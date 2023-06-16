package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
    @EnableWebSecurity
    public class SecSecurityConfig {

    @Autowired
    private DataSource dataSource;


    @Bean
    public void  userDetailsService() {
        UserDetails doctor = User.withUsername("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("Doctor")
                .build();
        UserDetails pacient = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("Pacient")
                .build();




    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.ejs")
                .failureUrl("/login.html?error=true");
        return http.build();
    }

    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery("select login as username, password, confirmed as enabled from network_user where login = ?")
                .authoritiesByUsernameQuery("select login as username, " +
                        "CASE WHEN role_id = 1 THEN 'ROLE_ADMIN' ELSE 'ROLE_USER' END as role " +
                        "from network_user where login=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }


    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/404").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/**").access("hasRole('role')").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("login")
                .passwordParameter("password")
                .and().logout()
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/login?error");
    }
}
