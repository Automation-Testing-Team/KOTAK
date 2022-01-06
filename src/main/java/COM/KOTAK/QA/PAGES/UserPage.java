package COM.KOTAK.QA.PAGES;

//imports
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
import cucumber.api.java.et.Eeldades;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class UserPage {

	List<Map<String, String>> testData;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	private WebDriver driver;
	Logger log = Logger.getLogger(UserPage.class);

	// User Page Xpaths
	@FindBy(name = "groupName")
	WebElement groupNameDropdown;
	
	@FindBy(name = "content(groupId)")
	WebElement groupDropdown;

	@FindBy(name="group")
	WebElement groupNameTxtField;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(name = "org.apache.struts.taglib.html.CANCEL")
	WebElement cancelBtn;

	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "fullName")
	WebElement fullName;
	
	@FindBy(name = "fullname")
	WebElement fullname;
	
	@FindBy(name="username")
	WebElement username;

	@FindBy(name = "locale")
	WebElement language;

	@FindBy(name = "initials")
	WebElement initials;

	@FindBy(name = "emailAddress")
	WebElement emailAddress;

	@FindBy(name = "mobileNo")
	WebElement mobileNo;

	@FindBy(name = "isSupervisor")
	WebElement isSupervisor;

	@FindBy(name = "profileId")
	WebElement profile;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "verifyPassword")
	WebElement verifyPassword;

	@FindBy(name = "externalId")
	WebElement externalId;

	@FindBy(name = "LOGINMATRIX")
	WebElement LOGINMATRIXlabelField;

	@FindBy(id = "codeId")
	WebElement userMappingCodedropdown;

	@FindBy(name = "codeValue")
	WebElement userMappingCode;

	@FindBy(name = "sec.param.type")
	WebElement securityParameters;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement btnOk;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/form/p/input[2]")
	WebElement btnConfirm;

	@FindBy(id = "inf_username")
	WebElement errorUsername;

	@FindBy(id = "inf_fullName")
	WebElement errorFullname;

	@FindBy(id = "inf_profileId")
	WebElement errorProfileId;

	@FindBy(name = "org.apache.struts.taglib.html.CANCEL")
	WebElement btnCancel;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement btnReset;

	@FindBy(id = "btnBlockUnblock")
	WebElement blockUnblockBtn;

	// WebElements for User-Approve page btn
	@FindBy(xpath = "//input[@value='OK']")
	WebElement OkBtn;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(xpath = "//tr[@class='rowcoloreven']")
	WebElement record;

	@FindBy(name = "approve")
	WebElement approveBtn;

	@FindBy(name = "reject")
	WebElement rejectBtn;

	@FindBy(name = "repair")
	WebElement toRepairBtn;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errorMessages;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
	WebElement validationMsg;

	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr[1]/td/b")
	WebElement screenMsg;

	@FindBy(xpath="//td[@class='HeaderTitle']")
	WebElement headerMsg;

	// Cancel Error Msg Xpath
	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement cancelErrorMsg;

	// Text fields Error Msg Xpath
	@FindBy(xpath = "//td[@id='inf_username']")
	WebElement userNameErrorMsg;

	@FindBy(xpath = "//td[@id='inf_fullName']")
	WebElement fullNameErrorMsg;

	@FindBy(xpath = "//td[@id='inf_profileId']")
	WebElement profileErrorMsg;

	@FindBy(xpath = "//a[@class='restartInHeader']")
	WebElement btnRestartWorkFLow;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	WebElement userOk;

	// Webelements for View user screen filter
	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement viewUserName;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[6]")
	WebElement viewUserStatus;

	@FindBy(name = "code")
	WebElement ifscCode;

	@FindBy(name = "group")
	WebElement group;

	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]")
	WebElement approveScreenUserNameTxt;

	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]")
	WebElement removeScreenUserName;

	@FindBy(id="btnRemove")
	WebElement removeBtn;

	@FindBy(name = "filter")
	WebElement statusDropdown;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[6]")
	WebElement userListScreenRecordStatusValue;

	@FindBy(xpath = "//button[normalize-space()='Close']")
	WebElement closeBtn;

	@FindBy(xpath = "//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkFlowBtn;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-log-out']")
	WebElement mainPageLogOutButton;

	@FindBy(id = "content")
	WebElement mainFrame;

	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;

	@FindBy(xpath = "//p[@class='label']")
	WebElement validateFilterMsg;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement listScreenRecord;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement listScreenRecordUserName;

	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]")
	WebElement blockUnblockScreenUserName;
	
	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	// UserPage Class Constructor
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.homePage = new HomePage(driver);
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);

	}//end

	//--------------Method to Add User Record------------------------//
	public void addUser(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupNameDropdown = map.get("GroupName");
			String Username = map.get("Username");
			String FullName = map.get("Full Name");
			String Language = map.get("Language");
			String Initials = map.get("Initials");
			String EmailAddress = map.get("Email Address");
			String MobileNo = map.get("Mobile No.");
			String IsSupervisor = map.get("Is Supervisor");
			String Profile = map.get("Profile");
			String Password = map.get("Password");
			String VerifyPassword = map.get("Verify Password");
			String ExternalUserID = map.get("External User ID");
			String LOGINMATRIXlabel = map.get("LOGINMATRIX.label");
			String UserMappingCodeDropdown = map.get("User Mapping Code Dropdown");
			String UserMappingCode = map.get("IFSC Code(User Mapping Code)");

			elementUtil.selectDropDownByVisibleText(groupNameDropdown, GroupNameDropdown);
			elementUtil.clickElement(okBtn);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(cancelBtn);

			String ActualCancelBtnValidationMsg = elementUtil.getText(errorMessages);
			String ExpectedCancelBtnValidationMsg = "Operation Add new user was cancelled.";

			if (ActualCancelBtnValidationMsg.trim().toString().equals(ExpectedCancelBtnValidationMsg.trim().toString())) {
				log.info("Cancel button is working fine for User-->Add Screen");
			} else {
				log.error("Cancel button is not working for User-->Add Screen");
			}

			elementUtil.selectDropDownByVisibleText(groupNameDropdown, GroupNameDropdown);
			elementUtil.clickElement(okBtn);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(btnOk);

			String ActualUsernameFieldValidation = errorUsername.getText();
			String ActualFullnameFieldValidation = errorFullname.getText();
			String ActualProfileIdFieldValidation = errorProfileId.getText();
			String ExpectedFieldValidation = "ERROR: required";

			if (ActualUsernameFieldValidation.equals(ExpectedFieldValidation)
					&& ActualFullnameFieldValidation.equals(ExpectedFieldValidation)
					&& ActualProfileIdFieldValidation.equals(ExpectedFieldValidation)) {
				log.info("Required fields are validated for User-->Add Screen");
			} else {
				log.error("Required field validation failed for User-->Add Screen");
			}

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(username, Username);
			elementUtil.enterText(fullName, FullName);
			elementUtil.selectDropDownByVisibleText(language, Language);
			elementUtil.enterText(initials, Initials);
			elementUtil.enterText(emailAddress, EmailAddress);
			elementUtil.enterText(mobileNo, MobileNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(isSupervisor, IsSupervisor);
			elementUtil.selectDropDownByVisibleText(profile, Profile);
			elementUtil.enterText(password, Password);
			elementUtil.enterText(verifyPassword, VerifyPassword);
			elementUtil.enterText(externalId, ExternalUserID);
			elementUtil.enterText(LOGINMATRIXlabelField,LOGINMATRIXlabel);
			elementUtil.selectDropDownByVisibleText(userMappingCodedropdown, UserMappingCodeDropdown);
			elementUtil.enterText(userMappingCode, UserMappingCode);

			elementUtil.clickElement(btnOk);
			elementUtil.TIMEOUT();

			String ExistingMsg = "User already exists";
			String ValidationMsg = "Operation Add new user executed successfully. "+GroupNameDropdown+"/"+Username+" placed in APPROVE queue.";
			
			try {

				if(elementUtil.getText(errorMessages).trim().toString().equals(ExistingMsg))
				{
					log.info("Duplicate Record Found Record With User Name "+Username+" Already Exists");
				}//end of if
				else
				{
					log.error("Test Data Provided For User Add Operation Is Not As Valid Format");
				}//end of else
			} catch (NoSuchElementException e) {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(btnConfirm);
				elementUtil.SHORT_TIMEOUT();
				if(elementUtil.getText(messages).equals(ValidationMsg))
				{
					log.info("Record With User Name "+Username+" placed in Approve queue for Add Operation");
				}else {
					log.error("Record With User Name "+Username+" failed to add");
				}
			}//end of catch
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		//perform logout operation
		elementUtil.SHORT_TIMEOUT();
		logOutOperation();
	}//end of userAdd function

	// --------------Method to Approve User Record------------------------//
	public void approveUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Username = map.get("Username");
			String IFSC = map.get("IFSC");
			String FullName = map.get("Full Name");
			String Group = map.get("Group");
			String Operation=map.get("Operation");

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);
			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for User-->Approve Screen");
			} else {
				log.error("Reset Button is not working for User-->Approve Screen");
			}

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);
			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Approve operation given the search criteria";
			String ValidationMsg = "Operation Approve user changes failed to execute: User cannot approve own modification.";
			String ApprovalMsg = "Operation Approve user changes executed successfully. "+Group+"/"+Username+" placed in active queue.";
			String RejectionMsg = "Operation Reject user changes executed successfully.";
			String RemoveMsg = "Operation Approve user changes executed successfully. "+Group+"/"+Username+" placed in DELETED queue.";
			String ToRepairMsg = "Operation Send to repair executed successfully. "+Group+"/"+Username+" placed in REPAIR queue.";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
			{
				log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For Approve Operation" );
			}else {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(record);
					
					try {
					if(elementUtil.getText(errorMessages).equals(ValidationMsg))
					{
						log.info("Approval of Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Failed. User cannot approve own modification" );
					}
					} catch (NoSuchElementException e) {
						switch (Operation) {
						case "Approve":
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(approveBtn);
							break;

						case "Reject":
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(rejectBtn);
							break;
							
						case "To Repair":	
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(toRepairBtn);
							break;
						}
						
						if(elementUtil.getText(messages).equals(ApprovalMsg))
						{
							log.info("Record With Values "+Username+" Approved Successfully" );
						} else if(elementUtil.getText(messages).contains(RejectionMsg))
						{
							log.info("Record With Values "+Username+" Rejected Successfully" );
						}else if(elementUtil.getText(messages).equals(ToRepairMsg))
						{
							log.info("Record With Values "+Username+" Sent To Repair Queue Successfully" );
						}else if(elementUtil.getText(messages).equals(RemoveMsg)){
							log.info("Record With Values "+Username+" removed Successfully" );
						}else {
							log.info("Profile "+Username+" is failed to "+Operation+"");
						}
				}//end of catch
			}//end of else
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		// perform logout operation
		logOutOperation();
	}//end of userApprove function

	// --------------Method to Remove User Record------------------------//
	public void removeUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Username = map.get("Username");
			String IFSC=map.get("IFSC");
			String FullName = map.get("Full Name");
			String Group = map.get("Group");
			String Status = map.get("Status");

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);
			elementUtil.enterText(statusDropdown,Status);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for User-->Remove Screen");
			} else {
				log.error("Reset Button is not working for User-->Remove Screen");
			}

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);
			elementUtil.enterText(statusDropdown,Status);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Remove operation given the search criteria";
			String ValidationMsg = "Operation Remove user executed successfully. "+Group+"/"+Username+" placed in APPROVE queue.";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
			{
				log.info("User record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For Remove Operation" );
			}else {
				elementUtil.clickElement(record);
				if(elementUtil.getText(removeScreenUserName).trim().toString().equals(Group+"/"+Username))
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(removeBtn);
					elementUtil.SHORT_TIMEOUT();

					if(elementUtil.getText(messages).equals(ValidationMsg))
					{
						log.info("User record With UserName "+Username+" placed in Approve queue for Remove Operation");
					}else {
						log.error("User record With UserName "+Username+" is failed to remove");
					}

				}//end of if
				else
				{
					log.error("Record Mismatch, User record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For Remove Operation");
				}
			}//end of else
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		// perform logout operation
		logOutOperation();
	}//end of userRemove function

	// --------------Method to Block/Unblock User Record------------------------//
	public void userBlockUnblockRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Username = map.get("Username");
			String IFSC = map.get("IFSC");
			String FullName = map.get("Full Name");
			String Group = map.get("Group");

			//enter details on filter screen
			elementUtil.clearText(username);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);

			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for User-->Block/Unblock screen");
			} else {
				log.error("Reset Button is not working for User-->Block/Unblock screen");
			}

			//enter details on filter screen
			elementUtil.clearText(username);
			elementUtil.enterText(userName, Username);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, FullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,Group);

			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Block/Unblock operation";
			String ValidationMsg = "Operation Block/Unblock user executed successfully. "+Group+"/"+Username+" placed in APPROVE queue.";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
			{
				log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For Block/Unblock Operation" );
			} else {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(record);
				elementUtil.SHORT_TIMEOUT();
				if(elementUtil.getText(blockUnblockScreenUserName).trim().toString().equals(Group+"/"+Username))
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(blockUnblockBtn);
					if(elementUtil.getText(messages).equals(ValidationMsg))
					{
						log.info("Record With UserName "+Username+" placed in Approve queue for Blocked/Unblocked Operation");
					}//end of if

				}//end of if
				else
				{
					log.error("Record Mismatch, Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For Block/Unblock Operation");
				}
			}//end of else
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		// perform logout operation
		logOutOperation();
	}//end of userBlockUnblockRecord function

	// --------------Method to Modify User Record------------------------//
	public void modifyUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String OriginalUsername = map.get("Original Username");
			String OriginalIFSC=map.get("IFSC");
			String OriginalFullName = map.get("OriginalFullName");
			String OriginalGroup = map.get("OriginalGroup");
			String Status = map.get("Status");
			String Username = map.get("Username");
			String FullName = map.get("FullName");
			String Language = map.get("Language");
			String Initials = map.get("Initials");
			String EmailAddress = map.get("Email Address");
			String MobileNo = map.get("Mobile No.");
			String IsSupervisor = map.get("Is Supervisor");
			String Group = map.get("Group");
			String Profile = map.get("Profile");
			String Password = map.get("Password");
			String VerifyPassword = map.get("Verify Password");
			String ExternalUserID = map.get("External User ID");
			String LOGINMATRIXlabel = map.get("LOGINMATRIX.label");
			String UserMappingCodeDropdown = map.get("User Mapping Code Dropdown");
			String UserMappingCode=map.get("IFSC Code(User Mapping Code)");

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName,OriginalUsername);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, OriginalIFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, OriginalFullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,OriginalGroup);
			elementUtil.selectDropDownByVisibleText(statusDropdown, Status);
			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for User-->Modify Screen");
			} else {
				log.error("Reset Button is not working for User-->Modify Screen");
			}//end

			//enter details on filter screen
			elementUtil.clearText(userName);
			elementUtil.enterText(userName,OriginalUsername);
			elementUtil.clearText(ifscCode);
			elementUtil.enterText(ifscCode, OriginalIFSC);
			elementUtil.clearText(fullname);
			elementUtil.enterText(fullname, OriginalFullName);
			elementUtil.clearText(groupNameTxtField);
			elementUtil.enterText(groupNameTxtField,OriginalGroup);
			elementUtil.selectDropDownByVisibleText(statusDropdown, Status);
			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Modify operation given the search criteria";
			String ValidationMsg = "Operation Modify/Repair user executed successfully. "+Group+"/"+Username+" placed in APPROVE queue.";
			String ExistingMsg = "User already exists";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
			{
				log.info("Record With Values [ " +OriginalUsername+ " , " +OriginalIFSC+ " , " +OriginalFullName+ " , " +OriginalGroup+ " ] Not Found For Modify/Repair Operation" );
			} else {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(record);
				if(elementUtil.getAttribute(username).equals(OriginalUsername))
				{
					elementUtil.clearText(username);
					elementUtil.enterText(username,Username);
					elementUtil.clearText(fullName);
					elementUtil.enterText(fullName,FullName);
					elementUtil.selectDropDownByVisibleText(language, Language);
					elementUtil.clearText(initials);
					elementUtil.enterText(initials, Initials);
					elementUtil.clearText(emailAddress);
					elementUtil.enterText(emailAddress, EmailAddress);
					elementUtil.clearText(mobileNo);
					elementUtil.enterText(mobileNo, MobileNo);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(isSupervisor, IsSupervisor);
					elementUtil.selectDropDownByVisibleText(groupDropdown, Group);
					elementUtil.selectDropDownByVisibleText(profile, Profile);
					elementUtil.clearText(password);
					elementUtil.enterText(password, Password);
					elementUtil.clearText(verifyPassword);
					elementUtil.enterText(verifyPassword, VerifyPassword);
					elementUtil.clearText(externalId);
					elementUtil.enterText(externalId, ExternalUserID);
					elementUtil.selectDropDownByVisibleText(LOGINMATRIXlabelField, LOGINMATRIXlabel);
					elementUtil.selectDropDownByVisibleText(userMappingCodedropdown, UserMappingCodeDropdown);
					elementUtil.clearText(userMappingCode);
					elementUtil.enterText(userMappingCode, UserMappingCode);
					
					elementUtil.clickElement(okBtn);
					try {
						if(elementUtil.getText(errorMessages).equals(ExistingMsg))
						{
							log.info("Duplicate Record Found , Record With " +Username+ " Already Exists");
						}//end of if
						else
						{
							log.info("Test Data Provided For Modify/Repair Operation Is Not As Per Valid Format");
						}//end of else
					} catch (NoSuchElementException e) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(okBtn);
		
						if(elementUtil.getText(messages).equals(ValidationMsg))
						{
							log.info("Record With UserName "+Username+" placed in Approve queue for Modify Operation");
						}else {
							log.error("Record With UserName "+Username+" failed to modify");
						}
					}//end of catch

				}//end of if
				else
				{
					log.info("Record Mismatch, Record With Values [ " +OriginalUsername+ " , " +OriginalIFSC+ " , " +OriginalFullName+ " , " +OriginalGroup+ " ] Not Found For Modify/Repair Operation" );		
				}
		}//end of else
			elementUtil.clickElement(restartWorkFlowBtn);
	}//end of for
	// perform logout operation
	logOutOperation();
}//end of modifyUserRecord function

