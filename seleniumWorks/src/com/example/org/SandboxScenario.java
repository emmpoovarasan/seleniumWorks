package com.example.org;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;
import org.openqa.selenium.support.ui.Select;

public class SandboxScenario {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
	//driver = new HtmlUnitDriver();
    baseUrl = "https://sandbox.easymedmobile.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSandboxScenario() throws Exception {
    driver.get(baseUrl + "/");
    // Warning: verifyTextPresent may require manual changes
    System.out.println(verifySignIn());
    fnLogin();
    System.out.println(invalidPassword());
  }
  
  public String verifySignIn() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	  try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  return (driver.findElement(By.className("siginTxt")).getText()+" Passed ");
  }
  public String fnLogin() throws Exception{
	  	driver.findElement(By.name("email")).clear();
	    //driver.findElement(By.name("email")).sendKeys("poovarsan@easymedmobile.com");
	  	driver.findElement(By.name("email")).sendKeys("");
	    driver.findElement(By.name("password")).clear();
	    //driver.findElement(By.name("password")).sendKeys("bbbbbbb");
	    driver.findElement(By.name("password")).sendKeys("");
	    driver.findElement(By.id("submitId")).click();
	    return null;
  }
  public String invalidPassword() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Session not set or expired [\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Invalid password [\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    return driver.findElement(By.id("loginMessageDiv")).getText();
  }
  
  public boolean verifyTitles() throws Exception{
	  for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Mobile Enabler for the Healthcare Industry".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	  for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	  
	  return true;
  }
  
  public void recurringPayment() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Try EasyMedMobile\\.com for free during 30 days \\(2/2\\)[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    new Select(driver.findElement(By.name("cc_type"))).selectByVisibleText("Visa");
	    driver.findElement(By.name("cc_number")).clear();
	    driver.findElement(By.name("cc_number")).sendKeys("4111111111111111");
	    driver.findElement(By.name("cc_name")).clear();
	    driver.findElement(By.name("cc_name")).sendKeys("poovarasan");
	    new Select(driver.findElement(By.name("cc_expiry_month"))).selectByVisibleText("May");
	    new Select(driver.findElement(By.name("cc_expiry_year"))).selectByVisibleText("2014");
	    driver.findElement(By.name("cc_cvc")).clear();
	    driver.findElement(By.name("cc_cvc")).sendKeys("123");
	    driver.findElement(By.cssSelector("input.btnBlue")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
  }
  public void paymentStatus() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Payment Status[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.cssSelector("input.btnBlue")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }  
  }
  public void stepByStepMedicalPassport() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Setting up your Medical Passport[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.id("caregiver")).click();
	    driver.findElement(By.id("authDoctor")).click();
	    driver.findElement(By.cssSelector("input.btnBlue")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
  
  }
  public void dashboardVerify() throws Exception{
	// Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Profile Completeness[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Credit Balance[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Add a Medication Reminder[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Health Tips[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Add an Appointment[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Sharing Profiles[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
  }
  public boolean fnLogout() throws Exception{
	  driver.findElement(By.linkText("Logout")).click();
	  return true;
  }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
