package COM.KOTAK.QA.MAIN;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateCucumberOptions {

	public static Properties prop;
	private static final String KEY = "cucumber.options";
	public void loadPropertiesFile(){
		System.out.println("In loadproperties file");
		FileInputStream input;  
		//final InputStream input;
		try{
			prop=new Properties();
			String filename = "E:/PINV/PINV/cucumberOptions.properties";

			//input = CreateCucumberOptions.class.getClassLoader().getResourceAsStream(filename);
			
			//input=new FileInputStream("E:/PINV/PINV/cucumberOptions.properties");
			
			input=new FileInputStream("E:/project/cucumberOptions.properties");
			//System.out.println(CreateCucumberOptions.class.getResourceAsStream("E:/PINV/PINV/cucumberOptions.properties"));
			//System.out.println(input);
			//	        if(input==null){
			//	            System.out.println("Sorry, unable to find " + filename);
			//	            return;
			//	        }
			prop.load(input);
			//			prop.load(new FileInputStream("/PINV/src/main/resources/Log4j.properties"));
			//			prop.setProperty("log4j.appender.File.File", "E:/PINV/PINV/PINV/test" + "applicationlogs");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			/*if(input!=null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }*/
			//}
		}
	}

	public String createAndGetCucumberOption(){       
		System.out.println("in create and get cucumber option method");
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		String featureFilesPath = 
				prop.getProperty("cucumber.options.feature");
		System.out.println(featureFilesPath);
//		String tag = 
//				prop.getProperty("cucumber.options.tags");
//		System.out.println(tag);

		String htmlOutputReport = 
				prop.getProperty("cucumber.options.report.html");
		System.out.println(htmlOutputReport);

		String jsonReport=
				prop.getProperty("cucumber.options.report.json");

		String xmlReport=
				prop.getProperty("cucumber.options.report.xml");
		//		
		//		String pdfReport=
		//				prop.getProperty("cucumber.options.report.extent");
		//////	
		sb.append(htmlOutputReport);
		sb.append(" ");
		sb.append(jsonReport);
		sb.append(" ");
		sb.append(xmlReport);
		sb.append(" ");
		sb.append(featureFilesPath);
//		sb.append(" ");
//		sb.append(tag);
	
		System.out.println(sb);
		//		sb.append(" ");
		//		sb.append(pdfReport);
		//////	
		//sb.append(" ");
		//sb.append(tag);
		//sb.append(featureFilesPath+"/"+tag);
		return sb.toString();
	}


	public void setOptions(){
		System.out.println("in set options");
		//  LOGGER.info(" Value: " +value);
		String value=createAndGetCucumberOption();
		System.out.println("Value " + value);
		System.setProperty(KEY, value);
	}

}
