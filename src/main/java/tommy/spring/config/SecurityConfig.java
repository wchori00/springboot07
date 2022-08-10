package tommy.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		security.csrf().disable();
//		security.formLogin();
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		security.userDetailsService(boardUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication().withUser("manager").password("{noop}manager123").roles("MANAGER");
////		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
//		String query1 = "select id username, concat('{noop}', password) password, 'Y' enabled from mymember where id=?";
//		String query2 = "select id, role from mymember where id=?";
//		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query1).authoritiesByUsernameQuery(query2);
//	}
	
}
