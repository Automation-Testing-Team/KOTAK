package COM.KOTAK.QA.UTIL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/*
 * Class Description : 
 * Class namely ValidationMessages is a generic Class which consists of different methods for all Menus in application
 * to check whether validation Messages displayed on click of different buttons are as expected 
 */

public class ValidationMessages {

	private WebDriver driver;
	ElementUtil elementUtil;
	SoftAssert sa=new SoftAssert();

	//Webelements
	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath = "//p[@class='messages']")
	WebElement validationmessages;

	@FindBy(xpath = "//p[contains(.,'Operation Cancelled')]")
	WebElement cancelBtnText;

	@FindBy(xpath = "//p[contains(.,'User Pressed Back Key')]")
	WebElement backErrorMsgText;

	@FindBy(name = "back")
	WebElement btnBack;

	@FindBy(name = "cancel")
	WebElement btnCancel;

	// logout btn
	@FindBy(xpath = "//*[@id=\"logoutButtonId\"]")
	WebElement btnLogout;

	// External logout btn
	@FindBy(name = "logoutBtn1")
	WebElement extBtnLogout;

	@FindBy(xpath = "//a[contains(.,'Restart Workflow')]")
	WebElement btnReset;

	Logger log = Logger.getLogger(ValidationMessages.class);

	//ValidationMessages class constructor
	public ValidationMessages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);

	}//end of constructor

	//Method to check Back button validation Message
	public ValidationMessages backBtnErrorMessage()
	{
		log.info("********BACK BUTTON WORKING CHECKING********");
		//click on "Back" button
		elementUtil.clickElement(btnBack);
		log.info("Back button clicked");

		//fetch messages from screen
		String actualBackBtnErrorMessage=elementUtil.getText(backErrorMsgText);
		log.info("Screen Message Captured");
		String expectedBackBtnErrorMessage="User Pressed Back Key";

		//check the equality of expected and actual
		sa.assertEquals(actualBackBtnErrorMessage,expectedBackBtnErrorMessage,"Back Button Not Working Properly");
		return new ValidationMessages(driver);

	}//end of backBtnErrorMessage function

	//Method to check Cancel button Validation Message
	public ValidationMessages cancelBtnValidationMessage()
	{
		//click on cancel button
		elementUtil.clickElement(btnCancel);

		//fetch the message from screen
		String actualCancelBtnMessage=cancelBtnText.getText();
		String expectedCancelBtnMessage="Operation Cancelled";

		//check equality of messages
		sa.assertEquals(actualCancelBtnMessage,expectedCancelBtnMessage,"Cancel button Not Working Properly");

		return new ValidationMessages(driver);

	}//end of cancelBtnErrorMessage function


	//Method to check Miscellaneous->Add Screen "OK" buton validation message
	public ValidationMessages miscellaneousAddScreenErrorMessage()
	{
		//fetch messages from screen
		String actualMiscellaneousAddScreenErrorMessage=elementUtil.getText(errormessages);
		String expectedMiscellaneousAddScreenErrorMessage="Invalid Miscellaneous Code\r\n" + 
				"Invalid input for ACH Credit File\r\n" + 
				"Invalid input for ACH Debit File\r\n" + 
				"Invalid input for ECS Credit File\r\n" + 
				"Invalid input for ECS Debit File\r\n" + 
				"Invalid input for APBS Credit File";

		//replace the line breaks from actual and expected messages
		actualMiscellaneousAddScreenErrorMessage = actualMiscellaneousAddScreenErrorMessage.replaceAll("[\\n\\t ]", "");
		expectedMiscellaneousAddScreenErrorMessage=expectedMiscellaneousAddScreenErrorMessage.replaceAll("[\\r\\n\\t ]", "");

		//check equality of messages 
		sa.assertEquals(actualMiscellaneousAddScreenErrorMessage,expectedMiscellaneousAddScreenErrorMessage,"Validation Message Displayed on Miscellaneous->Add Screen is not proper");

		return new ValidationMessages(driver);

	}//end of miscellaneousAddScreenErrorMessage function

	//Method to check RelationShip Manager->Add Screen "ok" button validation message
	public ValidationMessages relationshipManagerAddScreenMessage()
	{
		
		String actRelationshipManagerAddScreenMessage=elementUtil.getText(errormessages);
		String expRelationshipManagerAddScreenMessage="RM Code is Mandatory\r\n" + "Invalid Name\r\n" + "Invalid Email Id";

		//replace the line breaks from actual and expected messages
		actRelationshipManagerAddScreenMessage=actRelationshipManagerAddScreenMessage.replaceAll("[\\n\\t ]", "");
		expRelationshipManagerAddScreenMessage=expRelationshipManagerAddScreenMessage.replaceAll("[\\r\\n\\t ]", "");

		//check equality of messages 
		sa.assertEquals(actRelationshipManagerAddScreenMessage,expRelationshipManagerAddScreenMessage,"Mandatory Fields Validation Message on Relationship Manager Screen Is Not Proper");
		
		return new ValidationMessages(driver);
	}//end of relationshipManagerAddScreenMessage function

	//Method to check validation message correctness for RM Code field if user enters value other than alphanumeric
	public ValidationMessages relationshipManagerAddScreen_RMCodeValidationMessage()
	{
		//fetch messages from screen
		String actRelationshipManager_RMCodeMessage=elementUtil.getText(errormessages);
		String expRelationshipManager_RMCodeMessage="RM Code Should be Alpha-Numeric";

		//check equality of messages 
		sa.assertEquals(actRelationshipManager_RMCodeMessage,expRelationshipManager_RMCodeMessage,"Validation Message Displayed For RMCode Field Is Not Proper");

		return new ValidationMessages(driver);
	}//end of relationshipManagerAddScreen_RMCodeMessage function

	//Method to check record is displayed in list
	public ValidationMessages listAssert(String actualScreenFieldValue,String expectedScreenFieldValue, String status)
	{
		if(actualScreenFieldValue.trim().toString().equals(expectedScreenFieldValue.trim().toString()))
		{
			System.out.println(expectedScreenFieldValue + " IS DISPLAYED IN LIST WITH STATUS " +status);

		}//end of if
		else
		{
			System.err.println(expectedScreenFieldValue+ " IS NOT DISPLAYED IN LIST ");
		}//end of else

		return new ValidationMessages(driver);

	}//end of listAssert function

	//Method to check Approve filter screen validation message correctness
	public ValidationMessages noRecordsAvailableFor_ApproveErrorMessage()
	{
		String actualSearchCriteriaMessage=elementUtil.getText(errormessages);
		String expectedSearchCriteriaMessage="No Records available for Approve operation";
		sa.assertEquals(actualSearchCriteriaMessage,expectedSearchCriteriaMessage,"Message Displayed For Filter Screen Search Criteria Is Not Proper");

		return new ValidationMessages(driver);
	}//end of noRecordsAvailableForApproveErrorMessage function

	//Method to check List filter screen validation message correctness
	public ValidationMessages noRecordsAvailableFor_ListErrorMessage()
	{
		String actualSearchCriteriaMessage=elementUtil.getText(errormessages);
		String expectedSearchCriteriaMessage="No Records available for List operation";
		sa.assertEquals(actualSearchCriteriaMessage,expectedSearchCriteriaMessage,"Message Displayed For Filter Screen Search Criteria Is Not Proper");

		return new ValidationMessages(driver);
	}//end of noRecordsAvailableForListErrorMessage function

	//Method to check Delete filter screen validation message correctness
	public ValidationMessages noRecordsAvailableFor_DeleteErrorMessage()
	{
		String actualSearchCriteriaMessage=elementUtil.getText(errormessages);
		String expectedSearchCriteriaMessage="No Records available for Delete operation";
		sa.assertEquals(actualSearchCriteriaMessage,expectedSearchCriteriaMessage,"Message Displayed For Filter Screen Search Criteria Is Not Proper");

		return new ValidationMessages(driver);
	}//end of noRecordsAvailableForDeleteErrorMessage function

	//Method to check Modify filter screen validation message correctness
	public ValidationMessages noRecordsAvailableFor_ModifyErrorMessage()
	{
		String actualSearchCriteriaMessage=elementUtil.getText(errormessages);
		String expectedSearchCriteriaMessage="No Records available for Modify operation";
		sa.assertEquals(actualSearchCriteriaMessage,expectedSearchCriteriaMessage,"Message Displayed For Filter Screen Search Criteria Is Not Proper");
		
		return new ValidationMessages(driver);
	}//end of noRecordsAvailableFor_ModifyErrorMessage function


	//Method to check Confirm Delete filter screen validation message correctness
	public ValidationMessages noRecordsAvailableFor_ConfirmDeleteErrorMessage()
	{
		String actualSearchCriteriaMessage=elementUtil.getText(errormessages);
		String expectedSearchCriteriaMessage="No Records available for Confirm Delete operation";
		sa.assertEquals(actualSearchCriteriaMessage,expectedSearchCriteriaMessage,"Message Displayed For Filter Screen Search Criteria Is Not Proper");

		return new ValidationMessages(driver);
	}//end of noRecordsAvailableForDeleteErrorMessage function
	
	//Method to check mandatory field validation message for Scheme->Add and Modify Menu
	public ValidationMessages schemeAddScreenValidationMessage()
	{
		String actualSchemeAddScreenMessage=errormessages.getText();
		String expectedSchemeAddScreenMessage="Invalid Scheme Code\r\n" + "Invalid Scheme Description\r\n" + "Please enter atleast 1 code(ACH/ECS/APBS/Direct Debit).";
		
		//replace all line breaks
		actualSchemeAddScreenMessage=actualSchemeAddScreenMessage.replaceAll("[\\n\\t ]", "");
		expectedSchemeAddScreenMessage=expectedSchemeAddScreenMessage.replaceAll("[\\r\\n\\t ]", "");
		
		sa.assertEquals(actualSchemeAddScreenMessage, expectedSchemeAddScreenMessage,"Mandatory Field Validation Message For Scheme Menu screen Is Not Proper" );
		return new ValidationMessages(driver);
	}//end 

	//Generic method to throw all assertions
	public ValidationMessages assertAll()
	{
		sa.assertAll();
		return new ValidationMessages(driver);
	}//end 

	//Method to throw assertions if any OR perform logout operation
	public void assertAndLogout()
	{
		int flag=0;
		try {
			assertAll();
		}
		catch(AssertionError e)
		{
			//set flag value=1, print caught exception and perform logout
			flag=1;
			log.error(e);
			System.out.println(e);
			//elementUtil.clickElement(btnLogout);
			//elementUtil.clickElement(extBtnLogout);
			//elementUtil.quitBrowser();
		}//end of catch
		//		if(flag==0) 
		//		{
		//			//if flag value=0 i.e all assertions pass perform logout operation
		//			//elementUtil.clickElement(btnLogout);
		//			//elementUtil.clickElement(extBtnLogout);
		//			//elementUtil.quitBrowser();
		//		}
	}//end of assertAndLogout function








}
