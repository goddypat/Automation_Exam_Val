package jUnit_Project;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.TestPage1;
import util.BrowserFactory;

public class RemoveSingleItem {
	


	WebDriver driver;
	TestPage1 testPage1;

	@Test
	public void RemoveOneSingleItem() {

		driver = BrowserFactory.init();

		testPage1 = PageFactory.initElements(driver, TestPage1.class);
		testPage1.selectRandomList();

		testPage1.clickRemoveButton();
		testPage1.validateListDeleted();

	}

	@After
	public void teardown() {
		System.out.println("Browser shoot down");
		BrowserFactory.teardown();
	}

}
