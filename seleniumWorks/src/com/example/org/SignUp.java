package com.example.org;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://sandbox.easymedmobile.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignUp() throws Exception {
    driver.get(baseUrl + "/index.php");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Mobile Enabler for the Healthcare Industry".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Create an account", driver.findElement(By.cssSelector("h2.siginTxt")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Create", driver.findElement(By.id("signup")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("signup")).click();
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select gender", closeAlertAndGetItsText());
    driver.findElement(By.id("sexM")).click();
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter your name", closeAlertAndGetItsText());
    driver.findElement(By.id("glow")).clear();
    driver.findElement(By.id("glow")).sendKeys("12323");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter a valid name", closeAlertAndGetItsText());
    driver.findElement(By.id("glow")).clear();
    driver.findElement(By.id("glow")).sendKeys("123213@");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter a valid name", closeAlertAndGetItsText());
    driver.findElement(By.id("glow")).clear();
    driver.findElement(By.id("glow")).sendKeys("Ajith");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter your surname", closeAlertAndGetItsText());
    driver.findElement(By.name("surname")).clear();
    driver.findElement(By.name("surname")).sendKeys("78sdf");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter a valid surname", closeAlertAndGetItsText());
    driver.findElement(By.name("surname")).clear();
    driver.findElement(By.name("surname")).sendKeys("Don");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select birthdate", closeAlertAndGetItsText());
    new Select(driver.findElement(By.id("Lglow"))).selectByVisibleText("01");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select birthdate", closeAlertAndGetItsText());
    new Select(driver.findElement(By.name("month"))).selectByVisibleText("Jun");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select birthdate", closeAlertAndGetItsText());
    new Select(driver.findElement(By.name("year"))).selectByVisibleText("1984");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter a valid email", closeAlertAndGetItsText());
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter a valid email", closeAlertAndGetItsText());
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@me.test.com");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter your password", closeAlertAndGetItsText());
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("12345");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("The password must be at least 6 characters long", closeAlertAndGetItsText());
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Passwords do not match", closeAlertAndGetItsText());
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("1234567");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Passwords do not match", closeAlertAndGetItsText());
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select a security question", closeAlertAndGetItsText());
    new Select(driver.findElement(By.id("securityQuestion"))).selectByVisibleText("In which city were you born?");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please answer to the security question", closeAlertAndGetItsText());
    driver.findElement(By.name("securityAnswer")).clear();
    driver.findElement(By.name("securityAnswer")).sendKeys("chinthagampalli");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("The phone number must be 10 to 14 characters long", closeAlertAndGetItsText());
    new Select(driver.findElement(By.id("country"))).selectByVisibleText("Hungary");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("The phone number must be 10 to 14 characters long", closeAlertAndGetItsText());
    new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("The phone number must be 10 to 14 characters long", closeAlertAndGetItsText());
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("+919994442453");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Your Personal Information".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("An error happened while creating your profile", driver.findElement(By.cssSelector("p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("This phone number is already in use", driver.findElement(By.cssSelector("div.failed.clearfix > span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("+9190994442453");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter your password", closeAlertAndGetItsText());
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("TERMS OF USE - Version 7.0 Updated".equals(driver.findElement(By.cssSelector("h2.popupTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("TERMS OF USE - Version 7.0 Updated", driver.findElement(By.cssSelector("h2.popupTitle")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Accept", driver.findElement(By.cssSelector("input.btnBlue")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    try {
      assertEquals("Dashboard - International Medical Passport", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Try EasyMedMobile.com for free during 30 days (2/2)", driver.findElement(By.cssSelector("h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Please confirm your phone number by answering to the SMS we sent you", driver.findElement(By.cssSelector("span.notify-text")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select credit card type", closeAlertAndGetItsText());
    new Select(driver.findElement(By.name("cc_type"))).selectByVisibleText("Visa");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter credit card number", closeAlertAndGetItsText());
    driver.findElement(By.name("cc_number")).clear();
    driver.findElement(By.name("cc_number")).sendKeys("2134234");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter valid credit card number", closeAlertAndGetItsText());
    driver.findElement(By.name("cc_number")).clear();
    driver.findElement(By.name("cc_number")).sendKeys("4111111111111111");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter card holder name", closeAlertAndGetItsText());
    driver.findElement(By.name("cc_name")).clear();
    driver.findElement(By.name("cc_name")).sendKeys("Ajith");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select card expiry date", closeAlertAndGetItsText());
    new Select(driver.findElement(By.name("cc_expiry_month"))).selectByVisibleText("Jun");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please select card expiry date", closeAlertAndGetItsText());
    new Select(driver.findElement(By.name("cc_expiry_year"))).selectByVisibleText("2014");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    assertEquals("Please enter CVC/CVV number", closeAlertAndGetItsText());
    driver.findElement(By.name("cc_cvc")).clear();
    driver.findElement(By.name("cc_cvc")).sendKeys("123");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Payment Status", driver.findElement(By.cssSelector("h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Your request has been declined. Please try again.", driver.findElement(By.cssSelector("div.leftElement.failed > span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Transaction Failure", driver.findElement(By.cssSelector("div.leftElement.failed > p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    new Select(driver.findElement(By.name("cc_type"))).selectByVisibleText("Visa");
    driver.findElement(By.name("cc_number")).clear();
    driver.findElement(By.name("cc_number")).sendKeys("4111111111111111");
    driver.findElement(By.name("cc_name")).clear();
    driver.findElement(By.name("cc_name")).sendKeys("Ajith");
    new Select(driver.findElement(By.name("cc_expiry_month"))).selectByVisibleText("Feb");
    new Select(driver.findElement(By.name("cc_expiry_year"))).selectByVisibleText("2014");
    new Select(driver.findElement(By.name("cc_expiry_year"))).selectByVisibleText("2015");
    driver.findElement(By.name("cc_cvc")).clear();
    driver.findElement(By.name("cc_cvc")).sendKeys("123");
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    driver.findElement(By.cssSelector("input.btnBlue")).click();
    acceptNextAlert = false;
    assertTrue(closeAlertAndGetItsText().matches("^You have terminated the registration process – Are you sure you want to abort[\\s\\S]$"));
    driver.findElement(By.xpath("//input[@value='Cancel']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^You have terminated the registration process – Are you sure you want to abort[\\s\\S]$"));
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@me.test.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.id("submitId")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Dashboard - International Medical Passport".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Dashboard - International Medical Passport", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Try EasyMedMobile.com for free during 30 days (2/2)", driver.findElement(By.cssSelector("h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("�")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.xpath("//input[@value='Cancel']")).click();
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
