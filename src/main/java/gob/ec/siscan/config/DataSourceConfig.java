package gob.ec.siscan.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	  @Value("${spring.datasource.url}")
	  private String dbUrl;
	  @Profile("prod")
	  @Bean
	  public DataSource dataSource() {
	      HikariConfig config = new HikariConfig();
	      config.setJdbcUrl(dbUrl);
	      return (DataSource) new HikariDataSource(config);
	  }
}
