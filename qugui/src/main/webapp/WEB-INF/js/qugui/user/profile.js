/**
 * @author Nandem on 2017-03-19.
 */

var QuGui = {};
QuGui.Profile = {};

/*^_^*------初始化变量*^_^*/
function initVariable()
{
    QuGui.Profile.$recommendTab = $("#recommendTab");
    QuGui.Profile.$tripTab = $("#tripTab");
    QuGui.Profile.$schedulingTab = $("#schedulingTab");
    QuGui.Profile.$createTab = $("#createTab");
    QuGui.Profile.$friendsTab = $("#friendsTab");
    QuGui.Profile.$shareTab = $("#shareTab");
    QuGui.Profile.$personalInfoTab = $("#personalInfoTab");

    QuGui.Profile.$recommendBox = $("#recommendBox");
    QuGui.Profile.$tripBox = $("#tripBox");
    QuGui.Profile.$schedulingBox = $("#schedulingBox");
    QuGui.Profile.$createBox = $("#createBox");
    QuGui.Profile.$friendsBox = $("#friendsBox");
    QuGui.Profile.$personalInfoBox = $("#personalInfoBox");

    //
    QuGui.Profile.$boxTitle = $("#boxTitle");
    QuGui.Profile.$boxTitleBox = $("#boxTitleBox");

    //personalInfo
    QuGui.Profile.$infoInput = $("#personalInfoBox input");
    QuGui.Profile.$modifyBtn = $("#modifyBtn");
}

/*^_^*------个人中心相关事件*^_^*/
function initPersonalInfo()
{
    QuGui.Profile.$infoInput.each(function()
    {
        $(this).addClass("QuGuiTextInputLineCancelShadow");
    });

    var modifyBtnFlag = false;

    QuGui.Profile.$modifyBtn.click(function ()
    {
        if(!modifyBtnFlag)
        {
            QuGui.Profile.$modifyBtn.text("取消");
            QuGui.Profile.$infoInput.attr("readonly",false);
            QuGui.Profile.$infoInput.each(function()
            {
                var valuePrefix = $(this).val().split("：")[0];
                $(this).removeClass("QuGuiTextInputLineCancelShadow QuGuiTextColorGray");
                $(this).focus(function ()
                {
                    $(this).val($(this).val().split("：")[1]);
                });
                $(this).blur(function ()
                {
                    $(this).val(valuePrefix + "：" + $(this).val());
                });
            });
        }
        else
        {
            QuGui.Profile.$modifyBtn.text("修改");
            QuGui.Profile.$infoInput.attr("readonly",true);
            QuGui.Profile.$infoInput.each(function()
            {
                $(this).addClass("QuGuiTextInputLineCancelShadow QuGuiTextColorGray");
                $(this).unbind();
            });
        }

        modifyBtnFlag = !modifyBtnFlag;
    });
}

