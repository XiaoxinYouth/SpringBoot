package thymeleaf.sp1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("thymeleaf.sp1.dao")
public class Sp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sp1Application.class, args);
    }

}
