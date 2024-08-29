package com.wait.rose.Base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wait.rose_HooksClass.Hooks;
public class base {

		WebDriver driver;
		
		public void base() {
			this.driver=Hooks.driver;
		}
		
		public void click_WB(WebElement el, String msg) {
			el.click();
			System.out.println("Clicked on "+ msg);
			
		}
		
		public void click_WB(String el, String msg) {
			driver.findElement(By.xpath(el)).click();
			System.out.println("clicked on "+msg);
			
		}
		
		
		public void send_Text(WebElement el, String key, String message) {
			el.sendKeys(key);
			System.out.println(message);
			
		}
		
		
		public void select_based_on_text(WebElement el, String key, String message) {
			
			new Select(el).selectByValue(key);
			System.out.println(message +" is selected");
			
		}
		
		public void press_Enter(WebElement el, String message) {
			el.sendKeys(Keys.ENTER);
			
		}
		

	

}
