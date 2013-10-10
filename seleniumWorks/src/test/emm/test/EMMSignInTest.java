package test.emm.test;
import static test.emm.setup.SeleniumDriver.getDriver;
import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Test;

import test.emm.pageobjects.EMMDashboard;
import test.emm.pageobjects.EMMSignIn;

public class EMMSignInTest {

	@AfterClass
	public static void tearDown(){
		getDriver().close();
		getDriver().quit();
	}
	
	@Test
	public void should_not_login_with_wrong_credentials(){
		//given
		EMMSignIn signIn = new EMMDashboard().open().goToSignInPage();
		//when
		signIn.login("poovarsan@easymedmobile.com", "123456");
		//then
		System.out.println("Error Messages: "+signIn.isLoginError());
		//Assert.assertTrue(signIn.isLoginError());
	}
	@Test
	public void shoud_login_with_valid_credentials(){
		//given
		EMMDashboard dashboard = new EMMDashboard().open();
		//when
		dashboard.goToSignInPage().login("poovarsan@easymedmobile.com", "bbbbbb");
		System.out.println(getDriver().getTitle());
		dashboard.Edit_Basic_Profile();
		dashboard.Logout();
		System.out.println("After logout: "+getDriver().getCurrentUrl());
	}
	
}
