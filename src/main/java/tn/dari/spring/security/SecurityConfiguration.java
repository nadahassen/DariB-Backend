package tn.dari.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tn.dari.spring.jwt.JwtFilter;
import tn.dari.spring.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@CrossOrigin(origins = "http://localhost:4200")


public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService);
	}

	private static final String[] AUTH_WHITELIST = { "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs",
			"/webjars/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/authenticate", "/chat-websocket","/chat-websocket/**","/registration").permitAll()
//	http.csrf().disable().authorizeRequests().antMatchers("/authenticate", "/chat-websocket","/registration/**").permitAll()
//
//		.anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
//c'est la complete si on la decomme
		http.csrf().disable();
		http.authorizeRequests()
//		.antMatchers("/").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_ACHETEUR", "ROLE_VENDEUR","ROLE_BAILLEUR","ROLE_LOCATAIRE")
//        .antMatchers("/user/allUsers").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_ACHETEUR", "ROLE_VENDEUR","ROLE_BAILLEUR","ROLE_LOCATAIRE")
        .anyRequest().permitAll();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


}

	public class WebMvcCofig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/*").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
					.allowCredentials(true);
		}

	}
}