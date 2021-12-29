package COM.KOTAK.QA.PAGES;

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.FileReadUtils;
import COM.KOTAK.QA.UTIL.ValidationMessages;

/**
 * @Author -- Pranjal Mudhalwadkar
 **/

public class CorporatePage {

	private WebDriver driver;
	ElementUtil elementutil;
	FileReadUtils fileReader;
	ValidationMessages errorMessageChecker;
	List<Map<String, String>> test_Data;
	HomePage homePage;
	Logger log = Logger.getLogger(CorporatePage.class);

	// --- WebElements of Corporate CMS and Submenus Xpath-----------------

	@FindBy(name = "businessGroupName")
	WebElement groupNameTextField;

	@FindBy(xpath = "//input[@name='name']")
	WebElement groupNameFilterScreenTxtField;

	@FindBy(name = "businessGroupDesc")
	WebElement groupDescriptionTextField;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	WebElement businessGroupOkBtn;

	@FindBy(id = "btnAddConf")
	WebElement btnAddConfirm;

	@FindBy(name = "back")
	WebElement btnBack;

	// After clicking back button error msg xpath
	@FindBy(xpath = "//p[contains(.,'User Pressed Back Key')]")
	WebElement backErrorMsgText;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement okErrorMsgText;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement btnReset;

	// logout btn
	@FindBy(xpath = "//*[@id=\"logoutButtonId\"]")
	WebElement btnLogout;

	// External logout btn
	@FindBy(name = "logoutBtn1")
	WebElement extBtnLogout;

	// ---Business Group Approve Menu Xpath-------

	@FindBy(id = "btnApprove")
	WebElement btnApprove;

	@FindBy(name = "cancel")
	WebElement btnCancel;

	@FindBy(name = "cancelModify")
	WebElement btnCancelModify;

	// ---------Business Group Modify Menu Xpath----------------
	@FindBy(xpath = "//td[normalize-space()='2']")
	WebElement recordRow;

	@FindBy(xpath = "//td[normalize-space()='1']")
	WebElement recordRow1;

	@FindBy(id = "btnModifyConf")
	WebElement btnModifyConfirm;

	@FindBy(xpath = "//p[@class='label']")
	WebElement ScreenTextValue;

	// ----- Business Group Delete Menu Xpath-------------------

	@FindBy(id = "btnDelete")
	WebElement btnDelete;

	// ----Delete Confirm Menu Xpath---------------------------
	@FindBy(id = "btnDeleteConf")
	WebElement btnDeleteConfirm;

	@FindBy(name = "cancelDelete")
	WebElement btnCancelDelete;

