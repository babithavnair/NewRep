package Healthmanagement.Test;




	import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
	import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Healthmanagement.Healthmanagement.homepage;
import Healthmanagement.utiliy.ExtentManager;





	public class Healthtest extends Basetest
	{
		
		
		

		@Test(priority=1)
		public void Homevalidation() throws IOException 
		{
			
				
			//logger.info("URL is opened");
			
			homepage hp=new homepage(driver);
			hp.homepageavailable();
			//logger.info("URL opened ");
			System.out.println("loaded");
			eTest.log(LogStatus.INFO,"Homepage got lauched");
			
			
			
			
			
		}
		@Test
		public void band() throws IOException 
		{
				
			//logger.info("URL is opened");
			
			homepage hp=new homepage(driver);
			hp.brandelement();
			eTest.log(LogStatus.INFO,"banding got lauched");
			
			//logger.info("required page came ");
	}
	}



