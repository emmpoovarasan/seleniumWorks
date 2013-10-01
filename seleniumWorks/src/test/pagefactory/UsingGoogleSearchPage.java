package test.pagefactory;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingGoogleSearchPage {
	/*public static void main(String args[]){
		// Create a new instance of a driver
		WebDriver driver = new FirefoxDriver();
		
		// navigate to the right place
		driver.get("http://www.google.com");
		// create new instance of Google Search Page class
		// and initialise any WebElement fields in it.
		
		GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
		
		// And now do search
		
		page.searchFor("Chees");
	}*/

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors  = new StringBuffer();
	
	@Before
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		baseUrl = "http://www.google.com";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testGoogleSearchPage() throws Exception{
		driver.get(baseUrl);
		GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
		page.searchFor("Poovarasan");
		System.out.println(page.toString());
	}
	@Test
	public void testGoogleSearchPageClick() throws Exception{
		driver.get(baseUrl);
		GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
		page.searchFor("Nithya");
		System.out.println(driver.getTitle());
	}
	@After
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
	}
}
