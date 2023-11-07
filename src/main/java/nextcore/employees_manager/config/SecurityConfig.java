package nextcore.employees_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	private JwtAuthentificationFilter jwtAuthentificationFilter;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and();
		http.sessionManagement().sessionCreationPolicy(STATELESS);
		http.authorizeHttpRequests()
		.requestMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().disable();
		http.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}
