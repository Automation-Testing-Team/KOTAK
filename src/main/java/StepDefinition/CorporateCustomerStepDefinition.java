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

public class CorporateCustomerStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//-------------------------------------------ACCOUNTING ADD--------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Add")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_customer_and_clicks_on_sub_option_add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.customerAddMenu();
	}//end 

	@And("User provides record details for Add operation using {string} and clicks on Ok button and Add Confirm button")
	public void user_provides_record_details_for_add_operation_using_clicks_on_ok_button_and_add_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addCustomerRecord(SheetName);
	}//end 

	@Then("User goes to Customer Approve menu using {string} and approves the record and views it using List Menu")
	public void user_goes_to_customer_approve_menu_using_approves_the_record_and_views_it_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.customerApproveMenu();
		corporatePage.approveCustomerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.customerListMenu();
		corporatePage.listCustomerRecord(SheetName);
	}//end 

	//---------------------------------CUSTOMER MODIFY SCENARIO--------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Modify")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_customer_and_clicks_on_sub_option_modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.customerrModifyMenu();
	}//end 

	@And("User provides record details for Modify operation using {string} and clicks on Ok button and Modify Confirm button")
	public void user_provides_record_details_for_modify_operation_using_clicks_on_ok_button_and_modify_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.modifyCustomerRecord(SheetName);
	}//end 

	//---------------------------------CUSTOMER DELETE SCENARIO--------------------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Delete")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_customer_and_clicks_on_sub_option_delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.customerDeleteMenu();
	}//end 

	@And("User provides record details for delete operation using {string} and clicks on Ok button and Delete button")
	public void user_provides_record_details_for_delete_operation_using_clicks_on_ok_button_and_modify_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.deleteCustomerRecord(SheetName);
	}//end

	@Then("User navigates to Customer Confirm Delete Menu confirms the deletion of record using {string} and views the record using List Menu")
	public void user_navigates_to_customer_confirm_delete_menu_confirms_the_deletion_of_record_using_and_views_the_record_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.customerconfirmDeleteMenu();
		corporatePage.confirmdeleteCustomerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.customerListMenu();
		corporatePage.listCustomerRecord(SheetName);

	}//end

	//-----------------------------------CANCEL MODIFY ACTION SCENARIO-----------------------------------------------
	@Then("User goes to Customer Approve menu using {string} and Clicks on Cancel Modify Action button and views it using List Menu")
	public void user_goes_to_customer_approve_menu_using_clicks_on_cancel_modify_action_button_and_views_it_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.customerApproveMenu();
		corporatePage.cancelModifyActionCustomerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.customerListMenu();
		corporatePage.listCustomerRecord(SheetName);
	}//end 

	//----------------------------------CANCEL DELETE ACTION------------------------------------------------------
	@Then("User navigates to Customer Confirm Delete Menu and cancels the deletion of record using {string} and views the record using List Menu")
	public void user_navigates_to_customer_confirm_delete_menu_and_cancels_the_deletion_of_record_using_and_views_the_record_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.customerconfirmDeleteMenu();
		corporatePage.canceldeleteActionCustomerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.customerListMenu();
		corporatePage.listCustomerRecord(SheetName);

	}//end

	//------------------------------SCHEME/FORMAT CODE MAPPING------------------------------------------------
	@Then("User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option SchemeFormatCodeMapping")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_selects_customer_and_clicks_on_suboption_schemeformatcodemapping() throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage = homePage.customerSchemeFormatCodeMappingMenu();
	}//end

	@And("User provides details for Scheme or Format Code Mapping operation using {string}")
	public void user_provides_record_details_for_scheme_or_format_code_mapping_operation_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.customerRecordSchemeFormatCodeMapping(SheetName);
		
	}//end
	
	//------------------------------SCHEME/FORMAT CODE UNMAPPING------------------------------------------------

	@And("User provides details for Scheme or Format Code Unmapping operation using {string}")
	public void user_provides_record_details_for_scheme_or_format_code_unmapping_operation_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		
		corporatePage.customerRecordSchemeFormatCodeMapping(SheetName);
		
	}//end

	
	//--------------------------------CUSTOMER ADD INVALID DATA SCENARIO---------------------------------------------------

	@And("User provides invalid record details for Add operation using {string} and validates")
	public void user_provides_invalid_record_details_for_add_operation_using_and_validates(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addCustomerRecord_InvalidData(SheetName);
	}//end 
	
	










}
