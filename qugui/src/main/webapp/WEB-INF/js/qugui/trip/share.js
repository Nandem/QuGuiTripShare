/**
 * @Nandem by Nandem on 2017-03-30.
 */

function pageInit() {
    var $oSlideLeftBtn = $("#slideLeftBtn");
    var $oSlideRightBtn = $("#slideRightBtn");
    var $oFirstSlideNextBtn = $("#firstSlideNextBtn");

    $('#fullpage').fullpage(
        {
            //Navigation
            menu: '#myMenu',
            lockAnchors: true,
            anchors:['firstPage', 'secondPage'],
            navigation: false,
            navigationPosition: 'right',
            navigationTooltips: ['编辑', '确定', '提交'],
            showActiveTooltip: false,
            slidesNavigation: false,
            slidesNavPosition: 'bottom',

            //Scrolling
            css3: true,
            scrollingSpeed: 700,
            autoScrolling: true,
            fitToSection: true,
            fitToSectionDelay: 1000,
            // scrollBar: true,
            easing: 'easeInOutCubic',
            easingcss3: 'ease',
            loopBottom: false,
            loopTop: false,
            loopHorizontal: true,
            continuousVertical: false,
            continuousHorizontal: false,
            scrollHorizontally: false,
            interlockedSlides: false,
            dragAndMove: false,
            offsetSections: false,
            resetSliders: false,
            fadingEffect: false,
            normalScrollElements: '#element1, .element2',
            scrollOverflow: false,
            scrollOverflowReset: false,
            scrollOverflowOptions: null,
            touchSensitivity: 15,
            normalScrollElementTouchThreshold: 5,
            bigSectionsDestination: null,

            //Accessibility
            keyboardScrolling: true,
            animateAnchor: true,
            recordHistory: true,

            //Design
            controlArrows: false,
            verticalCentered: true,
            sectionsColor: ['#FFFFFF', '#FFFFFF', '#FFFFFF'],
            // paddingTop: '3em',
            // paddingBottom: '10px',
            fixedElements: '#header, .footer',
            responsiveWidth: 0,
            responsiveHeight: 0,
            responsiveSlides: false,
            parallax: false,
            parallaxOptions: {type: 'reveal', percentage: 62, property: 'translate'},

            //Custom selectors
            sectionSelector: '.section',
            slideSelector: '.slide',

            lazyLoading: true,

            //events
            onLeave: function(index, nextIndex, direction)
            {
                // layer.msg("direction:" + direction + " nextIndex:" + nextIndex);
            },
            afterLoad: function(anchorLink, index)
            {
                // layer.msg("anchorLink:" + anchorLink + " index:" + index);
            },
            afterRender: function()
            {
                //整个页面只会执行一次该回调方法
                // layer.msg("渲染完毕");
                $oSlideLeftBtn.hide();
                $oSlideRightBtn.hide();
            },
            afterResize: function()
            {

            },
            afterResponsive: function(isResponsive)
            {
            },
            afterSlideLoad: function(anchorLink, index, slideAnchor, slideIndex)
            {
            },
            onSlideLeave: function(anchorLink, index, slideIndex, direction, nextSlideIndex)
            {
                if(nextSlideIndex == 0)
                {
                    $oSlideLeftBtn.hide('slow');
                    $oSlideRightBtn.hide('slow');
                }
                else
                {
                    $oSlideLeftBtn.show('slow');
                    $oSlideRightBtn.show('slow');
                }
            }
        });

    $oSlideLeftBtn.click(function ()
    {
        $.fn.fullpage.moveSlideLeft();
    });

    $oSlideRightBtn.click(function ()
    {
        $.fn.fullpage.moveSlideRight();
    });

    $oFirstSlideNextBtn.click(function ()
    {
        $.fn.fullpage.moveSlideRight();
    });
}
function editInit()
{
    var $oDescribe1 = $("#describe1");
    var $oDescribe2 = $("#describe2");
    var $oDescribe3 = $("#describe3");
    var $oDescribe4 = $("#describe4");
    var $oDescribe5 = $("#describe5");
    var $oDescribe6 = $("#describe6");
    var $oPlaceName1 = $("#placeName1");
    var $oPlaceName2 = $("#placeName2");
    var $oPlaceName3 = $("#placeName3");
    var $oPlaceName4 = $("#placeName4");
    var $oPlaceName5 = $("#placeName5");
    var $oPlaceName6 = $("#placeName6");

    var $oPreviewPlaceName1 = $("#previewPlaceName1");
    var $oPreviewPlaceName2 = $("#previewPlaceName2");
    var $oPreviewPlaceName3 = $("#previewPlaceName3");
    var $oPreviewPlaceName4 = $("#previewPlaceName4");
    var $oPreviewPlaceName5 = $("#previewPlaceName5");
    var $oPreviewPlaceName6 = $("#previewPlaceName6");
    var $oPreviewDescribe1 = $("#previewDescribe1");
    var $oPreviewDescribe2 = $("#previewDescribe2");
    var $oPreviewDescribe3 = $("#previewDescribe3");
    var $oPreviewDescribe4 = $("#previewDescribe4");
    var $oPreviewDescribe5 = $("#previewDescribe5");
    var $oPreviewDescribe6 = $("#previewDescribe6");

    var $oShareBtn = $("#shareBtn");
    var $oCacheBtn = $("#cacheBtn");

    editSync($oPlaceName1, $oPreviewPlaceName1);
    editSync($oPlaceName2, $oPreviewPlaceName2);
    editSync($oPlaceName3, $oPreviewPlaceName3);
    editSync($oPlaceName4, $oPreviewPlaceName4);
    editSync($oPlaceName5, $oPreviewPlaceName5);
    editSync($oPlaceName6, $oPreviewPlaceName6);

    editSync($oDescribe1, $oPreviewDescribe1);
    editSync($oDescribe2, $oPreviewDescribe2);
    editSync($oDescribe3, $oPreviewDescribe3);
    editSync($oDescribe4, $oPreviewDescribe4);
    editSync($oDescribe5, $oPreviewDescribe5);
    editSync($oDescribe6, $oPreviewDescribe6);

    $oShareBtn.click(function ()
    {
        if(checkInputNull($oPlaceName1) ||
        checkInputNull($oPlaceName2) ||
        checkInputNull($oPlaceName3) ||
        checkInputNull($oPlaceName4) ||
        checkInputNull($oPlaceName5) ||
        checkInputNull($oPlaceName6) ||
        checkInputNull($oDescribe1) ||
        checkInputNull($oDescribe2) ||
        checkInputNull($oDescribe3) ||
        checkInputNull($oDescribe4) ||
        checkInputNull($oDescribe5) ||
        checkInputNull($oDescribe6))
        {
            return;
        }
        if(!checkCharAmount($oDescribe1, 50, "描述必须达到50字以上") ||
            !checkCharAmount($oDescribe2, 50, "描述必须达到50字以上") ||
            !checkCharAmount($oDescribe3, 50, "描述必须达到50字以上") ||
            !checkCharAmount($oDescribe4, 50, "描述必须达到50字以上") ||
            !checkCharAmount($oDescribe5, 50, "描述必须达到50字以上") ||
            !checkCharAmount($oDescribe6, 50, "描述必须达到50字以上"))
            return;
        var data =
            {
                token: $("#token").val(),
                id: $("#footprintID").val(),
                describe1: $oPlaceName1.val() + ":" + $oDescribe1.val(),
                describe2: $oPlaceName2.val() + ":" + $oDescribe2.val(),
                describe3: $oPlaceName3.val() + ":" + $oDescribe3.val(),
                describe4: $oPlaceName4.val() + ":" + $oDescribe4.val(),
                describe5: $oPlaceName5.val() + ":" + $oDescribe5.val(),
                describe6: $oPlaceName6.val() + ":" + $oDescribe6.val()
            };
        $.ajax({
            type: "POST",
            url: "/profile/share",
            data: data,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success: function (value)
            {
                if(value === true)
                {
                    layer.msg("分享成功");
                }
                else if(value === false)
                {
                    layer.msg("分享失败");
                }
            },
            error: function ()
            {
                layer.msg("出错啦，不要着急，待会儿再来~");
            }
        });
    });
    $oCacheBtn.click(function ()
    {
        var data =
            {
                token: $("#token").val(),
                id: $("#footprintID").val(),
                describe1: $oPlaceName1.val() + ":" + $oDescribe1.val(),
                describe2: $oPlaceName2.val() + ":" + $oDescribe2.val(),
                describe3: $oPlaceName3.val() + ":" + $oDescribe3.val(),
                describe4: $oPlaceName4.val() + ":" + $oDescribe4.val(),
                describe5: $oPlaceName5.val() + ":" + $oDescribe5.val(),
                describe6: $oPlaceName6.val() + ":" + $oDescribe6.val()
            };
        $.ajax({
            type: "POST",
            url: "/profile/cache",
            data: data,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success: function (value)
            {
                if(value === true)
                {
                    layer.msg("暂存成功");
                }
                else if(value === false)
                {
                    layer.msg("暂存失败");
                }
            },
            error: function ()
            {
                layer.msg("出错啦，不要着急，待会儿再来~");
            }
        });
    });

    function editSync($input, $span)
    {
        //textarea
        if(typeof($input.attr("value"))==="undefined")
        {
            if($input.val() !== ":")
            {
                $input.val($input.val().split(":")[1]);
                $span.text($input.val());
            }
            else
            {
                $span.text("请50字以上输入描述");
            }
        }
        //input
        else
        {
            if($input.val() !== ":")
            {
                $input.val($input.val().split(":")[0]);
                $span.text($input.val());
            }
            else
            {
                $span.text("（未填写）");
            }
        }
        $input.keyup(function ()
        {
            $span.text($input.val());
        });
    }

    function checkInputNull($obj) {
        if($obj.val() === "")
        {
            layer.msg("你有文字未填写");
            return true;
        }
        else
            return false;
    }

    function checkCharAmount($oInput, iMinNumber, tips)
    {
        if(inputLength($oInput.val()) < iMinNumber)
        {
            layer.msg(tips);
            return false;
        }
        else
            return true;
    }

    function inputLength(inputData)
    {
        var intLength=0;
        for (var i=0;i<inputData.length;i++)
        {
            if ((inputData.charCodeAt(i) < 0) || (inputData.charCodeAt(i) > 255))
                intLength=intLength+2;
            else
                intLength=intLength+1;
        }
        return intLength;
    }
}
$(document).ready(function()
{
    pageInit();
    editInit();
});