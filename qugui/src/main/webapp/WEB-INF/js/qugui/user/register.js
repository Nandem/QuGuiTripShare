$().ready(function ()
{
    var $somethingToBeHide = $("#somethingToBeHide");
    var $registerBtn = $("#registerBtn");
    var $tip = $("#tip");
    var $inputs = $(".QuGuiTextInputLine");

    var $validCode = $("#validCode");
    var $nickName = $("#nickName");
    var $password = $("#password");
    var $confirmPassword = $("#confirmPassword");
    var $idCardNo = $("#idCardNo");
    var $phoneNumber = $("#phoneNumber");
    var $email = $("#email");
    var $realName = $("#realName");
    var $meaningOfTrip = $("#meaningOfTrip");

    //实时监听确认密码框输入，以确定两次输入密码是否一致
    $confirmPassword.keyup(function ()
    {
        // alert("1")
        if($password.val() !== $(this).val())
        {
            if(!$(this).hasClass("QuGuiTextWarning"))
            {
                $(this).addClass("QuGuiTextWarning");
                $password.addClass("QuGuiTextWarning");
                layer.msg("两次密码输入不一致");
            }
        }
        else
        {
            if($(this).hasClass("QuGuiTextWarning"))
            {
                $(this).removeClass("QuGuiTextWarning");
                $password.removeClass("QuGuiTextWarning");
            }
        }
    });

    //申请按钮点击后进行一系列规则判断，同时做出相应特效处理
    $registerBtn.click(function ()
    {
        if($password.val() !== $confirmPassword.val())
        {
            layer.msg("两次输入密码不一致！");
            return;
        }

        if(!checkArgsNotNull($nickName, "“昵称”不能为空") ||
            !checkArgsNotNull($email, "“邮箱”不能为空") ||
            !checkArgsNotNull($password, "“密码”不能为空") ||
            !checkArgsNotNull($idCardNo, "“身份证号”不能为空") ||
            !checkArgsNotNull($realName, "“真实姓名”不能为空") ||
            !checkArgsNotNull($phoneNumber, "“手机号”不能为空") ||
            !checkArgsNotNull($meaningOfTrip, "“旅行的意义”不能为空"))
            return;

        if(checkArgsDuplicate($nickName, "“" + $nickName.val() + "”已被注册") ||
            checkArgsDuplicate($email, "“" + $email.val() + "”已被注册") ||
            checkArgsDuplicate($idCardNo, "“" + $idCardNo.val() + "”已被注册") ||
            checkArgsDuplicate($phoneNumber, "“" + $phoneNumber.val() + "”已被注册"))
            return;

        if($validCode.val() === "")
        {
            // alert("请输入验证码！");
            layer.msg("请输入邀请码！");
            return;
        }

        $.ajax({
            type: "POST",
            url: "/user/register",
            data: {inviteCode: $validCode.val(), nickName: $nickName.val(), realName: $realName.val(), email: $email.val(), phoneNumber: $phoneNumber.val(), idCardNo: $idCardNo.val(), meaningOfTrip: $meaningOfTrip.val(), password: $password.val()},
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success: function (value)
            {
                console.log(value);
                if(value.registerCode === 0)
                {
                    layer.msg("邀请码不存在或已被使用");
                }
                else if(value.registerCode === 1)
                {
                    var registerOrder = value.registerOrder;
                    var registerDate = value.registerDate;

                    var registerDateArr = registerDate.split("-");
                    registerDate = registerDateArr[0] + "年" + registerDateArr[1] + "月" + registerDateArr[2] + "日";

                    var msgWordStr = "第" + registerOrder + "位" +
                        "申请者 " + registerDate + " 晴";

                    $somethingToBeHide.animate({height: 0}, 800, function ()
                    {
                        $somethingToBeHide.hide();
                        $inputs.each(function ()
                        {
                            $(this).attr("readonly",true);
                            $(this).addClass("QuGuiTextInputLineCancelShadow");
                        });
                        $validCode.val(" ");
                        $tip.html("审核通过");
                        $tip.css({opacity:0, width: "100px", height:"100px", lineHeight: "100px", borderWidth: "2px"});
                        // $tip.hide();

                        $validCode.animate({border: 0}, 100, function ()
                        {
                            /*/
                             var msgWords = ["第","2","3","4","位","申","请","者","  ",
                             "2","0", "1", "7","年","2","月","5","日"," ","晴"];
                             //*/
                            var msgWords = msgWordStr.split("");
                            var msgs = "";
                            var msgWordsIndex = 0;
                            var delayId = setInterval(function ()
                            {
                                if(msgWordsIndex >= msgWords.length)
                                {
                                    $tip.css({opacity:1, width: "100px", height:"100px", lineHeight: "100px", borderWidth: "2px"});
                                    clearInterval(delayId);
                                }
                                else
                                {
                                    msgs += msgWords[msgWordsIndex];
                                    $validCode.val(msgs);
                                    msgWordsIndex++;
                                }
                            }, 500)
                        });

                        $validCode.attr("readonly",true);
                    });
                }
                else if(value.registerCode === 2)
                {
                    layer.msg(value.error);
                }
            },
            error: function ()
            {

            }
        });
    });

    function checkArgsNotNull($obj, tips)
    {
        if($obj.val() === "")
        {
            layer.msg(tips);
            return false;
        }
        return true;
    }

    function checkArgsDuplicate($account, tips)
    {
        var checkResult = false;
        $.ajax({
            type: "POST",
            url: "/user/validation/duplication",
            data: {account: $account.val()},
            dataType: "json",
            async: false,
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success: function (value)
            {
                if(value === true)
                {
                    layer.msg(tips);
                    checkResult = true;
                }
                else if(value === false)
                    checkResult = false;
            },
            error: function ()
            {
                layer.msg("检测用户账号异常！");
                return true;
            }
        });

        return checkResult;
    }
});