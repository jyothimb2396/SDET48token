package POMBankingTestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POMBankingGenerics.BaseclassUtility;
import POMBankingGenerics.ExcelUtility;
import POMBankingGenerics.FileUtility;
import POMBankingGenerics.JavaUtility;
import POMBankingGenerics.WebDriverUtility;
import POMBankingPages.Application_Home_Page;
import POMBankingPages.Approve_Pendind_Account_Page;
import POMBankingPages.Confirm_Page;
import POMBankingPages.Register_Page;
import POMBankingPages.Staff_Home_Page;
import POMBankingPages.Staff_Login_Page;

public class Approve_account_Test extends BaseclassUtility 
{
	@Test
	public void approve_Account_Module()throws EncryptedDocumentException, IOException 
//	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		  // WebDriver driver=new ChromeDriver();
		   
		   ExcelUtility elib=new ExcelUtility();
		   JavaUtility jlib=new JavaUtility();
		   FileUtility flib=new FileUtility();
		   WebDriverUtility wlib = new WebDriverUtility();
		   
		    Application_Home_Page application_home_page=new Application_Home_Page(driver);
		    Register_Page register_Page=new Register_Page(driver);
		    Confirm_Page confirm_Page=new Confirm_Page(driver);
		    Staff_Login_Page  staff_Login_Page=new Staff_Login_Page(driver);
		    Staff_Home_Page staff_Home_Page=new Staff_Home_Page(driver);
		    Approve_Pendind_Account_Page approve_Pendind_Account=new Approve_Pendind_Account_Page(driver);
		
		    // Launching application
// 			driver.get(flib.get_Property_Value("Url"));
// 			
// 			// Entering implicitlywait
// 			wlib.wait_Till_Page_Gets_Loaded(driver);
// 			
// 			//Window Maximization
// 			wlib.maximize_Window(driver);
 			
 			//verifying the application home page
 			String verify="Online Banking System";
 			String display="Application Home page";
 			wlib.get_Title(driver, verify, display);
 			
 			
 			// click on open account button
 			application_home_page.Open_Account_button();
 			
 			//verifying the Online account opening form
 			verify="Registration Form";
 			display="Online account opening form";
 			wlib.get_Title(driver, verify, display);
 			
 			register_Page.enter_Details_Register(driver, elib, "Register");
//			// Entering Name into the Name textfield
			String Name=elib.get_Data_From_Excel("Register", 1, 0);
//			register_Page.Name_Textfield(Name);
//			
//			// Selecting Gender in Gender dropdown
//			String gender=elib.get_Data_From_Excel("Register", 1, 1);
//			register_Page.Gendr_Dropdown(gender);                              
//			
//			// Entering Mobile Number into the Mobile Number textfield
			String Mobile=elib.get_Data_From_Excel("Register", 1, 2);
//			register_Page.Mobile_Textfield(Mobile);
//			
//			// Entering Email_id into the Email_id textfield
//			String email_id=elib.get_Data_From_Excel("Register", 1, 3);
//			register_Page.Email_Textfield(email_id);
//			
//			// Entering Landline Number into the Landline Number textfield
//			String landline_no=elib.get_Data_From_Excel("Register", 1, 4);
//			register_Page.Landline_Textfield(landline_no);
			
