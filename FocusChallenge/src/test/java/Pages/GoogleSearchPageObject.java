package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GoogleSearchPageObject {
	
	
	WebDriver driver=null;
	
	By textbox_search = By.name("q");
	By button_search= By.className("gNO89b");
	By popup_close= By.xpath("//html");	
	By button_locations= By.xpath("//*[@id=\"menu-item-4726\"]/a");
	By northAmerica_link = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]");
	
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	
	// Method to get to the google main page and enter a text to search
	public void setTextInSearchBox(String string) {
		driver.get("https://google.com");	
		driver.findElement(textbox_search).sendKeys(string);		
		driver.manage().window().maximize();
	}
	
	//Method to click the search button
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	//Method to verify if the link 'https://www.focusservices.com/' exist in the google search.
	public void verifyFocusLink() {
		String linkName = driver.findElement(By.xpath("//a[@href='https://www.focusservices.com/']")).getText();
		System.out.println("El siguiente Link se muestra en la busqueda " + linkName);
	}
		
}
