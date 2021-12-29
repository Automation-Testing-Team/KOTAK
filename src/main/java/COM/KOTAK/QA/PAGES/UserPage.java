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
	WebElement userAdd_Modify_Screen_UserName;

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

	@FindBy(xpath="//tr[@class='rowcoloreven']//td[8]")
	WebElement screenRecord;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement modifyScreenRecord;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement removeScreenRecord;

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
	@FindBy(name = "userName")
	WebElement username;

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

	@FindBy(xpath="//*[@id=\"pageBody\"]/p")
	WebElement listScreenErrorMessage;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement listScreenRecord;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement listScreenRecordUserName;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement blockUnblockScreenRecord;

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
				log.info("Cancel button is working fine");
			} else {
				log.error("Cancel button is not working");
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
				log.info("Required fields are validated");
			} else {
				log.error("Required field validation failed");
			}

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(userAdd_Modify_Screen_UserName, Username);
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

			try {

				if(elementUtil.getText(errorMessages).trim().toString().equals("User already exists".trim().toString()))
				{
					log.info("Duplicate Record Found Record With User Name " +Username+ " Already Exists");
				}//end of if
				else
				{
					log.error("Test Data Provided For User Add Operation Is Not As Valid Format");
				}//end of else
			} catch (NoSuchElementException e) {
				elementUtil.clickElement(btnConfirm);
				String userAddValidationMessage="Operation Add new user executed successfully. "+GroupNameDropdown+"/"+Username+ "placed in APPROVE queue.";
				if(elementUtil.getText(messages).trim().toString().equals(userAddValidationMessage.trim().toString()))
				{
					log.info("Record With User Name " +Username+ " Added Successfully");
				}
			}//end of catch
			elementUtil.SHORT_TIMEOUT();
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
			String GroupName = map.get("GroupName");
			String Username = map.get("Username");
			String FullName = map.get("Full Name");
			String IFSC=map.get("IFSC Code(User Mapping Code)");
			String operation=map.get("Operation");

			elementUtil.SHORT_TIMEOUT();

			//enter details on filter screen
//			elementUtil.enterText(userName, Username);
//			elementUtil.enterText(ifscCode, IFSC);
//			elementUtil.enterText(fullname, FullName);
//			elementUtil.enterText(groupNameTxtField,GroupName);

