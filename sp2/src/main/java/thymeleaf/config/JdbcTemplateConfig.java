package thymeleaf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author : 小新青年
 * @date : 2019-11-25  16:25
 * 描述 : 配置 JdbcTemplate
 **/
@Configuration
public class JdbcTemplateConfig {
    /*
    只要引入 spring-jdbc 依赖,springboot会自动帮我们配置一个 jdbcTemplate
    但是现在需要配置多数据源,所以需要自己配置

    DataSourceConfig 中配置了两个数据源,所有此处注入时需要指定名称注入
     */

    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dsOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dsTwo") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
