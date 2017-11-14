package com.insclix.mvc.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disabling CSRF as it messes with Errai MessageBus, still need to
        // figure out how to fix it
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").authenticated()
            .and()
                .formLogin()
                    .defaultSuccessUrl("/", true)
                    .loginProcessingUrl("/login")
            .and()
                .logout()
                    .permitAll()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(
            "/service-worker.js",
            "/index.html",
            "/offline/**",
            "/mvc/**",
            "/images/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth
            .inMemoryAuthentication();

        inMemoryAuthentication.withUser("user").password("11").roles("user");
        inMemoryAuthentication.withUser("admin").password("11").roles("admin");
    }
}