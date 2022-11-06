package com.site.uclass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.site.uclass.services.AccountService;


@Configuration
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/new_announcement").hasRole("PROFESSOR")
            .antMatchers("/registeredCourses").hasRole("STUDENT")
            .antMatchers("/login")
            .permitAll()
        .anyRequest()
            .authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .and()
        .logout()
        .logoutSuccessUrl("/login");
        
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                        .antMatchers("/resources/**", "static/**", "/images/*", "/styles/*", "/h2-console/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();//new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AccountService();
    }
}