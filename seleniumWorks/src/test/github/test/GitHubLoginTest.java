package test.github.test;

import static test.github.setup.SeleniumDriver.getDriver;
import junit.framework.Assert;
//import static org.fest.assertions.api.Assertions.assertThat;


import test.github.pageobjects.GitHubHomePage;
import test.github.pageobjects.GitHubLoginPage;
import org.junit.AfterClass;
import org.junit.Test;

public class GitHubLoginTest {

	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@Test
	public void should_not_login_with_wrong_credentials() {
		//given
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("emmpoovarasan", "kingarasan1982");
		//then
		//assertThat(loginPage.isLoginError()).isTrue();
		Assert.assertTrue(loginPage.isLoginError());
	}
}
