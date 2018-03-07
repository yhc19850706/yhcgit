<div class="content" style="background-color: #FFFFFF; width: 100%;height:88%; margin-top:40px;margin-top: 45px;position: absolute; margin-bottom:45px;padding:0px; overflow: hidden;">
    <div class="list-main-mian weui-form-preview infinite weui-pull-to-refresh" id="listwrap" style="height:100%; margin-top: 1px;overflow:auto;  z-index: 1">
        <!--下拉刷新-->
        <div class="weui-pull-to-refresh__layer" style="padding: 5px;">
            <div class="weui-pull-to-refresh__arrow"></div>
            <div class="weui-pull-to-refresh__preloader"></div>
            <div class="down">下拉刷新</div>
            <div class="up">释放刷新</div>
            <div class="refresh">正在刷新</div>
        </div>
        <div class="weui-form-preview" id="Tolist">
            <!--内容展示区域-->
        </div>
        <div class="weui-loadmore" style="padding-bottom:30px;height:20px">
            <i class="weui-loading"></i>
            <span class="weui-loadmore__tips">正在加载</span>
        </div>
    </div>
</div>
<script>
    var pages = 1;
    var sizes = 4;
    var loading = false;  //状态标记
    $(function () {
        //loadlist();
    })
    //=========================下拉刷新
    $("#listwrap").pullToRefresh().on("pull-to-refresh", function () {
        setTimeout(function () {
            pages = 1;
            $("#Tolist").html("");
            loadlist();
            if (loading) loading = false;
            $("#listwrap").pullToRefreshDone(); // 重置下拉刷新
        }, 1500);   //模拟延迟
    });
    //============================滚动加载
    $("#listwrap").infinite().on("infinite", function () {
        if (loading) return;
        loading = true;
        pages++; //页数
        $('.weui-loadmore').show();
        setTimeout(function () {
            loadlist();
            loading = false;
        }, 2500);   //模拟延迟
    });
    // =======加载数据loadlist();
    function loadlist() {
        var html = "";
        $.ajax({
            type: "POST",
            url: "/Index/Index",
            data: { 'page': pages, 'size': sizes },
            dataType: "json",
            error: function (request) {
                $(".weui-loadmore").hide();
                html += "<div class=\"weui-cells__title\" >已无更多数据</div>";
                $("#Tolist").append(html);
            },
            success: function (data) {
                if (data.List.length > 0) {
                    for (var i = 0; i < data.List.length; i++) {
                        html += ' <div class="weui-form-preview__bd"> ';
                        html += ' <div class="weui-form-preview__item"> ';
                        html += ' <label class="weui-form-preview__label">' + data.List[i].Name + '</label> ';
                        html += ' </div> ';
                        html += ' </div> ';
                    }
                    $("#Tolist").append(html);
                }
                else {
                    html += "<div class=\"weui-cells__title\" >已无更多数据</div>";
                    $("#Tolist").append(html);
                    loading = true;
                }
                $(".weui-loadmore").hide();
            }
        });
    }
</script>