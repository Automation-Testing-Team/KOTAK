package StepDefinition;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import AppHooks.Hooks;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.CalendarPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class CalendarStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver = DriverFactory.getDriver();
	CalendarPage calendarPage;
	Hooks hooks = new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil = new ElementUtil(driver);
	Logger log = Logger.getLogger(CalendarStepDefinition.class);

	// --------Create Calendar----------//
	@Then("User goes to Maintenance and open Calendar Add menu to add Calendar")
	public void user_goes_to_Maintenance_and_open_Calendar_Add_menu_to_add_Calendar() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		calendarPage = homePage.clickonCalendarCreateLink();
	}

	@Then("User add Calendar with invalid data using {string}")
	public void user_add_calendar_with_and_enter_invalid(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		calendarPage = calendarPage.createCalendarwithInvalidData(SheetName);
	}

	@Then("User add Calendar with valid data using {string}")
	public void user_add_Calendar_with(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		calendarPage = calendarPage.createCalendarwithValidData(SheetName);
	}

	// --------Approve Calendar----------//
	@Then("User goes to Maintenance and open Calendar Approve menu to approve Calendar")
	public void user_goes_to_Maintenance_and_open_Calendar_Approve_menu_to_approve_Calendar()
			throws InterruptedException {
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		homePage.LogOut();
		log.info("Launch Browser");
		homePage = hooks.launchBrowser1();
		calendarPage = homePage.clickonCalendarApproveLink();
	}

	@Then("User Approves Calendar using {string} and view the record")
	public void user_Approves_Calendar_using(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		calendarPage = calendarPage.approveCalendar(SheetName);
		homePage.closeApplicationMenu();
		calendarPage = homePage.clickonCalendarViewLink();
		calendarPage.viewCalendar(SheetName);
	}

	// --------View Calendar----------//
	@Then("User goes to Maintenance and open Calendar View menu")
	public void user_goes_to_Maintenance_and_open_Calendar_View_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		calendarPage = homePage.clickonCalendarViewLink();
	}

	@Then("User view Calendar using {string}")
	public void user_view_calendar_using(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		calendarPage = calendarPage.viewCalendar(SheetName);
	}

	// --------Modify Calendar----------//
	@Then("User goes to Maintenance and open Calendar Modify menu")
	public void user_goes_to_Maintenance_and_open_Calendar_Modify_menu() throws InterruptedException {
	   elementUtil.GoToFrame("toc");
	   elementUtil.SHORT_TIMEOUT();
	   calendarPage=homePage.clickonCalendarModifyLink();
	}

	@Then("User modify Calendar using {string} and view the record")
	public void user_modify_Calendar_using_valid(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		elementUtil.SHORT_TIMEOUT();
		calendarPage=calendarPage.modifyCalendar(SheetName);
		homePage.closeApplicationMenu();
		calendarPage = homePage.clickonCalendarViewLink();
		calendarPage.viewCalendar(SheetName);
	}


}
