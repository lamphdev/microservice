package lamph11.microservice.category;

import lamph11.microservice.common.config.EnableCommonSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCommonSecurity
//@EnableDiscoveryClient
@SpringBootApplication
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class, args);
    }

}
