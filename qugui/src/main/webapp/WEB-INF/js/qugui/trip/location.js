/**
 * Created by Nandem on 2017-03-20.
 */
/**
 * @author Nandem on 2017-03-19.
 */

var screenWidth = window.screen.width;

$().ready(function () {
    var $navBtnZoomIn = $("#navBtnZoomIn");
    var $navBtnZoomOut = $("#navBtnZoomOut");
    var $leftBox = $("#leftBox");
    var $rightBox = $("#rightBox");
    var $info = $("#info");
    var $article = $("#article");
    var $articleContent = $("#articleContent");

    $(window).resize(function () {
        screenWidth = window.screen.width;
    });

    $navBtnZoomIn.click(function () {
        zoom($rightBox, $leftBox);
        $info.animate({opacity: 0}, 500, function () {
            $info.hide();
            $article.css({opacity: 1}, 300);
            $article.fadeIn(300);
            var temId = setInterval(function () {
                $articleContent.animate({opacity: 1}, 300);
                clearInterval(temId);
            }, 100);
        })
    });

    $navBtnZoomOut.click(function () {

        zoom($leftBox, $rightBox);
        $articleContent.animate({opacity: 0}, 200, function () {

            $article.animate({opacity: 0}, 500, function () {
                $article.hide();
                $info.css({opacity: 1});
                $info.fadeIn(300);
            })
        });
    })
});

function zoom($sthToBeZoomIn, $sthToBeZoomOut) {
    var temRightWidth = $sthToBeZoomOut.width();
    var temLeftWidth = $sthToBeZoomIn.width();
    $sthToBeZoomOut.animate({width: temLeftWidth - screenWidth * 0.005 + "px"}, 800);
    $sthToBeZoomIn.animate({width: temRightWidth + screenWidth * 0.005 + "px"}, 800);
}
