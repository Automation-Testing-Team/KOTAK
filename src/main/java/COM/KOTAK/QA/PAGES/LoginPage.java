package COM.KOTAK.QA.PAGES;

//imports
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import COM.KOTAK.QA.UTIL.ElementUtil;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class LoginPage {
	private WebDriver driver;
	ElementUtil elementUtil=new ElementUtil(driver);

	@FindBy(xpath="//a[contains(.,'Accept')]")
	WebElement acceptLink;

	@FindBy(name="j_user")
	WebElement username;

	@FindBy(name="j_pass")
	WebElement password;

	@FindBy(id="login")
	WebElement loginBtn;

	@FindBy(name="j_user")
	WebElement username1;

	@FindBy(name="j_pass")
	WebElement password1;

	@FindBy(id = "details-button")
	WebElement advancedBtn;

	@FindBy(id = "proceed-link")
	WebElement proceedlink;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	Logger log = Logger.getLogger(LoginPage.class);

	//LoginPage Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}//end 

	//----------------------Method to perform Login operation-------------------------
	public HomePage login(String un,String pwd) throws InterruptedException {
		elementUtil.clickElement(advancedBtn);
		log.info("Advanced button clicked");
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(proceedlink);
		log.info("ProceedLink clicked");
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(acceptLink);
		log.info("Accept button clicked");
		elementUtil.enterText(username, un);
		log.info("Username entered");
		elementUtil.enterText(password, pwd);
		log.info("Password entered");
		elementUtil.clickElement(loginBtn);
		log.info("Login button clicked");
		String expectedLoginPage_ErrMessage="Operation Login failed to execute: Operator already logged on.";

		//check if Login operation is successfull or login operation falied
		try {
			if(errormessages.getText().trim().toString().equals(expectedLoginPage_ErrMessage.trim().toString()))
			{
				log.error("Login Operation Failed, Operator Already Logged on");
			}//end of if
			else
			{
				log.error("Login Message Displayed Is Not Proper");
			}//end of else

		}
		catch (NoSuchElementException e) {
			log.info("Login Successful");
		}//end of catch

		return new HomePage(driver);
	}//end of login function

	//Trial And Error Method
	/*public HomePage login1(String un,String pwd) {
		elementUtil.enterText(username1, un);
		elementUtil.enterText(password1, pwd);
		elementUtil.clickElement(loginBtn);
		return new HomePage();
	}*/
}
