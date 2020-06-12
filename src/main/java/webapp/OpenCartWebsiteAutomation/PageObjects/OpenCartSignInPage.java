package webapp.OpenCartWebsiteAutomation.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartSignInPage extends BasePageForMethods {
	
	private static Logger log = LogManager.getLogger(OpenCartSignInPage.class.getName());
	
	public static By emailIdInputField=By.xpath(getProperty("EmailIdInputField"));
	public static By passwordInputField=By.xpath(getProperty("PasswordInputField"));
	public static By loginButton=By.xpath(getProperty("LoginButton"));
	
	public void fillingUpCredentialsForLogin(String email,String password,String titleOfMyAccountPg)
	{
		log.debug("Entering email id ");
		passingValue(emailIdInputField, getProperty(email));
		log.debug("Entering password ");
		passingValue(passwordInputField,getProperty(password));
		log.debug("Clicking on login");
		clickOnElement(loginButton);
		log.debug("Checking for page navigation");
		String myAccountPgTitle=fetchingPageTitle();
		Assert.assertTrue(myAccountPgTitle.equals(getProperty(titleOfMyAccountPg)),"Incorrect, it is not navigated to the My Account page");
		log.info("Success!! it has been correctly navigated to the My Account Page");
		
		
	}
	

}
