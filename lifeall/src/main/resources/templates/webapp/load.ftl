<#list newsList as news>
        <a class="weui-cell weui-cell_access" href="${news.newsUrl!}">
            <div class="weui-cell__bd">
                <p>${news.newsName!}</p>
            </div>
            <div class="weui-cell__ft">
                <#if news.publishTime?exists>
                    ${news.publishTime?string('yyyy-MM-dd HH:mm')}
                </#if>
            </div>
        </a>
</#list>