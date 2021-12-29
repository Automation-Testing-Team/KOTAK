package COM.KOTAK.QA.PAGES;
//package com.kotak.qa.pages;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.kotak.qa.util.ElementUtil;
//import com.kotak.qa.util.ExcelReader;
//import com.kotak.qa.util.FileReadUtils;
//
//public class SponsorMandatePage {
//
//	private WebDriver driver;
//	ExcelReader excelReader=new ExcelReader();
//	ElementUtil elementUtil;
//	List<Map<String,String>> testData;
//	FileReadUtils fileReader;
//	Logger log = Logger.getLogger(SponsorMandatePage.class);
//	
//	// WebElements
//		@FindBy(name = "corpCustomer")
//		WebElement corporatedropdown;
//		
//		@FindBy(name = "fileUploadType")
//		WebElement fileUploadTypedropdown;
//		
//		@FindBy(name = "fileType")
//		WebElement fileTypedropdown;
//		
//		@FindBy(name = "corpScheme")
//		WebElement schemedropdown;
//		
//		@FindBy(name = "nachCodeType")
//		WebElement nachCodeTypedropdown;
//		
//		@FindBy(name = "nachCode")
//		WebElement nachCodedropdown;
//		
//		@FindBy(name = "gfpCode")
//		WebElement freeFormatCodedropdown;
//		
//		@FindBy(name="file")
//		WebElement chooseFileBtn;
//		
//		@FindBy(xpath="//input[@value='Upload']")
//		WebElement uploadBtn;
//		
//		@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
//		WebElement validationMsg;
//		
//		@FindBy(name = "mbSvcProviderCode")
//		WebElement utilityCode;
//		
//		@FindBy(name = "mbDRAccountNumber")
//		WebElement accountNumber;
//		
//		@FindBy(xpath="//input[@value='OK']")
//		WebElement okButton;
//		
//		@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
//		WebElement mandateId;
//		
//		@FindBy(name="line_check")
//		WebElement checkbox;
//		
//		@FindBy(name="mandateMultiAction")
//		WebElement dropdown;
//		
//		@FindBy(xpath="//*[@id=\"pageBody\"]/form/table[1]/tbody/tr/td[3]")
//		WebElement submitBtn;
//		
//		// WebElements for List Mandate Screen
//		@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[8]")
//		WebElement utilityCodeValue;
//		
//		@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[15]")
//		WebElement accountNumberValue;
//		
//		@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[12]")
//		WebElement achStatusValue;
//		
//	
//	// WebElements for Logout function
//		@FindBy(id="logoutButtonId")
//		WebElement logOutBtn;
//		
//		@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button/img")
//		WebElement logoutBtn;
//	
//	// SponsorMandatePage Class Constructor
//		public SponsorMandatePage(WebDriver driver) {
//			PageFactory.initElements(driver, this);
//			this.driver = driver;
//			this.fileReader = new FileReadUtils(driver);
//			this.elementUtil = new ElementUtil(driver);
//		}
//		
//		//---------To filter--------//
//		public void filterScreen(String SheetName,Integer Row) throws InterruptedException, InvalidFormatException, IOException {
//			testData=fileReader.readTransactionExcel(SheetName);
//			String UtilityCode=testData.get(Row).get("Utility Code");
//			String AccountNumber=testData.get(Row).get("Account Number");
//			
//			elementUtil.enterText(utilityCode, UtilityCode);
//			elementUtil.enterText(accountNumber, AccountNumber);
//			elementUtil.clickElement(okButton);
//			elementUtil.SHORT_TIMEOUT();
//		}
//		
//		//-----------Approve Mandate----------//
//		public void approveMandate(String SheetName,Integer Row) throws InvalidFormatException, IOException, InterruptedException {
//			testData=fileReader.readTransactionExcel(SheetName);
//			String MandateId = mandateId.getText();
//			String Dropdown=testData.get(Row).get("Dropdown");
//			elementUtil.clickElement(checkbox);
//			elementUtil.selectDropDownByVisibleText(dropdown, Dropdown);
//			elementUtil.SHORT_TIMEOUT();
//			elementUtil.clickElement(submitBtn);
//			
//			String ExpectedMsg = "Record "+MandateId+" status changed to NPCI";
//			if(validationMsg.getText().equals(ExpectedMsg)) {
//				log.info(ExpectedMsg);
//			}else {
//				log.info("Validation message is not proper");
//			}
//			
//			elementUtil.handlewin1(driver);
//		}
//		
//		//-----------List Mandate------------//
//		public void listMandate() throws InvalidFormatException, IOException, InterruptedException {
//			String UtilityCodeValue = utilityCodeValue.getText(); 
//			String AccountNumberValue = accountNumberValue.getText();
//			String ACHStatusValue = achStatusValue.getText();
//			
//			log.info(""+UtilityCodeValue+" with "+AccountNumberValue+" is available in list with Status "+ACHStatusValue+"");
//			
//			elementUtil.clickElement(logOutBtn);
//			elementUtil.clickElement(logoutBtn);
//			elementUtil.quitBrowser();
//		}
//
//		//-----------Upload Mandate File----------//
//	public SponsorMandatePage selectvaliddata(String SheetName,Integer Row) throws InterruptedException, InvalidFormatException, IOException {
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
//		return new SponsorMandatePage(driver);
//	}
//	
//}
