package COM.KOTAK.QA.PAGES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.ExcelReader;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class FileManagerPage {
	private WebDriver driver;
	SoftAssert sa = new SoftAssert();
	ExcelReader excelReader=new ExcelReader();
	ElementUtil elementUtil;
	
	// WebElements for File Manager Page
	@FindBy(name = "fileName")
	WebElement fileName;
	
	@FindBy(name = "direction")
	WebElement directiondropdown;
	
	@FindBy(name = "periodDate")
	WebElement entryDatePerioddropdown;
	
	@FindBy(name = "tranCode")
	WebElement tranCodedropdown;
	
	@FindBy(name = "source")
	WebElement fileSourcedropdown;
	
	@FindBy(name = "periodDateSettelment")
	WebElement settelmentDatePerioddropdown;
	
	@FindBy(name = "userNumber")
	WebElement userNumberfield;
	
	@FindBy(name = "sponsorBank")
	WebElement sponsorBankfield;
	
	@FindBy(name = "destinationBank")
	WebElement destinationBankfield;
	
	@FindBy(name = "fileType")
	WebElement fileTypedropdown;
	
	@FindBy(name = "businessOperation")
	WebElement businessOperationdropdown;
	
	@FindBy(name = "status")
	WebElement statusdropdown;
	
	@FindBy(xpath="//input[@value='OK']")
	WebElement okButton;
	
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[13]")
	WebElement fileStatus;
	
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement fileRecord;
	
	@FindBy(name="direction")
	WebElement directionField;
	
	@FindBy(name="currency")
	WebElement currencyField;
	
    // WebElements for Logout function
	@FindBy(id="logoutButtonId")
	WebElement logOutBtn;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button/img")
	WebElement logoutBtn;
	
	// FileManagerPage Class Constructor
	public FileManagerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}
	
	//--------To filter Screen---------//
	public void filterScreen(String SheetName,Integer Row) throws InvalidFormatException, InterruptedException, IOException {
		List<Map<String,String>> testData=excelReader.getData("E:\\workspace\\DEFAULT_WORKSPACE\\kotak_nach\\src\\test\\resources\\Config\\Transaction.xlsx", SheetName);
		String FileName=testData.get(Row).get("FileName");
		String Direction=testData.get(Row).get("Direction");
		String EntryDatePeriod=testData.get(Row).get("EntryDatePeriod");
		String TranCd=testData.get(Row).get("TranCd");
		String FileSource=testData.get(Row).get("FileSource");
		String SettelmentDatePeriod=testData.get(Row).get("SettelmentDatePeriod");
		String UserNumber=testData.get(Row).get("UserNumber");
		String SponsorBank=testData.get(Row).get("SponsorBank");
		String DestinationBank=testData.get(Row).get("DestinationBank");
		String FileType=testData.get(Row).get("FileType");
		String BusinessOperation=testData.get(Row).get("BusinessOperation");
		String Status=testData.get(Row).get("Status");
		
		elementUtil.enterText(fileName, FileName);
		elementUtil.selectDropDownByVisibleText(directiondropdown, Direction);
		elementUtil.selectDropDownByVisibleText(entryDatePerioddropdown, EntryDatePeriod);
		elementUtil.selectDropDownByVisibleText(tranCodedropdown, TranCd);
		elementUtil.selectDropDownByVisibleText(fileSourcedropdown, FileSource);
		elementUtil.selectDropDownByVisibleText(settelmentDatePerioddropdown, SettelmentDatePeriod);
		elementUtil.enterText(userNumberfield, UserNumber);
		elementUtil.enterText(sponsorBankfield, SponsorBank);
		elementUtil.enterText(destinationBankfield, DestinationBank);
		elementUtil.selectDropDownByVisibleText(fileTypedropdown, FileType);
		elementUtil.selectDropDownByVisibleText(businessOperationdropdown, BusinessOperation);
		elementUtil.selectDropDownByVisibleText(statusdropdown, Status);
		elementUtil.clickElement(okButton);
		elementUtil.SHORT_TIMEOUT();
	}
	
	//----------To check File status----------//
	public FileManagerPage checkFileStatus() throws InterruptedException {
		String ActualValue=elementUtil.getText(fileStatus);
//		String ExpectedValue="ReadyForFilling";
		System.out.println("File Status is : " +ActualValue);
//		sa.assertEquals(ActualValue, ExpectedValue ,"File Status has been Checked");
//		sa.assertAll();
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
		return new FileManagerPage(driver);
	}
	
	//--------Click on Record----------//
	public FileManagerPage clickonRecord() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(fileRecord);
		return new FileManagerPage(driver);
	}
	
	//---------Store data in Excel Sheet----------//
	public FileManagerPage writeinExcelSheet() throws IOException {
		File file = new File("E:\\workspace\\DEFAULT_WORKSPACE\\Kotak_Automation\\src\\main\\java\\com\\kotak\\qa\\config\\output.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Transaction");
		sh.createRow(0).createCell(0).setCellValue("Direction");
		sh.createRow(0).createCell(1).setCellValue("Currency");
		sh.createRow(0).createCell(2).setCellValue("Sponsor Bank");
		sh.createRow(0).createCell(3).setCellValue("Destination Bank");
		sh.createRow(1).createCell(0).setCellValue(elementUtil.getAttribute(directionField));
		sh.createRow(1).createCell(1).setCellValue(elementUtil.getAttribute(currencyField));
		sh.createRow(1).createCell(2).setCellValue(elementUtil.getAttribute(sponsorBankfield));
		sh.createRow(1).createCell(3).setCellValue(elementUtil.getAttribute(destinationBankfield));
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FileManagerPage(driver);

	}
	
	//-----------Validating file by comparing actual data with excel sheet data-----------//
	public FileManagerPage validateFile(String SheetName1,Integer Row1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=excelReader.getData("E:\\workspace\\DEFAULT_WORKSPACE\\Kotak_Automation\\src\\main\\java\\com\\kotak\\qa\\config\\Transaction.xlsx", SheetName1);
		
		String Direction_ExpectedValue=testData.get(Row1).get("Direction");
		String Currency_ExpectedValue=testData.get(Row1).get("Currency");
		String SponsorBank_ExpectedValue=testData.get(Row1).get("Sponsor Bank");
		String DestinationBank_ExpectedValue=testData.get(Row1).get("Destination Bank");
		System.out.println("values:" +Direction_ExpectedValue+ " " +Currency_ExpectedValue+ "" +SponsorBank_ExpectedValue+ " " +DestinationBank_ExpectedValue);
		
		String Direction_ActualValue=elementUtil.getAttribute(directionField);
		System.out.println(Direction_ActualValue);
		String Currency_ActualValue=elementUtil.getAttribute(currencyField);
		System.out.println(Currency_ActualValue);
		String SponsorBank_ActualValue=elementUtil.getAttribute(sponsorBankfield);
		System.out.println(SponsorBank_ActualValue);
		String DestinationBank_ActualValue=elementUtil.getAttribute(destinationBankfield);
		System.out.println(DestinationBank_ActualValue);
		
		sa.assertEquals(Direction_ActualValue, Direction_ExpectedValue, "Direction Field Validation");
		sa.assertEquals(Currency_ActualValue, Currency_ExpectedValue, "Currency Field Validation");
		sa.assertEquals(SponsorBank_ActualValue, SponsorBank_ExpectedValue, "Sponsor Bank Field Validation");
		sa.assertEquals(DestinationBank_ActualValue, DestinationBank_ExpectedValue, "Destination Bank Field Validation");
		sa.assertAll();
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		return new FileManagerPage(driver);
	}
	
	
	
}
