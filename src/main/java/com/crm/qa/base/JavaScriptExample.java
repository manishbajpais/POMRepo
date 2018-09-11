package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExample {
	public static void mains(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/manish/Desktop/SeleniumBrowserDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("manish123");
		driver.findElement(By.name("password")).sendKeys("manish123");
		//driver.findElement(By.partialLinkText("Login")).click();
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		driver.switchTo().frame(1);
		//WebElement LastTry1 = driver.findElements(By.partialLinkText("Login")).get(0);
		WebElement LastTry1= driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", LastTry1);
		
		/*WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		flash(loginBtn, driver);*/
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i =0;i<10;i++) {
			changeColor("rgb(0,200,0)",element, driver);
			changeColor(bgcolor,element,driver);
		}
		
 	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver ) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].style.backgroundColor='"+color+"'", element);
	}

}
