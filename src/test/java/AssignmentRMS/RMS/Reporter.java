package AssignmentRMS.RMS;



import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ReporterType;


public class Reporter {
	

	//Extent reports and test variable
	public static ExtentReports extent;
	public static ExtentTest extest;
	
		
		
		//Report html created under /Reports
		public static long millis=System.currentTimeMillis();
		public static String reportLocation="reports/detailTestReport_"+ millis + ".html";
		//relative path of report directory and report
		
		public static void intial(){
			extent= new ExtentReports(reportLocation, true);
			extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent()+File.separator+"extent.db");
						
		}
		
}

		
		
		
		

		
		


