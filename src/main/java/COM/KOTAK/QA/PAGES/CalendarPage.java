package COM.KOTAK.QA.PAGES;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.FileReadUtils;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class CalendarPage {
	private WebDriver driver;
	List<Map<String, String>> testData;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(CalendarPage.class);

	// WebElements for Calendar Page
	@FindBy(name = "currency")
	WebElement currency;

	@FindBy(name = "paymentType")
	WebElement paymentType;

	@FindBy(name = "month")
	WebElement month;

	@FindBy(name = "year")
	WebElement year;

	@FindBy(name = "filter")
	WebElement statusfilter;

	@FindBy(name = "toYear")
	WebElement toYear;

	@FindBy(id = "resetButton")
	WebElement resetBtn;

	@FindBy(xpath = "//body[@id='body']//td//td[1]//input[1]")
	WebElement resetbtn;

	@FindBy(xpath = "//tr[7]//td[1]//input[1]")
	WebElement RESETBtn;

	@FindBy(xpath = "//tr[8]//td[1]//input[1]")
	WebElement ResetBtn;

	@FindBy(xpath = "//table[@class='TableBorder']//input[2]")
	WebElement okBtn;

	@FindBy(name = "submit")
	WebElement submitBtn;

	@FindBy(name = "confirm")
	WebElement confirmBtn;

	@FindBy(name = "Cancel")
	WebElement CANCELBtn;

	@FindBy(xpath = "//p[@class='label']")
	WebElement message;

	@FindBy(xpath = "//tr[2]")
	WebElement record;

	@FindBy(xpath = "//div[@id='pageBody']//table//tbody//tr//td//form//p//input")
	WebElement removeBtn;

	@FindBy(xpath = "//button[contains(text(),'ack to List')]")
	WebElement backtoListBtn;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement verifyCurrency;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[6]")
	WebElement verifyStatus;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement verifyYear;

	@FindBy(name = "approve")
	WebElement approveBtn;

	@FindBy(name = "reject")
	WebElement rejectBtn;

	@FindBy(name = "repair")
	WebElement repairBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement OKBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement OKBTN;

	@FindBy(name = "day")
	WebElement daytype;

	@FindBy(name = "org.apache.struts.taglib.html.CANCEL")
	WebElement cancelBtn;

	@FindBy(xpath = "//a[contains(text(),'Restart Workflow')]")
	WebElement restartWorkflow;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
	WebElement validationMsg;

	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;
	
	@FindBy(name = "collapse")
	WebElement collapsemonth;

	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	// CalendarPage Class Constructor
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}

	// -----To Create Calendar with Valid data------//
		public CalendarPage createCalendarwithValidData(String SheetName)
				throws InterruptedException, IOException {
			List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {
			String ISOCode = map.get("ISOCode");
			String PaymentType = map.get("PaymentType");
			String Month = map.get("Month");
			String Year = map.get("Year");
			String DayType = map.get("DayType");

			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);

			elementUtil.clickElement(resetbtn);
			String a = elementUtil.getText(year);
			if (a.isEmpty()) {
				log.info("Reset Button functionality is working fine");
			} else {
				log.error("Reset Button is not working fine");
			}

			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);

			try {
				String expectedYearMsg = "Calendar already exists";
				if (elementUtil.getText(errormessages).equals(expectedYearMsg)) {
					log.info("Proper validation message is displayed for Already existing Year " + Year + " for " + ISOCode
							+ " currency");
				} else {
					log.error("Validation failed for Existing year");
				}
			}
			catch(NoSuchElementException e) {
			elementUtil.clickElement(cancelBtn);
			String expectedCancelValidationMsg = "Operation Create new calendar was cancelled.";
			if (elementUtil.getText(errormessages).equals(expectedCancelValidationMsg)) {
				log.info("Cancel operation executed successully");
			} else {
				log.error("Cancel Button is not working");
			}

			elementUtil.clickElement(restartWorkflow);
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);
			elementUtil.clickElement(daytype);
			elementUtil.selectDropDownByVisibleText(daytype, DayType);
			elementUtil.clickElement(OKBtn);

			elementUtil.clickElement(cancelBtn);
			if (elementUtil.getText(errormessages).equals(expectedCancelValidationMsg)) {
				log.info("Cancel Button from Calendar details Confirm screen is working fine");
			} else {
				log.error("Cancel button from Calendar details Confirm screen is not working");
			}
			elementUtil.clickElement(restartWorkflow);
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);
			elementUtil.clickElement(daytype);
			elementUtil.selectDropDownByVisibleText(daytype, DayType);
			elementUtil.clickElement(OKBtn);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(OKBTN);
			elementUtil.SHORT_TIMEOUT();

			String expectedCalendarvalidationMsg = "Operation Create new calendar executed successfully. placed in APPROVE queue.";
			String expectedValidationMsg = "Invalid Year.";
			if (elementUtil.getText(messages).equals(expectedCalendarvalidationMsg)) {
				log.info("Added calendar with year "+Year+" is placed in Approve queue");
			} else if (elementUtil.getText(messages).equals(expectedValidationMsg)){
				log.info("Proper validation message is displayed for Invalid Year " + Year + " for " + ISOCode
						+ " currency");
			}else {
				log.error("Validation failed for Invalid Year");
			}
			}
			elementUtil.clickElement(restartWorkflow);
		}
			logOutOperation();
			return new CalendarPage(driver);
		}

		// ----------To create Calendar with Invalid data----------//
		public CalendarPage createCalendarwithInvalidData(String SheetName)
				throws InterruptedException, IOException {
			List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {
				
				String ISOCode = map.get("ISOCode");
				String PaymentType = map.get("PaymentType");
				String Month = map.get("Month");
				String Year = map.get("Year");
				
				elementUtil.clickElement(currency);
				elementUtil.selectDropDownByVisibleText(currency, ISOCode);
				elementUtil.clickElement(paymentType);
				elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
				elementUtil.clickElement(month);
				elementUtil.selectDropDownByVisibleText(month, Month);
				elementUtil.enterText(year, Year);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(okBtn);

				String expectedValidationMsg = "Invalid Year.";
				try {
				if (elementUtil.getText(errormessages).equals(expectedValidationMsg)) {
					log.info("Proper validation message is displayed for Invalid/Blank Year " + Year + " for " + ISOCode
							+ " currency");
				} else {
					log.error("Validation failed for Invalid Year");
				}
				}
				catch(NoSuchElementException e)
					{
					log.info("Test data provided for Calendar Create menu is not Invalid");
					}
				elementUtil.clickElement(restartWorkflow);
			}
			logOutOperation();
			return new CalendarPage(driver);
		}

		// --------To Approve Calendar---------//
		public CalendarPage approveCalendar(String SheetName)
				throws InterruptedException, IOException {
			List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {

			String ISOCode = map.get("ISOCode");
			String PaymentType = map.get("PaymentType");
			String Month = map.get("Month");
			String Year = map.get("Year");
			String Operation = map.get("Operation");

			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(RESETBtn);

			String a = elementUtil.getText(year);
			if (a.isEmpty()) {
				log.info("Reset Button functionality is working fine");
			} else {
				log.error("Reset Button is not working");
			}
			
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(okBtn);
			elementUtil.SHORT_TIMEOUT();

			if(Operation.equalsIgnoreCase("Approve")) {
			String ScreenMsg = "Calendar details";
			String ScreenMsg1 = "Approve calendar changes";
			String CriteriaMsg = "No items available for Approve operation given the search criteria";
			
			String ExpectedCalendarValidationMsg = "Operation Approve calendar changes executed successfully. "+Year+"-"+Month+"-"+ISOCode+"-"+PaymentType+" placed in active queue.";
			String ErrorMsg = "Operation Approve calendar changes failed to execute: User cannot approve own modification.";

			try {
				if ((validationMsg.getText().equals(CriteriaMsg) || errormessages.getText().equals(CriteriaMsg))) {
					log.info("Calendar " + Year + "  is not available for Approve Operation");
				}
			} catch (NoSuchElementException e) {
				if (validationMsg.getText().equals(ScreenMsg1)) {
					elementUtil.clickElement(record);
					if (validationMsg.getText().equals(ScreenMsg) || errormessages.getText().equals(ScreenMsg)) {
						elementUtil.clickElement(approveBtn);
						elementUtil.SHORT_TIMEOUT();
						if (validationMsg.getText().equals(ExpectedCalendarValidationMsg)) {
							log.info("Calendar " + Year + " approved successfully and placed in ACTIVE queue");
						} else {
							log.error("Validation message is not proper");
						}
					} else if (errormessages.getText().equals(ErrorMsg)) {
						log.info("Calendar " + Year + "  is failed to Approve since it has 4 eye principle");
					}

				}
			}
			}else if(Operation.equalsIgnoreCase("Reject")) {
				String ScreenMsg = "Calendar details";
				String ScreenMsg1 = "Approve calendar changes";
				String CriteriaMsg = "No items available for Approve operation given the search criteria";
				String ExpectedCalendarValidationMsg = "Operation Reject changes for calendar executed successfully. "+Year+"-"+Month+"-"+ISOCode+"-"+PaymentType+" placed in REJECTED queue.";
				String ErrorMsg = "Operation Approve calendar changes failed to execute: User cannot approve own modification.";

				try {
					if ((validationMsg.getText().equals(CriteriaMsg) || errormessages.getText().equals(CriteriaMsg))) {
						log.info("Calendar " + Year + "  is not available for Reject Operation");
					}
				} catch (NoSuchElementException e) {
					if (validationMsg.getText().equals(ScreenMsg1)) {
						elementUtil.clickElement(record);
						if (validationMsg.getText().equals(ScreenMsg) || errormessages.getText().equals(ScreenMsg)) {
							elementUtil.clickElement(rejectBtn);
							elementUtil.SHORT_TIMEOUT();
							if (validationMsg.getText().equals(ExpectedCalendarValidationMsg)) {
								log.info("Calendar " + Year + " rejected successfully.");
							} else {
								log.error("Validation message is not proper");
							}
						} else if (errormessages.getText().equals(ErrorMsg)) {
							log.info("Calendar " + Year + "  is failed to Reject since it has 4 eye principle");
						}

					}
				}
			}
			else if (Operation.equalsIgnoreCase("SendToRepair")) {
				String ScreenMsg = "Calendar details";
				String ScreenMsg1 = "Approve calendar changes";
				String CriteriaMsg = "No items available for Approve operation given the search criteria";
				String ExpectedCalendarValidationMsg = "Operation Send to repair executed successfully. "+Year+"-"+Month+"-"+ISOCode+"-"+PaymentType+" placed in REPAIR queue.";
				String ErrorMsg = "Operation Approve calendar changes failed to execute: User cannot approve own modification.";

				try {
					if ((validationMsg.getText().equals(CriteriaMsg) || errormessages.getText().equals(CriteriaMsg))) {
						log.info("Calendar " + Year + "  is not available for Repair Operation");
					}
				} catch (NoSuchElementException e) {
					if (validationMsg.getText().equals(ScreenMsg1)) {
						elementUtil.clickElement(record);
						if (validationMsg.getText().equals(ScreenMsg) || errormessages.getText().equals(ScreenMsg)) {
							elementUtil.clickElement(repairBtn);
							elementUtil.SHORT_TIMEOUT();
							if (validationMsg.getText().equals(ExpectedCalendarValidationMsg)) {
								log.info("Calendar " + Year + " send to Repair queue successfully.");
							} else {
								log.error("Validation message is not proper");
							}
						} else if (errormessages.getText().equals(ErrorMsg)) {
							log.info("Calendar " + Year + "  is failed to send to Repair queue since it has 4 eye principle");
						}

					}
				}
			}
			elementUtil.clickElement(restartWorkflow);
			}
			elementUtil.handlewin1(driver);
			return new CalendarPage(driver);
		}
	
		// -----------To view Calendar-----------//
		public CalendarPage viewCalendar(String SheetName)
				throws InterruptedException, IOException {
			List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {

				String ISOCode = map.get("ISOCode");
				String PaymentType = map.get("PaymentType");
				String Month = map.get("Month");
				String Year = map.get("Year");
				String Status = map.get("Status");
				
				elementUtil.clickElement(currency);
				elementUtil.selectDropDownByVisibleText(currency, ISOCode);
				elementUtil.clickElement(paymentType);
				elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
				elementUtil.clickElement(month);
				elementUtil.selectDropDownByVisibleText(month, Month);
				elementUtil.enterText(year, Year);
				elementUtil.selectDropDownByVisibleText(statusfilter, Status);
				elementUtil.clickElement(collapsemonth);
				elementUtil.clickElement(ResetBtn);
				String a = elementUtil.getText(year);
				if (a.isEmpty()) {
					log.info("Reset Button functionality is working fine");
				} else {
					log.error("Reset Button is not working");
				}
				elementUtil.clickElement(currency);
				elementUtil.selectDropDownByVisibleText(currency, ISOCode);
				elementUtil.clickElement(paymentType);
				elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
				elementUtil.clickElement(month);
				elementUtil.selectDropDownByVisibleText(month, Month);
				elementUtil.enterText(year, Year);
				elementUtil.selectDropDownByVisibleText(statusfilter, Status);
				elementUtil.clickElement(collapsemonth);
				elementUtil.clickElement(okBtn);

				String ExpectedYear = Year;
				String ScreenMsg = "View calendars";
				String CriteriaMsg = "No items available for Calendar view operation";

				try {
					if (elementUtil.getText(errormessages).equals(CriteriaMsg)) {
						log.info("Calendar " + Year + " is not available for View Operation");
					} else {
						log.error(elementUtil.getText(errormessages));
					}
					
				} catch (NoSuchElementException e) {
					if (elementUtil.getText(validationMsg).equals(ScreenMsg)) {
						String ActualCurrency = elementUtil.getText(verifyCurrency);
						String ActualStatus = elementUtil.getText(verifyStatus);
						String ActualYear = elementUtil.getText(verifyYear);
						if (ActualYear.equals(ExpectedYear)) {
							log.info("Calendar " + Year + " with " + ActualCurrency
									+ " Currency is present in Calendar list and in " + ActualStatus + " status");
						} else {
							log.error("Calendar " + Year + " with " + ActualCurrency + " Currency is not present in User list");
						}
					}
				}
					
				elementUtil.clickElement(restartWorkflow);
			}
			logOutOperation();
			return new CalendarPage(driver);
		}
		
		// -------To modify Calendar--------//
		public CalendarPage modifyCalendar(String SheetName)
				throws InterruptedException, IOException {
			List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {
				
			String ISOCode = map.get("ISOCode");
			String PaymentType = map.get("PaymentType");
			String Month = map.get("Month");
			String Year = map.get("Year");
			String DayType = map.get("DayType");

			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(RESETBtn);
			String a = elementUtil.getText(year);
			if (a.isEmpty()) {
				log.info("Reset Button functionality is working fine");
			} else {
				log.error("Reset Button is not working");
			}
			
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(okBtn);
			
			String CriteriaMsg = "No items available for Modify operation given the search criteria";
			String ExpectedCalendarValidationMsg = "Operation Modify/Repair calendar executed successfully. "+Year+"-"+Month+"-"+ISOCode+"-"+PaymentType+" placed in APPROVE queue.";
			try {
				if (errormessages.getText().equals(CriteriaMsg)) {
					log.info("Calendar " + Year + " is not available for Modify Operation");
				}else {
					log.error("Validation message is not proper");
				}
			}catch(NoSuchElementException e) {	
			elementUtil.clickElement(record);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(cancelBtn);
			String ActualCancelBtnMsg = elementUtil.getText(errormessages);
			String ExpectedCancelBtnMsg = "Operation Modify/Repair calendar was cancelled.";
			if (ActualCancelBtnMsg.equals(ExpectedCancelBtnMsg)) {
				log.info("Cancel Button is working fine");
			} else {
				log.error("Cancel button is not working");
			}
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(okBtn);
			elementUtil.clickElement(record);
			elementUtil.clickElement(daytype);
			elementUtil.selectDropDownByVisibleText(daytype, DayType);
			elementUtil.clickElement(OKBtn);
			elementUtil.clickElement(cancelBtn);
			if (ActualCancelBtnMsg.equals(ExpectedCancelBtnMsg)) {
				log.info("Cancel Button from Confirm screen is working fine");
			} else {
				log.error("Cancel button from Confirm screen is not working");
			}
			elementUtil.clickElement(currency);
			elementUtil.selectDropDownByVisibleText(currency, ISOCode);
			elementUtil.clickElement(paymentType);
			elementUtil.selectDropDownByVisibleText(paymentType, PaymentType);
			elementUtil.clickElement(month);
			elementUtil.selectDropDownByVisibleText(month, Month);
			elementUtil.enterText(year, Year);
			elementUtil.clickElement(collapsemonth);
			elementUtil.clickElement(okBtn);
				elementUtil.clickElement(record);
				elementUtil.clickElement(daytype);
				elementUtil.selectDropDownByVisibleText(daytype, DayType);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(OKBtn);
				elementUtil.clickElement(OKBTN);
				elementUtil.SHORT_TIMEOUT();
				if (messages.getText().equals(ExpectedCalendarValidationMsg)) {
					log.info("Calendar " + Year + " Modified successfully and placed in APPROVE queue");
				} else {
					log.error("Validation message is not proper");
				}
			}
			elementUtil.clickElement(restartWorkflow);
			}
			elementUtil.SHORT_TIMEOUT();
			elementUtil.handlewin1(driver);
			return new CalendarPage(driver);
		}
	
		//-----------------Method to perform Logout Operation----------------------------
		public void logOutOperation() throws InterruptedException {
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		}// end of logOutOperation function

}
