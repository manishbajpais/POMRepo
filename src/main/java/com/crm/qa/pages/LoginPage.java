/**
 * 
 */
package com.crm.qa.pages;

import java.sql.Driver;

import javax.swing.GroupLayout.ParallelGroup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import net.bytebuddy.asm.Advice.This;

/**
 * @author manish
 *
 */
public class LoginPage extends TestBase {
	//PageFactory  OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[@type='submit']")
	@FindBy(partialLinkText="Login")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	
	//@FindBy()
	//#1 Free CRM software in the cloud for sales and service
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmimage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		driver.switchTo().frame(2);
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguement[0].click",loginbtn.click(););*/
		
		return new HomePage();
	}

}
