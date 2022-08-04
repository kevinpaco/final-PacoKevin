package ar.edu.unju.fi.pvisual.security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  //activar la seguridad
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImp userDetails;	
	
	@Autowired
	private UserDetailsServiceImp2 userDetailsEmp;
	
	@Autowired
	private AutenticacionSuccessHandler autentication;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/empleo/**","/include/**","/layer/**","/","/empleador/guardar","/empleador/formulario","/usuario/formulario","/usuario/guardar","/auth/**","/public/**","/image/**","/webjars/**","/css/**","/js/**").permitAll().anyRequest().authenticated()
		.and()
		     .formLogin().loginPage("/empleo/logging").successHandler(autentication).failureUrl("/empleo/logging?error=true").usernameParameter("dni").passwordParameter("password")
		     .loginProcessingUrl("/auth/login-post").permitAll()
		     .and()
		          .logout().logoutUrl("/logout").logoutSuccessUrl("/empleo/logging");
	   
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}

	
}
