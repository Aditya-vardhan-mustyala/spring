package springsecurity.config;

import java.beans.PropertyVetoException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages="springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class ConfigClass 
{
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource ds()
	{
		ComboPooledDataSource ds=new ComboPooledDataSource();
	
		try
		{
			ds.setDriverClass(env.getProperty("jdbc.driver"));
		}catch(PropertyVetoException e)
		{
			System.out.println(e);
			throw new RuntimeException(e);
		}
		
		System.out.println(env.getProperty("jdbc.url")+env.getProperty("jdbc.user"));
	
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		
		ds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		ds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		ds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		ds.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return ds;
	
	}
	
	
	


	@Bean
	public ViewResolver views()
	{
		InternalResourceViewResolver vr=new  InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
