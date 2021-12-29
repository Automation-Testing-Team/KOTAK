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

/**
 * @Author -- Pranjal Mudhalwadkar
 **/
public class CorporateIndustryTypeStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//-----------------------------------------------Add Method---------------------------------------------------------------------
	@Given("User goes to Application and Maintenance clicks on Corporate CMS menu and then Industry Type and clicks on Add menu")
	public void user_goes_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_industry_type_and_clicks_on_add_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		corporatePage=homePage.addIndustryType();
	}//end 

	@And("User adds record using {string} and clicks on Ok button and Add Confirm button")
	public void user_adds_record_using_clicks_on_ok_button_and_add_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addIndustryTypeRecord(SheetName);
	}//end 

	@Then("User goes to Industry Type Approve menu using {string} and approves the record and views it using List Menu")
	public void user_goes_to_industry_type_approve_menu_using_approves_the_record_and_views_it_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.approveIndustryType();
		elementUtil.SHORT_TIMEOUT();
		corporatePage.approveIndustryTypeRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listIndustryType();
		corporatePage.listIndustryTypeRecord(SheetName);
	}//end 

	//-----------------------------------------Validation Method -------------------------------------------------------------------
	@Given("User provides invalid record details using {string} and clicks on Ok button and validate the fields")
	public void user_provides_invalid_record_details_and_clicks_on_ok_button_and_validate_the_fields(String SheetName) throws InterruptedException, InvalidFormatException, IOException {

		corporatePage.addInvalidIndustryType(SheetName);
	}//end

	//-------------------------------------------Modify Method-----------------------------------------------------------------------
	@Given("User goes to Application and Maintenance clicks on Corporate CMS menu then Industry Type and clicks on Modify menu")
	public void user_goes_to_application_and_maintenance_clicks_on_corporate_cms_menu_then_industry_type_and_clicks_on_modify_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.modifyIndustryType();
	}//end

	@Given("User modifies the record by changing fields using {string}")
	public void user_modifies_the_record_by_changing_fields_and(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.modifyIndustryType(SheetName);
	}//end 
	//------------------------------------------Modify Invalid Data Scenario Method-------------------------------------------
	@Given("User provides invalid record details for modify operation using {string}")
	public void user_provides_invalid_record_details_for_modify_operation_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.modifyIndustryType_InvalidData(SheetName);
	}//end 


	//--------------------------------------------Delete Method-----------------------------------------------------------------------
	@Given("user goes to Application and Maintenance clicks Corporate CMS menu then Industry Type and clicks on Delete menu")
	public void user_goes_to_application_and_maintenance_clicks_on_corporate_cms_menu_then_industry_type_and_clicks_on_delete_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.deleteIndustryType();
	}//end 

	@And("User performs delete operation on the record from the list using {string}")
	public void user_performs_delete_operation_on_the_record_from_the_list_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.deleteIndustryTypeRecord(SheetName);
	}//end

	@Then("User goes to Industry Type Confirm Delete Menu confirms the deletion of record using {string} and views the record using List Menu")
	public void user_goes_to_industry_type_confirm_delete_menu_and_confirms_the_deletion_of_record_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.confirmDeleteIndustryType();
		corporatePage.confirmDeleteIndustryTypeRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listIndustryType();
		corporatePage.listIndustryTypeRecord(SheetName);

	}//end 

	//------------------------------------------Cancel Modify Action Method----------------------------------------------------------
	@Then("User goes to Industry Type Approve menu using {string} and clicks on Cancel Modify Action button and views the record")
	public void user_goes_to_industry_type_approve_menu_using_clicks_on_cancel_modify_action_button_and_views_the_recors(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.approveIndustryType();
		elementUtil.SHORT_TIMEOUT();
		corporatePage.cancelModifyActionIndustryTypeRec(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listIndustryType();
		corporatePage.listIndustryTypeRecord(SheetName);

	}//end

	//------------------------------------------Cancel Delete Action Method----------------------------------------------------------
	@Then("User goes Industry Type to Confirm Delete Menu using {string} and clicks on Cancel Delete Action button and views the record using List Menu")
	public void user_goes_to_industry_type_confirm_delete_menu_using_and_clicks_on_cancel_delete_action_button__and_views_the_record_using_list_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.confirmDeleteIndustryType();
		corporatePage.cancelDeleteActionIndustryTypeRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listIndustryType();
		corporatePage.listIndustryTypeRecord(SheetName);
	}//end




}
