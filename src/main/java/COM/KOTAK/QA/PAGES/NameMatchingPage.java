package COM.KOTAK.QA.PAGES;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.serviceworker.model.ServiceWorkerErrorMessage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.FileReadUtils;
import COM.KOTAK.QA.UTIL.ValidationMessages;

public class NameMatchingPage {

	private WebDriver driver;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	HomePage homePage;
	List<Map<String, String>> testData;

	//----------WebElements for Name Matching-------------------//
	@FindBy(name = "productType")
	WebElement productType;
	
	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;
	
	@FindBy(xpath = "//p[@class='label']")
	WebElement validateFilterMsg;
	
	@FindBy(xpath = "//tr[@class='rowcoloreven']")
	WebElement screenRecord;
	
	@FindBy(name = "amountAbove")
	WebElement amountAbove;
	
	@FindBy(name = "percentage")
	WebElement percentage;
	
	@FindBy(name = "cancel")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;
	
	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;
	
	@FindBy(id = "LNTablelistable")
	WebElement tableList;
	
	@FindBy(xpath = "//a[contains(text(),'Restart Workflow')]")
	WebElement restartWorkflow;
	
	
	//----------WebElements for Logout Operation-------------------//
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;
	
	
	// ---Constructor to initialize the webelement-----------//
	public NameMatchingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader = new FileReadUtils(driver);
		this.elementUtil = new ElementUtil(driver);
		this.homePage = new HomePage(driver);
	}// end of constructor

	// -------------------------Name Matching Menu
	// Methods----------------------------------------------------//

	// ----------Method to List Name Matching Record---------------------------//
	public void listNameMatchingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String ProductType = map.get("Product Type");

			// enter details on filter screen
			elementUtil.enterText(productType, ProductType);

			// click on ok button
			elementUtil.clickElement(okBtn);

			String ValidateFilterMsg = "No items available for List operation given the search criteria";
			
			if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
					System.out.println("No Records available for List operation Validation Message Displayed Is Correct for Product Type "+ProductType+"");
					System.out.println("Name Matching Record "+ProductType+" is not Displayed in List");
			} else {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(screenRecord);
				elementUtil.SHORT_TIMEOUT();
				
				String AmountAbove = elementUtil.getAttribute(amountAbove);
				String Percentage = elementUtil.getAttribute(percentage);
				
				if (elementUtil.getAttribute(productType).equals(ProductType)) {
					System.out.println("Name Matching Record "+ProductType+" is Displayed in List with Amount "+AmountAbove+" and Percentage "+Percentage);
				}else {
					System.out.println("Name Matching Record "+ProductType+" is not Displayed in List");
				}
			}
			elementUtil.clickElement(restartWorkflow);
		// perform logout operation
		}
		elementUtil.SHORT_TIMEOUT();
		logOutOperation();
	}// end of listDuplicateCheckRecord function
	
	// ----------Method to Delete Name Matching Record---------------------------//
		public void deleteNameMatchingRecord(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {

			// fetch details
			testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {
				String ProductType = map.get("Product Type");

				try {
					if(elementUtil.getAttribute(tableList).contains(ProductType)) {
						productType.getAttribute(ProductType);
						
					}
					
					
				}
				

				String ValidateFilterMsg = "No items available for List operation given the search criteria";
				
				if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
						System.out.println("No Records available for List operation Validation Message Displayed Is Correct for Product Type "+ProductType+"");
						System.out.println("Name Matching Record "+ProductType+" is not Displayed in List");
				} else {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(screenRecord);
					elementUtil.SHORT_TIMEOUT();
					
					String AmountAbove = elementUtil.getAttribute(amountAbove);
					String Percentage = elementUtil.getAttribute(percentage);
					
					if (elementUtil.getAttribute(productType).equals(ProductType)) {
						System.out.println("Name Matching Record "+ProductType+" is Displayed in List with Amount "+AmountAbove+" and Percentage "+Percentage);
					}else {
						System.out.println("Name Matching Record "+ProductType+" is not Displayed in List");
					}
				}
				elementUtil.clickElement(restartWorkflow);
			// perform logout operation
			}
			elementUtil.SHORT_TIMEOUT();
			logOutOperation();
		}// end of deleteDuplicateCheckRecord function
	
	// ----------Method to Add Name Matching Record---------------------------//
		public void addNameMatchingRecord(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {

			// fetch details
			testData = fileReader.readSetupExcel(SheetName);
			for (Map<String, String> map : testData) {
				String PRODUCTType = map.get("Product Type(Filter)");
				String ProductType = map.get("Product Type");
				String AmountAbove = map.get("Amount Above(in paise)");
				String Percentage = map.get("Percentage");

				// enter details on filter screen
				elementUtil.sendkeys(productType, PRODUCTType);
				// click on ok button
				elementUtil.clickElement(okBtn);
				
				String ExistingRecordMsg = "Namne match critera for Productype Test already present";
				try {
				if(elementUtil.getText(errormessages).equals(ExistingRecordMsg)) {
					System.out.println("Name Matching record with Product Type "+PRODUCTType+" is already present");
				}
				}catch (NoSuchElementException e) {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(cancelBtn);
				
				String ValidateFilterMsg = "Name Matching Filter";
				if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
						System.out.println("Cancel Button is working fine");
				} else {
					System.out.println("Cancel button is not working fine");
				}
				
					elementUtil.clearText(productType);
					elementUtil.sendkeys(productType, PRODUCTType);
					elementUtil.clickElement(okBtn);
					elementUtil.clearText(productType);
					elementUtil.sendkeys(productType, ProductType);
					elementUtil.clearText(amountAbove);
					elementUtil.sendkeys(amountAbove, AmountAbove);
					elementUtil.clearText(percentage);
					elementUtil.sendkeys(percentage, Percentage);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);
					
					String AmountfieldValidationMsg = "Amount above limit can't blank.";
					String PercentagefieldValidationMsg = "Percentage can't blank.";
					String ProductTypeValidationMsg = "Product type can't blank.";
					String ErrorMsg = "Amount above limit can't blank.\r\n"
							+ "Percentage can't blank.";
					String ErrorMsg1 = "Product type can't blank.\r\n"
							+ "Amount above limit can't blank.\r\n"
							+ "Percentage can't blank.";
					String ValidationMsg = "Added Successfully.";
					
					try {
						if(elementUtil.getText(errormessages).equals(ProductTypeValidationMsg)) {
							System.out.println("Validation message for Blank Product Type is displayed properly");
//						}else if(elementUtil.getText(errormessages).contains(ErrorMsg1)) {
//							System.out.println("Validation message for Invalid fields is displayed properly");
						}else if(elementUtil.getText(errormessages).equals(AmountfieldValidationMsg)) {
							System.out.println("Validation message for Invalid Amount field is displayed properly");
						}else if(elementUtil.getText(errormessages).equals(PercentagefieldValidationMsg)){
							System.out.println("Validation message for Invalid Percentage field is displayed properly");
//						}else if(elementUtil.getText(errormessages).contains(ErrorMsg)){
//							System.out.println("Validation message is displayed properly for Invalid fields");
						}
					} catch (NoSuchElementException e1) {
						if(elementUtil.getText(messages).equals(ValidationMsg)) {
							System.out.println("Name Matching record with Product Type "+ProductType+" gets added successfully");
						}else {
							System.out.println("Name Matching record with Product Type "+ProductType+" gets failed to add");
						}
					}
				}
					elementUtil.clickElement(restartWorkflow);
				}
			// perform logout operation
			elementUtil.SHORT_TIMEOUT();
			logOutOperation();
		}// end of addDuplicateCheckRecord function

	
	// -----------------Method to perform Logout
		// Operation----------------------------
		public void logOutOperation() throws InterruptedException {
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		}// end of logOutOperation function

}// end of main class NameMatchingPage
