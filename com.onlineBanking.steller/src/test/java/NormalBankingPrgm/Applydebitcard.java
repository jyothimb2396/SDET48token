package NormalBankingPrgm;


//first change as a local branch in applydebit card then commit changes
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Applydebitcard

{
	public static void main(String[] args) throws InterruptedException 
	{
		//open the browser 
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
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
		 String name = "chinnu";
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		
		//selecting the gender from the drop down
		String gender ="Female";
		WebElement ele = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s = new Select(ele);
		s.selectByVisibleText(gender);
		
		//enter the mobile number
		String mobile = "7411294233";
		driver.findElement(By.xpath("//input[@placeholder='Mobile no']")).sendKeys(mobile);
		
		//enter the email id
		String email ="chinnu@gmail.com";
		driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys(email);
		
		//enter the landline number
		driver.findElement(By.xpath("//input[@placeholder='Landline no']")).sendKeys("7411294233");
		
		//select the date
		String mon = "03";
		String day ="02";
		String year ="1996";
		WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date.click();
		date.sendKeys(mon);
		date.sendKeys(day);
		date.sendKeys(year);
		
		//enter the pan number
		String pan="abcd1234";
		driver.findElement(By.xpath("//input[@placeholder='PAN Number']")).sendKeys(pan);
		
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
		
		 //login as staff
		 driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		
		 
		 //enter username, password,click on login button
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys("210001");
		 driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");
		 driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		 
		//click on approve pending account 
		 driver.findElement(By.xpath("//input[@value='Approve Pending Account']")).click();
		 
		 //pass the application number
		 driver.findElement(By.xpath("//input[@placeholder='Application number']")).sendKeys(appno);
		 
		 //click on approve button
		 driver.findElement(By.name("approve_cust")).click();
		
		 //handling the alert and confirmation popup
		 Alert a1 =driver.switchTo().alert(); 
		 String alertmsg1 = driver.switchTo().alert().getText();
		 System.out.println(alertmsg1);
			String text1[]=alertmsg1.split(" ");
		String accno = text1[4].substring(1,14);
		System.out.println(accno);
		String acc = accno;
		 a1.accept();
		
		 driver.findElement(By.xpath("//img[@class='logo_img']")).click();
		 
		 //apply for debitcard
		 driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
		String url3 = driver.getCurrentUrl();
		if(url3.contains("debit_card_form"))
		{
			System.out.println("debit card page is displayed");
		}
		else 
		{
			System.out.println("debit card page is not displayed");
		}
		driver.findElement(By.name("holder_name")).sendKeys(name);
		Thread.sleep(2000);
		WebElement d1 = driver.findElement(By.name("dob"));
		d1.click();
		d1.sendKeys(mon);
		d1.sendKeys(day);
		d1.sendKeys(year);
		driver.findElement(By.name("pan")).sendKeys(pan);
		driver.findElement(By.name("mob")).sendKeys(mobile);
		driver.findElement(By.name("acc_no")).sendKeys(acc);
		Thread.sleep(2000);
		driver.findElement(By.name("dbt_crd_submit")).click();
		Thread.sleep(2000);
		 //handling the debit card no dispalyed popup
		 Alert a2 =driver.switchTo().alert();
		String alertmsg2 = driver.switchTo().alert().getText();
		System.out.println(alertmsg2);
		
		//get only application number from the popup
		text=alertmsg2.split(" ");	
		/*for( int i =0; i<text.length;i++)
		{
		System.out.println(i+"----"+text[i]);
		}*/
		String debitno = text[17];
		String pin = text[22];
		System.out.println(debitno);
		System.out.println(pin);
		Thread.sleep(2000);
		a2.accept();
		
		driver.findElement(By.xpath("//img[@class='logo_img']")).click();
		
		//apply for internet banking
		 JavascriptExecutor jse =(JavascriptExecutor) driver;
		 WebElement register = driver.findElement(By.xpath("//div[@class='ebanking']"));
		 jse.executeScript("arguments[0].scrollIntoView();", register);
		 Actions action = new Actions(driver);
		 action.moveToElement(register).perform();
		 driver.findElement(By.xpath("//li[.='Register']")).click();
		 driver.findElement(By.name("holder_name")).sendKeys(name);
		 
		 driver.findElement(By.name("holder_name")).sendKeys(name);
		 driver.findElement(By.name("accnum")).sendKeys(accno);
		 driver.findElement(By.name("dbtcard")).sendKeys(debitno);
		 driver.findElement(By.name("dbtpin")).sendKeys(pin);
		 driver.findElement(By.name("mobile")).sendKeys(mobile);
		 driver.findElement(By.name("pan_no")).sendKeys(pan);
		 WebElement dob1 = driver.findElement(By.name("dob"));
		dob1.click();
		dob1.sendKeys(mon);
		dob1.sendKeys(day);
		dob1.sendKeys(year);
		
		 driver.findElement(By.name("last_trans")).sendKeys("0");
		 WebElement password = driver.findElement(By.name("password"));
		 String pass = "12341234";
		password.sendKeys(pass);
		 WebElement confirmpass = driver.findElement(By.name("cnfrm_password"));
		 String conf ="12341234";
		 confirmpass.sendKeys(conf);
		 Thread.sleep(2000);
		 driver.findElement(By.name("submit")).click();
		
	}
}


