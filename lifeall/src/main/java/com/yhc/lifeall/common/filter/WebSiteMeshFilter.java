package com.yhc.lifeall.common.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        // 配置默认的渲染器. 将应用于所有路径.
        builder.addDecoratorPath("/*", "/decorators/mainpage").addExcludedPath("/static/**")//白名单;
//                // 配置特定路径的渲染器.
                .addExcludedPath("/list/*").addExcludedPath("/druid");
//                .addDecoratorPath("/*.special.jsp", "/special-decorator.html")
//                // 配置多个渲染器.
//                .addDecoratorPaths("/articles/*", "/decorators/article.html",
//                        "/decoratos/two-page-layout.html",
//                        "/decorators/common.html")
//                // 不被渲染的路径.
//                .addExcludedPath("/javadoc/*")
//                .addExcludedPath("/brochures/*");
//
//                .addTagRuleBundle(new MyTagRuleBundle())//自定义标签
    }
}
