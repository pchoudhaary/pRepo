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
@EnableJpaRepositories(basePackages="com.ashokit.oraclrepo",
                        entityManagerFactoryRef="orclEMF" ,
                        transactionManagerRef="orclTxm")
public class OracleConfig {

	@Bean
	@ConfigurationProperties(prefix = "orcle.datasource")
	@Primary
	public DataSource createDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name="orclEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(EntityManagerFactoryBuilder builder) {

		Map<String, String> map = new HashMap<>();

		map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		map.put("hibernate.hbm2ddl.auto", "update");

		return builder.dataSource(createDataSource()).packages("com.ashokit.product").properties(map).build();

	}
	
	
	@Bean(name="orclTxm")
	@Primary
	public PlatformTransactionManager createTransationManager(@Qualifier("orclEMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
