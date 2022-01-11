package StepDefinition;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.PAGES.SchedulePage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class ScheduleStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver(); 
	SchedulePage schedulePage;
	Hooks hooks=new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);
	
	@Then("User goes Maintenance and open Schedule Control menu")
	public void user_goes_Maintenance_and_open_Schedule_Control_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
	    schedulePage=homePage.clickonScheduleControlLink();
	}
	
	@Then("User Activate the Scheduler Service")
	public void user_Activate_the_Scheduler_Service() throws InterruptedException {
		schedulePage=schedulePage.checkSchedulerstatus();
	}
	
	@Then("User list the Scheduler using {string}")
	public void user_list_the_Scheduler_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		schedulePage=schedulePage.listSchedulers(SheetName);
	}
	
	@Then("User goes Maintenance and open Schedule New menu")
	public void user_goes_Maintenance_and_open_Schedule_New_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		schedulePage = homePage.clickonScheduleNewLink();
	}

	@Then("User add Valid data for Scheduler using {string}")
	public void user_add_scheduler_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		schedulePage=schedulePage.addSchedulerwithValidData(SheetName);
	}

	@Then("User add Invalid data for Scheduler using {string}")
	public void user_tries_to_add_already_existing(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		schedulePage = schedulePage.addSchedulerwithInValidData(SheetName);
	}

	@Then("User goes Maintenance and open Schedule Modify menu")
	public void user_goes_Maintenance_and_open_Schedule_Modify_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
	    schedulePage=homePage.clickonScheduleModifyLink();
	}
	
	@Then("User modify Scheduler using {string}")
	public void user_modify_scheduler_using(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		schedulePage=schedulePage.modifyScheduler(SheetName);
	}
	
	@Then("User goes Maintenance and open Schedule List menu")
	public void user_goes_Maintenance_and_open_Schedule_List_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		schedulePage = homePage.clickonScheduleListLink();
	}
}
