package lamph11.microservice.common.config;

import lamph11.microservice.common.config.security.SecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({SecurityConfig.class})
public @interface EnableCommonSecurity {
}
