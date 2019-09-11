package top.timebook.listener;

import org.testng.*;

import java.util.Map;

/**
 * @author xiongzl
 **/
public class CustomerListener03 implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        // 在suite执行开始之前开始执行
        System.out.println("suite: start");
        Map<String, ISuiteResult> results = suite.getResults();
        for (Map.Entry<String, ISuiteResult> iSuiteResultEntry : results.entrySet()) {
            String key = iSuiteResultEntry.getKey();
            ISuiteResult value = iSuiteResultEntry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("suite: finish");
    }
}
