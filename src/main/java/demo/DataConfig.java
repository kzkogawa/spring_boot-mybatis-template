package demo;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("demo.mapper")
public class DataConfig {
	private DataSource dataSource;

	@Bean
	public DataSource dataSource() {
		if (this.dataSource == null) {
			this.dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "admin");
		}
		return this.dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("demo.model");
		sessionFactory.setMapperLocations(resolver.getResources("classpath:sqlmap/*.xml"));
		return sessionFactory;
	}
}
