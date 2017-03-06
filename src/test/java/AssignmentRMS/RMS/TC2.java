package AssignmentRMS.RMS;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TC2 extends Reporter{
	
	//Testcase 2 -Validate fields on screen 
	
	WebDriver driver=null;
	Properties prop=null;
	FileInputStream ip=null;
	Functions function;
	
	@BeforeTest
	public void setup() throws Throwable {
		
		//Initialize the Properties object
		prop= new Properties();
		ip=new FileInputStream("D:\\CB\\Files\\Group3\\target\\test-classes\\config\\PropertFile.Property");
		prop.load(ip);
				
		extest= extent.startTest("Testcase 2: Validate fields on screen"); //name your test				
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		driver=new ChromeDriver();
		
	
		
	}
	
	
	@AfterTest
	public void closesetup(){
		//Close Browser
		driver.close();
		extest.log(LogStatus.INFO,"Close Browser");
		extent.flush();  //To output the result to the report
		extent.endTest(extest);
		
		
	}
	
	
	@Test (enabled=true)
	public void test2() throws InterruptedException{
		
		//extest= extent.startTest("Testcase 2: Validate fields on screen "); //name your test
			//Goto RMS Training Website
			///System.out.println("HEREREERERERER");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extest.log(LogStatus.INFO,"RMS Training Website open successfully");
			
			
			//click on Training option
			//function.isElementPresent(prop.getProperty("trainingxpath"));
			 
			
			WebElement training=driver.findElement(By.xpath(prop.getProperty("trainingxpath")));
			Actions act=new Actions(driver);
			//act.moveToElement(training).click().build().perform();
			act.moveToElement(training).build().perform();
			extest.log(LogStatus.INFO,"Click on Training option");
			Thread.sleep(2000);
			
			//click on Raised Training Request option			
			driver.findElement(By.xpath(prop.getProperty("raiserequestxpath"))).click();
			Thread.sleep(3000);
			extest.log(LogStatus.INFO,"Click on Raised Training Request option");
			Thread.sleep(6000);
			
			///Select the value training type: Knowledge Sharing Session from dropdown list
			WebElement trainingTypeDropList= driver.findElement(By.xpath(prop.getProperty("trainingtypedrop")));
			trainingTypeDropList.sendKeys(prop.getProperty("trainingtypedropvalue"));
			extest.log(LogStatus.INFO,"Training type: Knowledge Sharing Session from dropdown list");
			Thread.sleep(6000);
			
			//Verify the fields present
			List <WebElement> lst=driver.findElements(By.xpath(prop.getProperty("fieldlabels")));
			//System.out.println(lst.size());
				for (int j=1;j<8;j=j+1){
					for (int i=0;i<lst.size();i=i+1){
				
						if(lst.get(i).getText().equals(prop.getProperty("label"+j))){
							break;
						}
						
			}
					extest.log(LogStatus.INFO,"Field persent: "+prop.getProperty("label"+j));
					
					
			}
					
				extest.log(LogStatus.PASS,"Testcase Passed");
			
			
	}
	
	
}


