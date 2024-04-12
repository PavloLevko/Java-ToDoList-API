package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
public class AppContext {
@Bean
    LocalSessionFactoryBean sessionFactoryBean(){
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setPackagesToScan("com.example.domain");
    sessionFactory.setHibernateProperties(hibernateProperties());
    sessionFactory.setDataSource(dataSource());
    return sessionFactory;
}
@Bean
    public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/jru_boolean_spring?useSSL=false&useTimezone=true&serverTimezone=UTC");
    dataSource.setUsername("root");
    dataSource.setPassword("050708Sensual");
    return dataSource;
    }

    private Properties hibernateProperties() {
    Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}
