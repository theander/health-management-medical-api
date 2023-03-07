package com.healthmanagement.service.security;

import com.healthmanagement.service.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/api/**").permitAll();
        http.authorizeHttpRequests().antMatchers(HttpMethod.POST,"/api/**").permitAll();
        http.authorizeHttpRequests().antMatchers(HttpMethod.PUT,"/api/**").permitAll();

        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/v3/**").permitAll();
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll();
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("ROLE_MEDICAL");
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}

