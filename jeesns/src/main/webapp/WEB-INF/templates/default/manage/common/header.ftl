<header class="main-header">
    <a href="http://www.jeesns.cn" class="logo" target="_blank">
        <span class="logo-mini"><b>JEE</b></span>
        <span class="logo-lg"><b>JEESNS</b></span>
    </a>
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${base}${loginUser.avatar}" class="user-image" alt="User Image">
                        <span class="hidden-xs">${loginUser.name}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <img src="${base}${loginUser.avatar}" class="img-circle" alt="User Image">
                            <p>
                                ${loginUser.name}
                                <small>${loginUser.email}</small>
                            </p>
                        </li>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="${base}/member/editInfo" class="btn btn-default btn-flat" target="_blank">设置</a>
                            </div>
                            <div class="pull-right">
                                <a href="${base}/member/logout" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<aside class="main-sidebar">
    <section class="sidebar">
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${base}${loginUser.avatar}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${loginUser.name}</p>
                <a href="${base}/member/editInfo" target="_blank"><i class="fa fa-circle text-success"></i> 设置</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">功能模块</li>
            <li><a href="${managePath}/index"><i class="fa fa-dashboard"></i> <span>后台主页</span></a></li>
            <li class="treeview" module="config">
                <a href="#">
                    <i class="fa fa-cog"></i> <span>系统设置</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/config/edit" module="config"><i class="fa fa-circle-o"></i>系统设置</a></li>
                    <li><a href="${managePath}/config/managerList" module="config"><i class="fa fa-circle-o"></i>管理员列表</a></li>
                    <li><a href="${managePath}/sys/scoreRule/list" module="config"><i class="fa fa-circle-o"></i>积分规则</a></li>
                </ul>
            </li>
            <li class="treeview" module="action">
                <a href="#">
                    <i class="fa fa-cog"></i> <span>动态管理</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/action/list" module="action"><i class="fa fa-circle-o"></i>动态类型</a></li>
                    <li><a href="${managePath}/action/actionLogList" module="action"><i class="fa fa-circle-o"></i>会员日志</a></li>
                    <li><a href="${managePath}/action/memberActionLog" module="action"><i class="fa fa-circle-o"></i>会员动态</a></li>
                </ul>
            </li>
            <li class="treeview" module="cms">
                <a href="#">
                    <i class="fa fa-book"></i> <span>文章管理</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/cms/articleCate/list" module="cms"><i class="fa fa-circle-o"></i>栏目管理</a></li>
                    <li><a href="${managePath}/cms/index" module="cms"><i class="fa fa-circle-o"></i>文章管理</a></li>
                </ul>
            </li>
            <li class="treeview" module="mem">
                <a href="#">
                    <i class="fa fa-user"></i> <span>会员管理</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/mem/index" module="mem"><i class="fa fa-circle-o"></i>会员列表</a></li>
                </ul>
            </li>
            <li class="treeview" module="group">
                <a href="#">
                    <i class="fa fa-group"></i> <span>群组管理</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/group/index" module="group"><i class="fa fa-circle-o"></i>群组列表</a></li>
                </ul>
            </li>
            <li class="treeview" module="weibo">
                <a href="#">
                    <i class="fa fa-weibo"></i> <span>微博管理</span>
                    <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${managePath}/weibo/index" module="weibo"><i class="fa fa-circle-o"></i>微博列表</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
<script>
    $(function () {
       var uri = window.document.location.pathname;
        $(".treeview").each(function(){
            var _this = $(this);
            var module = _this.attr("module");
            if(uri.indexOf(module) > -1){
                _this.addClass("active");
            }else {
                _this.removeClass("active");
            }
        });
        $(".treeview-menu li").each(function(){
            var _this = $(this);
            if(uri == _this.find("a").attr("module")){
                _this.addClass("active");
            }else {
                _this.removeClass("active");
            }
        });
    });
</script>