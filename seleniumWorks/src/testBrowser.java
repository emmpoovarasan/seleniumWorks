import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class testBrowser {
	//static WebDriver driver;
	static HtmlUnitDriver driver;
	static String base_url;
	
	@Before
	public void setUp(){
		//driver = new FirefoxDriver();
		driver = new HtmlUnitDriver();
		base_url = "http://dq.sdc.bsnl.co.in";//"http://192.168.1.6/easymedmobiledb2.com/";
	}
	
	@Test
	public void testData(){

		/*driver.get(base_url);
		
		
		
		driver.navigate().refresh();
		
		System.out.println(driver.getTitle());
		
		WebElement name = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement Login = driver.findElement(By.name("Login"));
		
		name.sendKeys("poovarsan@easymedmobile.com");
		password.sendKeys("bbbbbb");
		Login.click();
		
		System.out.println(driver.getTitle());
		
		WebElement logout = driver.findElement(By.linkText("Logout"));
		
		logout.click();
				
		System.out.println(driver.getTitle());*/
		
		driver.get(base_url+"/bsnl-web/reversePhone.seam");
		System.out.println(driver.getTitle());
		
		WebElement phone = driver.findElement(By.id("revPhone:firstField"));
		WebElement city = driver.findElement(By.id("revPhone:city"));
		WebElement search = driver.findElement(By.id("revPhone:search"));
		
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(city.isDisplayed());
		Assert.assertTrue(search.isDisplayed());
		
		
		phone.sendKeys("2479");
		city.sendKeys("CHENNAI");
		search.click();
		
		System.out.println(driver.getPageSource());
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
