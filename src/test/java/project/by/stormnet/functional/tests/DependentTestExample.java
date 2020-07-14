package project.by.stormnet.functional.tests;

import org.testng.annotations.Test;

public class DependentTestExample {
    private int param;

    public DependentTestExample(int param) {
        this.param = param;
    }

    @Test(dependsOnMethods = {"depMethod2"})
    public void depMethod1(){
        System.out.println("This is depMethod1 with param " + param);
    }

    @Test
    public void depMethod2(){
        System.out.println("This is depMethod2 with param " + ++param);
    }
}
