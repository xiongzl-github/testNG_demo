package top.timebook;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_Praameters {
    
    /**
     * Parameters: 可以读取xml中提供的参数
     **/

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void beforeClass(String browser, String platform) {
        System.out.println("parameter from xml: " + browser + ", " + platform);
    }

    @Test
    @Parameters({"response"})
    public void test(String response){
        System.out.println("parameter from xml: " + response);
    }

}