//			elementUtil.clickElement(btnReset);
//
//			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
//				log.info("Reset Button is working fine");
//			} else {
//				log.error("Reset Button is not working");
//			}

			//enter details on filter screen
			elementUtil.enterText(userName, Username);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.enterText(fullname, FullName);
			elementUtil.enterText(groupNameTxtField,GroupName);

			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errorMessages).trim().toString().equals("No items available for Approve operation given the search criteria".trim().toString()))
				{
					log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Approve Operation" );
				}

			} catch (NoSuchElementException e) {
				try {
					elementUtil.clickElement(screenRecord);
					if(elementUtil.getText(errorMessages).trim().toString().equals("Operation Approve user changes failed to execute: User cannot approve own modification.".trim().toString()))
					{
						log.info("Approval of Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Failed. User cannot approve own modification" );
					}
				} catch (NoSuchElementException e2) {
					if(elementUtil.getText(approveScreenUserNameTxt).trim().toString().equals(GroupName+"/"+Username.trim().toString()))
					{
						if(operation.equalsIgnoreCase("Approve"))
						{
							elementUtil.clickElement(approveBtn);
							String validationMessageApprove="Operation Approve user changes executed successfully. "+GroupName+"/"+Username+ "placed in active queue.";
							if(elementUtil.getText(messages).trim().toString().equals(validationMessageApprove.trim().toString()))
							{
								log.info("Record With Values  " +Username+  " Approved Successfully" );
							}//end of if
						}
						else if(operation.equalsIgnoreCase("Reject"))
						{
							elementUtil.clickElement(rejectBtn);
							String validationMessageReject="Operation Reject user changes executed successfully.";
							if(elementUtil.getText(messages).trim().toString().equals(validationMessageReject.trim().toString()))
							{
								log.info("Record With Values  " +Username+  " Rejected Successfully" );
							}//end of if
						}
						else if(operation.equalsIgnoreCase("To Repair"))
						{
							elementUtil.clickElement(toRepairBtn);
							String validationMessageToRepair="Operation Send to repair executed successfully. User placed in " +GroupName+"/"+Username+ "placed in REPAIR queue.";
							if(elementUtil.getText(messages).trim().toString().equals(validationMessageToRepair.trim().toString()))
							{
								log.info("Record With Values  " +Username+  " Sent To Repair Queue Successfully" );
							}//end of if
						}
					}//end of if
					else
					{
						log.error("Record Mismatch, Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Approve Operation");
					}//end of else
				}//end of catch
			}//end of catch
			elementUtil.clickElement(restartWorkFlowBtn);
			elementUtil.clearText(userName);
			elementUtil.clearText(ifscCode);
			elementUtil.clearText(fullname);
			elementUtil.clearText(groupNameTxtField);
		}//end of for

		// perform logout operation
		logOutOperation();
	}//end of userApprove function

	// --------------Method to Remove User Record------------------------//
	public void removeUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
			String Username = map.get("Username");
			String FullName = map.get("Full Name");
			String IFSC=map.get("IFSC Code(User Mapping Code)");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details on filter screen
			elementUtil.enterText(userName, Username);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.enterText(fullName, FullName);
			elementUtil.enterText(groupNameTxtField,GroupName);

			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullName).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine");
			} else {
				log.error("Reset Button is not working");
			}

			//enter details on filter screen
			elementUtil.enterText(userName, Username);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.enterText(fullName, FullName);
			elementUtil.enterText(groupNameTxtField,GroupName);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errorMessages).trim().toString().equals("No items available for operation".trim().toString()))
				{
					log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Remove Operation" );
				}

			} catch (NoSuchElementException e) {
				elementUtil.clickElement(removeScreenRecord);
				if(elementUtil.getText(removeScreenUserName).trim().toString().equals(Username.trim().toString()))
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(removeBtn);
					String removeValidationMessage="Operation Remove user executed successfully. User placed in " +GroupName+"/"+Username+ " queue.";
					if(elementUtil.getText(messages).trim().toString().equals(removeValidationMessage.trim().toString()))
					{
						log.info("Record With UserName " +Username+ " Removed Successfully");
					}

				}//end of if
				else
				{
					log.error("Record Mismatch, Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Remove Operation");
				}
			}//end of catch
		}//end of for

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();
	}//end of userRemove function

	// --------------Method to Block/Unblock User Record------------------------//
	public void userBlockUnblockRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
			String Username = map.get("Username");
			String FullName = map.get("Full Name");
			String IFSC=map.get("IFSC Code(User Mapping Code)");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details on filter screen
			elementUtil.enterText(userName, Username);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.enterText(fullName, FullName);
			elementUtil.enterText(groupNameTxtField,GroupName);

			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullName).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine");
			} else {
				log.error("Reset Button is not working");
			}

			//enter details on filter screen
			elementUtil.enterText(userName, Username);
			elementUtil.enterText(ifscCode, IFSC);
			elementUtil.enterText(fullName, FullName);
			elementUtil.enterText(groupNameTxtField,GroupName);

			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errorMessages).trim().toString().equals("No items available for operation".trim().toString()))
				{
					log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Block/Unblock Operation" );
				}

			} catch (NoSuchElementException e) {
				elementUtil.clickElement(blockUnblockScreenRecord);
				if(elementUtil.getText(blockUnblockScreenUserName).trim().toString().equals(Username.trim().toString()))
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(blockUnblockBtn);
					String blockUnblockValidationMessage="Operation Block/Unblock user executed successfully. User placed in " +GroupName+"/"+Username+ " queue.";
					if(elementUtil.getText(validationMsg).trim().toString().equals(blockUnblockValidationMessage.trim().toString()))
					{
						log.info("Record With UserName " +Username+ " Blocked/Unblocked Successfully");
					}//end of if

				}//end of if
				else
				{
					log.error("Record Mismatch, Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For Block/Unblock Operation");
				}
			}//end of catch
		}//end of for

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();
	}//end of userBlockUnblockRecord function

	// --------------Method to Modify User Record------------------------//
	public void modifyUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {

			String OriginalGroupName = map.get("Original GroupName");
			String OriginalUsername = map.get("Original Username");
			String OriginalFullName = map.get("Original Full Name");
			String OriginalIFSC=map.get("Original IFSC Code(User Mapping Code)");
			String GroupName = map.get("GroupName");
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
			String UserMappingCode=map.get("IFSC Code(User Mapping Code)");
			

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details on filter screen
			elementUtil.enterText(userName,OriginalUsername);
			elementUtil.enterText(ifscCode, OriginalIFSC);
			elementUtil.enterText(fullname, OriginalFullName);
			elementUtil.enterText(groupNameTxtField,OriginalGroupName);

			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine");
			} else {
				log.error("Reset Button is not working");
			}//end

			//enter details on filter screen
			elementUtil.enterText(userName,OriginalUsername);
			elementUtil.enterText(ifscCode, OriginalIFSC);
			elementUtil.enterText(fullname, OriginalFullName);
			elementUtil.enterText(groupNameTxtField,OriginalGroupName);

			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errorMessages).trim().toString().equals("No items available for Modify operation given the search criteria".trim().toString()))
				{
					log.info("Record With Values [ " +OriginalUsername+ " , " +OriginalIFSC+ " , " +OriginalFullName+ " , " +OriginalGroupName+ " ] Not Found For Modify/Repair Operation" );
				}

			} catch (NoSuchElementException e) {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(modifyScreenRecord);
				if(elementUtil.getAttribute(userAdd_Modify_Screen_UserName).trim().toString().equals(OriginalUsername.trim().toString()))
				{
					elementUtil.clearText(userAdd_Modify_Screen_UserName);
					elementUtil.enterText(userAdd_Modify_Screen_UserName,Username);
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
					elementUtil.selectDropDownByVisibleText(profile, Profile);
					elementUtil.clearText(password);
					elementUtil.enterText(password, Password);
					elementUtil.clearText(verifyPassword);
					elementUtil.enterText(verifyPassword, VerifyPassword);
					elementUtil.clearText(externalId);
					elementUtil.enterText(externalId, ExternalUserID);
					elementUtil.clearText(LOGINMATRIXlabelField);
					elementUtil.enterText(LOGINMATRIXlabelField,LOGINMATRIXlabel);
					elementUtil.selectDropDownByVisibleText(userMappingCodedropdown, UserMappingCodeDropdown);
					elementUtil.clearText(userMappingCode);
					elementUtil.enterText(userMappingCode, UserMappingCode);
					
					elementUtil.clickElement(okBtn);
					try {
						if(elementUtil.getText(errorMessages).trim().toString().equals("User already exists".trim().toString()))
						{
							log.info("Duplicate Record Found , Record With " +Username+ " Already Exists");
						}//end of if
						else
						{
							log.info("Test Data Provided For Modify/Repair Operation Is Not As Per Valid Format");
						}//end of else
					} catch (NoSuchElementException e2) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(okBtn);
						
						String modifyScreenValidationMessage="Operation Modify/Repair user executed successfully. " +GroupName+"/"+Username+ " placed in Approve queue.";
						if(elementUtil.getText(messages).trim().toString().equals(modifyScreenValidationMessage.trim().toString()))
						{
							log.info("Record With UserName " +Username+ " Modified Successfully");
						}//end of if
					}//end of catch

				}//end of if
				else
				{
					log.info("Record Mismatch, Record With Values [ " +OriginalUsername+ " , " +OriginalIFSC+ " , " +OriginalFullName+ " , " +OriginalGroupName+ " ] Not Found For Modify/Repair Operation" );		
				}
		}//end of catch
	}//end of for

	// perform logout operation
	logOutOperation();
}//end of modifyUserRecord function

