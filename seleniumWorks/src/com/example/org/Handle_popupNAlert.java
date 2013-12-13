/**
 * 
 */
package com.example.org;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author POO
 *
 */
public class Handle_popupNAlert {
	WebDriver driver;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver= new FirefoxDriver(); 
        driver.get("http://www.rediff.com/");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.close();
        driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		WebElement sign = driver.findElement(By.xpath("//html/body/div[3]/div[3]/span[4]/span/a"));
        sign.click();

        Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
        Iterator<String> itererator = windowId.iterator();   

        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();

        driver.switchTo().window(newAdwinID);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(mainWinID);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        WebElement email_id= driver.findElement(By.xpath("//*[@id='c_uname']"));
        email_id.sendKeys("hi");
        Thread.sleep(5000);
	}

}
