$().ready(function ()
{
    //        alert(1)
    var $somethingToBeHide = $("#somethingToBeHide");
    var $registerBtn = $("#registerBtn");
    var $validCode = $("#validCode");
    var $tip = $("#tip");
    var $inputs = $(".QuGuiTextInputLine");


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
                var msgWords = ["第","2","3","4","位","申","请","者","  ",
                    "2","0", "1", "7","年","2","月","5","日"," ","晴"];
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
    });
});