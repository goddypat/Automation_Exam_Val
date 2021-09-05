package testNG_Project;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import page.PageTest;
import util.BrowserFactory;




public class ValidateAddCustomer {
	

	WebDriver driver;
	PageTest testPage;

	@Test
	public void CreateCategoryTest() {

		driver = BrowserFactory.init();
		testPage = PageFactory.initElements(driver, PageTest.class);

		testPage.enterCategoryName("CategoryData");
		testPage.clickAddCategoryButton();
		testPage.validateCategoryCreated();

	}

	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
	}
	

}
