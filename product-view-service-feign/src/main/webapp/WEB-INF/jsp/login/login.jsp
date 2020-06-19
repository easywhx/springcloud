<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome.min.css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="${ctx}/resource/assets/js/ace-extra.min.js"></script>
    <!--[if lt IE 9]>
    <script src="${ctx}/resource/assets/js/html5shiv.js"></script>
    <script src="${ctx}/resource/assets/js/respond.min.js"></script>
    <![endif]-->
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <title>登录实验室管理系统</title>
</head>

<body class="login-layout Reg_log_style">

<div class="loginbody">
    <div class="login-container">
        <div class="center">
          <%--<p><b style="font-size: 38px;color: white">高校实验室管理系统</b></p>--%>
        </div>

        <div class="space-6"></div>

        <div class="position-relative">
            <div id="login-box" class="login-box widget-box no-border visible" style="height: 255px">
                <div class="widget-body" style="height: 243px">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            用户登录
                        </h4>

                        <div class="login_icon"><img src="${ctx}/resource/images/login.png"/></div>

                        <form action="login_index" method="post" id="login">
                            <fieldset style="text-align: center">
                                <ul>
                                    <li class="frame_style form_error"><label class="user_icon"></label>
                                        <input name="name" type="text" id="用户名"/><i>用户名</i></li>
                                    <li class="frame_style form_error"><label class="password_icon"></label><input
                                            name="pass" type="password" id="密码"/><i>密码</i></li>

                                </ul>
                                <button type="button" class="width-35  btn btn-sm btn-primary"
                                        id="login_btn">
                                    <i class="icon-key"></i>
                                   登录
                                </button>
                                <%--<button type="button" class="width-35 pull-right btn btn-sm btn-primary"--%>
                                        <%--onclick="add()">--%>
                                    <%--<i class="icon-key"></i>--%>
                                    <%--注册--%>
                                <%--</button>--%>
                    </fieldset>
                    </form>

                   
                    </div><!-- /widget-main -->
                    <div class="toolbar clearfix">
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
</div>
</div>
</body>
</html>
<script>
    $(document).keydown(function(){
        if (event.keyCode == 13) {//回车键的键值为13
            loginReq();
        }
    });
    $('#login_btn').on('click', function () {
        loginReq();
    });

    function loginReq() {
        var num = 0;
        var str = "";
        $("input[type$='text'],input[type$='password']").each(function (n) {
            if ($(this).val() == "") {

                layer.alert(str += "" + $(this).attr("id") + "不能为空！\r\n", {
                    title: '提示框',
                    icon: 0,
                });
                num++;
                return false;
            }
        });
        if (num > 0) {
            return false;
        } else {
            $.ajax({
                cache: false,
                type: "post",
                url: "login_index",
                data: $('#login').serialize(),// 你的formid
                async: false,
                success: function (data) {
                    if (data.flag == 1) {
                        layer.msg('登陆成功', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                            window.location.href = data.url;
                        });
                    }
                    if (data.flag == 2) {
                        layer.msg('帐号未审核', {
                            icon: 0,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                        });
                    }
                    if (data.flag == 3) {
                        layer.msg('用户名或密码错误', {
                            icon: 0,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                        });
                    }

                }
            });
        }
    }

    function add() {
        layer.open({
            type: 2,
            area: ['700px', '600px'],
            content: 'user_add.do' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });

    }

    $(document).ready(function () {
        $("input[type='text'],input[type='password']").blur(function () {
            var $el = $(this);
            var $parent = $el.parent();
            $parent.attr('class', 'frame_style').removeClass(' form_error');
            if ($el.val() == '') {
                $parent.attr('class', 'frame_style').addClass(' form_error');
            }
        });
        $("input[type='text'],input[type='password']").focus(function () {
            var $el = $(this);
            var $parent = $el.parent();
            $parent.attr('class', 'frame_style').removeClass(' form_errors');
            if ($el.val() == '') {
                $parent.attr('class', 'frame_style').addClass(' form_errors');
            } else {
                $parent.attr('class', 'frame_style').removeClass(' form_errors');
            }
        });
    })

</script>