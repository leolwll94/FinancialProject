package com.financialProject.Configuration;


import com.financialProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalAuthentication()
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

    @Autowired
    UserService uServ;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uServ)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

/*
    http

                 .authorizeRequests()
                 .antMatchers( "/h2**", "/h2/**"
                        , "/home"
                        , "/css/**", "/Style.css","/Login.css", "/CadastroUsuario.css"
                        ,"/Login","/", "/user", "/user/save", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();

*/


        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()

                .antMatchers("/h2-console/**").permitAll()


                .antMatchers(
                        "/",
                        "/home",
                        "/Login",
                        "/login",
                        "/template"

                ).permitAll()

                // Endpoints de usuário
                .antMatchers(
                        "/user",
                        "/user/**",
                        "/user/save"
                ).permitAll()

                // Recursos estáticos - MELHOR FORMA
                .antMatchers(
                        "/css/**",
                        "/Style.css",
                        "/Login.css",
                        "/CadastroUsuario.css",
                        "/img/**",
                        "/js/**"

                ).permitAll()


                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/home")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/Login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();


    }


}
