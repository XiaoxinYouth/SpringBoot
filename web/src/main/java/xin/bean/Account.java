package xin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : 小新青年
 * @date : 2019-11-26  13:12
 * 描述 : Java Bean ;账户的实体类
 **/
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
