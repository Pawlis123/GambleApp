package gamblenewstart.demo.Security;


import gamblenewstart.demo.Filters.JwtRequestFilter;
import gamblenewstart.demo.Repository.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetails myUserDetails;
    private final JwtRequestFilter jwtRequestFilter;



    @Autowired
    public SecurityConfig(MyUserDetails myUserDetails, JwtRequestFilter jwtRequestFilter) {
        this.myUserDetails = myUserDetails;
        this.jwtRequestFilter = jwtRequestFilter;

    }

    public SecurityConfig(boolean disableDefaults, MyUserDetails myUserDetails, JwtRequestFilter jwtRequestFilter) {
        super(disableDefaults);
        this.myUserDetails = myUserDetails;
        this.jwtRequestFilter = jwtRequestFilter;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")
                .permitAll()//pozwalamy aby każdy miał dostęp do tego endpointa
                .antMatchers("/register")
                .permitAll()
                .anyRequest()
                .authenticated()// do reszty trzeba uatoryzacji jwt
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //jwt z założenia jest beststanowe zatem ustawiamy aby spring nie zajmował się sesjami


             http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // jako że nie ma sesji, to ta linijka

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

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    // ustawiamy skąd mają byc pobierani użytkownicy do logowania
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetails).passwordEncoder(new BCryptPasswordEncoder());
    }






}
