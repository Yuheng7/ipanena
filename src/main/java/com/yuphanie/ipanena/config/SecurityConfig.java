package com.yuphanie.ipanena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    DataSourceConfig dataSourceConfig = new DataSourceConfig();
// $2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("**").permitAll()
////                .antMatchers("/UserProfile/**").hasRole("USER")
////                .antMatchers("/account/**").hasRole("USER")
////                .antMatchers("/account/create").permitAll()
//                .and()
//                //when authentication is required, the next two lines REDIRECTS user to login page
//                .formLogin()
//                .loginPage("/index.html").failureUrl("/index.html?error=true")
////                .loginProcessingUrl("/perform_login")
//                // can change it to false if we want to set up custom redirect url i feel
//                .defaultSuccessUrl("/cards", true)
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                //need to invalidate http session and delete cookies otherwise they will REMAIN logged in
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID");
//
////                .logoutSuccessHandler(logoutSuccessHandler());
//
//        //makes it so that post methods aren't forbidden lmao, i dont get it
////        http.cors().and().csrf().disable();
//        http.csrf().disable().authorizeRequests();
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.cors().and()
                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/anonymous*").anonymous()
//                .antMatchers("/index*", "/static/**", "/*.js", "/*.json", "/*.ico").permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index.html")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/login",true)
                .failureUrl("/index.html?error=true")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
        // @formatter:on
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSourceConfig.getDataSource())
        .usersByUsernameQuery(
                "SELECT username, password, enabled FROM account WHERE username=?");
//        .authoritiesByUsernameQuery(
//                "SELECT username, 'ROLE_USER' FROM users WHERE username=?");
    }

    //High key think this is all that's needed to encode passwords
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
