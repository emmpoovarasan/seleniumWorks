package test.keyworddriven;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetExcelData {
	static Sheet wrkSheet;
	static Workbook wrkBook = null;
	
	public GetExcelData(String FilePath) throws BiffException, IOException{
		wrkBook = Workbook.getWorkbook(new File(FilePath));
	}
	
	public static String[][] extractDataFromExcel(String sheet) throws ArrayIndexOutOfBoundsException {
		wrkSheet = wrkBook.getSheet(sheet);
		String[][] steps = new String[wrkSheet.getRows()][wrkSheet.getColumns()];
		//System.out.println("Rows - "+wrkSheet.getRows()+" Columns - "+wrkSheet.getColumns()+" Size of steps"+steps.length);
		
		for(int i=0; i < steps.length; i++){
			for(int j=0; j < steps[i].length; j++){
				steps[i][j] = wrkSheet.getCell(j, i).getContents();
				//System.out.print(steps[i][j]+" ");
			}
			//System.out.println();
		}
		return steps;
	}
	
	/*public static void main(String[] args) throws BiffException, IOException{
		File f = new File("EMMDataDriven.xls");
		String fname = f.getAbsolutePath();
		System.out.println(fname);
		GetExcelData ge = new GetExcelData("C:\\Users\\POO\\git\\seleniumWorks\\seleniumWorks\\src\\test\\keyworddriven\\KeywordDriven.xls");
		
		String[][] steps;
		steps = ge.extractDataFromExcel("Sheet1");
		
		WebDriver wd = null;
		//System.out.println(steps[1][0]);
		for(int i = 1; i<= steps.length; i++){
			if(steps[0][i].equalsIgnoreCase("Y")){
				if("open_browser".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					wd = open_browser(steps[7][i]);
					
				}else if("navigate_to".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					navigate_to(wd,steps[7][i]);
					
				}else if("refresh".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					refresh(wd);
					
				}else if("send_keys".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					send_keys(wd,steps[5][i],steps[6][i],steps[7][i]);
					
				}else if("click_element".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					click_element(wd,steps[5][i],steps[6][i]);
					
				}else if("verify_element".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					verify_element(wd,steps[5][i],steps[6][i]);
					
				}else if("close_browser".equalsIgnoreCase(steps[4][i])){
					System.out.println(steps[4][i]);
					close_browser(wd);
				}else{
					System.out.println("else--"+steps[4][i]);
				}
			}
		}
	}*/

	public static void close_browser(WebDriver wd) {
		wd.close();
		wd.quit();
	}

	public static void verify_element(WebDriver wd, String locate,
			String LocString) {
		
		if("id".equalsIgnoreCase(locate)){
			String ActualOutput = wd.findElement(By.id(LocString)).getText();
			try {
				if("Invalid password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Invalid password", ActualOutput);
					System.out.println("Expected Output: Invalid password | Actual Output: "+ActualOutput);
				}else if("Please enter your email and password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Please enter your email and password", ActualOutput);
					System.out.println("Expected Output: Please enter your email and password | Actual Output: "+ActualOutput);
				}else if("Wrong email or password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Wrong email or password", ActualOutput);
					System.out.println("Expected Output: Wrong email or password | Actual Output: "+ActualOutput);
				}else{
					System.out.println("Actual Output: "+ActualOutput);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("xpath".equalsIgnoreCase(locate)){
			try {
				org.junit.Assert.assertEquals("Profile Completeness", wd.findElement(By.xpath(LocString)).getText());
				System.out.println(wd.findElement(By.xpath(LocString)).getText());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	public static void click_element(WebDriver wd, String locate,
			String locString) {
		if("name".equalsIgnoreCase(locate)){
			wd.findElement(By.name(locString)).click();
			
		}
		if("linkText".equalsIgnoreCase(locate)){
			wd.findElement(By.linkText(locString)).click();
		}
		
	}

	public static void send_keys(WebDriver wd, String locate, String locString,
			String data) {
		if("xpath".equalsIgnoreCase(locate)){
			wd.findElement(By.xpath(locString)).clear();
			wd.findElement(By.xpath(locString)).sendKeys(data);
		}
		if("name".equalsIgnoreCase(locate)){
			wd.findElement(By.name(locString)).clear();
			wd.findElement(By.name(locString)).sendKeys(data);
			
		}
		if("id".equalsIgnoreCase(locate)){
			wd.findElement(By.id(locString)).clear();
			wd.findElement(By.id(locString)).sendKeys(data);
		}
		
	}

	public static void refresh(WebDriver wd) {
		wd.navigate().refresh();
		
	}

	public static void navigate_to(WebDriver wd, String url) {
		wd.get(url);
		
	}

	public static WebDriver open_browser(String browserType) {
		WebDriver wd1 = null;
		//System.out.println(browserType);
		if(browserType.equalsIgnoreCase("FireFox")){
			wd1 = new FirefoxDriver();
		}
		if(browserType.equalsIgnoreCase("IE")){
			wd1 = new InternetExplorerDriver();
		}
		if(browserType.equalsIgnoreCase("chrome")){
			wd1 = new ChromeDriver();
		}
		
		return wd1;
	}

}
