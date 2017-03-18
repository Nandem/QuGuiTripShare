<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../css/libs/bootstrap/bootstrap.min.css" rel="stylesheet">
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
    <link href="../../css/qugui/user/register.css" rel="stylesheet">

    <title>注册</title>
</head>
<body>
<div class="QuGuiFullScreenContainer boxContainer">
    <div class="leftBox">
        <div class="boxLayer1">
            <p class="text-left QuGuiTextSize45 QuGuiTextStyleWhite">
                我们一直在等你
            </p>
            <p class="text-left QuGuiTextSize25 QuGuiTextStyleWhite">
                你，和你的一切我们都很感兴趣。我们将和你度过以后的每一个旅行的时光，
                我们将与你一同分享沿途的喜和乐。
                但是12px汉字例外，就是由以上方法得到的12px(1.2em)大小的汉字在IE中并不等于直接用12px定义的字体大小，而是稍大一点。这个问 题 Jorux已经解决，只需在body选择器中把62.5%换成63%就能正常显示了。原因可能是IE处理汉字时，对于浮点的取值精确度有限。不知道有没有 其他的解释。
            </p>
        </div>
    </div>
    <div class="rightBox">
        <div class="registerFormBox">
            <div class="formTitle"><span class="QuGuiTextSize50">申请资料</span></div>
            <div class="formCenter">
                <div><input placeholder="昵称" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiTextSize35"><input placeholder="邮箱" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiMarginLeft10 QuGuiTextSize35"></div>
                <div class="QuGuiMarginTop10"><input placeholder="密码" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiTextSize35"><input placeholder="确认密码" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiMarginLeft10 QuGuiTextSize35"></div>
                <div class="QuGuiMarginTop10"><input placeholder="身份证号" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiTextSize35"><input placeholder="真实姓名" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiMarginLeft10 QuGuiTextSize35"></div>
                <div class="QuGuiMarginTop10"><input placeholder="手机号" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiTextSize35"><input placeholder="旅行的意义" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiMarginLeft10 QuGuiTextSize35"></div>
            </div>
            <div class="formFooter">
                <div>
                    <input id="placeHolderHaHa" class="QuGuiSizeLarge  QuGuiInputHide" readonly>
                    <input placeholder="验证码" id="validCode" class="QuGuiSizeLarge QuGuiTextInputLine QuGuiMarginLeft10">
                    <div id="tip" style=""></div>
                </div>
                <div id="somethingToBeHide" class="QuGuiMarginTop5">
                    <input class="QuGuiSizeLarge QuGuiInputHide" readonly>
                    <button id="registerBtn" class="QuGuiSizeLarge QuGuiMarginLeft10 QuGuiBtn  QuGuiTextSize25">申请</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../js/qugui/user/register.js"></script>
</body>
</html>