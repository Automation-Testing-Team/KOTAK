package COM.KOTAK.QA.FACTORY;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
* @Author -- Suvarna Prabhumatkari
**/
public class DriverFactory {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ThreadLocal<WebDriver>tldriver=new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser value is "+ browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {   
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			tldriver.set(new InternetExplorerDriver());
		}else {
			System.out.println("Kindly pass correct browser value" + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	
}
