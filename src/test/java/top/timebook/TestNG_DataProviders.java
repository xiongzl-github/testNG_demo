package top.timebook;
import	java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author xiongzl
 **/
public class TestNG_DataProviders {

    /**
     * DataProvider: 可以为@Test提供测试数据
     **/

    @DataProvider(name = "param")
    public Object[][] getData() {
        return new Object[][]{
                {"apple", "red"},
                {"orange", "yellow"},
                {"watermelon", "green"}
        };
    }

    @DataProvider(name = "p")
    public Object[] getObj() {
        return new Object[]{
                "apple", "orange", "pear"
        };
    }
    @DataProvider(name = "p2")
    public Iterator<Object> getObjs() {
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        Iterator<Object> iterator = objects.iterator();
        return iterator;
    }

    @Test(dataProvider = "param")
    public void test01(String param01, String param02) {
        System.out.println("param01 = " + param01);
        System.out.println("param02 = " + param02);
    }

    @Test(dataProvider = "p")
    public void test02(String param) {
        System.out.println("param = " + param);
    }

    @Test(dataProvider = "p2")
    public void test04(Object param) {
        System.out.println("param = " + param);
    }

    @Test(dataProviderClass = TestNG_DataProvider.class, dataProvider = "userLogin")
    public void test03(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
