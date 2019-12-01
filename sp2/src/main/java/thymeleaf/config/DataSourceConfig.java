package thymeleaf.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author : 小新青年
 * @date : 2019-11-25  16:16
 * 描述 : 配置数据源
 **/
@Configuration
public class DataSourceConfig {

    /*
    @ConfigurationProperties 注解表示使用不同的前缀的配置文件来创建不同的 DataSource 实例
     */

    @Bean
    @ConfigurationProperties("spring.datasource.one")
    DataSource dsOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.two")
    DataSource dsTwo() {
        return DruidDataSourceBuilder.create().build();
    }
}
