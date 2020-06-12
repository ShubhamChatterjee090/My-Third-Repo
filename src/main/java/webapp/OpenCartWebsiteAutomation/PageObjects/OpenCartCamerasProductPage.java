package webapp.OpenCartWebsiteAutomation.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartCamerasProductPage extends BasePageForMethods {
	
	private static Logger log = LogManager.getLogger(OpenCartCamerasProductPage.class.getName());
	
	public static By camerasProductList=By.xpath(getProperty("CamerasProductList"));
	public static By nikonCamera=By.xpath(getProperty("NikonCamera"));
	public static By quantityInputField=By.xpath(getProperty("QuantityInputField"));
	public static By addToCartButton=By.xpath(getProperty("AddToCartButton"));
	public static By productAddedToCartSuccessMsg=By.xpath(getProperty("ProductAddedToCartSuccessMsg"));
	public static By cartTotalSection=By.xpath(getProperty("CartTotalSection"));
	public static By cartOptions=By.xpath(getProperty("CartOptions"));
	
	
	
	public void selectingDesiredCameraFromList(String nikonCameraOption,String titleOfNikonCameraPg,String quantity,String checkoutOption,String addToCartSuccessMsg,String titleOfShoppingCartPg) throws InterruptedException
	{
		log.debug("Selecting Nikon D300 camera");
		clickingOnWebelementThroughJavascript(nikonCamera);
		log.debug("Checking for page navigation ");
		String nikonCameraPgTitle=fetchingPageTitle();
		Assert.assertTrue(nikonCameraPgTitle.contains(getProperty(titleOfNikonCameraPg)),"Incorrect, it is not navigated to the Nikon D300 Camera page");
		log.info("Success!! it has been correctly navigated to Nikon D300 camera Page");
		log.debug("Entering the required quantity");
		passingValue(quantityInputField, getProperty(quantity));
		log.debug("Clicking on Add to Cart button");
		clickOnElement(addToCartButton);
		log.debug("Checking for Product added to cart success message");
		String messageAfterProductAddedToCart=fetchingText(productAddedToCartSuccessMsg);
		Assert.assertTrue(messageAfterProductAddedToCart.contains(getProperty(addToCartSuccessMsg)),"Incorrect, product added to cart success message did not come");
		log.info("Success!! product added to cart");
		log.debug("Clicking on Cart Total Section");
		clickOnElement(cartTotalSection);
		log.debug("Clicking on Checkout option");
		clickingDesiredValueFromMultipleElements(cartOptions,getProperty(checkoutOption));
		log.debug("Checking for page navigation");
		String shoppingCartPgTitle=fetchingPageTitle();
		Assert.assertTrue(shoppingCartPgTitle.equals(getProperty(titleOfShoppingCartPg)),"Incorrect, it is not navigated to the Shopping cart page");
		log.info("Success!! it has been correctly navigated to the Shopping cart Page");
		
	}
	
	

}
