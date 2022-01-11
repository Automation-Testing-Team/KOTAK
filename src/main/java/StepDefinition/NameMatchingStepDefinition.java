package StepDefinition;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.PAGES.NameMatchingPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class NameMatchingStepDefinition {

	private DriverFactory driverFactory;
	private WebDriver driver = DriverFactory.getDriver();
	Hooks hooks = new Hooks();
	NameMatchingPage nameMatchingPage;
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	ElementUtil elementUtil =new ElementUtil(driver);
	
	// ----------------Add Name Matching record--------------------------//
	@Given("User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Add")
	public void user_navigates_to_Application_and_clicks_on_Maintenance_menu_and_then_selects_Name_Matching_menu_and_clicks_on_sub_option_Add() throws InterruptedException {
	    elementUtil.GoToFrame("toc");
	    elementUtil.SHORT_TIMEOUT();
	    nameMatchingPage = homePage.clickonNameMatchingAddLink();
	}

	@Then("User add Name Matching record using {string}")
	public void user_add_Name_Matching_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		nameMatchingPage.addNameMatchingRecord(SheetName);
	}
	
	//----------------List Name Matching record--------------------------//
	@Given("User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option List")
	public void user_navigates_to_Application_and_clicks_on_Maintenance_menu_and_then_selects_Name_Matching_menu_and_clicks_on_sub_option_List() throws InterruptedException {
		 elementUtil.GoToFrame("toc");
		 elementUtil.SHORT_TIMEOUT();
		 nameMatchingPage = homePage.clickonNameMatchingListLink();
	}

	@Then("User list Name Matching record using {string}")
	public void user_list_Name_Matching_record_using(String SheetName) throws InvalidFormatException, InterruptedException, IOException {
		nameMatchingPage.listNameMatchingRecord(SheetName);
	}
	
	//----------------Modify Name Matching record--------------------------//
	@Given("User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Modify")
	public void user_navigates_to_Application_and_clicks_on_Maintenance_menu_and_then_selects_Name_Matching_menu_and_clicks_on_sub_option_Modify() throws InterruptedException {
		 elementUtil.GoToFrame("toc");
		 elementUtil.SHORT_TIMEOUT();
		 nameMatchingPage = homePage.clickonNameMatchingModifyLink();
	}

	@Then("User modify Name Matching record using {string}")
	public void user_modify_Name_Matching_record_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	    nameMatchingPage.modifyNameMatchingRecord(SheetName);
	}
	
	//----------------Delete Name Matching record--------------------------//
	@Given("User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Delete")
	public void user_navigates_to_Application_and_clicks_on_Maintenance_menu_and_then_selects_Name_Matching_menu_and_clicks_on_sub_option_Delete() throws InterruptedException {
		 elementUtil.GoToFrame("toc");
		 elementUtil.SHORT_TIMEOUT();
		 nameMatchingPage = homePage.clickonNameMatchingDeleteLink();
	}

	@Then("User deletes Name Matching record")
	public void user_deletes_Name_Matching_record() throws InvalidFormatException, InterruptedException, IOException {
		nameMatchingPage.deleteNameMatchingRecord();
	}
	
	
}
