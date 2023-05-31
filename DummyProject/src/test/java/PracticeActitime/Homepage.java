package PracticeActitime;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericsBank.PathConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage
{
	public static void main(String[] args) throws InterruptedException {
		

	WebDriverManager.chromedriver().create();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PathConstants.implicitWaitDuration));
	
	//enter the url
	driver.get("http://localhost/login.do");
	Thread.sleep(2000);
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	driver.findElement(By.xpath("//a[@class='content tt_selected selected']")).click();
//	WebElement d1 = driver.findElement(By.id("ext-gen10"));
//	d1.click();
//	driver.findElement(By.xpath("//span[.='31']")).click();
//	driver.findElement(By.xpath("//input[@placeholder='Add task by name']")).sendKeys("write test case");
//	driver.findElement(By.id("SubmitTTButton")).click();
	driver.findElement(By.xpath("//a[.='New']")).click();
}
}
