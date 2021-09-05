package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.TestPage1;
import util.BrowserFactory;

public class BackgroundColor {

	WebDriver driver;
	TestPage1 testPage1;
	
	@Given("^\"([^\"]*)\" button exists$")
	public void button_exists(String color) throws Throwable {
		driver = BrowserFactory.init();
		testPage1 = PageFactory.initElements(driver, TestPage1.class);

		if (color == "SkyBlue") {
			testPage1.assertColorButtonExistance(color);
		} else if (color == "White") {
			testPage1.assertColorButtonExistance(color);
		}
	}

	@When("^User should be able to click on the skyblue button$")
	public void user_should_be_able_to_click_on_the_skyblue_button() throws Throwable {
		testPage1.clickBlueBackgroundButton();
	}

	@When("^User should be able to click on the white button$")
	public void user_should_be_able_to_click_on_the_white_button() throws Throwable {
		testPage1.clickWhiteBackgroundButton();
	}

	@Then("^the background color will change to \"([^\"]*)\"$")
	public void the_background_color_will_change_to(String color) throws Throwable {
		testPage1.verifyBackgroundColor(color);

		BrowserFactory.teardown();

	}

}
