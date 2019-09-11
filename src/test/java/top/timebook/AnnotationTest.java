package top.timebook;

import org.testng.annotations.*;
import top.timebook.base.BaseSuite;

public class AnnotationTest extends BaseSuite {
    
    /**
     * 执行结果:
     * beforeClass
     * beforeMethod
     * test01
     * afterMethod
     * beforeMethod
     * test02
     * afterMethod
     * afterClass
     * @BeforeClass: 在类中第一个被执行
     * @AfterClass: 在类中最后一个被执行
     * @BeforeMethod: 在每一个@Test之前执行
     * @AfterMethod: 在每一个@Test之后执行
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

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }
}