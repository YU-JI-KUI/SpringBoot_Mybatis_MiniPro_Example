package com.kris.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName SessionFactoryConfiguration
 * @Description 配置 sqlSessionFactory, DAO 层的基础配置
 * 我们在使用中很少使用 DriverManager 来获取数据库连接，而是采用 DataSource 来获取连接
 * SqlSession 是持久层操作的对象，类似于 JDBC 的 Connection。
 * SqlSessionFactory 一般是由 XML 或 Configuration 配置得到，进而生成 SqlSession
 * @Author Kris
 * @Date 2019/9/5 21:55
 * @Version 1.0
 **/
@Configuration
public class SessionFactoryConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("@{entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        sqlSessionFactory.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactory;
    }
}
