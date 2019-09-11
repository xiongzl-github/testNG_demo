package top.timebook;

import org.testng.annotations.DataProvider;

/**
 * @author xiongzl
 **/
public class TestNG_DataProvider {

    @DataProvider(name = "userLogin")
    public Object[] provideData() {
        return new Object[][]{
                {"xiongzl666@163.com", "xzl3306"},
                {"qiberlin@163.com", "xzl3306"},
                {"1025567263@qq.com", "xzl3306"}
        };
    }

}
