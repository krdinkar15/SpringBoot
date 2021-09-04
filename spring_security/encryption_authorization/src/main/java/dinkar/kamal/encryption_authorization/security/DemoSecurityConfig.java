package dinkar.kamal.encryption_authorization.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("kamal")
                //https://bcrypt-generator.com/
                .password("$2a$12$CEpCnY7MD8SaV89vzkgUTenVwQg2IJ7bP8QI..hMkwTP5ADuwhECq") //raj
                .roles("USER")
                .and()
                .withUser("alpha")
                .password("$2a$12$7Euui2v10FnKw3kr7R/AZO292JFH3mt3uMNaWGz1thP6UAi8ORKGW") //alpha
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPassEncoded()
    {
        return new BCryptPasswordEncoder();
    }

    // Authorization Setting
    public void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
}
