package ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_AlwaysRun {

    @Test
    public void test01(){

        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test02(){

        Assert.assertTrue(true);
    }

    @Test
    public void test03(){

        Assert.assertTrue(true);
    }
}

// testNG provides many concepts and we will use only the one which are useful