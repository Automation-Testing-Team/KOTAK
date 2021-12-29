package StepDefinition;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
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

public class CorporateDuplicateCheckStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = DriverFactory.getDriver();
	Hooks hooks = new Hooks();
	CorporatePage corporatePage;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil = new ElementUtil(driver);
	Logger log = Logger.getLogger(CorporateDuplicateCheckStepDefinition.class);
	
	// ----------------Add Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Add")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_Add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.clickonDuplicateCheckAddLink();
	}

	@Then("User add Duplicate Check record using {string}")
	public void user_add_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.addDuplicateCheckRecord(SheetName);
	}
	
	// ----------------Approve Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Approve")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_Approve() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		log.info("Launch Browser");
		homePage = hooks.launchBrowser1();
		corporatePage = homePage.clickonDuplicateCheckApproveLink();
	}

	@Then("User approves Duplicate Check record using {string}")
	public void user_approves_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.approveDuplicateCheckRecord(SheetName);
	}

	// ----------------List Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option List")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_List() throws InterruptedException {
	   elementUtil.GoToFrame("toc");
	   elementUtil.SHORT_TIMEOUT();
	   corporatePage = homePage.clickonDuplicateCheckListLink();
	}

	@Then("User view Duplicate Check record using {string}")
	public void user_view_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.listDuplicateCheckRecord(SheetName);
	}
	
	// ----------------Delete Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Delete")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_Delete() throws InterruptedException {
		 elementUtil.GoToFrame("toc");
		 elementUtil.SHORT_TIMEOUT();
		 corporatePage = homePage.clickonDuplicateCheckDeleteLink();
	}

	@Then("User delete Duplicate Check record using {string}")
	public void user_delete_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.deleteDuplicateCheckRecord(SheetName);
	}
	
	// ----------------Confirm Delete Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Confirm Delete")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_Confirm_Delete() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		log.info("Launch Browser");
		homePage = hooks.launchBrowser1();
		corporatePage = homePage.clickonDuplicateCheckConfirmDeleteLink();
	}

	@Then("User approves delete operation on Duplicate Check record using {string}")
	public void user_approves_delete_operation_on_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.confirmDeleteDuplicateCheckRecord(SheetName);
	}
	
	// ----------------Modify Duplicate Check--------------------------//
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Modify")
	public void user_navigates_to_Application_and_Maintenance_clicks_on_Corporate_CMS_menu_and_then_selects_Duplicate_Check_and_clicks_on_sub_option_Modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.clickonDuplicateCheckModifyLink();
	}

	@Then("User try to modify Duplicate Check record with Invalid data using {string}")
	public void user_modify_Duplicate_Check_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.modifyDuplicateCheckRecordwithInvalidData(SheetName);
	}
	
	@Then("User try to modify Duplicate Check record with Valid data using {string}")
	public void user_try_to_modify_Duplicate_Check_record_with_Valid_data_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		corporatePage.modifyDuplicateCheckRecordwithValidData(SheetName);
	}



	
	
	
	
	
	
	
	
}
