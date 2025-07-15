package vn.com.iviettech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import vn.com.iviettech.service.CustomUserService;

@Configuration
public class SecurityConfig {


//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("userpass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("adminpass"))
//                .roles("ADMIN", "USER")
//                .build();
//                return new InMemoryUserDetailsManager(user, admin);
//    }

    private final CustomUserService customUserDetailsService;

    public SecurityConfig(CustomUserService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/", "/public/**", "/css/**", "/js/**").permitAll()
                            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")                              .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/admin/**").hasAnyRole("ADMIN")                              .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin.loginPage("/login")
                                .defaultSuccessUrl("/public", true)
                                .permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/public").permitAll());
        return http.build();
    }


}
