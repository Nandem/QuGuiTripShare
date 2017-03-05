$().ready(function ()
{
    //        alert(1)
    var $somethingToBeHide = $("#somethinToBeHide");
    var $registerBtn = $("#registerBtn");
    var $validCode = $("#validCode");


    //        alert($registerBtn)
    $registerBtn.click(function ()
    {
        if($validCode.val() == "")
        {
            // alert("请输入验证码！");
            layer.msg("请输入验证码！");
            return;
        }
        $somethingToBeHide.animate({height: 0}, 800, function ()
        {
            $somethingToBeHide.hide();
            $validCode.hide();
            $validCode.val("2017年2月5日 晴");
            $validCode.animate({border: 0}, 300, function ()
            {
                $validCode.show(500);
            });

            $validCode.attr("readonly",true);
        });
    });
});