//Author: Gayathri
package webapp.OpenCartWebAutomation.TestResources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webapp.OpenCartWebsiteAutomation.PageObjects.OpenCartMyAccountPage;

public class Listener implements ITestListener {

	public static Logger log = LogManager.getLogger(Listener.class.getName());
	BasePageForMethods basePage = new BasePageForMethods();
	ExtentReporter extentReporter = new ExtentReporter();

	ExtentTest test;
	ExtentReports extent = extentReporter.getReportConfig();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Starting Test Case is: " + result.getName());
		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test Case passed: " + result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test Case failed: " + result.getName());
		File source = basePage.takingScreenshotOnTestFailure();
		try {
		FileUtils.copyFile(source, new File("target//" + result.getName() + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		try {
			String baseDirectory=System.getProperty("user.dir");
			test.addScreenCaptureFromPath(baseDirectory+"\\target\\" + result.getName() + ".jpeg", "Image of Failed Page");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OpenCartMyAccountPage openCartMyAccountPage=new OpenCartMyAccountPage();
		openCartMyAccountPage.signingOutFromAccount("logoutOptionText","accountLogoutPgTitle");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