	// ---------Business Group List Menu----------------
	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")
	WebElement listScreenGroupName;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]")
	WebElement listScreenGroupDesc;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]")
	WebElement listScreenStatus;

	// -------Industry Type Xpath Menu-------------------------
	@FindBy(name = "industryTypeCode")
	WebElement industryTypeCodeTextField;

	@FindBy(name = "industryTypeDesc")
	WebElement industryTypeDescTextField;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	WebElement industryBtnOk;

	@FindBy(xpath = "//p[contains(.,'Operation Cancelled')]")
	WebElement cancelBtnText;

	@FindBy(name = "industryTypeCode")
	WebElement industryTypeFilterScreenTxtField;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")
	WebElement listScreenIndustryTypeCode;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]")
	WebElement listScreenIndustryTypeDesc;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]")
	WebElement industryTypeListScreenStatus;

	@FindBy(xpath = "//button[@accesskey='N']")
	WebElement listScreenNextBtn;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement industryTypeScreenRecord;

	// --------Miscellaneous Menu Xpath-------------------------
	@FindBy(name = "name")
	WebElement templateCodeTextField;

	@FindBy(name = "achCrSendAccounting")
	WebElement achCrSendAccountingDropDown;

	@FindBy(name = "achCrSendReturnAccounting")
	WebElement achCrSendReturnAccountingDropDown;

	@FindBy(name = "achDrSendReturnAccounting")
	WebElement achDrSendReturnAccountingDropDown;

	@FindBy(name = "ecsCrSendAccounting")
	WebElement ecsCrSendAccountingDropDown;

	@FindBy(name = "ecsCrSendReturnAccounting")
	WebElement ecsCrSendReturnAccountingDropDown;

	@FindBy(name = "ecsDrSendReturnAccounting")
	WebElement ecsDrSendReturnAccountingDropDown;

	@FindBy(name = "apbsCrSendAccounting")
	WebElement apbsCrSendAccountingDropDown;

	@FindBy(name = "apbsCrSendReturnAccounting")
	WebElement apbsCrSendReturnAccountingDropDown;

	@FindBy(name = "achCrFileSplitPriority")
	WebElement achCreditFileDropDown;

	@FindBy(name = "achCrAutoSettlementDate")
	WebElement achCrAutoSettlementDateDropDown;

	@FindBy(name = "achDrFileSplitPriority")
	WebElement achDebitFileDropDown;

	@FindBy(name = "ecsCrFileSplitPriority")
	WebElement ecsCreditFileDropDown;

	@FindBy(name = "ecsCrAutoSettlementDate")
	WebElement ecsCreditAutoSettlementDateDropDown;

	@FindBy(name = "ecsDrFileSplitPriority")
	WebElement ecsDebitFileDropDown;

	@FindBy(name = "apbsCrFileSplitPriority")
	WebElement apbsCreditFileDropDown;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement miscellaneousBtnOk;

	@FindBy(id = "btnAddConf")
	WebElement miscellaneousBtnConfirm;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	WebElement approveMiscellaneousBtnOk;

	@FindBy(name = "cancel")
	WebElement miscellaneousCancelBtn;

	@FindBy(id = "btnApprove")
	WebElement miscellaneousBtnApprove;

	@FindBy(name = "cancelModify")
	WebElement miscellaneousCancelModifyBtn;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement miscellaneousConfirmDeleteScreen_Rec;

	// for rowcolor=even
	@FindBy(xpath = "//tr[@class='rowcoloreven']")
	WebElement screenRecord;

	// for rowcolor=odd
	@FindBy(xpath = "//tr[@class='rowcolorodd']")
	WebElement screen_Record;

	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	WebElement miscellaneouslistScreenTemplateCode;

	@FindBy(xpath = "//tbody/tr[40]/td[2]")
	WebElement miscellaenousListScreenStatus;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath = "//a[contains(text(),'Restart Workflow')]")
	WebElement restartWorkflow;

	@FindBy(name = "name")
	WebElement partyNameTxtBox;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement AllFilterScreenOKBtn;

	@FindBy(xpath = "//td[contains(text(),'Screen:')]")
	WebElement screenName;

	@FindBy(name = "isMMSSpecialCustomer")
	WebElement MMSSpecialCustomerDropDown;

	@FindBy(name = "mandatedestination")
	WebElement mandateDestinationDropDown;

	@FindBy(name = "autoDebitTransactionEnabled")
	WebElement debitTransactionAutoRepresentationDropDown;

	@FindBy(name = "isReportGenReq")
	WebElement reportGenerationRequiredDropDown;

	@FindBy(name = "utilCustCycleDates")
	WebElement mmsCustCycleDateTxtBox;

	@FindBy(name = "isEndOfMonthCycleDate")
	WebElement cycleDateISEOMDropDown;

	@FindBy(name = "postponeCycledate")
	WebElement postponeCycleDateDropDown;

	@FindBy(name = "noOfDaysForAutoDebitTran")
	WebElement noofDaysForDebitTranTxtBox;

	@FindBy(name = "noOfDaysForNotification")
	WebElement noOfDaysForReport;

	@FindBy(name = "noOfDaysForPosting")
	WebElement noOfDaysForPostingTxtBox;

	@FindBy(name = "isH2HUser")
	WebElement isH2HUserDropDown;

	@FindBy(name = "autoMIS")
	WebElement enableAutomMISDropDown;

	@FindBy(name = "autoMISFor")
	WebElement selectAtuoMISForDropDown;

	@FindBy(name = "mandateDays")
	WebElement frequencyforMandateMISInDaysTxtBox;

	@FindBy(name = "transactionDays")
	WebElement frequencyforTransactionMISInDaysTxtBox;

	@FindBy(name = "misTypeTransaction")
	WebElement misTypeTransactionDropDown;

	@FindBy(name = "misTypeMandate")
	WebElement misTypeMandateDropDown;

	@FindBy(name = "misStatusTransaction")
	WebElement misStatusForTransaction;

	@FindBy(name = "misStatusMandate")
	WebElement misStatusforMandate;

	@FindBy(name = "cancelModify")
	WebElement cancelModifyActionBtn;

	@FindBy(xpath = "//input[@name='name']")
	WebElement miscellaneousScreenTemplateCodeValue;

	// WebElements for Miscellaneous->Delete,Miscellaneous->Confirm Delete Screen
	@FindBy(xpath = "//input[@id='btnDelete']")
	WebElement deleteScreenConfirmBtn;

	@FindBy(xpath = "//input[@id='btnDeleteConf']")
	WebElement confirmDeleteScreenDeleteConfirmBtn;

	@FindBy(name = "cancelDelete")
	WebElement cancelDeleteActionBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p")
	WebElement miscellaneousScreenLabels;

	// WebElements for Miscellaneous->Modify Screen
	@FindBy(xpath = "//input[@id='btnModifyConf']")
	WebElement modifyScreenModifyConfirmBtn;

	@FindBy(name = "acronym")
	WebElement acronymfieldTxtBox;

	// WebElements for Relationship Manager Menus
	@FindBy(name = "rmCode")
	WebElement rmCodeTxtField;

	@FindBy(name = "name")
	WebElement relationshipManagerNameTxtField;

	@FindBy(name = "emailId")
	WebElement emailIdTxtField;

	@FindBy(name = "phoneNo")
	WebElement phoneNoTxtField;

	@FindBy(name = "remarks")
	WebElement remarksTxtField;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(id = "btnAddConf")
	WebElement addConfirmBtn;

	@FindBy(xpath = "//tbody/tr[8]/td[2]")
	WebElement recordStatus;

	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	WebElement actualScreenRecordValue;

	@FindBy(xpath = "//tbody/tr[8]/td[2]")
	WebElement rmRecordstatus;

	@FindBy(xpath = "//input[@name='rmCode']")
	WebElement rmCodeValueApproveScreen;

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameFieldValueApproveScreen;

	@FindBy(xpath = "//body[1]/div[4]/center[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")
	WebElement rmlistScreenRMCodeRecordValue;

	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	WebElement rmlistScreenNameValue;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement rmScreenRecord_Path;

	// ------SCHEME MENU WEBELEMENTS-----------
	@FindBy(name = "schemecode")
	WebElement schemeCode;

	@FindBy(name = "schemedesc")
	WebElement description;

	@FindBy(name = "customerCode")
	WebElement corporate;

	@FindBy(name = "paymentProductCode")
	WebElement paymentProductCode;

	@FindBy(name = "minAmount")
	WebElement minAmount;

	@FindBy(name = "maxAmount")
	WebElement maxAmount;

	@FindBy(name = "accountingCode")
	WebElement accountingCode;

	@FindBy(name = "settlement")
	WebElement settlement;

	@FindBy(name = "miscName")
	WebElement miscellaneous;

	@FindBy(name = "repMappingName")
	WebElement representMapping;

	@FindBy(name = "chargeFrequencyName")
	WebElement chargeFrequency;

	@FindBy(name = "chargeMndtName")
	WebElement mandateCharge;

	@FindBy(name = "chargeTranName")
	WebElement transactionCharge;

	@FindBy(name = "startDate")
	WebElement startDate;

	@FindBy(name = "endDate")
	WebElement endDate;

	@FindBy(name = "smsAlert")
	WebElement smsAlert;

	@FindBy(name = "smsAlertOptList")
	WebElement smsOptedfor;

	@FindBy(name = "emailAlert")
	WebElement emailAlert;

	@FindBy(name = "emailAlertOptList")
	WebElement emailOptedFor;

	@FindBy(name = "emailIdsConfigured")
	WebElement EmailIds;

	@FindBy(name = "mobNosConfigured")
	WebElement mobileNo;

	@FindBy(name = "corpPostingChargeCode")
	WebElement corporatechargePosting;

	@FindBy(name = "vendorCode")
	WebElement vendorCode;

	@FindBy(name = "noOfDaysPosting")
	WebElement noOfDaysPosting;

	@FindBy(name = "achcodes")
	WebElement achCodes;

	@FindBy(name = "ecscodes")
	WebElement ecsCodes;

	@FindBy(name = "apbscodes")
	WebElement apbsCodes;

	@FindBy(name = "directDebitCorpCode")
	WebElement directDebitcodes;

	@FindBy(name = "viewAccount")
	WebElement showAccountButton;

	@FindBy(id = "accountingCodeDiv")
	WebElement showAccBtnPopUpText;

	@FindBy(xpath = "//body[1]/div[4]/center[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")
	WebElement schemeRecordValue;

	@FindBy(xpath = "//tbody/tr[31]/td[2]")
	WebElement schemeRecordStatus;

	@FindBy(xpath = "//input[@name='schemecode']")
	WebElement schemeApproveScreenRecordValue;

	@FindBy(xpath = "//input[@name='customerCode']")
	WebElement corpCodeValue;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement schemeScreenRecord;

	// -----Customer Menu Webelements------------
	@FindBy(name = "customerCode")
	WebElement customerCode_TxtField;

	@FindBy(name = "name")
	WebElement custName_TxtField;

	@FindBy(name = "sponsorCode")
	WebElement sponsorIFSC_TxtField;

	@FindBy(name = "parentCustomer")
	WebElement parentCustomer_DropDown;

	@FindBy(name = "contactPerson")
	WebElement contactPerson_TxtField;

	@FindBy(name = "addressLine1")
	WebElement addressLine1_TxtField;

	@FindBy(name = "addressLine2")
	WebElement addressLine2_TxtField;

	@FindBy(name = "addressLine3")
	WebElement addressLine3_TxtField;

	@FindBy(name = "addressLine4")
	WebElement addressLine4_TxtField;

	@FindBy(name = "zipCode")
	WebElement zipCode_TxtField;

	@FindBy(name = "country")
	WebElement country_TxtField;

	@FindBy(name = "stateName")
	WebElement stateName_DropDown;

	@FindBy(name = "phoneNo")
	WebElement customerMenu_phoneNo_TxtField;

	@FindBy(name = "mobileNo")
	WebElement customerMenu_mobileNumber_TxtField;

	@FindBy(name = "faxNo")
	WebElement faxNo_TxtField;

	@FindBy(name = "emailId")
	WebElement customerMenu_emailID_TxtField;

	@FindBy(name = "addressRemarks")
	WebElement addressRemarks_TxtField;

	@FindBy(name = "remarks")
	WebElement customerMenu_Remarks_TxtField;

	@FindBy(name = "industryTypeCode")
	WebElement customerMenu_industryType_DropDown;

	@FindBy(name = "uccNo")
	WebElement uccNo_TxtField;

	@FindBy(name = "panNo")
	WebElement customerMenu_panNo_TxtField;

	@FindBy(name = "customerType")
	WebElement customerMenu_CustType_TxtField;

	@FindBy(name = "creditRating")
	WebElement customerMenu_CreditRating_TxtField;

	@FindBy(name = "effectiveFrom")
	WebElement effectiveDateFrom_DateField;

	@FindBy(name = "effectiveTo")
	WebElement effectiveDateTo_DateField;

	@FindBy(name = "businessGrpCode")
	WebElement customerMenu_BusinessGroup_DropDown;

	@FindBy(name = "retentionPeriod")
	WebElement retentionPeriod_TxtField;

	@FindBy(name = "paymentMode")
	WebElement paymentMode_TxtField;

	@FindBy(name = "achCode")
	WebElement customerMenuFilterScreen_ACHCode;

	@FindBy(name = "ecsCode")
	WebElement customerMenuFilterScreen_ECSCode;

	@FindBy(name = "apbsCode")
	WebElement customerMenuFilterScreen_APBSCode;

	@FindBy(name = "abpsCode")
	WebElement customerMenulistFilterScreen_APBSCode;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")
	WebElement Customer_listScreenCustomerCodeValue;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]")
	WebElement Customer_listScreenCustomerNameValue;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[31]/td[2]")
	WebElement Customer_listScreenStatusValue;

	@FindBy(name = "customerCode")
	WebElement customer_SchemeFormatCd_CorporateDropDown;

	@FindBy(name = "mappingType")
	WebElement Customer_SchemeFormatCd_mappingType;

	@FindBy(name = "action")
	WebElement customerMenu_ActionType;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/form/input[4]")
	WebElement CustomerSchemeFormatMapping_SubmitBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/span")
	WebElement CustomerSchemeFormatCode_itemsInList;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement customerScreenRecord;

	// -----------Accounting Menu WebElements----------------

	@FindBy(name = "accountingCode")
	WebElement accountingMenu_AccountingCodeTxtField;

	@FindBy(name = "accountingDesc")
	WebElement accountingMenu_DescriptionTxtField;

	@FindBy(name = "creditAccNo")
	WebElement accountingMenu_CreditAccNoTxtField;

	@FindBy(name = "debitAccNo")
	WebElement accountingMenu_DebitAccNoTxtField;

	@FindBy(name = "chargeAccNo")
	WebElement accountingMenu_ChargeAccountNoTxtField;

	@FindBy(name = "isAutoDebitCharge")
	WebElement accountingMenu_IsAutoDebitChargeDropdown;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement accountingScreenRecord;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")
	WebElement accountingListScreenAccCode;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]")
	WebElement accountingListScreenCreditAccNo;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[2]")
	WebElement accountingListScreenDebitAccNo;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td[2]")
	WebElement accountingListScreenChargeAccNo;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[9]/td[2]")
	WebElement accountingListScreenStatus;

	// -----------Duplicate Check Menu WebElements----------------
	@FindBy(name = "name")
	WebElement duplicateCheckNameField;

	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	WebElement listScreenName;

	@FindBy(xpath = "//tbody/tr[6]/td[2]")
	WebElement duplicateCheckNameStatus;
	
	@FindBy(name = "cancel")
	WebElement cancelBtn;
	
	@FindBy(name = "back")
	WebElement backBtn;
	
	@FindBy(id = "btnDelete")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;
	
	@FindBy(name = "acronym")
	WebElement acronymField;
	
	@FindBy(name = "dest_Bank_IFSC_MICR")
	WebElement destinationBankIFSC_MICRField;
	
	@FindBy(name = "amount_Fixed")
	WebElement amountFixedField;
	
	@FindBy(name = "amount")
	WebElement amountField;
	
	@FindBy(name = "frequency")
	WebElement frequencyField;
	
	@FindBy(name = "customer_Name")
	WebElement customerNameField;
	
	@FindBy(name = "customer_Account_No")
	WebElement customerAccountNoField;
	
	@FindBy(name = "account_Type")
	WebElement accountTypeField;
	
	@FindBy(name = "category_code")
	WebElement categorycodeField;
	
	@FindBy(name = "consumer_Reference_Number")
	WebElement consumerReferenceNumberField;
	
	@FindBy(name = "scheme_Reference_Number")
	WebElement schemeReferenceNumberField;
	
	@FindBy(id = "btnDeleteConf")
	WebElement confirmDeleteBtn;
	
	@FindBy(name = "cancelDelete")
	WebElement cancelDeleteBtn;
	
	@FindBy(id = "btnApprove")
	WebElement approveBtn;
	
	@FindBy(name = "cancelModify")
	WebElement cancelModifyBtn;
	
	@FindBy(id = "btnModifyConf")
	WebElement modifyBtn;

	// ---Constructor to initialize the webelement-----
	public CorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader = new FileReadUtils(driver);
		this.errorMessageChecker = new ValidationMessages(driver);
		this.elementutil = new ElementUtil(driver);
		this.homePage = new HomePage(driver);
	}// end of constructor

	// --------------Methods for Business Group Menu----------------

	// -------------Add Business Group Method-----------------------
	public void addBusinessGroup(String SheetName) throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameTextField, groupName);
			elementutil.enterText(groupDescriptionTextField, groupDescription);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("Business Group Name Already Exists".trim().toString())) {
					log.info(
							"Duplicate Record : Business Group Name Already Exists Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.error(
							"Data Provided For Add operation Is Not As Per Valid Format OR Business Group Name Already Exists Validation Message Displayed Is Incorrrect");
				} // end of else
			} catch (NoSuchElementException e) {

				// click on Back button
				elementutil.clickElement(btnBack);

				// check back button working
				if (elementutil.getText(errormessages).trim().toString().equals("User Pressed Back Key")) {
					log.info("Back Button Is Working Fine");
				} // end
				else {
					log.error("Back button Is Not Working Fine");
				} // end of else
					// click on ok button
				elementutil.clickElement(okBtn);
				// click on AddConfirm button
				elementutil.clickElement(btnAddConfirm);
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		logOutOperation();
	}// end of addBusinessGroup function

	// ------------- Invalid Validation Method for Business Add
	// Menu-----------------------
	public void addInvalidBusinessGroup(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			String businessGrpAddScreen_MandatoryMessage = "Invalid Business Group Name\n"
					+ "Invalid Business Group Description";

			// click on ok button
			elementutil.clickElement(okBtn);

			// check if mandatory fields message displayed is correct
			if (elementutil.getText(errormessages).trim().toString()
					.equals(businessGrpAddScreen_MandatoryMessage.trim().toString())) {
				log.info("Mandatory Fields Validation Message For Business Group->Add Screen Displayed Is Correct");
			} // end of if
			else {
				log.info("Mandatory Fields Validation Message For Business Group->Add Screen Displayed Is Incorrect");
			} // end of else

			String expectedGroupNameFieldMessage = "Invalid Business Group Name";
			String expectedGroupDescFieldMessage = "Invalid Business Group Description";

			// enter details
			elementutil.enterText(groupNameTextField, groupName);
			elementutil.enterText(groupDescriptionTextField, groupDescription);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals(expectedGroupNameFieldMessage.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedGroupDescFieldMessage.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(businessGrpAddScreen_MandatoryMessage.trim().toString())) {
					log.info("Business Group->Add Screen Field Wise Invalid Data Message Displayed Is Correct");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("Business Group Name Already Exists".trim().toString())) {
					log.info(
							"Test Data Provided Was Not Invalid. Duplicate Record Error, Existing Record With Business Group Name "
									+ groupName + " And Group Description " + groupDescription + " Found");
				} else {
					log.error("Business Group->Add Screen Field Wise Invalid Data Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Was Not Invalid");
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of addInvalidBusinessGroup function

	// ---------- Modify Method for Business Group--------------------------

	public void modifyBusinessGroup(String SheetName) throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupNameOriginal = map.get("Original Group Name");
			String groupName = map.get("Group Name");
			String groupDescriptionOriginal = map.get("Original Group Description");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupNameOriginal);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(groupNameFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupNameOriginal);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Expected Record With Group Name " + groupNameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message displayed Is Correct");
				} // end of if
				else {
					log.info("Expected Record With Group Name " + groupNameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message displayed Is Incorrect");

				} // end of else

			} catch (NoSuchElementException e) {
				// check if multiple records are displayed on screen
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Modify".trim().toString())) {
					// click on screen record if displayed multiple list of records
					elementutil.clickElement(screenRecord);

					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupNameOriginal.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescriptionOriginal.trim().toString())) {
						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupNameOriginal);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on record if multiple records are displayed
						elementutil.clickElement(screenRecord);

						// modify record
						elementutil.clearText(groupNameTextField);
						elementutil.enterText(groupNameTextField, groupName);
						elementutil.clearText(groupDescriptionTextField);
						elementutil.enterText(groupDescriptionTextField, groupDescription);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// check if after modification values are not same as any existing
						// record(duplicate record)
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Business Group Name Already Exists".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} // end of if
							else {
								log.error(
										"Data Provided For Modify operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e2) {
							elementutil.clickElement(btnBack);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							}
							// click on ok button
							elementutil.clickElement(businessGroupOkBtn);
							// click on ModifyConfirm button
							elementutil.clickElement(btnModifyConfirm);
						}
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupNameOriginal
								+ " And Group Description " + groupDescriptionOriginal + " Not Found");
					} // end of else
				} // end of if

				else {
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupNameOriginal.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescriptionOriginal.trim().toString())) {
						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupNameOriginal);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// modify record
						elementutil.clearText(groupNameTextField);
						elementutil.enterText(groupNameTextField, groupName);
						elementutil.clearText(groupDescriptionTextField);
						elementutil.enterText(groupDescriptionTextField, groupDescription);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// check if after modification values are not same as any existing
						// record(duplicate record)
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Business Group Name Already Exists".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} // end of if
							else {
								log.error(
										"Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e2) {
							elementutil.clickElement(btnBack);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							}
							// click on ok button
							elementutil.clickElement(businessGroupOkBtn);
							// click on ModifyConfirm button
							elementutil.clickElement(btnModifyConfirm);
						}
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupNameOriginal
								+ " And Group Description " + groupDescriptionOriginal + " Not Found");
					} // end of else
				} // end of catch
					// NOTE IMP:
					// commented due to modify filter screen issue
				/*
				 * 
				 * elementutil.clickElement(businessGroupOkBtn);
				 * 
				 * if(elementutil.getAttribute(groupNameTextField).trim().toString().equals(
				 * groupNameOriginal) &&
				 * elementutil.getAttribute(groupDescriptionTextField).trim().toString().equals(
				 * groupDescriptionOriginal)) { elementutil.clickElement(btnCancel);
				 * if(elementutil.getText(errormessages).trim().toString().
				 * equals("Operation Cancelled".trim().toString())) {
				 * log.info("Cancel Button Is Working Fine"); }//end of if else {
				 * log.error("Cancel Button Is Not Working Fine"); }//end of else
				 * 
				 * //enter details elementutil.enterText(groupNameFilterScreenTxtField,
				 * groupNameOriginal);
				 * 
				 * //click on ok button elementutil.clickElement(businessGroupOkBtn);
				 * 
				 * elementutil.clickElement(screenRecord);
				 * 
				 * //modify record elementutil.clearText(groupNameTextField);
				 * elementutil.enterText(groupNameTextField, groupName);
				 * elementutil.clearText(groupDescriptionTextField);
				 * elementutil.enterText(groupDescriptionTextField, groupDescription);
				 * 
				 * //click on ok button elementutil.clickElement(businessGroupOkBtn);
				 * 
				 * //check if after modification values are not same as any existing
				 * record(duplicate record) try {
				 * if(elementutil.getText(errormessages).trim().toString().
				 * equals("Business Group Name Already Exists".trim().toString())) { log.
				 * info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct"
				 * ); }//end of if else { log.
				 * error("Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect"
				 * ); }//end of else } catch (NoSuchElementException e2) {
				 * elementutil.clickElement(btnBack);
				 * if(elementutil.getText(errormessages).trim().toString().
				 * equals("User Pressed Back Key".trim().toString())) {
				 * log.info("Back Button Is Working Fine"); }//end of if else {
				 * log.error("Back Button Is Not Working Fine"); } //click on ok button
				 * elementutil.clickElement(businessGroupOkBtn); //click on ModifyConfirm button
				 * elementutil.clickElement(btnModifyConfirm); } }//end of if else {
				 * log.info("Record Mismatch, Record With Business Group Name "
				 * +groupNameOriginal+ " And Group Description " +groupDescriptionOriginal+
				 * " Not Found"); }//end of else
				 */
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of modifyBusinessGroup function

	// -----------Delete Method for Business Group---------------------------

	public void deleteBusinessGroupRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(groupNameFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not working Fine");
			} // end of else

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.info("No Records available for Delete operation Validation Message displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.error("No Records available for Delete operation Validation Message displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Delete".trim().toString())) {
					// System.out.println("in if");
					// click on screen record
					elementutil.clickElement(screenRecord);

					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupName);

						// click on ok button
						elementutil.clickElement(okBtn);

						elementutil.clickElement(screenRecord);

						// click on ok button
						elementutil.clickElement(okBtn);

						// click on delete button
						elementutil.clickElement(btnDelete);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} else {
					// System.out.println("in else");
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupName);

						// click on ok button
						elementutil.clickElement(okBtn);

						// click on ok button
						elementutil.clickElement(okBtn);

						// click on delete button
						elementutil.clickElement(btnDelete);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of deleteBusinessGroupRecord function

	// -----------Delete Confirm for Business Group-----------------------------
	public void deleteConfirmBusinessGroup(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(groupNameFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not working Fine");
			} // end of else

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Confirm Delete".trim().toString())) {
					// System.out.println("in if");
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// Note IMP: Getting Error Message System information HTTP Error Code: 404.
						// Resource not found. on clicking
						// cancel button hence commented
						// click on cancel button
						/*
						 * elementutil.clickElement(btnCancel);
						 * if(elementutil.getText(errormessages).trim().toString().
						 * equals("Operation Cancelled".trim().toString())) {
						 * log.info("Cancel Button Is Working Fine"); }//end of if else {
						 * log.error("Cancel Button Is Not Working Fine"); }//end of else
						 * 
						 * //enter details elementutil.enterText(groupNameFilterScreenTxtField,
						 * groupName);
						 * 
						 * //click on ok button elementutil.clickElement(okBtn);
						 */

						// click on delete button
						elementutil.clickElement(btnDeleteConfirm);

						try {
							String CustomerCodesMappedMessage = elementutil.getText(errormessages);
							String CustomerCodes[] = CustomerCodesMappedMessage.split("[.]", 0);

							if (elementutil.getText(errormessages).trim().toString()
									.contains("Kindly unmap business group from customers. ".trim().toString())) {
								log.info("Confirm Delete Operation Cannot Be Performed on Record With Group Name "
										+ groupName + " As Record Is Mapped With " + CustomerCodes[1]);
							} // end of if

						} catch (NoSuchElementException e2) {
							log.info("Confirm Delete Operation Performed Successfully on " + groupName);
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of if
				else {
					// System.out.println("in else");
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// Note IMP: Getting Error Message System information HTTP Error Code: 404.
						// Resource not found. on clicking
						// cancel button hence commented
						// click on cancel button
						/*
						 * elementutil.clickElement(btnCancel);
						 * if(elementutil.getText(errormessages).trim().toString().
						 * equals("Operation Cancelled".trim().toString())) {
						 * log.info("Cancel Button Is Working Fine"); }//end of if else {
						 * log.error("Cancel Button Is Not Working Fine"); }//end of else
						 * 
						 * //enter details elementutil.enterText(groupNameFilterScreenTxtField,
						 * groupName);
						 * 
						 * //click on ok button elementutil.clickElement(okBtn);
						 */

						// click on delete button
						elementutil.clickElement(btnDeleteConfirm);

						try {
							String CustomerCodesMappedMessage = elementutil.getText(errormessages);
							String CustomerCodes[] = CustomerCodesMappedMessage.split("[.]", 0);

							if (elementutil.getText(errormessages).trim().toString()
									.contains("Kindly unmap business group from customers. ".trim().toString())) {
								log.info("Confirm Delete Operation Cannot Be Performed on Record With Group Name "
										+ groupName + " As Record Is Mapped With " + CustomerCodes[1]);
							} // end of if

						} catch (NoSuchElementException e2) {
							log.info("Confirm Delete Operation Performed Successfully on " + groupName);
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of deleteConfirmBusinessGroup function

	// ----------Method for Cancel Delete Action Scenario For Business
	// Group-----------------------------
	public void businessGroupCancelDeleteAction(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(ScreenTextValue).trim().equals("Confirm Delete".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on ConfirmDelete button
						elementutil.clickElement(cancelDeleteActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of if
				else {
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on ConfirmDelete button
						elementutil.clickElement(cancelDeleteActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of businessGroupCancelDeleteAction function

	// ----------Approve Method for Business Group---------------------------
	public void approveBusinessGroupRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details on filter screen
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(groupNameFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details on filter screen
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			// check if record is present for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " Not Found");
					log.error("No Records available for Approve operation Validation Message displayed Is Incorrect");
				} // end of else//*[@id="pageBody"]/p
			} catch (NoSuchElementException e) {
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Approve".trim().toString())) {
					// click on screen record
					elementutil.clickElement(screenRecord);
					// check if record to be approved matches the values from sheet
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupName);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on record if visible
						elementutil.clickElement(screenRecord);

						// click on Approve button
						elementutil.clickElement(btnApprove);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ "And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of if
				else {
					// check the record to be approve matches with the values from sheet
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(groupNameFilterScreenTxtField, groupName);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// click on Approve button
						elementutil.clickElement(btnApprove);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ "And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of approveBusinessGroup function

	// ----------Method to List Business Group Record---------------------------
	public void listBusinessGroupRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details on filter screen
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(groupNameFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details on filter screen
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			// check if record is present for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " Not Found");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " Not Found");
					log.error("No Records available for List operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("List".trim().toString())) {
					// System.out.println("in if");
					elementutil.clickElement(screenRecord);
					if (elementutil.getText(listScreenGroupName).trim().toString().equals(groupName.trim().toString())
							&& elementutil.getText(listScreenGroupDesc).trim().toString()
									.equals(groupDescription.trim().toString())) {
						log.info("Business Group Record With Group Name " + groupName + " And Group Description "
								+ groupDescription + " Is Displayed In List With Status "
								+ elementutil.getText(listScreenStatus));
					} // end of if
					else {
						log.info("Business Group Record With Group Name " + groupName + " And Group Description "
								+ groupDescription + " Is Not Displayed In List");

					} // end of else

				} // end of if
				else {
					// System.out.println("in else");
					elementutil.clickElement(screenRecord);
					if (elementutil.getText(listScreenGroupName).trim().toString().equals(groupName.trim().toString())
							&& elementutil.getText(listScreenGroupDesc).trim().toString()
									.equals(groupDescription.trim().toString())) {
						log.info("Business Group Record With Group Name " + groupName + " And Group Description "
								+ groupDescription + " Is Displayed In List With Status " + listScreenStatus);
					} // end of if
					else {
						log.info("Business Group Record With Group Name " + groupName + " And Group Description "
								+ groupDescription + " Is Not Displayed In List");

					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of listBusinessGroupRecord function

	// ---------- Method for Business Group Modify using Invalid
	// Data--------------------------

	public void modifyInvalidBusinessGroup(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupNameOriginal = map.get("Original Group Name");
			String groupName = map.get("Group Name");
			String groupDescriptionOriginal = map.get("Original Group Description");
			String groupDescription = map.get("Group Description");

			// enter details
			elementutil.enterText(groupNameFilterScreenTxtField, groupNameOriginal);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Expected Record With Group Name " + groupNameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message displayed Is Correct");
				} // end of if
				else {
					log.info("Expected Record With Group Name " + groupNameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message displayed Is Incorrect");

				} // end of else

			} catch (NoSuchElementException e) {

				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Modify".trim().toString())) {
					// click on screen record if visible
					elementutil.clickElement(screenRecord);

					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupNameOriginal.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescriptionOriginal.trim().toString())) {
						String expectedMandatoryFieldMessage = "Invalid Business Group Name\n"
								+ "Invalid Business Group Description";

						elementutil.clearText(groupNameTextField);
						elementutil.clearText(groupDescriptionTextField);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						if (elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldMessage.trim().toString())) {
							log.info(
									"Mandatory Field Validation Message For Business Group->Modify Screen Displayed Is Correct");
						} // end of if
						else {
							log.error(
									"Mandatory Field Validation Message For Business Group->Modify Screen Displayed Is Incorrect");
						} // end of else

						String expectedInvalidDataMessage1 = "Invalid Business Group Name";
						String expectedInvalidDataMessage2 = "Invalid Business Group Description";
						// enter details
						elementutil.enterText(groupNameTextField, groupName);
						elementutil.enterText(groupDescriptionTextField, groupDescription);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// check if after modification values are not same as any existing
						// record(duplicate record)
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedInvalidDataMessage1.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidDataMessage2.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedMandatoryFieldMessage.trim().toString())) {
								log.info("Field Wise Invalid Data Message Displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("Business Group Name Already Exists".trim().toString())) {
								log.info(
										"Test Data Provided Was Not Invalid. Duplicate Record Error, Existing Record With Business Group Name "
												+ groupName + "And Group Description " + groupDescription + " Found");
							} else {
								log.error("Field Wise Invalid Data Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e2) {
							log.info("Test Data Provided Was Not Invalid");
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupNameOriginal
								+ " And Group Description " + groupDescriptionOriginal + " Not Found");
					} // end of else

				} // end of if
				else {
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupNameOriginal.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescriptionOriginal.trim().toString())) {
						String expectedMandatoryFieldMessage = "Invalid Business Group Name\n"
								+ "Invalid Business Group Description";

						elementutil.clearText(groupNameTextField);
						elementutil.clearText(groupDescriptionTextField);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						if (elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldMessage.trim().toString())) {
							log.info(
									"Mandatory Field Validation Message For Business Group->Modify Screen Displayed Is Correct");
						} // end of if
						else {
							log.error(
									"Mandatory Field Validation Message For Business Group->Modify Screen Displayed Is Incorrect");
						} // end of else

						String expectedInvalidDataMessage1 = "Invalid Business Group Name";
						String expectedInvalidDataMessage2 = "Invalid Business Group Description";

						elementutil.enterText(groupNameTextField, groupName);
						elementutil.enterText(groupDescriptionTextField, groupDescription);

						// click on ok button
						elementutil.clickElement(businessGroupOkBtn);

						// check if after modification values are not same as any existing
						// record(duplicate record)
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedInvalidDataMessage1.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidDataMessage2.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedMandatoryFieldMessage.trim().toString())) {
								log.info("Field Wise Invalid Data Message Displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("Business Group Name Already Exists".trim().toString())) {
								log.info(
										"Test Data Provided Was Not Invalid. Duplicate Record Error, Existing Record With Business Group Name "
												+ groupName + "And Group Description " + groupDescription + " Found");
							} // end of else if
							else {
								log.error("Field Wise Invalid Data Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e2) {

							log.info("Test Data Provided Was Not Invalid");
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupNameOriginal
								+ " And Group Description " + groupDescriptionOriginal + " Not Found");
					} // end of else
				} // end of else
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of modifyInvalidBusinessGroup function

	// ----------Method for Cancel Modify Action forBusiness
	// Group---------------------------
	public void businessGroupCancelModifyAction(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String groupName = map.get("Group Name");
			String groupDescription = map.get("Group Description");

			// enter details on filter screen
			elementutil.enterText(groupNameFilterScreenTxtField, groupName);

			// click on ok button
			elementutil.clickElement(businessGroupOkBtn);

			// check if record is present for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Business Group Name " + groupName + " And Group Description "
							+ groupDescription + " Not Found");
					log.error("No Records available for Approve operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// check if multiple records are displayed if yes click on screen record and
				// check for grp name and description
				if (elementutil.getText(ScreenTextValue).trim().toString().equals("Approve".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on CancelModifyAction button
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of if
				else {
					// if multiple records are not displayed check for group name and description of
					// the record displayed
					if (elementutil.getAttribute(groupNameTextField).trim().toString()
							.equals(groupName.trim().toString())
							&& elementutil.getAttribute(groupDescriptionTextField).trim().toString()
									.equals(groupDescription.trim().toString())) {
						// click on CancelModifyAction button
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Business Group Name " + groupName
								+ " And Group Description " + groupDescription + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of cancelModifyActionBusinessGroup function

	// --------------Methods for Industry type-------------------------------------

	// --------- Add Method for Industry Type--------------------
	public void addIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.SHORT_TIMEOUT();
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			elementutil.enterText(industryTypeDescTextField, industryTypeDesc);
			elementutil.clickElement(industryBtnOk);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists".trim().toString())) {
					log.error("Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect");
				} // end of if
				else {
					log.info("Data Provided For Add operation Is Not As Per Valid Format");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on Back button
				elementutil.clickElement(btnBack);
				// -- Checking the Back button---------
				if (elementutil.getText(errormessages).trim().toString()
						.equals("User Pressed Back Key".trim().toString())) {
					log.info("Back Button Is Working Fine");
				} // end of if
				else {
					log.error("Back Button Is Not Working Fine");
				} // end of else

				// click on ok button
				elementutil.clickElement(industryBtnOk);

				// click on AddConfirm Button
				elementutil.clickElement(btnAddConfirm);

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();
	}// end of addIndustryTypeRecord function

	// -------------Approve Method for Industry Type----------------
	public void approveIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			test_Data = fileReader.readCorporateCMSExcel(SheetName);
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);
			// click on Reset Button
			elementutil.clickElement(btnReset);
			// check Reset Button working
			if (elementutil.getText(industryTypeFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);

			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) {
						// click on record
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCode.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDesc.trim().toString())) {
							// click on Cancel Button
							elementutil.clickElement(btnCancel);
							// check Cancel button working
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);
							// click on ok button
							elementutil.clickElement(industryBtnOk);
							// click on screen record
							elementutil.clickElement(industryTypeScreenRecord);
							// click on Approve button
							elementutil.clickElement(btnApprove);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
									+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCode.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDesc.trim().toString())) {
						// click on Cancel Button
						elementutil.clickElement(btnCancel);
						// check Cancel button working
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);
						// click on ok button
						elementutil.clickElement(industryBtnOk);
						// click on Approve button
						elementutil.clickElement(btnApprove);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
								+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of approveIndustryTypeRecord function

	// -------------List Method for Industry Type----------------
	public void listIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);
			// click on Reset Button
			elementutil.clickElement(btnReset);
			// check Reset Button working
			if (elementutil.getText(industryTypeFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);

			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.error("No Records available for List operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on record
				elementutil.clickElement(screenRecord);
				if (elementutil.getText(listScreenIndustryTypeCode).trim().toString()
						.equals(industryTypeCode.trim().toString())
						&& elementutil.getText(listScreenIndustryTypeDesc).trim().toString()
								.equals(industryTypeDesc.trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Is Displayed In List With Status "
							+ elementutil.getText(industryTypeListScreenStatus));

				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Is Not Displayed In List");
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of listIndustryTypeRecord function

	// -------------Method for Cancel Modify Action for Industry
	// Type----------------
	public void cancelModifyActionIndustryTypeRec(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeFilterScreenTxtField, industryTypeCode);

			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) {
						// click on record
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCode.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDesc.trim().toString())) {
							// click on Approve button
							elementutil.clickElement(cancelModifyActionBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
									+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCode.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDesc.trim().toString())) {
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
								+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of cancelModifyActionIndustryTypeRecord function

	// ---------------------Method to Add Industry Type Record With Invalid
	// Value---------------------------------
	public void addInvalidIndustryType(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			String expectedMandatoryFieldsMessage = "Invalid Industry Type Code\n"
					+ "Invalid Industry Type Description";

			// click on ok button
			elementutil.clickElement(industryBtnOk);

			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedMandatoryFieldsMessage.trim().toString())) {
				log.info("Mandatory Fields Validation Message Displayed for Industry Type->Add Screen Is Correct");
			} // end of if
			else {
				log.error("Mandatory Fields Validation Message Displayed for Industry Type->Add Screen Is Incorrect");

			} // end of else

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			elementutil.enterText(industryTypeDescTextField, industryTypeDesc);

			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("Invalid Industry Type Code".trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals("Invalid Industry Type Description".trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldsMessage.trim().toString())) {
					log.info("Field Wise Invalid Data Message Displayed Is Correct");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists".trim().toString())) {
					log.info(
							"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record Found With Indutry Type Code "
									+ industryTypeCode + " And Industry Type Desc " + industryTypeDesc);
				} else {
					log.error("Field Wise Invalid Data Message Displayed Is Incorrect");
				} // end of else

			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Was Not Invalid");
			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of addInvalidIndustryType function

	// ----------------------Method to Modify Industry Type
	// Record----------------------------------------
	public void modifyIndustryType(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCodeOriginal = map.get("Original Industry Type Code");
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDescOriginal = map.get("Original Industry Type Desc");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCodeOriginal);
			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(industryTypeFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCodeOriginal);
			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {

					if (industryTypeScreenRecord.isDisplayed()) {
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCodeOriginal.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDescOriginal.trim().toString())) { // click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(industryTypeCodeTextField, industryTypeCodeOriginal);
							// click on Ok button
							elementutil.clickElement(industryBtnOk);
							elementutil.clickElement(industryTypeScreenRecord);
							// enter details for modification
							elementutil.clearText(industryTypeCodeTextField);
							elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
							elementutil.clearText(industryTypeDescTextField);
							elementutil.enterText(industryTypeDescTextField, industryTypeDesc);
							elementutil.clickElement(industryBtnOk);
							try {
								if (elementutil.getText(errormessages).trim().toString()
										.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists")) {
									log.info(
											"Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect");
								} // end of if
								else {
									log.error("Data Provided For Modify operation Is Not As Per Valid Format");
								} // end of else
							} catch (NoSuchElementException e2) {
								elementutil.clickElement(btnBack);
								if (elementutil.getText(errormessages).trim().toString()
										.equals("User Pressed Back Key".trim().toString())) {
									log.info("Back Button Is Working Fine");
								} // end of if
								else {
									log.error("Back Button Is Not Working Fine");
								} // end of else
								elementutil.clickElement(industryBtnOk);
								elementutil.clickElement(btnModifyConfirm);
							} // end of catch
						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCodeOriginal
									+ " And Industry Type Desc " + industryTypeDescOriginal + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCodeOriginal.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDescOriginal.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(industryTypeCodeTextField, industryTypeCodeOriginal);
						// click on Ok button
						elementutil.clickElement(industryBtnOk);
						// enter details for modification
						elementutil.clearText(industryTypeCodeTextField);
						elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
						elementutil.clearText(industryTypeDescTextField);
						elementutil.enterText(industryTypeDescTextField, industryTypeDesc);
						elementutil.clickElement(industryBtnOk);
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists")) {
								log.info(
										"Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect");
							} // end of if
							else {
								log.error("Data Provided For Modify operation Is Not As Per Valid Format");
							} // end of else
						} catch (NoSuchElementException e3) {
							elementutil.clickElement(btnBack);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							} // end of else
							elementutil.clickElement(industryBtnOk);
							elementutil.clickElement(btnModifyConfirm);
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCodeOriginal
								+ " And Industry Type Desc " + industryTypeDescOriginal + " Not Found");
					} // end of else
				}
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of modifyIndustryType function

	// ----------------------Method to Modify Industry Type Record Using Invalid
	// Data----------------------------------------
	public void modifyIndustryType_InvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCodeOriginal = map.get("Original Industry Type Code");
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDescOriginal = map.get("Original Industry Type Desc");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCodeOriginal);
			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) {
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCodeOriginal.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDescOriginal.trim().toString())) {
							String expectedmandatoryFieldMessage = "Invalid Industry Type Code\n"
									+ "Invalid Industry Type Description";
							// clear all field values
							elementutil.clearText(industryTypeCodeTextField);
							elementutil.clearText(industryTypeDescTextField);
							// click on ok button
							elementutil.clickElement(industryBtnOk);
							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedmandatoryFieldMessage.trim().toString())) {
								log.info(
										"Mandatory Fields Validation Message Displayed For Industry Type->Modify Screen Is Correct");
							} // end of if
							else {
								log.error(
										"Mandatory Fields Validation Message Displayed For Industry Type->Modify Screen Is Incorrect");
							} // end of else
								// enter invalid details from sheet
							elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
							elementutil.enterText(industryTypeDescTextField, industryTypeDesc);
							// click on ok button
							elementutil.clickElement(industryBtnOk);
							try {
								if (elementutil.getText(errormessages).trim().toString()
										.equals("Invalid Industry Type Code".trim().toString())
										|| elementutil.getText(errormessages).trim().toString()
												.equals("Invalid Industry Type Description".trim().toString())
										|| elementutil.getText(errormessages).trim().toString()
												.equals(expectedmandatoryFieldMessage.trim().toString())) {
									log.info("Field Wise Invalid Data Validation Message Displayed Is Correct");
								} // end of if
								else if (elementutil.getText(errormessages).trim().toString()
										.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists"
												.trim().toString())) {
									log.info(
											"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record Found With Indutry Type Code "
													+ industryTypeCode + " And Industry Type Desc " + industryTypeDesc);
								} else {
									log.error("Field Wise Invalid Data Validation Message Displayed Is Incorrect");
								} // end of else
							} catch (NoSuchElementException e2) {
								log.info("Test Data Provided Was Not Invalid");
							} // end of catch
						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCodeOriginal
									+ " And Industry Type Desc " + industryTypeDescOriginal + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCodeOriginal.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDescOriginal.trim().toString())) {
						String expectedmandatoryFieldMessage = "Invalid Industry Type Code\n"
								+ "Invalid Industry Type Description";
						// clear all field values
						elementutil.clearText(industryTypeCodeTextField);
						elementutil.clearText(industryTypeDescTextField);
						// click on ok button
						elementutil.clickElement(industryBtnOk);
						if (elementutil.getText(errormessages).trim().toString()
								.equals(expectedmandatoryFieldMessage.trim().toString())) {
							log.info(
									"Mandatory Fields Validation Message Displayed For Industry Type->Modify Screen Is Correct");
						} // end of if
						else {
							log.error(
									"Mandatory Fields Validation Message Displayed For Industry Type->Modify Screen Is Incorrect");
						} // end of else
							// enter invalid details from sheet
						elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
						elementutil.enterText(industryTypeDescTextField, industryTypeDesc);
						// click on ok button
						elementutil.clickElement(industryBtnOk);
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Invalid Industry Type Code".trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals("Invalid Industry Type Description".trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedmandatoryFieldMessage.trim().toString())) {
								log.info("Field Wise Invalid Data Validation Message Displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("db.cif.cms.corp.industryType.error.industryTypeCode.recordExists".trim()
											.toString())) {
								log.info(
										"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record Found With Indutry Type Code "
												+ industryTypeCode + " And Industry Type Desc " + industryTypeDesc);
							} else {
								log.error("Field Wise Invalid Data Validation Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e3) {
							log.info("Test Data Provided Was Not Invalid");
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCodeOriginal
								+ " And Industry Type Desc " + industryTypeDescOriginal + " Not Found");
					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of modifyIndustryType_InvalidData function

	// ----------------------Method to Delete Industry Type
	// Record----------------------------------------
	public void deleteIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(industryTypeFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) { // click on screen record
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCode.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDesc.trim().toString())) { // click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
							// click on ok button on filter screen
							elementutil.clickElement(industryBtnOk);
							// click on screen record
							elementutil.clickElement(industryTypeScreenRecord);
							// click on ok button on Delete screen
							elementutil.clickElement(industryBtnOk);
							// click on Delete button
							elementutil.clickElement(btnDelete);

						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
									+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCode.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDesc.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
						// click on ok button on filter screen
						elementutil.clickElement(industryBtnOk);
						// click on ok button on Delete screen
						elementutil.clickElement(industryBtnOk);
						// click on Delete button
						elementutil.clickElement(btnDelete);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
								+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					} // end of else

				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of deleteIndustryType function

	// ----------------------Method to Confirm Delete Industry Type
	// Record----------------------------------------
	public void confirmDeleteIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(industryTypeFilterScreenTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			// click on ok button
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) {
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCode.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDesc.trim().toString())) { // click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
							// click on ok button
							elementutil.clickElement(industryBtnOk);
							// click on record
							elementutil.clickElement(industryTypeScreenRecord);
							// click on Delete button
							elementutil.clickElement(btnDeleteConfirm);

						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
									+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCode.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDesc.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
						// click on ok button
						elementutil.clickElement(industryBtnOk);
						// click on Delete button
						elementutil.clickElement(btnDeleteConfirm);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
								+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of confirmDeleteIndustryType function

	// ----------------------Method for Cancel Delete Action of Industry Type
	// Record----------------------------------------
	public void cancelDeleteActionIndustryTypeRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String industryTypeCode = map.get("Industry Type Code");
			String industryTypeDesc = map.get("Industry Type Desc");

			// enter details
			elementutil.enterText(industryTypeCodeTextField, industryTypeCode);
			// click on ok button on filter screen
			elementutil.clickElement(industryBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Industry Type Record With Industry Type Code " + industryTypeCode
							+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (industryTypeScreenRecord.isDisplayed()) {
						elementutil.clickElement(industryTypeScreenRecord);
						if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
								.equals(industryTypeCode.trim().toString())
								&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
										.equals(industryTypeDesc.trim().toString())) {
							elementutil.clickElement(cancelDeleteActionBtn);

						} // end of if
						else {
							log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
									+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(industryTypeCodeTextField).trim().toString()
							.equals(industryTypeCode.trim().toString())
							&& elementutil.getAttribute(industryTypeDescTextField).trim().toString()
									.equals(industryTypeDesc.trim().toString())) {
						elementutil.clickElement(cancelDeleteActionBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Industry Type Code " + industryTypeCode
								+ " And Industry Type Desc " + industryTypeDesc + " Not Found");
					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of cancelDeleteActionIndustryType function

	// ----------------------------------MISCELLANEOUS MENU
	// METHODS-----------------------------------------------

	// ----------------- Method for adding Miscellaneous-----------
	public void miscellaneousAddFilterScreen(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String templateCode = map.get("TemplateCode");
			String Acronym = map.get("Acronym");
			String ACHCreditSend = map.get("ACHCreditSend");
			String ACHCreditReturn = map.get("ACHCreditReturn");
			String ACHDebitSend = map.get("ACHDebitSend");
			String ECSCreditSend = map.get("ECSCreditSend");
			String ECSCreditRetrun = map.get("ECSCreditRetrun");
			String ECSDebitSend = map.get("ECSDebitSend");
			String APBSCreditSend = map.get("APBSCreditSend");
			String APBSCreditRetrun = map.get("APBSCreditRetrun");
			String ACHCreditFile = map.get("ACHCreditFile");
			String ACHCreditAutoSettlementDate = map.get("ACHCreditAutoSettlementDate");
			String ACHDebitFile = map.get("ACHDebitFile");
			String ECSCreditFile = map.get("ECSCreditFile");
			String ECSCreditAutoSettlementDate = map.get("ECSCreditAutoSettlementDate");
			String ECSDebitFile = map.get("ECSDebitFile");
			String APBSCreditFile = map.get("APBSCreditFile");
			String MMSSpecialCustomer = map.get("MMS Special Customer");
			String MandateDestination = map.get("Mandate Destination");
			String DebitTransactionAutoRepresentation = map.get("Debit Transaction Auto-presentation(on Cycle Date)");
			String ReportGenerationReq = map.get("Report Generation Required");
			String MMSCustomerCycleDates = map.get("MMS Customer Cycle Date");
			String CycleDateISEOM = map.get("Cycle Date is End of Month");
			String PostponeCycleDate = map.get("Postpone Cycle Date");
			String NoOFDaysForDebitTransaction = map.get("Number of Days for Debit Transaction");
			String NoOfDaysForReportGeneration = map.get("Number of Days for Report");
			String NoOfDaysForPosting = map.get("Number of Days for Posting");
			String IsH2HUser = map.get("Is H2H User");
			String EnableAutoMIS = map.get("Enable AutoMIS");
			String SelectAutoMISFor = map.get("Select AutoMIS For");
			String FrequencyForMandateMISInDays = map.get("Frequency For Mandate MIS in days");
			String FrequencyForTransactionMISInDays = map.get("Frequency For Transaction MIS in days");
			String MISTypeTransaction = map.get("MIS Type Transaction");
			String MISTypeMandate = map.get("MIS Type Mandate");
			String MISStatusForTransaction = map.get("MIS Status For Transaction");
			String MISStatusForMandate = map.get("MIS Status For Mandate");

			// delay
			elementutil.SHORT_TIMEOUT();

			// enter all details on screen from sheet
			elementutil.enterText(templateCodeTextField, templateCode);
			elementutil.enterText(acronymfieldTxtBox, Acronym);
			elementutil.SHORT_TIMEOUT();
			elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
			elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
			elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
			elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
			elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
			elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
			elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
			elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
			elementutil.SHORT_TIMEOUT();
			elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
			elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown, ACHCreditAutoSettlementDate);
			elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
			elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
			elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown, ECSCreditAutoSettlementDate);
			elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
			elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
			elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
			elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
			elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
					DebitTransactionAutoRepresentation);
			elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
			elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
			elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
			elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
			elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
			elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
			elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
			elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
			elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
			elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
			elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
			elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
			elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
			elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
			elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
			elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

			// click on "ok" button
			elementutil.clickElement(miscellaneousBtnOk);

			try {
				if (elementutil.getText(errormessages).trim().toString().equals("Duplicate Record".trim().toString())) {
					log.info("Duplicate Record Found: Duplicate Record Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.error(
							"Data Provided For Add Operation Is Not As Per Valid Format OR Duplicate Record Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on Back button
				elementutil.clickElement(btnBack);
				if (elementutil.getText(errormessages).trim().toString()
						.equals("User Pressed Back Key".trim().toString())) {
					log.info("Back Button Is Working Fine");
				} // end of if
				else {
					log.error("Back Button Is Not Working Fine");
				} // end of else

				// click on ok button and then confirm button to confirm addition of record
				elementutil.clickElement(miscellaneousBtnOk);

				// click on AddConfirm Button
				elementutil.clickElement(miscellaneousBtnConfirm);

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of miscellaneousAddFilterScreen function

	// --------------Method to Approve Added Miscellaneous Record---------------
	public void approveMiscellaneousRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String templateCode = map.get("Party Name");

			// move to enterPartyName function to enter Party Name Details on filter screen
			enterPartyName(SheetName);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(partyNameTxtBox).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterPartyName function to enter Party Name Details on filter screen
			enterPartyName(SheetName);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation")) {
					log.info("Record With Party Name " + templateCode + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + templateCode + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(miscellaneousScreenLabels).trim().toString()
						.equals("Approve".trim().toString())) {
					System.out.println("in if");
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(templateCode.trim().toString())) {
						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						enterPartyName(templateCode);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						elementutil.clickElement(screenRecord);

						// click on Approve button on Miscellaneous->Approve screen
						elementutil.clickElement(miscellaneousBtnApprove);

					} // end of if
					else {
						log.info("Record Mismatch, Expected Record With Template Code " + templateCode + " Not found");
					} // end of else
				} // end of if
				else {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(templateCode.trim().toString())) {
						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						enterPartyName(templateCode);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						// click on Approve button on Miscellaneous->Approve screen
						elementutil.clickElement(miscellaneousBtnApprove);

					} // end of if
					else {
						log.info("Record Mismatch, Expected Record With Template Code " + templateCode + " Not found");
					} // end of else

				} // end of else
			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout
		logOutOperation();
		// commented due to list screen filter issue
		// elementutil.handlewin1(driver);
	}// end of approveMiscellaneous function

	// --------------Method to List Miscellaneous Record---------------
	public void listMiscellaneousRecord(String SheetName, int Row)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		test_Data = fileReader.readCorporateCMSExcel(SheetName);
		String templateCode = test_Data.get(Row).get("Party Name");

		// move to enterPartyName function to enter Party Name Details on filter screen
		enterPartyName(templateCode);

		// click on Reset button
		elementutil.clickElement(btnReset);

		if (elementutil.getText(partyNameTxtBox).isEmpty()) {
			log.info("Reset Button Is Working Fine");
		} // end of if
		else {
			log.error("Reset Button Is Not Working Fine");
		} // end of else

		// move to enterPartyName function to enter Party Name Details on filter screen
		enterPartyName(templateCode);

		// click on ok button
		elementutil.clickElement(okBtn);

		try {
			if (elementutil.getText(errormessages).trim().toString()
					.equals("No Records available for List operation")) {
				log.info("Record With Party Name " + templateCode + " Not Found");
				log.info("No Records available for List operation Validation Message Displayed Is Correct");
			} // end of if
			else {
				log.info("Record With Party Name " + templateCode + " Not Found");
				log.error("No Records available for List operation Validation Message Displayed Is Incorrect");

			} // end of else
		} catch (NoSuchElementException e) {

			// click on record
			elementutil.clickElement(screenRecord);

			elementutil.SHORT_TIMEOUT();
			if (elementutil.getText(miscellaneouslistScreenTemplateCode).trim().toString()
					.equals(templateCode.trim().toString())) {
				log.info("Record With Template Code " + templateCode + " Is Displayed In List With Status "
						+ elementutil.getText(miscellaenousListScreenStatus));

			} // end of if
			else {
				log.info("Record With Template Code " + templateCode + " Is Not Displayed In List");
			} // end of else

		} // end of catch

		// perform logout operation
		elementutil.clickElement(logOutBtn);
		elementutil.clickElement(logoutBtn);
		elementutil.quitBrowser();
	}// end of listMiscellaneousRecord function

	// ------------Method to Delete Miscellaneous Record--------------------
	public void miscellaneousDeleteFilterScreen(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String partyName = map.get("Party Name");

			// move to enterPartyName function to enter filter screen details
			enterPartyName(partyName);

			// click on reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(partyNameTxtBox).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterPartyName function to enter filter screen details
			enterPartyName(partyName);

			// click on ok button on filter screen
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrecr");
				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(miscellaneousScreenLabels).trim().toString()
						.equals("Delete".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(partyName.trim().toString())) {
						// click on ok button
						elementutil.clickElement(okBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working fine");

						} else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details on filter screen
						enterPartyName(partyName);

						// click on ok button
						elementutil.clickElement(okBtn);
						// click on record if displayed
						elementutil.clickElement(screenRecord);

						// click on ok button on delete screen
						elementutil.clickElement(okBtn);

						// click on delete button
						elementutil.clickElement(deleteScreenConfirmBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + partyName + " Not Found");
					} // end of else
				} else {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(partyName.trim().toString())) {
						// click on ok button
						elementutil.clickElement(okBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working fine");

						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details on filter screen
						enterPartyName(partyName);

						// click on ok button
						elementutil.clickElement(okBtn);

						// click on ok button on delete screen
						elementutil.clickElement(okBtn);

						// click on delete button
						elementutil.clickElement(deleteScreenConfirmBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + partyName + " Not Found");
					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of miscellaneousDeleteFilterScreen function

	// ---------------Method to Confirm Delete Miscellaneous Record-----------
	public void miscellaneousConfirmDeleteScreen(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String partyName = map.get("Party Name");

			// move to enterPartyName function to enter filter screen details
			enterPartyName(SheetName);

			// click on reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(partyNameTxtBox).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterPartyName function to enter filter screen details
			enterPartyName(SheetName);

			// click on ok button on filter screen
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrecr");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (miscellaneousConfirmDeleteScreen_Rec.isDisplayed()) {
						elementutil.clickElement(miscellaneousConfirmDeleteScreen_Rec);
						if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
								.equals(partyName.trim().toString())) {

							// Note: Commented as cancel button not working properly getting 404: Resource
							// not found message
							// click on cancel button
							/*
							 * elementutil.clickElement(btnCancel);
							 * 
							 * if(elementutil.getText(errormessages).trim().toString().
							 * equals("Operation Cancelled".trim().toString())) {
							 * log.info("Cancel Button Is Working fine");
							 * 
							 * } else { log.error("Cancel Button Is Not Working Fine"); }//end of else
							 * 
							 * //enter details on filter screen enterPartyName(SheetName, Row);
							 * 
							 * //click on ok button elementutil.clickElement(okBtn);
							 */

							// click on ConfirmDelete button
							elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);

						} // end of if
						else {
							log.info("Record Mismatch, Record With Template Code " + partyName + " Not Found");
						} // end of else
					} // end of if

				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(partyName.trim().toString())) {

						// Note: Commented as cancel button not working properly getting 404: Resource
						// not found message
						// click on cancel button
						/*
						 * elementutil.clickElement(btnCancel);
						 * 
						 * if(elementutil.getText(errormessages).trim().toString().
						 * equals("Operation Cancelled".trim().toString())) {
						 * log.info("Cancel Button Is Working fine");
						 * 
						 * } else { log.error("Cancel Button Is Not Working Fine"); }//end of else
						 * 
						 * //enter details on filter screen enterPartyName(SheetName, Row);
						 * 
						 * //click on ok button elementutil.clickElement(okBtn);
						 */

						// click on ConfirmDelete button
						elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + partyName + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
		// commented due to list screen filter issue
		// elementutil.handlewin1(driver);

	}// end of miscellaneousConfirmDeleteScreen function

	// ----------------------Method to Modify the Miscellaneous Record-------------
	public void modifyMiscellaneousRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalTemplateCode = map.get("Original Template Code");
			String modifiedTemplateCode = map.get("TemplateCode");
			String Acronym = map.get("Acronym");
			String ACHCreditSend = map.get("ACHCreditSend");
			String ACHCreditReturn = map.get("ACHCreditReturn");
			String ACHDebitSend = map.get("ACHDebitSend");
			String ECSCreditSend = map.get("ECSCreditSend");
			String ECSCreditRetrun = map.get("ECSCreditRetrun");
			String ECSDebitSend = map.get("ECSDebitSend");
			String APBSCreditSend = map.get("APBSCreditSend");
			String APBSCreditRetrun = map.get("APBSCreditRetrun");
			String ACHCreditFile = map.get("ACHCreditFile");
			String ACHCreditAutoSettlementDate = map.get("ACHCreditAutoSettlementDate");
			String ACHDebitFile = map.get("ACHDebitFile");
			String ECSCreditFile = map.get("ECSCreditFile");
			String ECSCreditAutoSettlementDate = map.get("ECSCreditAutoSettlementDate");
			String ECSDebitFile = map.get("ECSDebitFile");
			String APBSCreditFile = map.get("APBSCreditFile");
			String MMSSpecialCustomer = map.get("MMS Special Customer");
			String MandateDestination = map.get("Mandate Destination");
			String DebitTransactionAutoRepresentation = map.get("Debit Transaction Auto-presentation(on Cycle Date)");
			String ReportGenerationReq = map.get("Report Generation Required");
			String MMSCustomerCycleDates = map.get("MMS Customer Cycle Date");
			String CycleDateISEOM = map.get("Cycle Date is End of Month");
			String PostponeCycleDate = map.get("Postpone Cycle Date");
			String NoOFDaysForDebitTransaction = map.get("Number of Days for Debit Transaction");
			String NoOfDaysForReportGeneration = map.get("Number of Days for Report");
			String NoOfDaysForPosting = map.get("Number of Days for Posting");
			String IsH2HUser = map.get("Is H2H User");
			String EnableAutoMIS = map.get("Enable AutoMIS");
			String SelectAutoMISFor = map.get("Select AutoMIS For");
			String FrequencyForMandateMISInDays = map.get("Frequency For Mandate MIS in days");
			String FrequencyForTransactionMISInDays = map.get("Frequency For Transaction MIS in days");
			String MISTypeTransaction = map.get("MIS Type Transaction");
			String MISTypeMandate = map.get("MIS Type Mandate");
			String MISStatusForTransaction = map.get("MIS Status For Transaction");
			String MISStatusForMandate = map.get("MIS Status For Mandate");

			// enter details on filter screen
			elementutil.enterText(partyNameTxtBox, originalTemplateCode);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(partyNameTxtBox).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details on filter screen
			elementutil.enterText(partyNameTxtBox, originalTemplateCode);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With Party Name " + originalTemplateCode + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + originalTemplateCode + " Not Found");
					log.error("No Records available for Modify operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {// *[@id="pageBody"]/p
				if (elementutil.getText(miscellaneousScreenLabels).trim().toString()
						.equals("Modify".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(originalTemplateCode.trim().toString())) {
						// click on ok button on modify screen
						elementutil.clickElement(okBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details on filter screen
						elementutil.enterText(partyNameTxtBox, originalTemplateCode);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						elementutil.clickElement(screenRecord);

						// move to insertMiscellaneousRecordDetailsforModify to insert details for first
						// time
//					insertMiscellaneousRecordDetailsforModify(SheetName);

						elementutil.SHORT_TIMEOUT();

						elementutil.clearText(templateCodeTextField);
						elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.enterText(acronymfieldTxtBox, Acronym);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						// click on "OK" button
						elementutil.clickElement(miscellaneousBtnOk);

						try {
							if (elementutil.getText(errormessages).equals("Duplicate Record".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} // end of if
							else {
								log.error(
										"Data Provided For Modify operation Is Not As Per Valid Format OR Duplicate Record Validation Message displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e2) {
							// click on back button
							elementutil.clickElement(btnBack);

							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working fine");
							} // end of else

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on ModifyConfirm button
							elementutil.clickElement(modifyScreenModifyConfirmBtn);
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Expected Record With Template Code " + originalTemplateCode
								+ " Not Found");
					} // end of else
				} // end if if
				else {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(originalTemplateCode.trim().toString())) {
						// click on ok button on modify screen
						elementutil.clickElement(okBtn);

						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details on filter screen
						elementutil.enterText(partyNameTxtBox, originalTemplateCode);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						// move to insertMiscellaneousRecordDetailsforModify to insert details for first
						// time
//					insertMiscellaneousRecordDetailsforModify(SheetName, Row);

						elementutil.SHORT_TIMEOUT();

						elementutil.clearText(templateCodeTextField);
						elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.enterText(acronymfieldTxtBox, Acronym);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						// click on "OK" button
						elementutil.clickElement(miscellaneousBtnOk);

						try {
							if (elementutil.getText(errormessages).equals("Duplicate Record".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} // end of if
							else {
								log.error(
										"Data Provided For Modify operation Is Not As Per Valid Format OR Duplicate Record Validation Message displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e3) {
							// click on back button
							elementutil.clickElement(btnBack);

							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working fine");
							} // end of else

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on ModifyConfirm button
							elementutil.clickElement(modifyScreenModifyConfirmBtn);
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Expected Record With Template Code " + originalTemplateCode
								+ " Not Found");
					} // end of else
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of miscellaneousAddFilterScreen function

	// ----------------------Method to Modify the Miscellaneous Record With Invalid
	// Data---------------------------------------------------
	public void modifyMiscellaneousRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalTemplateCode = map.get("Original Template Code");
			String modifiedTemplateCode = map.get("TemplateCode");
			String Acronym = map.get("Acronym");
			String ACHCreditSend = map.get("ACHCreditSend");
			String ACHCreditReturn = map.get("ACHCreditReturn");
			String ACHDebitSend = map.get("ACHDebitSend");
			String ECSCreditSend = map.get("ECSCreditSend");
			String ECSCreditRetrun = map.get("ECSCreditRetrun");
			String ECSDebitSend = map.get("ECSDebitSend");
			String APBSCreditSend = map.get("APBSCreditSend");
			String APBSCreditRetrun = map.get("APBSCreditRetrun");
			String ACHCreditFile = map.get("ACHCreditFile");
			String ACHCreditAutoSettlementDate = map.get("ACHCreditAutoSettlementDate");
			String ACHDebitFile = map.get("ACHDebitFile");
			String ECSCreditFile = map.get("ECSCreditFile");
			String ECSCreditAutoSettlementDate = map.get("ECSCreditAutoSettlementDate");
			String ECSDebitFile = map.get("ECSDebitFile");
			String APBSCreditFile = map.get("APBSCreditFile");
			String MMSSpecialCustomer = map.get("MMS Special Customer");
			String MandateDestination = map.get("Mandate Destination");
			String DebitTransactionAutoRepresentation = map.get("Debit Transaction Auto-presentation(on Cycle Date)");
			String ReportGenerationReq = map.get("Report Generation Required");
			String MMSCustomerCycleDates = map.get("MMS Customer Cycle Date");
			String CycleDateISEOM = map.get("Cycle Date is End of Month");
			String PostponeCycleDate = map.get("Postpone Cycle Date");
			String NoOFDaysForDebitTransaction = map.get("Number of Days for Debit Transaction");
			String NoOfDaysForReportGeneration = map.get("Number of Days for Report");
			String NoOfDaysForPosting = map.get("Number of Days for Posting");
			String IsH2HUser = map.get("Is H2H User");
			String EnableAutoMIS = map.get("Enable AutoMIS");
			String SelectAutoMISFor = map.get("Select AutoMIS For");
			String FrequencyForMandateMISInDays = map.get("Frequency For Mandate MIS in days");
			String FrequencyForTransactionMISInDays = map.get("Frequency For Transaction MIS in days");
			String MISTypeTransaction = map.get("MIS Type Transaction");
			String MISTypeMandate = map.get("MIS Type Mandate");
			String MISStatusForTransaction = map.get("MIS Status For Transaction");
			String MISStatusForMandate = map.get("MIS Status For Mandate");

			// enter party name value
			elementutil.enterText(partyNameTxtBox, originalTemplateCode);

			// click on ok button on filter screen
			elementutil.clickElement(AllFilterScreenOKBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With Party Name " + originalTemplateCode + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + originalTemplateCode + " Not Found");
					log.error("No Records available for Modify operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(miscellaneousScreenLabels).trim().toString()
						.equals("Modify".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(originalTemplateCode.trim().toString())) {
						// move to insertMiscellaneousRecordDetailsforModify to insert details for first
						// time
//					insertMiscellaneousRecordDetailsforModify_InvalidData(SheetName, Row);
						elementutil.clearText(templateCodeTextField);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, "");
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, "");
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						// click on ok button
						elementutil.clickElement(okBtn);

						String expectedMandatoryFieldValidationMessage = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
								+ "Invalid input for ECS Credit File\n" + "Invalid input for ECS Debit File\n"
								+ "Invalid input for APBS Credit File";

						if (elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldValidationMessage.trim().toString())) {
							log.info("Mandatory Field Validation Message Displayed Is Correct");
						} // end of if
						else {
							log.error("Mandatory Field Validation Message Displayed Is Incorrect");
						}

						elementutil.clearText(templateCodeTextField);
						elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.enterText(acronymfieldTxtBox, Acronym);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						elementutil.clickElement(okBtn);

						String expectedInvalidFieldMessage1 = "Invalid input for ACH Credit File\n"
								+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File\n"
								+ "Invalid input for ECS Debit File\n" + "Invalid input for APBS Credit File";
						String expectedInvalidFieldMessage2 = "Invalid Miscellaneous Code";
						String expectedInvalidFieldMessage3 = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
								+ "Invalid input for ECS Credit File";
						String expectedInvalidFieldMessage4 = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File";
						try {
							String actualMiscellaneousScreenMessage = elementutil.getText(errormessages);
							boolean FieldWiseInvalidMessageRes = checkSubstring(actualMiscellaneousScreenMessage,
									expectedMandatoryFieldValidationMessage);

							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedInvalidFieldMessage1.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage2.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedMandatoryFieldValidationMessage.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage3.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage4.trim().toString())
									|| FieldWiseInvalidMessageRes == true) {
								log.info("Field Wise Invalid Data Validation Message displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("Duplicate Record".trim().toString())) {
								log.info(
										"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With Template Code "
												+ modifiedTemplateCode + " Found");
							} else {
								log.error("Field Wise Invalid Data Validation Message displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e1) {
							log.info("Test Data Provided Was Not Invalid");
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + originalTemplateCode + " Not found");
					} // end of else

				} // end of if
				else {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(originalTemplateCode.trim().toString())) {
						// move to insertMiscellaneousRecordDetailsforModify to insert details for first
						// time
//					insertMiscellaneousRecordDetailsforModify_InvalidData(SheetName, Row);
						elementutil.clearText(templateCodeTextField);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, "");
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, "");
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, "");
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						// click on ok button
						elementutil.clickElement(okBtn);

						String expectedMandatoryFieldValidationMessage = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
								+ "Invalid input for ECS Credit File\n" + "Invalid input for ECS Debit File\n"
								+ "Invalid input for APBS Credit File";

						if (elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldValidationMessage.trim().toString())) {
							log.info("Mandatory Field Validation Message Displayed Is Correct");
						} // end of if
						else {
							log.error("Mandatory Field Validation Message Displayed Is Incorrect");
						}

						elementutil.clearText(templateCodeTextField);
						elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
						elementutil.clearText(acronymfieldTxtBox);
						elementutil.enterText(acronymfieldTxtBox, Acronym);
						elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
						elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
						elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
						elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
						elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
						elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
						elementutil.SHORT_TIMEOUT();
						elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
						elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown,
								ACHCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
						elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
						elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown,
								ECSCreditAutoSettlementDate);
						elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
						elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
						elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
						elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
						elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
								DebitTransactionAutoRepresentation);
						elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
						elementutil.clearText(mmsCustCycleDateTxtBox);
						elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
						elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
						elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
						elementutil.clearText(noofDaysForDebitTranTxtBox);
						elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
						elementutil.clearText(noOfDaysForReport);
						elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
						elementutil.clearText(noOfDaysForPostingTxtBox);
						elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
						elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
						elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
						elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
						elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
						elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
						elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
						elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
						elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
						elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
						elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
						elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

						elementutil.clickElement(okBtn);

						String expectedInvalidFieldMessage1 = "Invalid input for ACH Credit File\n"
								+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File\n"
								+ "Invalid input for ECS Debit File\n" + "Invalid input for APBS Credit File";
						String expectedInvalidFieldMessage2 = "Invalid Miscellaneous Code";
						String expectedInvalidFieldMessage3 = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
								+ "Invalid input for ECS Credit File";
						String expectedInvalidFieldMessage4 = "Invalid Miscellaneous Code\n"
								+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File";
						try {
							String actualMiscellaneousScreenMessage = elementutil.getText(errormessages);
							boolean FieldWiseInvalidMessageRes = checkSubstring(actualMiscellaneousScreenMessage,
									expectedMandatoryFieldValidationMessage);

							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedInvalidFieldMessage1.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage2.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedMandatoryFieldValidationMessage.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage3.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedInvalidFieldMessage4.trim().toString())
									|| FieldWiseInvalidMessageRes == true) {
								log.info("Field Wise Invalid Data Validation Message displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("Duplicate Record".trim().toString())) {
								log.info(
										"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With Template Code "
												+ modifiedTemplateCode + " Found");
							} else {
								log.error("Field Wise Invalid Data Validation Message displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e1) {
							log.info("Test Data Provided Was Not Invalid");
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + originalTemplateCode + " Not found");
					} // end of else
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of miscellaneousModifyRecord_InvalidData function

	// ---------------Method to perform Cancel Delete Action on Miscellaneous
	// Record-----------
	public void miscellaneousCancelDeleteAction(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String partyName = map.get("Party Name");

			// fetch values
			enterPartyName(SheetName);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (miscellaneousConfirmDeleteScreen_Rec.isDisplayed()) {
						// click on screen record
						elementutil.clickElement(miscellaneousConfirmDeleteScreen_Rec);
						// click on "Cancel Delete Action" button
						elementutil.clickElement(cancelDeleteActionBtn);
					}
				} catch (NoSuchElementException e2) {
					// click on "Cancel Delete Action" button
					elementutil.clickElement(cancelDeleteActionBtn);
				} // end of catch

			} // end of catch

			// commented due to list screen filter issue
			// elementutil.handlewin1(driver);
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of miscellaneousCancelDeleteAction function

	// -----------Method for Cancel Modify Action button to cancel addition of
	// record-------------
	public void miscellaneousCancelModifyAction(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String partyName = map.get("Party Name");

			enterPartyName(SheetName);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Party Name " + partyName + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getText(miscellaneousScreenLabels).trim().toString()
						.equals("Approve".trim().toString())) {
					elementutil.clickElement(screenRecord);
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(partyName.trim().toString())) {
						// click on CanceModifyAction Button
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + partyName + " Not found");
					} // end of else

				} // end of if
				else {
					if (elementutil.getAttribute(miscellaneousScreenTemplateCodeValue).trim().toString()
							.equals(partyName.trim().toString())) {
						// click on CanceModifyAction Button
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Template Code " + partyName + " Not found");
					} // end of else
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
		// commented due to list screen filter issue
		// elementutil.handlewin1(driver);
	}// end of miscellaneousCancelModifyActionforAddedRecord function

	// Method for Modify filter screen to enter Party Name Details
	public void enterPartyName(String templateCode) throws InvalidFormatException, IOException {
		// fetch values
//		test_Data = fileReader.readCorporateCMSExcel(SheetName);
//		String partyName = test_Data.get(Row).get("Party Name");

		elementutil.enterText(partyNameTxtBox, templateCode);

	}// end of enterPartyName function

	// ----------------- Method for adding Miscellaneous With Invalid
	// Data---------------------------------
	public void miscellaneousAddRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String templateCode = map.get("TemplateCode");
			String Acronym = map.get("Acronym");
			String ACHCreditSend = map.get("ACHCreditSend");
			String ACHCreditReturn = map.get("ACHCreditReturn");
			String ACHDebitSend = map.get("ACHDebitSend");
			String ECSCreditSend = map.get("ECSCreditSend");
			String ECSCreditRetrun = map.get("ECSCreditRetrun");
			String ECSDebitSend = map.get("ECSDebitSend");
			String APBSCreditSend = map.get("APBSCreditSend");
			String APBSCreditRetrun = map.get("APBSCreditRetrun");
			String ACHCreditFile = map.get("ACHCreditFile");
			String ACHCreditAutoSettlementDate = map.get("ACHCreditAutoSettlementDate");
			String ACHDebitFile = map.get("ACHDebitFile");
			String ECSCreditFile = map.get("ECSCreditFile");
			String ECSCreditAutoSettlementDate = map.get("ECSCreditAutoSettlementDate");
			String ECSDebitFile = map.get("ECSDebitFile");
			String APBSCreditFile = map.get("APBSCreditFile");
			String MMSSpecialCustomer = map.get("MMS Special Customer");
			String MandateDestination = map.get("Mandate Destination");
			String DebitTransactionAutoRepresentation = map.get("Debit Transaction Auto-presentation(on Cycle Date)");
			String ReportGenerationReq = map.get("Report Generation Required");
			String MMSCustomerCycleDates = map.get("MMS Customer Cycle Date");
			String CycleDateISEOM = map.get("Cycle Date is End of Month");
			String PostponeCycleDate = map.get("Postpone Cycle Date");
			String NoOFDaysForDebitTransaction = map.get("Number of Days for Debit Transaction");
			String NoOfDaysForReportGeneration = map.get("Number of Days for Report");
			String NoOfDaysForPosting = map.get("Number of Days for Posting");
			String IsH2HUser = map.get("Is H2H User");
			String EnableAutoMIS = map.get("Enable AutoMIS");
			String SelectAutoMISFor = map.get("Select AutoMIS For");
			String FrequencyForMandateMISInDays = map.get("Frequency For Mandate MIS in days");
			String FrequencyForTransactionMISInDays = map.get("Frequency For Transaction MIS in days");
			String MISTypeTransaction = map.get("MIS Type Transaction");
			String MISTypeMandate = map.get("MIS Type Mandate");
			String MISStatusForTransaction = map.get("MIS Status For Transaction");
			String MISStatusForMandate = map.get("MIS Status For Mandate");

			// click on ok button
			elementutil.clickElement(okBtn);

			String expectedMiscellaneousScreenMessage = "Invalid Miscellaneous Code\n"
					+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
					+ "Invalid input for ECS Credit File\n" + "Invalid input for ECS Debit File\n"
					+ "Invalid input for APBS Credit File";

			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedMiscellaneousScreenMessage.trim().toString())) {
				log.info("Mandatory Field Validation Message Displayed Is Correct");
			} // end of if
			else {
				log.error("Mandatory Field Validation Message displayed Is Incorrect");
			} // end of else

			// enter all details on screen from sheet
			elementutil.enterText(templateCodeTextField, templateCode);
			elementutil.enterText(acronymfieldTxtBox, Acronym);
			elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
			elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
			elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
			elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
			elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
			elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
			elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
			elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
			elementutil.SHORT_TIMEOUT();
			elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
			elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown, ACHCreditAutoSettlementDate);
			elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
			elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
			elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown, ECSCreditAutoSettlementDate);
			elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
			elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
			elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
			elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
			elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
					DebitTransactionAutoRepresentation);
			elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
			elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
			elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
			elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
			elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
			elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
			elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
			elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
			elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
			elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
			elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
			elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
			elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
			elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
			elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
			elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

			// click on "ok" button
			elementutil.clickElement(miscellaneousBtnOk);

			String expectedInvalidDataMessage1 = "Invalid input for ACH Credit File\n"
					+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File\n"
					+ "Invalid input for ECS Debit File\n" + "Invalid input for APBS Credit File";
			String expectedInvalidDataMessage2 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File\n"
					+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File\n"
					+ "Invalid input for ECS Debit File\n" + "Invalid input for APBS Credit File";
			String expectedInvalidDataMessage3 = "Invalid Miscellaneous Code";
			String expectedInvalidDataMessage4 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File";
			String expectedInvalidDataMessage5 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File\n"
					+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File";
			String expectedInvalidDataMessage6 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File\n"
					+ "Invalid input for ACH Debit File";

			try {
				String actualMiscellaneousScreenMessage = elementutil.getText(errormessages);
				boolean FieldWiseInvalidMessageRes = checkSubstring(actualMiscellaneousScreenMessage,
						expectedMiscellaneousScreenMessage);

				if (elementutil.getText(errormessages).trim().toString()
						.equals(expectedInvalidDataMessage1.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidDataMessage2.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidDataMessage3.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidDataMessage4.trim().toString())
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidDataMessage5.trim().toString())
						|| elementutil.getText(errormessages).trim().toString().equals(
								expectedInvalidDataMessage6.trim().toString())
						|| FieldWiseInvalidMessageRes == true) {
					log.info("Field Wise Invalid Data Valiation Message Displayed Is Correct");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("Duplicate Record".trim().toString())) {
					log.info(
							"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With Template Code"
									+ templateCode + " Found");
				} // end of else if
				else {
					log.error("Field Wise Invalid Data Valiation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Was Not Invalid");
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of miscellaneousAddFilterScreen function

	// ------------------------Method to enter modified record details on
	// Miscellaneous->Modify screen-------------------
	/*
	 * Method Description:- insertMiscellaneousRecordDetailsforModify Method is used
	 * to avoid the duplicacy of details fetching and entering on screen As after
	 * clicking on Cancel button on Miscellaneous->Modify screen again fetching and
	 * entering of details need to be done hence this method is used as this is
	 * written once once and can be invoked no. of times
	 */
	public void insertMiscellaneousRecordDetailsforModify(String SheetName, int Row)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch values
		test_Data = fileReader.readCorporateCMSExcel(SheetName);

		String modifiedTemplateCode = test_Data.get(Row).get("TemplateCode");
		String Acronym = test_Data.get(Row).get("Acronym");
		String ACHCreditSend = test_Data.get(Row).get("ACHCreditSend");
		String ACHCreditReturn = test_Data.get(Row).get("ACHCreditReturn");
		String ACHDebitSend = test_Data.get(Row).get("ACHDebitSend");
		String ECSCreditSend = test_Data.get(Row).get("ECSCreditSend");
		String ECSCreditRetrun = test_Data.get(Row).get("ECSCreditRetrun");
		String ECSDebitSend = test_Data.get(Row).get("ECSDebitSend");
		String APBSCreditSend = test_Data.get(Row).get("APBSCreditSend");
		String APBSCreditRetrun = test_Data.get(Row).get("APBSCreditRetrun");
		String ACHCreditFile = test_Data.get(Row).get("ACHCreditFile");
		String ACHCreditAutoSettlementDate = test_Data.get(Row).get("ACHCreditAutoSettlementDate");
		String ACHDebitFile = test_Data.get(Row).get("ACHDebitFile");
		String ECSCreditFile = test_Data.get(Row).get("ECSCreditFile");
		String ECSCreditAutoSettlementDate = test_Data.get(Row).get("ECSCreditAutoSettlementDate");
		String ECSDebitFile = test_Data.get(Row).get("ECSDebitFile");
		String APBSCreditFile = test_Data.get(Row).get("APBSCreditFile");
		String MMSSpecialCustomer = test_Data.get(Row).get("MMS Special Customer");
		String MandateDestination = test_Data.get(Row).get("Mandate Destination");
		String DebitTransactionAutoRepresentation = test_Data.get(Row)
				.get("Debit Transaction Auto-presentation(on Cycle Date)");
		String ReportGenerationReq = test_Data.get(Row).get("Report Generation Required");
		String MMSCustomerCycleDates = test_Data.get(Row).get("MMS Customer Cycle Date");
		String CycleDateISEOM = test_Data.get(Row).get("Cycle Date is End of Month");
		String PostponeCycleDate = test_Data.get(Row).get("Postpone Cycle Date");
		String NoOFDaysForDebitTransaction = test_Data.get(Row).get("Number of Days for Debit Transaction");
		String NoOfDaysForReportGeneration = test_Data.get(Row).get("Number of Days for Report");
		String NoOfDaysForPosting = test_Data.get(Row).get("Number of Days for Posting");
		String IsH2HUser = test_Data.get(Row).get("Is H2H User");
		String EnableAutoMIS = test_Data.get(Row).get("Enable AutoMIS");
		String SelectAutoMISFor = test_Data.get(Row).get("Select AutoMIS For");
		String FrequencyForMandateMISInDays = test_Data.get(Row).get("Frequency For Mandate MIS in days");
		String FrequencyForTransactionMISInDays = test_Data.get(Row).get("Frequency For Transaction MIS in days");
		String MISTypeTransaction = test_Data.get(Row).get("MIS Type Transaction");
		String MISTypeMandate = test_Data.get(Row).get("MIS Type Mandate");
		String MISStatusForTransaction = test_Data.get(Row).get("MIS Status For Transaction");
		String MISStatusForMandate = test_Data.get(Row).get("MIS Status For Mandate");

		elementutil.SHORT_TIMEOUT();

		elementutil.clearText(templateCodeTextField);
		elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
		elementutil.clearText(acronymfieldTxtBox);
		elementutil.enterText(acronymfieldTxtBox, Acronym);
		elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
		elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
		elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
		elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
		elementutil.SHORT_TIMEOUT();
		elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
		elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown, ACHCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
		elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
		elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown, ECSCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
		elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
		elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
		elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
		elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
				DebitTransactionAutoRepresentation);
		elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
		elementutil.clearText(mmsCustCycleDateTxtBox);
		elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
		elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
		elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
		elementutil.clearText(noofDaysForDebitTranTxtBox);
		elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
		elementutil.clearText(noOfDaysForReport);
		elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
		elementutil.clearText(noOfDaysForPostingTxtBox);
		elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
		elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
		elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
		elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
		elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
		elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
		elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
		elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
		elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
		elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
		elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
		elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

	}// end of insertMiscellaneousRecordDetailsforModify function

	// -------------------Method to insert invalid record details for miscellaneous
	// Modify screen--------------------
	public void insertMiscellaneousRecordDetailsforModify_InvalidData(String SheetName, int Row)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch values
		test_Data = fileReader.readCorporateCMSExcel(SheetName);

		String modifiedTemplateCode = test_Data.get(Row).get("TemplateCode");
		String Acronym = test_Data.get(Row).get("Acronym");
		String ACHCreditSend = test_Data.get(Row).get("ACHCreditSend");
		String ACHCreditReturn = test_Data.get(Row).get("ACHCreditReturn");
		String ACHDebitSend = test_Data.get(Row).get("ACHDebitSend");
		String ECSCreditSend = test_Data.get(Row).get("ECSCreditSend");
		String ECSCreditRetrun = test_Data.get(Row).get("ECSCreditRetrun");
		String ECSDebitSend = test_Data.get(Row).get("ECSDebitSend");
		String APBSCreditSend = test_Data.get(Row).get("APBSCreditSend");
		String APBSCreditRetrun = test_Data.get(Row).get("APBSCreditRetrun");
		String ACHCreditFile = test_Data.get(Row).get("ACHCreditFile");
		String ACHCreditAutoSettlementDate = test_Data.get(Row).get("ACHCreditAutoSettlementDate");
		String ACHDebitFile = test_Data.get(Row).get("ACHDebitFile");
		String ECSCreditFile = test_Data.get(Row).get("ECSCreditFile");
		String ECSCreditAutoSettlementDate = test_Data.get(Row).get("ECSCreditAutoSettlementDate");
		String ECSDebitFile = test_Data.get(Row).get("ECSDebitFile");
		String APBSCreditFile = test_Data.get(Row).get("APBSCreditFile");
		String MMSSpecialCustomer = test_Data.get(Row).get("MMS Special Customer");
		String MandateDestination = test_Data.get(Row).get("Mandate Destination");
		String DebitTransactionAutoRepresentation = test_Data.get(Row)
				.get("Debit Transaction Auto-presentation(on Cycle Date)");
		String ReportGenerationReq = test_Data.get(Row).get("Report Generation Required");
		String MMSCustomerCycleDates = test_Data.get(Row).get("MMS Customer Cycle Date");
		String CycleDateISEOM = test_Data.get(Row).get("Cycle Date is End of Month");
		String PostponeCycleDate = test_Data.get(Row).get("Postpone Cycle Date");
		String NoOFDaysForDebitTransaction = test_Data.get(Row).get("Number of Days for Debit Transaction");
		String NoOfDaysForReportGeneration = test_Data.get(Row).get("Number of Days for Report");
		String NoOfDaysForPosting = test_Data.get(Row).get("Number of Days for Posting");
		String IsH2HUser = test_Data.get(Row).get("Is H2H User");
		String EnableAutoMIS = test_Data.get(Row).get("Enable AutoMIS");
		String SelectAutoMISFor = test_Data.get(Row).get("Select AutoMIS For");
		String FrequencyForMandateMISInDays = test_Data.get(Row).get("Frequency For Mandate MIS in days");
		String FrequencyForTransactionMISInDays = test_Data.get(Row).get("Frequency For Transaction MIS in days");
		String MISTypeTransaction = test_Data.get(Row).get("MIS Type Transaction");
		String MISTypeMandate = test_Data.get(Row).get("MIS Type Mandate");
		String MISStatusForTransaction = test_Data.get(Row).get("MIS Status For Transaction");
		String MISStatusForMandate = test_Data.get(Row).get("MIS Status For Mandate");

		elementutil.clearText(templateCodeTextField);
		elementutil.clearText(acronymfieldTxtBox);
		elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
		elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
		elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
		elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
		elementutil.SHORT_TIMEOUT();
		elementutil.selectDropDownByVisibleText(achCreditFileDropDown, "");
		elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown, ACHCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(achDebitFileDropDown, "");
		elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, "");
		elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown, ECSCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, "");
		elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, "");
		elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
		elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
		elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
				DebitTransactionAutoRepresentation);
		elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
		elementutil.clearText(mmsCustCycleDateTxtBox);
		elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
		elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
		elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
		elementutil.clearText(noofDaysForDebitTranTxtBox);
		elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
		elementutil.clearText(noOfDaysForReport);
		elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
		elementutil.clearText(noOfDaysForPostingTxtBox);
		elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
		elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
		elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
		elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
		elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
		elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
		elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
		elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
		elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
		elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
		elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
		elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

		// click on ok button
		elementutil.clickElement(okBtn);

		String expectedMandatoryFieldValidationMessage = "Invalid Miscellaneous Code\n"
				+ "Invalid input for ACH Credit File\n" + "Invalid input for ACH Debit File\n"
				+ "Invalid input for ECS Credit File\n" + "Invalid input for ECS Debit File\n"
				+ "Invalid input for APBS Credit File";

		if (elementutil.getText(errormessages).trim().toString()
				.equals(expectedMandatoryFieldValidationMessage.trim().toString())) {
			log.info("Mandatory Field Validation Message Displayed Is Correct");
		} // end of if
		else {
			log.error("Mandatory Field Validation Message Displayed Is Incorrect");
		}

		elementutil.clearText(templateCodeTextField);
		elementutil.enterText(templateCodeTextField, modifiedTemplateCode);
		elementutil.clearText(acronymfieldTxtBox);
		elementutil.enterText(acronymfieldTxtBox, Acronym);
		elementutil.selectDropDownByVisibleText(achCrSendAccountingDropDown, ACHCreditSend);
		elementutil.selectDropDownByVisibleText(achCrSendReturnAccountingDropDown, ACHCreditReturn);
		elementutil.selectDropDownByVisibleText(achDrSendReturnAccountingDropDown, ACHDebitSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendAccountingDropDown, ECSCreditSend);
		elementutil.selectDropDownByVisibleText(ecsCrSendReturnAccountingDropDown, ECSCreditRetrun);
		elementutil.selectDropDownByVisibleText(ecsDrSendReturnAccountingDropDown, ECSDebitSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendAccountingDropDown, APBSCreditSend);
		elementutil.selectDropDownByVisibleText(apbsCrSendReturnAccountingDropDown, APBSCreditRetrun);
		elementutil.SHORT_TIMEOUT();
		elementutil.selectDropDownByVisibleText(achCreditFileDropDown, ACHCreditFile);
		elementutil.selectDropDownByVisibleText(achCrAutoSettlementDateDropDown, ACHCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(achDebitFileDropDown, ACHDebitFile);
		elementutil.selectDropDownByVisibleText(ecsCreditFileDropDown, ECSCreditFile);
		elementutil.selectDropDownByVisibleText(ecsCreditAutoSettlementDateDropDown, ECSCreditAutoSettlementDate);
		elementutil.selectDropDownByVisibleText(ecsDebitFileDropDown, ECSDebitFile);
		elementutil.selectDropDownByVisibleText(apbsCreditFileDropDown, APBSCreditFile);
		elementutil.selectDropDownByVisibleText(MMSSpecialCustomerDropDown, MMSSpecialCustomer);
		elementutil.selectDropDownByVisibleText(mandateDestinationDropDown, MandateDestination);
		elementutil.selectDropDownByVisibleText(debitTransactionAutoRepresentationDropDown,
				DebitTransactionAutoRepresentation);
		elementutil.selectDropDownByVisibleText(reportGenerationRequiredDropDown, ReportGenerationReq);
		elementutil.clearText(mmsCustCycleDateTxtBox);
		elementutil.enterText(mmsCustCycleDateTxtBox, MMSCustomerCycleDates);
		elementutil.selectDropDownByVisibleText(cycleDateISEOMDropDown, CycleDateISEOM);
		elementutil.selectDropDownByVisibleText(postponeCycleDateDropDown, PostponeCycleDate);
		elementutil.clearText(noofDaysForDebitTranTxtBox);
		elementutil.enterText(noofDaysForDebitTranTxtBox, NoOFDaysForDebitTransaction);
		elementutil.clearText(noOfDaysForReport);
		elementutil.enterText(noOfDaysForReport, NoOfDaysForReportGeneration);
		elementutil.clearText(noOfDaysForPostingTxtBox);
		elementutil.enterText(noOfDaysForPostingTxtBox, NoOfDaysForPosting);
		elementutil.selectDropDownByVisibleText(isH2HUserDropDown, IsH2HUser);
		elementutil.selectDropDownByVisibleText(enableAutomMISDropDown, EnableAutoMIS);
		elementutil.selectDropDownByVisibleText(selectAtuoMISForDropDown, SelectAutoMISFor);
		elementutil.clearText(frequencyforMandateMISInDaysTxtBox);
		elementutil.enterText(frequencyforMandateMISInDaysTxtBox, FrequencyForMandateMISInDays);
		elementutil.clearText(frequencyforTransactionMISInDaysTxtBox);
		elementutil.enterText(frequencyforTransactionMISInDaysTxtBox, FrequencyForTransactionMISInDays);
		elementutil.selectDropDownByVisibleText(misTypeTransactionDropDown, MISTypeTransaction);
		elementutil.selectDropDownByVisibleText(misTypeMandateDropDown, MISTypeMandate);
		elementutil.selectDropDownByVisibleText(misStatusForTransaction, MISStatusForTransaction);
		elementutil.selectDropDownByVisibleText(misStatusforMandate, MISStatusForMandate);

		elementutil.clickElement(okBtn);

		String expectedInvalidFieldMessage1 = "Invalid input for ACH Credit File\n"
				+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File\n"
				+ "Invalid input for ECS Debit File\n" + "Invalid input for APBS Credit File";
		String expectedInvalidFieldMessage2 = "Invalid Miscellaneous Code";
		String expectedInvalidFieldMessage3 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File\n"
				+ "Invalid input for ACH Debit File\n" + "Invalid input for ECS Credit File";
		String expectedInvalidFieldMessage4 = "Invalid Miscellaneous Code\n" + "Invalid input for ACH Credit File\n"
				+ "Invalid input for ACH Debit File";
		try {
			String actualMiscellaneousScreenMessage = elementutil.getText(errormessages);
			boolean FieldWiseInvalidMessageRes = checkSubstring(actualMiscellaneousScreenMessage,
					expectedMandatoryFieldValidationMessage);

			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedInvalidFieldMessage1.trim().toString())
					|| elementutil.getText(errormessages).trim().toString()
							.equals(expectedInvalidFieldMessage2.trim().toString())
					|| elementutil.getText(errormessages).trim().toString()
							.equals(expectedMandatoryFieldValidationMessage.trim().toString())
					|| elementutil.getText(errormessages).trim().toString()
							.equals(expectedInvalidFieldMessage3.trim().toString())
					|| elementutil.getText(errormessages).trim().toString().equals(
							expectedInvalidFieldMessage4.trim().toString())
					|| FieldWiseInvalidMessageRes == true) {
				log.info("Field Wise Invalid Data Validation Message displayed Is Correct");
			} // end of if
			else if (elementutil.getText(errormessages).trim().toString()
					.equals("Duplicate Record".trim().toString())) {
				log.info(
						"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With Template Code "
								+ modifiedTemplateCode + " Found");
			} else {
				log.error("Field Wise Invalid Data Validation Message displayed Is Incorrect");
			} // end of else
		} catch (NoSuchElementException e) {
			log.info("Test Data Provided Was Not Invalid");
		} // end of catch
	}// end of insertMiscellaneousRecordDetailsforModify_Invalidata function

	// ---------------------------RELATIONSHIP MANAGER MENU
	// METHODS-------------------------------------------

	// ------------------------METHOD TO ADD RELATIONSHIPMANAGER
	// RECORD----------------------------
	public void addRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String Name = map.get("Name");
			String EmaiId = map.get("Email Id");
			String PhoneNo = map.get("Phone No");
			String Remarks = map.get("Remarks");

			// enter valid details
			elementutil.enterText(rmCodeTxtField, rmCode);
			elementutil.enterText(relationshipManagerNameTxtField, Name);
			elementutil.enterText(emailIdTxtField, EmaiId);
			elementutil.enterText(phoneNoTxtField, PhoneNo);
			elementutil.enterText(remarksTxtField, Remarks);

			// click on "ok" btton
			elementutil.clickElement(okBtn);
			// Note Imp : changes to be done for duplicate record message once application
			// changes done
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
					log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Incorrect");
				} // end of if
				else {
					log.error("Data Provided Is Not As Per Valid Format");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on Back button
				elementutil.clickElement(btnBack);
				if (elementutil.getText(backErrorMsgText).trim().toString()
						.equals("User Pressed Back Key".trim().toString())) {
					log.info("Back button Is Working Fine");
				} // end of if
				else {
					log.error("Back Button Is Not Working fine");
				} // end of else

				// click on OK button
				elementutil.clickElement(okBtn);
				// click on Add confirm button
				elementutil.clickElement(addConfirmBtn);

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
		// elementutil.handlewin1(driver);
		// elementutil.GoToFrame("Content");
		// homePage.LogOut();

	}// end of addRelationshipManagerRecord function

	// ------------------------METHOD TO ADD RELATIONSHIPMANAGER RECORD WITH INVALID
	// DATA--------------------------------------------------
	public void addRelationshipManagerRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String Name = map.get("Name");
			String EmaiId = map.get("Email Id");
			String PhoneNo = map.get("Phone No");
			String Remarks = map.get("Remarks");

			// click on ok button
			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			String rmAddScreenMandatoryMessage = "RM Code is Mandatory\n" + "Invalid Name\n" + "Invalid Email Id";

			if (elementutil.getText(errormessages).trim().toString()
					.equals(rmAddScreenMandatoryMessage.trim().toString())) {
				log.info(
						"Mandatory Field Validation Message For Relationship Manager->Add Screen Is Displayed Correctly");
			} // end of if
			else {
				log.error(
						"Mandatory Field Validation Message For Relationship Manager->Add Screen Is Displayed Incorrectly");
			} // end of else

			String expectedRMCODEScreenMessage1 = "Invalid Name\n" + "RM Code Should be Alpha-Numeric\n"
					+ "Invalid Email Id";
			String expectedRMCODEScreenMessage2 = "RM Code Should be Alpha-Numeric";

			// enter valid details
			elementutil.enterText(rmCodeTxtField, rmCode);
			elementutil.enterText(relationshipManagerNameTxtField, Name);
			elementutil.enterText(emailIdTxtField, EmaiId);
			elementutil.enterText(phoneNoTxtField, PhoneNo);
			elementutil.enterText(remarksTxtField, Remarks);

			// click on "ok" btton
			elementutil.clickElement(okBtn);

			try {
				String actualRMCodeAddScreen_Message = elementutil.getText(errormessages);
				boolean FieldWiseInvalidMessageRes = checkSubstring(actualRMCodeAddScreen_Message,
						rmAddScreenMandatoryMessage);

				if (elementutil.getText(errormessages).trim().toString()
						.equals(expectedRMCODEScreenMessage1.trim().toString())
						|| elementutil.getText(errormessages).trim().toString().equals(expectedRMCODEScreenMessage2)
						|| elementutil.getText(errormessages).trim().toString().equals(
								rmAddScreenMandatoryMessage.trim().toString())
						|| FieldWiseInvalidMessageRes == true) {
					log.info("Validation Message Displayed For Field Wise Invalid Data Is Displayed Correctly");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
					log.info("Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With RM Code"
							+ rmCode + " Found");
				} // end of else if
				else {
					log.error("Validation Message Displayed For Field Wise Invalid Data Is Displayed Incorrectly");
				} // end of else
			} catch (NoSuchElementException e) {

				log.info("Test Data Provided Was Not Invalid");

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of addRelationshipManagerRecord_InvalidData function

	// -----------------------METHOD TO APPROVE RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void approveRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCodeOriginal = map.get("RM Code");
			String Name = map.get("Name");

			// move to relationshipManagerFilterScreenData function to enter valid details
			// on filter screen
			relationshipManagerFilterScreenData(rmCodeOriginal, Name);

			// click on Reset button
			elementutil.clickElement(btnReset);
			// log.info("Reset Button Clicked");

			if (elementutil.getText(rmCodeTxtField).isEmpty()
					&& elementutil.getText(relationshipManagerNameTxtField).isEmpty()) {
				log.info("RESET Button Is Working Fine");
			} // end of if loop
			else {
				log.error("RESET Button Is Not Working Fine");
			} // end of else

			// move to relationshipManagerFilterScreenData function to enter valid details
			// on filter screen
			relationshipManagerFilterScreenData(rmCodeOriginal, Name);

			// click on ok button on filter screen
			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation")) {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + Name + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + Name + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else

			} catch (NoSuchElementException e) {
				try {
					if (rmScreenRecord_Path.isDisplayed()) {
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
								.equals(rmCodeOriginal.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(Name.trim().toString())) {
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(cancelBtnText).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Buton Is Not Working Fine");
							} // end of else

							// move to relationshipManagerFilterScreenData function to enter valid details
							// on filter screen
							relationshipManagerFilterScreenData(rmCodeOriginal, Name);

							// click on ok button on filter screen
							elementutil.clickElement(okBtn);

							// click on record
							elementutil.clickElement(rmScreenRecord_Path);

							// click on Approve Button
							elementutil.clickElement(btnApprove);
							// log.info("Approve Button Clicked");
						} // end of if
						else {
							log.error("Record Mismatch, Record With RMCode " + rmCodeOriginal + " And Name " + Name
									+ " Not Found");
						} // end of else
					} // end of if

				} catch (NoSuchElementException e2) {
					// click on Cancel Button
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
							.equals(rmCodeOriginal.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(Name.trim().toString())) {
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(cancelBtnText).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Buton Is Not Working Fine");
						} // end of else

						// move to relationshipManagerFilterScreenData function to enter valid details
						// on filter screen
						relationshipManagerFilterScreenData(rmCodeOriginal, Name);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						// click on Approve Button
						elementutil.clickElement(btnApprove);
						// log.info("Approve Button Clicked");
					} // end of if
					else {
						log.error("Record Mismatch, Record With RMCode " + rmCodeOriginal + " And Name " + Name
								+ " Not Found");
					} // end of else
				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// move to handlewin function to
		elementutil.handlewin1(driver);

	}// end of approveRelationshipManagerRecord function

	// -----------------------METHOD TO MODIFY RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void modifyRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCodeOriginal = map.get("Original RM Code");
			String rmCode = map.get("RM Code");
			String nameOriginal = map.get("Original Name");
			String Name = map.get("Name");
			String EmaiId = map.get("Email Id");
			String PhoneNo = map.get("Phone No");
			String Remarks = map.get("Remarks");

			// enter valid details on filter screen
			elementutil.enterText(rmCodeTxtField, rmCodeOriginal);
			elementutil.enterText(relationshipManagerNameTxtField, nameOriginal);

			// click on Reset Button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(rmCodeTxtField).isEmpty()
					&& elementutil.getText(relationshipManagerNameTxtField).isEmpty()) {
				log.info("RESET Button Is Working Fine");
			} // end of if
			else {
				log.error("RESET Button Is Not Working Fine");
			} // end of else

			// enter valid details on filter screen
			elementutil.enterText(rmCodeTxtField, rmCodeOriginal);
			elementutil.enterText(relationshipManagerNameTxtField, nameOriginal);

			// click on "OK" button on filter screen
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + nameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message Is Displayed Correctly");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + nameOriginal + " Not Found");
					log.error("No Records available for Modify operation Validation Message Is Displayed Incorrectly");

				} // end of else

			} catch (NoSuchElementException e) {

				try {
					System.out.println("in try");
					if (rmScreenRecord_Path.isDisplayed()) {
						System.out.println("in if");
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim()
								.equals(rmCodeOriginal.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(nameOriginal.trim().toString())) {
							// click on OK button
							elementutil.clickElement(okBtn);

							// Cancel Button Clicking
							elementutil.clickElement(btnCancel);

							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if loop
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// enter valid details on filter screen
							elementutil.enterText(rmCodeTxtField, rmCodeOriginal);
							elementutil.enterText(relationshipManagerNameTxtField, nameOriginal);

							// click on ok button on filter screen
							elementutil.clickElement(okBtn);

							// click on screen record
							elementutil.clickElement(rmScreenRecord_Path);

							// click on ok button on modify screen
							elementutil.clickElement(okBtn);

							// click on Back Button
							elementutil.clickElement(btnBack);

							if (elementutil.getText(backErrorMsgText).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Wokring Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							} // end of else

							// clear all field values
							elementutil.clearText(rmCodeTxtField);
							elementutil.clearText(relationshipManagerNameTxtField);
							elementutil.clearText(emailIdTxtField);
							elementutil.clearText(phoneNoTxtField);
							elementutil.clearText(remarksTxtField);

							// enter the modified values
							elementutil.enterText(rmCodeTxtField, rmCode);
							elementutil.enterText(relationshipManagerNameTxtField, Name);
							elementutil.enterText(emailIdTxtField, EmaiId);
							elementutil.enterText(phoneNoTxtField, PhoneNo);
							elementutil.enterText(remarksTxtField, Remarks);

							// click on "OK" button
							elementutil.clickElement(okBtn);
							// log.info("OK Button Clicked");
							// Note IMP: Changes to be done in Error Message Checking Once Change in
							// Application Message
							// check if record already exists
							try {
								if (elementutil.getText(errormessages).trim().toString()
										.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
									log.info(
											"Duplicate Record : Duplicate Record Validation Message Is Displayed Incorrectly");
								} // end of if
								else {
									log.error("Data Provided For Modify Operation Is Not As Per Valid Format");
								} // end of else

							} catch (NoSuchElementException e2) {
								// click on "ModifyConfirm" button
								elementutil.clickElement(modifyScreenModifyConfirmBtn);
							} // end of catch

						} // end of if
						else {
							log.error("Record Mismatch, Record With RMCode " + rmCodeOriginal + " And Name "
									+ nameOriginal + " Not Found ");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					System.out.println("in catch");
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim()
							.equals(rmCodeOriginal.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(nameOriginal.trim().toString())) {
						// click on OK button
						elementutil.clickElement(okBtn);

						// Cancel Button Clicking
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if loop
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter valid details on filter screen
						elementutil.enterText(rmCodeTxtField, rmCodeOriginal);
						elementutil.enterText(relationshipManagerNameTxtField, nameOriginal);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						// click on ok button on modify screen
						elementutil.clickElement(okBtn);

						// click on Back Button
						elementutil.clickElement(btnBack);

						if (elementutil.getText(backErrorMsgText).trim().toString()
								.equals("User Pressed Back Key".trim().toString())) {
							log.info("Back Button Is Working Fine");
						} // end of if
						else {
							log.error("Back Button Is Not Working Fine");
						} // end of else

						// clear all field values
						elementutil.clearText(rmCodeTxtField);
						elementutil.clearText(relationshipManagerNameTxtField);
						elementutil.clearText(emailIdTxtField);
						elementutil.clearText(phoneNoTxtField);
						elementutil.clearText(remarksTxtField);

						// enter the modified values
						elementutil.enterText(rmCodeTxtField, rmCode);
						elementutil.enterText(relationshipManagerNameTxtField, Name);
						elementutil.enterText(emailIdTxtField, EmaiId);
						elementutil.enterText(phoneNoTxtField, PhoneNo);
						elementutil.enterText(remarksTxtField, Remarks);

						// click on "OK" button
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");
						// Note IMP: Changes to be done in Error Message Checking Once Change in
						// Application Message
						// check if record already exists
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
								log.info(
										"Duplicate Record : Duplicate Record Validation Message Is Displayed Incorrectly");
							} // end of if
							else {
								log.error("Data Provided For Modify Operation Is Not As Per Valid Format");
							} // end of else

						} catch (NoSuchElementException e3) {
							// click on "ModifyConfirm" button
							elementutil.clickElement(modifyScreenModifyConfirmBtn);
						} // end of catch

					} // end of if
					else {
						log.error("Record Mismatch, Record With RMCode " + rmCodeOriginal + " And Name " + nameOriginal
								+ " Not Found ");
					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of modifyRelationshipManagerRecord function

	// -----------------------METHOD TO MODIFY RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void modifyRelationshipManagerRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCodeOriginal = map.get("Original RM Code");
			String rmCode = map.get("RM Code");
			String nameOriginal = map.get("Original Name");
			String Name = map.get("Name");
			String EmaiId = map.get("Email Id");
			String PhoneNo = map.get("Phone No");
			String Remarks = map.get("Remarks");

			// enter valid details on filter screen
			elementutil.enterText(rmCodeTxtField, rmCodeOriginal);
			elementutil.enterText(relationshipManagerNameTxtField, nameOriginal);

			// click on "OK" button on filter screen
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + nameOriginal + " Not Found");
					log.info("No Records available for Modify operation Validation Message Is Displayed Correctly");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCodeOriginal + " And Name " + nameOriginal + " Not Found");
					log.error("No Records available for Modify operation Validation Message Is Displayed Incorrectly");

				} // end of else

			} catch (NoSuchElementException e) {
				try {
					if (rmScreenRecord_Path.isDisplayed()) {
						// click on screen record
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim()
								.equals(rmCodeOriginal.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(nameOriginal.trim().toString())) {
							// clear all field values
							elementutil.clearText(rmCodeTxtField);
							elementutil.clearText(relationshipManagerNameTxtField);
							elementutil.clearText(emailIdTxtField);
							elementutil.clearText(phoneNoTxtField);
							elementutil.clearText(remarksTxtField);

							// click on ok button on filter screen
							elementutil.clickElement(okBtn);

							String rmModifyScreenMandatoryMessage = "RM Code is Mandatory\n" + "Invalid Name\n"
									+ "Invalid Email Id";

							if (elementutil.getText(errormessages).trim().toString()
									.equals(rmModifyScreenMandatoryMessage.trim().toString())) {
								log.info(
										"Mandatory Field Validation Message For Relationship Manager->Modify Screen Is Displayed Correctly");
							} // end of if
							else {
								log.error(
										"Mandatory Field Validation Message For Relationship Manager->Modify Screen Is Displayed Incorrectly");
							} // end of else

							String expectedRMCODEScreenMessage1 = "Invalid Name\n" + "RM Code Should be Alpha-Numeric\n"
									+ "Invalid Email Id";
							String expectedRMCODEScreenMessage2 = "RM Code Should be Alpha-Numeric";

							// enter valid details
							elementutil.enterText(rmCodeTxtField, rmCode);
							elementutil.enterText(relationshipManagerNameTxtField, Name);
							elementutil.enterText(emailIdTxtField, EmaiId);
							elementutil.enterText(phoneNoTxtField, PhoneNo);
							elementutil.enterText(remarksTxtField, Remarks);
							// click on "ok" button
							elementutil.clickElement(okBtn);
							try {

								String actualRMCodeModifyScreen_Message = elementutil.getText(errormessages);
								boolean FieldWiseInvalidMessageRes = checkSubstring(actualRMCodeModifyScreen_Message,
										rmModifyScreenMandatoryMessage);

								System.out.println(elementutil.getText(errormessages));
								if (elementutil.getText(errormessages).trim().toString()
										.equals(expectedRMCODEScreenMessage1.trim().toString())
										|| elementutil.getText(errormessages).trim().toString()
												.equals(expectedRMCODEScreenMessage2.trim().toString())
										|| elementutil.getText(errormessages).trim().toString()
												.equals(rmModifyScreenMandatoryMessage.trim().toString())
										|| FieldWiseInvalidMessageRes == true) {
									log.info(
											"Validation Message Displayed For Field Wise Invalid Data Is Displayed Correctly");
								} // end of if
								else if (elementutil.getText(errormessages).trim().toString()
										.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
									log.info(
											"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With RM Code"
													+ rmCode + " Found");
								} // end of else if
								else {
									log.error(
											"Validation Message Displayed For Field Wise Invalid Data Is Displayed Incorrectly");
								} // end of else
							} catch (NoSuchElementException e2) {

								log.info("Test Data Provided Was Not Invalid");

							} // end of catch
						} // end of if
						else {
							log.info("Record Mismatch, Record With RM Code Value " + rmCodeOriginal + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim()
							.equals(rmCodeOriginal.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(nameOriginal.trim().toString())) {
						// clear all field values
						elementutil.clearText(rmCodeTxtField);
						elementutil.clearText(relationshipManagerNameTxtField);
						elementutil.clearText(emailIdTxtField);
						elementutil.clearText(phoneNoTxtField);
						elementutil.clearText(remarksTxtField);

						// click on ok button on filter screen
						elementutil.clickElement(okBtn);

						String rmModifyScreenMandatoryMessage = "RM Code is Mandatory\n" + "Invalid Name\n"
								+ "Invalid Email Id";

						if (elementutil.getText(errormessages).trim().toString()
								.equals(rmModifyScreenMandatoryMessage.trim().toString())) {
							log.info(
									"Mandatory Field Validation Message For Relationship Manager->Modify Screen Is Displayed Correctly");
						} // end of if
						else {
							log.error(
									"Mandatory Field Validation Message For Relationship Manager->Modify Screen Is Displayed Incorrectly");
						} // end of else

						String expectedRMCODEScreenMessage1 = "Invalid Name\n" + "RM Code Should be Alpha-Numeric\n"
								+ "Invalid Email Id";
						String expectedRMCODEScreenMessage2 = "RM Code Should be Alpha-Numeric";

						// enter valid details
						elementutil.enterText(rmCodeTxtField, rmCode);
						elementutil.enterText(relationshipManagerNameTxtField, Name);
						elementutil.enterText(emailIdTxtField, EmaiId);
						elementutil.enterText(phoneNoTxtField, PhoneNo);
						elementutil.enterText(remarksTxtField, Remarks);

						// click on "ok" btton
						elementutil.clickElement(okBtn);

						try {
							String actualRMCodeModifyScreen_Message = elementutil.getText(errormessages);
							boolean FieldWiseInvalidMessageRes = checkSubstring(actualRMCodeModifyScreen_Message,
									rmModifyScreenMandatoryMessage);
							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedRMCODEScreenMessage1.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(expectedRMCODEScreenMessage2.trim().toString())
									|| elementutil.getText(errormessages).trim().toString()
											.equals(rmModifyScreenMandatoryMessage.trim().toString())
									|| FieldWiseInvalidMessageRes == true) {
								log.info(
										"Validation Message Displayed For Field Wise Invalid Data Is Displayed Correctly");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("db.cif.cms.corp.rm.error.rmCode.recordExists".trim().toString())) {
								log.info(
										"Test Data Provided Was Not Invalid, Duplicate Record Error : Existing Record With RM Code"
												+ rmCode + " Found");
							} // end of else if
							else {
								log.error(
										"Validation Message Displayed For Field Wise Invalid Data Is Displayed Incorrectly");
							} // end of else
						} catch (NoSuchElementException e3) {

							log.info("Test Data Provided Was Not Invalid");

						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With RM Code Value " + rmCodeOriginal + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of modifyRelationshipManagerRecord_InvalidData function

	// -----------------------METHOD TO LIST RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void listRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			test_Data = fileReader.readCorporateCMSExcel(SheetName);
			String rmCode = map.get("RM Code");
			String name = map.get("Name");

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on Reset Button
			elementutil.clickElement(btnReset);
			log.info("Reset Button Clicked");

			if (elementutil.getText(rmCodeTxtField).isEmpty()
					&& elementutil.getText(relationshipManagerNameTxtField).isEmpty()) {
				log.info("RESET Button Is Working Fine");
			} // end of if
			else {
				log.error("RESET Button Is Not Working Fine");
			} // end of else

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on ok button
			elementutil.clickElement(okBtn);
			log.info("OK Button Clicked");

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.error("No Records available for List operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on screen record
				elementutil.SHORT_TIMEOUT();
				elementutil.clickElement(screenRecord);

				if (elementutil.getText(rmlistScreenRMCodeRecordValue).trim().equals(rmCode.trim().toString())
						&& elementutil.getText(rmlistScreenNameValue).trim().toString()
								.equals(name.trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name
							+ " Is Displayed In List With Status " + elementutil.getText(rmRecordstatus));
				} // end of if
				else {
					log.error("Record With RM Code " + rmCode + " And Name " + name + " Is Not Displayed In List");
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of listRelationshipManagerRecord function

	// -----------------------METHOD TO DELETE RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void deleteRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String name = map.get("Name");

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on reset button
			elementutil.clickElement(btnReset);
			// log.info("RESET Button Clicked");

			if (elementutil.getText(rmCodeTxtField).isEmpty()
					&& elementutil.getText(relationshipManagerNameTxtField).isEmpty()) {
				log.info("RESET Button Is Working Fine");
			} // end of if
			else {
				log.error("RESET Button Is Not Working Fine");
			} // end of else

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on "ok" button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (rmScreenRecord_Path.isDisplayed()) {
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
								.equals(rmCode.trim().toString())
								&& elementutil.getAttribute(relationshipManagerNameTxtField).trim().toString()
										.equals(name.trim().toString())) {
							// click on ok button
							elementutil.clickElement(okBtn);
							// log.info("OK Button Clicked");

							// click on cancel button
							elementutil.clickElement(btnCancel);

							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working fine");
							}

							// move to relationshipManagerFilterScreenData function to enter details
							relationshipManagerFilterScreenData(rmCode, name);

							// click on ok button
							elementutil.clickElement(okBtn);

							elementutil.clickElement(rmScreenRecord_Path);

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on Deleted button
							elementutil.clickElement(btnDelete);

						} // end of if
						else {
							log.info("Record Mismatch, Record With RM Code " + rmCode + " And Name " + name
									+ " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
							.equals(rmCode.trim().toString())
							&& elementutil.getAttribute(relationshipManagerNameTxtField).trim().toString()
									.equals(name.trim().toString())) {
						// click on ok button
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");

						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working fine");
						}

						// move to relationshipManagerFilterScreenData function to enter details
						relationshipManagerFilterScreenData(rmCode, name);

						// click on ok button
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");

						// click on ok button
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");

						// click on Deleted button
						elementutil.clickElement(btnDelete);
						// log.info("Delete Button Clicked");

					} // end of if
					else {
						log.info("Record Mismatch, Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					} // end of else
				} // end of catch
			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of deleteRelationshipManagerRecord function

	// -----------------------METHOD TO CONFIRM DELETE RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void confirmDeleteRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String name = map.get("Name");

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			elementutil.clickElement(btnReset);

			if (elementutil.getText(rmCodeTxtField).isEmpty()
					&& elementutil.getText(relationshipManagerNameTxtField).isEmpty()) {
				log.info("RESET Button Is Working Fine");
			} // end of if
			else {
				log.error("RESET Button Is Not Working fine");
			} // end of else

			// move to relationshipManagerFilterScreenData to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end
				else {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (rmScreenRecord_Path.isDisplayed()) {
						System.out.println("in if");
						// click on screen record
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
								.equals(rmCode.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(name.trim().toString())) {
							// click on cancel button
							elementutil.clickElement(btnCancel);

							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// move to relationshipManagerFilterScreenData function to enter valid details
							relationshipManagerFilterScreenData(rmCode, name);

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on screen record
							elementutil.clickElement(rmScreenRecord_Path);
							elementutil.SHORT_TIMEOUT();
							// click on DeleteConfirm button
							elementutil.clickElement(btnDeleteConfirm);
							elementutil.SHORT_TIMEOUT();
						} // end of if
						else {
							log.info("Record Mismatch, Record With RM Code " + rmCode + " And Name " + name
									+ " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
							.equals(rmCode.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(name.trim().toString())) {
						// click on cancel button
						elementutil.clickElement(btnCancel);

						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// move to relationshipManagerFilterScreenData function to enter valid details
						relationshipManagerFilterScreenData(rmCode, name);

						// click on ok button
						elementutil.clickElement(okBtn);

						elementutil.SHORT_TIMEOUT();
						// click on DeleteConfirm button
						elementutil.clickElement(btnDeleteConfirm);

					} // end of if
					else {
						log.info("Record Mismatch, Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// move to handlewin1 function to switch window
		elementutil.handlewin1(driver);

	}// end of confirmDeleteRelationshipManagerRecord function

	// -----------------------METHOD FOR CANCEL MODIFY ACTION RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void cancelModifyActionRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String name = map.get("Name");

			// move to relationshipManagerFilterScreenData function to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on ok button on filter screen
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.error("No Records available for Approve operation Validation Message displayed Is Incorrect");
				} // end of else

			} catch (NoSuchElementException e) {

				try {

					if (rmScreenRecord_Path.isDisplayed()) {
						// click on screen record
						elementutil.clickElement(rmScreenRecord_Path);

						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
								.equals(rmCode.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(name.trim().toString())) {
							// click on Cancel Modify Action button
							elementutil.clickElement(cancelModifyActionBtn);

						} // end of if
						else {
							log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {

					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
							.equals(rmCode.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(name.trim().toString())) {
						// click on Cancel Modify Action button
						elementutil.clickElement(cancelModifyActionBtn);

					} // end of if
					else {
						log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of cancelModifyActionRelationshipManagerRecord function

	// -----------------------METHOD FOR CANCEL DELETE ACTION RELATIONSHIP MANAGER
	// RECORD----------------------------
	public void cancelDeleteActionRelationshipManagerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String rmCode = map.get("RM Code");
			String name = map.get("Name");

			// move to relationshipManagerFilterScreenData function to enter details
			relationshipManagerFilterScreenData(rmCode, name);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Messsage Displayed is Correct");
				} // end of if
				else {
					log.info("Record With RM Code " + rmCode + " And Name " + name + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Messsage Displayed is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (rmScreenRecord_Path.isDisplayed()) {
						System.out.println("in try");
						// click on screen record//*[@id="LNTablelistable"]/tbody/tr[2]
						elementutil.clickElement(rmScreenRecord_Path);
						if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
								.equals(rmCode.trim().toString())
								&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
										.equals(name.trim().toString())) {
							System.out.println("in if");
							// click on cancel delete action button
							elementutil.clickElement(cancelDeleteActionBtn);

						} // end of if
						else {
							log.info("Record With RM Code Value " + rmCode + " And Name " + name
									+ " Not The Expected Record");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					System.out.println("in catch");
					if (elementutil.getAttribute(rmCodeValueApproveScreen).trim().toString()
							.equals(rmCode.trim().toString())
							&& elementutil.getAttribute(nameFieldValueApproveScreen).trim().toString()
									.equals(name.trim().toString())) {

						// click on cancel delete action button
						elementutil.clickElement(cancelDeleteActionBtn);

					} // end of if
					else {
						log.info("Record With RM Code Value " + rmCode + " And Name " + name
								+ " Not The Expected Record");
					} // end of else
				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// move to handlewin1 function to switch window
		elementutil.handlewin1(driver);
	}// end of cancelModifyActionRelationshipManagerRecord function

	// Generic method for Relationship Manager->Approve,Add,List,Delete,Confirm
	// Delete filter screens to enter data
	public void relationshipManagerFilterScreenData(String rmCode, String name)
			throws InvalidFormatException, IOException {
		// fetch details
//		test_Data = fileReader.readCorporateCMSExcel(SheetName);
//		String rmCodeOriginal = test_Data.get(Row).get("RM Code");
//		String Name = test_Data.get(Row).get("Name");

		// enter valid details
		elementutil.enterText(rmCodeTxtField, rmCode);

		elementutil.enterText(relationshipManagerNameTxtField, name);

	}// end of relationshipManagerFilterScreenData function

	public void approveFilterScreen_InvalidInput() throws InvalidFormatException, IOException {
		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// click on "Reset" button
		elementutil.clickElement(btnReset);

		// Check if after clicking Reset button values become empty
		if (rmCodeTxtField.getText().isEmpty() && relationshipManagerNameTxtField.getText().isEmpty()) {
			System.out.println("RESET BUTTON IS WORKING FINE");
		} else {
			System.err.println("RESET BUTTON IS NOT WORKING");
		}

		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// move to noRecordsAvailableFor_ApproveErrorMessage function to check filter
		// screen Validation message correctness
		errorMessageChecker.noRecordsAvailableFor_ApproveErrorMessage();

		errorMessageChecker.assertAndLogout();

		elementutil.handlewin1(driver);
	}// end of approveFilterScreen_InvalidInput function

	public void listFilterScreen_InvalidInput() throws InvalidFormatException, IOException {
		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// click on "Reset" button
		elementutil.clickElement(btnReset);

		// Check if after clicking Reset button values become empty
		if (rmCodeTxtField.getText().isEmpty() && relationshipManagerNameTxtField.getText().isEmpty()) {
			System.out.println("RESET BUTTON IS WORKING FINE");
		} // end of if
		else {
			System.err.println("RESET BUTTON IS NOT WORKING");
		} // end of else

		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// move to noRecordsAvailableFor_ApproveErrorMessage function to check filter
		// screen Validation message correctness
		errorMessageChecker.noRecordsAvailableFor_ListErrorMessage();

		errorMessageChecker.assertAndLogout();

		elementutil.handlewin1(driver);
	}// end of listFilterScreen_InvalidInput function

	public void modifyFilterScreen_InvalidInput() throws InvalidFormatException, IOException {
		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// click on "Reset" button
		elementutil.clickElement(btnReset);

		// Check if after clicking Reset button values become empty
		if (rmCodeTxtField.getText().isEmpty() && relationshipManagerNameTxtField.getText().isEmpty()) {
			System.out.println("RESET BUTTON IS WORKING FINE");
		} // end of if
		else {
			System.err.println("RESET BUTTON IS NOT WORKING");
		} // end of else

		// move to enterInvalidScreenData function to enter invalid data on filter
		// screen
		enterInvalidFilterScreenData();

		// move to noRecordsAvailableFor_ApproveErrorMessage function to check filter
		// screen Validation message correctness
		errorMessageChecker.noRecordsAvailableFor_ModifyErrorMessage();

		errorMessageChecker.assertAndLogout();

		elementutil.handlewin1(driver);

	}// end of modifyFilterScreen_InvalidInput function

	// Generic Method to enter invalid data on all filter screens
	public void enterInvalidFilterScreenData() throws InvalidFormatException, IOException {
		// enter invalid details
		elementutil.enterText(rmCodeTxtField, "r123codetest000test456");
		elementutil.enterText(relationshipManagerNameTxtField, "9nametest000");

		// click on "OK" button
		elementutil.clickElement(okBtn);

	}// end of relationshipManagerFilterScreenData function

	// ----------------------------------------SCHEME MENU
	// METHODS-----------------------------------------------

	// ---------------------------------------METHOD TO ADD SCHEME RECORD WITH VALID
	// DATA--------------------------------------------------------
	public void addSchemeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");
			String Description = map.get("Description");
			String Corporate = map.get("Corporate");
			String Payment_Product = map.get("Payment Product");
			String Minimum_Amount = map.get("Minimum Amount");
			String Maximum_Amount = map.get("Maximum Amount");
			String Accounting = map.get("Accounting");
			String Settlment = map.get("Settlement");
			String Miscellaneous = map.get("Miscellaneous");
			String Represent_Mapping = map.get("Represent Mapping");
			String Charge_Frequency = map.get("Charge Frequency");
			String Mandate_Charge = map.get("Mandate Charge");
			String Trasansaction_Charge = map.get("Transaction Charge");
			String Start_Date = map.get("Start Date");
			String End_Date = map.get("End Date");
			String SMS_Alert = map.get("SMS Alert");
			String SMS_Opted_For = map.get("SMS Opted for");
			String Email_Alert = map.get("EMAIL Alert");
			String Email_Opted_For = map.get("EMAIL Opted for");
			String Email_Ids = map.get("Email Ids(Comma Separated)");
			String MobileNo = map.get("Mobile No.(Comma Separated)");
			String CorporateChargePosting = map.get("Corporate Charge Posting");
			String VendorCode = map.get("Vendor Code");
			String NoOfDaysPosting = map.get("No of DaysPosting");
			String ACH_Codes = map.get("ACH Codes");
			String ECS_Codes = map.get("ECS Codes");
			String APBS_Codes = map.get("APBS Codes");
			String Direct_Debit_Codes = map.get("Direct Debit Codes");

			// elementutil.clickElement(showAccountButton);
			// elementutil.GoToFrame("accountingCodeDiv");
			// elementutil.getText(showAccBtnPopUpText);
			//
			// Enter Valid Values in the Fields to check Valid Data Scenario
			elementutil.enterText(schemeCode, SchemeCode);
			elementutil.enterText(description, Description);
			elementutil.selectDropDownByVisibleText(corporate, Corporate);
			elementutil.enterText(paymentProductCode, Payment_Product);
			elementutil.enterText(minAmount, Minimum_Amount);
			elementutil.enterText(maxAmount, Maximum_Amount);
			elementutil.selectDropDownByVisibleText(accountingCode, Accounting);
			elementutil.selectDropDownByVisibleText(settlement, Settlment);
			elementutil.selectDropDownByVisibleText(miscellaneous, Miscellaneous);
			elementutil.selectDropDownByVisibleText(representMapping, Represent_Mapping);
			elementutil.selectDropDownByVisibleText(chargeFrequency, Charge_Frequency);
			elementutil.selectDropDownByVisibleText(mandateCharge, Mandate_Charge);
			elementutil.selectDropDownByVisibleText(transactionCharge, Trasansaction_Charge);
			// elementutil.enterText(startDate, Start_Date);
			// log.info(Start_Date + " Entered For Start Date Field");
			// elementutil.enterText(endDate, End_Date);
			// log.info(End_Date + " Entered For End Date Field");
			elementutil.selectDropDownByVisibleText(smsAlert, SMS_Alert);
			if (SMS_Alert.trim().toString().equals("Y".trim().toString())) {
				elementutil.selectDropDownByVisibleText(smsOptedfor, SMS_Opted_For);
			} // end
			elementutil.selectDropDownByVisibleText(emailAlert, Email_Alert);
			if (Email_Alert.trim().toString().equals("Y")) {
				elementutil.selectDropDownByVisibleText(emailOptedFor, Email_Opted_For);
			} // end
			elementutil.enterText(EmailIds, Email_Ids);
			elementutil.enterText(mobileNo, MobileNo);
			elementutil.selectDropDownByVisibleText(corporatechargePosting, CorporateChargePosting);
			elementutil.selectDropDownByVisibleText(vendorCode, VendorCode);
			elementutil.selectDropDownByVisibleText(noOfDaysPosting, NoOfDaysPosting);
			elementutil.enterText(achCodes, ACH_Codes);
			elementutil.enterText(ecsCodes, ECS_Codes);
			elementutil.enterText(apbsCodes, APBS_Codes);
			elementutil.enterText(directDebitcodes, Direct_Debit_Codes);
			// click on ok button
			elementutil.clickElement(okBtn);
			try {
				if (elementutil.getText(errormessages).trim().toString().equals("Duplicate Record".trim().toString())) {
					log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Proper");
				} // end of if loop
				else {
					log.error(
							"Data Provided For Add operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Not Proper");

				} // end of else

			} catch (NoSuchElementException e) {
				elementutil.clickElement(btnBack);
				if (elementutil.getText(backErrorMsgText).trim().toString().equals("User Pressed Back Key")) {
					log.info("Back Button Is Working Fine");
				} // end of if
				else {
					log.error("Back Button Is Not Working fine");
				} // end of else

				// click on "OK" button
				elementutil.clickElement(okBtn);

				// click on Add Confirm Button
				elementutil.clickElement(addConfirmBtn);
			} // end of catch block

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end

	// --------------------------------METHOD TO MODIFY SCHEME
	// RECORD-------------------------------------------------------
	public void modifySchemeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");
			String OriginalSchemeCode = map.get("Original Scheme Code");
			String Description = map.get("Description");
			String Corporate = map.get("Corporate");
			String Payment_Product = map.get("Payment Product");
			String Minimum_Amount = map.get("Minimum Amount");
			String Maximum_Amount = map.get("Maximum Amount");
			String Accounting = map.get("Accounting");
			String Settlment = map.get("Settlement");
			String Miscellaneous = map.get("Miscellaneous");
			String Represent_Mapping = map.get("Represent Mapping");
			String Charge_Frequency = map.get("Charge Frequency");
			String Mandate_Charge = map.get("Mandate Charge");
			String Trasansaction_Charge = map.get("Transaction Charge");
			String Start_Date = map.get("Start Date");
			String End_Date = map.get("End Date");
			String SMS_Alert = map.get("SMS Alert");
			String SMS_Opted_For = map.get("SMS Opted for");
			String Email_Alert = map.get("EMAIL Alert");
			String Email_Opted_For = map.get("EMAIL Opted for");
			String Email_Ids = map.get("Email Ids(Comma Separated)");
			String MobileNo = map.get("Mobile No.(Comma Separated)");
			String CorporateChargePosting = map.get("Corporate Charge Posting");
			String VendorCode = map.get("Vendor Code");
			String NoOfDaysPosting = map.get("No of DaysPosting");
			String ACH_Codes = map.get("ACH Codes");
			String ECS_Codes = map.get("ECS Codes");
			String APBS_Codes = map.get("APBS Codes");
			String Direct_Debit_Codes = map.get("Direct Debit Codes");

			// enter scheme code value on filter screen of modify
			elementutil.enterText(schemeCode, OriginalSchemeCode);

			// click on Reset button
			elementutil.clickElement(btnReset);

			// check if Reset button is working properly
			if (elementutil.getText(schemeCode).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter scheme code value on filter screen of modify
			elementutil.enterText(schemeCode, OriginalSchemeCode);

			// click on "OK" button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With Scheme Code " + OriginalSchemeCode + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end if if
				else {
					log.info("Record With Scheme Code " + OriginalSchemeCode + " Not Found");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {

				elementutil.SHORT_TIMEOUT();
				if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
						.equals(OriginalSchemeCode.trim().toString())) {
					// click on "OK" button on Modify Screen
					elementutil.clickElement(okBtn);

					// click on "Cancel" button
					elementutil.clickElement(btnCancel);

					// check if Cancel button is working properly
					if (elementutil.getText(cancelBtnText).trim().toString()
							.equals("Operation Cancelled".trim().toString())) {
						log.info("Cancel Button Is Working Fine");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Fine");
					} // end of else

					// enter scheme code value on filter screen of modify
					elementutil.enterText(schemeCode, OriginalSchemeCode);

					// click on "OK" button
					elementutil.clickElement(okBtn);

					// Enter Valid Values in the Fields to perform modification
					elementutil.clearText(schemeCode);
					elementutil.enterText(schemeCode, SchemeCode);
					// log.info(SchemeCode + " Entered In Scheme Code Field");
					elementutil.clearText(description);
					elementutil.enterText(description, Description);
					// log.info(Description + " Entered In Description Field");
					elementutil.selectDropDownByVisibleText(corporate, Corporate);
					// log.info(Corporate + " Selected For Coporate Field");
					elementutil.clearText(paymentProductCode);
					elementutil.enterText(paymentProductCode, Payment_Product);
					// log.info(Payment_Product + " Entered In Payment Product Field");
					elementutil.clearText(minAmount);
					elementutil.enterText(minAmount, Minimum_Amount);
					// log.info(Minimum_Amount + " Entered In Minimum Amount Field");
					elementutil.clearText(maxAmount);
					elementutil.enterText(maxAmount, Maximum_Amount);
					// log.info(Maximum_Amount + " Entered In Maximum Amount Field");
					elementutil.selectDropDownByVisibleText(accountingCode, Accounting);
					// log.info(Accounting + " Selected For Accounting Field");
					elementutil.selectDropDownByVisibleText(settlement, Settlment);
					// log.info(Settlment + " Selected For Settlement Field");
					elementutil.selectDropDownByVisibleText(miscellaneous, Miscellaneous);
					// log.info(Miscellaneous + " Selected For Miscellaneous Field");
					elementutil.selectDropDownByVisibleText(representMapping, Represent_Mapping);
					// log.info(Represent_Mapping + " Selected For Represent Mapping Field");
					elementutil.selectDropDownByVisibleText(chargeFrequency, Charge_Frequency);
					// log.info(Charge_Frequency + " Selected For Charge Frequency Field");
					elementutil.selectDropDownByVisibleText(mandateCharge, Mandate_Charge);
					// log.info(Mandate_Charge + " Selected For Mandate Charge Field");
					elementutil.selectDropDownByVisibleText(transactionCharge, Trasansaction_Charge);
					// log.info(Trasansaction_Charge + " Selected For Transaction Charge Field");

					// commented as getting blank page if selected dates even in proper format
					// elementutil.enterText(startDate, Start_Date);
					// log.info(Start_Date + " Entered For Start Date Field");
					// elementutil.enterText(endDate, End_Date);
					// log.info(End_Date + " Entered For End Date Field");

					if (SMS_Alert.trim().toString().equals("Y".trim().toString())) {
						elementutil.selectDropDownByVisibleText(smsAlert, "N");
						elementutil.selectDropDownByVisibleText(smsAlert, SMS_Alert);
						// log.info(SMS_Alert + " Selected For SMS Alert Field");
						elementutil.selectDropDownByVisibleText(smsOptedfor, SMS_Opted_For);
						// log.info(SMS_Opted_For + " Selected For SMS Opted For Field");
					} // end of if
					else {
						elementutil.selectDropDownByVisibleText(smsAlert, SMS_Alert);
						// log.info(SMS_Alert + " Selected For SMS Alert Field");
					} // end of else
					if (Email_Alert.trim().toString().equals("Y".trim().toString())) {
						elementutil.selectDropDownByVisibleText(emailAlert, "N");
						elementutil.selectDropDownByVisibleText(emailAlert, Email_Alert);
						// log.info(Email_Alert + " Selected For Email Alert Field");
						elementutil.selectDropDownByVisibleText(emailOptedFor, Email_Opted_For);
						// log.info(Email_Opted_For + " Selected For Email Opted For Field");
					} // end of if
					else {
						elementutil.selectDropDownByVisibleText(emailAlert, Email_Alert);
						// log.info(Email_Alert + " Selected For Email Alert Field");

					} // end of else
					elementutil.clearText(EmailIds);
					elementutil.enterText(EmailIds, Email_Ids);
					// log.info(Email_Ids + " Entered In EmailIds Field");
					elementutil.clearText(mobileNo);
					elementutil.enterText(mobileNo, MobileNo);
					// log.info(MobileNo + " Entered In Mobile No. Field");
					elementutil.selectDropDownByVisibleText(corporatechargePosting, CorporateChargePosting);
					// log.info(CorporateChargePosting + " Selected For Corporate Charge Posting
					// Field");
					elementutil.selectDropDownByVisibleText(vendorCode, VendorCode);
					// log.info(VendorCode + " Selected For Vendor Code Field");
					elementutil.selectDropDownByVisibleText(noOfDaysPosting, NoOfDaysPosting);
					// log.info(NoOfDaysPosting + " Selected For No Of DaysPosting Field");
					elementutil.clearText(achCodes);
					elementutil.enterText(achCodes, ACH_Codes);
					// log.info(ACH_Codes+ " Entered in ACH Codes Field");
					elementutil.clearText(ecsCodes);
					elementutil.enterText(ecsCodes, ECS_Codes);
					// log.info(ECS_Codes+ " Entered in ECS Codes Field");
					elementutil.clearText(apbsCodes);
					elementutil.enterText(apbsCodes, APBS_Codes);
					// log.info(APBS_Codes+ " Entered in APBS Codes Field");
					elementutil.clearText(directDebitcodes);
					elementutil.enterText(directDebitcodes, Direct_Debit_Codes);
					// log.info(Direct_Debit_Codes+ " Entered in Direct Debit Codes Field");

					// click on ok button on modify screen
					elementutil.clickElement(okBtn);
					// log.info("OK Button Clicked");

					try {
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Duplicate Record".trim().toString())) {
							log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Proper");
						} // end of if loop
						else {
							log.error(
									"Data Provided For Modify Operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Not Proper");

						} // end of else

					} catch (NoSuchElementException e2) {

						// click on Back button
						elementutil.clickElement(btnBack);

						// Check if Back button is working properly
						if (elementutil.getText(backErrorMsgText).trim().toString()
								.equals("User Pressed Back Key".trim().toString())) {
							log.info("Back Button Is Working Fine");
						} // end of if
						else {
							log.error("Back Button Is Not Working fine");
						} // end of else

						// click on "OK" button
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");

						// click on Modify Confirm Button
						elementutil.clickElement(modifyScreenModifyConfirmBtn);
						// log.info("Modify Confirm Button Clicked");
					} // end of catch block

				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of modifySchemeRecord function

	// --------------------------------METHOD TO APPROVE SCHEME
	// RECORD---------------------------------------
	public void approveSchemeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on Reset button
			elementutil.clickElement(btnReset);
			// log.info("Reset Button Clicked");

			// check if Reset button is working properly
			if (elementutil.getText(schemeCode).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on "OK" button on filter screen
			elementutil.SHORT_TIMEOUT();
			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			// check if Records are available for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				try {
					// System.out.println("in try");
					if (schemeScreenRecord.isDisplayed()) {
						// System.out.println("in if");
						elementutil.clickElement(schemeScreenRecord);
						if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
								.equals(SchemeCode.trim().toString())) {
							// click on "Cancel" button
							elementutil.clickElement(btnCancel);
							// log.info("Cancel Button Clicked");

							// check if Cancel button is working properly
							if (elementutil.getText(cancelBtnText).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
							// screen
							enterFilterScreen_SchemeCode(SchemeCode);

							// click on "OK" button on Filter Screen
							elementutil.clickElement(okBtn);
							// log.info("OK Button Clicked");

							elementutil.clickElement(schemeScreenRecord);

							// click on Approve button
							elementutil.clickElement(btnApprove);
							// log.info("Approve Button Clicked");
						} // end of if
						else {
							log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
						} // end of else
					} // end of if

				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
							.equals(SchemeCode.trim().toString())) {
						// click on "Cancel" button
						elementutil.clickElement(btnCancel);
						// log.info("Cancel Button Clicked");

						// check if Cancel button is working properly
						if (elementutil.getText(cancelBtnText).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
						// screen
						enterFilterScreen_SchemeCode(SchemeCode);

						// click on "OK" button on Filter Screen
						elementutil.clickElement(okBtn);
						// log.info("OK Button Clicked");

						// click on Approve button
						elementutil.clickElement(btnApprove);
						// log.info("Approve Button Clicked");
					} // end of if
					else {
						log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
					} // end of else

				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of approveSchemeRecord function

	// -------------------------------------METHOD TO ADD SCHEME RECORD WITH INVALID
	// DATA------------------------------------
	public void addSchemeRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		String expectedScheme_AddScreenMessage = "Invalid Scheme Code\n" + "Invalid Scheme Description\n"
				+ "Please enter atleast 1 code(ACH/ECS/APBS/Direct Debit).";

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");
			String Description = map.get("Description");
			String Payment_Product = map.get("Payment Product");
			String Minimum_Amount = map.get("Minimum Amount");
			String Maximum_Amount = map.get("Maximum Amount");
			String Email_Ids = map.get("Email Ids(Comma Separated)");
			String MobileNo = map.get("Mobile No.(Comma Separated)");
			String ACH_Codes = map.get("ACH Codes");
			String ECS_Codes = map.get("ECS Codes");

			// click on "OK" button
			elementutil.clickElement(okBtn);
			// log.info("OK button Clicked");

			// check if validation message captured after
			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedScheme_AddScreenMessage.trim().toString())) {
				log.info("Mandatory Fields Validation Message Displayed For Scheme->Add Screen Is Proper");
			} // end of if
			else {
				log.error("Mandatory Fields Validation Message Displayed For Scheme->Add Screen Is Not Proper");
			} // end of else

			// Enter Invalid Values in the Fields to check Invalid Data Scenario
			elementutil.enterText(schemeCode, SchemeCode);
			// log.info(SchemeCode + " Entered In Scheme Code Field");
			elementutil.enterText(description, Description);
			// log.info(Description + " Entered In Description Field");
			elementutil.enterText(paymentProductCode, Payment_Product);
			// log.info(Payment_Product + " Entered In Payment Product Field");
			elementutil.enterText(minAmount, Minimum_Amount);
			// log.info(Minimum_Amount + " Entered In Minimum Amount Field");
			elementutil.enterText(maxAmount, Maximum_Amount);
			// log.info(Maximum_Amount + " Entered In Maximum Amount Field");
			elementutil.enterText(EmailIds, Email_Ids);
			// log.info(Email_Ids + " Entered In EmailIds Field");
			elementutil.enterText(mobileNo, MobileNo);
			// log.info(MobileNo + " Entered In Mobile No. Field");
			elementutil.enterText(achCodes, ACH_Codes);
			// log.info(ACH_Codes+ " Entered in ACH Codes Field");
			elementutil.enterText(ecsCodes, ECS_Codes);
			// log.info(ECS_Codes+ " Entered in ECS Codes Field");

			// click on ok button
			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			String expectedInvalidFieldsMessage1 = "Invalid Scheme Code\n" + "Invalid Payment Product code\n"
					+ "The provided code : " + ACH_Codes + " is not valid\n" + "The provided code : " + ECS_Codes
					+ " is not valid\n" + "Invalid Minimum Amount\n" + "Invalid Maximum Amount\n"
					+ "Invalid Mobile No : " + MobileNo + "\n" + "Invalid Email Id : " + Email_Ids;
			String expectedInvalidFieldsMessage2 = "Invalid Scheme Code\n" + "Invalid Payment Product code\n"
					+ "The provided code : " + ECS_Codes + " is not valid\n" + "Invalid Minimum Amount\n"
					+ "Invalid Maximum Amount\n" + "Invalid Mobile No : " + MobileNo + "\n" + "Invalid Email Id : "
					+ Email_Ids;
			String expectedInvalidFieldsMessage3 = "Invalid Scheme Code\n" + "Invalid Payment Product code\n"
					+ "The provided code : " + ACH_Codes + " is not valid\n" + "Invalid Minimum Amount\n"
					+ "Invalid Maximum Amount\n" + "Invalid Mobile No : " + MobileNo + "\n" + "Invalid Email Id : "
					+ Email_Ids;
			String expectedInvalidFieldsMessage4 = "Invalid Scheme Code\n" + "Invalid Scheme Description\n"
					+ "Invalid Payment Product code\n" + "The provided code : " + ACH_Codes + " is not valid\n"
					+ "The provided code : " + ECS_Codes + " is not valid\n" + "Invalid Minimum Amount\n"
					+ "Invalid Maximum Amount\n" + "Invalid Mobile No : " + MobileNo + "\n" + "Invalid Email Id : "
					+ Email_Ids;

			// check if validation message captured after invalid data entering is proper
			try {
				if ((elementutil.getText(errormessages).trim().toString()
						.equals(expectedInvalidFieldsMessage1.trim().toString()))
						|| (elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidFieldsMessage2.trim().toString()))
						|| (elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidFieldsMessage3.trim().toString()))
						|| (elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidFieldsMessage4.trim().toString()))) {
					log.info("Validation Message For Field Wise Invalid Data Is Displayed Properly");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("Duplicate Record".trim().toString())) {
					log.info(
							"Test Data Provided Was Not Invalid. Duplicate Record Error : Existing Record With Scheme Code "
									+ SchemeCode + " Found");
				} else {
					log.error("Validation Message For Field Wise Invalid Data Is Not Displayed Properly");
				} // end of else loop

			} catch (NoSuchElementException e) {
				log.error("Test Data Provided Was Not Invalid");
			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end

	// -------------------------------------METHOD TO MODIFY SCHEME RECORD WITH
	// INVALID DATA------------------------------------
	public void modifySchemeRecord_InvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		String expectedScheme_AddScreenMessage = "Invalid Scheme Code\n" + "Invalid Scheme Description\n"
				+ "Please enter atleast 1 code(ACH/ECS/APBS/Direct Debit).";

		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String OriginalSchemeCode = map.get("Original Scheme Code");
			String SchemeCode = map.get("Scheme Code");
			String Description = map.get("Description");
			String Payment_Product = map.get("Payment Product");
			String Minimum_Amount = map.get("Minimum Amount");
			String Maximum_Amount = map.get("Maximum Amount");
			String Email_Ids = map.get("Email Ids(Comma Separated)");
			String MobileNo = map.get("Mobile No.(Comma Separated)");
			String ACH_Codes = map.get("ACH Codes");
			String ECS_Codes = map.get("ECS Codes");

			// enter scheme code in filter screen
			elementutil.enterText(schemeCode, OriginalSchemeCode);

			// click on "OK" button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With Scheme Code " + OriginalSchemeCode + " Not Found");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end if if
				else {
					log.info("Record With Scheme Code " + OriginalSchemeCode + " Not Found");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
						.equals(SchemeCode.trim().toString())) {
					// Enter Invalid Values in the Fields to check Invalid Data Scenario
					elementutil.clearText(schemeCode);
					elementutil.clearText(description);
					elementutil.clearText(paymentProductCode);
					elementutil.clearText(minAmount);
					elementutil.clearText(maxAmount);
					elementutil.clearText(EmailIds);
					elementutil.clearText(mobileNo);
					elementutil.clearText(achCodes);
					elementutil.clearText(ecsCodes);
					elementutil.clearText(apbsCodes);
					elementutil.clearText(directDebitcodes);

					// click on "OK" button
					elementutil.clickElement(okBtn);

					// check if validation message captured after
					if (elementutil.getText(errormessages).trim().toString()
							.equals(expectedScheme_AddScreenMessage.trim().toString())) {
						log.info("Mandatory Fields Validation Message Displayed For Scheme->Modify Screen Is Proper");
					} // end of if
					else {
						log.error(
								"Mandatory Fields Validation Message Displayed For Scheme->Modify Screen Is Not Proper");
					} // end of else

					// Enter Invalid Values in the Fields to check Invalid Data Scenario
					elementutil.enterText(schemeCode, SchemeCode);
					// log.info(SchemeCode + " Entered In Scheme Code Field");
					elementutil.enterText(description, Description);
					// log.info(Description + " Entered In Description Field");
					elementutil.enterText(paymentProductCode, Payment_Product);
					// log.info(Payment_Product + " Entered In Payment Product Field");
					elementutil.enterText(minAmount, Minimum_Amount);
					// log.info(Minimum_Amount + " Entered In Minimum Amount Field");
					elementutil.enterText(maxAmount, Maximum_Amount);
					// log.info(Maximum_Amount + " Entered In Maximum Amount Field");
					elementutil.enterText(EmailIds, Email_Ids);
					// log.info(Email_Ids + " Entered In EmailIds Field");
					elementutil.enterText(mobileNo, MobileNo);
					// log.info(MobileNo + " Entered In Mobile No. Field");
					elementutil.enterText(achCodes, ACH_Codes);
					// log.info(ACH_Codes+ " Entered in ACH Codes Field");
					elementutil.enterText(ecsCodes, ECS_Codes);
					// log.info(ECS_Codes+ " Entered in ECS Codes Field");

					// click on ok button
					elementutil.clickElement(okBtn);
					// log.info("OK Button Clicked");

					String expectedInvalidFieldsMessage1 = "Invalid Scheme ode\n" + "Invalid Payment Product code\n"
							+ "The provided code : " + ACH_Codes + " is not valid\n" + "The provided code : "
							+ ECS_Codes + " is not valid\n" + "Invalid Minimum Amount\n" + "Invalid Maximum Amount\n"
							+ "Invalid Mobile No : " + MobileNo + "\n" + "Invalid Email Id : " + Email_Ids;
					String expectedInvalidFieldsMessage2 = "Invalid Scheme Code\n" + "Invalid Payment Product code\n"
							+ "The provided code : " + ECS_Codes + " is not valid\n" + "Invalid Minimum Amount\n"
							+ "Invalid Maximum Amount\n" + "Invalid Mobile No : " + MobileNo + "\n"
							+ "Invalid Email Id : " + Email_Ids;
					String expectedInvalidFieldsMessage3 = "Invalid Scheme Code\n" + "Invalid Payment Product code\n"
							+ "The provided code : " + ACH_Codes + " is not valid\n" + "Invalid Minimum Amount\n"
							+ "Invalid Maximum Amount\n" + "Invalid Mobile No : " + MobileNo + "\n"
							+ "Invalid Email Id : " + Email_Ids;

					// check if validation message captured after invalid data entering is proper
					try {
						if ((elementutil.getText(errormessages).trim().toString()
								.equals(expectedInvalidFieldsMessage1.trim().toString()))
								|| (elementutil.getText(errormessages).trim().toString()
										.equals(expectedInvalidFieldsMessage2.trim().toString()))
								|| (elementutil.getText(errormessages).trim().toString()
										.equals(expectedInvalidFieldsMessage3.trim().toString()))) {
							log.info("Validation Message For Field Wise Invalid Data Is Displayed Properly");
						} // end of if
						else if (elementutil.getText(errormessages).trim().toString()
								.equals("Duplicate Record".trim().toString())) {
							log.info(
									"Test Data Provided Was Not Invalid. Duplicate Record Error : Existing Record With Scheme Code "
											+ SchemeCode + " Found");
						} else {
							log.error("Validation Message For Field Wise Invalid Data Is Not Displayed Properly");
						} // end of else loop

					} catch (NoSuchElementException e2) {

						log.info("Test Data Provided Was Not Invalid");
					} // end of catch
				} // end of if
				else {
					log.info("Record Mismatch, Record With Scheme Code " + OriginalSchemeCode + "Not Found");
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end

	// --------------------------------METHOD TO DELETE SCHEME
	// RECORD---------------------------------------
	public void deleteSchemeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on Reset button
			elementutil.clickElement(btnReset);
			// check if Reset button is working properly
			if (elementutil.getText(schemeCode).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on "OK" button on filter screen
			elementutil.clickElement(okBtn);
			// check if Records are available for deletion
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				// click on "OK" button on Delete screen
				// elementutil.clickElement(okBtn);
				if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
						.equals(SchemeCode.trim().toString())) {
					// click on "OK" button on Delete screen
					elementutil.clickElement(okBtn);
					// click on "Cancel" button
					elementutil.clickElement(btnCancel);

					// check if Cancel button is working properly
					if (elementutil.getText(cancelBtnText).trim().toString()
							.equals("Operation Cancelled".trim().toString())) {
						log.info("Cancel Button Is Working Fine");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Fine");
					} // end of else

					// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
					// screen
					enterFilterScreen_SchemeCode(SchemeCode);

					// click on "OK" button on Filter Screen
					elementutil.clickElement(okBtn);

					// click on "OK" button on Delete Screen
					elementutil.clickElement(okBtn);

					// click on Delete button
					elementutil.clickElement(btnDelete);

				} // end of if
				else {
					log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of schemeDeleteRecord function

	// --------------------------------METHOD TO CONFIRM DELETE SCHEME
	// RECORD---------------------------------------
	public void confirmdeleteSchemeRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on Reset button
			elementutil.clickElement(btnReset);
			log.info("Reset Button Clicked");

			// check if Reset button is working properly
			if (elementutil.getText(schemeCode).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on "OK" button on filter screen
			elementutil.clickElement(okBtn);

			// check if Records are available for confirm delete operation
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (schemeScreenRecord.isDisplayed()) {
						elementutil.clickElement(schemeScreenRecord);
						if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
								.equals(SchemeCode.trim().toString())) {
							// click on "Cancel" button
							elementutil.clickElement(btnCancel);

							// check if Cancel button is working properly
							if (elementutil.getText(cancelBtnText).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
							// screen
							enterFilterScreen_SchemeCode(SchemeCode);

							// click on "OK" button on Filter Screen
							elementutil.clickElement(okBtn);

							elementutil.clickElement(schemeScreenRecord);

							// click on Delete Confirm button
							elementutil.clickElement(btnDeleteConfirm);

							// check if scheme is mapped with corporate before confirming deletion of record
							try {
								if (elementutil.getText(errormessages).trim().toString().equals(
										"Kindly unmap schemes from corporate customers before delete. Customer Code - ["
												+ elementutil.getAttribute(corpCodeValue) + "]")) {
									log.info("Scheme " + SchemeCode
											+ " Cannot Be Deleted As It Is Mapped With Corporate ["
											+ elementutil.getAttribute(corpCodeValue) + "]");
								}
							} catch (NoSuchElementException e2) {
								// click on Delete Confirm button
								// elementutil.clickElement(btnDeleteConfirm);
								// log.info("Delete Confirm Button Clicked");
								log.info("Confirm Delete Operation Successfully Performed On Record With Scheme Code "
										+ SchemeCode);
							} // end of catch
						} // end of if
						else {
							log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
							.equals(SchemeCode.trim().toString())) {
						// click on "Cancel" button
						elementutil.clickElement(btnCancel);

						// check if Cancel button is working properly
						if (elementutil.getText(cancelBtnText).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
						// screen
						enterFilterScreen_SchemeCode(SchemeCode);

						// click on "OK" button on Filter Screen
						elementutil.clickElement(okBtn);

						// click on Delete Confirm button
						elementutil.clickElement(btnDeleteConfirm);

						// check if scheme is mapped with corporate before confirming deletion of record
						try {
							if (elementutil.getText(errormessages).trim().toString().equals(
									"Kindly unmap schemes from corporate customers before delete. Customer Code - ["
											+ elementutil.getAttribute(corpCodeValue) + "]")) {
								log.info("Scheme " + SchemeCode + " Cannot Be Deleted As It Is Mapped With Corporate ["
										+ elementutil.getAttribute(corpCodeValue) + "]");
							}
						} catch (NoSuchElementException e3) {
							// click on Delete Confirm button
							// elementutil.clickElement(btnDeleteConfirm);
							// log.info("Delete Confirm Button Clicked");
							log.info("Confirm Delete Operation Successfully Performed On Record With Scheme Code "
									+ SchemeCode);
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
					} // end of else
				}

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of confirmdeleteSchemeRecord function

	// --------------------------------METHOD TO LIST SCHEME
	// RECORD---------------------------------------
	public void listSchemeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on Reset button
			elementutil.clickElement(btnReset);
			log.info("Reset Button Clicked");

			// check if Reset button is working properly
			if (elementutil.getText(schemeCode).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			// click on "OK" button on filter screen
			elementutil.clickElement(okBtn);
			log.info("OK Button Clicked");

			// check if Records are available for list operation
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error("No Records available for List operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {

				elementutil.clickElement(screenRecord);
				log.info("Record Click Performed");

				if (elementutil.getText(schemeRecordValue).trim().toString().equals(SchemeCode.trim().toString())) {
					log.info(SchemeCode + " Is Displayed In List With Status "
							+ elementutil.getText(schemeRecordStatus));
				} // end of if
				else {
					log.info(SchemeCode + " Is Not Displayed In List");
				} // end of else

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of listSchemeRecord function

	// --------------------------------METHOD FOR CANCEL MODIFY ACTION OF SCHEME
	// RECORD---------------------------------------
	public void schemeCancelModifyAction(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			// check if Records are available for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (schemeScreenRecord.isDisplayed()) {
						elementutil.clickElement(schemeScreenRecord);
						if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
								.equals(SchemeCode.trim().toString())) {
							// click on CancelModifyAction button
							elementutil.clickElement(cancelModifyActionBtn);
							// log.info("Cancel Modify Action Button Clicked");
						} // end of if
						else {
							log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Present For Approval");
						} // end of else

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
							.equals(SchemeCode.trim().toString())) {
						// click on CancelModifyAction button
						elementutil.clickElement(cancelModifyActionBtn);
						// log.info("Cancel Modify Action Button Clicked");
					} // end of if
					else {
						log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Present For Approval");
					} // end of else

				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of schemeCancelModifyAction function

	// --------------------------------METHOD FOR CANCEL DELETE ACTION OF SCHEME
	// RECORD---------------------------------------
	public void schemeCancelDeleteAction(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String SchemeCode = map.get("Scheme Code");

			// move to enterFilterScreen_SchemeCode function enter Scheme Code on filter
			// screen
			enterFilterScreen_SchemeCode(SchemeCode);

			elementutil.clickElement(okBtn);
			// log.info("OK Button Clicked");

			// check if Records are available for approval
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Scheme Code " + SchemeCode + " Not Found");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {

				try {
					if (schemeScreenRecord.isDisplayed()) {
						elementutil.clickElement(schemeScreenRecord);
						if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
								.equals(SchemeCode.trim().toString())) {
							elementutil.clickElement(cancelDeleteActionBtn);

						} // end of if
						else {
							log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {

					if (elementutil.getAttribute(schemeApproveScreenRecordValue).trim().toString()
							.equals(SchemeCode.trim().toString())) {
						elementutil.clickElement(cancelDeleteActionBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Expected Scheme " + SchemeCode + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of schemeCancelDeleteAction function

	// Generic methods for Scheme Filter Screens to enter Scheme Code
	public void enterFilterScreen_SchemeCode(String SchemeCode) throws InvalidFormatException, IOException {
//		test_Data = fileReader.readCorporateCMSExcel(SheetName);
//		String SchemeCode = test_Data.get(Row).get("Scheme Code");

		elementutil.enterText(schemeCode, SchemeCode);

	}// end of enterFilterScreen_SchemeCode

	// --------------------------------------------CUSTOMER MENU
	// METHODS-------------------------------------------------------
	// --------------------------------------------Method to Add Customer
	// Record---------------------------------------
	public void addCustomerRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String sponsorIFSC = map.get("Sponsor IFSC");
			String parentCustomer = map.get("Parent Customer");
			String contactPerson = map.get("Contact Person");
			String addressLine1 = map.get("Address Line 1");
			String addressLine2 = map.get("Address Line 2");
			String addressLine3 = map.get("Address Line 3");
			String addressLine4 = map.get("Address Line 4");
			String zipCode = map.get("Zip Code");
			String Country = map.get("Country");
			String State = map.get("State");
			String Phone = map.get("Phone");
			String Mobile = map.get("Mobile");
			String Fax = map.get("Fax");
			String Email = map.get("Email");
			String AddressRemarks = map.get("Address Remarks");
			String Remarks = map.get("Remarks");
			String industryType = map.get("Industry Type");
			String uccNumber = map.get("UCC Number");
			String panNumber = map.get("PAN Number");
			String customerType = map.get("Customer Type");
			String creditRating = map.get("Credit Rating");
			String EffectiveFromDate = map.get("Effective From Date(dd/mm/yyyy)");
			String EffectiveToDate = map.get("Effective To Date(dd/mm/yyyy)");
			String BusinessGroup = map.get("Business Group");
			String RetentionPeriod = map.get("Retention Period");
			String PaymentMode = map.get("Payment Mode");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(sponsorIFSC_TxtField, sponsorIFSC);
			elementutil.selectDropDownByVisibleText(parentCustomer_DropDown, parentCustomer);
			elementutil.enterText(contactPerson_TxtField, contactPerson);
			elementutil.enterText(addressLine1_TxtField, addressLine1);
			elementutil.enterText(addressLine2_TxtField, addressLine2);
			elementutil.enterText(addressLine3_TxtField, addressLine3);
			elementutil.enterText(addressLine4_TxtField, addressLine4);
			elementutil.enterText(zipCode_TxtField, zipCode);
			elementutil.enterText(country_TxtField, Country);
			elementutil.SelectElementByVisibleText(stateName_DropDown, State);
			elementutil.enterText(customerMenu_phoneNo_TxtField, Phone);
			elementutil.enterText(customerMenu_mobileNumber_TxtField, Mobile);
			elementutil.enterText(faxNo_TxtField, Fax);
			elementutil.enterText(customerMenu_emailID_TxtField, Email);
			elementutil.enterText(addressRemarks_TxtField, AddressRemarks);
			elementutil.enterText(customerMenu_Remarks_TxtField, Remarks);
			elementutil.selectDropDownByVisibleText(customerMenu_industryType_DropDown, industryType);
			elementutil.enterText(uccNo_TxtField, uccNumber);
			elementutil.enterText(customerMenu_panNo_TxtField, panNumber);
			elementutil.enterText(customerMenu_CustType_TxtField, customerType);
			elementutil.enterText(customerMenu_CreditRating_TxtField, creditRating);
			elementutil.enterText(effectiveDateFrom_DateField, EffectiveFromDate);
			elementutil.enterText(effectiveDateTo_DateField, EffectiveToDate);
			elementutil.selectDropDownByVisibleText(customerMenu_BusinessGroup_DropDown, BusinessGroup);
			elementutil.enterText(retentionPeriod_TxtField, RetentionPeriod);
			elementutil.enterText(paymentMode_TxtField, PaymentMode);
			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("Duplicate Entry Found! Please enter valid CRN code.".trim().toString())) {
					log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.error(
							"Data Provided For Add operation is not as per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on Back button
				elementutil.clickElement(btnBack);
				// -- Checking the Back button---------
				if (elementutil.getText(errormessages).trim().toString()
						.equals("User Pressed Back Key".trim().toString())) {
					log.info("Back Button Is Working Fine");
				} // end of if
				else {
					log.error("Back Button Is Not Working Fine");
				} // end of else

				// click on ok button
				elementutil.clickElement(okBtn);

				// click on AddConfirm Button
				elementutil.clickElement(btnAddConfirm);

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();
	}// end of addCustomerRecord function

	// ------------------------------------Method to Add Customer Record With
	// Invalid Data----------------------------------------
	public void addCustomerRecord_InvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String sponsorIFSC = map.get("Sponsor IFSC");
			String parentCustomer = map.get("Parent Customer");
			String contactPerson = map.get("Contact Person");
			String addressLine1 = map.get("Address Line 1");
			String addressLine2 = map.get("Address Line 2");
			String addressLine3 = map.get("Address Line 3");
			String addressLine4 = map.get("Address Line 4");
			String zipCode = map.get("Zip Code");
			String Country = map.get("Country");
			String State = map.get("State");
			String Phone = map.get("Phone");
			String Mobile = map.get("Mobile");
			String Fax = map.get("Fax");
			String Email = map.get("Email");
			String AddressRemarks = map.get("Address Remarks");
			String Remarks = map.get("Remarks");
			String industryType = map.get("Industry Type");
			String uccNumber = map.get("UCC Number");
			String panNumber = map.get("PAN Number");
			String customerType = map.get("Customer Type");
			String creditRating = map.get("Credit Rating");
			String EffectiveFromDate = map.get("Effective From Date(dd/mm/yyyy)");
			String EffectiveToDate = map.get("Effective To Date(dd/mm/yyyy)");
			String BusinessGroup = map.get("Business Group");
			String RetentionPeriod = map.get("Retention Period");
			String PaymentMode = map.get("Payment Mode");
			// click on ok button
			elementutil.clickElement(okBtn);
			String expectedInvalidFieldsWiseDataMessage = "Mobile number should be 10 digits long(Numeric)\n"
					+ "UCC number should be 10 digit numeric value\n"
					+ "PAN number should be 10 character e.g. ABCDE1234A\n" + "Phone number should be Numeric\n"
					+ "Effective To Date cannot be before Effective From Date\n"
					+ "Customer Code Should be Alpha-Numeric\n"
					+ "Effective To Date cannot be equal to Effective From Date";
			boolean alertPresentFlag = false;
			String expectedMandatoryFieldMessage = "Invalid Customer Code\n" + "Invalid Customer Name\n"
					+ "Please enter Contact Person\n" + "Invalid IFSC Code\n" + "Please enter Address Line 1\n"
					+ "Please enter valid Zip Code(6 digits long & Numeric)\n" + "Please enter Country\n"
					+ "Please select State\n" + "Please enter valid email id\n" + "Please enter Remarks\n"
					+ "Please enter Effective Date From\n" + "Please select Business Group";
			// check if mandatory fields message is correct
			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedMandatoryFieldMessage.trim().toString())) {
				log.info("Mandatory Fields Message For Customer->Add Screen displayed Is Correct");
			} // end of if
			else {
				log.error("Mandatory Fields Message For Customer->Add Screen Displayed Is Incorrect");
			} // end of else
				// enter details
			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.SHORT_TIMEOUT();
			elementutil.clickElement(sponsorIFSC_TxtField);
			elementutil.SHORT_TIMEOUT();
			WebDriverWait w = new WebDriverWait(driver, 5);
			try {
				if (w.until(ExpectedConditions.alertIsPresent()) == null) {
					alertPresentFlag = false;
				} // end of if
				else {
					elementutil.acceptAlert();
					alertPresentFlag = true;
					elementutil.clearText(custName_TxtField);
				} // end of else
			} catch (TimeoutException e) {
				alertPresentFlag = false;
			} catch (ElementNotInteractableException e2) {
				alertPresentFlag = false;
			}

			elementutil.enterText(sponsorIFSC_TxtField, sponsorIFSC);
			elementutil.selectDropDownByVisibleText(parentCustomer_DropDown, parentCustomer);
			elementutil.enterText(contactPerson_TxtField, contactPerson);
			elementutil.enterText(addressLine1_TxtField, addressLine1);
			elementutil.enterText(addressLine2_TxtField, addressLine2);
			elementutil.enterText(addressLine3_TxtField, addressLine3);
			elementutil.enterText(addressLine4_TxtField, addressLine4);
			elementutil.enterText(zipCode_TxtField, zipCode);
			elementutil.enterText(country_TxtField, Country);
			elementutil.SelectElementByVisibleText(stateName_DropDown, State);
			elementutil.enterText(customerMenu_phoneNo_TxtField, Phone);
			elementutil.enterText(customerMenu_mobileNumber_TxtField, Mobile);
			elementutil.enterText(faxNo_TxtField, Fax);
			elementutil.enterText(customerMenu_emailID_TxtField, Email);
			elementutil.enterText(addressRemarks_TxtField, AddressRemarks);
			elementutil.enterText(customerMenu_Remarks_TxtField, Remarks);
			elementutil.selectDropDownByVisibleText(customerMenu_industryType_DropDown, industryType);
			elementutil.enterText(uccNo_TxtField, uccNumber);
			elementutil.enterText(customerMenu_panNo_TxtField, panNumber);
			elementutil.enterText(customerMenu_CustType_TxtField, customerType);
			elementutil.enterText(customerMenu_CreditRating_TxtField, creditRating);
			elementutil.enterText(effectiveDateFrom_DateField, EffectiveFromDate);
			elementutil.enterText(effectiveDateTo_DateField, EffectiveToDate);
			elementutil.selectDropDownByVisibleText(customerMenu_BusinessGroup_DropDown, BusinessGroup);
			elementutil.enterText(retentionPeriod_TxtField, RetentionPeriod);
			elementutil.enterText(paymentMode_TxtField, PaymentMode);
			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				String actualCustomerScreenMessage = elementutil.getText(errormessages);
				boolean FieldWiseInvalidMessageRes = checkSubstring(actualCustomerScreenMessage,
						expectedInvalidFieldsWiseDataMessage);
				if (FieldWiseInvalidMessageRes == true || alertPresentFlag == true) {
					log.info("Field Wise Invalid Data Message Displayed For Customer->Add Screen Is Correct");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("Duplicate Entry Found! Please enter valid CRN code.".trim().toString())) {
					log.info(
							"Test Data Provided Is Not Invalid, Duplicate Record Error : Existing Record With Customer Code "
									+ customerCode + " Found");

				} // end of else if
				else {
					log.error("Field Wise Invalid Data Message Displayed For Customer->Add Screen Is Incorrect");
				} // end of else

			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Was Not Invalid");

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of addCustomerRecord function

	// --------------------------------------------Method to Approve Customer
	// Record---------------------------------------
	public void approveCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(customerCode_TxtField).isEmpty() && elementutil.getText(custName_TxtField).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ACHCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ECSCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_APBSCode).isEmpty()) {
				log.info("Reset button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {

					if (customerScreenRecord.isDisplayed()) {

						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(customerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(customerName.trim().toString())) { // click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(customerCode_TxtField, customerCode);
							elementutil.enterText(custName_TxtField, customerName);
							elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
							elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
							elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on screen record
							elementutil.clickElement(customerScreenRecord);
							// click on Approve button
							elementutil.clickElement(btnApprove);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Customer Code " + customerCode
									+ " And Customer Name " + customerName + " Not Found");
						}

					} // end of if

				} catch (NoSuchElementException e2) {

					if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
							.equals(customerCode.trim().toString())
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(customerName.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(customerCode_TxtField, customerCode);
						elementutil.enterText(custName_TxtField, customerName);
						elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
						elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
						elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on Approve button
						elementutil.clickElement(btnApprove);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + customerCode + " And Customer Name "
								+ customerName + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of approveCustomerRecord function

	// --------------------------------------------Method to Delete Customer
	// Record---------------------------------------
	public void deleteCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(customerCode_TxtField).isEmpty() && elementutil.getText(custName_TxtField).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ACHCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ECSCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_APBSCode).isEmpty()) {
				log.info("Reset button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (customerScreenRecord.isDisplayed()) {
						System.out.println("in if");
						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(customerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(customerName.trim().toString())) { // click on ok button
							elementutil.clickElement(okBtn);
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(customerCode_TxtField, customerCode);
							elementutil.enterText(custName_TxtField, customerName);
							elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
							elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
							elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on screen record
							elementutil.clickElement(customerScreenRecord);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on Approve button
							elementutil.clickElement(btnDelete);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Customer Code " + customerCode
									+ " And Customer Name " + customerName + " Not Found");
						} // end of else
					}
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
							.equals(customerCode.trim().toString())
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(customerName.trim().toString())) { // click on ok button
						elementutil.clickElement(okBtn);
						// click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(customerCode_TxtField, customerCode);
						elementutil.enterText(custName_TxtField, customerName);
						elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
						elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
						elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on Approve button
						elementutil.clickElement(btnDelete);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + customerCode + " And Customer Name "
								+ customerName + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		logOutOperation();

	}// end of deleteCustomerRecord function
		// --------------------------------------------Method to Confirm Delete Customer
		// Record---------------------------------------

	public void confirmdeleteCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(customerCode_TxtField).isEmpty() && elementutil.getText(custName_TxtField).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ACHCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ECSCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_APBSCode).isEmpty()) {
				log.info("Reset button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (customerScreenRecord.isDisplayed()) {
						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(customerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(customerName.trim().toString())) {
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(customerCode_TxtField, customerCode);
							elementutil.enterText(custName_TxtField, customerName);
							elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
							elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
							elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
							// click on ok button
							elementutil.clickElement(okBtn);
							elementutil.clickElement(customerScreenRecord);
							// click on Confirm Delete button
							elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Customer Code " + customerCode
									+ " And Customer Name " + customerName + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
							.equals(customerCode.trim().toString())
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(customerName.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(customerCode_TxtField, customerCode);
						elementutil.enterText(custName_TxtField, customerName);
						elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
						elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
						elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on Confirm Delete button
						elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + customerCode + " And Customer Name "
								+ customerName + " Not Found");
					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of confirmdeleteCustomerRecord function

	// -------------------------------Method For Cancel Delete Action of Customer
	// Record---------------------------------------
	public void canceldeleteActionCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (customerScreenRecord.isDisplayed()) {
						System.out.println("in if");
						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(customerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(customerName.trim().toString())) {
							elementutil.clickElement(cancelDeleteActionBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With Customer Code " + customerCode
									+ " And Customer Name " + customerName + " Not Found");
						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
							.equals(customerCode.trim().toString())
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(customerName.trim().toString())) {
						// click on Cancel Delete Action button
						elementutil.clickElement(cancelDeleteActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + customerCode + " And Customer Name "
								+ customerName + " Not Found");
					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of canceldeleteActionCustomerRecord function

	// -----------------------------Method For Mapping/Unmapping of Scheme/Format
	// code for Customer---------------------------------------
	public void customerRecordSchemeFormatCodeMapping(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String corporate = map.get("Corporate");
			String scheme_format = map.get("Scheme/Format");
			String actionType = map.get("Action Type");
			String recordNo = map.get("Record No(Comma Separated Numeric Values)");
			String[] recordNoValueList = recordNo.split(",");

			elementutil.selectDropDownByVisibleText(customer_SchemeFormatCd_CorporateDropDown, corporate);
			elementutil.selectDropDownByVisibleText(Customer_SchemeFormatCd_mappingType, scheme_format);
			elementutil.SelectElementByVisibleText(customerMenu_ActionType, actionType);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No records found for selected criteria".trim().toString())) {
					log.info("No Records Found For Corporate : " + corporate);
					log.info("No records found for selected criteria Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("No Records Found For Corporate  : " + corporate);
					log.error("No records found for selected criteria Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {

				boolean flagValue = elementutil.selectCheckBoxes(recordNoValueList);
				if (flagValue == true) {
					elementutil.clickElement(CustomerSchemeFormatMapping_SubmitBtn);
					if (elementutil.getText(errormessages).trim().toString().equals("Customer mapping saved")) {
						log.info("Customer Mapping Done for Corporate  : " + corporate);
					} // end of if
				} // end of if
				else {
					log.error("Failed To Do Customer Mapping for Corporate " + corporate);
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of function

	// ------------------------------------Method to Modify Customer
	// Record---------------------------------------------------------
	public void modifyCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalCustomerCode = map.get("Original Customer Code");
			String customerCode = map.get("Customer Code");
			String originalCustomerName = map.get("Original Name");
			String customerName = map.get("Name");
			String sponsorIFSC = map.get("Sponsor IFSC");
			String parentCustomer = map.get("Parent Customer");
			String contactPerson = map.get("Contact Person");
			String addressLine1 = map.get("Address Line 1");
			String addressLine2 = map.get("Address Line 2");
			String addressLine3 = map.get("Address Line 3");
			String addressLine4 = map.get("Address Line 4");
			String zipCode = map.get("Zip Code");
			String Country = map.get("Country");
			String State = map.get("State");
			String Phone = map.get("Phone");
			String Mobile = map.get("Mobile");
			String Fax = map.get("Fax");
			String Email = map.get("Email");
			String AddressRemarks = map.get("Address Remarks");
			String Remarks = map.get("Remarks");
			String industryType = map.get("Industry Type");
			String uccNumber = map.get("UCC Number");
			String panNumber = map.get("PAN Number");
			String customerType = map.get("Customer Type");
			String creditRating = map.get("Credit Rating");
			String EffectiveFromDate = map.get("Effective From Date(dd/mm/yyyy)");
			String EffectiveToDate = map.get("Effective To Date(dd/mm/yyyy)");
			String BusinessGroup = map.get("Business Group");
			String RetentionPeriod = map.get("Retention Period");
			String PaymentMode = map.get("Payment Mode");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");
			// enter details
			elementutil.enterText(customerCode_TxtField, originalCustomerCode);
			elementutil.enterText(custName_TxtField, originalCustomerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
			// click on Reset button
			elementutil.clickElement(btnReset);
			// check Reset button Working
			if (elementutil.getText(customerCode_TxtField).isEmpty() && elementutil.getText(custName_TxtField).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ACHCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ECSCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_APBSCode).isEmpty()) {
				log.info("Reset button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else
				// enter details
			elementutil.enterText(customerCode_TxtField, originalCustomerCode);
			elementutil.enterText(custName_TxtField, originalCustomerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
			// click on ok button
			elementutil.clickElement(okBtn);
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With Values [ " + originalCustomerCode + " , " + originalCustomerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + originalCustomerCode + " , " + originalCustomerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (customerScreenRecord.isDisplayed()) {
						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(originalCustomerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(originalCustomerName.trim().toString())) { // click on ok button
							elementutil.clickElement(okBtn);
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(customerCode_TxtField, originalCustomerCode);
							elementutil.enterText(custName_TxtField, originalCustomerName);
							elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
							elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
							elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on screen record
							elementutil.clickElement(customerScreenRecord);
							// enter details for modify
							elementutil.clearText(customerCode_TxtField);
							elementutil.enterText(customerCode_TxtField, customerCode);
							elementutil.clearText(custName_TxtField);
							elementutil.enterText(custName_TxtField, customerName);
							elementutil.clearText(sponsorIFSC_TxtField);
							elementutil.enterText(sponsorIFSC_TxtField, sponsorIFSC);
							elementutil.selectDropDownByVisibleText(parentCustomer_DropDown, parentCustomer);
							elementutil.clearText(contactPerson_TxtField);
							elementutil.enterText(contactPerson_TxtField, contactPerson);
							elementutil.clearText(addressLine1_TxtField);
							elementutil.enterText(addressLine1_TxtField, addressLine1);
							elementutil.clearText(addressLine2_TxtField);
							elementutil.enterText(addressLine2_TxtField, addressLine2);
							elementutil.clearText(addressLine3_TxtField);
							elementutil.enterText(addressLine3_TxtField, addressLine3);
							elementutil.clearText(addressLine4_TxtField);
							elementutil.enterText(addressLine4_TxtField, addressLine4);
							elementutil.clearText(zipCode_TxtField);
							elementutil.enterText(zipCode_TxtField, zipCode);
							elementutil.clearText(country_TxtField);
							elementutil.enterText(country_TxtField, Country);
							elementutil.SelectElementByVisibleText(stateName_DropDown, State);
							elementutil.clearText(customerMenu_phoneNo_TxtField);
							elementutil.enterText(customerMenu_phoneNo_TxtField, Phone);
							elementutil.clearText(customerMenu_mobileNumber_TxtField);
							elementutil.enterText(customerMenu_mobileNumber_TxtField, Mobile);
							elementutil.clearText(faxNo_TxtField);
							elementutil.enterText(faxNo_TxtField, Fax);
							elementutil.clearText(customerMenu_emailID_TxtField);
							elementutil.enterText(customerMenu_emailID_TxtField, Email);
							elementutil.clearText(addressRemarks_TxtField);
							elementutil.enterText(addressRemarks_TxtField, AddressRemarks);
							elementutil.clearText(customerMenu_Remarks_TxtField);
							elementutil.enterText(customerMenu_Remarks_TxtField, Remarks);
							elementutil.selectDropDownByVisibleText(customerMenu_industryType_DropDown, industryType);
							elementutil.clearText(uccNo_TxtField);
							elementutil.enterText(uccNo_TxtField, uccNumber);
							elementutil.clearText(customerMenu_panNo_TxtField);
							elementutil.enterText(customerMenu_panNo_TxtField, panNumber);
							elementutil.clearText(customerMenu_CustType_TxtField);
							elementutil.enterText(customerMenu_CustType_TxtField, customerType);
							elementutil.clearText(customerMenu_CreditRating_TxtField);
							elementutil.enterText(customerMenu_CreditRating_TxtField, creditRating);
							elementutil.clearText(effectiveDateFrom_DateField);
							elementutil.enterText(effectiveDateFrom_DateField, EffectiveFromDate);
							elementutil.clearText(effectiveDateTo_DateField);
							elementutil.enterText(effectiveDateTo_DateField, EffectiveToDate);
							elementutil.selectDropDownByVisibleText(customerMenu_BusinessGroup_DropDown, BusinessGroup);
							elementutil.clearText(retentionPeriod_TxtField);
							elementutil.enterText(retentionPeriod_TxtField, RetentionPeriod);
							elementutil.clearText(paymentMode_TxtField);
							elementutil.enterText(paymentMode_TxtField, PaymentMode);
							// click on ok button
							elementutil.clickElement(okBtn);
							// check if duplicate record exists
							try {
								if (elementutil.getText(errormessages).trim().toString().equals(
										"Duplicate Entry Found! Please enter valid CRN code.".trim().toString())) {
									log.info(
											"Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
								} // end of if
								else {
									log.error(
											"Data Provided For Modify Operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
								} // end of else
							} catch (NoSuchElementException e2) {
								// click on Back button
								elementutil.clickElement(btnBack);
								// -- Checking the Back button---------
								if (elementutil.getText(errormessages).trim().toString()
										.equals("User Pressed Back Key".trim().toString())) {
									log.info("Back Button Is Working Fine");
								} // end of if
								else {
									log.error("Back Button Is Not Working Fine");
								} // end of else

								// click on ok button
								elementutil.clickElement(okBtn);

								// click on AddConfirm Button
								elementutil.clickElement(btnModifyConfirm);

							} // end of catch

						} // end of if
						else {
							log.info("Record Mismatch, Record With Customer Code " + originalCustomerCode
									+ " And Customer Name " + originalCustomerName + " Not Found");
						} // end of else
					} // end of if
				} catch (Exception e2) {
					if (elementutil.getAttribute(customerCode_TxtField).trim().toString().equals(originalCustomerCode)
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(originalCustomerName.trim().toString())) { // click on ok button
						elementutil.clickElement(okBtn);
						// click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(customerCode_TxtField, originalCustomerCode);
						elementutil.enterText(custName_TxtField, originalCustomerName);
						elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
						elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
						elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
						// click on ok button
						elementutil.clickElement(okBtn);
						// enter details for modify
						elementutil.clearText(customerCode_TxtField);
						elementutil.enterText(customerCode_TxtField, customerCode);
						elementutil.clearText(custName_TxtField);
						elementutil.enterText(custName_TxtField, customerName);
						elementutil.clearText(sponsorIFSC_TxtField);
						elementutil.enterText(sponsorIFSC_TxtField, sponsorIFSC);
						elementutil.selectDropDownByVisibleText(parentCustomer_DropDown, parentCustomer);
						elementutil.clearText(contactPerson_TxtField);
						elementutil.enterText(contactPerson_TxtField, contactPerson);
						elementutil.clearText(addressLine1_TxtField);
						elementutil.enterText(addressLine1_TxtField, addressLine1);
						elementutil.clearText(addressLine2_TxtField);
						elementutil.enterText(addressLine2_TxtField, addressLine2);
						elementutil.clearText(addressLine3_TxtField);
						elementutil.enterText(addressLine3_TxtField, addressLine3);
						elementutil.clearText(addressLine4_TxtField);
						elementutil.enterText(addressLine4_TxtField, addressLine4);
						elementutil.clearText(zipCode_TxtField);
						elementutil.enterText(zipCode_TxtField, zipCode);
						elementutil.clearText(country_TxtField);
						elementutil.enterText(country_TxtField, Country);
						elementutil.SelectElementByVisibleText(stateName_DropDown, State);
						elementutil.clearText(customerMenu_phoneNo_TxtField);
						elementutil.enterText(customerMenu_phoneNo_TxtField, Phone);
						elementutil.clearText(customerMenu_mobileNumber_TxtField);
						elementutil.enterText(customerMenu_mobileNumber_TxtField, Mobile);
						elementutil.clearText(faxNo_TxtField);
						elementutil.enterText(faxNo_TxtField, Fax);
						elementutil.clearText(customerMenu_emailID_TxtField);
						elementutil.enterText(customerMenu_emailID_TxtField, Email);
						elementutil.clearText(addressRemarks_TxtField);
						elementutil.enterText(addressRemarks_TxtField, AddressRemarks);
						elementutil.clearText(customerMenu_Remarks_TxtField);
						elementutil.enterText(customerMenu_Remarks_TxtField, Remarks);
						elementutil.selectDropDownByVisibleText(customerMenu_industryType_DropDown, industryType);
						elementutil.clearText(uccNo_TxtField);
						elementutil.enterText(uccNo_TxtField, uccNumber);
						elementutil.clearText(customerMenu_panNo_TxtField);
						elementutil.enterText(customerMenu_panNo_TxtField, panNumber);
						elementutil.clearText(customerMenu_CustType_TxtField);
						elementutil.enterText(customerMenu_CustType_TxtField, customerType);
						elementutil.clearText(customerMenu_CreditRating_TxtField);
						elementutil.enterText(customerMenu_CreditRating_TxtField, creditRating);
						elementutil.clearText(effectiveDateFrom_DateField);
						elementutil.enterText(effectiveDateFrom_DateField, EffectiveFromDate);
						elementutil.clearText(effectiveDateTo_DateField);
						elementutil.enterText(effectiveDateTo_DateField, EffectiveToDate);
						elementutil.selectDropDownByVisibleText(customerMenu_BusinessGroup_DropDown, BusinessGroup);
						elementutil.clearText(retentionPeriod_TxtField);
						elementutil.enterText(retentionPeriod_TxtField, RetentionPeriod);
						elementutil.clearText(paymentMode_TxtField);
						elementutil.enterText(paymentMode_TxtField, PaymentMode);
						// click on ok button
						elementutil.clickElement(okBtn);
						// check if duplicate record exists
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Duplicate Entry Found! Please enter valid CRN code.".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} // end of if
							else {
								log.error(
										"Data Provided For Modify Operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e3) {
							// click on Back button
							elementutil.clickElement(btnBack);
							// -- Checking the Back button---------
							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							} // end of else

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on AddConfirm Button
							elementutil.clickElement(btnModifyConfirm);

						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + originalCustomerCode
								+ " And Customer Name " + originalCustomerName + " Not Found");
					} // end of else
				} // end

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();
	}// end of modifyCustomerRecord function

	// --------------------------------------------Method For Cancel Modify Action
	// Of Customer Record---------------------------------------
	public void cancelModifyActionCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenuFilterScreen_APBSCode, customerMenu_APBSCodeValue);
			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					if (customerScreenRecord.isDisplayed()) {
						elementutil.clickElement(customerScreenRecord);
						if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
								.equals(customerCode.trim().toString())
								&& elementutil.getAttribute(custName_TxtField).trim().toString()
										.equals(customerName.trim().toString())) {
							// click on Cancel Modify Action button
							elementutil.clickElement(cancelModifyActionBtn);
						} // end of if
						{
							log.info("Record Mismatch, Record With Customer Code " + customerCode
									+ " And Customer Name " + customerName + " Not Found");
						}

					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(customerCode_TxtField).trim().toString()
							.equals(customerCode.trim().toString())
							&& elementutil.getAttribute(custName_TxtField).trim().toString()
									.equals(customerName.trim().toString())) { // click on Approve button
						elementutil.clickElement(cancelModifyActionBtn);

					} // end of if
					else {
						log.info("Record Mismatch, Record With Customer Code " + customerCode + " And Customer Name "
								+ customerName + " Not Found");
					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end ofcancelModifyActionCustomerRecord function

	// --------------------------------------------Method to List Customer
	// Record---------------------------------------
	public void listCustomerRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCode = map.get("Customer Code");
			String customerName = map.get("Name");
			String customerMenu_ACHCodesValue = map.get("ACH Code");
			String customeMenu_ECSCodeValue = map.get("ECS Code");
			String customerMenu_APBSCodeValue = map.get("APBS Code");

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenulistFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(customerCode_TxtField).isEmpty() && elementutil.getText(custName_TxtField).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ACHCode).isEmpty()
					&& elementutil.getText(customerMenuFilterScreen_ECSCode).isEmpty()
					&& elementutil.getText(customerMenulistFilterScreen_APBSCode).isEmpty()) {
				log.info("Reset button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			elementutil.enterText(customerCode_TxtField, customerCode);
			elementutil.enterText(custName_TxtField, customerName);
			elementutil.enterText(customerMenuFilterScreen_ACHCode, customerMenu_ACHCodesValue);
			elementutil.enterText(customerMenuFilterScreen_ECSCode, customeMenu_ECSCodeValue);
			elementutil.enterText(customerMenulistFilterScreen_APBSCode, customerMenu_APBSCodeValue);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if records are available
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Values [ " + customerCode + " , " + customerName + " , "
							+ customerMenu_ACHCodesValue + " , " + customeMenu_ECSCodeValue + " , "
							+ customerMenu_APBSCodeValue + " ]  Not Found ");
					log.error("No Records available for List operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				elementutil.clickElement(screenRecord);
				if (elementutil.getText(Customer_listScreenCustomerCodeValue).trim().toString()
						.equals(customerCode.trim().toString())
						&& elementutil.getText(Customer_listScreenCustomerNameValue).trim().toString()
								.equals(customerName.trim().toString())) {
					log.info("Record With Customer Code " + customerCode + " And Customer Name " + customerName
							+ " Is Displayed In List With Status "
							+ elementutil.getText(Customer_listScreenStatusValue));
				} // end of if
				else {
					log.info("Record With Customer Code " + customerCode + " And Customer Name " + customerName
							+ " Is Not Displayed In List");
				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		logOutOperation();
	}// end of listCustomerRecord function

	// -------------------------Accounting Menu
	// Methods----------------------------------------------------

	// ------------------------Method to Add Accounting
	// Record------------------------------------------------------

	public void addAccountingRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String description = map.get("Description");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");
			String isAutoDebitCharge = map.get("Is Auto Debit Charge");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_DescriptionTxtField, description);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
			elementutil.SHORT_TIMEOUT();
			elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown, isAutoDebitCharge);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString().equals("Duplicate Record".trim().toString())) {
					log.info("Duplicate Record :  Duplicate Record Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.error(
							"Data Provided For Add operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrrect");
				} // end of else
			} catch (NoSuchElementException e) {

				// click on Back button
				elementutil.clickElement(btnBack);

				// check back button working
				if (elementutil.getText(errormessages).trim().toString().equals("User Pressed Back Key")) {
					log.info("Back Button Is Working Fine");
				} // end
				else {
					log.error("Back button Is Not Working Fine");
				} // end of else
					// click on ok button
				elementutil.clickElement(okBtn);
				// click on AddConfirm button
				elementutil.clickElement(btnAddConfirm);

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of addAccountingRecord function

	// ------------------------Method to Approve Accounting
	// Record------------------------------------------------------

	public void approveAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(accountingMenu_AccountingCodeTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_CreditAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_DebitAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_ChargeAccountNoTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {

				try {
					// System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						// System.out.println("in if");
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(accountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(creditAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(debitAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(chargeAccountNo.trim().toString())) {
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// enter details
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

							// click on ok button
							elementutil.clickElement(okBtn);

							// click on record
							elementutil.clickElement(accountingScreenRecord);

							// click on Approve button
							elementutil.clickElement(btnApprove);
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
									+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
									+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					// System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(accountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(creditAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(debitAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(chargeAccountNo.trim().toString())) {
						// click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

						// click on ok button
						elementutil.clickElement(okBtn);

						// click on Approve button
						elementutil.clickElement(btnApprove);
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
								+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
								+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of approveAccountingRecord function

	// ------------------------Method to List Accounting
	// Record------------------------------------------------------

	public void listAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(accountingMenu_AccountingCodeTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_CreditAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_DebitAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_ChargeAccountNoTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info("No Records available for List operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				// click on record
				elementutil.clickElement(accountingScreenRecord);
				if (elementutil.getText(accountingListScreenAccCode).trim().toString()
						.equals(accountingCode.trim().toString())
						&& elementutil.getText(accountingListScreenCreditAccNo).trim().toString()
								.equals(creditAccountNo.trim().toString())
						&& elementutil.getText(accountingListScreenDebitAccNo).trim().toString()
								.equals(debitAccountNo.trim().toString())
						&& elementutil.getText(accountingListScreenChargeAccNo).trim().toString()
								.equals(chargeAccountNo.trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Is Displayed In List With Status "
							+ elementutil.getText(accountingListScreenStatus));

				} // end of if
				else {
					log.error("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found");

				} // end of else

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();
	}// end of listAccountingRecord function

	// -------------------------------Method to Delete Accounting
	// Record----------------------------------------------------------
	public void deleteAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(accountingMenu_AccountingCodeTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_CreditAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_DebitAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_ChargeAccountNoTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					// System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						// System.out.println("in if");
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(accountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(creditAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(debitAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(chargeAccountNo.trim().toString())) { // click on ok button
							elementutil.clickElement(okBtn);
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on record
							elementutil.clickElement(accountingScreenRecord);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on Delete button
							elementutil.clickElement(btnDelete);
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
									+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
									+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					// System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(accountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(creditAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(debitAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(chargeAccountNo.trim().toString())) { // click on ok button
						elementutil.clickElement(okBtn);
						// click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on Delete button
						elementutil.clickElement(btnDelete);
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
								+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
								+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

					} // end of else

				} // end of catch

			} // end of catch

			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of deleteAccountingRecord function

	// -------------------------------Method to Confirm Delete Accounting
	// Record----------------------------------------------------------
	public void confirmDeleteAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(accountingMenu_AccountingCodeTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_CreditAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_DebitAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_ChargeAccountNoTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {

				try {
					// System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						// System.out.println("in if");
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(accountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(creditAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(debitAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(chargeAccountNo.trim().toString())) { // click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else
								// enter details
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on record
							elementutil.clickElement(accountingScreenRecord);
							// click on Confirm Delete button
							elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
									+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
									+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					// System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(accountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(creditAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(debitAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(chargeAccountNo.trim().toString())) { // click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else
							// enter details
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
						// click on ok button
						elementutil.clickElement(okBtn);
						// click on Confirm Delete button
						elementutil.clickElement(confirmDeleteScreenDeleteConfirmBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
								+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
								+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of confirmDeleteAccountingRecord function

	// ------------------------Method to Modify Accounting
	// Record------------------------------------------------------

	public void modifyAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalAccountingCode = map.get("Original Accounting Code");
			String accountingCode = map.get("Accounting Code");
			String description = map.get("Description");
			String originalCreditAccNo = map.get("Original Credit Acc Num");
			String creditAccountNo = map.get("Credit Acc Num");
			String originalDebitAccNo = map.get("Original Debit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String originalChargeAccNo = map.get("Original Charge Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");
			String isAutoDebitCharge = map.get("Is Auto Debit Charge");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, originalAccountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, originalCreditAccNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, originalDebitAccNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, originalChargeAccNo);

			// click on Reset button
			elementutil.clickElement(btnReset);

			if (elementutil.getText(accountingMenu_AccountingCodeTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_CreditAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_DebitAccNoTxtField).isEmpty()
					&& elementutil.getText(accountingMenu_ChargeAccountNoTxtField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if loop
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, originalAccountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, originalCreditAccNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, originalDebitAccNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, originalChargeAccNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + originalAccountingCode + " , Credit Acc Num : "
							+ originalCreditAccNo + " , Debit Acc Num : " + originalDebitAccNo + " , Charge Acc Num : "
							+ originalChargeAccNo + " ] Not Found ");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + originalAccountingCode + " , Credit Acc Num : "
							+ originalCreditAccNo + " , Debit Acc Num : " + originalDebitAccNo + " , Charge Acc Num : "
							+ originalChargeAccNo + " ] Not Found ");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						System.out.println("in if");
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						elementutil.TIMEOUT();
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(originalAccountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(originalCreditAccNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(originalDebitAccNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(originalChargeAccNo.trim().toString())) {
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on Cancel button
							elementutil.clickElement(btnCancel);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Operation Cancelled".trim().toString())) {
								log.info("Cancel Button Is Working Fine");
							} // end of if
							else {
								log.error("Cancel Button Is Not Working Fine");
							} // end of else

							// enter details
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, originalAccountingCode);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, originalCreditAccNo);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, originalDebitAccNo);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, originalChargeAccNo);
							// click on ok button
							elementutil.clickElement(okBtn);
							// click on record
							elementutil.clickElement(accountingScreenRecord);
							// enter details for modification
							elementutil.clearText(accountingMenu_AccountingCodeTxtField);
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
							elementutil.clearText(accountingMenu_DescriptionTxtField);
							elementutil.enterText(accountingMenu_DescriptionTxtField, description);
							elementutil.clearText(accountingMenu_CreditAccNoTxtField);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
							elementutil.clearText(accountingMenu_DebitAccNoTxtField);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
							elementutil.clearText(accountingMenu_ChargeAccountNoTxtField);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
							elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown,
									isAutoDebitCharge);
							// click on ok button
							elementutil.clickElement(okBtn);
							try {
								if (elementutil.getText(errormessages).trim().toString()
										.equals("Duplicate Record".trim().toString())) {
									log.info(
											"Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
								} else {
									log.error(
											"Data Provided For Modify operation is not as per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
								} // end of else
							} catch (NoSuchElementException e2) {
								elementutil.clickElement(btnBack);
								if (elementutil.getText(errormessages).trim().toString()
										.equals("User Pressed Back Key".trim().toString())) {
									log.info("Back Button Is Working Fine");
								} // end of if
								else {
									log.error("Back Button Is Not Working Fine");
								} // end of else
									// click on ok button
								elementutil.clickElement(okBtn);
								// click on Modify Confirm button
								elementutil.clickElement(modifyScreenModifyConfirmBtn);
							} // end of catch

						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + originalAccountingCode
									+ " , Credit Acc Num : " + originalCreditAccNo + " , Debit Acc Num : "
									+ originalDebitAccNo + " , Charge Acc Num : " + originalChargeAccNo
									+ " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(originalAccountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(originalCreditAccNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(originalDebitAccNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(originalChargeAccNo.trim().toString())) { // click on ok button
						elementutil.clickElement(okBtn);
						// click on Cancel button
						elementutil.clickElement(btnCancel);
						if (elementutil.getText(errormessages).trim().toString()
								.equals("Operation Cancelled".trim().toString())) {
							log.info("Cancel Button Is Working Fine");
						} // end of if
						else {
							log.error("Cancel Button Is Not Working Fine");
						} // end of else

						// enter details
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, originalAccountingCode);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, originalCreditAccNo);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, originalDebitAccNo);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, originalChargeAccNo);
						// click on ok button
						elementutil.clickElement(okBtn);
						// modify values
						elementutil.clearText(accountingMenu_AccountingCodeTxtField);
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
						elementutil.clearText(accountingMenu_DescriptionTxtField);
						elementutil.enterText(accountingMenu_DescriptionTxtField, description);
						elementutil.clearText(accountingMenu_CreditAccNoTxtField);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
						elementutil.clearText(accountingMenu_DebitAccNoTxtField);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
						elementutil.clearText(accountingMenu_ChargeAccountNoTxtField);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
						elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown,
								isAutoDebitCharge);
						// click on ok button
						elementutil.clickElement(okBtn);
						try {
							if (elementutil.getText(errormessages).trim().toString()
									.equals("Duplicate Record".trim().toString())) {
								log.info("Duplicate Record : Duplicate Record Validation Message Displayed Is Correct");
							} else {
								log.error(
										"Data Provided For Modify operation is not as per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e3) {
							elementutil.clickElement(btnBack);
							if (elementutil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Fine");
							} // end of if
							else {
								log.error("Back Button Is Not Working Fine");
							} // end of else
								// click on ok button
							elementutil.clickElement(okBtn);
							// click on Modify Confirm button
							elementutil.clickElement(modifyScreenModifyConfirmBtn);
						} // end of catch

					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + originalAccountingCode
								+ " , Credit Acc Num : " + originalCreditAccNo + " , Debit Acc Num : "
								+ originalDebitAccNo + " , Charge Acc Num : " + originalChargeAccNo + " ] Not Found ");

					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of modifyAccountingRecord function

	// ------------------------Method For Cancel Modify Action of Accounting
	// Record------------------------------------------------------

	public void cancelModifyActionAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(accountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(creditAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(debitAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(chargeAccountNo.trim().toString())) {
							// click on Approve button
							elementutil.clickElement(cancelModifyActionBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
									+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
									+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(accountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(creditAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(debitAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(chargeAccountNo.trim().toString())) { // click on Approve button
						elementutil.clickElement(cancelModifyActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
								+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
								+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

					} // end of else
				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);
	}// end of cancelModifyActionAccountingRecord function

	// -------------------------------Method for Cancel Delete Action of Accounting
	// Record----------------------------------------------------------
	public void cancelDeleteActionAccountingRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);

			// click on ok button
			elementutil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + accountingCode + " , Credit Acc Num : "
							+ creditAccountNo + " , Debit Acc Num : " + debitAccountNo + " , Charge Acc Num : "
							+ chargeAccountNo + " ] Not Found ");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {

				try {
					if (accountingScreenRecord.isDisplayed()) {
						// click on record
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(accountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(creditAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(debitAccountNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(chargeAccountNo.trim().toString())) { // click on Cancel Delete Action
																						// button
							elementutil.clickElement(cancelDeleteActionBtn);
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
									+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
									+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(accountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(creditAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(debitAccountNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(chargeAccountNo.trim().toString())) {
						// click on Cancel Delete Action button
						elementutil.clickElement(cancelDeleteActionBtn);
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + accountingCode
								+ " , Credit Acc Num : " + creditAccountNo + " , Debit Acc Num : " + debitAccountNo
								+ " , Charge Acc Num : " + chargeAccountNo + " ] Not Found ");

					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		elementutil.handlewin1(driver);

	}// end of cancelDeleteActionAccountingRecord function

	// ------------------------Method to Add Accounting Record With Invalid
	// Data------------------------------------------------------

	public void addAccountingRecord_InvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String accountingCode = map.get("Accounting Code");
			String description = map.get("Description");
			String creditAccountNo = map.get("Credit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");
			String isAutoDebitCharge = map.get("Is Auto Debit Charge");

			// click on ok button
			elementutil.clickElement(okBtn);

			String expectedMandatoryFieldMessage = "Invalid Accounting Code\n" + "Invalid Accounting Description\n"
					+ "Invalid Credit Account Number\n" + "Invalid Debit Account Number\n"
					+ "Invalid Charge Account Number";

			if (elementutil.getText(errormessages).trim().toString()
					.equals(expectedMandatoryFieldMessage.trim().toString())) {
				log.info("Mandatory Fields Validation Message Displayed For Accounting->Add Screen Is Correct");
			} else {
				log.error("Mandatory Fields Validation Message Displayed For Accounting->Add Screen Is Incorrect");
			} // end of else

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
			elementutil.enterText(accountingMenu_DescriptionTxtField, description);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
			elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown, isAutoDebitCharge);
			// click on ok button
			elementutil.clickElement(okBtn);

			String FieldWiseInvalidDataMessage = "Invalid Accounting Code\n" + "Invalid Credit Account Number\n"
					+ "Invalid Debit Account Number\n" + "Invalid Charge Account Number";

			try {
				String actualAccountingScreenMessage = elementutil.getText(errormessages);
				boolean messagePresentValue = checkSubstring(actualAccountingScreenMessage,
						expectedMandatoryFieldMessage);
				if (elementutil.getText(errormessages).trim().toString()
						.equals(FieldWiseInvalidDataMessage.trim().toString()) || messagePresentValue == true
						|| elementutil.getText(errormessages).trim().toString()
								.equals(expectedMandatoryFieldMessage.trim().toString())) {
					log.info("Field Wise Invalid Data Message For Accounting->Add Screen Displayed Is Correct");
				} // end of if
				else if (elementutil.getText(errormessages).trim().toString()
						.equals("Duplicate Record".trim().toString())) {
					log.info(
							"Test Data Provided Is Not Invalid, Duplicate Record : Existing Record With Accounting Code : "
									+ accountingCode + " Found");
				} else {
					log.error("Field Wise Invalid Data Message For Accounting->Add Screen Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Is Not Invalid");
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of addAccountingRecord_InvalidData function

	// ------------------------Method to Modify Accounting Record With Invalid
	// Data------------------------------------------------------

	public void modifyAccountingRecord_InvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalAccountingCode = map.get("Original Accounting Code");
			String accountingCode = map.get("Accounting Code");
			String description = map.get("Description");
			String originalCreditAccNo = map.get("Original Credit Acc Num");
			String creditAccountNo = map.get("Credit Acc Num");
			String originalDebitAccNo = map.get("Original Debit Acc Num");
			String debitAccountNo = map.get("Debit Acc Num");
			String originalChargeAccNo = map.get("Original Charge Acc Num");
			String chargeAccountNo = map.get("Charge Acc Num");
			String isAutoDebitCharge = map.get("Is Auto Debit Charge");
			String mandatoryFieldMessage = "Invalid Accounting Code\n" + "Invalid Accounting Description\n"
					+ "Invalid Credit Account Number\n" + "Invalid Debit Account Number\n"
					+ "Invalid Charge Account Number";

			// enter details
			elementutil.enterText(accountingMenu_AccountingCodeTxtField, originalAccountingCode);
			elementutil.enterText(accountingMenu_CreditAccNoTxtField, originalCreditAccNo);
			elementutil.enterText(accountingMenu_DebitAccNoTxtField, originalDebitAccNo);
			elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, originalChargeAccNo);
			// click on ok button
			elementutil.clickElement(okBtn);
			try {
				if (elementutil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With [ Accounting Code : " + originalAccountingCode + " , Credit Acc Num : "
							+ originalCreditAccNo + " , Debit Acc Num : " + originalDebitAccNo + " , Charge Acc Num : "
							+ originalChargeAccNo + " ] Not Found ");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Accounting Code : " + originalAccountingCode + " , Credit Acc Num : "
							+ originalCreditAccNo + " , Debit Acc Num : " + originalDebitAccNo + " , Charge Acc Num : "
							+ originalChargeAccNo + " ] Not Found ");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				try {
					// System.out.println("in try");
					if (accountingScreenRecord.isDisplayed()) {
						// System.out.println("in if");
						elementutil.clickElement(accountingScreenRecord);
						if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
								.equals(originalAccountingCode.trim().toString())
								&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
										.equals(originalCreditAccNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
										.equals(originalDebitAccNo.trim().toString())
								&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
										.equals(originalChargeAccNo.trim().toString())) {
							// clear field values
							elementutil.clearText(accountingMenu_AccountingCodeTxtField);
							elementutil.clearText(accountingMenu_DescriptionTxtField);
							elementutil.clearText(accountingMenu_CreditAccNoTxtField);
							elementutil.clearText(accountingMenu_DebitAccNoTxtField);
							elementutil.clearText(accountingMenu_ChargeAccountNoTxtField);
							// click on ok button
							elementutil.clickElement(okBtn);
							if (elementutil.getText(errormessages).trim().toString()
									.equals(mandatoryFieldMessage.trim().toString())) {
								log.info("Mandatory Field Message For Accounting->Modify Screen Displayed Is Correct");
							} // end of if
							else {
								log.info(
										"Mandatory Field Message For Accounting->Modify Screen Displayed Is Incorrect");
							} // end of else
								// enter details
							elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
							elementutil.enterText(accountingMenu_DescriptionTxtField, description);
							elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
							elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
							elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
							elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown,
									isAutoDebitCharge);
							// click on ok button
							elementutil.clickElement(okBtn);
							String expectedFieldWiseDataMessage = "Invalid Accounting Code\n"
									+ "Invalid Credit Account Number\n" + "Invalid Debit Account Number\n"
									+ "Invalid Charge Account Number";
							try {
								String actualAccountingModifyScreen_Message = elementutil.getText(errormessages);
								boolean MessagePresent = checkSubstring(actualAccountingModifyScreen_Message,
										mandatoryFieldMessage);
								if (elementutil.getText(errormessages).trim().toString()
										.equals(expectedFieldWiseDataMessage.trim().toString())
										|| elementutil.getText(errormessages).trim().toString().equals(
												mandatoryFieldMessage.trim().toString())
										|| MessagePresent == true) {
									log.info("Field Wise Invalid Data Message For Modify Screen Displayed Is Correct");
								} // end of if
								else if (elementutil.getText(errormessages).trim().toString()
										.equals("Duplicate Record".trim().toString())) {
									log.info(
											"Test Data Provided Is Not Invalid, Duplicate Record : Existing Record With Accounting Code "
													+ accountingCode + " Found");
								} // end of else if
								else {
									log.error(
											"Field Wise Invalid Data Message For Modify Screen Displayed Is Incorrect");
								} // end of else
							} catch (NoSuchElementException e2) {
								log.info("Test Data Provided Is Not Invalid");
							} // end of catch
						} // end of if
						else {
							log.info("Record Mismatch, Record With [ Accounting Code : " + originalAccountingCode
									+ " , Credit Acc Num : " + originalCreditAccNo + " , Debit Acc Num : "
									+ originalDebitAccNo + " , Charge Acc Num : " + originalChargeAccNo
									+ " ] Not Found ");

						} // end of else
					} // end of if
				} catch (NoSuchElementException e2) {
					// System.out.println("in catch");
					if (elementutil.getAttribute(accountingMenu_AccountingCodeTxtField).trim().toString()
							.equals(originalAccountingCode.trim().toString())
							&& elementutil.getAttribute(accountingMenu_CreditAccNoTxtField).trim().toString()
									.equals(originalCreditAccNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_DebitAccNoTxtField).trim().toString()
									.equals(originalDebitAccNo.trim().toString())
							&& elementutil.getAttribute(accountingMenu_ChargeAccountNoTxtField).trim().toString()
									.equals(originalChargeAccNo.trim().toString())) {
						// clear field values
						elementutil.clearText(accountingMenu_AccountingCodeTxtField);
						elementutil.clearText(accountingMenu_DescriptionTxtField);
						elementutil.clearText(accountingMenu_CreditAccNoTxtField);
						elementutil.clearText(accountingMenu_DebitAccNoTxtField);
						elementutil.clearText(accountingMenu_ChargeAccountNoTxtField);
						// click on ok button
						elementutil.clickElement(okBtn);
						if (elementutil.getText(errormessages).trim().toString()
								.equals(mandatoryFieldMessage.trim().toString())) {
							log.info("Mandatory Field Message For Accounting->Modify Screen Displayed Is Correct");
						} // end of if
						else {
							log.info("Mandatory Field Message For Accounting->Modify Screen Displayed Is Incorrect");
						} // end of else
							// enter details
						elementutil.enterText(accountingMenu_AccountingCodeTxtField, accountingCode);
						elementutil.enterText(accountingMenu_DescriptionTxtField, description);
						elementutil.enterText(accountingMenu_CreditAccNoTxtField, creditAccountNo);
						elementutil.enterText(accountingMenu_DebitAccNoTxtField, debitAccountNo);
						elementutil.enterText(accountingMenu_ChargeAccountNoTxtField, chargeAccountNo);
						elementutil.selectDropDownByVisibleText(accountingMenu_IsAutoDebitChargeDropdown,
								isAutoDebitCharge);
						// click on ok button
						elementutil.clickElement(okBtn);
						String expectedFieldWiseDataMessage = "Invalid Accounting Code\n"
								+ "Invalid Credit Account Number\n" + "Invalid Debit Account Number\n"
								+ "Invalid Charge Account Number";
						try {
							String actualAccountingModifyScreen_Message = elementutil.getText(errormessages);
							boolean MessagePresent = checkSubstring(actualAccountingModifyScreen_Message,
									mandatoryFieldMessage);
							if (elementutil.getText(errormessages).trim().toString()
									.equals(expectedFieldWiseDataMessage.trim().toString())
									|| elementutil.getText(errormessages).trim().toString().equals(
											mandatoryFieldMessage.trim().toString())
									|| MessagePresent == true) {
								log.info("Field Wise Invalid Data Message For Modify Screen Displayed Is Correct");
							} // end of if
							else if (elementutil.getText(errormessages).trim().toString()
									.equals("Duplicate Record".trim().toString())) {
								log.info(
										"Test Data Provided Is Not Invalid, Duplicate Record : Existing Record With Accounting Code "
												+ accountingCode + " Found");
							} // end of else if
							else {
								log.error("Field Wise Invalid Data Message For Modify Screen Displayed Is Incorrect");
							} // end of else
						} catch (NoSuchElementException e3) {
							log.info("Test Data Provided Is Not Invalid");
						} // end of catch
					} // end of if
					else {
						log.info("Record Mismatch, Record With [ Accounting Code : " + originalAccountingCode
								+ " , Credit Acc Num : " + originalCreditAccNo + " , Debit Acc Num : "
								+ originalDebitAccNo + " , Charge Acc Num : " + originalChargeAccNo + " ] Not Found ");

					} // end of else

				} // end of catch

			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		logOutOperation();

	}// end of modifyAccountingRecord_InvalidData function

	// ---------------------METHOD FOR VALIDATION MESSAGES CHECKING(SUBSTRING
	// CHECKING) FOR DIFFERENT MENU SCREENS----------------------------
	public static boolean checkSubstring(String S, String I) {
		System.out.println("in checksubstring");
		String[] words = S.split("\n");

		boolean found = true;
		for (String item : words) {
			if (!I.trim().toString().contains(item.trim().toString())) {
				found = false;
				break;
			}
		}
		return found;

	}// end of checkSubstring function

	// -------------------------Duplicate Check Menu
	// Methods----------------------------------------------------

	// ----------Method to List Duplicate Check Record---------------------------
	public void listDuplicateCheckRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String Name = map.get("Name");

			// enter details on filter screen
			elementutil.enterText(duplicateCheckNameField, Name);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(duplicateCheckNameField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details on filter screen
			elementutil.enterText(duplicateCheckNameField, Name);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).equals("No Records available for List operation")) {
					log.info("Record With Duplicate Check Name " + Name + " Not Found");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Duplicate Check Name " + Name + " Not Found");
					log.error("No Records available for List operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				elementutil.SHORT_TIMEOUT();
				elementutil.clickElement(screenRecord);
				String NameStatus = elementutil.getText(duplicateCheckNameStatus).trim().toString();
				if (elementutil.getText(listScreenName).trim().toString().equals(Name)) {
					log.info("Duplicate Check Record " + Name + " is Displayed in List with status " + NameStatus);
				} // end of if
				else {
					log.info("Duplicate Check Record " + Name + " is not Displayed in List");
				} // end of else
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of listDuplicateCheckRecord function

	// ----------Method to Delete Duplicate Check Record---------------------------
	public void deleteDuplicateCheckRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch details
		List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String Name = map.get("Name");

			// enter details on filter screen
			elementutil.enterText(duplicateCheckNameField, Name);

			// click on Reset button
			elementutil.clickElement(btnReset);
			if (elementutil.getText(duplicateCheckNameField).isEmpty()) {
				log.info("Reset Button Is Working Fine");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Fine");
			} // end of else

			// enter details on filter screen
			elementutil.enterText(duplicateCheckNameField, Name);

			// click on ok button
			elementutil.clickElement(okBtn);

			try {
				if (elementutil.getText(errormessages).equals("No Records available for Delete operation")) {
					log.info("Record With Duplicate Check Name " + Name + " Not Found");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With Duplicate Check Name " + Name + " Not Found");
					log.error("No Records available for Delete operation Validation Message displayed Is Incorrect");
				} // end of else
			} catch (NoSuchElementException e) {
				elementutil.SHORT_TIMEOUT();
				elementutil.clickElement(screenRecord);
				elementutil.clickElement(okBtn);
				elementutil.clickElement(cancelBtn);
				
				String CancelMsg = "Operation Cancelled";
				
				if(elementutil.getText(errormessages).equals(CancelMsg)) {
					log.info("Cancel Button is working fine");
				}else {
					log.error("Cancel Button is not working");
				}
				
				elementutil.enterText(duplicateCheckNameField, Name);
				elementutil.clickElement(okBtn);
				elementutil.SHORT_TIMEOUT();
				elementutil.clickElement(screenRecord);
				elementutil.clickElement(okBtn);
				elementutil.clickElement(deleteBtn);
				
				String ValidationMsg = "Record Marked for deletion for";
				try {
				if(elementutil.getText(messages).contains(ValidationMsg)) {
					log.info("Duplicate Check Record "+Name+" is placed in Confirm Delete queue for Delete operation");
					} // end of if
				else {
					log.error("Validation failed for Duplicate Check Record "+Name+"");
					}
				} //end of try
				catch(NoSuchElementException e1) {
					log.error("Validation failed for Duplicate Check Record "+Name+"");
				} // end of catch
			} // end of catch
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of deleteDuplicateCheckRecord function
	
	// ----------Method for Confirm Delete Duplicate Check Record---------------------------
		public void confirmDeleteDuplicateCheckRecord(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {

			// fetch details
			List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
			for (Map<String, String> map : test_Data) {
				String Name = map.get("Name");
				String Action = map.get("Action");

				// enter details on filter screen
				elementutil.enterText(duplicateCheckNameField, Name);

				// click on Reset button
				elementutil.clickElement(btnReset);
				if (elementutil.getText(duplicateCheckNameField).isEmpty()) {
					log.info("Reset Button Is Working Fine");
				} // end of if
				else {
					log.error("Reset Button Is Not Working Fine");
				} // end of else

				// enter details on filter screen
				elementutil.enterText(duplicateCheckNameField, Name);

				// click on ok button
				elementutil.clickElement(okBtn);
				
				String ValidationMsg = "Failed 4 Eyes Principle";
				
				try {
					if (elementutil.getText(errormessages).equals("No Records available for Confirm Delete operation")) {
						log.info("Record With Duplicate Check Name " + Name + " Not Found");
						log.info("No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
					} // end of if
					else if(elementutil.getText(errormessages).contains(ValidationMsg)){
						log.info("Validation message is displayed properly for 4-eyes check principle");
					}else {
						log.info("Record With Duplicate Check Name " + Name + " Not Found");
						log.error("No Records available for Confirm Delete operation Validation Message displayed Is Incorrect");
					} // end of else
				} catch (NoSuchElementException e) {
					elementutil.SHORT_TIMEOUT();
					elementutil.clickElement(screenRecord);
					
					elementutil.SHORT_TIMEOUT();
					elementutil.clickElement(cancelBtn);
					
					String CancelMsg = "Operation Cancelled";
					String ValidationMsgforDeleteAction = "Record deleted for";
					String ValidationMsgforCancelAction = "Deletion cancelled for"; 
					
					if(elementutil.getText(errormessages).equals(CancelMsg)) {
						log.info("Cancel Button is working fine");
					}else {
						log.error("Cancel Button is not working");
					}
					
					elementutil.enterText(duplicateCheckNameField, Name);
					elementutil.clickElement(okBtn);
					elementutil.SHORT_TIMEOUT();
					elementutil.clickElement(screenRecord);
					
					if(Action.equals("Delete")) {
						elementutil.clickElement(confirmDeleteBtn);
						if(elementutil.getText(messages).contains(ValidationMsgforDeleteAction)) {
							log.info("Duplicate Check record "+Name+" gets deleted successfully");
						}else {
							log.error("Duplicate Check record "+Name+" failed to delete");
						}
					}else if(Action.equals("Cancel")){
						elementutil.clickElement(cancelDeleteBtn);
						if(elementutil.getText(messages).contains(ValidationMsgforCancelAction)) {
							log.info("Duplicate Check Confirm Delete Cancel operation for record "+Name+" executed successfully");
						}else {
							log.error("Duplicate Check Confirm Delete Cancel operation is failed to execute for record "+Name+"");
						}	
					}else {
						log.info("For Duplicate Check Confirm Delete - No operation is specified in Excel sheet");
					}
					
				} // end of catch
				elementutil.clickElement(restartWorkflow);
			}
			// perform logout operation
			elementutil.SHORT_TIMEOUT();
			logOutOperation();

		}// end of confirmDeleteDuplicateCheckRecord function
	
	
	// ----------Method to Add Duplicate Check Record---------------------------
	public void addDuplicateCheckRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {
	// fetch details
			List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
			for (Map<String, String> map : test_Data) {
				String DuplicateCheckName = map.get("Duplicate Check Name");
				String Acronym = map.get("Acronym");
				String DestinationBankIFSC = map.get("Destination Bank IFSC/MICR");
				String AmountFixed = map.get("Amount Fixed");
				String Amount = map.get("Amount");
				String Frequency = map.get("Frequency");
				String CustomerName = map.get("Customer Name");
				String CustomerAccountNo = map.get("Customer Account No");
				String AccountType = map.get("Account Type");
				String Categorycode = map.get("Category code");
				String ConsumerReferencenumber = map.get("Consumer Reference number");
				String SchemeReferenceNumber = map.get("Scheme Reference Number");
				
				elementutil.clickElement(okBtn);
				elementutil.acceptAlert();
				
				// enter details on filter screen
				elementutil.enterText(duplicateCheckNameField, DuplicateCheckName);
				elementutil.enterText(acronymField, Acronym);
				elementutil.isElementSelected(destinationBankIFSC_MICRField, DestinationBankIFSC);
				elementutil.isElementSelected(amountFixedField, AmountFixed);
				elementutil.isElementSelected(amountField, Amount);
				elementutil.isElementSelected(frequencyField, Frequency);
				elementutil.isElementSelected(customerNameField, CustomerName);
				elementutil.isElementSelected(customerAccountNoField, CustomerAccountNo);
				elementutil.isElementSelected(accountTypeField, AccountType);
				elementutil.isElementSelected(categorycodeField, Categorycode);
				elementutil.isElementSelected(consumerReferenceNumberField, ConsumerReferencenumber);
				elementutil.isElementSelected(schemeReferenceNumberField, SchemeReferenceNumber);
				
				// click on ok button
				elementutil.clickElement(okBtn);
		
				String ErrorMsg = "db.cif.cms.corp.misc.name.error";
				String BackBtnMsg = "User Pressed Back Key";
				String ExistingRecordMsg = "Record is Already Exists";
				
				try {
					if(elementutil.getText(errormessages).equals(ErrorMsg)) {
						log.info("Validation message displayed properly for "+DuplicateCheckName+" field");
					}else if(elementutil.getText(errormessages).equals(ExistingRecordMsg)){
						log.info("Duplicate Check record "+DuplicateCheckName+" already exist");
					}else {
						log.error("Validation message is not displayed properly for "+DuplicateCheckName+" field");
					}
				} catch (Exception e) {
					
							elementutil.clickElement(backBtn);
							try {
							if(elementutil.getText(errormessages).equals(BackBtnMsg)) {
								log.info("Back button is working properly");
							}else {
								log.error("Back button is not working");
							}
							} catch(NoSuchElementException e1) {
								log.error("Back button is not working");
							}
				
							elementutil.clickElement(okBtn);
							elementutil.clickElement(addConfirmBtn);
				}
				
			elementutil.clickElement(restartWorkflow);
		}
		// perform logout operation
		elementutil.SHORT_TIMEOUT();
		logOutOperation();

	}// end of addDuplicateCheckRecord function
	
	// ----------Method to Modify Duplicate Check Record---------------------------
		public void modifyDuplicateCheckRecordwithInvalidData(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
				List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
				for (Map<String, String> map : test_Data) {
					String Name = map.get("Name");
					String DuplicateCheckName = map.get("Duplicate Check Name");
					String Acronym = map.get("Acronym");
					String DestinationBankIFSC = map.get("Destination Bank IFSC/MICR");
					String AmountFixed = map.get("Amount Fixed");
					String Amount = map.get("Amount");
					String Frequency = map.get("Frequency");
					String CustomerName = map.get("Customer Name");
					String CustomerAccountNo = map.get("Customer Account No");
					String AccountType = map.get("Account Type");
					String Categorycode = map.get("Category code");
					String ConsumerReferencenumber = map.get("Consumer Reference number");
					String SchemeReferenceNumber = map.get("Scheme Reference Number");
				
					// enter details on filter screen
					elementutil.enterText(duplicateCheckNameField, Name);
					
					// click on ok button
					elementutil.clickElement(okBtn);
					
					try {
						if (elementutil.getText(errormessages).equals("No Records available for Modify operation")) {
							log.info("Record With Duplicate Check Name " + Name + " Not Found");
							log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
						}else {
							log.error("No Records available for Modify operation Validation Message displayed Is Incorrect");
						} // end of else
					} catch (NoSuchElementException e) {
					elementutil.clearText(duplicateCheckNameField);
					elementutil.enterText(duplicateCheckNameField, DuplicateCheckName);
					elementutil.clearText(acronymField);
					elementutil.enterText(acronymField, Acronym);
					elementutil.isElementSelected(destinationBankIFSC_MICRField, DestinationBankIFSC);
					elementutil.isElementSelected(amountFixedField, AmountFixed);
					elementutil.isElementSelected(amountField, Amount);
					elementutil.isElementSelected(frequencyField, Frequency);
					elementutil.isElementSelected(customerNameField, CustomerName);
					elementutil.isElementSelected(customerAccountNoField, CustomerAccountNo);
					elementutil.isElementSelected(accountTypeField, AccountType);
					elementutil.isElementSelected(categorycodeField, Categorycode);
					elementutil.isElementSelected(consumerReferenceNumberField, ConsumerReferencenumber);
					elementutil.isElementSelected(schemeReferenceNumberField, SchemeReferenceNumber);
					elementutil.clickElement(okBtn);
					
					elementutil.SHORT_TIMEOUT();
					String ErrorMsg = "db.cif.cms.corp.misc.name.error";
					try{
						if(elementutil.getText(errormessages).equals(ErrorMsg)) {
							log.info("Name field should not be empty for Record "+Name+"");
						}
					}catch(NoSuchElementException e1) {
						log.error("Validation failed for Name field for Record "+Name+"");
					}
					elementutil.clickElement(restartWorkflow);
			}
		}
			// perform logout operation
			elementutil.SHORT_TIMEOUT();
			logOutOperation();
	}// end of modifyDuplicateCheckRecord function
		
		public void modifyDuplicateCheckRecordwithValidData(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {
		// fetch details
				List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
				for (Map<String, String> map : test_Data) {
					String Name = map.get("Name");
					String DuplicateCheckName = map.get("Duplicate Check Name");
					String Acronym = map.get("Acronym");
					String DestinationBankIFSC = map.get("Destination Bank IFSC/MICR");
					String AmountFixed = map.get("Amount Fixed");
					String Amount = map.get("Amount");
					String Frequency = map.get("Frequency");
					String CustomerName = map.get("Customer Name");
					String CustomerAccountNo = map.get("Customer Account No");
					String AccountType = map.get("Account Type");
					String Categorycode = map.get("Category code");
					String ConsumerReferencenumber = map.get("Consumer Reference number");
					String SchemeReferenceNumber = map.get("Scheme Reference Number");
				
					// enter details on filter screen
					elementutil.enterText(duplicateCheckNameField, Name);
					
					// click on ok button
					elementutil.clickElement(okBtn);
			
					String ModifyMsg = "Modifications saved for";
					
					try {
						if (elementutil.getText(errormessages).equals("No Records available for Modify operation")) {
							log.info("Record With Duplicate Check Name " + Name + " Not Found");
							log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
						}else {
							log.error("No Records available for Modify operation Validation Message displayed Is Incorrect");
						} // end of else
					} catch (NoSuchElementException e) {
					elementutil.clearText(duplicateCheckNameField);
					elementutil.enterText(duplicateCheckNameField, DuplicateCheckName);
					elementutil.clearText(acronymField);
					elementutil.enterText(acronymField, Acronym);
					elementutil.isElementSelected(destinationBankIFSC_MICRField, DestinationBankIFSC);
					elementutil.isElementSelected(amountFixedField, AmountFixed);
					elementutil.isElementSelected(amountField, Amount);
					elementutil.isElementSelected(frequencyField, Frequency);
					elementutil.isElementSelected(customerNameField, CustomerName);
					elementutil.isElementSelected(customerAccountNoField, CustomerAccountNo);
					elementutil.isElementSelected(accountTypeField, AccountType);
					elementutil.isElementSelected(categorycodeField, Categorycode);
					elementutil.isElementSelected(consumerReferenceNumberField, ConsumerReferencenumber);
					elementutil.isElementSelected(schemeReferenceNumberField, SchemeReferenceNumber);
					elementutil.clickElement(okBtn);
					
					elementutil.SHORT_TIMEOUT();
					elementutil.clickElement(cancelBtn);
					
					String CancelMsg = "Operation Cancelled"; 
					
					if(elementutil.getText(errormessages).equals(CancelMsg)) {
						log.info("Cancel Button is working fine");
					}else {
						log.error("Cancel Button is not working");
					}
					
					// enter details on filter screen
					elementutil.enterText(duplicateCheckNameField, Name);
					
					// click on ok button
					elementutil.clickElement(okBtn);
					
					elementutil.clearText(duplicateCheckNameField);
					elementutil.enterText(duplicateCheckNameField, DuplicateCheckName);
					elementutil.clearText(acronymField);
					elementutil.enterText(acronymField, Acronym);
					elementutil.isElementSelected(destinationBankIFSC_MICRField, DestinationBankIFSC);
					elementutil.isElementSelected(amountFixedField, AmountFixed);
					elementutil.isElementSelected(amountField, Amount);
					elementutil.isElementSelected(frequencyField, Frequency);
					elementutil.isElementSelected(customerNameField, CustomerName);
					elementutil.isElementSelected(customerAccountNoField, CustomerAccountNo);
					elementutil.isElementSelected(accountTypeField, AccountType);
					elementutil.isElementSelected(categorycodeField, Categorycode);
					elementutil.isElementSelected(consumerReferenceNumberField, ConsumerReferencenumber);
					elementutil.isElementSelected(schemeReferenceNumberField, SchemeReferenceNumber);
					elementutil.clickElement(okBtn);
					
					elementutil.clickElement(modifyBtn);
						try {
							if(elementutil.getText(messages).contains(ModifyMsg)) {
									log.info("Duplicate Check record placed in Approve queue for Modification");
							}
							}catch(NoSuchElementException e3) {
									log.error("Duplicate Check record is failed to Modify");
							}
					
					elementutil.clickElement(restartWorkflow);
					}
				}
			// perform logout operation
			elementutil.SHORT_TIMEOUT();
			logOutOperation();
	}// end of modifyDuplicateCheckRecord function

	// ----------Method to Approve Duplicate Check Record---------------------------
		public void approveDuplicateCheckRecord(String SheetName)
				throws InterruptedException, InvalidFormatException, IOException {

			// fetch details
			List<Map<String, String>> test_Data = fileReader.readCorporateCMSExcel(SheetName);
			for (Map<String, String> map : test_Data) {
				String Name = map.get("Name");
				String Action = map.get("Action");
				
				// enter details on filter screen
				elementutil.enterText(duplicateCheckNameField, Name);

				// click on Reset button
				elementutil.clickElement(btnReset);
				if (elementutil.getText(duplicateCheckNameField).isEmpty()) {
					log.info("Reset Button Is Working Fine");
				} // end of if
				else {
					log.error("Reset Button Is Not Working Fine");
				} // end of else

				// enter details on filter screen
				elementutil.enterText(duplicateCheckNameField, Name);

				// click on ok button
				elementutil.clickElement(okBtn);

				try {
					if (elementutil.getText(errormessages).equals("No Records available for Approve operation")) {
						log.info("Record With Duplicate Check Name " + Name + " Not Found");
						log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
					} // end of if
					else {
						log.info("Record With Duplicate Check Name " + Name + " Not Found");
						log.error("No Records available for Approve operation Validation Message displayed Is Incorrect");
					} // end of else
				} catch (NoSuchElementException e) {
					elementutil.SHORT_TIMEOUT();
					elementutil.clickElement(cancelBtn);
					
					String CancelMsg = "Operation Cancelled";
					String ValidationMsgforApproveAction = "Changes Approved for";
					String ValidationMsgforCancelAction = "Modifications Cancelled for"; 
					
					if(elementutil.getText(errormessages).equals(CancelMsg)) {
						log.info("Cancel Button is working fine");
					}else {
						log.error("Cancel Button is not working");
					}
					
					elementutil.enterText(duplicateCheckNameField, Name);
					elementutil.clickElement(okBtn);
					elementutil.SHORT_TIMEOUT();
					
					if(Action.equals("Approve")) {
						elementutil.clickElement(approveBtn);
						if(elementutil.getText(messages).contains(ValidationMsgforApproveAction)) {
							log.info("Duplicate Check record "+Name+" gets approved successfully");
						}else {
							log.error("Duplicate Check record "+Name+" failed to approve");
						}
					}else if(Action.equals("Cancel")){
						elementutil.clickElement(cancelModifyBtn);
						if(elementutil.getText(messages).contains(ValidationMsgforCancelAction)) {
							log.info("Cancel operation for record "+Name+" executed successfully");
						}else {
							log.error("Cancel operation is failed to execute for record "+Name+"");
						}	
					}else {
						log.info("For Duplicate Check Approve screen - No operation is specified in Excel sheet");
					}
				} // end of catch
				elementutil.clickElement(restartWorkflow);
			}
			// perform logout operation
			elementutil.SHORT_TIMEOUT();
			logOutOperation();
		}// end of approveDuplicateCheckRecord function
	
	
	
	
	

	// -----------------Method to perform Logout
	// Operation----------------------------
	public void logOutOperation() throws InterruptedException {
		elementutil.clickElement(logOutBtn);
		elementutil.clickElement(logoutBtn);
		elementutil.quitBrowser();
	}// end of logOutOperation function

}// end of main class CorporatePage
