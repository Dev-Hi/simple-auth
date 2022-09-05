package com.dev.hi.slow.auth.configuration;

import com.dev.hi.slow.auth.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@RequiredArgsConstructor
public class JwtSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtSecurityConfigurationProperty property;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests(auth ->
                        auth
                                .antMatchers(HttpMethod.GET, "/foo/**").hasAuthority(Role.READ.toString())
                                .antMatchers(HttpMethod.POST, "/foos").hasAuthority(Role.WRITE.toString())
                                .anyRequest().authenticated()
                ).oauth2ResourceServer(oauth2 ->
                        oauth2.opaqueToken(token ->
                                token.introspectionUri(property.getIntrospectionUri()).introspectionClientCredentials(property.getClientId(), property.getClientSecret())
                        )
                );

    }
}
