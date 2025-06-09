package ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_InvocationCount {

    @Test(invocationCount = 3)
    //invocation count is used to provide how many times we want to execute the code
    public void test01(){

        System.out.println("hi");
    }

    @Test(invocationCount = 2)
    public void test02(){

        System.out.println("hi");
    }
}
