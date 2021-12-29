package COM.KOTAK.QA.UTIL;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class ExtentReportGenerator {
	//ExtentHtmlReporter htmlReporter; 
	//ExtentReports report; 

	
	public void generateReport()
	{
		System.out.println("in generate report");
		//		htmlReporter = new ExtentHtmlReporter("reports.html");
		//		report = new ExtentReports();
		//Reporter.loadXMLConfig(new File("E:/PINV/PINV/PINV/extent-config.xml"));
		//ExtentReports reports = new ExtentReports("extentreports.html", true);
		//htmlReporter.start();

		//htmlReporter.start();
		//	reports.flush();

		//		File reportOutputDirectory = new File("target");
		//		List<String> jsonFiles = new ArrayList<>();
		//		jsonFiles.add("cucumber-report-1.json");
		//		jsonFiles.add("cucumber-report-2.json");
		//
		//		String buildNumber = "1";
		//		String projectName = "cucumberProject";

		//		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		//		// optional configuration - check javadoc for details
		//		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		//		// do not make scenario failed when step has status SKIPPED
		//		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		//		configuration.setBuildNumber(buildNumber);
		//		// addidtional metadata presented on main page
		//		configuration.addClassifications("Platform", "Windows");
		//		configuration.addClassifications("Browser", "Firefox");
		//		configuration.addClassifications("Branch", "release/1.0");

		File reportOutputDirectory = new File("output");
		List<String> jsonFiles = new ArrayList<>();
		//jsonFiles.add("E:\\PINV\\PINV\\PINV\\target\\cucumber-reports\\cucumber.json");
		jsonFiles.add("E:\\project\\target\\cucumber-reports\\cucumber.json");
		

		String buildNumber = "1";
		String projectName = "cucumberProject";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");

//		// optionally add metadata presented on main page via properties file
//		List<String> classificationFiles = new ArrayList<>();
//		classificationFiles.add("properties-1.properties");
//		classificationFiles.add("properties-2.properties");
//		configuration.addClassificationFiles(classificationFiles);

		// optionally specify qualifiers for each of the report json files
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		configuration.setQualifier("cucumber","First report");
	

		ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
		Reportable result=reportBuilder.generateReports();
		
		// and here validate 'result' to decide what to do if report has failed

	}


}
