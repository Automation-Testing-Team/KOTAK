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
import io.cucumber.core.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SchemeMenuStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	Scenario scenario;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//-------------------------------SCHEME ADD RECORD SCENARIO-VALID DATA SCENARIO-------------------------------------------------------------

	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Add")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_scheme_and_clicks_on_sub_option_add() throws InterruptedException {
		//hooks.launchBrowser(scenario);
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.schemeAddMenu();
	}//end

	@And("User provides the valid record details using Sheet {string} to add the record")
	public void user_provides_the_valid_record_details_using_sheet_and_row_to_add_the_record(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.addSchemeRecord(SheetName);
	}//end

	//----------------------------------SCHEME ADD RECORD SCENARIO-INVALID DATA SCENARIO----------------------------------------------
	@And("User provides invalid record details using Sheet {string} to check Invalid Data Scenario")
	public void user_provides_invalid_record_details_using_sheet_and_row_to_check_the__invalid_data_scenario(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.addSchemeRecord_InvalidData(SheetName);
	}//end

	//---------------------------------------SCHEME APPROVE-LIST SCENARIO-------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Approve")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_scheme_and_clicks_on_sub_option_approve() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		corporatePage = homePage.schemeApproveMenu();

	}//end

	@Then("User provides the records details using {string} and approves the record and views it record using List menu")
	public void user_provides_the_records_details_using_and_and_approves_it_and_views_the_record_using_list_menu(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.approveSchemeRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.schemeListMenu();
		corporatePage.listSchemeRecord(SheetName);

	}//end

	//-----------------------------------------SCHEME DELETE SCENARIO--------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Delete")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_scheme_and_clicks_on_sub_option_delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.schemeDeleteMenu();
	}

	@Then("User provides the record details in Delete filter screen using Sheet {string} for deletion of record")
	public void user_provides_the_record_details_in_delete_filter_screen_using_sheet_and_row_for_deletion_of_record(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.deleteSchemeRecord(SheetName);
	}//end 

	//--------------------------------------SCHEME CONFIRM DELETE SCENARIO---------------------------------------------------------
	@Given("User navigates to Scheme Confirm Delete Screen")
	public void user_navigates_to_scheme_confirm_delete_screen() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		corporatePage = homePage.schemeConfirmDeleteMenu();

	}//end 

	@Then("User provides the record details in confirm Delete filter screen using Sheet {string} for confirming the record deletion")
	public void user_provides_the_record_details_in_confirm_delete_filter_screen_using_sheet_and_row_for_confirming_the_record_deletion(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.confirmdeleteSchemeRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.schemeListMenu();
		corporatePage.listSchemeRecord(SheetName);


	}//end

	//-------------------------------------SCHEME MODIFY VALID DATA SCENARIO---------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Modify")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_scheme_and_clicks_on_sub_option_modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.schemeModifyMenu();

	}//end 

	@Then("User provides the valid record details using Sheet {string} to Modify the record")
	public void user_provides_the_valid_record_details_using_sheet_and_row_to_modify_the_record(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifySchemeRecord(SheetName);

	}//end

	//---------------------------------------SCHEME MODIFY INVALID DATA SCENARIO-----------------------------------------------
	@And("User provides the invalid record details using Sheet {string}")
	public void user_provides_invalid_record_details_using_sheet_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifySchemeRecord_InvalidData(SheetName);
	}//end

	//-------------------------------------SCHEME CANCEL MODIFY ACTION FOR ADDED AND MODIFIED RECORD----------------------------

	@Then("User navigates to Scheme Approve Screen using Sheet {string} to perform Cancel Modify Action and check record visibility")
	public void user_navigates_to_scheme_approve_screen_using_sheet_and_row_to_perform_cancel_modify_action_check_record_visibility(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		homePage=hooks.launchBrowser1();
		corporatePage=homePage.schemeApproveMenu();
		corporatePage.schemeCancelModifyAction(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.schemeListMenu();
		corporatePage.listSchemeRecord(SheetName);

	}//end

	//---------------------------------------SCHEME CANCEL DELETE ACTION SCENARIO-----------------------------------------------
	@And("User navigates to Scheme Confirm Delete Screen provides the record details using {string} for Cancel Delete Action and check record visibility")
	public void user_navigates_the_scheme_confirm_delete_screen_provides_the_record_details_using_for_cancel_delete_action_and_check_record_visibility(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		homePage=hooks.launchBrowser1();
		corporatePage=homePage.schemeConfirmDeleteMenu();
		corporatePage.schemeCancelDeleteAction(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.schemeListMenu();
		corporatePage.listSchemeRecord(SheetName);

	}//end




}
