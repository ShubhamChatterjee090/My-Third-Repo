package webapp.OpenCartWebsiteAutomation.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartMyAccountPage extends BasePageForMethods {

	private static Logger log=LogManager.getLogger(OpenCartMyAccountPage.class.getName());
	
	public static By productsSection=By.xpath(getProperty("ProductsSection"));
	
	public void signingOutFromAccount(String optionName,String titleOfSignOutPg)
	{
		log.debug("Clicking on My Account ");
		clickOnElement(OpenCartHomePage.myAccount);
		log.debug("Clicking Logout from My Account options dropdown ");
		clickingDesiredValueFromMultipleElements(OpenCartHomePage.myAccountOptionsDropdown,getProperty(optionName));
		log.debug("Checking for page navigation");
		String signOutPgTitle=fetchingPageTitle();
		Assert.assertTrue(signOutPgTitle.equals(getProperty(titleOfSignOutPg)),"Incorrect, it is not navigated to the Sign Out page");
		log.info("Success!! it has been correctly navigated to the Sign Out Page");
	}
	
	public void clickingOnCamerasProductCategory(String camerasOption, String titleOfCamerasProductPg)
	{
		log.debug("Clicking on Cameras from the list of products");
		clickingDesiredValueFromMultipleElements(productsSection,getProperty(camerasOption));
		String camerasProductPgTitle=fetchingPageTitle();
		Assert.assertTrue(camerasProductPgTitle.equals(getProperty(titleOfCamerasProductPg)),"Incorrect, it is not navigated to correct page");
		log.info("Success!! it has been correctly navigated to the Cameras Product Page");
	}
}
