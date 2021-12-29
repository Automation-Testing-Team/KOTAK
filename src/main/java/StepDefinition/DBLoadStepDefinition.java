package StepDefinition;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.DBLoadPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.IFSC_CODEPage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Then;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class DBLoadStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver();
	DBLoadPage dbLoadPage;
	IFSC_CODEPage ifscCodePage;
	Hooks hooks=new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);

	//------------Navigate to DB Load Screen---------//
	@Then("User goes to Maintenance DB and open Static data menu and then DB Loads menu to upload IFSC Codes")
	public void user_goes_to_maintenance_db_and_open_static_data_menu_and_then_db_loads_menu_to_upload_ifsc_codes() throws InterruptedException {
		elementUtil.GoToFrame("toc");
	    elementUtil.SHORT_TIMEOUT();
		dbLoadPage=homePage.clickonStaticDataDBLoadsLink();	
	}

	//------------Upload IFSC Code list-----------------//
	@Then("User uploads IFSC list using {string} and view added IFSC Code")
	public void user_uploads_ifsc_list_using_and(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		dbLoadPage=dbLoadPage.uploadFile(SheetName);
		homePage.closeApplicationMenu();
		ifscCodePage = homePage.clickonStaticDataIFSCCODEListLink();
		ifscCodePage.viewIFSCCodeList(SheetName);
	}
	
//	@Then("User views NPCI Code list")
//	public void user_views_NPCI_Code_list() throws InterruptedException {
//		homePage=hooks.launchBrowser1();
//		elementUtil.SHORT_TIMEOUT();
//		elementUtil.GoToFrame("toc");
//		
//		//Add code to view NPCI CODE 
//	}
}
