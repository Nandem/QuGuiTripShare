/**
* @author Nandem on 2017-03-30.
*/
$().ready(function ()
{
    var $oSideBox = $("#sideBox");
    var $oSideBoxMask = $("#sideBoxMask");
    var $oSideBarToggle = $("#sideBarToggleBtn");

    var sideBarToggleFlag = false;
    $oSideBarToggle.click(function ()
    {
        if(!sideBarToggleFlag)
        {
            $oSideBarToggle.addClass("QuGuiRotate180");
            $oSideBoxMask.animate({opacity: 1}, 600, function ()
            {
                $oSideBox.animate({opacity: 1}, 2000)
            });
        }
        else
        {
            $oSideBarToggle.removeClass("QuGuiRotate180");
            $oSideBox.animate({opacity: 0}, 600, function ()
            {
                $oSideBoxMask.animate({opacity: 0}, 600)
            });
        }
        sideBarToggleFlag = !sideBarToggleFlag;
    });
});