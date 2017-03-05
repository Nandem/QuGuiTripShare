<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../css/libs/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../js/libs/html5shiv.min.js"></script>
    <script src="../../js/libs/respond.min.js"></script>
    <!--<![endif]&ndash;&gt;-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/libs/jq/jquery-3.1.1.min.js"></script>
    <script src="../../js/jquery.leoweather.min.js"></script>
    <script src="../../js/qugui/user/login.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/libs/bootstrap/bootstrap.min.js"></script>
    <link href="../../css/qugui/quguiStyle.css" rel="stylesheet">
    <link href="../../css/qugui/user/login.css" rel="stylesheet">
    <title>去归</title>
</head>
<body>
<div class="topBox">
    <div id="weather">
        <script>
            $('#weather').leoweather(
                    {
                        format:'<i class="icon-{图标}">{气温}℃</i>'
                    });
        </script>
    </div>
    <span class="vline quguiMarginLeft30"></span>
    <div class="introduction quguiMarginLeft30">
        <p class="text-center quguiFontSize66">去归</p>
        <p class="lead text-center">
            你的个性化旅行分享平台
        </p>
    </div>
</div>
<div class="bottomBox">
    <div class="loginBox">
        <input type="text" class="quguiTextInput quguiSizeLarge quguiMarginTop30" />
        <input type="password" class="quguiTextInput quguiMarginTop10 quguiSizeLarge" />
        <button class="quguiBtn quguiBlackBtnStyle quguiMarginTop10 quguiSizeLarge" onclick="login()">登录</button>
        <div class="quguiSizeLarge registerAndForgotPassword quguiMarginTop5">
            <p class="">忘记密码</p>
            <p class="">免费注册</p>
        </div>

        <div class="footer quguiFontSize12">
            关于去归 | 诚征英才 | 联系我们 | International Business | About QuGui<br>
            去归版权所有 2013-2017 蜀IPC备15025050
        </div>
    </div>
</div>
</body>
</html>