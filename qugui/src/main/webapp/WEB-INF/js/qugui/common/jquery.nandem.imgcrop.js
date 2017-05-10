/**
 * 这是一个图片裁剪插件
 * @author Nandem on 17-4-14.
 */
(function($)
{
    /**
     * 初始化裁剪图层
     * @param options 裁剪图层canvas对象
     */
    $.fn.initCropper = function(options)
    {
        /*^_^*------------------------一些初始化工作----------------------------*^_^*/
        options = $.extend(
            {
                $originCanvas: null,
                $cropCanvas: null,
                $confirmBtn: null,
                $imgCarrier: null,
                $imgValue: null,
                $imgChosenInput: null,
                canvasWidth: 0,
                canvasHeight: 0,
                fnConfirmCallBack: null
            }
            , options);

        //根据配置设置画布大小
        options.$originCanvas.attr("width", options.canvasWidth);
        options.$originCanvas.attr("height", options.canvasHeight);
        options.$cropCanvas.attr("width", options.canvasWidth);
        options.$cropCanvas.attr("height", options.canvasHeight);

        //从jq对象初始化画布
        var originCanvas = options.$originCanvas[0].getContext("2d");
        var cropCanvas = options.$cropCanvas[0].getContext("2d");
        options.$originCanvas.css({zIndex: 2334});
        options.$cropCanvas.css({zIndex: 2335});
        //初始化预览图片
        var originImg = new Image();
        var firstAdjustFlag = true;//首次调整大小标识，目的是防止出现未选择图片即可调整大小的bug
        var cropWidth = options.canvasWidth * 0.4;
        var cropHeight = options.canvasWidth * 0.4;
        var originImgIncreaseFactor = 10;//每次调整的增长因子
        var originImgMinWidth = cropWidth / 4;
        var originImgMinHeight = cropHeight / 4;
        var originImgWidth2HeightRatio;//原始图片宽高比
        /*^_^*-------------------------初始化结束-----------------------------*^_^*/

        //////////////////////////////////////////////////////////////////////////

        /*^_^*------------------------逻辑主体开始----------------------------*^_^*/
        //初始化界面提示
        drawTips();
        //添加鼠标滚轮监听，以实现滚轮调整图片大小
        options.$cropCanvas.hover(bindAdjustSize, unBindAdjustSize);
        //监听图片文件选择改变事件
        options.$imgChosenInput.change(fileChange);
        //监听确定按钮事件
        options.$confirmBtn.click(confirmPic);
        /*^_^*------------------------逻辑主体结束----------------------------*^_^*/

        //////////////////////////////////////////////////////////////////////////

        /*^_^*-----------------------**各个功能函数**--------------------------*^_^*/
        function drawTips()
        {
            clearCanvas();
            saveCanvasState();

            var tipsStr = "请选择一张图片";
            var singleStrSize = 50;
            var cw = options.canvasWidth;
            var ch = options.canvasHeight;
            originCanvas.fillStyle = "#cccccc";
            originCanvas.font=singleStrSize + "px Arial";
            originCanvas.textBaseline = "middle";
            originCanvas.textAlign = "center";
            originCanvas.fillText(tipsStr, cw / 2, ch / 2);
            // cropCanvas.rect((cw - singleStrSize * tipsStr.length) / 2, (ch - singleStrSize) / 2, singleStrSize * tipsStr.length, singleStrSize);
            cropCanvas.stroke();

            restoreCanvasState();
        }

        /**
         * 绘制原始图层，指的是待裁剪图片
         */
        function drawOriginLayer()
        {
            saveCanvasState();
            originImg = new Image();
            originImg.src = getPath(options.$imgChosenInput[0].files[0]);

            originImg.onload = function ()
            {
                originImgWidth2HeightRatio = originImg.width / originImg.height;
                calculateAndDraw();
            };
            restoreCanvasState();
        }

        /**
         * 绘制裁剪图层，指的是裁剪的遮罩
         */
        function drawCropLayer()
        {
            saveCanvasState();
            var cw = options.canvasWidth;
            var ch = options.canvasHeight;
            //绘制遮罩
            cropCanvas.globalAlpha = 0.6;
            cropCanvas.fillStyle="#000000";
            cropCanvas.fillRect(0, 0, cw, ch);

            //绘制裁剪框
            cropCanvas.clearRect((cw - cropWidth) / 2, (ch - cropHeight) / 2, cropWidth, cropHeight);
            restoreCanvasState();
        }

        /**
         * 文件选择变化时调用
         */
        function fileChange()
        {
            firstAdjustFlag = false;
            clearCanvas();
            //绘制原始图层
            drawOriginLayer();
            //绘制裁剪图层
            drawCropLayer();
        }

        /**
         * 确定所选图片尺寸并进行裁剪
         */
        function confirmPic()
        {
            if(firstAdjustFlag)
            {
                layer.msg("请选择一张图片！");
                return;
            }
            options.fnConfirmCallBack();
            var cw = options.canvasWidth;
            var ch = options.canvasHeight;
            var temImageData = originCanvas.getImageData((cw - cropWidth) / 2, (ch - cropHeight) / 2, cropWidth, cropHeight);
            clearOriginCanvas();
            options.$originCanvas.attr("width", options.canvasWidth * 0.4);
            options.$originCanvas.attr("height", options.canvasWidth * 0.4);
            originCanvas.putImageData(temImageData, 0, 0);
            options.$imgCarrier[0].src = options.$originCanvas[0].toDataURL();
            if(options.$imgValue !== null)
                options.$imgValue.val(options.$imgCarrier[0].src);
            options.$originCanvas.attr("width", options.canvasWidth);
            options.$originCanvas.attr("height", options.canvasHeight);
            originImg = new Image();
            firstAdjustFlag = true;
            options.$imgChosenInput.val("");
            drawTips();
        }

        /**
         * 绑定图片尺寸调整函数
         */
        function bindAdjustSize()
        {
            EventUtil.addHandler(document,'mousewheel',onWheel);
            EventUtil.addHandler(document,'DOMMouseScroll',onWheel);
        }

        /**
         * 解除图片调整函数绑定
         */
        function unBindAdjustSize()
        {
            EventUtil.removeHandler(document,'mousewheel',onWheel);
            EventUtil.removeHandler(document,'DOMMouseScroll',onWheel);
        }

        /**
         * 保存canvas状态，防止操作过后全文状态污染
         */
        function saveCanvasState()
        {
            originCanvas.save();
            cropCanvas.save();
        }

        /**
         * 取回之前保存的canvas状态
         */
        function restoreCanvasState()
        {
            originCanvas.restore();
            cropCanvas.restore();
        }

        /**
         * 慎用
         * 清空canvas，即清除canvas上绘制的所有内容
         */
        function clearCanvas()
        {
            clearOriginCanvas();
            clearCropCanvas();
        }
        function clearOriginCanvas()
        {
            originCanvas.clearRect(0, 0, options.canvasWidth, options.canvasHeight);
        }
        function clearCropCanvas()
        {
            cropCanvas.clearRect(0, 0, options.canvasWidth, options.canvasHeight);
        }

        /**
         * 获取文件路径，以便实现本地绘制、调整和裁剪的工作
         * @param file 文件对象
         * @returns {*}
         */
        function getPath(file)
        {
            var URL = (window.webkitURL || window.URL);
            return URL.createObjectURL(file);
        }

        /**
         * 计算和绘制图片
         * 计算的目的是确保图片按照canvas合适的尺寸绘制，而不是出现一些过大或者过小的情况
         */
        function calculateAndDraw()
        {
            autoResizeImage(options.canvasWidth, options.canvasHeight, originImg);
            originCanvas.drawImage(originImg, (options.canvasWidth - originImg.width) / 2, (options.canvasHeight - originImg.height) / 2, originImg.width, originImg.height);
        }
        function calculateAndDrawWithWidthAndHeight(width, height)
        {
            autoResizeImage(width, height, originImg);
            originCanvas.drawImage(originImg, (options.canvasWidth - originImg.width) / 2, (options.canvasHeight - originImg.height) / 2, originImg.width, originImg.height);
        }

        function max()
        {
            var m = Number.NEGATIVE_INFINITY;
            for (var i = 0; i  < arguments.length; i++)
            {
                if (arguments[i] > m) m = arguments[i];
            }

            return m;
        }
        function min()
        {
            var m = Number.POSITIVE_INFINITY;
            for (var i = 0; i  < arguments.length; i++)
            {
                if (arguments[i] < m) m = arguments[i];
            }

            return m;
        }

        function repaint(increaseFactor)
        {
            clearOriginCanvas();
            var temWidth = originImg.width + increaseFactor;
            var temHeight = originImg.height + increaseFactor / originImgWidth2HeightRatio;
            if(temHeight > options.canvasHeight)
            {

                originImg.width = options.canvasHeight * originImgWidth2HeightRatio;
                originImg.height = options.canvasHeight;
            }
            else if(temHeight < originImgMinHeight)
            {
                originImg.width = originImgMinHeight * originImgWidth2HeightRatio;
                originImg.height = originImgMinHeight;
            }
            else
            {
                originImg.width = temWidth;
                originImg.height = temHeight;
            }
            calculateAndDraw();
        }

        //鼠标滚轮事件
        function onWheel(event)
        {
            if(firstAdjustFlag) return;
            event = EventUtil.getEvent(event);
            var delta = EventUtil.getWheelDelta(event);

            if (delta > 0)
            {
                console.log("wheelup");
                repaint(originImgIncreaseFactor);
                // calculateAndDrawWithWidthAndHeight(100, 100);
            }
            else
            {
                console.log("wheeldown");
                repaint(-originImgIncreaseFactor);
                // calculateAndDrawWithWidthAndHeight(500, 500);
            }
            EventUtil.preventDefault(event);
        }

        /**
         *
         * @param maxWidth
         * @param maxHeight
         * @param objImg
         */
        function autoResizeImage(maxWidth,maxHeight,objImg)
        {
            var hRatio;
            var wRatio;
            var Ratio = 1;
            var w = objImg.width;
            var h = objImg.height;
            wRatio = maxWidth / w;
            hRatio = maxHeight / h;
            if (maxWidth === 0 && maxHeight === 0)
            {
                Ratio = 1;
            }
            else if (maxWidth === 0)
            {
                if (hRatio<1) Ratio = hRatio;
            }
            else if (maxHeight === 0)
            {
                if (wRatio<1) Ratio = wRatio;
            }
            else if (wRatio<1 || hRatio<1)
            {
                Ratio = (wRatio<=hRatio?wRatio:hRatio);
            }
            if (Ratio<1)
            {
                w = w * Ratio;
                h = h * Ratio;
            }
            objImg.height = h;
            objImg.width = w;
        }

        /**
         * 事件处理工具类
         * @type {
         *          {
         *              addHandler: addHandler,
         *              removeHandler: removeHandler,
         *              getEvent: getEvent,
         *              getTarget: getTarget,
         *              getWheelDelta: getWheelDelta,
         *              preventDefault: preventDefault
         *          }
         *       }
         */
        var EventUtil =
            {
                addHandler: function(element, type, handler)
                {
                    if (element.addEventListener)
                    {
                        element.addEventListener(type, handler, false);
                    }
                    else if (element.attachEvent)
                    {
                        element.attachEvent("on" + type, handler);
                    }
                    else
                    {
                        element["on" + type] = handler;
                    }
                },

                removeHandler: function(element, type, handler)
                {
                    if (element.removeEventListener)
                    {
                        element.removeEventListener(type, handler, false);
                    }
                    else if (element.detachEvent)
                    {
                        element.detachEvent("on" + type, handler);
                    }
                    else
                    {
                        element["on" + type] = null;
                    }
                },

                getEvent: function(event)
                {
                    return event ? event : window.event;
                },

                getTarget: function(event)
                {
                    return event.target || event.srcElement;
                },

                getWheelDelta: function(event)
                {
                    if (event.wheelDelta)
                    {
                        return event.wheelDelta;
                    }
                    else
                    {
                        return -event.detail * 40;
                    }
                },

                preventDefault: function(event)
                {
                    if (event.preventDefault)
                    {
                        event.preventDefault();
                    }
                    else
                    {
                        event.returnValue = false;
                    }
                }

            };
    };

})(jQuery);