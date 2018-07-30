package gov.healthdata.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import gov.healthdata.pages.SearchPage;
import gov.healthdata.utilities.ConfigurationReader;

public class FeedBackSubmition extends TestBase{

	@Test(groups = {"smoke"})
	public void feedBackTest() {
		SearchPage searchPage = new SearchPage(); 
	
		searchPage.searchBox.sendKeys(ConfigurationReader.getProperty("searchTerm"));
		searchPage.searchBtn.click();
		searchPage.addFeedbackBtn.click();
		
		searchPage.addTitle.sendKeys(ConfigurationReader.getProperty("feedbackTitle"));//18691
		searchPage.addFeedBackText.sendKeys(ConfigurationReader.getProperty("feedbackText"));
		searchPage.addTags.sendKeys(ConfigurationReader.getProperty("tag") + Keys.ENTER);
		
		searchPage.feedBackTypeOpt.click();
		searchPage.selectOtherOpt.click();
		searchPage.captchaInput.sendKeys("5");
		searchPage.saveBtn.click();
		
		assertTrue(searchPage.errorMsg.isDisplayed());
	}
}
