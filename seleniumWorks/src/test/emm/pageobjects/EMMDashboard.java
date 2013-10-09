package test.emm.pageobjects;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EMMDashboard extends EMMPage<EMMDashboard>{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.titleContains("");
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

}
