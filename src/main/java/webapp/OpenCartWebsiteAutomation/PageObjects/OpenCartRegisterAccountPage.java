package webapp.OpenCartWebsiteAutomation.PageObjects;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import webapp.OpenCartWebAutomation.TestResources.BasePageForMethods;

public class OpenCartRegisterAccountPage extends BasePageForMethods {

	private static Logger log = LogManager.getLogger(OpenCartRegisterAccountPage.class.getName());

	public static By firstNameField = By.xpath(getProperty("FirstNameField"));
	public static By lastNameField = By.xpath(getProperty("LastNameField"));
	public static By emailInputField = By.xpath(getProperty("EmailInputField"));
	public static By telephoneNumberField = By.xpath(getProperty("TelephoneNumberField"));
	public static By passwordField = By.xpath(getProperty("PasswordField"));
	public static By confirmPasswordField = By.xpath(getProperty("ConfirmPasswordField"));
	public static By checkbox = By.xpath(getProperty("Checkbox"));
	public static By continueBtn = By.xpath(getProperty("ContinueBtn"));
	public static By invalidPasswordMsg = By.xpath(getProperty("InvalidPasswordMsg"));
	public static By successfulAccountCreationMsg = By.xpath(getProperty("SuccessfulAccountCreationMsg"));

	public void fillingUpDetailsForNewRegistration(String firstName, String lastName, String email, String telephone,
			String password,String navigatedPgTitle) {
		log.debug("Entering first name");
		passingValue(firstNameField, getProperty(firstName));
		log.debug("Entering last name");
		passingValue(lastNameField, getProperty(lastName));
		log.debug("Entering Email id");
		String mailId=getProperty(email);
		//GENERATING A RANDOM NEW MAIL ID SO THAT REGISTRATION COULD BE DONE SUUCESSFULLY ON EVERY RUN
		Random r=new Random();
		int a=r.nextInt(10000)+r.nextInt(500);
		String numericPart=String.valueOf(a)+"@";
		String generatedMailId=mailId.replace("@", numericPart);
		passingValue(emailInputField, generatedMailId);
		log.debug("Entering Telephone Number");
		passingValue(telephoneNumberField, getProperty(telephone));
		log.debug("Entering Password");
		passingValue(passwordField, getProperty(password));
		log.debug("Entering Password again in Confirm Password field");
		passingValue(confirmPasswordField, getProperty(password));
		log.debug("Clicking on checkbox");
		markingCheckboxAndRadioButton(checkbox);
		log.debug("Clicking on Continue button");
		clickOnElement(continueBtn);
		log.debug("Checking for Navigation");
		String pageTitle=fetchingPageTitle();
		Assert.assertTrue(pageTitle.contains(getProperty(navigatedPgTitle)), "Page navigation is not correct");
		log.info("Success!! Page navigation is correct");
	}
	
	public void validatingAccountRegistrationSuccess(String registrationSuccessMsg)
	{
		log.debug("Checking for the account registration success message");
		Assert.assertTrue(fetchingText(successfulAccountCreationMsg).contains(getProperty(registrationSuccessMsg)),"Registration is not succesful");
		log.info("Registration is successful");
	}

}