			// Entering Date of Birth into the Date of Birth textfield
			String Day=elib.get_Data_From_Excel("Register", 1, 5);
			String Mon=elib.get_Data_From_Excel("Register", 1, 6);
			String Year=elib.get_Data_From_Excel("Register", 1, 7);
			register_Page.DateofBirth_Textfield(Day, Mon, Year);
			
//			// Entering Pan Number into the Pan textfield
			String Pan=elib.get_Data_From_Excel("Register", 1, 8); 
//			register_Page.Pan_Number_Textfield(Pan);
//			
//			// Entering Citizenship Number into the Citizenship Number textfield
//			String citizenship_no=elib.get_Data_From_Excel("Register", 1, 9);
//			register_Page.Citizenship_Number_Textfield(citizenship_no);
//			
//			// Entering Home Address into the Home Address textfield
//			String Home_address=elib.get_Data_From_Excel("Register", 1, 10);
//			register_Page.Home_Address_Textfield(Home_address); 
//			
//			// Entering Office Address into the Office Address textfield
//			String office_address=elib.get_Data_From_Excel("Register", 1, 11);
//			register_Page.Office_Address_Textfield(office_address); 
//			
//			// Selecting State in State dropdown
//			String state=elib.get_Data_From_Excel("Register", 1, 12);
//			register_Page.State_Dropdown(state);                                  
//			
//			// Selecting City in City dropdown
//			String city=elib.get_Data_From_Excel("Register", 1, 13);
//			register_Page.City_Dropdown(city);
//			
//			// Entering PinCode into the Pin textfield
//			String pin=elib.get_Data_From_Excel("Register", 1, 14);
//			register_Page.Pin_Number_Textfield(pin);
//			
//			// Entering Location into the Location textfield
//			String area_location=elib.get_Data_From_Excel("Register", 1, 15);
//			register_Page.Arealocation_Textfield(area_location);
//			
//			// Entering Nominee Name into the Nominee Name textfield
//			String nominee_name=elib.get_Data_From_Excel("Register", 1, 16);
//			register_Page.Nominee_Name_Textfield(nominee_name); 
//			
//			// Entering Nominee Account Number into the Nominee Account textfield
//			String nominee_account_no=elib.get_Data_From_Excel("Register", 1, 17);
//			register_Page.Nominee_Account_Textfield(nominee_account_no);
//			
//			// Selecting Account type in Account type dropdown					 
			String account_type=elib.get_Data_From_Excel("Register", 1, 18);
//			register_Page.Account_Type_Dropdown(account_type);
			
			//Click on submit Button
			register_Page.Submit_Button(); 
			
			// Verifying Confirm page is displaying
			verify="Confirm";
			display="Confirm page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Confirm_submit Button
			confirm_Page.Confirm_Button(); 
			
			// Verifying Application submitted successfully popup is displaying
			verify="Application submitted successfully";
			display="Application submitted successfully popup";
			String text = wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
			
			
			// Initializing the variable using Application no
			String ApplicationNumber="";
			for (int i = 0; i <text.length(); i++) 
			{
				if(Character.isDigit(text.charAt(i)))
				{
					ApplicationNumber=ApplicationNumber+text.charAt(i);
				}
				
			}
			//storing ApplicationNumber into Excel Sheet
			elib.insert_Data_Into_Excel("Application", 1, 0, ApplicationNumber);
			
			//verifying the application home page
			verify="Online Banking System";
			display="Application Home page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Staff login_button
			application_home_page.Staff_login_button();
			
			//Verifying staff home page is displaying
			verify="Staff";
			display="Staff login page";
			wlib.get_Title(driver, verify, display);
			
			staff_Login_Page.Enter_Details_into_Loginpage(driver, elib, "Staff Login Cred");
			
//			// Entering Staff Id into the Staff Id textfield
//			String Staff_id=elib.get_Data_From_Excel("Staff Login Cred", 1, 0);
//			staff_Login_Page.Staff_id_Textfield(Staff_id);
//			
//			// Entering Password into the Password textfield
//			String Password=elib.get_Data_From_Excel("Staff Login Cred", 1, 1);
//			staff_Login_Page.Password_Textfield(Password);
 			
 			//Click on login button
 			staff_Login_Page.Login_Button();
 			
 			//Verifying staff home page is displaying
 			verify="Staff Home";
 			display="Staff Home page";
 			wlib.get_Title(driver, verify, display);
 			
 			//Click on Approve Account 
 			staff_Home_Page.Approve_Pending_Account_button();
 			
 			//Verifying staff home page is displaying
 			verify="Pending Customers";
 			display="Pending Customers page";
 			wlib.get_Title(driver, verify, display);
 			
 			//Entering application number into the application number textfield
 			approve_Pendind_Account.Application_Number_Textfield(ApplicationNumber);
 			
 			//Click on search button
 			approve_Pendind_Account.Search_Button();
 			
 			//Verifying staff home page is displaying
 			verify="Pending Customers";
 			display="Pending Customers page";
 			wlib.get_Title(driver, verify, display);
 			
 			// Click on approve button
 			approve_Pendind_Account.Approve_Button();;
 			
 			//Verifying account created successfully popup is displaying
 			verify="Account Created Successfully";
 			display="Account created successfully popup";
 			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);

 			// Initializing the variable using Account no
 			String AccountNumber="";
 			for (int i = 0; i <text.length(); i++) 
 			{
 				if(Character.isDigit(text.charAt(i)))
 				{
 					AccountNumber=AccountNumber+text.charAt(i);
 				}
 				
 			}
 			
 			// Storing AAcount number in Excel
 			elib.insert_Data_Into_Excel("Account", 1, 0, AccountNumber);	        

	}

}
