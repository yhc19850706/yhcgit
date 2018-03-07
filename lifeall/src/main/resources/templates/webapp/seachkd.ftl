<script>
    $(function () {

        $("#kddh").change(function () {
            $('#inputTips').children("li").remove()
             setTimeout(function() {
                 $("#tip").hide();
                var code=$("#kddh").val();
                if(code!=null&&code.length<5){
                    return
                }
                $.ajax({
                    type: "get",
                    url: "/list/kdsearch_code?code="+code,
                    error: function (request) {
                        $("#tip").show();
                        $("tipinfo").text("暂无数据")
                    },
                    success: function (data) {
                        if (data!=null && data.length>0) {
                            var jsondata = $.parseJSON(data);
                            var jsons=jsondata.auto
                            if(jsons.length>0){
                                var html="";
                                $('#inputTips').children("li").remove()
                                for(var i=0;i<jsons.length;i++){
                                  html+="<li class=\"selection selection0\" data-index="+i+" data-code="+jsons[i].comCode+" data-num="+code+"><span>"+jsons[i].comCode+"</span></li>"
                                }

                                $("#inputTips").append(html);
                                //$('#inputTips').show();
                                $("#search").removeClass("weui-btn_disabled");
                            }
                        }
                        else {
                            $("#tip").show();
                            $("tipinfo").text("暂无数据")

                        }
                    }
                });
            }, 500);
        });

        $("#search").click(function () {
            $("#search").addClass("weui-btn_disabled");
            $('#loading').show();
            $('#wuliu').children("div").remove();
            var code=$("#kddh").val();
            if(code!=null&&code.length<5){
                $('#loading').hide();
                $("#tip").show();
                $("tipinfo").text("请输入正确的快递单号")
                return
            }
            var lihtmls=$("#inputTips").children("li");
            if (lihtmls!=null&&lihtmls.length>0){
                var result=false;
                for (var i=0;i<lihtmls.length;i++) {
                    var datacode=lihtmls[i].attributes[2].nodeValue
                    if (datacode!=null&&datacode.length>0){
                        $.ajax({
                            type: "get",
                            url: "/list/kdsearch?code="+code+"&kdcode="+datacode,
                            async:false,
                            error: function (request) {
                                var html = "<div class=\"weui-cells__title\" >未查询到物流信息</div>";
                                $("#wuliu").append(html);
                            },
                            success: function (data) {
                                if (data!=null && data.length>0) {
                                    $('#loading').hide();
                                    $("#wuliu").append(data);
                                    result=true
                                    $("#search").removeClass("weui-btn_disabled");
                                }
                            }
                        });
                        if(result){
                            return
                        }
                    }
                }
                if(!result){
                    $('#loading').hide();
                    $("#search").removeClass("weui-btn_disabled");
                    $("#tip").show();
                    $("tipinfo").html("暂无数据")
                    return
                }
            }
        });
    });
</script>

<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">快递单号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="kddh" type="number" pattern="[0-9]*" placeholder="请输入快递单号">
        </div>
    </div>
    <ul class="input-tips hidden" id="inputTips" style="display: none;">
    </ul>
    <a href="javascript:void(0);" id="search" class="weui-btn weui-btn_disabled weui-btn_primary">搜索</a>

</div>
  <div class="weui-loadmore" id="loading" style="display: none;">
      <i class="weui-loading"></i>
      <span class="weui-loadmore__tips">正在加载</span>
  </div>
    <div class="weui-loadmore weui-loadmore_line" id="tip" style="display: none;">
        <span class="weui-loadmore__tips" id="tipinfo">暂无数据</span>
    </div>
<div id="wuliu">
</div>