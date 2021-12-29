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

public class DBLoadPage {
	private WebDriver driver;
	List<Map<String, String>> testData;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(DBLoadPage.class);

	// WebElements for DB Load Page
	@FindBy(name="loadType")
	WebElement selectLoadtype;
	
	@FindBy(name="forceUpdate")
	WebElement forceUpdate;
	
	@FindBy(name="fileName")
	WebElement fileName;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/form/table/tbody/tr/td/table/tbody/tr[6]/td/input[1]")
	WebElement OKBtn;
	
	@FindBy(name="back")
	WebElement backBtn;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/form/table/tbody/tr/td/table/tbody/tr[6]/td/input[2]")
	WebElement confirmBtn;
	
	@FindBy(xpath="//input[@name='reveal']")
	WebElement statusBtn;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/table/tbody/tr[14]/td/input[3]")
	WebElement okBtn;
	
	@FindBy(xpath="//p[@class='errormessages']")
	WebElement errormessages;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/p[1]")
	WebElement validationMsg;
	
	@FindBy(id="logoutButtonId")
	WebElement logOutBtn;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn; 
	
	// DBLoadPage Class Constructor
	public DBLoadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}
	
	//--------To upload IFSC Codes-----------//
	public DBLoadPage uploadFile(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		testData = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : testData) {	
		String Loadtype = map.get("Loadtype");
		String ForceUpdate = map.get("ForceUpdate");
		String FileName = map.get("FileName");
		
		elementUtil.clickElement(OKBtn);
		elementUtil.SHORT_TIMEOUT();
		String ExpectedValidationMsg="DB: File Name is Required";
		if(elementUtil.getText(validationMsg).equals(ExpectedValidationMsg)) {
			log.info("Validation message is displayed properly for keeping File name blank");
		}else {
			log.error("Validation failed for keeping File name blank");
		}
		elementUtil.selectDropDownByVisibleText(selectLoadtype, Loadtype);
		elementUtil.selectDropDownByVisibleText(forceUpdate, ForceUpdate);
		elementUtil.enterText(fileName, FileName);
		elementUtil.clickElement(OKBtn);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(confirmBtn);
		elementUtil.SHORT_TIMEOUT();
		
		String ExpectedMsg= "DB: Load Started For:"+Loadtype+"";
		if(elementUtil.getText(validationMsg).equals(ExpectedMsg)) {
			log.info(ExpectedMsg);
		}else {
			log.error("DB load failed for "+Loadtype+"");
		}
		}
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin1(driver);
		return new DBLoadPage(driver);
	}
	
	//-----------------Method to perform Logout Operation----------------------------
		public void logOutOperation() throws InterruptedException {
			elementUtil.clickElement(logOutBtn);
			elementUtil.clickElement(logoutBtn);
			elementUtil.quitBrowser();
		}// end of logOutOperation function
}
