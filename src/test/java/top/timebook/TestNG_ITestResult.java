package top.timebook;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_ITestResult {
    
    /**
     * ITestResult: 可以获得上一个Test执行的结果
     **/

    @Test
    public void test01(){
        System.out.println("test01");
        Assert.assertTrue(false);
    }

    @Test
    public void test02(){
        System.out.println("test02");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void afterClass(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("失败: " + result.getMethod().getMethodName());
        } else {
            System.out.println("成功: " + result.getName());
        }
    }



}
