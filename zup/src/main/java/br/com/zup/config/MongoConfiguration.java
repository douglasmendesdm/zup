package br.com.zup.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

//@Configuration
//@EnableTransactionManagement
public class MongoConfiguration {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), "zupdb");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}
	
//	@Override
//    protected String getDatabaseName() {
//        return "zupdb";
//    }
//  
//    @Override
//    public Mongo mongo() throws Exception {
//        return new MongoClient("127.0.0.1", 27017);
//    }
//  
//    @Override
//    protected String getMappingBasePackage() {
//        return "br.com.zup.entity";
//    }
	
	public MongoOperations getMongoOperations(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		return mongoOperation;
	}
	
//	@Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("root123");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/zup");
//        dataSource.setDriverClassName("org.postgresql.Driver");
//
//        factoryBean.setDataSource(dataSource);
//        
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect" , "org.hibernate.dialect.MySQL5Dialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "update");
//
//        factoryBean.setJpaProperties(props);
//
//        factoryBean.setPackagesToScan("br.com.zup.entity");
//
//        return factoryBean;
//
//    }
//	
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
//		return new JpaTransactionManager(emf);
//		
//	}
	
//	@Bean
//    public LocalContainerEntityManagerFactoryBean mongoEntityManager() throws Throwable {
//
//        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put("javax.persistence.transactionType", "resource_local");
//        properties.put("hibernate.ogm.datastore.provider","mongodb");
//        properties.put("hibernate.ogm.datastore.host","localhost");
//        properties.put("hibernate.ogm.datastore.port","27017");
//        properties.put("hibernate.ogm.datastore.database", "zupdb");
//        properties.put("hibernate.ogm.datastore.create_database", "true");
//
//        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//        entityManager.setPackagesToScan("br.com.zup.entity");
//        entityManager.setPersistenceUnitName("mongoPersistenceUnit");
//        entityManager.setJpaPropertyMap(properties);
//        entityManager.setPersistenceProviderClass(HibernateOgmPersistence.class);
//        return entityManager;
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager() throws Throwable {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(mongoEntityManager().getObject());
//        return transactionManager;
//    }
	
}
