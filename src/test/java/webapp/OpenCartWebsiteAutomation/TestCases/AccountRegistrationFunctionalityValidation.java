package webapp.OpenCartWebsiteAutomation.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webapp.OpenCartWebAutomation.TestResources.BaseConfiguration;
import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartHomePage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartMyAccountPage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartRegisterAccountPage;

@Listeners(webapp.OpenCartWebAutomation.TestResources.Listener.class)
@Test
public class AccountRegistrationFunctionalityValidation extends BaseConfiguration {

	public void validatingNewAccountRegistrationFunctionality() {
		BasePageForMethods basePage = new BasePageForMethods();
		OpenCartHomePage openCartHomePage = new OpenCartHomePage();
		OpenCartRegisterAccountPage openCartRegisterAccountPage = new OpenCartRegisterAccountPage();
		OpenCartMyAccountPage openCartMyAccountPage=new OpenCartMyAccountPage();

		basePage.launchingUrl("url", "homePgTitle");
		openCartHomePage.clickingOnLogin("registerOptionText", "accountRegisterPgTitle");
		openCartRegisterAccountPage.fillingUpDetailsForNewRegistration("firstName", "lastName", "email", "phone",
				"password", "accountRegSuccessfulPgTitle");
		openCartRegisterAccountPage.validatingAccountRegistrationSuccess("registrationSucccessMessage");
		openCartMyAccountPage.signingOutFromAccount("logoutOptionText","accountLogoutPgTitle");

	}

}
