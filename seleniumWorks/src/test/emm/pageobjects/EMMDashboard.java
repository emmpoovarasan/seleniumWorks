package test.emm.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.emm.setup.SeleniumDriver;

public class EMMDashboard extends EMMPage<EMMDashboard>{
	@FindBy(linkText = "Logout")
	WebElement logOut;
	@FindBy(linkText="(Edit Basic Profile)")
	WebElement edit_basic_profile;
	@FindBy(className = "popupTitle") //(xpath = "//*[@id='popupAjaxDiv']/dl/div/h2")
	WebElement edit_basic_profile_popUpTitle;
	
	@FindBy(id="cboxClose")
	WebElement edit_basic_profile_close;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.titleContains(SeleniumDriver.getDriver().getTitle());
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return "";
	}
	
	public EMMSignIn goToSignInPage(){
		return new EMMSignIn().openPage(EMMSignIn.class);
	}
	
	public EMMDashboard open(){
		
		return new EMMDashboard().openPage(EMMDashboard.class);
	}
	public void Edit_Basic_Profile(){
		System.out.println(edit_basic_profile.getText());
		
		edit_basic_profile.click();
		SeleniumDriver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(edit_basic_profile_popUpTitle.getTagName());
		SeleniumDriver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		edit_basic_profile_close.click();
	}
	public void Logout(){
		System.out.println(logOut.getText());
		logOut.click();
	}
}
