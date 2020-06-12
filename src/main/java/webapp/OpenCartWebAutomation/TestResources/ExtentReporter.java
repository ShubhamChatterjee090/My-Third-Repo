package webapp.OpenCartWebAutomation.TestResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public ExtentReports getReportConfig()
	{
		String path=System.getProperty("user.dir")+"\\ExtentReport\\index.html";
		ExtentSparkReporter report= new ExtentSparkReporter(path);
		report.config().setReportName("Open Cart Test Case Execution Report");
		report.config().setDocumentTitle("Generated Extent Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester: ", "Gayathri");
		return extent;
	}
	

}
