package top.timebook;

import org.testng.annotations.*;
import top.timebook.base.BaseSuite;

public class PriorityTest {
    
    /**
     * 为测试方法添加优先级, 优先级越低, 越先执行
     **/
    

    @BeforeClass
    public void setUp() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void clearUp() {
        System.out.println("afterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @Test(priority = 3)
    public void test01() {
        System.out.println("test01");
    }

    @Test(priority = 0)
    public void test02() {
        System.out.println("test02");
    }
    @Test(priority = 1)
    public void test03() {
        System.out.println("test03");
    }
}