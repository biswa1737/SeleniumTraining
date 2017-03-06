package AssignmentRMS.RMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Functions {
	WebDriver driver=null;
	
	
	public void waitTime(long timesec) throws InterruptedException{
		Thread.sleep(timesec);
	}
	
	public boolean isElementPresent(String xpath){
		List<WebElement> obj=driver.findElements(By.xpath(xpath));
		if (obj.size()>0){
			
			return true;
						
		}else{
			return false;
		}
			
			
	}
	
}
