package Practiceprgm;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import POMBankingGenerics.ExcelUtility;
import POMBankingGenerics.FileUtility;
import POMBankingGenerics.WebDriverUtility;

public class ActitimegenericExcel 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver ;
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		//JavaUtility jutil = new JavaUtility();
		 WebDriverUtility wutil = new WebDriverUtility();
		 
		 //fetch the data from property file
		 String Browser = futil.get_Property_Value("browser1");
		driver=wutil.VerifyDriver(Browser);
		
		//webDriverUtility.waitTillPageGetsLoad(driver);
		wutil.maximize_Window(driver);	

		//open the browser
		String Url1 = futil.get_Property_Value("url1");
		driver.get(Url1);

////		
//		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Actitime");
//	
		String USN = eutil.get_Data_From_Excel("Actitime", 1, 0);
		 String usn = USN;
		 System.out.println(usn);
		driver.findElement(By.name("username")).sendKeys(USN);
		Thread.sleep(1000);
		String PSW = eutil.get_Data_From_Excel("Sheet3", 1, 1);
		driver.findElement(By.name("pwd")).sendKeys(PSW);
		Thread.sleep(1000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
