package top.timebook;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author xiongzl
 **/
public class TestNG_Report_Login {

    private ExtentReports report;

    private ExtentTest test;

    private WebDriver webDriver;

    private static final String REPORT_PATH = "D:\\Reports\\login.html";

    private static final String URL = "https://mail.163.com/";

    private static final String DRIVER_PATH = "E:\\project\\testNG-demo\\chromedriver.exe";

    @BeforeClass
    private void beforeClass() {
        setWebDriver();
        report = new ExtentReports(REPORT_PATH);
        test = report.startTest("验证登陆是否成功");
        test.log(LogStatus.INFO, "浏览器开始初始话");
        webDriver = getWebDriver(new ChromeDriver());
        test.log(LogStatus.INFO, "浏览器初始话完成");
    }

    @Test
    private void loginTest() throws InterruptedException {
        String username = "";
        // 点击账号登陆
        webDriver.findElement(By.id("switchAccountLogin")).click();
        test.log(LogStatus.INFO, "点击账号登陆");
        // 进入iframe
        webDriver.switchTo().frame(0);
        // 输入用户名
        webDriver.findElement(By.xpath("//div[@class='u-input box']/input[@name='email']")).sendKeys("xiongzl666");
        test.log(LogStatus.INFO, "输入用户名");
        Thread.sleep(2000);
        // 输入密码
        webDriver.findElement(By.xpath("//div[@class='u-input box']/input[@name='password']")).sendKeys("15392714349xzl");
        test.log(LogStatus.INFO, "输入密码");
        Thread.sleep(2000);
        // 点击登陆
        webDriver.findElement(By.id("dologin")).click();
        test.log(LogStatus.INFO, "点击登陆");
        Thread.sleep(3000);
        try {
            username = webDriver.findElement(By.id("spnUid")).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (username.isEmpty()) {
            Assert.assertTrue(false);
            test.log(LogStatus.FAIL, "登陆失败");
        } else {
            Assert.assertTrue(true);
            test.log(LogStatus.PASS, "登陆成功");
        }
    }

    /**
     * 设置WebDriver
     *
     * @return void
     * @author xiongzl
     * @date 2019/8/29 11:25
     **/
    private void setWebDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, DRIVER_PATH);
    }

    /**
     * 初始化WebDriver
     *
     * @param webDriver a webDriver
     * @return org.openqa.selenium.WebDriver
     * @author xiongzl
     * @date 2019/8/29 11:25
     **/
    private WebDriver getWebDriver(WebDriver webDriver) {
        // 定位到目标url
        webDriver.get(URL);
        // 使测试窗口最大化
        webDriver.manage().window().maximize();
        // 使用隐式等待(隐式等待对页面上所有元素都适用, 对加载慢的元素其都会等待3秒钟)
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return webDriver;
    }

    @AfterClass
    private void afterClass() {
        webDriver.quit();
        report.endTest(test);
        report.flush();
    }

}
