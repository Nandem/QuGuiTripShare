<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../css/libs/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/libs/cropper/cropper.min.css">
    <link href="../../css/qugui/quguiStyle.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../js/libs/html5shiv.min.js"></script>
    <script src="../../js/libs/respond.min.js"></script>
    <!--<![endif]&ndash;&gt;-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/libs/jq/jquery-3.1.1.min.js"></script>
    <script src="../../js/jquery.leoweather.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/libs/bootstrap/bootstrap.min.js"></script>
    <script src="../../js/libs/layer/layer.js"></script>
    <script src="../../js/libs/cropper/cropper.min.js"></script>
    <link href="../../css/qugui/user/profile.css" rel="stylesheet">

    <title>个人中心</title>
</head>
<body>
<div class="QuGuiFullScreenContainer boxContainer">
    <div class="QuGuiBoxAlignColumnCenterFlex QuGuiBox60And100pc">
        <div class="leftContentBox QuGuiBoxAlignColumnCenterFlex">
            <div class="QuGuiBoxAlignColumnCenterFlex" style="width: 100%; height: 30%;">
                <img class="QuGuiPointerCursor QuiGuiHoverShadowChinaRed" src="../../imgs/logo.png" id="headIcon">
                <!--<input type="image" />-->
            </div>
            <div class="QuGuiBoxAlignColumnCenterFlex" style="width: 100%; height: 10%;">
                <div class="profileNav QuGuiBoxAlignRowCenterFlex">
                    <div class="QuGuiHorizontalListBox">
                        <div class="QuGuiBoxAlignRowCenterFlex" title="行程"><i class="iconfont QuGuiTextSize12">&#xe632;</i></div>
                        <div class="QuGuiBoxAlignRowCenterFlex" title="攻略"><i class="iconfont QuGuiTextSize12">&#xe62f;</i></div>
                        <div class="QuGuiBoxAlignRowCenterFlex" title="组队"><i class="iconfont QuGuiTextSize12">&#xe610;</i></div>
                        <div class="QuGuiBoxAlignRowCenterFlex" title="足迹"><i class="iconfont QuGuiTextSize12">&#xe7cc;</i></div>
                        <div class="QuGuiBoxAlignRowCenterFlex" title="寻找"><i class="iconfont QuGuiTextSize12">&#xe604;</i></div>
                    </div>
                </div>
            </div>
            <div class="QuGuiBoxAlignRowCenterFlex" style="width: 100%; height: 10%;">
                <div id="slogan" class="QuGuiBoxAlignRowCenterFlex">
                    向来心是看客心，奈何人是剧中人
                </div>
            </div>
            <div class="QuGuiBoxAlignRowCenterFlex" style="width: 100%; height: 40%;">
                <img id="summary" src="../../imgs/favorite.jpg" />
            </div>
            <div class="QuGuiBoxAlignRowCenterFlex" style="width: 100%; height: 10%;">
                <button id="moreBtn" class="profileBottomBtn QuGuiBtn"><i class="iconfont">&#xe600;</i></button>
                <button id="indexBtn" class="profileBottomBtn QuGuiBtn"><i class="iconfont">&#xe6a6;</i></button>
            </div>
        </div>
    </div>
    <div class="QuGuiBoxAlignColumnCenterFlex QuGuiBox40And100pc QuGuiBackgroundColorBlack">
        <div class="visitedPlaceBox QuGuiBoxAlignColumnCenterFlex">
            <div class="visitedPlaceBoxCenter QuGuiBoxAlignRowCenterFlex">
                <div class="visitedPlace QuiGuiHoverShadowWhite">
                    <img src="../../imgs/visitedPlace1.jpg">
                </div>
                <!--<div class="visitedPlace QuiGuiHoverShadowWhite">-->
                    <!--<img src="../../imgs/visitedPlace2.jpg">-->
                <!--</div>-->
                <!--<div class="visitedPlace QuiGuiHoverShadowWhite">-->
                    <!--<img src="../../imgs/visitedPlace3.jpg">-->
                <!--</div>-->
            </div>
            <div class="visitedPlaceBoxBottom QuGuiBoxAlignColumnCenterFlex">
                <div class="navBtnBox QuGuiBoxAlignRowCenterFlex">
                    <button class="navBtn  QuiGuiHoverShadowWhite"><</button>
                    <button class="navBtn QuiGuiHoverShadowWhite">></button>
                </div>
                <div class="everyDayMsg">
                    你是一树一树的花开，是燕在梁间的呢喃，你是爱，是暖，是希望，你是人间的四月天。
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../js/qugui/user/profile.js"></script>
</body>
</html>