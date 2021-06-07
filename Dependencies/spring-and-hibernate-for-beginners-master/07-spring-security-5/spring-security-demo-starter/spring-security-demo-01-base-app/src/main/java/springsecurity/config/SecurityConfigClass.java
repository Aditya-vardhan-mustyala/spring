package springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfigClass extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private DataSource ds;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication().dataSource(ds);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
			.antMatchers("/").hasRole("STUDENT")
			.antMatchers("/teachers").hasRole("TEACHER")
			.antMatchers("/admins").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showlogin")
				.loginProcessingUrl("/processlogin")
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/accessdenied");
	}
	
	
	

}
