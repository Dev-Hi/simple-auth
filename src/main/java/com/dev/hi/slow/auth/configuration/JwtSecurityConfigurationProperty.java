package com.dev.hi.slow.auth.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.oauth2.client")
@Setter @Getter
public class JwtSecurityConfigurationProperty {

    private String clientId;
    private String clientSecret;
    private String introspectionUri;

}
