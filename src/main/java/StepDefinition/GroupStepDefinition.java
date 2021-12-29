package StepDefinition;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.GroupPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class GroupStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver(); 
	GroupPage groupPage;
	Hooks hooks=new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);
	
	//--------Create Group----------//
	@Given("user goes to administration and clicks on Group menu and add menu")
	public void user_goes_to_administration_and_clicks_on_profile_menu_and_add_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage = homePage.clickonAddGroupLink();
	}
	
	@Then("user enters data using {string} and clicks on Ok button")
	public void user_enters_data_using_and_clicks_on_Ok_button(String SheetName) throws InterruptedException, IOException {
		groupPage.addGroup(SheetName);
	}

	//-------------Approve Group-------------//
	@Given("user goes to administration and clicks on Group menu and Approve menu")
	public void user_goes_to_administration_and_clicks_on_Group_menu_and_Approve_menu() throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		homePage = hooks.launchBrowser1();
		groupPage = homePage.clickonApproveGroupLink();
	}
	
	@Then("user approves the record using {string}")
	public void user_approves_the_record(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		groupPage.approveRecord(SheetName);
	}

	// --------Modify Group----------//

	@Then("user goes to administration and clicks on Group menu and modify menu")
	public void user_goes_to_administration_and_clicks_on_profile_menu_and_modify_menu_and_enters()
			throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage = homePage.clickonModifyGroupLink();

	}
	
	@Then("user modifies record using {string}")
	public void user_modifies_and(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		groupPage.modifyGroupRecord(SheetName);
	}

	// -------Remove Group---------//
	@Then("user goes to administration and clicks on Group menu and remove menu")
	public void user_goes_to_administration_and_clicks_on_profile_menu_and_remove_menu_and_enters()
			throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage = homePage.clickonRemoveGroupLink();
	}

	@Then("user removes the group profile using {string}")
	public void user_removes_the_group_profile(String SheetName) throws InterruptedException, IOException {
		groupPage.removeGroupRecord(SheetName);
	}
	
	//---------List Group------------//
	@Given("user goes to administration and clicks on Group menu and List menu")
	public void user_goes_to_administration_and_clicks_on_group_menu_and_list_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage = homePage.clickonListGroupLink();
	}
	
	@Then("user list the group profile using {string}")
	public void user_list_the_group_profile(String SheetName) throws InterruptedException, IOException {
		groupPage=groupPage.listGroupRecord(SheetName);
	}
	
	//--------Block Group-------//
	@Given("user goes to administration and clicks on Group menu and Block menu")
	public void user_goes_to_administration_and_clicks_on_group_menu_and_block_menu_and_enters() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage=homePage.clickonBlockGroupLink();
	}

	@Then("user blocks group profile using {string}")
	public void user_blocks_group_profile_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		groupPage=groupPage.blockGroup(SheetName);
	}
	
	//--------Unblock Group----------//
	@Given("user goes to administration and clicks on Group menu and Unblock menu")
	public void user_goes_to_administration_and_clicks_on_group_menu_and_unblock_menu_and_enters() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		groupPage=homePage.clickonUnblockGroupLink();
	}
	
	@Then("user unblocks group profile")
	public void user_unblocks_group_profile() throws InterruptedException {
		groupPage=groupPage.unblockGroup();
	}
}

