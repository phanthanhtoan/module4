package com.case_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("member").password("{noop}12345").roles("MEMBER")
//                .and()
//                .withUser("admin").password("{noop}12345").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/user**", "/customer", "/employee").hasRole("MEMBER")
//                .and()
//                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }




////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
////    }
//
// login v?? ph??n quy???n
    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //C???u h??nh cho c??c ??u??ng d???n kh??ng c???n x??c th???c(????ng nh???p)
                .antMatchers("/", "/login", "/register").permitAll()
                //C???u h??nh cho c??c ???????ng d???n ????ng nh???p b???ng Role l?? Member, Admin
                .antMatchers("/member/**").hasAnyRole("MEMBER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                //c???u h??nh cho ???????ng d???n admin, ch??? c?? Role admin m???i v??o ???????c
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                //formlogin
                .formLogin()
                //???????ng d???n tr??? v??? trang authentication
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //N???u authentication th??nh c??ng
                .defaultSuccessUrl("/")
                //N???u authentication th???t b???i
                .failureUrl("/login?error")
                //N???u authentication th??nh c??ng nh??ng v??o trang kh??ng ????ng role
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/").permitAll()
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
        ;

        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}