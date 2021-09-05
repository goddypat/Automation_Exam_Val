package testNG_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.PageTest;
import util.BrowserFactory;

public class DuplicateFunctionality {
	


	WebDriver driver;
	PageTest testPage;

	@Test
	public void DuplicateCategoryTest() {
		driver = BrowserFactory.init();
		testPage = PageFactory.initElements(driver, PageTest.class);
		
		testPage.createDuplicateClass("CategoryData");
		testPage.validateDuplicateNotCreated();
		
	}
	
	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
	}

}
