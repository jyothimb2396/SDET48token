package Bankscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Viewbyaccno 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//open the browser 
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//enter the url
		driver.get("http://rmgtestingserver/domain/Online_Banking_System");
		Thread.sleep(2000);
		
		//click on open account major tab
		driver.findElement(By.xpath("//li[.='Open Account']")).click();
		
		//verify open account page is displayed or not
		 String url = driver.getCurrentUrl();
		 if(url.contains("customer_reg_form"))
		 {
			 System.out.println("open account page is displayed");
		 }
		 else 
		 {
			System.out.println("open account page is not dispalyed"); 
		 }
		 
		 //enter name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("chinnu");
		
		//selecting the gender from the drop down
		WebElement ele = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s = new Select(ele);
		s.selectByVisibleText("Female");
		
		//enter the mobile number
		driver.findElement(By.xpath("//input[@placeholder='Mobile no']")).sendKeys("7411294233");
		
		//enter the email id
		driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys("chinnu@gmail.com");
		
		//enter the landline number
		driver.findElement(By.xpath("//input[@placeholder='Landline no']")).sendKeys("7411294233");
		
		//select the date
		WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date.click();
		date.sendKeys("03");
		date.sendKeys("02");
		date.sendKeys("1996");
		
		//enter the pan number
		driver.findElement(By.xpath("//input[@placeholder='PAN Number']")).sendKeys("abcd1234");
		
		//enter the citizenship no
		driver.findElement(By.xpath("//input[@placeholder='Citizenship Number']")).sendKeys("01");
		
		//enter the home address
		driver.findElement(By.xpath("//input[@placeholder='Home Address']")).sendKeys("@bangalore");
		
		//enter the official adress
		driver.findElement(By.xpath("//input[@placeholder='Office Address']")).sendKeys("@bangalore");
		
		//enter the country
		driver.findElement(By.xpath("//input[@placeholder='US']")).sendKeys("us");
		
		//enter the state  
		driver.findElement(By.xpath("//select[@name='state']/option[2]")).click();
		
		//enter the city
		driver.findElement(By.xpath("//select[@name='city']/option[16]")).click();
		
		//enter the pincode
		driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).sendKeys("587102");
		
		//enter the area/locality
		driver.findElement(By.xpath("//input[@placeholder='Area/Locality']")).sendKeys("bangalore");
		
		//enter the nominee name
		driver.findElement(By.xpath("//input[@placeholder='Nominee Name (If any)']")).sendKeys("ammu1");
		
		//enter the nominee account
		driver.findElement(By.xpath("//input[@placeholder='Nominee Account no']")).sendKeys("1234567890");
		
		//select the account type
		driver.findElement(By.xpath("//select[@name='acctype']/option[2]")).click();
		
		//click on submit button   
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		//verify open account page is displayed or not
		 String url1 = driver.getCurrentUrl();
		 if(url1.contains("cust_regfrm_confirm"))
		 {
			 System.out.println("Applicant details is displayed");
		 }
		 else 
		 {
			System.out.println("Applicant details is not displayed"); 
		 }
		 //click on confirm button
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 Thread.sleep(3000);
		 
		 //handling the account no dispalyed popup
		 Alert a =driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		
		//get only application number from the popup
		String text[]=alertmsg.split(" ");	
		String appno = text[5];
		System.out.println(appno);
		 a.accept();
		 //verifying the Application home page is displyaing or not
		 String url2 = driver.getCurrentUrl();
		 if(url2.contains("index"))
		 {
			 System.out.println("Application Home page is displayed");
		 }
		 else 
		 {
			 System.out.println("Application home is not displayed");
		 }
		 Thread.sleep(2000);
		 //login as staff
		 driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		 Thread.sleep(2000);
		 
		 //enter username, password,click on login button
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys("210001");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		 Thread.sleep(2000);
		 
		//click on approve pending account 
		 driver.findElement(By.xpath("//input[@value='Approve Pending Account']")).click();
		 Thread.sleep(2000);
		 
		 //pass the application number
		 driver.findElement(By.xpath("//input[@placeholder='Application number']")).sendKeys(appno);
		 Thread.sleep(2000);
		 
		 //click on approve button
		 driver.findElement(By.xpath("//input[@value='Approve']")).click();
		 Thread.sleep(1000);
		 
		 //handling the alert and confirmation popup
		 Alert a1 =driver.switchTo().alert();
		 
		 String alertmsg1 = driver.switchTo().alert().getText();
			String text1[]=alertmsg1.split(" ");	

		/*for( int i =0; i<text1.length;i++)
		{
		System.out.println(i+"----"+text1[i]);
		}*/
		String accno = text1[4].substring(1,14);
		System.out.println(accno);
		//String acc = accno;
		 a1.accept();
		 
		//click on view active cutomer and check for active customer 
		driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		String url5 = driver.getCurrentUrl();
		if(url5.contains("taff_login"))
		{
			System.out.println("staff login page is displayed");
		}
		else 
		{
			System.out.println("staff login page is not displayed");
		}
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys("210001");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		 Thread.sleep(1000);
		
	
		 //click on view active customer
		 driver.findElement(By.xpath("//input[@value='View Active Customer']")).click();
		 
		 //verifying the active customer
		 String url3 = driver.getCurrentUrl();
		 if(url3.contains("active_customers"))
		 {
			 System.out.println("active customer account are displayed");
		 }
		 else
		 {
			 System.out.println("active customer account are not displayed");
		 }
		 
		 //Verifying view customer by account number
		 driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys("210001");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		 Thread.sleep(1000);

		 
		 //Verifying the view customer by account number
		 driver.findElement(By.xpath("//input[@value='View Customer by A/c No']")).click();
		String url4 = driver.getCurrentUrl();
		if(url4.contains("view_customer_by_acc_no"))
		{
			System.out.println("view customer by account number page is displayed");
		}
		else 
		{
			System.out.println("view customer by account number page is not displayed");
		}
		/*WebElement CUSTNO = driver.findElement(By.xpath("//input[@placeholder='Customer Account No']"));
		CUSTNO.click();
	     CUSTNO.sendKeys(accno);*/
	     WebElement vc = driver.findElement(By.name("account_no"));
	     //vc.click();
	     vc.sendKeys(accno);
		 driver.findElement(By.name("submit_view")).click();
		 
		 //verifying the cust details
		 String text2 = driver.findElement(By.xpath("//div[@class='cust_details']/label[2]")).getText();
		 if(text2.contains(accno)) 
		 {
			System.out.println("customer acc number is present"); 
		 }
		 else
		 {
			 System.out.println("customer acc number is not present");
		 }
		 
	}

}
