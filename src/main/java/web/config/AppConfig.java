package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(value = "web")
public class AppConfig {

    @Bean
    public DataSource getDataSource (){
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/users_mvc?verifyServerCertificate=false&useSSL" +
                "=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
        managerDataSource.setUsername("root");
        managerDataSource.setPassword("E8d4a51000");
        return managerDataSource;
    }

    @Bean
    public Properties hibernateProperties () {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql","hibernate.show_sql=true");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto","create-drop");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf () {
        LocalContainerEntityManagerFactoryBean localContainerEmf = new LocalContainerEntityManagerFactoryBean();
        localContainerEmf.setDataSource(getDataSource());
        localContainerEmf.setPackagesToScan("web");
        localContainerEmf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEmf.afterPropertiesSet();
         return localContainerEmf;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager () {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf().getObject());
        return transactionManager;
    }
}
