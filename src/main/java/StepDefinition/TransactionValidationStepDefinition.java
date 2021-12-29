//package StepDefinition;
//
//import java.io.IOException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import AppHooks.Hooks;
//import COM.KOTAK.QA.FACTORY.DriverFactory;
//import COM.KOTAK.QA.PAGES.FileManagerPage;
//import COM.KOTAK.QA.PAGES.HomePage;
//import COM.KOTAK.QA.PAGES.LoginPage;
//import COM.KOTAK.QA.UTIL.ElementUtil;
//import freemarker.core.NonStringException;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
///**
//* @Author -- Suvarna Prabhumatkari
//**/
//
//public class TransactionValidationStepDefinition {
//	private DriverFactory driverFactory;
//	private WebDriver driver=DriverFactory.getDriver();
//	SponsorModulePage sponsorModulePage;
//	FileManagerPage fileManagerPage;
//	Hooks hooks=new Hooks();
//	LoginPage loginPage=new LoginPage(driver);
//	HomePage homePage=new HomePage(driver);
//	ElementUtil elementUtil=new ElementUtil(driver);
//	
//	//-------To Upload INP File-------//
//	@Given("User goes to File Manager menu and click on Sponsor Module Upload Submenu")
//	public void user_goes_to_File_Manager_menu_and_click_on_Sponsor_Module_Upload_Submenu() throws InterruptedException {
////		try {
////			elementUtil.SHORT_TIMEOUT();
////			elementUtil.SHORT_TIMEOUT();
////			homePage.closeackwindow();
////			elementUtil.GoToFrame("toc");
////		} catch (NoSuchElementException e) {
////			elementUtil.GoToFrame("toc");
////		}
//		
//		elementUtil.GoToFrame("toc");
//	    elementUtil.SHORT_TIMEOUT();
//	    sponsorModulePage=homePage.clickonSponsorModule_UploadLink();
//	}
//
//	@Then("User upload file using {string} and {int}")
//	public void user_upload_file_using_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		sponsorModulePage=sponsorModulePage.selectvaliddata(SheetName,Row);
//	}
//	
//	//-------To Check File Status---------//
//	@Given("User goes to File Manager menu and click on List Submenu")
//	public void user_goes_to_File_Manager_menu_and_click_on_List_Submenu() throws InterruptedException {
//		elementUtil.GoToFrame("toc");
//	    elementUtil.SHORT_TIMEOUT();
//	    fileManagerPage=homePage.clickonFileManager_ListLink();
//	}
//	
//	@Then("Check File status using {string} and {int}")
//	public void check_File_status_using_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		fileManagerPage.filterScreen(SheetName,Row);
//		fileManagerPage=fileManagerPage.checkFileStatus();
//	}
//	
//	//--------To Approve Possible Reject------//
//	@Given("User goes to File Manager menu and click on Sponsor Module Upload Submenu and then click on Approve Possible Reject submenu")
//	public void user_goes_to_file_manager_menu_and_click_on_sponsor_module_upload_submenu_and_then_click_on_approve_possible_reject_submenu() throws InterruptedException {
//		elementUtil.GoToFrame("content");
//		homePage.LogOut();
//		homePage=hooks.launchBrowser1();
//		elementUtil.SHORT_TIMEOUT();
//		sponsorModulePage=homePage.clickonSponsorModule_ApprovePossibleRejectLink();
//	}
//	
//	@Then("User select checkbox and select dropdown using {string} and {int} and click on Submit button")
//	public void user_select_checkbox_and_select_dropdown_using_and_and_click_on_submit_button(String SheetName, Integer Row) throws IOException, InterruptedException, IOException {
//		sponsorModulePage.approvePossibleReject(SheetName, Row);
//	}
//	
//	//---------To Create ACH File---------//
//	@Given("User goes to File Manager menu and click on Sponsor Module Upload Submenu and then click on Create ACH File submenu")
//	public void user_goes_to_File_Manager_menu_and_click_on_Sponsor_Module_Upload_Submenu_and_then_click_on_Create_ACH_File_submenu() throws InterruptedException {
//		elementUtil.GoToFrame("content");
//		homePage.LogOut();
//		homePage=hooks.launchBrowser1();
//		elementUtil.SHORT_TIMEOUT();
//	    sponsorModulePage=homePage.clickonSponsorModule_CreateACHFileLink();
//	}
//
//	@When("User filter out file using {string} and {int}")
//	public void user_filter_out_file_using_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		sponsorModulePage.filterScreen(SheetName,Row);
//	}
//	
//	@Then("User select file using checkbox and select dropdown using {string} and {int} and click on Submit button")
//	public void user_select_file_using_checkbox_and_select_dropdown_using_and_and_click_on_Submit_button(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		sponsorModulePage.createACHFile(SheetName, Row);
//	}
//	
//	//------To validate Transaction---------//
//	@When("Use filter using {string} and {int}")
//	public void use_filter_using_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		fileManagerPage.filterScreen(SheetName,Row);
//	}
//
//	@Then("User validate file using {string} and {int}")
//	public void user_validate_file_using_and(String SheetName1,Integer Row1) throws InterruptedException, InvalidFormatException, IOException {
//		fileManagerPage=fileManagerPage.clickonRecord();
//		fileManagerPage=fileManagerPage.writeinExcelSheet();
//		fileManagerPage=fileManagerPage.validateFile(SheetName1,Row1);
//	}
//	
//
//	
//	
//	
//}
