package allclasses;

import allclasses.car;
import allclasses.tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Audi implements car {
    private tyre company;

    //@Autowired
    Audi(tyre type)
    {

        System.out.println("this is audi constructor");
        this.company=type;
    }
    @Override
    public void getName() {
        System.out.println("this is audi allclasses.car");
    }

    @Override
    public void getTyre() {
        System.out.println(company.getTyre());
    }
}
