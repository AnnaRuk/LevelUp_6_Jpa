package de.ait.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.ait.repositories.impl.UsersRepositoryImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "de.ait")
public class HibernateConf {

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jpa_db");
        config.setUsername("postgres");
        config.setPassword("qwerty43!");
        config.setMaximumPoolSize(20);

        return config;
    }

    @Bean
    public DataSource dataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }


    @Bean
  public Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    return hibernateProperties;
}

    @Bean
    public UsersRepositoryImpl usersRepository(EntityManager entityManager) {
        return new UsersRepositoryImpl(entityManager);
    }

    @Bean
    public EntityManager entityManager(SessionFactory factory) {
        return factory.createEntityManager();
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("de.ait.models");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean factory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factory.getObject());
        return transactionManager;
    }



}

