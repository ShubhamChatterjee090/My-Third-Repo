//Author: Gayathri
package webapp.OpenCartWebAutomation.TestResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartMyAccountPage;

public class BaseConfiguration {

	public static WebDriver driver;

	public static String getProperty(String keyName) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			String path = System.getProperty("user.dir");
			String propertiesFile = path + "\\resources\\data.properties";
			fis = new FileInputStream(propertiesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(keyName);
		return value;
	}
	@BeforeSuite
	public void initializingDriver()
	{
		String keyName="browser";
		String defaultBrowser="chrome";
	    String browserName=System.getProperty(keyName,defaultBrowser);
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver(); 
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	

	//@AfterSuite
	public void closingTheDriver() {
		driver.quit();
		driver = null;
	}

}
