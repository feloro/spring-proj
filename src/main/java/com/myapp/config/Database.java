package com.myapp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

import java.util.Properties;

/**
 * Created by anton.istomin on 27.04.2018.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.myapp.database.repository")
public class Database {

  @Autowired
  Environment env;

  @Bean
  @Primary
  public DataSource dataSource() throws PropertyVetoException {
    /** if needed:
     <property name="initialPoolSize" value="${db.minPoolSize}" />
     <property name="minPoolSize" value="${db.minPoolSize}" />
     <property name="maxPoolSize" value="${db.maxPoolSize}" />
     <property name="acquireIncrement" value="${db.acquireIncrement}" />
     <property name="idleConnectionTestPeriod" value="3000" />
     <property name="preferredTestQuery" value="select 1" />
     <property name="maxIdleTimeExcessConnections" value="2400" />
     */

    /**that datasource allows user cached queries*/
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(env.getProperty("db.driver"));
    dataSource.setJdbcUrl(env.getProperty("db.url"));
    dataSource.setUser(env.getProperty("db.username"));
    dataSource.setPassword(env.getProperty("db.password"));
    return dataSource;
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource());
    factoryBean.setPackagesToScan(env.getProperty("db.entitymanager.packages.to.scan"));
    factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    Properties props = new Properties();
    props.put("hibernate.dialect", env.getProperty("db.hibernate.dialect"));
    props.put("hibernate.show_sql", env.getProperty("db.hibernate.show_sql"));
    props.put("hibernate.hbm2ddl.auto", env.getProperty("db.hibernate.hbm2ddl.auto"));
    factoryBean.setJpaProperties(props);
    return factoryBean;
  }

  @Bean
  public JpaTransactionManager transactionManager () throws PropertyVetoException {
    JpaTransactionManager manager = new JpaTransactionManager();
    manager.setEntityManagerFactory(entityManagerFactory().getObject());
    return manager;
  }

  @Bean
  public SpringLiquibase liquibase() throws PropertyVetoException {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setDataSource(dataSource());
    liquibase.setChangeLog("classpath:changelogs/sql/all.xml");
    return liquibase;
  }
}
