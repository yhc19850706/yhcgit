<!doctype html>
<html lang="en">
<head>
    <script>
        $(function () {
            var page=2
            var loading = false;  //状态标记
            $(document.body).infinite().on("infinite", function() {
                if(loading) return;
                loading = true;
                $('.weui-loadmore').show();
                setTimeout(function() {
                    $.ajax({
                        type: "get",
                        url: "/list/loadpage?pageNum="+page+"&websiteId="+${websiteId},
                        error: function (request) {
                            $(".weui-loadmore").hide();
                            var html = "<div class=\"weui-cells__title\" >已无更多数据</div>";
                            $("#newslist").append(html);
                            loading = true;
                        },
                        success: function (data) {
                            if (data!=null && data.length>0) {
                                $("#newslist").append(data);
                                loading=false;
                                page=page+1;
                            }
                            else {
                                var html = "<div class=\"weui-cells__title\" >已无更多数据</div>";
                                $("#newslist").append(html);
                                loading = true;

                            }
                            $(".weui-loadmore").hide();
                        }
                    });
                }, 1000);   //模拟延迟
            });
        })
    </script>
</head>
<body>
<div class="weui-cells" id="newslist">
    <#list newsList as news>
        <a class="weui-cell weui-cell_access" href="${news.newsUrl!}">
            <div class="weui-cell__bd">
                <p>${news.newsName!}</p>
            </div>
            <div class="weui-cell__ft">
                ${news.publishTime?string('HH:mm')}
            </div>
        </a>
    </#list>
</div>

</body>
</html>