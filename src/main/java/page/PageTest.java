package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import util.BasePage;



public class PageTest {
	
	WebDriver driver;
	BasePage basePage = new BasePage();
	String customCSS;
	String testName;

	public PageTest(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[value = 'Remove']") WebElement REMOVE_BUTTON;
	@FindBy(how = How.CSS, using = "input[value = 'Complete']") WebElement COMPLETE_BUTTON;
	@FindBy(how = How.CSS, using = "input[name = 'allbox']") WebElement TOGGLE_ALL_BUTTON;
	@FindBy(how = How.CSS, using = "input[name = 'data']") WebElement LIST_NAME_FIELD;
	@FindBy(how = How.CSS, using = "input[name = 'categorydata']") WebElement CATEGORY_NAME_FIELD;
	@FindBy(how = How.CSS, using = "input[value = 'add']") WebElement ADD_LIST_BUTTON;
	@FindBy(how = How.CSS, using = "input[value = 'Add category']") WebElement ADD_CATEGORY_BUTTON;
	@FindBy(how = How.CSS, using = "select[name = 'category']") WebElement CATEGORY_DROPDOWN;
	@FindBy(how = How.CSS, using = "select[name = 'due_day']") WebElement DAY_DROPDOWN;
	@FindBy(how = How.CSS, using = "select[name = 'due_month']") WebElement MONTH_DROPDOWN;
	@FindBy(how = How.CSS, using = "select[name = 'due_year']") WebElement YEAR_DROPDOWN;
	@FindBy(how = How.CSS, using = "select[name = 'color']") WebElement CATEGORY_COLOR_DROPDOWN;
	@FindBy(how = How.CSS, using = "button[onclick = 'myFunctionSky()']") WebElement BLUE_BACKGROUND_BUTTON;
	@FindBy(how = How.CSS, using = "button[onclick = 'myFunctionWhite()']") WebElement WHITE_BACKGROUND_BUTTON;
	
	//Interactive Methods
	
	public void clickRemoveButton () {
		REMOVE_BUTTON.click();
	}
	
	public void clickCompleteButton () {
		COMPLETE_BUTTON.click();
	}
	
	public void clickToggleAllButton () {
		TOGGLE_ALL_BUTTON.click();
	}
	
	public void enterListName (String listname) {
		LIST_NAME_FIELD.sendKeys(listname);
	}
	
	public void enterCategoryName (String categoryName) {
		int randomNumber = basePage.randomNumberGenerator(999);
		testName = categoryName + randomNumber;
		CATEGORY_NAME_FIELD.sendKeys(testName);
	}
	
	public void clickAddListButton () {
		ADD_LIST_BUTTON.click();
	}
	
	public void clickAddCategoryButton () {
		ADD_CATEGORY_BUTTON.click();
	}
	
	public void selectCategory (String categorySelection) {
		basePage.selectFromDropdown(CATEGORY_DROPDOWN, categorySelection);
	}
	
	public void selectDay (String day) {
		basePage.selectFromDropdown(DAY_DROPDOWN, day);
	}
	
	public void selectMonth (String month) {
		basePage.selectFromDropdown(MONTH_DROPDOWN, month);
	}
	
	public void selectYear (String year) {
		basePage.selectFromDropdown(YEAR_DROPDOWN, year);
	}
	
	public void selectCategoryColor (String categoryColor) {
		basePage.selectFromDropdown(CATEGORY_COLOR_DROPDOWN, categoryColor);
	}
	
	public void clickBlueBackgroundButton() {
		BLUE_BACKGROUND_BUTTON.click();
	}
	
	public void clickWhiteBackgroundButton() {
		WHITE_BACKGROUND_BUTTON.click();
	}
	
	//Interactive Methods

	public void validateCategoryCreated() {
		
		List<WebElement> allCategories = driver.findElements(By.cssSelector("a[title]"));
		int categoryCount = allCategories.size();
		
		WebElement lastCategory = allCategories.get(categoryCount-1);
		String lastCategoryName = lastCategory.getText();
		System.out.println(lastCategoryName);
		boolean categoryDisplayed = lastCategory.isDisplayed();
		
		Assert.assertEquals(lastCategoryName, testName, "Category not created.");
		Assert.assertEquals(categoryDisplayed, true);
		
		
	}
	
	public void createDuplicateClass(String categoryName) {
		
		int randomNumber = basePage.randomNumberGenerator(999);
		testName = categoryName + randomNumber;
		
		CATEGORY_NAME_FIELD.sendKeys(testName);
		clickAddCategoryButton();
		CATEGORY_NAME_FIELD.sendKeys(testName);
		clickAddCategoryButton();
		
	}
	
	public void validateDuplicateNotCreated() {
		
		String bodyText = driver.findElement(By.cssSelector("body")).getText();
		boolean duplicateMessageBoolean = bodyText.contains("The category you want to add already exists");
		
		String categoryName = driver.findElement(By.xpath("//span[1][text()]")).getText();
	
		Assert.assertEquals(duplicateMessageBoolean, true);
		
		if(duplicateMessageBoolean==true) {
			System.out.println("The category you want to add already exists: " + categoryName);
		}
		
	}
	
	public void validateMonths() {
		
		Select select = new Select(MONTH_DROPDOWN);
		List<WebElement> months = select.getOptions();
		List<String> actualMonths = new ArrayList<String>();
		
		List<String> expectedMonths = new ArrayList<String>();
		expectedMonths.add("Jan");
		expectedMonths.add("Feb");
		expectedMonths.add("Mar");
		expectedMonths.add("Apr");
		expectedMonths.add("May");
		expectedMonths.add("Jun");
		expectedMonths.add("Jul");
		expectedMonths.add("Aug");
		expectedMonths.add("Sep");
		expectedMonths.add("Oct");
		expectedMonths.add("Nov");
		expectedMonths.add("Dec");

		for(WebElement actualMonth : months) {
			if(actualMonth.getText().equalsIgnoreCase("None")) {continue;}
			actualMonths.add(actualMonth.getText());
		}
		
		for(int i=0; i<=expectedMonths.size()-1; i++) {
			System.out.print("Actual: " + expectedMonths.get(i));
			try {
			System.out.println(" ExpectedMonths: " + actualMonths.get(i));
				Assert.assertTrue(expectedMonths.get(i).equals(actualMonths.get(i)));
			}catch(IndexOutOfBoundsException e) {}
		}
		
	}
	
	

}