/*^_^*------tab点击事件*^_^*/
function initTabClickEvent()
{
    QuGui.Profile.$recommendTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$recommendTab))
            return;
        changeTitle(QuGui.Profile.$recommendTab);
        highLightTab(QuGui.Profile.$recommendTab);
        showBox(QuGui.Profile.$recommendBox);
    });
    QuGui.Profile.$tripTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$tripTab))
            return;
        changeTitle(QuGui.Profile.$tripTab);
        highLightTab(QuGui.Profile.$tripTab);
        showBox(QuGui.Profile.$tripBox);
    });
    QuGui.Profile.$schedulingTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$schedulingTab))
            return;
        changeTitle(QuGui.Profile.$schedulingTab);
        highLightTab(QuGui.Profile.$schedulingTab);
        showBox(QuGui.Profile.$schedulingBox);
    });
    QuGui.Profile.$createTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$createTab))
            return;
        changeTitle(QuGui.Profile.$createTab);
        highLightTab(QuGui.Profile.$createTab);
        showBox(QuGui.Profile.$createBox);
    });
    QuGui.Profile.$friendsTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$friendsTab))
            return;
        changeTitle(QuGui.Profile.$friendsTab);
        highLightTab(QuGui.Profile.$friendsTab);
        showBox(QuGui.Profile.$friendsBox);
    });
    QuGui.Profile.$shareTab.click(function ()
    {
        // window.location.href = ""
    });
    QuGui.Profile.$personalInfoTab.click(function ()
    {
        if(checkIsHighlight(QuGui.Profile.$personalInfoTab))
            return;
        changeTitle(QuGui.Profile.$personalInfoTab);
        showBox(QuGui.Profile.$personalInfoBox);
        highLightTab(QuGui.Profile.$personalInfoTab);
    });
}
function highLightTab($tabToBeHighLight)
{
    QuGui.Profile.$recommendTab.removeClass("btnHighlight");
    QuGui.Profile.$tripTab.removeClass("btnHighlight");
    QuGui.Profile.$schedulingTab.removeClass("btnHighlight");
    QuGui.Profile.$createTab.removeClass("btnHighlight");
    QuGui.Profile.$friendsTab.removeClass("btnHighlight");
    QuGui.Profile.$personalInfoTab.removeClass("btnHighlight");

    $tabToBeHighLight.addClass("btnHighlight");
}
function showBox($boxToBeShow)
{
    QuGui.Profile.$recommendBox.addClass("QuGuiHide");
    QuGui.Profile.$recommendBox.css({opacity:0});
    QuGui.Profile.$tripBox.addClass("QuGuiHide");
    QuGui.Profile.$tripBox.css({opacity:0});
    QuGui.Profile.$schedulingBox.addClass("QuGuiHide");
    QuGui.Profile.$schedulingBox.css({opacity:0});
    QuGui.Profile.$createBox.addClass("QuGuiHide");
    QuGui.Profile.$createBox.css({opacity:0});
    QuGui.Profile.$friendsBox.addClass("QuGuiHide");
    QuGui.Profile.$friendsBox.css({opacity:0});
    QuGui.Profile.$personalInfoBox.addClass("QuGuiHide");
    QuGui.Profile.$personalInfoBox.css({opacity:0});

    $boxToBeShow.removeClass("QuGuiHide");
    $boxToBeShow.animate({opacity:1}, 300);
}
function checkIsHighlight(objToBeChecked)
{
    return !!objToBeChecked.hasClass("btnHighlight");
}
function changeTitle($objToBeChangeTitle)
{
    var id = "#"+ $objToBeChangeTitle[0].id + "Hidden";
    id = id.replace("Tab", "Box");
    if(id == "#personalInfoBoxHidden")
    {
        QuGui.Profile.$boxTitleBox.hide();
        return;
    }
    else
    {
        QuGui.Profile.$boxTitleBox.show();
    }

    QuGui.Profile.$boxTitle.animate({opacity:0}, 0, function ()
    {
        QuGui.Profile.$boxTitle.text($(id).val());
        QuGui.Profile.$boxTitle.animate({opacity:1}, 300);
    });
}

function initSomePlugs()
{
    $("#goDate").dateDropper({
        animate: false,
        format: 'Y-m-d',
        maxYear: '2099'
    });
    $("#backDate").dateDropper({
        animate: false,
        format: 'Y-m-d',
        maxYear: '2099'
    });
}
function initFlip() {
    var $oViewMore = $("#viewMore");
    var $oBackBtn = $("#backBtn");
    var $oFlipToggle = $("#flipToggle");

    $oViewMore.click(function ()
    {
        $oFlipToggle.addClass("flipStart");
    });
    $oBackBtn.click(function ()
    {
        $oFlipToggle.removeClass("flipStart");
    });
}
/*^_^*------入口*^_^*/
$().ready(function ()
{
    initVariable();
    initTabClickEvent();
    initPersonalInfo();

    initSomePlugs();

    initFlip();
});
