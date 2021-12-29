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
public class CorporateMiscellaneousStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//--------------GENERIC STEPDEFINATIONS FOR DELETE,CONFIRM DELETE, CANCEL DELETE ACTION SCENARIOS--------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Delete menu")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_miscellaneous_and_clicks_on_delete_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.deleteMiscellaneous();
	}//end 

	@And("User provides Party Name value from sheetname {string} and clicks on Ok button and Delete button")
	public void User_provides_Party_Name_value_from_sheetname_and_rowNumber_and_clicks_on_Ok_button_and_Delete_button(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.miscellaneousDeleteFilterScreen(SheetName);
	}//end 

	@Then("User navigates to Miscellaneous Confirm Delete Screen")
	public void User_navigates_to_Miscellaneous_Confirm_Delete_Screen_to_confirm_the_Deletion_of_Record() throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.confirmDeleteMiscellaneous();
	}//end 

	//-------------GENERIC STEPDEFINATIONS FOR MISCELLANEOUS ADD,CANCEL MISCELLANEOUS RECORD ADDITION --------------------

	@Given("User goes to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Add menu")
	public void user_goes_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_miscellaneous_and_clicks_on_add_menu() throws InterruptedException {

		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.addMiscellaneous();
	}//end 

	@And("User adds Template Code and selects priority fields from sheetname {string} and clicks on Ok button and confirm")
	public void user_adds_template_code_and_selects_priority_fields_from_sheetname_and_row_number_and_clicks_on_ok_button_and_confirm(String SheetName) throws InvalidFormatException, IOException, InterruptedException {

		corporatePage.miscellaneousAddFilterScreen(SheetName);
	}//end 

	//-----------------------------------------MISCELLANEOUS->APPROVE,LIST-----------------------------------------------------

	@Given("User goes to Miscellaneous Approve screen and approve the record using SheetName {string} and views the record using List")
	public void User_goes_to_Miscellaneous_Approve_screen_and_approve_the_record_using_and_views_the_record_using_list(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
	
		homePage=hooks.launchBrowser1();
		corporatePage=homePage.approveMiscellaneous();
		corporatePage.approveMiscellaneousRecord(SheetName);
		//homePage.closeAdministrationMenu();
		//corporatePage = homePage.ListMiscellaneous();
		//corporatePage.listMiscellaneousRecord(SheetName,Row);
	}//end

	//------------------------------------MISCELLANEOUS->DELETE SCREEN---------------------------------------------

	@Then("User provides Party Name value from sheetname {string} and clicks on Ok button and Delete Confirm button")
	public void User_provides_Party_Name_value_from_sheetname_and_rowNumber_and_clicks_on_Ok_button_and_Delete_Confirm_button(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.miscellaneousConfirmDeleteScreen(SheetName);
		//homePage.closeAdministrationMenu();
		//corporatePage = homePage.ListMiscellaneous();
		//corporatePage.listMiscellaneousRecord(SheetName,Row);

	}//end 

	//-----------------------------------MISCELLANEOUS->MODIFY SCREEN---------------------------------------------

	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Modify menu")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_and_then_miscellaneous_and_clicks_on_modify_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.modifyMiscellaneous();
	}//end 

	@And("User provides Party Name value from sheetname {string} and clicks on Ok button and Modify Confirm button")
	public void User_provides_Party_Name_value_from_sheetname_and_rowNumber_and_clicks_on_Ok_button_and_Modify_Confirm_button(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifyMiscellaneousRecord(SheetName);
	}//end 

	@And("User goes to Miscellaneous Approve screen and approve the modified record using SheetName {string} and rowNumber {int} and clicks on Ok button and Approve button")
	public void User_goes_to_Miscellaneous_Approve_screen_and_approve_the__modified_record_using_and_clicks_on_Ok_button_and_Approve_button(String SheetName,int Row) throws InterruptedException, InvalidFormatException, IOException {

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.approveMiscellaneous();
		elementUtil.SHORT_TIMEOUT();

		//corporatePage.approveMiscellaneousRecordforModify(SheetName, Row);

	}//end

	//------------------------------CANCEL DELETE ACTION SCENARIO--------------------------------------------------

	@Then("User provides Party Name value from sheetname {string} and clicks on Cancel Delete Action button to cancel the deletion")
	public void User_provides_Party_Name_value_from_sheetname_and_rowNumber_and_clicks_on_Cancel_Delete_Action_button_to_cancel_the_deletion(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.miscellaneousCancelDeleteAction(SheetName);
		//homePage.closeAdministrationMenu();
		//corporatePage = homePage.ListMiscellaneous();
		//corporatePage.listMiscellaneousRecord(SheetName,Row);


	}//end 

	//------------------------------CANCEL MODIFY ACTION FOR ADDED RECORD SCENARIO--------------------------------------------------

	@Then("User navigates to Approve screen to perform Cancel Modify Action using SheetName {string}")
	public void User_navigates_to_Approve_screen_to_perform_Cancel_Modify_Action_using_SheetName_and_rowNumber(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.approveMiscellaneous();
		elementUtil.SHORT_TIMEOUT();

		corporatePage.miscellaneousCancelModifyAction(SheetName);
		//homePage.closeAdministrationMenu();
		//corporatePage = homePage.ListMiscellaneous();
		//corporatePage.listMiscellaneousRecord(SheetName,Row);


	}//end 

	//------------------------------MISCELLANEOUS ADD SCREEN INVALID DATA---------------------------------------------
	@And("User provides invalid data using Sheet {string} to check Invalid Data Scenario")
	public void user_provides_invalid_data_using_sheet_and_rowNumber_to_check_invalid_data_scenario(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.miscellaneousAddRecord_InvalidData(SheetName);
	}//end 

	//------------------------------MISCELLANEOUS MODIFY SCREEN INVALID DATA---------------------------------------------
	@And("User provides invalid record details using SheetName {string} to check Invalid Data scenario")
	public void user_provides_invalid_record_details_using_sheet_and_rowNumber_to_check_invalid_data_scenario(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifyMiscellaneousRecord_InvalidData(SheetName);
	}//end 




















}
