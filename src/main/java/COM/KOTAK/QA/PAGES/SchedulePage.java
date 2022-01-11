package COM.KOTAK.QA.PAGES;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
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

public class SchedulePage {
	private WebDriver driver;
	List<Map<String, String>> testData;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(SchedulePage.class);
	
	@FindBy(name="name")
	WebElement schedulerdropdown;
	
	@FindBy(name="enabled")
	WebElement checkbox;
	
	@FindBy(name="content(starts1)")
	WebElement starttime;
	
	@FindBy(name="content(ends1)")
	WebElement endtime;
	
	@FindBy(name="content(frequencyHours1)")
	WebElement frequencyHH;
	
	@FindBy(name="content(frequencyMinutes1)")
	WebElement frequencyMM;
	
	@FindBy(name="content(frequencySeconds1)")
	WebElement frequencySS;
	
	@FindBy(name="content(settlementCycle1)")
	WebElement settlementCycle;
	
	@FindBy(id="remove1")
	WebElement removeBtn;
	
	@FindBy(id="add1")
	WebElement addBtn;
	
	@FindBy(name="submit")
	WebElement submitBtn;
	
	@FindBy(name="org.apache.struts.taglib.html.CANCEL")
	WebElement cancelBtn;
	
	@FindBy(xpath="//input[@value='OK']")
	WebElement okBtn;
	
	@FindBy(xpath="//tr[2]//td[3]")
	WebElement checkstatus;
	
	@FindBy(xpath="//tr[3]//td[3]")
	WebElement checkstatus1;
	
	@FindBy(xpath="//tr[4]//td[3]")
	WebElement checkstatus2;
	
	@FindBy(xpath="//tr[5]//td[3]")
	WebElement checkstatus3;
	
	@FindBy(xpath="//tr[6]//td[3]")
	WebElement checkstatus4;
	
	@FindBy(xpath="//tr[7]//td[3]")
	WebElement checkstatus5;
	
	@FindBy(xpath="//tr[8]//td[3]")
	WebElement checkstatus6;
	
	@FindBy(xpath="//tr[6]//td[3]")
	WebElement checkstatus7;
	
	@FindBy(xpath="//tr[7]//td[3]")
	WebElement checkstatus8;
	
	@FindBy(xpath="//tr[8]//td[3]")
	WebElement checkstatus9;
	
	@FindBy(name="enabled")
	WebElement enabledcheckbox;
	
	@FindBy(xpath="//p[@class='errormessages']")
	WebElement errormessages;
	
	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;
	
	@FindBy(xpath="//p[@class='label']")
	WebElement screenMsg;
	
	@FindBy(xpath="//a[contains(text(),'Restart Workflow')]")
	WebElement restartWorkflow;
	
	@FindBy(name="status")
	WebElement status;
	
	@FindBy(xpath="//table[@id='LNTablelistable']//tbody")
	WebElement schedulertable;
	
