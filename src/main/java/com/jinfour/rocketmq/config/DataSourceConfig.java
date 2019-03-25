package com.jinfour.rocketmq.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${spring.datasource.hikari.pool-name}")
    private String poolName;

    @Value("${spring.datasource.hikari.connection-timeout}")
    private Integer connectionTimeout;

    @Value("${spring.datasource.hikari.max-lifetime}")
    private Integer maxLifetime;

    @Value("${spring.datasource.hikari.idle-timeout}")
    private Integer idleTimeout;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer maximumPoolSize;
    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;

    public String getPoolName() {
		return poolName;
	}

	@Bean
    public MBeanExporter exporter() {
        final MBeanExporter exporter = new AnnotationMBeanExporter();
        exporter.setAutodetect(true);
        exporter.setExcludedBeans("dataSource");
        return exporter;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        log.info("dataSourceUrl:"+dataSourceUrl);
        config.setJdbcUrl(dataSourceUrl); //数据源
        config.setUsername(user); //用户名
        config.setPassword(password); //密码
        config.setRegisterMbeans(true);
        config.setPoolName(poolName);
        config.setConnectionTimeout(connectionTimeout);
        config.setMaxLifetime(maxLifetime);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setIdleTimeout(idleTimeout);
        config.setDriverClassName(driverClassName);
        HikariDataSource ds = new HikariDataSource(config);
        log.info("DataSourceConfig config:"+ds.getDriverClassName()+"==="+ds.getConnectionTimeout()+"==="+ds.getMaxLifetime()+"==="+ds.getMaximumPoolSize()+"==="+ds.getIdleTimeout());
        return ds;
    }
}