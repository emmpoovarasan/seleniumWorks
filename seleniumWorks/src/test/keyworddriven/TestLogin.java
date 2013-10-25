package test.keyworddriven;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestLogin {
	String[][] steps = null;
	WebDriver wd = null;
	@Before
	public void testSetup() throws BiffException, IOException{
		File f = new File("src\\test\\keyworddriven\\KeywordDriven.xls");
		String fullFilePath = f.getAbsolutePath();
		//System.out.println(fullFilePath);
		//GetExcelData ge = new GetExcelData("C:\\Users\\POO\\git\\seleniumWorks\\seleniumWorks\\src\\test\\keyworddriven\\KeywordDriven.xls");
		GetExcelData ge = new GetExcelData(fullFilePath);
		
	}
	@Test
	public void testLoginWithValidAndInvalidCredentials() throws ArrayIndexOutOfBoundsException{
		steps = GetExcelData.extractDataFromExcel("Sheet1");
		
		// read excel data and store string arrays
		//System.out.println(steps.length);
		/*String [][] crossword= new String[18][8];
		for(int i=0; i < crossword.length; i++){
			for(int j=0; j < crossword[i].length; j++){
				crossword[i][j]= " "+ i + j+" ";
				System.out.print(crossword[i][j]+"\t");
			}
			System.out.println();
		}*/
		for(int i = 1; i< steps.length; i++){
			if(steps[i][0].equalsIgnoreCase("Y")){
				if("open_browser".equalsIgnoreCase(steps[i][4])){
					wd = GetExcelData.open_browser(steps[i][7]);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("navigate_to".equalsIgnoreCase(steps[i][4])){
					GetExcelData.navigate_to(wd,steps[i][7]);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("refresh".equalsIgnoreCase(steps[i][4])){
					GetExcelData.refresh(wd);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("send_keys".equalsIgnoreCase(steps[i][4])){
					GetExcelData.send_keys(wd,steps[i][5],steps[i][6],steps[i][7]);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("click_element".equalsIgnoreCase(steps[i][4])){
					GetExcelData.click_element(wd,steps[i][5],steps[i][6]);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("verify_element".equalsIgnoreCase(steps[i][4])){
					GetExcelData.verify_element(wd,steps[i][5],steps[i][6]);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
					
				}else if("close_browser".equalsIgnoreCase(steps[i][4])){
					GetExcelData.close_browser(wd);
					System.out.println(steps[i][3]+" -- "+steps[i][4]);
				}else{
					System.out.println(steps[i][3]+" -- "+"else--"+steps[i][4]);
				}
			}
		}
		
	}

}
