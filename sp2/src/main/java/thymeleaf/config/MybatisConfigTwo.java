package thymeleaf.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author : 小新青年
 * @date : 2019-11-25  17:15
 * 描述 : Mybatis 配置多数据源1
 **/
@Configuration
@MapperScan(value = "thymeleaf.mapper2",sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MybatisConfigTwo {
    @Resource(name = "dsTwo")
    private DataSource dsTwo;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsTwo);
        return factoryBean.getObject();
    }
}
