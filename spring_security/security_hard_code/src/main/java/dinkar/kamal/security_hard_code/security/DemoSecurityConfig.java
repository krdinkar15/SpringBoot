package dinkar.kamal.security_hard_code.security;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("kamal")
                .password("raj")
                .roles("USER")
                .and()
                .withUser("alpha")
                .password("beta")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPassEncoded()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
