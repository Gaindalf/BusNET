package busnet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

//    @Bean(name = "passwordEncoder")
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .and().formLogin().loginPage("/login").permitAll().usernameParameter("j_username")
//                .passwordParameter("j_password").loginProcessingUrl("/j_spring_security_check").failureUrl("/login?error=true")
//                .and()
//                .httpBasic()
//                .and()
//                .authorizeRequests()
                .antMatchers("/confidential/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/index.html").access("hasRole('USER')")
//                .antMatchers("/delete/**").access("hasRole('MASTER')")
//                .antMatchers("/friends/**").access("hasRole('USER')")
//                .antMatchers("/invites/**").access("hasRole('USER')")
//                .antMatchers("/searchFriends/**").access("hasRole('USER')")
//                .antMatchers("/truncate").access("hasRole('DIRECTOR')")
//                .antMatchers("/backup/**").access("hasRole('BACKUP')")
//                .antMatchers("/profile/**").access("hasRole('USER')")
//                .antMatchers("/chat/**").access("hasRole('USER')")
//                .antMatchers("/messages/**").access("hasRole('USER')")
//                .antMatchers("/userNews/**").access("hasRole('USER')")
//                .antMatchers("/allWorkgroups/**").access("hasRole('USER')")
//                .antMatchers("/workgroup/**").access("hasRole('USER')")
//                .antMatchers("/workgroupEdit/**").access("hasRole('USER')")
                .and().formLogin().defaultSuccessUrl("/", false)
//                .defaultSuccessUrl("/profile", false)
//                .and().csrf().disable()
//                .logout().invalidateHttpSession(true).deleteCookies()
        ;
    }

//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
}
