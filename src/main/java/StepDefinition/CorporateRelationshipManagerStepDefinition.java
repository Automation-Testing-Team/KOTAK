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


public class CorporateRelationshipManagerStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();


	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Add")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_sub_option_add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.relationshipManagerAddMenu();

	}//end

	@And("User provides the record details using Sheet {string}")
	public void user_provides_the_record_details_using_sheet_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.addRelationshipManagerRecord(SheetName);

	}//end

	@Then("User goes to Relationship Manager Approve screen for record approval using Sheet {string} and Row {int}")
	public void user_goes_to_relationship_manager_approve_screen_for_record_approval_using_sheet_and_row(String SheetName, int Row) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.relationshipManagerApproveMenu();
		elementUtil.SHORT_TIMEOUT();

		corporatePage.approveRelationshipManagerRecord(SheetName);
	}//end

	//-----------------------------RELATIONSHIP MANAGER APPROVE SCENARIO-----------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Approve")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_sub_option_approve() throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		corporatePage = homePage.relationshipManagerApproveMenu();


	}//end

	@Then("User provides the records details using {string} and approves it and views the record")
	public void User_provides_the_records_details_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.approveRelationshipManagerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.relationshipManagerListMenu();
		corporatePage.listRelationshipManagerRecord(SheetName);


	}//end

	//------------------------------RELATIONSHIP MANAGER LIST SCENARIO----------------------------------------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option List")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_sub_option_list() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.relationshipManagerListMenu();
	}//end

	@And("User provides the records details using {string} and {int} to view the record")
	public void User_provides_the_records_details_using_to_view_the_record(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.listRelationshipManagerRecord(SheetName);
	}//end

	//-----------------------------RELATIONSHIP MANAGER MODIFY SCENARIO----------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Modify")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_sub_option_modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.relationshipManagerModifyMenu();

	}//end

	@And("User provides the record details for modification using {string}")
	public void user_provides_the_record_details_for_modification_using_sheet_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifyRelationshipManagerRecord(SheetName);

	}//end

	//------------------------------RELATIONSHIP MANAGER DELETE SCENARIO---------------------------
	@Given("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Delete")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_sub_option_delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.relationshipManagerDeleteMenu();

	}//end

	@Then("User provides the record details in Delete filter screen using Sheet {string} for record deletion")
	public void user_provides_the_record_details_in_Delete_filte_screen_using_sheet_and_row_for_record_deletion(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.deleteRelationshipManagerRecord(SheetName);

	}//end

	//------------------------------RELATIONSHIP MANAGER CONFIRM DELETE SCENARIO---------------------------

	@Given("User navigates to Relationship Manager Confirm Delete Screen")
	public void User_navigates_to_Relationship_Manager_Confirm_Delete_Screen() throws InterruptedException {
		elementUtil.GoToFrame("content");
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		corporatePage=homePage.relationshipManagerconfirmDeleteMenu();

	}//end

	@And("User provides the record details in confirm Delete filter screen using Sheet {string} for confirming record deletion")
	public void user_provides_the_record_details_in_Confirm_Delete_filte_screen_using_sheet_and_row_for_confirming_record_deletion(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.confirmDeleteRelationshipManagerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.relationshipManagerListMenu();
		corporatePage.listRelationshipManagerRecord(SheetName);
	}//end

	//------------------------------CANCEL MODIFY ACTION SCENARIO FOR ADDED AND MODIFIED RECORD-----------------------------------------------------
	@Then("User navigates to Relationship Manager Approve screen to perform Cancel Modify Action using {string}")
	public void User_provides_the_records_details_using_and_clicks_on_Cancel_Modify_Action_button_and_views_the_record_using_List_menu(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		corporatePage=homePage.relationshipManagerApproveMenu();
		corporatePage.cancelModifyActionRelationshipManagerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.relationshipManagerListMenu();
		corporatePage.listRelationshipManagerRecord(SheetName);

	}//end

	//------------------------------CANCEL DELETE ACTION SCENARIO -----------------------------------------------------
	@Then("User navigates to Relationship Manager Confirm Delete Screen to perform Cancel Delete Action")
	public void user_navigates_to_relationship_manager_confirm_delete_screen_to_perform_cancel_delete_action_using_and_row() throws InterruptedException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.relationshipManagerconfirmDeleteMenu();
		
	}//end

	@Then("User navigates to Relationship Manager List screen after performing Cancel Delete Action to view the record using {string}")
	public void user_navigates_to_relationship_manager_list_screen_to_view_the_record_using_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.cancelDeleteActionRelationshipManagerRecord(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.relationshipManagerListMenu();
		corporatePage.listRelationshipManagerRecord(SheetName);

	}//end

	//-----------------------------FILTER SCREENS INVALID INPUT SCENARIO--------------------------------------------------
		
	@And("User provides invalid details on Modify filter screen")
	public void user_provides_invalid_details_on_Modify_filter_screen() throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifyFilterScreen_InvalidInput();
		elementUtil.SHORT_TIMEOUT();
		homePage.closeApplicationMenu();
	}//end

	@Then("User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on Approve option Link")
	public void user_navigates_to_application_and_maintenance_clicks_on_corporate_cms_menu_selects_relationship_manager_and_clicks_on_approve_option_link() throws InterruptedException, InvalidFormatException, IOException {
		//elementUtil.SHORT_TIMEOUT();
		//driver.switchTo().frame("content");
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		corporatePage = homePage.relationshipManagerApproveMenu();
	}//end
	
	@And("User provides invalid details on Approve filter screen then moves to Relationship Manager List filter screen to enter invalid input")
	public void user_provides_invalid_input_details_for_filter_screen_search_criteria() throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.approveFilterScreen_InvalidInput();
		homePage.closeApplicationMenu();
		corporatePage = homePage.relationshipManagerListMenu();
		corporatePage.listFilterScreen_InvalidInput();
	}//end

	//---------------------------RELATIONSHIP MANAGER ADD-INVALID DATA SCENARIO------------------------------
	@And("User provides the invalid record details using {string}")
	public void user_provides_the_invalid_record_details_using_sheet_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.addRelationshipManagerRecord_InvalidData(SheetName);

	}//end
	
	//----------------------------RELATIONSHIP MANAGER MODIFY INVALID DATA-------------------------------------------
	@And("User provides the invalid record details for modification using {string}")
	public void user_provides_the_invalid_record_details_for_modification_using_sheet_and_row(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		corporatePage.modifyRelationshipManagerRecord_InvalidData(SheetName);

	}//end






}
