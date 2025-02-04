package genericlibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners1 implements ITestListener{
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;
	@Override
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"pass");
		test.pass(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot takescreenshot = (TakesScreenshot) BaseClass.driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(AutoConstant.photoPath + "failed" + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.fail(result.getMethod().getMethodName()+"fail");
		test.fail(result.getThrowable());

	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"fail");
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./reporter/montocarlo.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("montoCarlo");
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("username", "Manjunath");
		reports.setSystemInfo("OS", "windows");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	

	
}
