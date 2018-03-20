<!doctype html>
<html lang="en">
<head>
    <script>
        $(function () {
            $("#regist").click(function () {
                $.ajax({
                    type: "post",
                    url: "/login",
                    data:{"userName":$("#userName").val(),
                        "password":$("#password").val()},
                    error: function (request) {
                        $.alert("登陆异常！", "登陆");
                    },
                    success: function (data) {
                        if (data.status==200) {
                            $.alert("注册成功！", "登陆");
                            location.href="/"
                        }
                        else {
                            $.alert("登陆失败！", "登陆");
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">账号：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" id="userName" name="userName" pattern="[a-zA-Z][0-9]*" placeholder="请输入qq号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">密码：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="password" id="password" name="password" pattern="[a-zA-Z][0-9]*" placeholder="请输入qq号">
        </div>
    </div>
    <a href="javascript:void(0);" id="regist" class="weui-btn weui-btn_primary">登陆</a>
</div>
</body>
</html>