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
        showBox($oIntroductionBox);
    });
    $oFolkCustomBtn.click(function ()
    {
        showBox($oFolkCustomBox);
    });
    $oCharacteristicBtn.click(function ()
    {
        showBox($oCharacteristicBox);
    });
    $oViewpointBtn.click(function ()
    {
        showBox($oViewpointBox);
    });

    function showBox($objToBeShow)
    {
        $oIntroductionBox.addClass("QuGuiHide");
        $oFolkCustomBox.addClass("QuGuiHide");
        $oCharacteristicBox.addClass("QuGuiHide");
        $oViewpointBox.addClass("QuGuiHide");

        $objToBeShow.removeClass("QuGuiHide");
    }
});