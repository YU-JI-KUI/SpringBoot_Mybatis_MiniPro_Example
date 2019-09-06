package com.kris.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.beans.PropertyVetoException;

/**
 * @ClassName DataSourceConfiguration
 * @Description 配置数据库连接池
 * @Author Kris
 * @Date 2019/9/5 21:23
 * @Version 1.0
 **/
@Configuration
// 要扫描 Mapper 类包的路径
@MapperScan("com.kris.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        // 连接池关闭不自动提交事务
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
