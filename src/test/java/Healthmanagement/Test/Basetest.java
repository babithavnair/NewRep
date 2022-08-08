package Healthmanagement.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Healthmanagement.utiliy.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Basetest { 
	ExtentReports eReport;
	ExtentTest eTest;

	//ReadConfig readconfig=new ReadConfig();
	
	public String baseURL="https://healthcaresuccess.com";
	public static WebDriver driver;
	public String br="chrome";
	
	//public static Logger logger;
	
	//@Parameters("browser")
	@BeforeClass
	public void setup()
	{			
		
		//logger = Logger.getLogger("");
		//PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(baseURL);
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.get(baseURL);
		}
		else if(br.equals("ie"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();

		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	@BeforeTest
	public void report()
	{
		eReport = ExtentManager.getInstance();
		eTest = eReport.startTest("TestOne");
		
	}
	
	@AfterTest
	public void testClosure() {
		
		eReport.endTest(eTest);
		
		eReport.flush();
		
	}
	
	
}
