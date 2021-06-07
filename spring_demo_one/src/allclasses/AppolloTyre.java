package allclasses;

import allclasses.tyre;
import org.springframework.stereotype.Component;


//@Component
public class AppolloTyre implements tyre {

    AppolloTyre()
    {
        System.out.println("allclasses.tyre constructor");
    }
    @Override
    public String getTyre() {
        return "this is appollo";
    }
}
