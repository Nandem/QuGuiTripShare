/**
 * Created by Nandem on 2017-05-03.
 */
$().ready(function ()
{
    //*/
    $("#searchBtn").click(function ()
    {
        var $oSearchInput = $("#searchInput");
        if($oSearchInput.val() === "")
        {
            layer.msg("请输入旅行地点");
            return;
        }
        post("/search/searchPlace?key="+$oSearchInput.val())
    });
    //*/
});
var likedArray = [];
function like($carrier, footprintID)
{
    if(likedArray.contains(footprintID))
    {
        layer.msg("您已赞过该足迹");
        stopEventBbubble();
        return;
    }
    // layer.msg("like:" + $carrier.text());
    var likeAmount = parseInt($carrier.children("span").text());
    likeAmount = likeAmount + 1;
    $.ajax({
        type: "POST",
        url: "/search/like",
        data: {footprintID: footprintID},
        dataType: "json",
        scriptCharset: 'utf-8',
        success: function (value)
        {
            if(value === true)
            {
                layer.msg("点赞成功");
                $carrier.children("span").text(likeAmount);
                $carrier.addClass("QuGuiTextChinaRed");
                likedArray.push(footprintID);
            }
            else if(value === false)
            {
                layer.msg("网络异常");
            }
        },
        error: function ()
        {

        }
    });
    stopEventBbubble();
}

function stopEventBbubble() {
    var e = window.event;
    if (window.event) {
        e.cancelBubble=true;     // ie下阻止冒泡
    } else {
        //e.preventDefault();
        e.stopPropagation();     // 其它浏览器下阻止冒泡
    }
}

Array.prototype.contains = function ( needle ) {
    for (var i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}