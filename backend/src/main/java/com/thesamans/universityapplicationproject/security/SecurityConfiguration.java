package com.thesamans.universityapplicationproject.security;

import com.thesamans.universityapplicationproject.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity // added for web applications
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    // reference to database auto injected
//    @Autowired
//    DataSource dataSource;
    // however when using jpa use UserDetailsService
    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    // TODO: Set up who passwords should be encoded
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Connects roles to requests they can make (Authorisation)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/test").permitAll()
                .antMatchers("/user").hasRole("ADMIN")
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin();
    }
}
