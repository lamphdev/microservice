package lamph11.microservice.common.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"lamph11.microservice.common.config.security"})
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2ResourceServerProperties resourceServerProperties;

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) {
        log.info("Using common security configuration");

        security.csrf().disable();
        security.authorizeExchange(
                auth -> auth.anyExchange().permitAll()
        );
        security.httpBasic().disable();
        security.oauth2ResourceServer(
                resource -> resource.jwt(
                        jwt -> jwt.jwkSetUri(getJwkUri())
                )
        );
        return security.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


    private String getJwkUri() {
        if (resourceServerProperties.getJwt().getJwkSetUri() == null) {
            return "http://localhost:8083";
        }
        return resourceServerProperties.getJwt().getJwkSetUri();
    }

}
