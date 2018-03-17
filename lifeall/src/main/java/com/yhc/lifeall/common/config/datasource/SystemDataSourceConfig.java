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

/**
 * 配置类需要对DataSource、DataSourceTransactionManager、SqlSessionFactory 、SqlSessionTemplate四个数据项进行配置；DataSource类型需要引入javax.sql.DataSource；当系统中有多个数据源时，必须有一个数据源为主数据源，使用@Primary修饰。
 @MapperScan对指定dao包建立映射，确保在多个数据源下，自动选择合适的数据源，而在service层里不需要做特殊说明
 */
@Configuration
@MapperScan(basePackages = "com.yhc.lifeall.mapper.sysdata", sqlSessionTemplateRef = "sysSqlSessionTemplate")
public class SystemDataSourceConfig {
    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.systemData")
    @Primary
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sysdataTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("sysDataSource") DataSource dataSource) {
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sysSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/sysdata/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sysSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
