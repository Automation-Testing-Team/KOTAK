package StepDefinition;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//imports
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.EnvironmentPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.PAGES.ProfilePage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class ProfileStepDefinition {
	
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver();
	EnvironmentPage environmentPage;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);
	Hooks hooks = new Hooks();
	ProfilePage profilePage;
	
	//----------Profile Add------------//
	
	@Given("user is on Administration menu and clicks on Profile menu and Add menu")
	public void user_goes_to_Administration_and_then_Profile_Add_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		profilePage = homePage.ProfileAddMenu();
	}//end

	@Then("user enters the profile name using {string} and clicks on checkboxes and ok button")
	public void user_enters_valid_record_details_using_and_clicks_on_Ok_button(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		profilePage.addprofile(SheetName);
	}//end
	
	//----------Profile Approve------------//

	@Given("user goes to Administration and then Profile Approve menu")
	public void user_goes_to_Administration_and_then_Profile_Approve_menu() throws InterruptedException {
		elementUtil.GoToFrame("content");
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		profilePage=homePage.ProfileApproveMenu();
	}//end

	@Then("user approve the record using {string}")
	public void user_goes_to_Profile_Approve_screen_and_approves_the_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		profilePage.profileApprove(SheetName);
	}//end

	//----------Profile List------------//
	
	@Given("user is on Administration menu and clicks on Profile menu and List menu")
	public void user_goes_to_Administration_and_then_Profile_List_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		profilePage = homePage.ProfileListMenu();
	
	}//end

	@Then("user list the profile using {string}")
	public void user_goes_to_Profile_List_screen_and_views_the_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		profilePage.listProfileRecord(SheetName);
	}//end
	
	//----------Profile Modify/Repair------------//

	@Given("User goes to Administration and then User selects Profile Modify\\/Repair menu")
	public void user_goes_to_Administration_and_then_User_selects_Profile_Modify_Repair_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		profilePage = homePage.ProfileModifyMenu();
	}//end

	@Then("User provides valid profile record details for Modify\\/Repair operation using {string}")
	public void user_provides_valid_profile_record_details_for_Modify_Repair_operation_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		profilePage.modifyRepairprofile(sheetName);
	}//end
	
	//----------Profile Remove------------//

	@Given("user is on Administration menu and clicks on Profile menu and Remove menu")
	public void user_goes_to_Administration_and_then_User_selects_Profile_Remove_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		profilePage = homePage.ProfileRemoveMenu();
	}//end

	@Then("user removes the profile using {string}")
	public void user_goes_to_Profile_Remove_screen_and_remove_the_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		profilePage.profileRemove(SheetName);
	}//end



}
