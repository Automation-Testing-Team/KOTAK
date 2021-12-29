package COM.KOTAK.QA.PAGES;
//package com.kotak.qa.pages;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import com.kotak.qa.util.ElementUtil;
//import com.kotak.qa.util.ExcelReader;
//import com.kotak.qa.util.FileReadUtils;
//import com.kotak.qa.util.ValidationMessages;
//
///**
//* @Author -- Suvarna Prabhumatkari
//**/
//
//public class SponsorModulePage {
//	private WebDriver driver;
//	ExcelReader excelReader=new ExcelReader();
//	ElementUtil elementUtil;
//	List<Map<String,String>> testData;
//	FileReadUtils fileReader;
//	Logger log = Logger.getLogger(SponsorModulePage.class);
//	
//	// WebElements
//	@FindBy(name = "corpCustomer")
//	WebElement corporatedropdown;
//	
//	@FindBy(name = "fileUploadType")
//	WebElement fileUploadTypedropdown;
//	
//	@FindBy(name = "fileType")
//	WebElement fileTypedropdown;
//	
//	@FindBy(name = "corpScheme")
//	WebElement schemedropdown;
//	
//	@FindBy(name = "nachCodeType")
//	WebElement nachCodeTypedropdown;
//	
//	@FindBy(name = "nachCode")
//	WebElement nachCodedropdown;
//	
//	@FindBy(name = "gfpCode")
//	WebElement freeFormatCodedropdown;
//	
//	@FindBy(name="file")
//	WebElement chooseFileBtn;
//	
//	@FindBy(xpath="//input[@value='Upload']")
//	WebElement uploadBtn;
//	
//	@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
//	WebElement validationMsg;
//	
//	@FindBy(name = "fileName")
//	WebElement fileName;
//	
//	@FindBy(name = "direction")
//	WebElement directiondropdown;
//	
//	@FindBy(name = "startDate")
//	WebElement entryDateFromField;
//	
//	@FindBy(name = "endDate")
//	WebElement entryDateToField;
//	
//	@FindBy(name = "tranCode")
//	WebElement tranCodedropdown;
//	
//	@FindBy(name = "source")
//	WebElement fileSourcedropdown;
//	
//	@FindBy(name = "startDateSettelment")
//	WebElement settelmentDateFromField;
//	
//	@FindBy(name = "endDateSettelment")
//	WebElement settelmentDateToField;
//	
//	@FindBy(name = "userNumber")
//	WebElement userNumberfield;
//	
//	@FindBy(name = "sponsorBank")
//	WebElement sponsorBankfield;
//	
//	@FindBy(name = "destinationBank")
//	WebElement destinationBankfield;
//	
//	@FindBy(name = "businessOperation")
//	WebElement businessOperationdropdown;
//	
//	@FindBy(name = "status")
//	WebElement statusdropdown;
//	
//	@FindBy(xpath="//input[@value='OK']")
//	WebElement okButton;
//	
//	@FindBy(name="line_check")
//	WebElement checkbox;
//	
//	@FindBy(name="performAction")
//	WebElement dropdown;
//	
//	@FindBy(xpath="//input[@value='Submit for Selected Items']")
//	WebElement submitBtn;
//	
//	// WebElements for Logout function
//	@FindBy(id="logoutButtonId")
//	WebElement logOutBtn;
//	
//	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button/img")
//	WebElement logoutBtn;
//	
//	// SponsorModulePage Class Constructor
//	public SponsorModulePage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//		this.driver = driver;
//		this.fileReader = new FileReadUtils(driver);
//		this.elementUtil = new ElementUtil(driver);
//	}
//	
//	//---------To filter--------//
//	public void filterScreen(String SheetName,Integer Row) throws InterruptedException, InvalidFormatException, IOException {
//		testData=fileReader.readTransactionExcel(SheetName);
//		String FileName=testData.get(Row).get("FileName");
//		String Direction=testData.get(Row).get("Direction");
//		String EntryDateFrom=testData.get(Row).get("EntryDateFrom");
//		String EntryDateTo=testData.get(Row).get("EntryDateTo");
//		String TranCd=testData.get(Row).get("TranCd");
//		String FileSource=testData.get(Row).get("FileSource");
//		String SettelmentDateFrom=testData.get(Row).get("SettelmentDateFrom");
//		String SettelmentDateTo=testData.get(Row).get("SettelmentDateTo");
//		String UserNumber=testData.get(Row).get("UserNumber");
//		String SponsorBank=testData.get(Row).get("SponsorBank");
//		String DestinationBank=testData.get(Row).get("DestinationBank");
//		String FileType=testData.get(Row).get("FileType");
//		String BusinessOperation=testData.get(Row).get("BusinessOperation");
//		String Status=testData.get(Row).get("Status");
//		
//		elementUtil.enterText(fileName, FileName);
//		elementUtil.selectDropDownByVisibleText(directiondropdown, Direction);
//		elementUtil.enterText(entryDateFromField, EntryDateFrom);
//		elementUtil.enterText(entryDateToField, EntryDateTo);
//		elementUtil.selectDropDownByVisibleText(tranCodedropdown, TranCd);
//		elementUtil.selectDropDownByVisibleText(fileSourcedropdown, FileSource);
//		elementUtil.enterText(settelmentDateFromField, SettelmentDateFrom);
//		elementUtil.enterText(settelmentDateToField, SettelmentDateTo);
//		elementUtil.enterText(userNumberfield, UserNumber);
//		elementUtil.enterText(sponsorBankfield, SponsorBank);
//		elementUtil.enterText(destinationBankfield, DestinationBank);
//		elementUtil.selectDropDownByVisibleText(fileTypedropdown, FileType);
//		elementUtil.selectDropDownByVisibleText(businessOperationdropdown, BusinessOperation);
//		elementUtil.selectDropDownByVisibleText(statusdropdown, Status);
//		elementUtil.clickElement(okButton);
//		elementUtil.SHORT_TIMEOUT();
//	}
//	
//	public SponsorModulePage selectvaliddata(String SheetName,Integer Row) throws InterruptedException, InvalidFormatException, IOException {
//		testData=fileReader.readTransactionExcel(SheetName);
//		String Corporate=testData.get(Row).get("Corporate");
//		String FileUploadType=testData.get(Row).get("FileUploadType");
//		String FileType=testData.get(Row).get("FileType");
//		String Scheme=testData.get(Row).get("Scheme");
//		String NACHCodeType=testData.get(Row).get("NACHCodeType");
//		String NACHCode=testData.get(Row).get("NACHCode");
//		String FreeFormatCode=testData.get(Row).get("FreeFormatCode");
//		String File=testData.get(Row).get("File");
//		
//		elementUtil.SHORT_TIMEOUT();
//		elementUtil.clickElement(corporatedropdown);
//		elementUtil.selectDropDownByVisibleText(corporatedropdown, Corporate);
//		elementUtil.clickElement(fileUploadTypedropdown);
//		elementUtil.selectDropDownByVisibleText(fileUploadTypedropdown, FileUploadType);
//		elementUtil.clickElement(fileTypedropdown);
//		elementUtil.selectDropDownByVisibleText(fileTypedropdown, FileType);
//		elementUtil.clickElement(schemedropdown);
//		elementUtil.selectDropDownByVisibleText(schemedropdown, Scheme);
//		elementUtil.clickElement(nachCodeTypedropdown);
//		elementUtil.selectDropDownByVisibleText(nachCodeTypedropdown, NACHCodeType);
//		elementUtil.clickElement(nachCodedropdown);
//		elementUtil.selectDropDownByVisibleText(nachCodedropdown, NACHCode);
//		elementUtil.clickElement(freeFormatCodedropdown);
//		elementUtil.selectDropDownByVisibleText(freeFormatCodedropdown, FreeFormatCode);
//		elementUtil.enterText(chooseFileBtn, File);
//		elementUtil.clickElement(uploadBtn);
//		
//		elementUtil.TIMEOUT();
//		String ValidationMsg = "Initial Load Started";
//		String DuplicateFileMsg = "Duplicate file uploaded.";
//		
//		if(validationMsg.getText().equals(DuplicateFileMsg)) {
//			log.info("Validation message is displayed properly for uploading Duplicate file");
//		}else if(validationMsg.getText().equals(ValidationMsg)) {
//			log.info("File Uploaded Successfully");
//		}else {
//			log.error("Validation is not proper for uploading File");
//		}
//		
//		elementUtil.clickElement(logOutBtn);
//		elementUtil.clickElement(logoutBtn);
//		elementUtil.quitBrowser();
//		return new SponsorModulePage(driver);
//	}
//	
//	//------To create ACH File--------//
//	public void createACHFile(String SheetName,Integer Row) throws InterruptedException, InvalidFormatException, IOException {
//		testData=fileReader.readTransactionExcel(SheetName);
//		String Dropdown=testData.get(Row).get("Dropdown");
//		elementUtil.clickElement(checkbox);
//		elementUtil.selectDropDownByVisibleText(dropdown, Dropdown);
//		elementUtil.SHORT_TIMEOUT();
//		elementUtil.clickElement(submitBtn);
//		elementUtil.clickElement(logOutBtn);
//		elementUtil.clickElement(logoutBtn);
//		elementUtil.quitBrowser();
//	}
//	
//	//---------To Approve Possible Reject----------//
//	public void approvePossibleReject(String SheetName,Integer Row) throws InvalidFormatException, IOException, InterruptedException {
//		testData=fileReader.readTransactionExcel(SheetName);
//		String Dropdown=testData.get(Row).get("Dropdown");
//		elementUtil.clickElement(checkbox);
//		elementUtil.selectDropDownByVisibleText(dropdown, Dropdown);
//		elementUtil.SHORT_TIMEOUT();
//		elementUtil.clickElement(submitBtn);
//		elementUtil.clickElement(logOutBtn);
//		elementUtil.clickElement(logoutBtn);
//		elementUtil.quitBrowser();
//	}
//	
//}
