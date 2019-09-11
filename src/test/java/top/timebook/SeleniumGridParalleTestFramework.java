package top.timebook;

import org.testng.annotations.Test;

public class SeleniumGridParalleTestFramework extends TestSuiteBase{

	@Test
	public void test() throws Exception {
		search.setKeyWord("java");
		search.clickSearchButton();
//		Thread.sleep(3000);
//		search.clickFight();
//		search.clickFightTab();
//		search.setOriginCity("北京, 中国 (PEK-首都国际机场)");
//		search.setDestinationCity("上海, 中国 (SHA-虹桥国际机场)");
//		search.setDeaprtureDate("2018/04/29");
//		search.clickCalendar();
	}


}