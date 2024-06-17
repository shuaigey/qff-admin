package org.example.qff.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/3 17:43
 **/
@Configuration
@MapperScan("org.example.qff.dao")
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;
    public SqlSessionFactory sqlSessionFactory()  throws  Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("org.example.qff.dao");//扫描Model
        PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/mapper/*.xml"));
        return sessionFactory.getObject();
    }
}