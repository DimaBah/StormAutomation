package project.by.stormnet.functional.tests.factory;

import org.testng.annotations.Factory;
import project.by.stormnet.functional.tests.DependentTestExample;

public class TestFactory {
    @Factory
    public Object[] factoryMethod(){
        return new Object[]{new DependentTestExample(1), new DependentTestExample(2)};
    }
}
