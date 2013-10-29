package test.keyworddriven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

public class TestHomePage extends TestCase{
	WebDriver driver;
	String baseURL = "https://guest:guest@sandbox.easymedmobile.com"; 
@Before
protected void setUp() throws Exception {
		// TODO Auto-generated method stub
	driver = new FirefoxDriver();
	driver.get(baseURL);
	driver.navigate().refresh();
}
@Test
public void testHomePageStaticLinks() throws InterruptedException{
	List<WebElement> linkElements = driver.findElements(By.tagName("a"));
	String[] linkText = new String[linkElements.size()];
	int i=0;
	
	//extract the link texts of each link element
	for(WebElement e : linkElements){
		if("" != e.getText() && " " != e.getText()){
			linkText[i]=e.getText();
			System.out.println(i+" --------> "+linkText[i]);
			i++;
		}
	}
		
	//test each link
	for(String  testLink : linkText){
		System.out.println("Print testLink has value --- "+testLink);
		/*if("" != testLink){
			System.out.println("Print testLink has value --- "+testLink);
			if("_blank".equalsIgnoreCase(driver.findElement(By.linkText(testLink)).getAttribute("target").toString())){
				System.out.println("A tag target values ---> "+driver.findElement(By.linkText(testLink)).getAttribute("target").toString());
				System.out.println(testLink+" \" - "+driver.getCurrentUrl());
			}else{
				//if("Mobile Enabler for the Healthcare Industry".equalsIgnoreCase(driver.getTitle())){
					//System.out.println("A tag not target values ---> "+driver.findElement(By.linkText(testLink)).getAttribute("target").toString());
					driver.findElement(By.linkText(testLink)).click();
					
					Thread.sleep(2000);
					System.out.println(testLink+" \" - "+driver.getCurrentUrl());
					
					driver.navigate().back();
					Thread.sleep(2000);
					
				}else{
					System.out.println("Else - home page \"- "+testLink+" \" - "+driver.getCurrentUrl());
					driver.navigate().back();
				}
			}
		}else{
			System.out.println("Print testLink has not value --- "+testLink);
		}*/
		
	} // end of for loop
	
}
@After
public void tearDown(){
	driver.close();
	driver.quit();
}
}
