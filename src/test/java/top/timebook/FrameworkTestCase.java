package top.timebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	private static final String DRIVER_PATH = "E:\\project\\testNG-demo\\chromedriver.exe";

	@BeforeClass
	public void beforeClass() {
		setWebDriver();
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia-cn.com/";
		searchPage = new SearchPageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		Thread.sleep(3000);
		searchPage.clickFight();
		searchPage.clickFightTab();
		searchPage.setOriginCity("北京, 中国 (PEK-首都国际机场)");
		searchPage.setDestinationCity("上海, 中国 (SHA-虹桥国际机场)");
		searchPage.setDeaprtureDate("2018/04/29");
		searchPage.clickCalendar();
//		searchPage.clickSearchButton();
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


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}