package thymeleaf.sp1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : 小新青年
 * @date : 2019-11-23  22:10
 * 描述 : Account 实体类
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
