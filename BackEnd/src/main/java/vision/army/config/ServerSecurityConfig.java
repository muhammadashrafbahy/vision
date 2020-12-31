package vision.army.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailsService;

    public ServerSecurityConfig(
            UserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }


@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"
                ,"/vision/register/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**","/font/**","/js/**", "/images/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/vision/register/**").permitAll()
//                .antMatchers("/vision/login/**").permitAll()
                .and().formLogin().loginPage("/vision/login").successForwardUrl("/").permitAll()
                .and().logout().logoutSuccessUrl("/vision/login");

    }
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//    http
//            .antMatcher("/**")
//            .authorizeRequests()
//            .antMatchers("/oauth/authorize**", "/login**", "/error**","/vision/register/**")
//            .permitAll()
//            .and()
//            .authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll();
//}


//    @Override
//    public void configure(WebSecurity web) {
//        ApplicationContext applicationContext = getApplicationContext();
//        Environment environment = applicationContext.getEnvironment();
//        boolean ignoreSwaggerResources = Stream.of(environment.getActiveProfiles())
//                .anyMatch(profile -> Objects.equals(profile, "dev") || Objects.equals(profile, "stage"));
//        if (ignoreSwaggerResources) {
//            web.ignoring()
//                    .antMatchers("/documentation/**",
//                            "/v2/api-docs",
//                            "/configuration/ui",
//                            "/swagger-resources/**",
//                            "/configuration/**",
//                            "/swagger-ui.html",
//                            "/webjars/**",
//                            "/swagger/**",
//                            "/vision/product/**",
//                            "/vision/register/**");
//        }
//    }



}