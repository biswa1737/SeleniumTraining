package AssignmentRMS.RMS;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;

public class TC8 extends Reporter {
	//Testcase 8 - Click on Submit button 
	
	///
	
	
	WebDriver driver=null;
	Properties prop=null;
	FileInputStream ip=null;
	Functions function;
	
	@BeforeTest
	public void setup() throws Throwable {
		
		extent= new ExtentReports(reportLocation, true);
		extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent()+File.separator+"extent.db");
		
		
		//Initialize the Properties object
		prop= new Properties();
		ip=new FileInputStream("D:\\CB\\Files\\Group3\\target\\test-classes\\config\\PropertFile.Property");
		prop.load(ip);
				
		extest= extent.startTest("Testcase 8: Click on Submit button"); //name your test				
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
	
	
	@Test
	public void test2() throws InterruptedException{
		
		//extest= extent.startTest("Testcase 2: Validate fields on screen "); //name your test
			//Goto RMS Training Website
			///System.out.println("HEREREERERERER");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extest.log(LogStatus.INFO,"RMS Training Website open successfully");
			
			
			//click on Training option
						
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
			
			//Select value Testing from Traning Type drop down
			WebElement KSSTypeDropList= driver.findElement(By.xpath(prop.getProperty("KSStypedropxpath")));
			KSSTypeDropList.sendKeys(prop.getProperty("drop1val"));
			extest.log(LogStatus.INFO,"Training type selected: "+prop.getProperty("drop1val"));
			Thread.sleep(2000);
			
			//Validate topic field
			WebElement topicEditfield=driver.findElement(By.xpath(prop.getProperty("topicxpath")));
			topicEditfield.sendKeys("Testing Topic field");
			extest.log(LogStatus.INFO,"Enter value in the Topic field");
			
			//Validate Agenda field
			WebElement agendaEditfield=driver.findElement(By.xpath(prop.getProperty("agendaxpath")));
			agendaEditfield.sendKeys("Testing Agenda field");
			extest.log(LogStatus.INFO,"Enter value in the Agenda field");
			
			
			//Click on Search button
			driver.findElement(By.xpath(prop.getProperty("searchbtnxpath"))).click();
			extest.log(LogStatus.INFO,"Click on Presenter Search button");
			
			//Keyin the employee name in Search input field
			driver.findElement(By.xpath(prop.getProperty("searchempinput"))).sendKeys(prop.getProperty("employeename"));
			extest.log(LogStatus.INFO,"Keyin the employee name to search :"+prop.getProperty("employeename"));
			
			
			//Select Presenter
			List<WebElement> selectchkboxlist=driver.findElements(By.xpath(prop.getProperty("selectchkboxlistxpath")));
			List<WebElement> empnameListxpath=driver.findElements(By.xpath(prop.getProperty("empnameListxpath")));
			
			for (int i=0; i<selectchkboxlist.size();i=i+1){
				if(empnameListxpath.get(i).getText().equals(prop.getProperty("employeename"))){
					selectchkboxlist.get(i).findElement(By.tagName("input")).click();
					extest.log(LogStatus.INFO,"Click the checkbox of employee name :"+prop.getProperty("employeename"));
					Thread.sleep(2000);
					
					
					
				}
			}
			
			//Click on first select button
			driver.findElement(By.xpath(prop.getProperty("firstselectbtnxpath"))).click();
			extest.log(LogStatus.INFO,"Click the Select button");
			Thread.sleep(2000);
			
			
			
			//click on Date field
			driver.findElement(By.xpath(prop.getProperty("datexpath"))).click();
			Thread.sleep(3000);
			extest.log(LogStatus.INFO,"Click on Date field");
			WebElement datepicker=driver.findElement(By.xpath(prop.getProperty("datepickerxpath")));
			List<WebElement> date=datepicker.findElements(By.xpath(prop.getProperty("datexpath")));
			
			for (int j=0;j<date.size();j=j+1){
				if (date.get(j).getText().equals(prop.getProperty("date"))){
					System.out.println(date.get(j).getText());
					date.get(j).click();
					extest.log(LogStatus.INFO,"Selected date is : "+prop.getProperty("date"));
					
				}
				
			}
			
			//Click on Submit button
			driver.findElement(By.xpath(prop.getProperty("submitbtnxpath")));
			extest.log(LogStatus.INFO,"Click On Sumit button");
			
			extest.log(LogStatus.PASS,"Testcase Passed");

	}


}
