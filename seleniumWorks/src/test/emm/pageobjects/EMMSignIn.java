package test.emm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EMMSignIn extends EMMPage<EMMSignIn> {

	@FindBy(name = "email")
	WebElement emailText;
	@FindBy(name = "password")
	WebElement passwordText;
	@FindBy(id = "submitId")
	WebElement submitIdButton;
	@FindBy (id = "loginMessageDiv")
	WebElement errorBox;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(emailText);
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return "";
	}
	
	public void login(String email, String password){
		emailText.sendKeys(email);
		passwordText.sendKeys(password);
		submitIdButton.click();
	}
	
	public String isLoginError(){
		return errorBox.getText().toString();
	}

}
