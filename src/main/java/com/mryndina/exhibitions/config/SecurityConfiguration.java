package com.mryndina.exhibitions.config;

import com.mryndina.exhibitions.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/exhibitions", "/exhibitions/*", "/register", "/h2-console/*", "/css/*", "/ping", "/display", "/add", "/al").permitAll()
                .antMatchers("/admin", "/admin/*").hasAuthority("ADMIN")
                .antMatchers("/organizer","/organizer/*").hasAuthority("ORGANIZER")
                .antMatchers("/modeller","/modeller*").hasAuthority("MODELLER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signin").permitAll()
                .successHandler((request, response, authentication) -> {
                    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                        response.sendRedirect("/admin");
                    } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ORGANIZER"))) {
                        response.sendRedirect("/organizer");
                    } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("MODELLER"))) {
                        response.sendRedirect("/modeller/model");
                    } else {
                        response.sendRedirect("/");
                    }
                })
                .failureUrl("/bad-credentials")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
                .logoutSuccessUrl("/")
                .permitAll();

        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
