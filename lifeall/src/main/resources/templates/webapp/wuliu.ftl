<#if wuliulist??>
<div class="weui-cells">
    <#list wuliulist as wuliu>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>${wuliu.context}</p>
            </div>
            <div class="weui-cell__ft">${wuliu.nodeTime?string("yyyy-MM-dd HH:mm")}</div>
        </div>
    </#list>
</div>
</#if>