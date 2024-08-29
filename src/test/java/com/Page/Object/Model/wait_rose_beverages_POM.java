package com.Page.Object.Model;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Helper.utilities.Helper;
import com.wait.rose.Base.base;
import com.wait.rose_HooksClass.Hooks;

public class wait_rose_beverages_POM extends base {
	

 private WebDriver driver; // instance variable



// Constructor to initialize the WebElements
 public wait_rose_beverages_POM() {
	
    this.driver =  Hooks.driver;
    PageFactory.initElements(Hooks.driver, this);
}
//		
 
    @FindBy(xpath="//button[contains(@class,'acceptAll')]")
	public WebElement accept_Cookies;
 
	@FindBy(xpath = "//div[@class='account___eYb7V']//child::a[1]")
	private WebElement sign_In_Btn;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email_Txt_Box;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_Txt_Box;
	
	@FindBy(id = "loginSubmit")
	private WebElement login_Btn;
	
	
	
//==============================================================================>
	@FindBy(xpath = "//p[contains(text(),'Please enter your email address')]")
	private WebElement err_Msg_Enter_Email;

	@FindBy(xpath = "//p[contains(text(),'Please enter your password')]")
	private WebElement err_Msg_Enter_Password;

	@FindBy(xpath = "//p[contains(text(),'Please enter a valid email address')]")
	private WebElement err_Msg_Enter_Valid_Email;

	@FindBy(xpath = "//p[contains(text(),'Please check your email and password')]")
	private WebElement err_Msg_Check_email_Password;
	
	
	
	/** example for encapsulation
	 * 
	 * @return
	 */
	
	 public  WebElement get_login_Btn_Element() { 
		 WebElement e1=login_Btn;
		 return e1;
	 }

	  
	public void click_SignIn() {
		sign_In_Btn.click();
	}
	
	
	/**
	 Example for method overloading 
	 * @param data
	 */
	
	public void enter_email(String data) {
		//email_Txt_Box.sendKeys(data);
		
		send_Text(email_Txt_Box, data, "Input is given as "+data);
	}
	
	public void enter_Password(String data) {
	//	password_Txt_Box.sendKeys(data);
		send_Text(password_Txt_Box, data, "Input is given as "+data);
	}
	
	public String get_Text_Error_EnterEmail() {
		 return err_Msg_Enter_Email.getText();
	}
	
	public void click_login_Btn() {
		login_Btn.click();
	}
	

	/**                      
	   "invalid_Username": "Please check your email and password",
      "invalid_password": "Please check your email and password",
      
      "Not_entering_email": "Please enter your email address",
       "Not_enetering_Password": "Please enter your password",
       
       "Enter_valid_email": "Please enter a valid email address"
       
       user enters email         null   ==> to validate Not_entering_email [click]
       user enters password    valid
       user click on login      yes
       ===================================================================
        user enters email         valid   ==> Not_enetering_Password [click]
       user enters password    null
       user click on login      yes
       ===================================================================
       user enters email         invalid   ==> invalid_Username [click]
       user enters password    valid
       user click on login      yes
       ===================================================================
        user enters email         valid   ==> invalid_password [click]
       user enters password    invalid
       user click on login      yes
       ==================================================================
        user enters email      wrong_format   ==> Enter_valid_email [ no needed to click]
       user enters password    valid
       user click on login      yes
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	

	
	public void enter_login_Details_And_validate(String username, String password,
			String errorKey, String file) throws IOException, ParseException, InterruptedException {

		accept_Cookies.click();
		click_SignIn();
		Thread.sleep(9000);
		String  key_value_Error_message= Helper.read_JSON(file, errorKey);
		
		switch (errorKey) {
		
		case "Not_entering_email":
			enter_email(username);//null
			enter_Password(password);//valid pwd
			click_login_Btn(); //click login
			Assert.assertEquals(err_Msg_Enter_Email.getText(), key_value_Error_message);
			
			break;
			
		case "Not_enetering_Password":
			enter_email(username);
			enter_Password(password);
			click_login_Btn();
			Assert.assertEquals(err_Msg_Enter_Password.getText(), key_value_Error_message);
			
			break;
			
		case "invalid_Username":
			enter_email(username);
			enter_Password(password);
			click_login_Btn();
			Assert.assertEquals(err_Msg_Check_email_Password.getText(), key_value_Error_message);
			break;
			
		case "invalid_password":
			enter_email(username);
			enter_Password(password);
			click_login_Btn();
			Assert.assertEquals(err_Msg_Check_email_Password.getText(), key_value_Error_message);
			break;
			
		case "Enter_valid_email":
			enter_email(username);
			enter_Password(password);
			Assert.assertEquals(err_Msg_Enter_Valid_Email.getText(), key_value_Error_message);
			break;
			
		case "valid_email_and_password":
			enter_email(username);
			enter_Password(password);
			click_login_Btn();
			System.out.println(driver.getTitle());
			break;
			
			
			
	  default:
		  break;
			
		}
		
		
		
	
		
		
	}


}
