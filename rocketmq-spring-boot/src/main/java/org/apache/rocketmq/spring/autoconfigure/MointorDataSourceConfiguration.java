package org.apache.rocketmq.spring.autoconfigure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lijiangtao
 * @description rocketmq 监控信息存储数据库信息配置
 * @date 2020/8/21 0021
 */
@Configuration
@MapperScan(basePackages = "org.apache.rocketmq.spring.dao",sqlSessionFactoryRef = "monitorSqlSessionFactory",sqlSessionTemplateRef = "monitorSqlSessionTemplate")
public class MointorDataSourceConfiguration {


    @Bean("monitorDataSource")
    @ConfigurationProperties(prefix = "rocketmq.monitor.datasource")
    public DataSource troubleMsgDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("monitorSqlSessionFactory")
    public SqlSessionFactory monitorSqlSessionFactory(@Qualifier("monitorDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean("monitorSqlSessionTemplate")
    public SqlSessionTemplate monitorSqlSessionTemplate(
            @Qualifier("monitorSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

}
