package com.example.spring_security.security;

import com.example.spring_security.auth.ApplicationUserService;
import com.example.spring_security.jwt.JwtConfig;
import com.example.spring_security.jwt.JwtTokenVerifier;
import com.example.spring_security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // to enable use @PreAuthorize in controller
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final ApplicationUserService applicationUserService;

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService, SecretKey secretKey, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }


    /**
     * instead of default login form in path /login --> it provides the login request in popup login dialog in web browser.
     * <p>
     * hasRole is role-based authentication , hasAuthority is permission-based authentication
     * <p>
     * .antMatchers("/","index","/css/*","/js/*") dont request username/password every time you login in path localhost:8080/index.html or css or...
     * <p>
     * .antMatchers ---> These expressions are responsible for defining the access control or authorization to specific URLs or methods in your application.
     * <p>
     * csrf --> Cross-Site Request Forgery
     * <p>
     * the order of antMatchers that you write is important. the users is go down and check one by one in antMatchers.
     * if in one matcher block then will not continue
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) //X-XSRF-TOKEN header name
                .and()*/

                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name()) // only student can access this api path

                /*      .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                      .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                      .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                      .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
                      */

                .anyRequest()
                .authenticated();


                /*.and()
                //        .httpBasic();  with basic you can't logout
                .formLogin()
                .loginPage("/login").permitAll() // load your own login form
                .defaultSuccessUrl("/courses", true) // redirect to page if auth is ok
                .passwordParameter("password") // there are change the HTML 'name' attribute of these fields...<input type="password" id="password" name="password">
                .usernameParameter("username")

                .and()
                .rememberMe() // defaults to 2 weeks.
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // expires after 21 day
                .key("somethingverysecured")//
                .rememberMeParameter("remember-me")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // if csrf() is disable you can use any http method But if not delete this line. you should use POST for prevent csrf attacks.
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login")*/

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }


    /**
     * The UserDetailsService interface is used to retrieve user-related data.
     * It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user.
     */
/*    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails faramarzUser = User.builder()
                .username("faramarz")
                .password(passwordEncoder.encode("password"))
                //.roles(ApplicationUserRole.STUDENT.name())
                .authorities(ApplicationUserRole.STUDENT.grantedAuthorities())
                .build();


        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                //.roles(ApplicationUserRole.ADMIN.name())
                .authorities(ApplicationUserRole.ADMIN.grantedAuthorities())
                .build();


        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
                //.roles(ApplicationUserRole.ADMINTRAINE.name())
                .authorities(ApplicationUserRole.ADMINTRAINEE.grantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(faramarzUser, lindaUser, tomUser);
    }*/


}
