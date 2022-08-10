package com.example.FlatironSpring.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletResponse;
import java.security.cert.Extension;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/crypto").permitAll();


        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout();

        return http.build();
    }

    @Bean UserDetailsService udService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        String username = "CondorGleason";
        String password = "condor92";
        UserDetails user1 = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .authorities("read")
                .build();

        userDetailsService.createUser(user1);

        username = "AbdellaS";
        password = "naruto";
        UserDetails user2 = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .authorities("read")
                .build();

        userDetailsService.createUser(user2);

        return userDetailsService;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

}
