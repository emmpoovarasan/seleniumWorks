package test.keyworddriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

import junit.framework.TestCase;

public class TestHomePage extends TestCase{
	WebDriver driver;
	String baseURL = "https://guest:guest@sandbox.easymedmobile.com"; 
@Before
protected void setUp() throws Exception {
		// TODO Auto-generated method stub
	driver = new FirefoxDriver();
	driver.get(baseURL);
	//driver.navigate().refresh();
}
@Test
public void testHomePageLinks() throws InterruptedException{
	List<WebElement> linkElements = driver.findElements(By.tagName("a"));
	String[] linkText = new String[linkElements.size()];
	int i=0;
	
	//extract the link texts of each link element
	for(WebElement e : linkElements){
		if("" != e.getText() && " " != e.getText() && e.getText().length() > 0){
			linkText[i]=e.getText();
			//System.out.println(i+" --------> "+linkText[i]);
			i++;
		}
	}
		
	//test each link
	test_all_links("LINK", linkText, "href");
	
	// test each link under menus
	
	
	/*//test each link
	for(String  testLink : linkText){

			driver.get(driver.findElement(By.linkText(testLink)).getAttribute("href").toString());
			Thread.sleep(1000);
			System.out.println(testLink+" \" - "+driver.getTitle()+" - "+driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(3000);
		
	} // end of for loop
*/	
}
/*@Test
public void test_XPath_Links() throws InterruptedException{
	// first model
	List<WebElement> xpathElements = driver.findElements(By.xpath(".//*[@id='nav']/li"));

	System.out.println("List of xpathElements - "+xpathElements.size());
	int i=1;
	for(WebElement e : xpathElements){
		System.out.println(e+"["+i+"]/a");
		if(i==1){
			
			List<WebElement> xpathElements_MedPass = driver.findElements(By.xpath(".//*[@id='nav']/li[1]/ul/li"));
			System.out.println("Size of xpathElements_MedPass --- "+xpathElements_MedPass.size());
			String[] linkText = new String[xpathElements_MedPass.size()];
			int j=1;
			try {
				for(WebElement xp_medPass_atags : xpathElements_MedPass){
					//System.out.println(xp_medPass_atags.getText());
					//System.out.println("Get Text --"+xp_medPass_atags.getText()+"Get TagName --"+xp_medPass_atags.getTagName()+"Get Location --"+xp_medPass_atags.getLocation()+"Get Location string --"+xp_medPass_atags.getLocation().toString()+"Get Attribute --"+xp_medPass_atags.getAttribute("href"));
					
					//System.out.println("Test --> "+xp_medPass_atags.findElement(By.xpath(".//*[@id='nav']/li[1]/ul/li["+j+"]/a")).getText());
					String e1 = xp_medPass_atags+"["+j+"]/a";
					String[] spt = e1.split("xpath: .");
					//System.out.println(spt[0].toString()+"----test---\n"+spt[1].toString());
					linkText[j-1] = spt[1].toString();//xp_medPass_atags+"["+j+"]/a";
					//System.out.println("for loop -> "+linkText[j]);
					j++;
				}
				//System.out.println(linkText.length);
				for(int s=0; s<linkText.length;s++){
					System.out.println("Link Text print --- "+linkText[s].toString());
				}
				
				
				//test_all_links("XPATH", linkText, "href");
			} catch (Exception e2) {
				System.out.println("ERROR: "+e2.getMessage());
			}
			
			
		}
		if(i==2){
			List<WebElement> xpathElements_ES = driver.findElements(By.xpath(".//*[@id='nav']/li[2]/ul/li"));
			int j=1;
			for(WebElement xp_es_atags : xpathElements_ES){
				System.out.println(xp_es_atags+"["+j+"]/a");
				j++;
			}
		}
		if(i==3){
			List<WebElement> xpathElements_OT = driver.findElements(By.xpath(".//*[@id='nav']/li[3]/ul/li"));
			int j=1;
			for(WebElement xp_ot_atags : xpathElements_OT){
				System.out.println(xp_ot_atags+"["+j+"]/a");
				j++;
			}
		}
		if(i==4){
			List<WebElement> xpathElements_IT = driver.findElements(By.xpath(".//*[@id='nav']/li[4]/ul/li"));
			int j=1;
			for(WebElement xp_it_atags : xpathElements_IT){
				System.out.println(xp_it_atags+"["+j+"]/a");
				j++;
			}
		}
		if(i==5){
			List<WebElement> xpathElements_AED = driver.findElements(By.xpath(".//*[@id='nav']/li[5]/ul/li"));
			int j=1;
			for(WebElement xp_aed_atags : xpathElements_AED){
				System.out.println(xp_aed_atags+"["+j+"]/a");
				j++;
			}
		}
		i++;
	}
}
*/
public void test_all_links(String typeOfLink, String[] strLinkText, String attributeValue){
	//test each link
	try {
		if("LINK".equalsIgnoreCase(typeOfLink)){
			for(String  testLink : strLinkText){

				driver.get(driver.findElement(By.linkText(testLink)).getAttribute("href").toString());
				Thread.sleep(1000);
				System.out.println(testLink+" \" - "+driver.getTitle()+" - "+driver.getCurrentUrl());
				driver.navigate().back();
				Thread.sleep(3000);
			
			} // end of for loop
		}
		if("XPATH".equalsIgnoreCase(typeOfLink)){
			for(String  testLink : strLinkText){
				System.out.println("XPATH -- "+driver.findElement(By.xpath(testLink)).getText());
				//driver.get(driver.findElement(By.xpath(testLink)).getAttribute("href").toString());
				driver.findElement(By.xpath(testLink)).click();
				Thread.sleep(1000);
				System.out.println(testLink+" \" - "+driver.getTitle()+" - "+driver.getCurrentUrl());
				driver.navigate().back();
				Thread.sleep(3000);
			
			} // end of for loop
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
		
}
@Test
public void testSubMenus() throws InterruptedException{
	
	Actions action = new Actions(driver);
	List<WebElement> elements;
	ArrayList aList;
	int size;
	 
	WebElement medPass = driver.findElement(By.linkText("Medical Passport"));
	
	WebElement outTech = driver.findElement(By.linkText("Our Technology"));
	WebElement invest = driver.findElement(By.linkText("Investors"));
	WebElement aboutEM = driver.findElement(By.linkText("About EasyMed"));
	
	// menu Med Pass
	action.moveToElement(medPass).build().perform(); // Mouse over of Menu
	Thread.sleep(3000);
	elements = driver.findElements(By.xpath("//*[@id='nav']/li[1]/ul/li/a"));
	aList = new ArrayList(elements.size());
	for(WebElement e : elements){
		//System.out.println("Med Pass --> "+e.getText()+" Med Pas att --> "+e.getAttribute("href"));
		aList.add(e.getAttribute("href"));
	}
	subMenuIterator(aList);
	
	// Menu EasySmart
	WebElement easysmart = driver.findElement(By.linkText("Easy SmartCare"));
	action.moveToElement(easysmart).build().perform(); // Mouse over of Menu
	Thread.sleep(3000);
	elements = driver.findElements(By.xpath("//*[@id='nav']/li[2]/ul/li/a"));
	aList = new ArrayList(elements.size());
	for(WebElement e : elements){
		//System.out.println("Med Pass --> "+e.getText()+" Med Pas att --> "+e.getAttribute("href"));
		aList.add(e.getAttribute("href"));
	}
	subMenuIterator(aList);
	
}
public void subMenuIterator(ArrayList arrList) throws InterruptedException{
	Iterator itr = arrList.iterator();
	while (itr.hasNext()) {
		String type = (String) itr.next();
		//System.out.println(type);
		driver.get(type);
		//Thread.sleep(1000);
		System.out.println("Title: "+driver.getTitle()+" URL : "+driver.getCurrentUrl());
		//Thread.sleep(1000);
		driver.navigate().back();
	}
}
@After
public void tearDown(){
	driver.close();
	driver.quit();
}
}
