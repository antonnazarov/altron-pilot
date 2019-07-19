package bs2.cim.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CimDefaultConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource);
    }
}
