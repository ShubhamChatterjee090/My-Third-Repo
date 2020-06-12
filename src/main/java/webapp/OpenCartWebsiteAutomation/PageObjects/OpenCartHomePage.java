package webapp.OpenCartWebsiteAutomation.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartHomePage extends BasePageForMethods {
	
	private static Logger log = LogManager.getLogger(OpenCartHomePage.class.getName());
	
	public static By myAccount=By.xpath(getProperty("MyAccount"));
	public static By myAccountOptionsDropdown=By.xpath(getProperty("MyAccountOptionsDropdown"));
	
	
	
	public void clickingOnLogin(String optionName,String titleOfSignInPg)
	{
		log.debug("Clicking on My Account ");
		clickOnElement(myAccount);
		log.debug("Clicking Login from My Account options dropdown ");
		clickingDesiredValueFromMultipleElements(myAccountOptionsDropdown,getProperty(optionName));
		log.debug("Checking for page navigation");
		String signInPgTitle=fetchingPageTitle();
		Assert.assertTrue(signInPgTitle.equals(getProperty(titleOfSignInPg)),"Incorrect, it is not navigated to the Sign In page");
		log.info("Success!! it has been correctly navigated to the Sign In Page");
		
	}
	
	public void clickingOnRegister(String optionName,String titleOfAccountRegisterPg)
	{
		log.debug("Clicking on My Account ");
		clickOnElement(myAccount);
		log.debug("Clicking Login from My Account options dropdown ");
		clickingDesiredValueFromMultipleElements(myAccountOptionsDropdown,getProperty(optionName));
		log.debug("Checking for page navigation");
		String accountRegisterPgTitle=fetchingPageTitle();
		Assert.assertTrue(accountRegisterPgTitle.equals(getProperty(titleOfAccountRegisterPg)),"Incorrect, it is not navigated to the Account Registration page");
		log.info("Success!! it has been correctly navigated to the Account Registration Page");
		
	}
	

}