//--------------Method to List User Record------------------------//
public void listUserRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
	testData = fileReader.readSetupExcel(SheetName);
	for (Map<String, String> map : testData) {
		String GroupName = map.get("GroupName");
		String Username = map.get("Username");
		String FullName = map.get("Full Name");
		String IFSC=map.get("IFSC Code(User Mapping Code)");
		String status=map.get("Status");

		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(restartWorkFlowBtn);

		//enter details on filter screen
//		elementUtil.enterText(userName, Username);
//		elementUtil.enterText(ifscCode, IFSC);
//		elementUtil.enterText(fullname, FullName);
//		elementUtil.enterText(groupNameTxtField,GroupName);
//		elementUtil.selectDropDownByVisibleText(statusDropdown, status);
//
//		elementUtil.clickElement(btnReset);
//
//		if (elementUtil.getText(userName).isEmpty() && elementUtil.getText(ifscCode).isEmpty() && elementUtil.getText(fullname).isEmpty() && elementUtil.getText(groupNameTxtField).isEmpty()) {
//			log.info("Reset Button is working fine");
//		} else {
//			log.error("Reset Button is not working");
//		}

		//enter details on filter screen
		elementUtil.enterText(userName, Username);
		elementUtil.enterText(ifscCode, IFSC);
		elementUtil.enterText(fullname, FullName);
		elementUtil.enterText(groupNameTxtField,GroupName);
		elementUtil.selectDropDownByVisibleText(statusDropdown, status);

		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);


		if(elementUtil.getText(listScreenErrorMessage).trim().toString().equals("No items available for List operation given the search criteria".trim().toString()))
		{
			log.info("Record With Values [ " +Username+ " , " +IFSC+ " , " +FullName+ " , " +GroupName+ " ] Not Found For List Operation" );
		}//end of if

		else
		{
			elementUtil.SHORT_TIMEOUT();
			String userRecordStatusValue=elementUtil.getText(userListScreenRecordStatusValue);
			elementUtil.SHORT_TIMEOUT();
			String listScreenRecordUserNameValue=elementUtil.getText(listScreenRecordUserName);
			elementUtil.SHORT_TIMEOUT();
			System.out.println(userRecordStatusValue+""+listScreenRecordUserNameValue);
			if(listScreenRecordUserNameValue.trim().toString().equals(GroupName+"/"+Username.trim().toString()))
			{
				log.info("Record With " +Username+ " Is Displayed In List With Status " +userRecordStatusValue);
			}//end of if
			else
			{
				log.info("Record With " +Username+ " Is Not Displayed In List" );

			}//end of else
		}//end of else

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
