package top.timebook.listener;

import org.testng.*;

/**
 * @author xiongzl
 **/
public class CustomerListener02 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // 在@Test修饰的方法之前运行
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // 在@Test修饰的方法成功之后运行
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // 在@Test修饰的方法失败之后运行
        System.out.println("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // 在@Test修饰的方法被跳过之后运行
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // 忽略
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // 在@Test修饰的方法Timeout之后执行
    }

    @Override
    public void onStart(ITestContext context) {
        // 在xml文件中Test标签开始之前运行
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        // 在xml文件中Test标签结束之后运行
        System.out.println("onFinish");
    }
}
