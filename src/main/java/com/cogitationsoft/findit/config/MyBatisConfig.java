package com.cogitationsoft.findit.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Andy
 * @date: 5/3/2018 5:57 PM
 * @description: Mybatis 配置信息
 * @version: 1.0
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config/druid.properties")
@MapperScan("com.cogitationsoft.findit.mapper")
public class MyBatisConfig {
	@Autowired(required = false)
	public Environment env;

	@Value("${druid.driverClassName}")
	private String driver;

	@Value("${druid.url}")
	private String url;

	@Value("${druid.username}")
	private String username;

	@Value("${druid.password}")
	private String password;

	@Value("${druid.initialSize}")
	private int initialSize;

	@Value("${druid.minIdle}")
	private int minIdle;

	@Value("${druid.maxActive}")
	private int maxActive;

	@Value("${druid.maxWait}")
	private int maxWait;

	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		// 基本属性 url、user、password
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		// 配置初始化大小、最小、最大
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);

		// 配置获取连接等待超时的时间
		dataSource.setMaxWait(maxWait);

		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

		dataSource.setValidationQuery("SELECT 'X'");
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);

		// 是否打开PSCache，并且指定每个连接上PSCache的大小
		dataSource.setPoolPreparedStatements(false);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// 设置 mapper xml
		//sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
