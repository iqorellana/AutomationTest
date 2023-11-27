package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.FocusPageObject;
import Pages.GoogleSearchPageObject;

public class FocusPageTest {
	
	private static WebDriver driver= null;	
	
	public static void main(String[] args) {
		googleSearchTest();
		
	}
	
	
	public static void googleSearchTest() {
		
		//Adding ChromeDriver
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary(projectPath+"/drivers/chrome-win64/chrome.exe");
		driver = new ChromeDriver(co);
		
		
		//Adding the Class GoogleSearchObject that includes the methods for The Google page.
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		
		//Adding the Class FocusPageObject that includes the methods for The Focus page.
		FocusPageObject focusObject= new FocusPageObject(driver);
	    
		//Search the word "Focus Services" in Google page
		searchPageObj.setTextInSearchBox("Focus Services");	
		
		//Click on Search Button.		
		searchPageObj.clickSearchButton();
		
		//Verify if the URL "https://www.focusservices.com" exist in the search.
		searchPageObj.verifyFocusLink();
		
		//Click on Focus Services page.		
		focusObject.getFocusPage();
		
		//Scroll down to the bottom of the page.
		focusObject.scrollDownBotton();
		
		//Verify if the button "Now Hiring!" Exist in the page.
		focusObject.verifyButton();
		
		//Click on the locations tab.
		focusObject.clickLocationsButton();
		
		//Locate the North America Link and performed and assert on this link.
		focusObject.linkValidation();
		
		//Click on Central America Location.
		focusObject.clickCentralAmerica();
		
		//Verify that the text "El Salvador & Nicaragua" exist on the page.
		focusObject.verifyTitle();
		
		//Click on Asia Location
		focusObject.clickAsiaLocation();
		
		//Verify if the text block "Bacolod City, Philippines" exist on the page.
		focusObject.verifyAsiaLocationText();
		
		//Click on Careers tab.
		focusObject.clickCareersButton();
		
		//Search for Generalist in Careers page
		
		focusObject.setKeywords("Generalist");
		
		//Click on Facebook icon.
		focusObject.clickFacebookButton();
		
		//Close the Driver
		driver.close();
		System.out.println("The test was successfull");
	}

}
