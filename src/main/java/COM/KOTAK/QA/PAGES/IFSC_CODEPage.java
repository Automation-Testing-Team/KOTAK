package COM.KOTAK.QA.PAGES;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.FileReadUtils;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class IFSC_CODEPage {
	private WebDriver driver;
	List<Map<String, String>> testData;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(IFSC_CODEPage.class);

	// WebElements for IFSC Code screen
	@FindBy(name = "ifscCode")
	WebElement IFSCCodefield;

	@FindBy(name = "micrCode")
	WebElement MICRCodefield;

	@FindBy(name = "iinCode")
	WebElement IINCodefield;

	@FindBy(name = "name")
	WebElement partyNamefield;

	@FindBy(name = "acronym")
	WebElement acronymfield;

	@FindBy(name = "headOffice")
	WebElement headOfficefield;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(xpath = "//tbody/tr[2]")
	WebElement record;
	
	@FindBy(xpath = "//a[contains(text(),'Restart Workflow')]")
	WebElement restartWorkflow;

	@FindBy(name = "addressLine1")
	WebElement addressLine1field;

	@FindBy(name = "addressLine2")
	WebElement addressLine2field;

	@FindBy(name = "addressLine3")
	WebElement addressLine3field;

	@FindBy(name = "branchName")
	WebElement branchfield;

	@FindBy(name = "branchCode")
	WebElement branchCodefield;

	@FindBy(name = "circleCode")
	WebElement circleCodefield;

	@FindBy(name = "circleName")
	WebElement circleNamefield;

	@FindBy(name = "populationCode")
	WebElement populationCodefield;

	@FindBy(name = "moduleName")
	WebElement moduleNamefield;

	@FindBy(name = "city")
	WebElement cityfield;

	@FindBy(name = "bankTypeDirect")
	WebElement bankTypeDirectdropdown;

	@FindBy(name = "contactInfo")
	WebElement contactfield;

	@FindBy(name = "district")
	WebElement districtfield;

	@FindBy(name = "state")
	WebElement statefield;

	@FindBy(name = "achConnect")
	WebElement NACHParticipantdropdown;

	@FindBy(name = "achDebit")
	WebElement ACHDEBITParticipantdropdown;

	@FindBy(name = "achCredit")
	WebElement ACHCREDITParticipantdropdown;

	@FindBy(name = "apbCredit")
	WebElement APBCREDITParticipantdropdown;

	@FindBy(name = "ecsCredit")
	WebElement ECSCREDITParticipantdropdown;

	@FindBy(name = "ebtSingleFF")
	WebElement EBTSingleFileFormatdropdown;

	@FindBy(name = "rtgsParticipant")
	WebElement RTGSParticipantdropdown;

	@FindBy(name = "neftParticipant")
	WebElement NEFTParticipantdropdown;

	@FindBy(name = "lcbgParticipant")
	WebElement LCBGParticipantdropdown;

	@FindBy(name = "retainOnUpdate")
	WebElement retainonUpdatedropdown;

	@FindBy(name = "retainOnDelete")
	WebElement retainonDeletedropdown;

	@FindBy(name = "headOffice")
	WebElement headOfficedropdown;

	@FindBy(name = "isVirtualIfsc")
	WebElement virtualIFSCdropdown;

	@FindBy(name = "isRRBIfsc")
	WebElement RRBIFSCdropdown;

	@FindBy(name = "gstin")
	WebElement GSTINfield;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
	WebElement validationMsg;
	
	@FindBy(xpath = "//tr[@class='rowcoloreven']//td[3]")
	WebElement IFSCCodetext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement MICRCodetext;

	@FindBy(xpath = "//tr[@class='rowcoloreven']//td[5]")
	WebElement IINCodetext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[6]")
	WebElement PartyNametext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[7]")
	WebElement Acronymtext;
	
	//WebElement for IFSC Code list
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement verifyMICRCode;
	
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[16]")
	WebElement verifyStatus;
	
	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	// IFSC_CODEPage Class Constructor
	public IFSC_CODEPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}

	// ----------View IFSC Code List---------//
	public IFSC_CODEPage viewIFSCCodeList(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {	
		String IFSCCode = map.get("IFSC Code");
		String MICRCode = map.get("MICR Code");
		String IINCode = map.get("IIN Code");
		String PartyName = map.get("Party Name");
		String Acronym = map.get("Acronym");
		String HeadOffice = map.get("Head Office");

		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);

		elementUtil.clickElement(resetBtn);

		String a = elementUtil.getText(IFSCCodefield);
		String b = elementUtil.getText(MICRCodefield);
		String c = elementUtil.getText(IINCodefield);
		String d = elementUtil.getText(partyNamefield);
		String e = elementUtil.getText(acronymfield);
		String f = elementUtil.getText(headOfficefield);
		if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
			log.info("Reset button from IFSCCode list screen is working fine");
		} else {
			log.error("Reset button from IFSCCode list screen is not working");
		}
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);
		elementUtil.clickElement(okBtn);

		String ScreenMsg = "List IFSCCODE";
		String CriteriaMsg = "No Records available for List operation";

		if (validationMsg.getText().equals(ScreenMsg)) {
			String ActualMICRCode = verifyMICRCode.getText();
			String ActualStatus = verifyStatus.getText();
			log.info("IFSC Code with "+ActualMICRCode+" with status "+ActualStatus+" is displayed");
		} else if(validationMsg.getText().equals(CriteriaMsg))
		{
			log.info("IFSC Code with MICR " + MICRCode + " is not available for View Operation");
		}else {
			log.error("Validation message is not displayed properly");
		}
		elementUtil.clickElement(restartWorkflow);
		}
		elementUtil.SHORT_TIMEOUT();
		logOutOperation();
		return new IFSC_CODEPage(driver);
	}

	// -----------------Add IFSC Code-----------------//
	public IFSC_CODEPage addIFSCCode(String SheetName, Integer Row)
			throws InvalidFormatException, IOException, InterruptedException {
		testData = fileReader.readSetupExcel(SheetName);
		String IFSCCode = testData.get(Row).get("IFSC Code");
		String MICRCode = testData.get(Row).get("MICR Code");
		String IINCode = testData.get(Row).get("IIN Code");
		String PartyName = testData.get(Row).get("Party Name");
		String Acronym = testData.get(Row).get("Acronym");
		String AddressLine1 = testData.get(Row).get("Address Line 1");
		String AddressLine2 = testData.get(Row).get("Address Line 2");
		String AddressLine3 = testData.get(Row).get("Address Line 3");
		String Branch = testData.get(Row).get("Branch");
		String BranchCode = testData.get(Row).get("Branch Code");
		String CircleCode = testData.get(Row).get("Circle Code");
		String CircleName = testData.get(Row).get("Circle Name");
		String PopulationCode = testData.get(Row).get("Population Code");
		String ModuleName = testData.get(Row).get("Module Name");
		String City = testData.get(Row).get("City");
		String BankTypeDirectorIndirect = testData.get(Row).get("Bank Type Direct/Indirect");
		String Contact = testData.get(Row).get("Contact");
		String District = testData.get(Row).get("District");
		String State = testData.get(Row).get("State");
		String NACHParticipant = testData.get(Row).get("NACH Participant");
		String ACHDEBITParticipant = testData.get(Row).get("ACH DEBIT Participant");
		String ACHCREDITParticipant = testData.get(Row).get("ACH CREDIT Participant");
		String APBCREDITParticipant = testData.get(Row).get("APB CREDIT Participant");
		String ECSCREDITParticipant = testData.get(Row).get("ECS CREDIT Participant");
		String EBTSingleFileFormat = testData.get(Row).get("EBT Single File Format");
		String RTGSParticipant = testData.get(Row).get("RTGS Participant");
		String NEFTParticipant = testData.get(Row).get("NEFT Participant");
		String LCBGParticipant = testData.get(Row).get("LCBG Participant");
		String RetainonUpdate = testData.get(Row).get("Retain on Update");
		String RetainonDelete = testData.get(Row).get("Retain on Delete");
		String HeadOffice = testData.get(Row).get("Head Office");
		String VirtualIFSC = testData.get(Row).get("Virtual IFSC");
		String RRBIFSC = testData.get(Row).get("RRB IFSC");
		String GSTIN = testData.get(Row).get("GSTIN");

		elementUtil.TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(addressLine1field, AddressLine1);
		elementUtil.enterText(addressLine2field, AddressLine2);
		elementUtil.enterText(addressLine3field, AddressLine3);
		elementUtil.enterText(branchfield, Branch);
		elementUtil.enterText(branchCodefield, BranchCode);
		elementUtil.enterText(circleCodefield, CircleCode);
		elementUtil.enterText(circleNamefield, CircleName);
		elementUtil.enterText(populationCodefield, PopulationCode);
		elementUtil.enterText(moduleNamefield, ModuleName);
		elementUtil.enterText(cityfield, City);
		elementUtil.selectDropDownByVisibleText(bankTypeDirectdropdown, BankTypeDirectorIndirect);
		elementUtil.enterText(contactfield, Contact);
		elementUtil.enterText(districtfield, District);
		elementUtil.enterText(statefield, State);
		elementUtil.clickElement(NACHParticipantdropdown);
		elementUtil.selectDropDownByVisibleText(NACHParticipantdropdown, NACHParticipant);
		elementUtil.clickElement(ACHDEBITParticipantdropdown);
		elementUtil.selectDropDownByVisibleText(ACHDEBITParticipantdropdown, ACHDEBITParticipant);
		elementUtil.selectDropDownByVisibleText(ACHCREDITParticipantdropdown, ACHCREDITParticipant);
		elementUtil.selectDropDownByVisibleText(APBCREDITParticipantdropdown, APBCREDITParticipant);
		elementUtil.selectDropDownByVisibleText(ECSCREDITParticipantdropdown, ECSCREDITParticipant);
		elementUtil.selectDropDownByVisibleText(EBTSingleFileFormatdropdown, EBTSingleFileFormat);
		elementUtil.selectDropDownByVisibleText(RTGSParticipantdropdown, RTGSParticipant);
		elementUtil.selectDropDownByVisibleText(NEFTParticipantdropdown, NEFTParticipant);
		elementUtil.selectDropDownByVisibleText(LCBGParticipantdropdown, LCBGParticipant);
		elementUtil.selectDropDownByVisibleText(retainonUpdatedropdown, RetainonUpdate);
		elementUtil.selectDropDownByVisibleText(retainonDeletedropdown, RetainonDelete);
		elementUtil.selectDropDownByVisibleText(headOfficedropdown, HeadOffice);
		elementUtil.selectDropDownByVisibleText(virtualIFSCdropdown, VirtualIFSC);
		elementUtil.selectDropDownByVisibleText(RRBIFSCdropdown, RRBIFSC);
		elementUtil.enterText(GSTINfield, GSTIN);

		elementUtil.clickElement(okBtn);
		String validateMsg = elementUtil.getText(validationMsg);
		String IFSCCodefieldmsg = "Invalid IFSC Code";
		String MICRCodefieldmsg = "Invalid MICR Code";
		String IINCodefieldmsg = "Invalid IIN Code";
		String AddressLine1fieldmsg = "Address Line 1 contains invalid characters";
		String AddressLine2fieldmsg = "Address Line 2 contains invalid characters";
		String AddressLine3fieldmsg = "Address Line 3 contains invalid characters";
		String branchfieldmsg = "Atleast one code must be present";
		String branchCodefieldmsg = "Atleast one code must be present";
		String circleCodefieldmsg = "Atleast one code must be present";
		String circleNamefieldmsg = "Atleast one code must be present";
		String populationCodfieldemsg = "Atleast one code must be present";
		String moduleNamefieldmsg = "Atleast one code must be present";
		String cityfieldmsg = "Atleast one code must be present";
		String contactfieldmsg = "Atleast one code must be present";
		String districtfieldmsg = "Atleast one code must be present";
		String statefieldmsg = "Atleast one code must be present";
		String GSTINfieldmsg = "Atleast one code must be present";

		if (validateMsg.contains(IFSCCodefieldmsg)) {
			System.out.println("Validation is proper for " + IFSCCodefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(MICRCodefieldmsg)) {
			System.out.println("Validation is proper for " + MICRCodefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(IINCodefieldmsg)) {
			System.out.println("Validation is proper for " + IINCodefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(AddressLine1fieldmsg)) {
			System.out.println("Validation is proper for " + AddressLine1fieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(AddressLine2fieldmsg)) {
			System.out.println("Validation is proper for " + AddressLine2fieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(AddressLine3fieldmsg)) {
			System.out.println("Validation is proper for " + AddressLine3fieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(branchfieldmsg)) {
			System.out.println("Validation is proper for " + branchfieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(branchCodefieldmsg)) {
			System.out.println("Validation is proper for " + branchCodefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(circleCodefieldmsg)) {
			System.out.println("Validation is proper for " + circleCodefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(circleNamefieldmsg)) {
			System.out.println("Validation is proper for " + circleNamefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(populationCodfieldemsg)) {
			System.out.println("Validation is proper for " + populationCodfieldemsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(moduleNamefieldmsg)) {
			System.out.println("Validation is proper for " + moduleNamefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(cityfieldmsg)) {
			System.out.println("Validation is proper for " + cityfieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(contactfieldmsg)) {
			System.out.println("Validation is proper for " + contactfieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(districtfieldmsg)) {
			System.out.println("Validation is proper for " + districtfieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(statefieldmsg)) {
			System.out.println("Validation is proper for " + statefieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else if (validateMsg.contains(GSTINfieldmsg)) {
			System.out.println("Validation is proper for " + GSTINfieldmsg + " ");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		} else {
			System.out.println("Validation is failed for checking Invalid data while adding IFSC Code");
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		}
		return new IFSC_CODEPage(driver);
	}

	// --------------Delete IFSC Code with Invalid data------------------//
	public IFSC_CODEPage deleteIFSCCodewithInvaliddata(String SheetName, Integer Row)
			throws InvalidFormatException, IOException, InterruptedException {
		testData = fileReader.readSetupExcel(SheetName);
		String IFSCCode = testData.get(Row).get("IFSC Code");
		String MICRCode = testData.get(Row).get("MICR Code");
		String IINCode = testData.get(Row).get("IIN Code");
		String PartyName = testData.get(Row).get("Party Name");
		String Acronym = testData.get(Row).get("Acronym");
		String HeadOffice = testData.get(Row).get("Head Office");

		elementUtil.TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);

		elementUtil.clickElement(resetBtn);
		String a = elementUtil.getText(IFSCCodefield);
		String b = elementUtil.getText(MICRCodefield);
		String c = elementUtil.getText(IINCodefield);
		String d = elementUtil.getText(partyNamefield);
		String e = elementUtil.getText(acronymfield);
		String f = elementUtil.getText(headOfficefield);

		if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
			System.out.println("Reset button from IFSCCode Delete screen is working fine");
		} else {
			System.out.println("Reset button from IFSCCode Delete screen is not working");
		}
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);

		elementUtil.clickElement(okBtn);
		String g = "No Records available for Delete operation";
		String validateMsg = elementUtil.getText(validationMsg);
		if (validateMsg.equals(g)) {
			System.out.println("Validation is proper for Invalid data in Row " + Row + " ");
		} else {
			System.out.println("Validation is failed for Invalid data in Row " + Row + " ");
		}
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
		return new IFSC_CODEPage(driver);
	}

	// ------------Delete IFSC Code with Valid data--------------//
	public IFSC_CODEPage deleteIFSCCodewithValiddata(String SheetName, Integer Row)
			throws InvalidFormatException, IOException, InterruptedException {
		testData = fileReader.readSetupExcel(SheetName);
		String IFSCCode = testData.get(Row).get("IFSC Code");
		String MICRCode = testData.get(Row).get("MICR Code");
		String IINCode = testData.get(Row).get("IIN Code");
		String PartyName = testData.get(Row).get("Party Name");
		String Acronym = testData.get(Row).get("Acronym");
		String HeadOffice = testData.get(Row).get("Head Office");

		elementUtil.TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);

		elementUtil.clickElement(resetBtn);
		String a = elementUtil.getText(IFSCCodefield);
		String b = elementUtil.getText(MICRCodefield);
		String c = elementUtil.getText(IINCodefield);
		String d = elementUtil.getText(partyNamefield);
		String e = elementUtil.getText(acronymfield);
		String f = elementUtil.getText(headOfficefield);

		if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
			System.out.println("Reset button from IFSCCode Delete screen is working fine");
		} else {
			System.out.println("Reset button from IFSCCode Delete screen is not working");
		}
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(IFSCCodefield, IFSCCode);
		elementUtil.enterText(MICRCodefield, MICRCode);
		elementUtil.enterText(IINCodefield, IINCode);
		elementUtil.enterText(partyNamefield, PartyName);
		elementUtil.enterText(acronymfield, Acronym);
		elementUtil.enterText(headOfficefield, HeadOffice);

		elementUtil.clickElement(okBtn);
		elementUtil.clickElement(record);
		elementUtil.clickElement(okBtn);

		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
		return new IFSC_CODEPage(driver);
	}
	
	//-----------------Method to perform Logout Operation----------------------------
	public void logOutOperation() throws InterruptedException {
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
	}// end of logOutOperation function
}
