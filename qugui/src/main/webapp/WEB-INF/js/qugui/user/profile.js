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


    var $oNickName = $("#nickName");
    var nickNameInput = $oNickName.val();
    var $oMeaningOfTrip = $("#meaningOfTrip");
    var meaningOfTripInput = $oMeaningOfTrip.val();
    var $oEmail = $("#email");
    var emailInput = $oEmail.val();
    var $oPhoneNumber = $("#phoneNumber");
    var phoneNumberInput = $oPhoneNumber.val();
    var $oIdCardNo = $("#idCardNo");
    var idCardNoInput = $oIdCardNo.val();
    var $oRealName = $("#realName");
    var realNameInput = $oRealName.val();

    var $oInfoModifySubmit = $("#infoModifySubmit");

    $oInfoModifySubmit.click(function ()
    {
        if(!checkModified(nickNameInput, $oNickName.val()) &&
            !checkModified(meaningOfTripInput, $oMeaningOfTrip.val()) &&
            !checkModified(emailInput, $oEmail.val()) &&
            !checkModified(phoneNumberInput, $oPhoneNumber.val()) &&
            !checkModified(idCardNoInput, $oIdCardNo.val()) &&
            !checkModified(realNameInput, $oRealName.val()))
        {
            layer.msg("数据未修改，无需提交");
            return;
        }
        else
        {
            $.ajax({
                type: "POST",
                url: "/profile/updatePersonalInfo",
                data:
                    {
                        token: $("#token").val(),
                        id: $("#userID").val(),
                        nickName: $oNickName.val().split("：")[1],
                        realName: $oRealName.val().split("：")[1],
                        email: $oEmail.val().split("：")[1],
                        phoneNumber: $oPhoneNumber.val().split("：")[1],
                        idCardNo: $oIdCardNo.val().split("：")[1],
                        meaningOfTrip: $oMeaningOfTrip.val().split("：")[1]
                    },
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (value)
                {
                    if(value === false)
                    {
                        layer.msg("修改失败");
                    }
                    else if(value === true)
                    {
                        layer.msg("修改成功");

                        nickNameInput = $oNickName.val();
                        meaningOfTripInput = $oMeaningOfTrip.val();
                        emailInput = $oEmail.val();
                        phoneNumberInput = $oPhoneNumber.val();
                        idCardNoInput = $oIdCardNo.val();
                        realNameInput = $oRealName.val();

                        modifyBtnFlag = !modifyBtnFlag;
                        QuGui.Profile.$modifyBtn.text("修改");
                        QuGui.Profile.$infoInput.attr("readonly",true);
                        QuGui.Profile.$infoInput.each(function()
                        {
                            $(this).addClass("QuGuiTextInputLineCancelShadow QuGuiTextColorGray");
                            $(this).unbind();
                        });
                    }
                },
                error: function ()
                {

                }
            });
        }
    });

    /**
     * 检查数据有没有被修改过
     * @param oldValue 旧值
     * @param newValue 新值
     * @returns {boolean} true：修改过，false：未修改过
     */
    function checkModified(oldValue, newValue)
    {
        return oldValue !== newValue;
    }
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
        format: 'Y/m/d',
        maxYear: '2099'
    });
    $("#backDate").dateDropper({
        animate: false,
        format: 'Y/m/d',
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


function intiImgCrop()
{
    var $oHeadIconModal = $("#headIconModal");

    var $oOriginCanvas = $("#origin");
    var $oCropCanvas = $("#crop");
    var $oConfirmBtn = $("#confirm");
    var $oHeadIcon = $("#headIcon");
    var $oImgChosenInput = $("#imgChosenInput");

    $oHeadIconModal.initModal("选择头像")
        .size(600, 500);

    //*/
    $.fn.initCropper(
    {
        $originCanvas: $oOriginCanvas,
        $cropCanvas: $oCropCanvas,
        $confirmBtn: $oConfirmBtn,
        $imgCarrier: $oHeadIcon,
        $imgChosenInput: $oImgChosenInput,
        canvasWidth: 600,
        canvasHeight: 500*0.7,
        fnConfirmCallBack: function ()
        {
            $oHeadIconModal.fadeOut();
            $(".MaskLayer").fadeOut();


            setTimeout(function ()
            {
                $.ajax({
                    type: "POST",
                    url: "/profile/updateHeadIcon",
                    data: {token: $("#token").val(), userID: $("#userID").val(), headIconStr: $oHeadIcon[0].src},
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                    success: function (value)
                    {
                        if(value === false)
                        {
                            layer.msg("头像上传失败");
                        }
                        else if(value === true)
                        {
                            layer.msg("头像上传成功");
                        }
                    },
                    error: function ()
                    {

                    }
                });
            }, 1000)
        }
    });
    //*/
}

function initCreateScheduling()
{
    var $oCreateSchedulingConfirmBtn = $("#createSchedulingConfirmBtn");
    // var $oCreateSchedulingFrom = $("#createSchedulingFrom");
    var $oCreateSchedulingTo = $("#createSchedulingTo");
    var $oCreateSchedulingStartTime = $("#goDate");
    var $oCreateSchedulingEndTime = $("#backDate");
    var $oCreateSchedulingTemp = $("#createSchedulingTemp");
    var $oCreateSchedulingWeatherTxt = $("#createSchedulingWeatherTxt");

    $oCreateSchedulingTo.change(function ()
    {
        $.ajax({
            type: "POST",
            url: "/profile/scenicSpotWeather",
            data: {scenicSpot: $oCreateSchedulingTo.val()},
            dataType: "json",
            scriptCharset: 'utf-8',
            success: function (value)
            {
                console.log(value);
                $oCreateSchedulingTemp.text(value.weather.liveT + "℃");
                $oCreateSchedulingWeatherTxt.text(value.weather.weatherTxt);
            },
            error: function ()
            {

            }
        });
    });

    $oCreateSchedulingConfirmBtn.click(function ()
    {
        /*/
        if($oCreateSchedulingFrom.val() === "")
        {
            layer.msg("请输入");
            return;
        }
        //*/
        if(checkArgsNull($oCreateSchedulingTo, "请输入目的地（去往何处）") ||
        checkArgsNull($oCreateSchedulingStartTime, "请输入开始时间（去时）") ||
        checkArgsNull($oCreateSchedulingEndTime, "请输入预计结束时间（归期）"))
        {
            return;
        }
        layer.msg("创建行程");
    });

    /**
     * 检查参数是否为空
     * @param $arg 包含参数的jq对象
     * @param tips 参数为空时的提示
     * @returns {boolean} true：参数为空，false：参数不为空。
     */
    function checkArgsNull($arg, tips)
    {
        if($arg.val() === "")
        {
            layer.msg(tips);
            return true;
        }
        else
            return false;
    }
}
/*^_^*------入口*^_^*/
$().ready(function ()
{
    initVariable();
    initTabClickEvent();
    initPersonalInfo();

    initSomePlugs();

    initFlip();

    intiImgCrop();

    initCreateScheduling();
});
