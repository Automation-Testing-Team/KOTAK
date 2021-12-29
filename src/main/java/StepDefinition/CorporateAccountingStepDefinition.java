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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CorporateAccountingStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//---------------------------------ACCOUNTING ADD SCENARIO--------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Add")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_accounting_and_clicks_on_sub_option_add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.accountingAddMenu();
	}//end 

	@And("User provides the valid record details using Sheet {string} and clicks on Ok button and Add Confirm button")
	public void user_provides_the_valid_record_details_for_add_operation_using_sheet_and_row_clicks_on_ok_button_and_add_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addAccountingRecord(SheetName);
	}//end 

	//------------------------------ACCOUNTIG APPROVE,LIST SCENARIO-------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Approve")
	public void user_goes_to_customer_approve_menu_using_approves_the_record_and_views_it_using_list_menu() throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.accountingApproveMenu();
	}	

	@And("User provides the records details using {string} and approves it and views the record using Accounting List")
	public void user_provides_the_record_details_for_using_approves_it_and_views_the_record_using_Accounting_list(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.approveAccountingRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.accountingListMenu();
		corporatePage.listAccountingRecord(SheetName);
	}//end 

	//-----------------------------------ACCOUNTING INVALID DATA ADD SCNEARIO-------------------------------------------------------
	@And("User provides the invalid record details for Add operation using {string} and clicks on ok button and validates")
	public void user_provides_the_invalid_record_details_for_add_operation_using_and_clicks_on_ok_button_and_validates_n(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addAccountingRecord_InvalidData(SheetName);
	}//end 

	//-----------------------------------ACCOUNTING MODIFY SCENARIO---------------------------------------------------

	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Modify")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_accounting_and_clicks_on_sub_option_modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.accountingModifyMenu();
	}//end 

	@And("User provides the valid record details for modification using {string}")
	public void user_provides_the_valid_record_details_for_modification(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.modifyAccountingRecord(SheetName);
	}//end 

	//-----------------------------------ACCOUNTING MODIFY INVALID DATA SCNEARIO----------------------------------
	@And("User provides the invalid record details for modify operation using {string}")
	public void user_provides_the_invalid_record_details_for_modify_operation_using_sheet_and_row_clicks_on_ok_button_and_add_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.modifyAccountingRecord_InvalidData(SheetName);
	}//end 

	//------------------------------------ACCOUNTING DELETE SCENARIO-------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Delete")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_accounting_and_clicks_on_sub_option_delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.accountingDeleteMenu();
	}//end 

	@And("User provides the record details for Delete operation using Sheet {string}")
	public void user_provides_the_record_details_for_delete_operation_using_sheet_and_row(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.deleteAccountingRecord(SheetName);
	}//end 

	//------------------------------------ACCOUNTING CONFIRM DELETE,LIST SCENARIO-------------------------------------------------------
	@Given("User navigates to Accounting Confirm Delete Screen")
	public void user_navigates_to_accounting_confirm_delete_screen() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		homePage=hooks.launchBrowser1();

		corporatePage=homePage.accountingConfirmDeleteMenu();
	}//end 

	@And("User provides the record details using Sheet {string} and confirms the deletion of record and views it using Accounting List")
	public void user_provides_the_record_details_using_sheet_and_row_confirms_the_deletion_of_record_and_views_it_using_accounting_list(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.confirmDeleteAccountingRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.accountingListMenu();
		corporatePage.listAccountingRecord(SheetName);
		
	}//end 
	
	//--------------------------------------ACCOUNTING CANCEL MODIFY ACTION--------------------------------------------------------
	@And("User navigates to Accounting Approve screen to perform Cancel Modify Action using {string}")
	public void user_navigates_to_accounting_approve_screen_to_perform_cancel_modify_action_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.accountingApproveMenu();
	
		corporatePage.cancelModifyActionAccountingRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.accountingListMenu();
		corporatePage.listAccountingRecord(SheetName);
	}//end 
	
	//---------------------------------------ACCOUNTING CANCEL DELETE ACTION-------------------------------------------------
	@And("User cancels the deletion of record using {string} and views it using Accounting List")
	public void user_cancels_the_deletion_of_record_using_and_views_it_using_accounting_list(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.accountingConfirmDeleteMenu();
		corporatePage.cancelDeleteActionAccountingRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.accountingListMenu();
		corporatePage.listAccountingRecord(SheetName);
	}//end 














}
