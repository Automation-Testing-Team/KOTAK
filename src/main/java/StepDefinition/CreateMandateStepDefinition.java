//package StepDefinition;
//
//import java.io.IOException;
//import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import AppHooks.Hooks;
//import COM.KOTAK.QA.FACTORY.DriverFactory;
//import COM.KOTAK.QA.PAGES.HomePage;
//import COM.KOTAK.QA.PAGES.LoginPage;
//import COM.KOTAK.QA.UTIL.ElementUtil;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//public class CreateMandateStepDefinition {
//
//	private DriverFactory driverFactory;
//	private WebDriver driver=DriverFactory.getDriver();
//	SponsorMandatePage sponsorMandatePage;
//	Hooks hooks=new Hooks();
//	LoginPage loginPage=new LoginPage(driver);
//	HomePage homePage=new HomePage(driver);
//	ElementUtil elementUtil=new ElementUtil(driver);
//	Logger log = Logger.getLogger(CreateMandateStepDefinition.class);
//	
//	//-------To Upload Mandate File-------//
//	@Given("User go to File Manager menu and click on Sponsor Module Upload Submenu")
//	public void user_go_to_file_manager_menu_and_click_on_sponsor_module_upload_submenu() throws InterruptedException {
//		elementUtil.GoToFrame("toc");
//	    elementUtil.SHORT_TIMEOUT();
//	    sponsorMandatePage=homePage.clickonSponsorModuleUploadLink();
//	}
//	
//	@Then("User uploads file using {string} and {int}")
//	public void user_uploads_file_using_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		sponsorMandatePage=sponsorMandatePage.selectvaliddata(SheetName,Row);
//	}
//	
//	//--------To Approve Mandate----------//
//	@Given("User goes to Mandate Management Sponsor Mandate menu and click on Approve Mandate Submenu")
//	public void user_goes_to_mandate_management_sponsor_mandate_menu_and_click_on_approve_mandate_submenu() throws InterruptedException {
//		elementUtil.GoToFrame("content");
//		homePage.LogOut();
//		homePage=hooks.launchBrowser1();
//		elementUtil.SHORT_TIMEOUT();
//	    sponsorMandatePage=homePage.clickonSponsorMandateApproveMandate();
//	}
//
//	@Then("approve the mandate using {string} and {int} and list the mandate")
//	public void approve_the_mandate_and(String SheetName, Integer Row) throws InvalidFormatException, InterruptedException, IOException {
//		sponsorMandatePage.filterScreen(SheetName, Row);
//		sponsorMandatePage.approveMandate(SheetName, Row);
//		homePage.closeApplicationMenu();
//		sponsorMandatePage = homePage.clickonSponsorMandateListMandate();
//		sponsorMandatePage.filterScreen(SheetName, Row);
//		sponsorMandatePage.listMandate();
//		
//	}
//
//	
//	
//	
//	
//	
//}
