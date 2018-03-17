package com.yhc.lifeall.common.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.yhc.lifeall.mapper.netcrawl", sqlSessionTemplateRef = "netCrawlSqlSessionTemplate")
public class NewCrawlDataSourceConfig {
    @Bean(name = "netCrawlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.netcrawldata")
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "netCrawlTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("netCrawlDataSource") DataSource dataSource) {
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "netCrawlSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("netCrawlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/netcrawl/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "netCrawlSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("netCrawlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
