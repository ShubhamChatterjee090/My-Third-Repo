package webapp.OpenCartWebsiteAutomation.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webapp.OpenCartWebAutomation.TestResources.BaseConfiguration;
import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartHomePage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartMyAccountPage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartSignInPage;

@Listeners(webapp.OpenCartWebAutomation.TestResources.Listener.class)
@Test
public class SignInFunctionalityValidation extends BaseConfiguration {

	public void validatingLoginFunctionalityOfOpenCart() {
		BasePageForMethods basePage = new BasePageForMethods();
		OpenCartHomePage openCartHomePage = new OpenCartHomePage();
		OpenCartSignInPage openCartSignInPage = new OpenCartSignInPage();
		OpenCartMyAccountPage openCartMyAccountPage=new OpenCartMyAccountPage();

		basePage.launchingUrl("url","homePgTitle");
		openCartHomePage.clickingOnLogin("loginOptionText", "loginPgTitle");
		openCartSignInPage.fillingUpCredentialsForLogin("email", "password", "myAccountPgTitle");
		openCartMyAccountPage.signingOutFromAccount("logoutOptionText","accountLogoutPgTitle");
		

	}

}
