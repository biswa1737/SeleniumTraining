package AssignmentRMS.RMS;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;





public class TC1 extends Reporter {

	///Raise Training Request
	
	WebDriver driver=null;
	Properties prop=null;
	FileInputStream ip=null;
	//static Reporter report=null;
	
			
	//Report html created under /Reports
			//private static long millis=System.currentTimeMillis();
			//public static String reportLocation="reports/detailTestReport_"+ millis + ".html";
	
	
	
		
	@BeforeTest
	public void setup() throws Throwable {
		
		///extent= new ExtentReports(reportLocation, true);
		//extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent()+File.separator+"extent.db");
		//TC1.intial();

		prop= new Properties();
		ip=new FileInputStream("D:\\CB\\Files\\Group3\\target\\test-classes\\config\\PropertFile.Property");
		prop.load(ip);
		
		extest= extent.startTest("Testcase 1: Raise Training Request"); //name your test			
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		driver=new ChromeDriver();
		
		extest.log(LogStatus.INFO,"Open Browser Done for TC1");
			
	}
	
	@AfterTest
	public void closesetup(){
		driver.close();
		extest.log(LogStatus.INFO,"Close Browser for TC1");
		//System.out.println("After Test");
		//Reporter.
		
		extent.flush();  //To output the result to the report
		extent.endTest(extest);
		//Reporter.
		
	}
	
	
	
	@Test (enabled=true)
	public void test1(){
		//Goto RMS Training Website
		///System.out.println("HEREREERERERER");
		//extest= extent.startTest("Testcase 1: Raise Training Request"); //name your test	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		extest.log(LogStatus.INFO,"RMS Training Website open successfully");
		
			
		String title=driver.getTitle();
		System.out.println("Title:"+title);
		
		if (title.equals(prop.getProperty("expectedResult1"))){
			
			extest.log(LogStatus.PASS,"Testcase Passed");
			extest.log(LogStatus.INFO,"Expected Result: " +prop.getProperty("expectedResult1")+" matches with Actual Result: "+title);
			//System.out.println("Testcase Passed");
			
		}else{
			
			extest.log(LogStatus.FAIL,"Testcase Failed");
			extest.log(LogStatus.INFO,"Expected Result: " +prop.getProperty("expectedResult1")+" does not matches with Actual Result: "+title);
			//System.out.println("Testcase Failed");
		}
		
		
		
		
		
		
	}
		
				
		
	
	
	
	
	
	
	
	
}


