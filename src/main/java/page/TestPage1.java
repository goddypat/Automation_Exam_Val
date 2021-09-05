package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.BasePage;
import util.BrowserFactory;

public class TestPage1 {


	WebDriver driver;
	BasePage basePage = new BasePage();
	String customCSS;
	String testCategoryName;

	public TestPage1(WebDriver driver) {
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
	
	public void enterCategoryName (String categoryname) {
		int randomNumber = basePage.randomNumberGenerator(999);
		testCategoryName = categoryname + randomNumber;
		CATEGORY_NAME_FIELD.sendKeys(testCategoryName);
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
	
	public void validateCheckboxes() {
		
		/*
		 	This method works,
		 		no matter how many checkboxes there are,
		 		and if there are deleted checkboxes anywhere in the list,
		 		and it will give an AssertionError if there is no list.
		*/
		
		boolean toggleAllSelected = TOGGLE_ALL_BUTTON.isSelected();
		
		List<WebElement> listNames = driver.findElements(By.tagName("li"));
		int listCount = listNames.size();
		String lastCheckboxName = "";
		
		try {
			lastCheckboxName = driver.findElement(By.xpath("//li["+listCount+"]/input")).getAttribute("name");
		} catch (NoSuchElementException e) {
			System.out.println("There is no list.");
			BrowserFactory.teardown();
			Assert.assertTrue("There is no list.", false);
		}
		
		int bracketCloseIndex = lastCheckboxName.indexOf("]");
		String lastCheckboxNumber = lastCheckboxName.substring(5, bracketCloseIndex);
		int finalNumberToUseInLoop = Integer.valueOf(lastCheckboxNumber);
				
		if(toggleAllSelected==true) {
			
			System.out.println("Toggle all is checked");
			
			for(int i=0; i<=finalNumberToUseInLoop; i++) {
				//Custom cssSelector to locate each checkbox
				String customCSS = "input[name='todo["+i+"]'";
				
				WebElement checkbox = null;
				int absentList = -1;
				
				//try-catch block to find checkbox element, if checkbox does not exist, save it as absentList
				try {
				checkbox = driver.findElement(By.cssSelector(customCSS));
				basePage.waitForElement(driver, checkbox, 2);
				} catch (NoSuchElementException e) {absentList = i;}
				
				//If there is an absent list, skip it and continue validating the rest.
				if(absentList == i) {
					System.out.println("List #" + i + " does not exist.");
					continue;
				}
				
				boolean checkboxesSelected = checkbox.isSelected();
					
				Assert.assertTrue(checkboxesSelected);
				
				if (checkboxesSelected==true) {
					System.out.println("Checkbox #" +i+ " is checked");			
					
				}	
			}
		}
	}
	
	public void selectRandomList() {
		
		List<WebElement> listNames = driver.findElements(By.tagName("li"));
		int listCount = listNames.size();
		
		int randomListNumber = basePage.randomNumberGenerator(listCount);
		customCSS = "input[name='todo["+randomListNumber+"]'";
		driver.findElement(By.cssSelector(customCSS)).click();
		
		System.out.println("Randomly selected list #" + randomListNumber);
		
	}
	
	public void validateListDeleted() {
		
		boolean listExistance;
		
		try {
			listExistance = driver.findElement(By.cssSelector(customCSS)).isDisplayed();
			} catch (NoSuchElementException e) {
			listExistance = false;
			}
		
		Assert.assertFalse(listExistance);
		System.out.println("Randomly selected list is deleted");
		
	}

	public void validateAllListsDeleted() {
		
		boolean listExistance;
		
		try {
			listExistance = driver.findElement(By.tagName("li")).isDisplayed();
			} catch (NoSuchElementException e) {
			listExistance = false;
			}
		
		Assert.assertFalse(listExistance);
		
		if(listExistance==false) {
		System.out.println("All lists are deleted");
		}
	}

	public void assertColorButtonExistance(String color) {
		
		boolean buttonExistance;
		
		if(color=="sky blue") {
			buttonExistance = BLUE_BACKGROUND_BUTTON.isDisplayed();
			Assert.assertTrue("Button is not displayed", buttonExistance);
			System.out.println("Blue color button exists");
			
		} else if (color=="white") {
			buttonExistance = WHITE_BACKGROUND_BUTTON.isDisplayed();
			Assert.assertTrue("Button is not displayed", buttonExistance);
			System.out.println("White color button exists");
			
			}
		
	}

	public void assertWhiteButtonExistance() {
	
	boolean buttonExistance = WHITE_BACKGROUND_BUTTON.isDisplayed();
	
	Assert.assertTrue("Button is not displayed", buttonExistance);
	
	}
	
	public String getBackgroundColor() {
		
		String backgroundColor = "";
		
		for(int i=0; i<=1; i++) {
			
		boolean success = false;
			
		if(i==0) {	
		try {
			driver.findElement(By.cssSelector("body[style='background-color: skyblue;']"));
			backgroundColor = "skyblue";
			success=true;
		} catch (NoSuchElementException e) {
			backgroundColor = "not skyblue";
		}
		}
		
		if(success==true) {break;} else if(i==1){
		
		try {
			driver.findElement(By.cssSelector("body[style='background-color: white;']"));
			backgroundColor = "white";
		} catch (NoSuchElementException e) {
			backgroundColor = "not white";
		}
		}
		}
		
		return backgroundColor;
		
	}
	
	public void verifyBackgroundColor(String expectedColor) {
		
		String actualColor = getBackgroundColor();
		
		Assert.assertEquals("Color is not :", expectedColor, actualColor);
		System.out.println("Background color is " + actualColor);		
	}
	

}
