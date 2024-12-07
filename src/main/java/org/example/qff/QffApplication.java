package org.example.qff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HUAWEI
 */
/*扫描包 scanBasePackages*/
@SpringBootApplication
public class QffApplication {

    public static void main(String[] args) {
        SpringApplication.run(QffApplication.class, args);
    }

}
