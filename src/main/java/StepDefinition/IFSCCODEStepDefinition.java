package StepDefinition;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.IFSC_CODEPage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class IFSCCODEStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver(); 
	IFSC_CODEPage ifsc_CodePage;
	Hooks hooks=new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);
	
	//--------Add IFSC CODE----------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Add menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_add_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage = homePage.clickonStaticDataIFSCCODEAddLink();
	}

	@Then("user enters invalid data using {string} and {int}")
	public void user_enters_invalid_data_using_and(String SheetName, Integer Row) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage=ifsc_CodePage.addIFSCCode(SheetName, Row);
	}
	
	//----------Delete IFSC CODE-----------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Delete menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_delete_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage=homePage.clickonStaticDataIFSCCODEDeleteLink();
	}
	
	@Then("user try to filter IFSC Code using invalid data using {string} and {int}")
	public void user_try_to_filter_ifsc_code_using_invalid_data_using_and(String SheetName, Integer Row) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage=ifsc_CodePage.deleteIFSCCodewithInvaliddata(SheetName, Row);
	}
	
	@Then("user try to filter IFSC Code using valid data using {string} and {int}")
	public void user_try_to_filter_ifsc_code_using_valid_data_using_and(String SheetName, Integer Row) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage=ifsc_CodePage.deleteIFSCCodewithValiddata(SheetName, Row);
	}
	
	//------------List IFSC CODE---------------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE List menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_list_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage=homePage.clickonStaticDataIFSCCODEListLink();
	}
	
	@Then("user view IFSC Code using valid data using {string}")
	public void user_view_ifsc_code_using_valid_data_using_and(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage=ifsc_CodePage.viewIFSCCodeList(SheetName);
	}

}
