package bsnl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bsnl_test {
	public WebDriver driver;
	public String URL;
	public StringBuffer errors;

	@Before
	public void testSetupEnvironment() throws InterruptedException{
		driver = new FirefoxDriver();
		URL ="http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";
		
	}
	
	@Test
	public void testGetPhoneNumbers() throws InterruptedException{
		driver.get(URL);
		Thread.sleep(3000);
		WebElement phone = driver.findElement(By.id("revPhone:firstField"));
		WebElement city = driver.findElement(By.id("revPhone:city"));
		WebElement search = driver.findElement(By.id("revPhone:search"));
		
		try {
			phone.clear();
			phone.sendKeys("24790186");
			city.clear();
			city.sendKeys("CHENNAI");
			search.click();
			Thread.sleep(3000);
			
			WebElement searchResultsCount = driver.findElement(By.xpath("//*[@id='contentSrchResult']/div[1]/div[1]/span"));
			WebElement searchResultsPageCount = driver.findElement(By.xpath("//*[@id='second']/span"));
			WebElement firstButton = driver.findElement(By.id("j_id10:FIRSTPGLink"));
			WebElement nextButton = driver.findElement(By.id("j_id10:PGDOWNLink"));
			
			String strPageCount = searchResultsPageCount.getText();
			String[] splitStr = strPageCount.split("of");
			//System.out.println("First -- "+splitStr[0].trim() +"\n Second -- "+splitStr[1].trim());
			String totPageCount = splitStr[1].trim();
			
			
			Assert.assertTrue(firstButton.isDisplayed());
			//System.out.println("Total Count"+searchResultsCount.getText());
			//System.out.println("Total Page Count"+searchResultsPageCount.getText());
			//System.out.println("Is First Button displayed"+firstButton.isDisplayed());
			
			Integer countPage;
			countPage = Integer.valueOf(totPageCount);
			
			System.out.println("Cout page ---- "+countPage);
			for(int k=0;k<countPage;k++){
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
				
				nextButton.click();
				Thread.sleep(1000);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	@After
	public void testTearDown(){
		driver.close();
		driver.quit();
	}
}
