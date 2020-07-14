package project.by.stormnet.functional.tests.parallel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTestClass2 {
    @BeforeClass
    public void before(){
        long id = Thread.currentThread().getId();
        System.out.println("Before test method. Thred id is: " + id);
    }

    @Test
    public void method21(){
        long id = Thread.currentThread().getId();
        System.out.println("Method21 thread id is: " + id);
    }

    @Test
    public void method22(){
        long id = Thread.currentThread().getId();
        System.out.println("Method22 thread id is: " + id);
    }

    @AfterClass
    public void after(){
        long id = Thread.currentThread().getId();
        System.out.println("After method id is:" + id);
    }
}
