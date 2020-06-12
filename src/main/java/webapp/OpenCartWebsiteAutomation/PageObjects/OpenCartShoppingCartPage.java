package webapp.OpenCartWebsiteAutomation.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartShoppingCartPage extends BasePageForMethods {

	private static Logger log = LogManager.getLogger(OpenCartShoppingCartPage.class.getName());

	public static By productName = By.xpath(getProperty("ProductName"));
	public static By quantity = By.xpath(getProperty("Quantity"));

	public void validatingProductInShoppingCartPage(String nameOfProduct, String quantityOfProduct) {
		SoftAssert softAssert = new SoftAssert();
		log.debug("Validating product Name and Quantity");
		String productInCart = fetchingText(productName);
		log.info("hi=========="+productInCart);
		String quantityInCart = fetchingText(quantity);
		softAssert.assertTrue(productInCart.contains(getProperty(nameOfProduct)),
				"Correct product is not added in shopping cart");
		softAssert.assertTrue(quantityInCart.equals(getProperty(quantityOfProduct)),
				"Product quantity is not correct in shopping cart");
		softAssert.assertAll();
		log.info("Success!! Correct Product and Quantity is available in shopping cart");

	}

}
