package project.by.stormnet.functional.tests.parallel;

import org.testng.annotations.*;

public class ParallelTestClass1 {

    @BeforeClass
    public void before(){
        long id = Thread.currentThread().getId();
        System.out.println("Before test method. Thred id is: " + id);
    }

    @Test
    public void method1(){
        long id = Thread.currentThread().getId();
        System.out.println("Method1 thread id is: " + id);
    }

    @Test
    public void method2(){
        long id = Thread.currentThread().getId();
        System.out.println("Method2 thread id is: " + id);
    }

    @AfterClass
    public void after(){
        long id = Thread.currentThread().getId();
        System.out.println("After method id is:" + id);
    }
}
