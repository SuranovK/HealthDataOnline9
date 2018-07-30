package gov.healthdata.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import gov.healthdata.pages.SearchPage;
import gov.healthdata.utilities.ConfigurationReader;

public class searchTest extends TestBase {
	
	@Test(groups = { "smoke" })
	public void test() {
		SearchPage searchPage = new SearchPage();
		searchPage.searchBox.sendKeys(ConfigurationReader.getProperty("searchTerm"));
		searchPage.searchBtn.click();
		assertTrue(searchPage.searchResultLbl.isDisplayed());
		System.out.println(searchPage.searchResultLbl.getText());
		
		
		
		
	}
}
