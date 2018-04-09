<!doctype html>
<html>
<head>
    <!--//theme-style-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
    <!-- head 中 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <script src="/static/js/jquery-2.1.4.js"></script>
    <script src="/static/js/jquery-weui.min.js"></script>
    <style>
        body, html {
            height: 100%;
            -webkit-tap-highlight-color: transparent;
        }
    </style>
    <script>
        $(function () {
            // var ua = navigator.userAgent.toLowerCase();
            // var isWeixin = ua.indexOf('micromessenger') != -1;
            // var isAndroid = ua.indexOf('android') != -1;
            // var isIos = (ua.indexOf('iphone') != -1) || (ua.indexOf('ipad') != -1);
            // if (!isWeixin) {
            //     document.head.innerHTML = '<title>抱歉，出错了</title><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0"><link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/0.4.1/weui.css">';
            //     document.body.innerHTML = '<div class="weui_msg"><div class="weui_icon_area"><i class="weui_icon_info weui_icon_msg"></i></div><div class="weui_text_area"><h4 class="weui_msg_title">请在微信客户端打开链接</h4></div></div>';
            // }

        });
    </script>
    <sitemesh:write property='head'/>

</head>
<body ontouchstart>
<!--container-->
<sitemesh:write property='body'/><br/>

<!-- body 最后-->
<div class="weui-loadmore" style="padding-bottom:30px;height:20px;display:none;">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
</div>

<div class="weui-footer">
    <p class="weui-footer__links">
        <a href="javascript:void(0);" class="weui-footer__link"></a>
    </p>
    <p class="weui-footer__text">Copyright © 2018-2020 yinghuacheng 浙ICP备18010399</p>
</div>

<!-- 如果使用了某些拓展插件还需要额外的JS -->
<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/swiper.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/city-picker.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<!--iOS 系统下默认的 click 事件会有300毫秒的延迟，这个延迟是iOS系统的特性而不是jQuery WeUI设定的，可以使用 fastclick 来消除这个延迟-->
<script src="/static/js/fastclick.js"></script>
<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>
</body>
</html>