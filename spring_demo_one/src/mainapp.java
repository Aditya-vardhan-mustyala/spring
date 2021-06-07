import allclasses.ConfigClass;
import allclasses.car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainapp
{
    public static void main(String [] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
        car obj = context.getBean("audi", car.class);
        obj.getName();
        obj.getTyre();





    }

}
