package dinkar.kamal.encryption_authorization.security;

import dinkar.kamal.encryption_authorization.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserInfoService userInfoService;
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
            //        auth.inMemoryAuthentication()
            //                .withUser("kamal")
            //                //https://bcrypt-generator.com/
            //                .password("$2a$12$CEpCnY7MD8SaV89vzkgUTenVwQg2IJ7bP8QI..hMkwTP5ADuwhECq") //raj
            //                .roles("USER")
            //                .and()
            //                .withUser("alpha")
            //                .password("$2a$12$7Euui2v10FnKw3kr7R/AZO292JFH3mt3uMNaWGz1thP6UAi8ORKGW") //alpha
            //                .roles("ADMIN");
        auth.userDetailsService(userInfoService);
    }
    @Bean
    public PasswordEncoder getPassEncoded()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    // Authorization Setting
    public void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
}
