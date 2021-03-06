package com.info.application;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2018/1/19 10:00
 */
//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.info" })
@MapperScan("com.info.dao")
public class Application extends SpringBootServletInitializer implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(SpringBootServletInitializer.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    // 创建数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    // 指定数据源的前缀 ,在application.properties文件中指定
    public DataSource dataSource() {
        return new DataSource();
    }

    // 创建SqlSessionFactory
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    // 创建事物管理器
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("项目启动完成！");
    }
}