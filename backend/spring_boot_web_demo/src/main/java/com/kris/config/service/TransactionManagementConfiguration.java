package com.kris.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @ClassName TransactionManagementConfiguration
 * @Description 配置 Service 层事务
 *
 * Spring Boot 开发 3 步骤：配置，接口类，实现类
 *
 * Service 层是对业务整合的分层，将多个 DAO 层的操作封装到一个 Service 方法中，所以就需要用到事务。
 *
 * @Author Kris
 * @Date 2019/9/6 11:28
 * @Version 1.0
 **/
@Configuration
// 开启事务管理
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{

    @Autowired
    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
