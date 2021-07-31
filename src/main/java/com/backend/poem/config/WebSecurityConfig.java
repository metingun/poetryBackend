package com.backend.poem.config;

import com.backend.poem.auth.JwtTokenFilter;
import com.backend.poem.auth.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    public void configurePasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailService).passwordEncoder(getBCryptPasswordEncoder());
    }
    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().addFilterBefore(corsFilter(), SessionManagementFilter.class);
        // SWAGGER İÇİN KAPATILACAK
        http.authorizeRequests().antMatchers("/login/**").permitAll()
                .antMatchers("/rest/category/getAll").permitAll()
                .antMatchers("/rest/category/getById/**").permitAll()
                .antMatchers("/rest/comment/**").permitAll()
                .antMatchers("/rest/homepage/get").permitAll()
                .antMatchers("/rest/poem/getByCategory/**").permitAll()
                .antMatchers("/rest/poem/getById/**").permitAll()
                .antMatchers("/rest/poem/getPoemsBySearchText/**").permitAll()
                .antMatchers("/rest/poem/getPoemsBySearchTextAndCategoryId/**").permitAll()
                .antMatchers("/rest/poem/getAllByCount").permitAll()
                .antMatchers("/rest/poem/getAll").permitAll()
                .antMatchers("/restful/user/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();

    }

    @Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }
}




