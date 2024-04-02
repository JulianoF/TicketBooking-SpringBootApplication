package net.group18.TicketApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import net.group18.TicketApplication.service.CustomUserDetailsService;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

     
    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        AuthenticationManager authenticationManager = new ProviderManager(authProvider);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authenticationManager;
    }

 
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        // Disable CSRF protection
        http.csrf().disable();
                 
        http.authorizeHttpRequests(auth ->
            auth.requestMatchers("/pastbooking").authenticated()
            .anyRequest()
            .permitAll() 
            ) 
            .formLogin(login ->
                login
                .loginPage("/login")
                .usernameParameter("email")
                //.defaultSuccessUrl("/booking")
                .permitAll()
            )
            .rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret"))
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll().deleteCookies("JSESSIONID")
        ); 

            // Configure session management
         http.sessionManagement(session ->
            session.sessionAuthenticationStrategy(sessionAuthenticationStrategy())
        ); 



        
        return http.build();
    }  

    private AuthorizationDecision denyAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'denyAll'");
    }


    private AuthorizationDecision permitAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'permitAll'");
    }


    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        // Use SessionFixationProtectionStrategy to prevent session fixation attacks
        return new SessionFixationProtectionStrategy();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}