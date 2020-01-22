package org.sid.configs;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

   //bean for spring boot adapter
    @Bean
    public KeycloakSpringBootConfigResolver configResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
