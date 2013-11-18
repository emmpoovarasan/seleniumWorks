

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bsnl_test {
	//public WebDriver driver;
	public HtmlUnitDriver driver;
	public String URL;
	public StringBuffer errors;

	
	public void testSetupEnvironment() throws InterruptedException{
		//driver = new FirefoxDriver();
		driver = new HtmlUnitDriver(true);
		//driver = new ChromeDriver();
		URL ="http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";
		
	}
	
public static void main (String a[]) throws Exception{
	
	bsnl_test bt = new bsnl_test();
	bt.testSetupEnvironment();
	System.out.println("Completed Setup");
	bt.testGetPhoneNumbers();
	System.out.println("Completed getPhoneNumbers");
	bt.testTearDown();
	System.out.println("TearDown");
	
}
	
	
	public void testGetPhoneNumbers() throws InterruptedException{
		driver.get(URL);
		Thread.sleep(3000);
		WebElement phone = driver.findElement(By.id("revPhone:firstField"));
		WebElement city = driver.findElement(By.id("revPhone:city"));
		WebElement search = driver.findElement(By.id("revPhone:search"));
		
		try {
			phone.clear();
			phone.sendKeys("2479");
			city.clear();
			city.sendKeys("CHENNAI");
			search.click();
			Thread.sleep(3000);
			System.out.println("Wakeup from sleep");
			WebElement searchResultsCount = driver.findElement(By.xpath("//*[@id='contentSrchResult']/div[1]/div[1]/span"));
			WebElement searchResultsPageCount =driver.findElement(By.xpath("//*[@id='second']/span"));
			WebElement firstButton = driver.findElement(By.id("j_id10:FIRSTPGLink"));
			WebElement nextButton = driver.findElement(By.id("j_id10:PGDOWNLink"));
			System.out.println("nextButton.isEnabled() --> "+nextButton.isEnabled());
			
			String strPageCount = searchResultsPageCount.getText();
			String[] splitStr = strPageCount.split("of");
			System.out.println("First -- "+splitStr[0].trim() +"\n Second -- "+splitStr[1].trim());
			String totPageCount = splitStr[1].trim();
			
			
			Assert.assertTrue(firstButton.isDisplayed());
			System.out.println("Total Count"+searchResultsCount.getText());
			System.out.println("Total Page Count"+searchResultsPageCount.getText());
			System.out.println("Is First Button displayed"+firstButton.isDisplayed());
			
			Integer countPage;
			countPage = Integer.valueOf(totPageCount);
			
			System.out.println("Cout page ---- "+countPage);
			for(int k=0;k<countPage;k++){
				System.out.println("--------------- Start Record "+k+" ----------------");
				// Get Tables
				WebElement table = driver.findElement(By.id("second:myTab"));
				// get all the TR in the displayed table
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
				// iterate now
				
				for(WebElement row : allRows){
					
					List<WebElement> cell = row.findElements(By.tagName("td"));
					// iterate now
					int i=0;
					for(WebElement cellValue: cell){
						if(i==0){
							System.out.println("Name is "+cellValue.getText());
							
						}
						if(i==1){
							System.out.println("Telephone number is "+cellValue.getText());
							
						}
						if(i==2){
							System.out.println("Address is "+cellValue.getText());
							
						}
						if(i==3){
							System.out.println("State is "+cellValue.getText());
							
							
						}
						if(i>=3){
							i=0;
						}else{
							i++;
						}
						
					}
				}
				System.out.println("--------------- end of "+k+" Record ----------------");
				nextButton.click();
				Thread.sleep(1000);
				
			}
			
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public void testTearDown(){
		driver.close();
		driver.quit();
	}
}
