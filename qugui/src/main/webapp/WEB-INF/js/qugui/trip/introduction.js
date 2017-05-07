/**
 * Created by Nandem on 2017-05-07.
 */
$().ready(function ()
{
    var $oIntroductionBtn = $("#introductionBtn");
    var $oFolkCustomBtn = $("#folkCustomBtn");
    var $oCharacteristicBtn = $("#characteristicBtn");
    var $oViewpointBtn = $("#viewpointBtn");

    var $oIntroductionBox = $("#introductionBox");
    var $oFolkCustomBox = $("#folkCustomBox");
    var $oCharacteristicBox = $("#characteristicBox");
    var $oViewpointBox = $("#viewpointBox");

    $oIntroductionBtn.click(function ()
    {
        highlightBtn($(this));
        showBox($oIntroductionBox);
    });
    $oFolkCustomBtn.click(function ()
    {
        highlightBtn($(this));
        showBox($oFolkCustomBox);
    });
    $oCharacteristicBtn.click(function ()
    {
        highlightBtn($(this));
        showBox($oCharacteristicBox);
    });
    $oViewpointBtn.click(function ()
    {
        highlightBtn($(this));
        showBox($oViewpointBox);
    });

    function highlightBtn($btnToBeHightlight)
    {
        $oIntroductionBtn.removeClass("QuGuiTextChinaRed");
        $oFolkCustomBtn.removeClass("QuGuiTextChinaRed");
        $oCharacteristicBtn.removeClass("QuGuiTextChinaRed");
        $oViewpointBtn.removeClass("QuGuiTextChinaRed");

        $btnToBeHightlight.addClass("QuGuiTextChinaRed");
    }

    function showBox($objToBeShow)
    {
        $oIntroductionBox.addClass("QuGuiHide");
        $oFolkCustomBox.addClass("QuGuiHide");
        $oCharacteristicBox.addClass("QuGuiHide");
        $oViewpointBox.addClass("QuGuiHide");

        $objToBeShow.removeClass("QuGuiHide");
    }
});