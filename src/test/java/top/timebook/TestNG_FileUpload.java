package top.timebook;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiongzl
 **/
public class TestNG_FileUpload {

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
    private void loginTest() throws InterruptedException, AWTException, IOException {
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
        // 点击写信按钮
        test.log(LogStatus.INFO, "点击写信");
        webDriver.findElement(By.xpath("//span[text()='写 信']")).click();
        // 填写收件人地址
        test.log(LogStatus.INFO, "输入收信人地址");
        webDriver.findElement(By.xpath("//input[@class='nui-editableAddr-ipt']")).sendKeys("1025567263@qq.com");
        // 填写主题
        test.log(LogStatus.INFO, "输入主题");
        webDriver.findElement(By.xpath("//div[@aria-label='邮件主题输入框，请输入邮件主题']/input[@class='nui-ipt-input']")).sendKeys("test upload attachment function");
        // 点击添加附件按钮
        test.log(LogStatus.INFO, "点击添加附件");
        WebElement element = webDriver.findElement(By.xpath("//a[@class='cb0 nui-txt-link']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().perform();

        // 使用AutoIT完成对附件的添加
        test.log(LogStatus.INFO, "使用AutoIT完成对附件的添加");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("E:\\project\\testNG-demo\\email_attach_upload.exe");
        Thread.sleep(2000);
        // 点击发送邮件
        webDriver.findElements(By.xpath("//span[contains(text(), '发送') and contains(@class, 'nui-btn-text')]")).get(0).click();
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
