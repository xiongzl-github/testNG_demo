package top.timebook;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_Dependency {

    /**
     * 测试方法之间可以存在依赖关系
     * 被依赖的方法先执行, 没有依赖的方法先执行
     * 如果被依赖的方法出错, 依赖它的方法将被跳过, 除非加上alwaysRun=true属性
     **/

    Arithmetic arithmetic;

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
        arithmetic = new Arithmetic();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @Test(dependsOnMethods = {"test03"}, alwaysRun = true)
    public void test01() {
        System.out.println("test01");
    }
    @Test
    public void test02() {
        System.out.println("test02");
        int result = arithmetic.add(1, 2);
        Assert.assertEquals(result, 2);
    }
    @Test(dependsOnMethods = {"test02"})
    public void test03() {
        System.out.println("test03");
    }
    @Test
    public void test04() {
        System.out.println("test04");
    }




}
