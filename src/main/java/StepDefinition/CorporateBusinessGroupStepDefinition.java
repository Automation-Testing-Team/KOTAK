package StepDefinition;

//imports
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
public class CorporateBusinessGroupStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CorporatePage corporatePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	// ------------------------------Business Group Add Menu Method--------------------------------------------------
	@Given("User goes to Application and Maintenance clicks on Business group and clicks on Add menu")
	public void user_goes_to_application_and_maintenance_clicks_on_business_group_and_clicks_on_add_menu()
			throws InterruptedException {

		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.createBusinessGroup();
	}//end
	
	@And("User add Business Group record using {string} and clicks on Ok button and Add confirm button")
	public void user_add_business_group_record_using_and_and_clicks_on_ok_button_and_add_confirm_button(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		corporatePage.addBusinessGroup(SheetName);
	}//end

	@Then("User goes to Business Group Approve menu approves the record using {string} and views the record using List Menu")
	public void user_goes_to_business_group_approve_menu_and_approves_the_record(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage = homePage.approveBusinessGroup();
		corporatePage.approveBusinessGroupRecord(SheetName);
		homePage.closeApplicationMenu();
		corporatePage = homePage.listBusinessGroup();
		corporatePage.listBusinessGroupRecord(SheetName);

	}//end

	@Given("User add invalid data using {string} and clicks on Ok button and validate")
	public void user_add_invalid_data_using_clicks_on_ok_button_and_validate(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	    
		corporatePage.addInvalidBusinessGroup(SheetName);
	}//end
	
	//------------------------------------Modify Method----------------------------------
	@Given("User goes to Application and Maintenance clicks on Business group and clicks on Modify menu")
	public void User_goes_to_application_and_maintenance_clicks_on_business_group_and_clicks_on_modify_menu() throws InterruptedException {
	 
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.modifyBusinessGroup();
	}//end 
	

	@And("User modifies the record using {string} and clicks on Ok button and Modify Confirm button")
	public void user_modifies_the_record_using_clicks_on_ok_button_and_modify_confirm_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	   corporatePage.modifyBusinessGroup(SheetName);
	}//end 
	
	//------------------------------------Delete Method-------------------------------------------
	@Given("user goes to Application and Maintenance clicks on Business group and clicks on Delete menu")
	public void user_goes_to_application_and_maintenance_clicks_on_business_group_and_clicks_on_delete_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.deleteBusinessGroup();
	}//end 

	@And("User deletes the record from the list using {string}")
	public void user_deletes_the_record_from_the_list_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	    corporatePage.deleteBusinessGroupRecord(SheetName);
	}//end

	@Then("User goes to Confirm Delete Menu confirms the deletion of record using {string} and views the record using List Menu")
	public void user_goes_to_confirm_delete_menu_and_confirms_the_deletion_of_record_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.confirmDeleteBusinessGroup();
		corporatePage.deleteConfirmBusinessGroup(SheetName);
		homePage.closeApplicationMenu();
		corporatePage = homePage.listBusinessGroup();
		corporatePage.listBusinessGroupRecord(SheetName);

	}//end 
	
	//--------------------------------MODIFY RECORD WITH INVALID DATA------------------------------------------
	@And("User provides invalid data for modify operation using {string} and clicks on Ok button and validate")
	public void user_provides_invalid_data_for_modify_operation_using_clicks_on_ok_button_validate(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	    corporatePage.modifyInvalidBusinessGroup(SheetName);
	}//end

	//---------------------------------CANCEL MODIFY ACTION SCENARIO----------------------------------------------
	@Then("User goes to Business Group Approve menu using {string} and clicks on Cancel Modify Action button and views the record")
	public void user_goes_to_business_group_approve_menu_using_clicks_on_cancel_modify_action_button_and_views_the_recors(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();

		corporatePage = homePage.approveBusinessGroup();
		corporatePage.businessGroupCancelModifyAction(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listBusinessGroup();
		corporatePage.listBusinessGroupRecord(SheetName);

	}//end
	//---------------------------------CANCEL DELETE ACTION SCENARIO--------------------------------------------------
	@Then("User goes to Confirm Delete Menu using {string} and clicks on Cancel Delete Action button and views the record using List Menu")
	public void user_goes_to_confirm_delete_menu_using_and_clicks_on_cancel_delete_action_button(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		corporatePage=homePage.confirmDeleteBusinessGroup();
		corporatePage.businessGroupCancelDeleteAction(SheetName);
		homePage.closeAdministrationMenu();
		corporatePage = homePage.listBusinessGroup();
		corporatePage.listBusinessGroupRecord(SheetName);

	}//end 
	
	

	
	
}
