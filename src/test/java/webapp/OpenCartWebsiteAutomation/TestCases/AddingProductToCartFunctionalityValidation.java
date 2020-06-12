package webapp.OpenCartWebsiteAutomation.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webapp.OpenCartWebAutomation.TestResources.BaseConfiguration;
import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartCamerasProductPage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartHomePage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartMyAccountPage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartShoppingCartPage;
import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartSignInPage;

@Listeners(webapp.OpenCartWebAutomation.TestResources.Listener.class)
@Test
public class AddingProductToCartFunctionalityValidation extends BaseConfiguration {

	public void validatingAddProductToCartFunctionality() throws InterruptedException {
		
		BasePageForMethods basePage = new BasePageForMethods();
		OpenCartSignInPage openCartSignInPage = new OpenCartSignInPage();
		OpenCartHomePage openCartHomePage = new OpenCartHomePage();
		OpenCartMyAccountPage openCartMyAccountPage = new OpenCartMyAccountPage();
		OpenCartCamerasProductPage openCartCamerasProductPage = new OpenCartCamerasProductPage();
		OpenCartShoppingCartPage openCartShoppingCartPage = new OpenCartShoppingCartPage();

		basePage.launchingUrl("url", "homePgTitle");
		openCartHomePage.clickingOnLogin("loginOptionText", "loginPgTitle");
		openCartSignInPage.fillingUpCredentialsForLogin("email", "password", "myAccountPgTitle");
		openCartMyAccountPage.clickingOnCamerasProductCategory("camerasOption", "camerasPgTitle");
		openCartCamerasProductPage.selectingDesiredCameraFromList("nikonCamera", "nikonCameraPgTitle", "quantity",
				"checkOutOption", "addToCartSuccessMsg", "shoppingCartPgTitle");
		openCartShoppingCartPage.validatingProductInShoppingCartPage("nikonCamera", "quantity");
		openCartMyAccountPage.signingOutFromAccount("logoutOptionText", "accountLogoutPgTitle");

	}

}