//--------------Method to List User Record------------------------//
public void listUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	testData = fileReader.readSetupExcel(SheetName);
	for (Map<String, String> map : testData) {
		String Username = map.get("Username");
		String IFSC=map.get("IFSC");
		String FullName = map.get("Full Name");
		String Group = map.get("Group");
		String Status=map.get("Status");

		//enter details on filter screen
		elementUtil.enterText(userName, Username);
		elementUtil.enterText(ifscCode, IFSC);
		elementUtil.enterText(fullname, FullName);
		elementUtil.enterText(groupNameTxtField,Group);
		elementUtil.selectDropDownByVisibleText(statusDropdown, Status);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(btnReset);

		if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
			log.info("Reset Button is working fine for User-->View Screen");
		} else {
			log.error("Reset Button is not working for User-->View Screen");
		}

		//enter details on filter screen
		elementUtil.enterText(userName, Username);
		elementUtil.enterText(ifscCode, IFSC);
		elementUtil.enterText(fullname, FullName);
		elementUtil.enterText(groupNameTxtField,Group);
		elementUtil.selectDropDownByVisibleText(statusDropdown, Status);

		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		String CriteriaMsg = "No items available for List operation given the search criteria";
		if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
		{
			log.info("User record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +Group+ " ] Not Found For List Operation" );
		}//end of if

		else
		{
			elementUtil.SHORT_TIMEOUT();
			String userRecordStatusValue=elementUtil.getText(userListScreenRecordStatusValue);
			String listScreenRecordUserNameValue=elementUtil.getText(listScreenRecordUserName);
			System.out.println(userRecordStatusValue+""+listScreenRecordUserNameValue);
			if(listScreenRecordUserNameValue.trim().toString().equals(Group+"/"+Username.trim().toString()))
			{
				log.info("User record With "+Username+" Is Displayed In List With Status " +userRecordStatusValue);
			}//end of if
			else
			{
				log.info("User record With "+Username+" Is Not Displayed In List" );

			}//end of else
		}//end of else
		elementUtil.clickElement(restartWorkFlowBtn);
	}//end of for 

	// perform logout operation
	logOutOperation();
}//end of listUserRecord function

//-----------------Method to perform Logout Operation----------------------------
public void logOutOperation() throws InterruptedException {
	elementUtil.clickElement(logOutBtn);
	elementUtil.clickElement(logoutBtn);
	elementUtil.quitBrowser();
}// end of logOutOperation function


}//end of main class UserPage
