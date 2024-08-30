package com.wait.rose_step_defenition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Helper.utilities.Helper;
import com.Page.Object.Model.wait_rose_beverages_POM;
import com.wait.rose_HooksClass.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.qameta.allure.Allure;

public class wait_rose_beverages  {
	wait_rose_beverages_POM ref=null;
	 


@Given("I launch the browser {string}")
public void i_launch_the_browser(String key) throws IOException {
   Helper.get_Browser_Type(key);
   Hooks.launchBrowser();
}
	
	@Then("Launch the Browser {string}")
	public void launch_the_browser(String key) throws IOException {
       Helper.getURL(key);
		Hooks.launch_url();
	}
	
	@Then("user enters the {string} and {string} and click on signin and validate {string} from file {string}")
	public void user_enters_the_and_and_click_on_signin_and_validate_from_file(String username, String password, String err, String file) throws IOException, ParseException, InterruptedException {
		ref = new wait_rose_beverages_POM();
		ref.enter_login_Details_And_validate(username, password, err, file);
	
	}

//	@Then("user validates the login dashboard Page title {string}")
//	public void user_validates_the_login_dashboard_page_title(String string) {
//	    String title = Hooks.driver.getTitle();
//	    System.out.println(title);
//	    assertEquals(title, "ABC");
//	}

	

	@Then("user validates the dashboard {string} along with the information for {string}")
	public void user_validates_the_dashboard_along_with_the_information_for(String data1, String data2) {
		ref.validate_Dashboard(data1, data2);
	   
	}
	






}
