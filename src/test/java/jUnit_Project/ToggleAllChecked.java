package jUnit_Project;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.TestPage1;
import util.BrowserFactory;

public class ToggleAllChecked {
	


	WebDriver driver;
	TestPage1 testPage1;

	@Test
	public void toggleAllFunctionTest() {

		driver = BrowserFactory.init();
		testPage1 = PageFactory.initElements(driver, TestPage1.class);

		testPage1.clickToggleAllButton();
		testPage1.validateCheckboxes();

	}

	@After
	public void teardown() {
		BrowserFactory.teardown();
	}

}
