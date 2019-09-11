package top.timebook;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import top.timebook.listener.CustomerListener02;

/**
 * @author xiongzl
 **/
@Listeners(CustomerListener02.class)
public class TestNG_Listener02 {

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }


}
