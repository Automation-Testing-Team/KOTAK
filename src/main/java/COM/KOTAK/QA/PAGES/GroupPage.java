package COM.KOTAK.QA.PAGES;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
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

public class GroupPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	List<Map<String, String>> testData;
	
	// WebElements for Group Page Menu
	@FindBy(name="name")
	WebElement nameTextField;
	
	@FindBy(name="groupName")
	WebElement nameField;
	
	@FindBy(name="sortPriority")
	WebElement sortPriorityTextField;
	
	@FindBy(name="details")
	WebElement detailsTextField;
	
	@FindBy(name="admin")
	WebElement adminChkBox;
	
	@FindBy(xpath="//input[@id='drFlag']")
	WebElement noninquiryChkBox;
	
	@FindBy(name="mySwiftBic")
	WebElement swiftBic;
	
	@FindBy(name="myEmailAddr")
	WebElement emailAddress;
	
	@FindBy(name="sec.param.type")
	WebElement securityParameters;
	
	@FindBy(xpath="//input[@value=\"OK\"]")
	WebElement btnOk;
	
	// btn confirm
	@FindBy(xpath="//*[@id=\"pageBody\"]/form/p/input[2]")
	WebElement btnConfirm;
	
	// Message
	@FindBy(xpath="//*[@id=\"pageBody\"]/p")
	WebElement approveMsg;
	
	@FindBy(xpath="//input[@value=\"Reset\"]")
	WebElement btnReset;
	
	@FindBy(xpath="//input[@value=\"Cancel\"]")
	WebElement btnCancel;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/p[1]")
	WebElement cancelMsg;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/p[1]")
	WebElement groupErrorMsg;
	
	@FindBy(name="filter")
	WebElement withStatusdropdown;
	
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement verifyGroupName;
	
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement verifyStatus;
	
	// Approve Record
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement record;
	
	@FindBy(xpath="//input[@name='approve']")
	WebElement btnApprove;
	
	@FindBy(name= "reject")
	WebElement btnReject;
	
	@FindBy(xpath = "//p[@class='messages']")
	WebElement validationmsg;
	
	// Remove Record
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[1]")
	WebElement removeRecordLink;
	
	@FindBy(xpath="//input[@id='btnRemove']")
	WebElement btnRemove;
	
	// Block Record
	@FindBy(xpath="//button[@accesskey='B']")
	WebElement backToListBtn;
	
	@FindBy(name="block")
	WebElement blockBtn;
	
	// Unblock Record
	@FindBy(name="unblock")
	WebElement unblockBtn;
	
	// Modify Record
	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[1]")
	WebElement modifyRecordLink;
	
	@FindBy(xpath = "//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkflow;
	
	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;
	
	@FindBy(xpath = "//p[@class='label']")
	WebElement validateFilterMsg;
	
	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;
	
	// GroupPage Class Constructor
	public GroupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}

	//--------------------To add Group---------------//
	public void addGroup(String SheetName) throws InterruptedException, IOException {
		
		//fetch details
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String Name = map.get("Name");
			String SortPriority = map.get("SortPriority");
			String Details = map.get("Details");
			String Admin = map.get("Admin");
			String NonInquiryUsers = map.get("NonInquiryUsers");
			String SWIFTBIC = map.get("SWIFTBIC");
			String EmailAddress = map.get("EmailAddress");
			String SecurityParameters = map.get("SecurityParameters");
			
		//----Cancel button validation----//
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(btnCancel);
		
		String expectCancelMsg="Operation Add group was cancelled.";

		if(elementUtil.getText(cancelMsg).equals(expectCancelMsg)) {
			System.out.println("-----Cancel Message Validated------");
		}else {
			System.out.println("-----Cancel Message not Validated------");
		}
		
		elementUtil.clickElement(restartWorkflow);
		//----Reset button validation----//
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(nameTextField, Name);
		elementUtil.enterText(sortPriorityTextField, SortPriority);
		elementUtil.enterText(detailsTextField, Details);
		elementUtil.isElementSelected(adminChkBox, Admin);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.isElementSelected(noninquiryChkBox, NonInquiryUsers);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(swiftBic, SWIFTBIC);
		elementUtil.enterText(emailAddress, EmailAddress);
		elementUtil.selectDropDownByVisibleText(securityParameters, SecurityParameters);
		elementUtil.clickElement(btnReset);
		
		if(elementUtil.getAttribute(nameTextField).isEmpty() && elementUtil.getAttribute(detailsTextField).isEmpty() && elementUtil.getAttribute(swiftBic).isEmpty() && elementUtil.getAttribute(emailAddress).isEmpty()) {
			System.out.println("Reset button is working fine on Group-->Add screen");
		}else {
			System.out.println("Reset button is not working on Group-->Add screen");
		}
		
		elementUtil.clickElement(restartWorkflow);
	
		//----Adding the record----//
		elementUtil.enterText(nameTextField, Name);
		elementUtil.enterText(sortPriorityTextField, SortPriority);
		elementUtil.enterText(detailsTextField, Details);
		elementUtil.isElementSelected(adminChkBox, Admin);
		elementUtil.isElementSelected(noninquiryChkBox, NonInquiryUsers);
		elementUtil.enterText(swiftBic, SWIFTBIC);
		elementUtil.enterText(emailAddress, EmailAddress);
		elementUtil.clickElement(securityParameters);
		elementUtil.selectDropDownByVisibleText(securityParameters, SecurityParameters);
		elementUtil.clickElement(btnOk);
		
		String expectGrpMsg="Name is required.\r\n" + 
							"Details is required.";
		String detailsFieldMsg = "Details is required.";
		String nameFieldMsg = "Name is required.";
		String ExistingMsg = "Group with the same name already exists";
		
		try {
		if(elementUtil.getText(errormessages).contains(expectGrpMsg)) {
			System.out.println("----Group Message Fields are validated-----");
		}else if(elementUtil.getText(errormessages).equals(detailsFieldMsg)){
			System.out.println("Validation message is displayed properly for Invalid Details field");
		}else if(elementUtil.getText(errormessages).equals(nameFieldMsg)){
			System.out.println("Validation message is displayed properly for Invalid Name field");
		}else if(elementUtil.getText(errormessages).equals(ExistingMsg)){
			System.out.println("Validation message is displayed properly for existing Group");
		}else{
			System.out.println("----Group Message Fields are not validated-----");
		}
		}catch(NoSuchElementException e) {
		elementUtil.clickElement(btnOk);
		
		String actualGroupMsg= elementUtil.getText(approveMsg);
		String expectGroupMsg="Operation Add group executed successfully.";
		
		if(actualGroupMsg.contains(expectGroupMsg)) {
			System.out.println("-----Add Group Message Validated and Added Group placed in Approve Queue------");
		}else {
			System.out.println("-----Add Group Message not Validated------");
		}
	    }
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
	}
	
	//--------To Approve Group----------//
	public GroupPage approveRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
			String Action = map.get("Action");
			
		elementUtil.sendkeys(nameField, GroupName);
		elementUtil.clickElement(btnReset);
		
		if(elementUtil.getAttribute(nameField).isEmpty()) {
			System.out.println("Reset button is working fine on Group-->Approve screen");
		}else {
			System.out.println("Reset button is not working on Group-->Approve screen");
		}
		
		elementUtil.sendkeys(nameField, GroupName);
		elementUtil.clickElement(btnOk);
		
		String ValidateFilterMsg = "No items available for Approve operation given the search criteria";
		
		if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
			System.out.println("No Records available for Approve operation--Validation Message Displayed Is Correct"); 
		} else {
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(record);
			elementUtil.SHORT_TIMEOUT();	
			
			switch (Action) {
				case "Approve":
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(btnApprove);
					break;

				case "Reject":
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(btnReject);
					break;
			}
		
		String ApprovalMsg = "Operation Approve group changes executed successfully. "+GroupName+" placed in active queue.";
		String RejectionMsg = "Operation Reject approval for group executed successfully.";
		String RemoveMsg = "Operation Approve group changes executed successfully. "+GroupName+" placed in DELETED queue.";
		String BlockMsg = "Operation Approve group changes executed successfully. "+GroupName+" placed in BLOCKED queue.";
		
		if (elementUtil.getText(validationmsg).equals(ApprovalMsg)) {
			System.out.println("Group "+GroupName+" approved successfully");
		}else if(elementUtil.getText(validationmsg).equals(RejectionMsg)){
			System.out.println("Group "+GroupName+" rejected successfully");
		}else if(elementUtil.getText(validationmsg).equals(RemoveMsg)){
			System.out.println("Group "+GroupName+" removed successfully");
		}else if(elementUtil.getText(validationmsg).equals(BlockMsg)){
			System.out.println("Group "+GroupName+" blocked successfully");
		}else{
			System.out.println("Group "+GroupName+" is failed to "+Action+" ");
		}
		
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//---------To Modify Record-----------//
	public GroupPage modifyGroupRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String name = map.get("name");
			String Name = map.get("Name");
			String SortPriority = map.get("SortPriority");
			String Details = map.get("Details");
			String Admin = map.get("Admin");
			String NonInquiryUsers = map.get("NonInquiryUsers");
			String SWIFTBIC = map.get("SWIFTBIC");
			String EmailAddress = map.get("EmailAddress");
			String SecurityParameters = map.get("SecurityParameters");
			
		elementUtil.sendkeys(nameField, name);
		elementUtil.clickElement(btnReset);	
		
		if(elementUtil.getAttribute(nameField).isEmpty()) {
			System.out.println("Reset button is working fine on Group-->Modify screen");
		}else {
			System.out.println("Reset button is not working on Group-->Modify screen");
		}
			
		elementUtil.sendkeys(nameField, name);
		elementUtil.clickElement(btnOk);
		
		String ValidateFilterMsg = "No items available for Modify operation given the search criteria";	
		String ModifyMsg = "Operation Modify group executed successfully. "+Name+" placed in APPROVE queue.";
		
		if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
			System.out.println("No Records available for Remove operation--Validation Message Displayed Is Correct"); 
		} else {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(record);
		elementUtil.SHORT_TIMEOUT();
		
		//----Cancel button validation----//
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(btnCancel);
						
		String expectCancelMsg="Operation Modify group was cancelled.";

		if(elementUtil.getText(cancelMsg).equals(expectCancelMsg)) {
			System.out.println("-----Cancel Message Validated------");
		}else {
			System.out.println("-----Cancel Message not Validated------");
		}
		
		elementUtil.sendkeys(nameField, name);
		elementUtil.clickElement(btnOk);
		elementUtil.clickElement(record);
		elementUtil.SHORT_TIMEOUT();
		
		elementUtil.clearText(nameTextField);
		elementUtil.enterText(nameTextField, Name);
		
		elementUtil.clearText(sortPriorityTextField);
		elementUtil.enterText(sortPriorityTextField, SortPriority);
		
		elementUtil.clearText(detailsTextField);
		elementUtil.enterText(detailsTextField, Details);
		
		elementUtil.isElementSelected(adminChkBox, Admin);
		elementUtil.isElementSelected(noninquiryChkBox, NonInquiryUsers);
		
		elementUtil.clearText(swiftBic);
		elementUtil.enterText(swiftBic, SWIFTBIC);
		
		elementUtil.clearText(emailAddress);
		elementUtil.enterText(emailAddress, EmailAddress);
		
		elementUtil.selectDropDownByVisibleText(securityParameters, SecurityParameters);
		
		elementUtil.clickElement(btnOk);
		String expectGrpMsg="Name is required.\r\n" + 
				"Details is required.";
		String detailsFieldMsg = "Details is required.";
		String nameFieldMsg = "Name is required.";
		String ExistingMsg = "Group with the same name already exists";

		try {
			if(elementUtil.getText(errormessages).contains(expectGrpMsg)) {
				System.out.println("----Group Message Fields are validated-----");
			}else if(elementUtil.getText(errormessages).equals(detailsFieldMsg)){
				System.out.println("Validation message is displayed properly for Invalid Details field");
			}else if(elementUtil.getText(errormessages).equals(nameFieldMsg)){
				System.out.println("Validation message is displayed properly for Invalid Name field");
			}else if(elementUtil.getText(errormessages).equals(ExistingMsg)){
				System.out.println("Validation message is displayed properly for existing Group");
			}else{
				System.out.println("----Group Message Fields are not validated-----");
			}
		}catch (NoSuchElementException e) {
			elementUtil.clickElement(btnConfirm);
			
			if(elementUtil.getText(validationmsg).equals(ModifyMsg)) {
				System.out.println("-----Modify Group Message Validated and Modified Group "+Name+" placed in Approve Queue------");
			}else {
				System.out.println("Group "+Name+" is failed to modify");
			}
		
		}
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//-----------To Remove Record---------//
	public GroupPage removeGroupRecord(String SheetName) throws InterruptedException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
		
		elementUtil.sendkeys(nameField, GroupName);
		elementUtil.clickElement(btnReset);
			
		if(elementUtil.getAttribute(nameField).isEmpty()) {
			System.out.println("Reset button is working fine on Group-->Remove screen");
		}else {
			System.out.println("Reset button is not working on Group-->Remove screen");
		}
			
		elementUtil.sendkeys(nameField, GroupName);
		elementUtil.clickElement(btnOk);	
		
		String ValidateFilterMsg = "No items available for Remove operation given the search criteria";
		
		if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
			System.out.println("No Records available for Remove operation--Validation Message Displayed Is Correct"); 
		} else {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(record);
		elementUtil.clickElement(btnRemove);
		elementUtil.SHORT_TIMEOUT();
		
		String expctRemoveMsg="Operation Remove group executed successfully. "+GroupName+" placed in APPROVE queue.";
		
		if(elementUtil.getText(validationmsg).equals(expctRemoveMsg)) {
			System.out.println("--------Remove Message Validated and Group record is placed in APPROVE queue---------");
		}else {
			System.out.println("--------Remove Message not Validated------");
		}
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//-----------To List Record------------//
	public GroupPage listGroupRecord(String SheetName) throws InterruptedException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
			String WithStatus = map.get("With status");
			
		elementUtil.sendkeys(nameField, GroupName);
		elementUtil.selectDropDownByVisibleText(withStatusdropdown, WithStatus);
		btnReset.click();
		
		if (elementUtil.getAttribute(nameField).isEmpty()) {
			System.out.println("Reset Button functionality is working fine");
		} else {
			System.out.println("Reset Button is not working");
		}
		
		elementUtil.enterText(nameField, GroupName);
		elementUtil.selectDropDownByVisibleText(withStatusdropdown, WithStatus);
		elementUtil.clickElement(btnOk);
		elementUtil.SHORT_TIMEOUT();
		
		String ValidateFilterMsg = "No items available for List operation given the search criteria";
		
		if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
			System.out.println(""+GroupName+" is not displayed in list"); 
		} else if (elementUtil.getText(verifyGroupName).equals(GroupName)) {
			System.out.println(""+GroupName+" is displayed in list with "+elementUtil.getText(verifyStatus)+" status");
		} 
		
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//-----------------To Block Record-------------//
	public GroupPage blockGroup(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {
			String GroupName = map.get("GroupName");
			
		elementUtil.enterText(nameField, GroupName);
		btnReset.click();
		
		if (elementUtil.getAttribute(nameField).isEmpty()) {
			System.out.println("Reset Button functionality is working fine");
		} else {
			System.out.println("Reset Button is not working");
		}
		
		elementUtil.enterText(nameField, GroupName);
		elementUtil.clickElement(btnOk);
		elementUtil.SHORT_TIMEOUT();
		
		String ValidateFilterMsg = "No items available for Block/Unblock operation";
		String expctRemoveMsg="Operation Block group executed successfully. "+GroupName+" placed in APPROVE queue.";
		String ValidationMsg = "Operation Block group failed to execute: User cannot approve own modification.";
		
		if (elementUtil.getText(validateFilterMsg).equals(ValidateFilterMsg)) {
			System.out.println("No Records available for Block operation--Validation Message Displayed Is Correct"); 
		} else {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(record);
		elementUtil.SHORT_TIMEOUT();
		try {
			if(elementUtil.getText(errormessages).equals(ValidationMsg)){
				System.out.println("--------Operation Block group failed to execute: User cannot approve own modification.---------");	
			}
		}
		catch (NoSuchElementException e) {
			elementUtil.clickElement(blockBtn);	
			try {
				if(elementUtil.getText(validationmsg).equals(expctRemoveMsg)) {
					System.out.println("--------Group record is placed in APPROVE queue for Block operation---------");
					System.out.println("--------Validation message is proper for Block operation---------");
				}else {
					System.out.println("--------Validation message is not proper for Block operation---------");
				}
				}catch (NoSuchElementException e1) {
					System.out.println("--------Operation Block group failed to execute.------");
				}
		
			}
		}
		elementUtil.clickElement(restartWorkflow);
		}
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//------------To Unblock Record-------------//
	public GroupPage unblockGroup() throws InterruptedException {
		elementUtil.clickElement(record);
		elementUtil.SHORT_TIMEOUT();
		
		String expctUnblockMsg = "Operation Unblock group executed successfully.";
		String ValidationMsg = "Operation Unblock group failed to execute: User cannot approve own modification.";
		
		try {
			if(elementUtil.getText(errormessages).equals(ValidationMsg)){
				System.out.println("--------Operation Unblock group failed to execute: User cannot approve own modification.---------");	
			}
		}
		catch (NoSuchElementException e) {
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(unblockBtn);	
			elementUtil.SHORT_TIMEOUT();
			try {
				if(elementUtil.getText(validationmsg).contains(expctUnblockMsg)) {
					System.out.println("--------Group record is placed in APPROVE queue for Unblock operation---------");
					System.out.println("--------Validation message is proper for Unblock operation---------");
				}else {
					System.out.println("--------Validation message is not proper for Unblock operation---------");
				}
				}catch (NoSuchElementException e1) {
					System.out.println("--------Operation Unblock group failed to execute.------");
				}
		}
		
		logOutOperation();
		return new GroupPage(driver);
	}
	
	//-----------------Method to perform Logout Operation----------------------------
	public void logOutOperation() throws InterruptedException {
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
	}// end of logOutOperation function
}

