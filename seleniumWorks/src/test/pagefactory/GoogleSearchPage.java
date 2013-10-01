package test.pagefactory;

import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
// here is the element
	private WebElement q;
	
	public void searchFor(String text){
		// And here we use it. Note that it looks like we've
		// not properlly instantiated yet
		
		q.sendKeys(text);
		q.submit();
	}
}
