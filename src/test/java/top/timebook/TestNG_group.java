package top.timebook;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_group {

    /**
     * 学习TestNG如何进行分组运行,(testng_group.xml)
     * 分组运行之后, beforeClass, afterClass并不会运行,
     * 所以我们需要在其注解上加上alwaysRun
     **/

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("afterClass");
    }

    @Test(groups = {"car", "suv"})
    public void testBMW() {
        System.out.println("testBMW");
    }

    @Test(groups = {"car", "sedan"})
    public void testAudi() {
        System.out.println("testAudi");
    }

    @Test(groups = {"bike"})
    public void testNinja() {
        System.out.println("testNinja");
    }

    @Test(groups = {"bike"})
    public void testHonda() {
        System.out.println("testHonda");
    }

}
