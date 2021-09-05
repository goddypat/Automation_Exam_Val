package testNG_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.PageTest;

import util.BrowserFactory;

public class ValidateMonth {
	


	WebDriver driver;
	PageTest testPage;

	@Test
	public void ValidateMonthTest() {
		driver = BrowserFactory.init();
		testPage = PageFactory.initElements(driver, PageTest.class);

		testPage.validateMonths();

	}

	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
	}

}
