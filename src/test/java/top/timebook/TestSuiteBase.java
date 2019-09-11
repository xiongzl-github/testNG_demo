package top.timebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author xiongzl
 **/
public class TestSuiteBase {
    protected RemoteWebDriver driver;
    protected BaiDuPageModel search;

    public static RemoteWebDriver getDriverInstance(String url, String nodeUrl)
            throws MalformedURLException {
        RemoteWebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(Boolean.TRUE);
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("disable-dev-shm-usage");
        chromeOptions.addArguments("blink-settings=imagesEnabled=false");
        chromeOptions.addArguments("disable-gpu");
        driver = new RemoteWebDriver(new URL(nodeUrl), chromeOptions);
        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the Application
        driver.get(url);
        return driver;
    }

    @Parameters({"url", "node_url"})
    @BeforeClass(alwaysRun = true)
    public void setup(String url, String node_url) throws MalformedURLException {
        driver = getDriverInstance(url, node_url);
        search = PageFactory.initElements(driver, BaiDuPageModel.class);
    }

    @AfterClass
    public void afterClass(ITestContext context) {
        SessionId sessionId = driver.getSessionId();
        System.out.println("sessionId = " + sessionId);
        driver.quit();
    }
}
