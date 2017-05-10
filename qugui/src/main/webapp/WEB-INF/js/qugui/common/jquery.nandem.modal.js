/**
 * 这是一个简单的模态插件
 * 使用时需要指定模态窗口标题，否则你试试就知道后果了
 * @author Nandem on 17-4-14.
 */
(function($)
{
    $.fn.extend(
        {
            /**
             * 初始化模态框
             * @param title 模态框标题
             */
            "initModal":function(title)
            {
                var $oModal;
                var $oMaskLayer;

                var $oModalTitleBar;
                var $oModalTitle;
                var $oModalClose;

                $(this).addClass("Modal");

                $oModal = $(this);
                $oMaskLayer = $("<div class='MaskLayer'></div>");

                $oModalTitleBar = $("<div class='ModalTitleBar'></div>");
                $oModalTitle = $("<div style='font-family: FangzhengSongkeJianti; color: gray' class='title QuGuiTextColorGray'></div>");
                $oModalClose = $("<div style='font-family: FangzhengSongkeJianti; color: white' class='close'>X</div>");

                $oModalTitle.appendTo($oModalTitleBar);
                $oModalClose.appendTo($oModalTitleBar);
                $oModalTitleBar.prependTo($oModal);
                $oModal.appendTo("body");
                $oMaskLayer.appendTo("body");


                if(!title)
                    $oModalTitle.text("请初始化模态框标题");
                else
                    $oModalTitle.text(title);

                $($(this).attr("toggle")).click(function ()
                {
                    $oModal.fadeIn();
                    $oMaskLayer.fadeIn();
                    $oMaskLayer.click(function()
                    {
                        $oModal.fadeOut();
                        $oMaskLayer.fadeOut();
                    });
                });

                $oModalClose.click(function ()
                {
                    $oModal.fadeOut();
                    $oMaskLayer.fadeOut();
                });
                // $(this).css({width:100,height:100});

                return $(this);

            },
            size:function (width, height)
            {
                $(this).css({width:width,height:height, marginLeft:-width/2, marginTop:-height/2});

                return $(this);
            }
        });
})(jQuery);