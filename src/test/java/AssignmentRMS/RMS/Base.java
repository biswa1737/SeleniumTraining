package AssignmentRMS.RMS;

import java.io.File;

import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ReporterType;

public class Base extends Reporter {

	@BeforeSuite
	public static void intial(){
		extent= new ExtentReports(reportLocation, true);
		extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent()+File.separator+"extent.db");
	
}
}