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
            $oSideBoxMask.animate({opacity: 1}, 600, function ()
            {
                $oSideBox.animate({opacity: 1}, 2000)
            });
        }
        else
        {
            $oSideBox.animate({opacity: 0}, 600, function ()
            {
                $oSideBoxMask.animate({opacity: 0}, 600)
            });
        }
        sideBarToggleFlag = !sideBarToggleFlag;
    });
});