package com.example.blog.config;

import com.example.blog.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                .antMatchers("/blog/list").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                .antMatchers("/blog/create").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/blog/delete/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/blog/view/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/blog/edit/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/blog/search").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/category/list").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                .antMatchers("/category/create").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/category/delete/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/category/view/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/category/edit/**").hasAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and().exceptionHandling().accessDeniedPage("/403");


        http.csrf().disable();

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/login").permitAll();

        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/blog/list",
                "/blog/view/**",
                "/category/list",
                "/blog/search",
                "/category/view/**",
                "/user").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/blog/create",
                "/blog/delete/**",
                "/blog/edit/**",
                "/category/create",
                "/category/delete/**",
                "/category/edit/**").access("hasRole('ROLE_ADMIN')");

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/blog/list")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

        // Cấu hình Remember Me.
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}