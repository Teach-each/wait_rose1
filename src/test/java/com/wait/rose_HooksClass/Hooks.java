package com.wait.rose_HooksClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.wait.rose_constants.constants;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Hooks  {
	public static WebDriver driver;
	public static ChromeOptions op;
	

	
	@Before
	public void chromeOptions() {
		 op = new ChromeOptions();
		op.addArguments("--maximized");
		op.addArguments("--incognito");
		op.addArguments("--disable-popup-blocking");
	}
	
	public static void launchBrowser() {
		
		
		//String browser = constants.browser_con;
		String browser=constants.browser_con; //chrome
		
		
		try {
			switch (browser) {
			case "chrome":
			
			WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	         break;

			case "edge":
	        WebDriverManager.edgedriver().setup();
	       driver = new EdgeDriver();
	        break;
	        
			case "firefox":
	        WebDriverManager.firefoxdriver().setup();
	        driver= new FirefoxDriver();
	        break;
	        
			case "ie":
	        WebDriverManager.iedriver().setup();
	        driver = new InternetExplorerDriver();
	        break;
	        
	        default:
	        		        	
			
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static void launch_url() {
		driver.manage().window().maximize();
		driver.get(constants.app_url_con);	
		
	}
	
	@io.cucumber.java.After
	public void tear_Down() throws InterruptedException   {
		
		driver.quit();
	}
	

}
