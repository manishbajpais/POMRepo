/**
 * 
 */
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;
import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

/**
 * @author manish
 *
 */
public class TestBase {
	protected static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browseName = prop.getProperty("browser");
		if(browseName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/manish/Desktop/SeleniumBrowserDriver/chromedriver");
			driver = new ChromeDriver();
		}  else if (browseName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "/Users/manish/Desktop/SeleniumBrowserDriver/geckodriver");
			driver = new FirefoxDriver();
		} 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
