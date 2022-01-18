package StepDefinition;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.CorporatePage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class CorporateModeOfOperationStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver = DriverFactory.getDriver();
	Hooks hooks = new Hooks();
	CorporatePage corporatePage;
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	ElementUtil elementUtil =new ElementUtil(driver);
	
	// ----------------List Mode Of Operation record--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Mode Of Operation and clicks on sub option List")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Mode_Of_Operation_and_clicks_on_sub_option_List() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.clickonModeOfOperationListLink();
	}

	@Then("User lists Mode of Operation record using {string}")
	public void user_lists_Mode_of_Operation_record_using(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.listModeOfOperationRecord(SheetName);
	}
	
	// ----------------Add Mode Of Operation record--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Mode Of Operation and clicks on sub option Add")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Mode_Of_Operation_and_clicks_on_sub_option_Add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.clickonModeOfOperationAddLink();
	}

	@Then("User add Mode of Operation record using {string}")
	public void user_add_Mode_of_Operation_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.addModeOfOperationRecord(SheetName);
	}
}
