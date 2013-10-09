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
	}
	
	@Test
	public void should_not_login_with_wrong_credentials(){
		//given
		EMMSignIn signIn = new EMMDashboard().open().goToSignInPage();
		signIn.login("poovarsan@easymedmobile.com", "123456");
		Assert.assertTrue(signIn.isLoginError());
	}
}
