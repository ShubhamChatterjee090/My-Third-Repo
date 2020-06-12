//Author: Gayathri
package webapp.OpenCartWebAutomation.TestResources;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePageForMethods extends BaseConfiguration {

	private static Logger log = LogManager.getLogger(BasePageForMethods.class.getName());

	public void launchingUrl(String url, String landingPgTitle) {
		
		log.debug("Launching OpenCart Website URL");
		driver.get(getProperty(url));
		String title = fetchingPageTitle();
		Assert.assertTrue(title.equals(getProperty(landingPgTitle)),
				"Incorrect, it is not navigated to the landing page");
		log.info("Success!! it has been correctly navigated to the Home/Landing Page");
	}

	public void explicitWaitForElementVisibility(final By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickOnElement(final By locator) {
		driver.findElement(locator).click();
	}

	public void selectingElementFromDropdownByVisibleText(final By locator, String value) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(value);
	}

	public void markingCheckboxAndRadioButton(final By locator) {
		boolean result = true;
		Actions checkBox = new Actions(driver);
		result = driver.findElement(locator).isSelected();
		if (result == false) {
			checkBox.moveToElement(driver.findElement(locator)).click().build().perform();
		}
	}

	public String fetchingPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean checkingForElementDisplayed(final By locator) {
		boolean result = driver.findElement(locator).isDisplayed();
		return result;
	}

	public String fetchingText(final By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}

	public void clickingDesiredValueFromMultipleElements(final By locator, String value) {
		Actions a = new Actions(driver);
		List<WebElement> elements = driver.findElements(locator);
		Iterator<WebElement> it = elements.iterator();
		while (it.hasNext()) {
			WebElement w = it.next();
			if (w.getText().equals(value)) {
				a.moveToElement(w).click().build().perform();
				break;
			}
		}
	}

	public void actionMoveToElementClick(final By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator)).click().build().perform();
	}

	public ArrayList<String> clickingOnMultipleElementsAndgetText(final By locator) {
		ArrayList<String> arrayListElements = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(locator);
		Iterator<WebElement> it = elements.iterator();
		while (it.hasNext()) {
			WebElement w = it.next();
			w.click();
			arrayListElements.add(w.getText());
		}
		return arrayListElements;
	}

	public void limitingWebdriverScopeAndClickingOnElementFromList(final By locator1, final By locator2, String value) {

		WebElement subset = driver.findElement(locator1);
		List<WebElement> subsetElements = subset.findElements(locator2);
		Iterator<WebElement> iterate = subsetElements.iterator();
		while (iterate.hasNext()) {
			WebElement we = iterate.next();
			if (we.getText().equals(value)) {
				we.click();
				break;
			}
		}

	}

	public void passingValue(final By locator, String value) {
		WebElement element=driver.findElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void openingLinkInNewTab(final By locator) {
		String keyBoardAction = Keys.chord(Keys.CONTROL, Keys.ENTER);
		passingValue(locator, keyBoardAction);
	}

	public void draggingAndDroppingElement(final By locator1, final By locator2) {
		Actions action = new Actions(driver);
		WebElement sourceLocator = driver.findElement(locator1);
		WebElement targetLocator = driver.findElement(locator2);
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	}

	public ArrayList<String> switchingToNewTabsFetchingTitlesAndReturnToParentTab() throws InterruptedException {
		ArrayList<String> tabTitles = new ArrayList<String>();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		while (it.hasNext()) {
			tabTitles.add(driver.switchTo().window(it.next()).getTitle());
			driver.close();
		}
		driver.switchTo().window(parentWindow);
		return tabTitles;
	}

	public void switchingToNewTabOrWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		System.out.println(parentWindow);
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
	}

	public File takingScreenshotOnTestFailure() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return src;
	}

	public void scrollingDownInWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToSpecificWebelement(final By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void clickingOnWebelementThroughJavascript(final By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].click();", element);
	}

}
