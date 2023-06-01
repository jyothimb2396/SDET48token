package Practiceprgm;


import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Actitimefrompropertyfile 
{
	public static void main(String[] args) throws Throwable 
	{

		//fetch the property using only proprty file (no use of generic)
		//System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/commondta.properties.txt");
		Properties p = new Properties();
			p.load(fis);
			//driver=new ChromeDriver();
		String Url1 = p.getProperty("url1");
		String Username = p.getProperty("username1");
		String Password = p.getProperty("password1");
		String Browser = p.getProperty("browser1");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
			driver = new ChromeDriver();
		driver.get(Url1);
		driver.findElement(By.name("username")).sendKeys(Username);
		Thread.sleep(1000);
		driver.findElement(By.name("pwd")).sendKeys(Password);
		Thread.sleep(1000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(1000);
		driver.quit();	
	}
	
		
}
