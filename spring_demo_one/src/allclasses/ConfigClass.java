package allclasses;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan("allclasses")
public class ConfigClass
{
    @Bean
    public AppolloTyre depend()
    {
        return new AppolloTyre();
    }

    @Bean
    public car audi()
    {
        return new Audi(depend());
    }



}
