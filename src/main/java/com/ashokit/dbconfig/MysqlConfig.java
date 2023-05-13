package com.ashokit.dbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.ashokit.mysqllrepo",
                         entityManagerFactoryRef="mysqlEMF",
                         transactionManagerRef="mysqlTxm")
public class MysqlConfig {

	@Bean(name="mysqlDS")
	@ConfigurationProperties(prefix="mysql.datasource")
	
	public DataSource createDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlEMF")
	
	public LocalContainerEntityManagerFactoryBean createEntityManager(EntityManagerFactoryBuilder builder) {
		
		Map<String,String> map=new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		
		return builder.dataSource(createDataSource()).
				packages("com.ashokit.book")
				.properties(map)
				.build();
		
		
	}
	
	@Bean(name="mysqlTxm")
	public PlatformTransactionManager createTransationalManager(@Qualifier("mysqlEMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
	
	
	
	
	
}
