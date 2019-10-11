package com.yuphanie.ipanena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("**").permitAll()
//                .antMatchers("/UserProfile/**").hasRole("USER")
//                .antMatchers("/account/**").hasRole("USER")
//                .antMatchers("/account/create").permitAll()
                .and()
                //when authentication is required, the next two lines REDIRECTS user to login page
                .formLogin()
                .loginPage("/login").failureUrl("/login-error")
                .defaultSuccessUrl("/", true)
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                //need to invalidate http session and delete cookies otherwise they will REMAIN logged in
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

//                .logoutSuccessHandler(logoutSuccessHandler());

        //makes it so that post methods aren't forbidden lmao, i dont get it
        http.cors().and().csrf().disable();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSourceConfig.getDataSource());
    }

    //High key think this is all that's needed to encode passwords
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
