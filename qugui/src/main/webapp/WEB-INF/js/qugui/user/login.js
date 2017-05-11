/**
* @author Nandem on 2017-02-03.
*/
$().ready(function()
{
    var $oLoginBtn = $("#loginBtn");
    var $oAccount = $("#account");
    var $oPassword = $("#password");

    var url = "/user/login";
    var data = {};


    $oLoginBtn.click(function ()
    {
        data = {account:$oAccount.val(), password: $oPassword.val()};
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success: function (value)
            {
                if(value.resultCode === true)
                {
                    post("/profile/me", {userID: value.result.id, password: value.result.password})
                }
                else
                {
                    layer.msg(value.result.messageContent);
                }
            },
            error: function ()
            {
                layer.msg("出错啦，不要着急，待会儿再来~");
            }
        });
    });
});