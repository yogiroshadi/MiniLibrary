package com.technical.configuration;

import com.technical.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class RestSecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //function ini atau antMatcher ini akan mengambil nilai role dari securitycontextholder
        http.antMatcher("/api/**").csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/account/authenticate", "/api/customer/register").permitAll()
                .antMatchers("/api/book", "/api/customer/update").hasAuthority("Customer")
                .antMatchers("/api/book/**", "/api/category/**").hasAuthority("Admin")
                .anyRequest().authenticated()
                .and()
                .httpBasic() //digunakan untuk membuat kodingan kita memiliki HttpBasic setting
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
