package bsnl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.Selenium;

public class bsnl_web_driver_class {
	public static Selenium selenium;
	static Logger logger = Logger.getLogger("");
	static WebDriver driver = new HtmlUnitDriver();

	// static WebDriver driver = new FirefoxDriver();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		logger.setLevel(Level.OFF);
		StringBuffer output = new StringBuffer();
		StringBuffer error = new StringBuffer();
		String phone = null;
		String data = null;

		String basepath = "/home/ganesh/Desktop/Input/";

		File fin = new File(basepath + "Input.txt");
		try {
			FileReader fr;

			fr = new FileReader(fin);

			BufferedReader br = new BufferedReader(fr);

			do {
				// url = br.readLine();
				data = getDetails(driver, null);

				if (data == null) {
					// error.append(url);
					error.append("\n");

				} else {
					output.append(data);
				}

			} while (phone != null);

			br.close();
			fr.close();

		} catch (Exception e) {
			 e.printStackTrace();
			System.out
					.println("****************File Not Found please Provide proper file path **********************");

		}
		// writeError(basepath, error.toString());
		// writeOutput(basepath, output.toString());

		driver.close();
		System.out.println("Completed the Conversion !!!!!!");
	}

	private static String getDetails(WebDriver driver1, String phone) {
		String url = "http://dq.sdc.bsnl.co.in/bsnl-web/reversePhone.seam";

		try {
			  WebDriver driver = new HtmlUnitDriver();
driver.get(url);

			Thread.sleep(1000);
			String phoneno = driver.getTitle();
			System.out.println(phoneno);

			WebElement ph = driver.findElement(By.id("revPhone:firstField"));
			WebElement city = driver.findElement(By.id("revPhone:city"));

			System.out.println(city.equals(driver.switchTo().activeElement()));

			city.clear();
			city.sendKeys("CHENNAI");
			ph.sendKeys("24790186");
			System.out.println(city.getAttribute("value"));
			System.out.println(ph.getAttribute("value"));


			WebElement login = driver.findElement(By.name("revPhone:search"));
			
			System.out.println(login.isDisplayed());
			System.out.println(login.isEnabled());
			System.out.println(login);
			
			login.click();
			Thread.sleep(10000);
			
			
			
			WebElement error = driver.findElement(By.className("errors"));
			System.out.println(error.getText());
			
			

			
			List<WebElement> addr = driver.findElements(By.tagName("table"));

			System.out.println(addr);
			//System.out.println(addr.getText());

			System.out.println(driver.getPageSource());

			System.exit(0);

			return "";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
