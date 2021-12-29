package StepDefinition;

//imports
import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.EnvironmentPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.PAGES.UserPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class UserStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver();
	EnvironmentPage environmentPage;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);
	Hooks hooks = new Hooks();
	UserPage userPage;

	//--------Create User----------//
	@Given("User goes to Administration and then User Add menu")
	public void user_goes_to_administration_and_then_user_add_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		userPage = homePage.UserAddMenu();
	}//end

	@Given("User enters details using {string} and clicks on Ok button")
	public void user_enters_details_using_and_and_clicks_on_ok_button(String SheetName) throws InvalidFormatException, InterruptedException, IOException  {
		userPage.addUser(SheetName);
	}//end
	
	//----------User Approve-----------//
	
	@Given("User goes to Administration and then User Approve menu")
	public void user_goes_to_Administration_and_then_User_Approve_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("content");
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		elementUtil.SHORT_TIMEOUT();
		userPage=homePage.UserApproveMenu();
	}//end

	@Then("User goes to Approve screen and approves the record using {string}")
	public void user_goes_to_Approve_screen_and_approves_the_record_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		userPage.approveUserRecord(sheetName);
	}//end
	
	//-----------User List--------------//

	@Given("User goes to Administration and then User List menu")
	public void user_goes_to_Administration_and_then_User_List_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		userPage = homePage.UserListMenu();
	}//end

	@Then("User goes to List screen and views the record using {string}")
	public void user_goes_to_List_screen_and_views_the_record_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		userPage.listUserRecord(sheetName);
	}//end
	
	//------------User Modify/Repair----------------//

	@Given("User goes to Administration and then User selects Modify\\/Repair menu")
	public void user_goes_to_Administration_and_then_User_selects_Modify_Repair_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		userPage = homePage.UserModifyMenu();
	}//end

	@Then("User provides valid record details for Modify\\/Repair operation using {string}")
	public void user_provides_valid_record_details_for_Modify_Repair_operation_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		userPage.modifyUserRecord(sheetName);
	}//end
	
	//---------------User Remove-------------------//

	@Given("User goes to Administration and then User selects Remove menu")
	public void user_goes_to_Administration_and_then_User_selects_Remove_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		userPage = homePage.UserRemoveMenu(); 
	}//end

	@Then("User goes to Remove screen and remove the record using {string}")
	public void user_goes_to_Remove_screen_and_remove_the_record_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		userPage.removeUserRecord(sheetName);
	}//end

	//-------------User Block/Unblock----------------//
	@Given("User goes to Administration and then User selcts Block or UnBlock menu")
	public void user_goes_to_Administration_and_then_User_selcts_Block_or_UnBlock_menu() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		userPage = homePage.UserBlockUnBlockMenu(); 
	}//end

	@Then("User goes to BlockUnblock screen and Block or UnBlock the record using {string}")
	public void user_goes_to_BlockUnblock_screen_and_Block_or_UnBlock_the_record_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		userPage.userBlockUnblockRecord(sheetName);
	}//end


}
