package com.dev.hi.slow.auth.configuration;

import com.dev.hi.slow.auth.role.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class JwtSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests(auth ->
                        auth
                                .antMatchers(HttpMethod.GET, "/foo/**").hasAuthority(Role.READ.toString())
                                .antMatchers(HttpMethod.POST, "/foos").hasAuthority(Role.WRITE.toString())
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }
}
