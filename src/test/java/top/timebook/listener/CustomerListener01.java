package top.timebook.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * @author xiongzl
 **/
public class CustomerListener01 implements IInvokedMethodListener {

    /**
     * 监听器会在每个方法之前运行
     **/

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("CustomerListener01:beforeInvocation" + testResult.getTestClass().getName() + ", " + testResult.getMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("CustomerListener01:afterInvocation" + testResult.getTestClass().getName() + ", " + testResult.getMethod().getMethodName());
    }
}
