package top.timebook.base;

import org.testng.annotations.*;

/**
 * @author xiongzl
 **/
public class BaseSuite {

    @BeforeClass
    public void beforeClass() {
        System.out.println("BaseSuit=================>beforeClass");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("BaseSuit=================>afterClass");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("BaseSuit=================>beforeTest");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("BaseSuit=================>afterTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BaseSuit=================>beforeSuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("BaseSuit=================>afterSuite");
    }




}