	@FindBy(xpath="//td[contains(text(),'AutoMISScheduler')]")
	WebElement AutoMISSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'DebitTransactionAutoGenerationScheduler')]")
	WebElement DebitTransactionAutoGenerationSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'EmailInwardMandateDashboardScheduler')]")
	WebElement EmailInwardMandateDashboardSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'EmailInwardTranDashboardScheduler')]")
	WebElement EmailInwardTranDashboardSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'EmailNachDashboardTechnologyScheduler')]")
	WebElement EmailNachDashboardTechnologySchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'EmailOutwardMandateDashboardScheduler')]")
	WebElement EmailOutwardMandateDashboardSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'MandateInwardAlertScheduler')]")
	WebElement MandateInwardAlertSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'MandateOutwardAlertScheduler')]")
	WebElement MandateOutwardAlertSchedulerserver;
	
	@FindBy(xpath="//td[contains(text(),'MandateReportScheduler')]")
	WebElement MandateReportSchedulerserver;
	
	@FindBy(xpath="//*[@id=\"headerTable\"]/tbody/tr[3]/td[2]/input")
	WebElement serverStatusCheckbox;
	
	@FindBy(xpath="//*[@id=\"headerTable\"]/tbody/tr[2]/td[2]")
	WebElement schedulercontrolStatus;
	
	@FindBy(xpath="//center//td[1]//input[1]")
	WebElement startBtn;
	
	@FindBy(xpath="//td[2]//input[1]")
	WebElement stopBtn;
	
	@FindBy(id="logoutButtonId")
	WebElement logOutBtn;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button/img")
	WebElement logoutBtn;

	// SchedulePage Class Constructor
	public SchedulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}
	
	public SchedulePage addSchedulerwithValidData(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Scheduler = map.get("Scheduler");
			String Checkbox = map.get("Checkbox");
			String StartTime = map.get("StartTime");
			String EndTime = map.get("EndTime");
			String FrequencyHH = map.get("FrequencyHH");
			String FrequencyMM = map.get("FrequencyMM");
			String FrequencySS = map.get("FrequencySS");
			String SettlementCycle = map.get("SettlementCycle");
		
			elementUtil.selectDropDownByVisibleText(schedulerdropdown, Scheduler);
			elementUtil.clickElement(okBtn);
			elementUtil.SHORT_TIMEOUT();
			
			String ValidationMsg = "Operation executed successfully. You can add other scheduler.";
			String ExistingSchedulerMsg="The Scheduler was already added.";
			try {
				if(elementUtil.getText(errormessages).equals(ExistingSchedulerMsg)) {
					log.info("Scheduler "+Scheduler+" is already added");
				}
			} catch (NoSuchElementException e) {
				
			elementUtil.isElementSelected(checkbox, Checkbox);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.sendkeys(starttime, StartTime);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.sendkeys(endtime, EndTime);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(submitBtn);
			elementUtil.clickElement(cancelBtn);
			
			String CancelValidationMsg="Operation was cancelled.";
			if(elementUtil.getText(errormessages).equals(CancelValidationMsg)) {
				log.info("Cancel Button functionality is working fine");
			}
			else {
				log.error("Cancel Button is not working");
			}	
			
		elementUtil.selectDropDownByVisibleText(schedulerdropdown, Scheduler);
		elementUtil.clickElement(okBtn);
		elementUtil.isElementSelected(checkbox, Checkbox);
		elementUtil.sendkeys(starttime, StartTime);
		elementUtil.sendkeys(endtime, EndTime);
		elementUtil.selectDropDownByVisibleText(frequencyHH, FrequencyHH);
		elementUtil.selectDropDownByVisibleText(frequencyMM, FrequencyMM);
		elementUtil.selectDropDownByVisibleText(frequencySS, FrequencySS);
		elementUtil.selectDropDownByVisibleText(settlementCycle, SettlementCycle);
		elementUtil.clickElement(submitBtn);
		elementUtil.clickElement(okBtn);
		
		if(elementUtil.getText(messages).equals(ValidationMsg)) {
			log.info("Scheduler "+Scheduler+" get added successfully");
		}else {
			log.error("Scheduler "+Scheduler+" is failed to add");
			}
		
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new SchedulePage(driver);
	}
		
	public SchedulePage addSchedulerwithInValidData(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Scheduler = map.get("Scheduler");
			String StartTime = map.get("StartTime");
			String EndTime = map.get("EndTime");
			
		elementUtil.selectDropDownByVisibleText(schedulerdropdown, Scheduler);
		elementUtil.clickElement(okBtn);
		
		String ValidationMsg = "Operation executed successfully. You can add other scheduler.";
		String ExistingSchedulerMsg="The Scheduler was already added.";
		String ValidationMsgforStartTime = "Invalid Start Time for interval 1";
		String ValidationMsgforEndTime = "Invalid End Time for interval 1";
		
		try {
			if(elementUtil.getText(errormessages).equals(ExistingSchedulerMsg)) 
			{
				log.info(""+Scheduler+" Scheduler is already present in list");
			}
		}catch(NoSuchElementException e) {
				elementUtil.sendkeys(starttime, StartTime);
				elementUtil.sendkeys(endtime, EndTime);
				elementUtil.clickElement(submitBtn);
				elementUtil.clickElement(okBtn);
				
				try{
					if(elementUtil.getText(errormessages).equals(ValidationMsgforStartTime)) 
					{
					log.info("Start Time validation message is properly displayed for Invalid Start time "+StartTime+" field");
					} else if(elementUtil.getText(errormessages).equals(ValidationMsgforEndTime))
					{
						log.info("End Time validation message is properly displayed for Invalid End time "+EndTime+" field");
					}else if(elementUtil.getText(errormessages).equals(ExistingSchedulerMsg)) 
					{
						log.info(""+Scheduler+" Scheduler is already present in list");
					}
					else{
						log.error("Validation Message is not proper for Invalid data "+Scheduler+"");
					}
				}catch(NoSuchElementException e1) {
						elementUtil.SHORT_TIMEOUT();
						if(elementUtil.getText(messages).equals(ValidationMsg)) {
							log.info(""+Scheduler+" Scheduler get added successfully");
						}else {
							log.error("Scheduler is failed to add");
						}
					}
				}	
		
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new SchedulePage(driver);
	}
	
	public SchedulePage modifyScheduler(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String ScheduleManager = map.get("Schedule Manager");
			String Scheduler = map.get("Scheduler");
			String Checkbox = map.get("Checkbox");
			String StartTime = map.get("StartTime");
			String EndTime = map.get("EndTime");
			String FrequencyHH = map.get("FrequencyHH");
			String FrequencyMM = map.get("FrequencyMM");
			String FrequencySS = map.get("FrequencySS");
			String SettlementCycle = map.get("SettlementCycle");
			
		elementUtil.SelectElementByVisibleText(status, ScheduleManager);
		elementUtil.clickElement(okBtn);
		
		String ErrorMsg = "No items available for List operation given the search criteria";
		try {
			if(elementUtil.getText(errormessages).equals(ErrorMsg)) {
				log.info("Validation message is displayed for Invalid criteria");
			}
		} catch (NoSuchElementException e) {
			switch (Scheduler) {
			case "AutoMISScheduler":
				try {
					if(AutoMISSchedulerserver.isDisplayed()) {	
						if(elementUtil.getText(AutoMISSchedulerserver).equals(Scheduler)) {
							elementUtil.clickElement(AutoMISSchedulerserver);
							elementUtil.SHORT_TIMEOUT();
							modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
						}else {
							log.info("");
						}
					}
					}catch(NoSuchElementException e1) {
						log.error("AutoMISSchedulerserver is not available for modify operation");
					}
				break;
				
			case "DebitTransactionAutoGenerationScheduler":
				try {
					if(DebitTransactionAutoGenerationSchedulerserver.isDisplayed()) {	
						if(elementUtil.getText(DebitTransactionAutoGenerationSchedulerserver).equals(Scheduler)) {
							elementUtil.clickElement(DebitTransactionAutoGenerationSchedulerserver);
							modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
						}else {
							log.info("");
						}
					}
					}catch(NoSuchElementException e1) {
						log.error("DebitTransactionAutoGenerationSchedulerserver is not available for modify operation");
					}
				break;
				
			case "EmailInwardMandateDashboardScheduler":
			try {
				if(EmailInwardMandateDashboardSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(EmailInwardMandateDashboardSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(EmailInwardMandateDashboardSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("EmailInwardMandateDashboardSchedulerserver is not available for modify operation");
				}
			break;
			
			case "EmailInwardTranDashboardScheduler":
			try {
				if(EmailInwardTranDashboardSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(EmailInwardTranDashboardSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(EmailInwardTranDashboardSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("EmailInwardTranDashboardSchedulerserver is not available for modify operation");
				}
			break;
			
			case "EmailNachDashboardTechnologyScheduler":
			try {
				if(EmailNachDashboardTechnologySchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(EmailNachDashboardTechnologySchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(EmailNachDashboardTechnologySchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("EmailNachDashboardTechnologySchedulerserver is not available for modify operation");
				}
			break;
			
			case "EmailOutwardMandateDashboardScheduler":
			try {
				if(EmailOutwardMandateDashboardSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(EmailOutwardMandateDashboardSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(EmailOutwardMandateDashboardSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("EmailOutwardMandateDashboardSchedulerserver is not available for modify operation");
				}
			break;
			
			case "MandateInwardAlertScheduler":
			try {
				if(MandateInwardAlertSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(MandateInwardAlertSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(MandateInwardAlertSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("MandateInwardAlertSchedulerserver is not available for modify operation");
				}
			break;
			
			case "MandateOutwardAlertScheduler":
			try {
				if(MandateOutwardAlertSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(MandateOutwardAlertSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(MandateOutwardAlertSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("MandateOutwardAlertSchedulerserver is not available for modify operation");
				}
			break;
			
			case "MandateReportScheduler":
			try {
				if(MandateReportSchedulerserver.isDisplayed()) {	
					if(elementUtil.getText(MandateReportSchedulerserver).equals(Scheduler)) {
						elementUtil.clickElement(MandateReportSchedulerserver);
						modifyData(Checkbox,StartTime, EndTime, FrequencyHH, FrequencyMM, FrequencySS, SettlementCycle, Scheduler);
					}else {
						log.info("");
					}
				}
				}catch(NoSuchElementException e1) {
					log.error("MandateReportSchedulerserver is not available for modify operation");
				}
			break;
			}
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new SchedulePage(driver);
	}
	
	public SchedulePage modifyData(String Checkbox,String StartTime,String EndTime,String FrequencyHH,String FrequencyMM,String FrequencySS,String SettlementCycle,String Scheduler) throws InterruptedException {
		elementUtil.isElementSelected(checkbox, Checkbox);
		elementUtil.clearText(starttime);
		elementUtil.sendkeys(starttime, StartTime);
		elementUtil.clearText(endtime);
		elementUtil.sendkeys(endtime, EndTime);
		elementUtil.SelectElementByVisibleText(frequencyHH, FrequencyHH);
		elementUtil.SelectElementByVisibleText(frequencyMM, FrequencyMM);
		elementUtil.SelectElementByVisibleText(frequencySS, FrequencySS);
		elementUtil.SelectElementByVisibleText(settlementCycle, SettlementCycle);
		elementUtil.clickElement(submitBtn);
		elementUtil.clickElement(okBtn);
		
		String ValidationMsg = "Operation executed successfully. You can modify other scheduler.";
		if(elementUtil.getText(messages).equals(ValidationMsg)) {
			log.info("Scheduler "+Scheduler+" gets modified successfully");
		}else {
			log.error("Scheduler "+Scheduler+" is unable to modify ");
		}
		return new SchedulePage(driver);
	}
	
	public SchedulePage listSchedulers(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String ScheduleManager = map.get("Schedule Manager");
		
		elementUtil.SelectElementByVisibleText(status, ScheduleManager);	
		elementUtil.clickElement(okBtn);
		String ValidationMsg="No items available for List operation given the search criteria";
		
		try{
			if(elementUtil.getText(errormessages).equals(ValidationMsg)) {
			log.info("No items available for List operation given the search criteria validation message is displayed properly");
		}else {
			log.error("Validation failed for Scheduler list");
			}
		}catch(NoSuchElementException e) {
			
			try {
			if(AutoMISSchedulerserver.isDisplayed()) {				
				if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
					log.info("AutoMISScheduler server is displayed in list with "+ScheduleManager+" status");
				}else {
					log.info("AutoMISScheduler server is displayed in list");
				}
			}
			}catch(NoSuchElementException e1) {
				if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
					log.error("AutoMISSchedulerserver is not displayed in list for "+ScheduleManager+" status");
				}else {
					log.error("AutoMISSchedulerserver is not displayed in list");
				}
			}
			
			try {
				if(DebitTransactionAutoGenerationSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("DebitTransactionAutoGenerationSchedulerserver server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("DebitTransactionAutoGenerationSchedulerserver server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("DebitTransactionAutoGenerationSchedulerserver is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("DebitTransactionAutoGenerationSchedulerserver is not displayed in list");
					}
				}
			
			try {
				if(EmailInwardMandateDashboardSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("EmailInwardMandateDashboardScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("EmailInwardMandateDashboardScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("EmailInwardMandateDashboardScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("EmailInwardMandateDashboardScheduler is not displayed in list");
					}
				}
			
			try {
				if(EmailInwardTranDashboardSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("EmailInwardTranDashboardScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("EmailInwardTranDashboardScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("EmailInwardTranDashboardScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("EmailInwardTranDashboardScheduler is not displayed in list");
					}
				}
			
			try {
				if(EmailNachDashboardTechnologySchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("EmailNachDashboardTechnologyScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("EmailNachDashboardTechnologyScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("EmailNachDashboardTechnologyScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("EmailNachDashboardTechnologyScheduler is not displayed in list");
					}
				}
			
			try {
				if(EmailOutwardMandateDashboardSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("EmailOutwardMandateDashboardScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("EmailOutwardMandateDashboardScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("EmailOutwardMandateDashboardScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("EmailOutwardMandateDashboardScheduler is not displayed in list");
					}
				}
			
			try {
				if(MandateInwardAlertSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("MandateInwardAlertScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("MandateInwardAlertScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("MandateInwardAlertScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("MandateInwardAlertScheduler is not displayed in list");
					}
				}
			
			try {
				if(MandateOutwardAlertSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("MandateOutwardAlertScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("MandateOutwardAlertScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("MandateOutwardAlertScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("MandateOutwardAlertScheduler is not displayed in list");
					}
				}
			
			try {
				if(MandateReportSchedulerserver.isDisplayed()) {				
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")) {	
						log.info("MandateReportScheduler server is displayed in list with "+ScheduleManager+" status");
					}else {
						log.info("MandateReportScheduler server is displayed in list");
					}
				}
				}catch(NoSuchElementException e1) {
					if(ScheduleManager.equals("Enabled") || ScheduleManager.equals("Disabled")){
						log.error("MandateReportScheduler is not displayed in list for "+ScheduleManager+" status");
					}else {
						log.error("MandateReportScheduler is not displayed in list");
					}
				}
		}
			
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new SchedulePage(driver);
	}
	
	public SchedulePage checkSchedulerstatus() throws InterruptedException {
		String statusScheduler = schedulercontrolStatus.getText();
		if (statusScheduler.equals("Shutdown")) {
			startBtn.click();
			checkSchedulerstatus1();
		} else {
			log.info("Scheduler Service is already in Active state");
		}
		logOutOperation();
		return new SchedulePage(driver);
	}

	public void checkSchedulerstatus1() {
		String statusScheduler = schedulercontrolStatus.getText();
		if (statusScheduler.equals("Active")) {
			log.info("Scheduler Service started");
		} else {
			log.error("Scheduler Service is failed to start");
		}
	}
	
	//-----------------Method to perform Logout Operation----------------------------
			public void logOutOperation() throws InterruptedException {
				elementUtil.clickElement(logOutBtn);
				elementUtil.clickElement(logoutBtn);
				elementUtil.quitBrowser();
			}// end of logOutOperation function

}
