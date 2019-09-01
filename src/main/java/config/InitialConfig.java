package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class InitialConfig {

	@Value("${spring.datasource.url}")
	String mysqlUrl;
	
	@Value("${spring.datasource.username}")
	String mysqlUser;
	
	@Value("${spring.datasource.password}")
	String mysqlPassword;
	
	@Value("${spring.datasource.driver-class-name}")
	String mysqlDriver;
	
	@Bean
	public DataSource getMYSQLDatasource() {
		DataSourceBuilder dataSource = DataSourceBuilder.create(); 
		dataSource.driverClassName(mysqlDriver);
		dataSource.url(mysqlUrl);
		dataSource.username(mysqlUser); 
		dataSource.password(mysqlPassword); 
		
        return dataSource.build();
	}
	
    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
	
	
}
