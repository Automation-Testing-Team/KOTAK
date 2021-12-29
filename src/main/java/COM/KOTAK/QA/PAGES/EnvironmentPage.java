package COM.KOTAK.QA.PAGES;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import COM.KOTAK.QA.UTIL.ElementUtil;


/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class EnvironmentPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(EnvironmentPage.class);

	// WebElements for Environment Page
	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:sodExecutor")
	WebElement sodcheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:sodExecutorc2")
	WebElement sodStatus;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:eodExecutorc2")
	WebElement eodStatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:eodExecutor")
	WebElement eodcheckbox;

	@FindBy(id = "modalDialogContinue")
	WebElement continuebutton;

	@FindBy(xpath = "//*[@id=\"preconditionEnforceAdvice\"]/table/tbody/tr/td[2]/input")
	WebElement manageBtn;

	@FindBy(name = "env.run.continue")
	WebElement returnButton;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps")
	WebElement bdcheckbox;

	@FindBy(id = "SET_BUSINESS_DATE_ACTION")
	WebElement setBusinessDateButton;
	
	@FindBy(xpath = "//*[@id=\"pageBody\"]/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td/span")
	WebElement businessDateSubmitBtnMsg;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")
	WebElement bdSubmitbutton;

	@FindBy(id = "SWITCH_RESOURCE_ACTION")
	WebElement switchResourceButton;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement environmentokbutton;

	@FindBy(xpath = "//*[@id='adviceId' and @class='visible']")
	WebElement buttonVisibility;
	
	@FindBy(name ="RUN_INTEGRATED_JOB_REEVALUATE")
	WebElement reEvaluateBtn;
 
	@FindBy(xpath ="//*[@id=\"pageBody\"]/form/table[2]/tbody/tr[4]/td/div/table/tbody/tr[1]/td/select")
	WebElement preconditionsFilterDropdown;
	
	@FindBy(id ="RUN_INTEGRATED_JOB_CONFIRM")
	WebElement proceedBtn;

	// WebElements for Server's Status and checkbox 
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:envEventServerc2")
	WebElement envEventServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:envEventServer")
	WebElement envEventServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:remoteResourceServerc2")
	WebElement remoteResourceServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:remoteResourceServer")
	WebElement remoteResourceServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:remoteLogConsoleServerc2")
	WebElement remoteLogConsoleServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:remoteLogConsoleServer")
	WebElement remoteLogConsoleServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:schedulerTrackerc2")
	WebElement schedulerTrackerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:schedulerTracker")
	WebElement schedulerTrackercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:updaterServerc2")
	WebElement updaterServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:updaterServer")
	WebElement updaterServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps:emailServerc2")
	WebElement emailServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps:emailServer")
	WebElement emailServercheckbox;

	// WebElements for SFTP Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NPCI_Upload_Serverc2")
	WebElement NPCI_Upload_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NPCI_Upload_Server")
	WebElement NPCI_Upload_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NPCI_Download_Serverc2")
	WebElement NPCI_Download_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NPCI_Download_Server")
	WebElement NPCI_Download_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:File_Router_Serverc2")
	WebElement File_Router_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:File_Router_Server")
	WebElement File_Router_Servercheckbox;

	// WebElements for Mandate Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_InFile_Serverc2")
	WebElement MMS_InFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_InFile_Server")
	WebElement MMS_InFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_InProcess_Serverc2")
	WebElement MMS_InProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_InProcess_Server")
	WebElement MMS_InProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_OutFileCreate_Serverc2")
	WebElement MMS_OutFileCreate_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MMS_OutFileCreate_Server")
	WebElement MMS_OutFileCreate_Servercheckbox;

	// WebElements for DBTL Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_InFile_Serverc2")
	WebElement DBTL_InFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_InFile_Server")
	WebElement DBTL_InFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_InProcess_Serverc2")
	WebElement DBTL_InProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_InProcess_Server")
	WebElement DBTL_InProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_Verification_Serverc2")
	WebElement DBTL_Verification_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_Verification_Server")
	WebElement DBTL_Verification_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_OutFileCreate_Serverc2")
	WebElement DBTL_OutFileCreate_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:DBTL_OutFileCreate_Server")
	WebElement DBTL_OutFileCreate_Servercheckbox;

	// WebElements for CBDT Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_InFile_Serverc2")
	WebElement CBDT_InFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_InFile_Server")
	WebElement CBDT_InFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_InProcess_Serverc2")
	WebElement CBDT_InProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_InProcess_Server")
	WebElement CBDT_InProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_AccountVerification_Serverc2")
	WebElement CBDT_AccountVerification_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_AccountVerification_Server")
	WebElement CBDT_AccountVerification_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_OutFileCreate_Serverc2")
	WebElement CBDT_OutFileCreate_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CBDT_OutFileCreate_Server")
	WebElement CBDT_OutFileCreate_Servercheckbox;

	// WebElements for ACH Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_InFile_Serverc2")
	WebElement NACH_InFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_InFile_Server")
	WebElement NACH_InFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_InProcess_Serverc2")
	WebElement NACH_InProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_InProcess_Server")
	WebElement NACH_InProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_OutProcess_Serverc2")
	WebElement NACH_OutProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_OutProcess_Server")
	WebElement NACH_OutProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_OutFileCreate_Serverc2")
	WebElement NACH_OutFileCreate_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_OutFileCreate_Server")
	WebElement NACH_OutFileCreate_Servercheckbox;

	// WebElements for Corporate Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Corporate_InFile_Serverc2")
	WebElement Corporate_InFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Corporate_InFile_Server")
	WebElement Corporate_InFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Corporate_InProcess_Serverc2")
	WebElement Corporate_InProcess_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Corporate_InProcess_Server")
	WebElement Corporate_InProcess_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:LIC_INFile_Serverc2")
	WebElement LIC_INFile_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:LIC_INFile_Server")
	WebElement LIC_INFile_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:SCHM_Segrigate_Serverc2")
	WebElement SCHM_Segrigate_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:SCHM_Segrigate_Server")
	WebElement SCHM_Segrigate_Servercheckbox;

	// WebElements for ReportServer Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:AutoMisServerc2")
	WebElement AutoMisServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:AutoMisServer")
	WebElement AutoMisServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:H2HMMSServerc2")
	WebElement H2HMMSServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:H2HMMSServer")
	WebElement H2HMMSServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:H2HFileServerRouterc2")
	WebElement H2HFileServerRouterstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:H2HFileServerRouter")
	WebElement H2HFileServerRoutercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MandateRepresentServerc2")
	WebElement MandateRepresentServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:MandateRepresentServer")
	WebElement MandateRepresentServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:TransactionRepresentServerc2")
	WebElement TransactionRepresentServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:TransactionRepresentServer")
	WebElement TransactionRepresentServercheckbox;

	// WebElements for ROUTER Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsFileProgressServerc2")
	WebElement GpsFileProgressServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsFileProgressServer")
	WebElement GpsFileProgressServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsPaymentProgressServerc2")
	WebElement GpsPaymentProgressServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsPaymentProgressServer")
	WebElement GpsPaymentProgressServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ChargePostingServerc2")
	WebElement ChargePostingServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ChargePostingServer")
	WebElement ChargePostingServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CorporateFundingServerc2")
	WebElement CorporateFundingServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:CorporateFundingServer")
	WebElement CorporateFundingServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:FileMarkCompleteServerc2")
	WebElement FileMarkCompleteServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:FileMarkCompleteServer")
	WebElement FileMarkCompleteServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:FilePostingMarkCompleteServerc2")
	WebElement FilePostingMarkCompleteServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:FilePostingMarkCompleteServer")
	WebElement FilePostingMarkCompleteServercheckbox;

	// WebElements for Posting Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Finacle_Posting_Serverc2")
	WebElement Finacle_Posting_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Finacle_Posting_Server")
	WebElement Finacle_Posting_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsReQueueingServerc2")
	WebElement GpsReQueueingServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:GpsReQueueingServer")
	WebElement GpsReQueueingServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:IpaymentReQueueingServerc2")
	WebElement IpaymentReQueueingServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:IpaymentReQueueingServer")
	WebElement IpaymentReQueueingServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_Posting_Serverc2")
	WebElement Inward_Debit_Posting_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_Posting_Server")
	WebElement Inward_Debit_Posting_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_Posting_Serverc2")
	WebElement Inward_Credit_Posting_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_Posting_Server")
	WebElement Inward_Credit_Posting_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_RePosting_Serverc2")
	WebElement Inward_Debit_RePosting_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_Posting_Server")
	WebElement Inward_Debit_RePosting_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_Posting_Serverc2")
	WebElement Inward_Credit_RePosting_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_RePosting_Server")
	WebElement Inward_Credit_RePosting_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_ReffralPost_Serverc2")
	WebElement Inward_Debit_ReffralPost_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Debit_ReffralPost_Server")
	WebElement Inward_Debit_ReffralPost_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_ReffralPost_Serverc2")
	WebElement Inward_Credit_ReffralPost_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Inward_Credit_ReffralPost_Server")
	WebElement Inward_Credit_ReffralPost_Servercheckbox;

	// WebElements for Alert Server Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Mandate_SMS_Alerts_Serverc2")
	WebElement Mandate_SMS_Alerts_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Mandate_SMS_Alerts_Server")
	WebElement Mandate_SMS_Alerts_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Mandate_EMAIL_Alerts_Serverc2")
	WebElement Mandate_EMAIL_Alerts_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Mandate_EMAIL_Alerts_Server")
	WebElement Mandate_EMAIL_Alerts_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Payment_SMS_Alerts_Serverc2")
	WebElement Payment_SMS_Alerts_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Payment_SMS_Alerts_Server")
	WebElement Payment_SMS_Alerts_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Payment_EMAIL_Alerts_Serverc2")
	WebElement Payment_EMAIL_Alerts_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:Payment_EMAIL_Alerts_Server")
	WebElement Payment_EMAIL_Alerts_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:PaymentPosting_Alert_Serverc2")
	WebElement PaymentPosting_Alert_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:PaymentPosting_Alert_Server")
	WebElement PaymentPosting_Alert_Servercheckbox;

	// WebElements for ESIGN Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ESIGNMMSInFileServerc2")
	WebElement ESIGNMMSInFileServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ESIGNMMSInFileServer")
	WebElement ESIGNMMSInFileServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ESIGNMMSVerificationServerc2")
	WebElement ESIGNMMSVerificationServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:ESIGNMMSVerificationServer")
	WebElement ESIGNMMSVerificationServercheckbox;

	// WebElements for MMS API Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:APIMandateValidateServerc2")
	WebElement APIMandateValidateServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:APIMandateValidateServer")
	WebElement APIMandateValidateServercheckbox;

	// WebElements for JARVIS Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:JARVISFileProcessServerc2")
	WebElement JARVISFileProcessServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:JARVISFileProcessServer")
	WebElement JARVISFileProcessServercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:JARVISFileCreatorServerc2")
	WebElement JARVISFileCreatorServerstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:JARVISFileCreatorServer")
	WebElement JARVISFileCreatorServercheckbox;

	// WebElements for PGP Servers
	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_FileEncryption_Serverc2")
	WebElement NACH_FileEncryption_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_FileEncryption_Server")
	WebElement NACH_FileEncryption_Servercheckbox;

	@FindBy(id = "TRin,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_FileDecryption_Serverc2")
	WebElement NACH_FileDecryption_Serverstatus;

	@FindBy(id = "in,in/kotak_nach,in/kotak_nach/gps,in/kotak_nach/gps:NACH_FileDecryption_Server")
	WebElement NACH_FileDecryption_Servercheckbox;

	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	// EnvironmentPage Class Constructor
	public EnvironmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	//-----To click on Ok button------//
	public void clickonEnvironmentokbutton() throws InterruptedException {
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(environmentokbutton);
	}

	//------To set new Business Date--------//
	public void businessDate() throws InterruptedException {
		String Status = elementUtil.getText(sodStatus);
		String StatusEod = elementUtil.getText(eodStatus);
		if (Status.equals("Not Performed") && StatusEod.equals("Not Performed")) {
			elementUtil.clickElement(bdcheckbox);
			elementUtil.clickElement(setBusinessDateButton);
			elementUtil.clickElement(bdSubmitbutton);
			performSOD();
		} else if (Status.equals("Performed") && StatusEod.equals("Not Performed")) {
			log.info("SOD is already performed");
		} else if (Status.equals("Performed") && StatusEod.equals("Performed")) {
			log.info("SOD is already performed");
			log.info("EOD is already performed");
			elementUtil.clickElement(bdcheckbox);
			elementUtil.clickElement(setBusinessDateButton);
			elementUtil.clickElement(bdSubmitbutton);
			performSOD();
		}
		LogOut();
	}
	
	public void clickEODandManage() throws InterruptedException
	{
		eodcheckbox.click();
		elementUtil.SHORT_TIMEOUT();
		switchResourceButton.click();
		elementUtil.SHORT_TIMEOUT();
//		returnBtnStatus();
		manageBtn.click();
		elementUtil.SHORT_TIMEOUT();
		
		Select sel=new Select (preconditionsFilterDropdown);
		sel.selectByVisibleText("All");
		elementUtil.SHORT_TIMEOUT();
		reEvaluateBtn.click();
		//System.out.println("entering inside");
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(list);
		for (WebElement el : list)
		{
			if(!el.isSelected())
				el.click();
			Thread.sleep(100);
		}
		elementUtil.SHORT_TIMEOUT();
		reEvaluateBtn.click();
		elementUtil.SHORT_TIMEOUT();
		proceedBtn.click();
		returnBtnStatus();
		elementUtil.SHORT_TIMEOUT();
		
	}//end 

	//-------To Click on Return Button-------//
	public void returnBtnStatus() throws InterruptedException {
		boolean waitForReturnBtn = true;
		while (waitForReturnBtn) {
			if (null != buttonVisibility) {
				elementUtil.clickElement(returnButton);
				waitForReturnBtn = false;
			} else {
				log.info(new Date() + " start time");
				elementUtil.TIMEOUT();
				log.info(new Date() + " start time");
			}
		}
	}

	//------To perform SOD functionality-------//
	public void performSOD() throws InterruptedException {
		elementUtil.clickElement(sodcheckbox);
		elementUtil.clickElement(switchResourceButton);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(continuebutton);
		returnBtnStatus();
	}

	//--------Check envEventServer Status-------//
	public void checkenvEventServer() throws InterruptedException {
		String statusenvEventServer = elementUtil.getText(envEventServerstatus);
		if (statusenvEventServer.equals("Inactive")) {
			elementUtil.clickElement(envEventServercheckbox);
			elementUtil.clickElement(switchResourceButton);
			returnBtnStatus();
			checkenvEventServer1();
		} else {
			log.info("envEventServer is already running");
		}
	}

	public void checkenvEventServer1() {
		String statusenvEventServer = elementUtil.getText(envEventServerstatus);
		if (statusenvEventServer.equals("Active")) {
			log.info("envEventServer is started");
		} else {
			log.error("envEventServer is failed to start");
		}
	}

	//-------Check remoteResourceServer Status--------//
	public void checkremoteResourceServer() throws InterruptedException {
		String statusremoteResourceServer = elementUtil.getText(remoteResourceServerstatus);
		if (statusremoteResourceServer.equals("Inactive")) {
			elementUtil.clickElement(remoteResourceServercheckbox);
			elementUtil.clickElement(switchResourceButton);
			returnBtnStatus();
			checkremoteResourceServer1();
		} else {
			log.info("remoteResourceServer is already running");
		}
	}

	public void checkremoteResourceServer1() {
		String statusremoteResourceServer = elementUtil.getText(remoteResourceServerstatus);
		if (statusremoteResourceServer.equals("Active")) {
			log.info("remoteResourceServer is started");
		} else {
			log.error("remoteResourceServer is failed to start");
		}
	}

	//-------Check remoteLogConsoleServer Status---------//
	public void checkremoteLogConsoleServer() throws InterruptedException {
		String statusremoteLogConsoleServer = remoteLogConsoleServerstatus.getText();
		if (statusremoteLogConsoleServer.equals("Inactive")) {
			remoteLogConsoleServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkremoteLogConsoleServer1();
		} else {
			log.info("remoteLogConsoleServer is already running");
		}
	}

	public void checkremoteLogConsoleServer1() {
		String statusremoteLogConsoleServer = remoteLogConsoleServerstatus.getText();
		if (statusremoteLogConsoleServer.equals("Active")) {
			log.info("remoteLogConsoleServer is started");
		} else {
			log.error("remoteLogConsoleServer is failed to start");
		}
	}

	//---------Check schedulerTracker Status--------//
	public void checkschedulerTracker() throws InterruptedException {
		String statusschedulerTracker = schedulerTrackerstatus.getText();
		if (statusschedulerTracker.equals("Inactive")) {
			schedulerTrackercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkschedulerTracker1();
		} else {
			log.info("schedulerTracker is already running");
		}
	}

	public void checkschedulerTracker1() {
		String statusschedulerTracker = schedulerTrackerstatus.getText();
		if (statusschedulerTracker.equals("Active")) {
			log.info("schedulerTracker is started");
		} else {
			log.error("schedulerTracker is failed to start");
		}
	}

	//---------Check updaterServer Status---------//
	public void checkupdaterServer() throws InterruptedException {
		String statusupdaterServer = updaterServerstatus.getText();
		if (statusupdaterServer.equals("Inactive")) {
			updaterServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkupdaterServer1();
		} else {
			log.info("updaterServer is already running");
		}
	}

	public void checkupdaterServer1() {
		String statusupdaterServer = updaterServerstatus.getText();
		if (statusupdaterServer.equals("Active")) {
			log.info("updaterServer is started");
		} else {
			log.error("updaterServer is failed to start");
		}
	}

	//-----------Check emailServer Status-----------//
	public void checkemailServer() throws InterruptedException {
		String statusemailServer = emailServerstatus.getText();
		if (statusemailServer.equals("Inactive")) {
			emailServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkemailServer1();
		} else {
			log.info("emailServer is already running");
		}
	}

	public void checkemailServer1() {
		String statusemailServer = emailServerstatus.getText();
		if (statusemailServer.equals("Active")) {
			log.info("emailServer is started");
		} else {
			log.error("emailServer is failed to start");
		}
	}

	//-----------Check NPCI_Upload_Server Status----------//
	public void checkNPCI_Upload_Server() throws InterruptedException {
		String statusNPCI_Upload_Server = NPCI_Upload_Serverstatus.getText();
		if (statusNPCI_Upload_Server.equals("Inactive")) {
			NPCI_Upload_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNPCI_Upload_Server1();
		} else {
			log.info("NPCI_Upload_Server is already running");
		}
	}

	public void checkNPCI_Upload_Server1() {
		String statusNPCI_Upload_Server = NPCI_Upload_Serverstatus.getText();
		if (statusNPCI_Upload_Server.equals("Active")) {
			log.info("NPCI_Upload_Server is started");
		} else {
			log.error("NPCI_Upload_Server is failed to start");
		}
	}

	//-----------Check NPCI_Download_Server Status-----------//
	public void checkNPCI_Download_Server() throws InterruptedException {
		String statusNPCI_Download_Server = NPCI_Download_Serverstatus.getText();
		if (statusNPCI_Download_Server.equals("Inactive")) {
			NPCI_Download_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNPCI_Download_Server1();
		} else {
			log.info("NPCI_Download_Server is already running");
		}
	}

	public void checkNPCI_Download_Server1() {
		String statusNPCI_Download_Server = NPCI_Download_Serverstatus.getText();
		if (statusNPCI_Download_Server.equals("Active")) {
			log.info("NPCI_Download_Server is started");
		} else {
			log.error("NPCI_Download_Server is failed to start");
		}
	}

	//-----------Check File_Router_Server Status-------------//
	public void checkFile_Router_Server() throws InterruptedException {
		String statusFile_Router_Server = File_Router_Serverstatus.getText();
		if (statusFile_Router_Server.equals("Inactive")) {
			File_Router_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkFile_Router_Server1();
		} else {
			log.info("File_Router_Server is already running");
		}
	}

	public void checkFile_Router_Server1() {
		String statusFile_Router_Server = File_Router_Serverstatus.getText();
		if (statusFile_Router_Server.equals("Active")) {
			log.info("File_Router_Server is started");
		} else {
			log.error("File_Router_Server is failed to start");
		}
	}

	//------------Check MMS_InFile_Server Status------------//
	public void checkMMS_InFile_Server() throws InterruptedException {
		String statusMMS_InFile_Server = MMS_InFile_Serverstatus.getText();
		if (statusMMS_InFile_Server.equals("Inactive")) {
			MMS_InFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMMS_InFile_Server1();
		} else {
			log.info("MMS_InFile_Server is already running");
		}
	}

	public void checkMMS_InFile_Server1() {
		String statusMMS_InFile_Server = MMS_InFile_Serverstatus.getText();
		if (statusMMS_InFile_Server.equals("Active")) {
			log.info("MMS_InFile_Server is started");
		} else {
			log.error("MMS_InFile_Server is failed to start");
		}
	}

	//----------Check MMS_InProcess_Server Status-----------//
	public void checkMMS_InProcess_Server() throws InterruptedException {
		String statusMMS_InProcess_Server = MMS_InProcess_Serverstatus.getText();
		if (statusMMS_InProcess_Server.equals("Inactive")) {
			MMS_InProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMMS_InProcess_Server1();
		} else {
			log.info("MMS_InProcess_Server is already running");
		}
	}

	public void checkMMS_InProcess_Server1() {
		String statusMMS_InProcess_Server = MMS_InProcess_Serverstatus.getText();
		if (statusMMS_InProcess_Server.equals("Active")) {
			log.info("MMS_InProcess_Server is started");
		} else {
			log.error("MMS_InProcess_Server is failed to start");
		}
	}

	//----------Check MMS_OutFileCreate_Server Status-----------//
	public void checkMMS_OutFileCreate_Server() throws InterruptedException {
		String statusMMS_OutFileCreate_Server = MMS_OutFileCreate_Serverstatus.getText();
		if (statusMMS_OutFileCreate_Server.equals("Inactive")) {
			MMS_OutFileCreate_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMMS_OutFileCreate_Server1();
		} else {
			log.info("MMS_OutFileCreate_Server is already running");
		}
	}

	public void checkMMS_OutFileCreate_Server1() {
		String statusMMS_OutFileCreate_Server = MMS_OutFileCreate_Serverstatus.getText();
		if (statusMMS_OutFileCreate_Server.equals("Active")) {
			log.info("MMS_OutFileCreate_Server is started");
		} else {
			log.error("MMS_OutFileCreate_Server is failed to start");
		}
	}

	//-------------Check DBTL_InFile_Server Status------------//
	public void checkDBTL_InFile_Server() throws InterruptedException {
		String statusDBTL_InFile_Server = DBTL_InFile_Serverstatus.getText();
		if (statusDBTL_InFile_Server.equals("Inactive")) {
			DBTL_InFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkDBTL_InFile_Server1();
		} else {
			log.info("DBTL_InFile_Server is already running");
		}
	}

	public void checkDBTL_InFile_Server1() {
		String statusDBTL_InFile_Server = DBTL_InFile_Serverstatus.getText();
		if (statusDBTL_InFile_Server.equals("Active")) {
			log.info("DBTL_InFile_Server is started");
		} else {
			log.error("DBTL_InFile_Server is failed to start");
		}
	}

	//------------Check DBTL_InProcess_Server Status---------------//
	public void checkDBTL_InProcess_Server() throws InterruptedException {
		String statusDBTL_InProcess_Server = DBTL_InProcess_Serverstatus.getText();
		if (statusDBTL_InProcess_Server.equals("Inactive")) {
			DBTL_InProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkDBTL_InProcess_Server1();
		} else {
			log.info("DBTL_InProcess_Server is already running");
		}
	}

	public void checkDBTL_InProcess_Server1() {
		String statusDBTL_InProcess_Server = DBTL_InProcess_Serverstatus.getText();
		if (statusDBTL_InProcess_Server.equals("Active")) {
			log.info("DBTL_InProcess_Server is started");
		} else {
			log.error("DBTL_InProcess_Server is failed to start");
		}
	}

	//------------Check DBTL_Verification_Server Status--------------//
	public void checkDBTL_Verification_Server() throws InterruptedException {
		String statusDBTL_Verification_Server = DBTL_Verification_Serverstatus.getText();
		if (statusDBTL_Verification_Server.equals("Inactive")) {
			DBTL_Verification_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkDBTL_Verification_Server1();
		} else {
			log.info("DBTL_Verification_Server is already running");
		}
	}

	public void checkDBTL_Verification_Server1() {
		String statusDBTL_Verification_Server = DBTL_Verification_Serverstatus.getText();
		if (statusDBTL_Verification_Server.equals("Active")) {
			log.info("DBTL_Verification_Server is started");
		} else {
			log.error("DBTL_Verification_Server is failed to start");
		}
	}

	//---------Check DBTL_OutFileCreate_Server Status----------//
	public void checkDBTL_OutFileCreate_Server() throws InterruptedException {
		String statusDBTL_OutFileCreate_Server = DBTL_OutFileCreate_Serverstatus.getText();
		if (statusDBTL_OutFileCreate_Server.equals("Inactive")) {
			DBTL_OutFileCreate_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkDBTL_OutFileCreate_Server1();
		} else {
			log.info("DBTL_OutFileCreate_Server is already running");
		}
	}

	public void checkDBTL_OutFileCreate_Server1() {
		String statusDBTL_OutFileCreate_Server = DBTL_OutFileCreate_Serverstatus.getText();
		if (statusDBTL_OutFileCreate_Server.equals("Active")) {
			log.info("DBTL_OutFileCreate_Server is started");
		} else {
			log.error("DBTL_OutFileCreate_Server is failed to start");
		}
	}

	//-----------Check CBDT_InFile_Server Status------------//
	public void checkCBDT_InFile_Server() throws InterruptedException {
		String statusCBDT_InFile_Server = CBDT_InFile_Serverstatus.getText();
		if (statusCBDT_InFile_Server.equals("Inactive")) {
			CBDT_InFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCBDT_InFile_Server1();
		} else {
			log.info("CBDT_InFile_Server is already running");
		}
	}

	public void checkCBDT_InFile_Server1() {
		String statusCBDT_InFile_Server = CBDT_InFile_Serverstatus.getText();
		if (statusCBDT_InFile_Server.equals("Active")) {
			log.info("CBDT_InFile_Server is started");
		} else {
			log.error("CBDT_InFile_Server is failed to start");
		}
	}

	//----------Check CBDT_InProcess_Server Status----------//
	public void checkCBDT_InProcess_Server() throws InterruptedException {
		String statusCBDT_InProcess_Server = CBDT_InProcess_Serverstatus.getText();
		if (statusCBDT_InProcess_Server.equals("Inactive")) {
			CBDT_InProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCBDT_InProcess_Server1();
		} else {
			log.info("CBDT_InProcess_Server is already running");
		}
	}

	public void checkCBDT_InProcess_Server1() {
		String statusCBDT_InProcess_Server = CBDT_InProcess_Serverstatus.getText();
		if (statusCBDT_InProcess_Server.equals("Active")) {
			log.info("CBDT_InProcess_Server is started");
		} else {
			log.error("CBDT_InProcess_Server is failed to start");
		}
	}

	//-----------Check CBDT_AccountVerification_Server Status---------------//
	public void checkCBDT_AccountVerification_Server() throws InterruptedException {
		String statusCBDT_AccountVerification_Server = CBDT_AccountVerification_Serverstatus.getText();
		if (statusCBDT_AccountVerification_Server.equals("Inactive")) {
			CBDT_AccountVerification_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCBDT_AccountVerification_Server1();
		} else {
			log.info("CBDT_AccountVerification_Server is already running");
		}
	}

	public void checkCBDT_AccountVerification_Server1() {
		String statusCBDT_AccountVerification_Server = CBDT_AccountVerification_Serverstatus.getText();
		if (statusCBDT_AccountVerification_Server.equals("Active")) {
			log.info("CBDT_AccountVerification_Server is started");
		} else {
			log.error("CBDT_AccountVerification_Server is failed to start");
		}
	}

	//---------Check CBDT_OutFileCreate_Server Status----------//
	public void checkCBDT_OutFileCreate_Server() throws InterruptedException {
		String statusCBDT_OutFileCreate_Server = CBDT_OutFileCreate_Serverstatus.getText();
		if (statusCBDT_OutFileCreate_Server.equals("Inactive")) {
			CBDT_OutFileCreate_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCBDT_OutFileCreate_Server1();
		} else {
			log.info("CBDT_OutFileCreate_Server is already running");
		}
	}

	public void checkCBDT_OutFileCreate_Server1() {
		String statusCBDT_OutFileCreate_Server = CBDT_OutFileCreate_Serverstatus.getText();
		if (statusCBDT_OutFileCreate_Server.equals("Active")) {
			log.info("CBDT_OutFileCreate_Server is started");
		} else {
			log.error("CBDT_OutFileCreate_Server is failed to start");
		}
	}

	//----------Check NACH_InFile_Server Status---------//
	public void checkNACH_InFile_Server() throws InterruptedException {
		String statusNACH_InFile_Server = NACH_InFile_Serverstatus.getText();
		if (statusNACH_InFile_Server.equals("Inactive")) {
			NACH_InFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_InFile_Server1();
		} else {
			log.info("NACH_InFile_Server is already running");
		}
	}

	public void checkNACH_InFile_Server1() {
		String statusNACH_InFile_Server = NACH_InFile_Serverstatus.getText();
		if (statusNACH_InFile_Server.equals("Active")) {
			log.info("NACH_InFile_Server is started");
		} else {
			log.error("NACH_InFile_Server is failed to start");
		}
	}

	//----------Check NACH_InProcess_Server Status-------------//
	public void checkNACH_InProcess_Server() throws InterruptedException {
		String statusNACH_InProcess_Server = NACH_InProcess_Serverstatus.getText();
		if (statusNACH_InProcess_Server.equals("Inactive")) {
			NACH_InProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_InProcess_Server1();
		} else {
			log.info("NACH_InProcess_Server is already running");
		}
	}

	public void checkNACH_InProcess_Server1() {
		String statusNACH_InProcess_Server = NACH_InProcess_Serverstatus.getText();
		if (statusNACH_InProcess_Server.equals("Active")) {
			log.info("NACH_InProcess_Server is started");
		} else {
			log.error("NACH_InProcess_Server is failed to start");
		}
	}

	//---------Check NACH_OutProcess_Server Status----------//
	public void checkNACH_OutProcess_Server() throws InterruptedException {
		String statusNACH_OutProcess_Server = NACH_OutProcess_Serverstatus.getText();
		if (statusNACH_OutProcess_Server.equals("Inactive")) {
			NACH_OutProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_OutProcess_Server1();
		} else {
			log.info("NACH_OutProcess_Server is already running");
		}
	}

	public void checkNACH_OutProcess_Server1() {
		String statusNACH_OutProcess_Server = NACH_OutProcess_Serverstatus.getText();
		if (statusNACH_OutProcess_Server.equals("Active")) {
			log.info("NACH_OutProcess_Server is started");
		} else {
			log.error("NACH_OutProcess_Server is failed to start");
		}
	}

	//----------Check NACH_OutFileCreate_Server Status-----------//
	public void checkNACH_OutFileCreate_Server() throws InterruptedException {
		String statusNACH_OutFileCreate_Server = NACH_OutFileCreate_Serverstatus.getText();
		if (statusNACH_OutFileCreate_Server.equals("Inactive")) {
			NACH_OutFileCreate_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_OutFileCreate_Server1();
		} else {
			log.info("NACH_OutFileCreate_Server is already running");
		}
	}

	public void checkNACH_OutFileCreate_Server1() {
		String statusNACH_OutFileCreate_Server = NACH_OutFileCreate_Serverstatus.getText();
		if (statusNACH_OutFileCreate_Server.equals("Active")) {
			log.info("NACH_OutFileCreate_Server is started");
		} else {
			log.error("NACH_OutFileCreate_Server is failed to start");
		}
	}

	//----------Check Corporate_InFile_Server Status----------//
	public void checkCorporate_InFile_Server() throws InterruptedException {
		String statusCorporate_InFile_Server = Corporate_InFile_Serverstatus.getText();
		if (statusCorporate_InFile_Server.equals("Inactive")) {
			Corporate_InFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCorporate_InFile_Server1();
		} else {
			log.info("Corporate_InFile_Server is already running");
		}
	}

	public void checkCorporate_InFile_Server1() {
		String statusCorporate_InFile_Server = Corporate_InFile_Serverstatus.getText();
		if (statusCorporate_InFile_Server.equals("Active")) {
			log.info("Corporate_InFile_Server is started");
		} else {
			log.error("Corporate_InFile_Server is failed to start");
		}
	}

	//------------Check Corporate_InProcess_Server Status---------//
	public void checkCorporate_InProcess_Server() throws InterruptedException {
		String statusCorporate_InProcess_Server = Corporate_InProcess_Serverstatus.getText();
		if (statusCorporate_InProcess_Server.equals("Inactive")) {
			Corporate_InProcess_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCorporate_InProcess_Server1();
		} else {
			log.info("Corporate_InProcess_Server is already running");
		}
	}

	public void checkCorporate_InProcess_Server1() {
		String statusCorporate_InProcess_Server = Corporate_InProcess_Serverstatus.getText();
		if (statusCorporate_InProcess_Server.equals("Active")) {
			log.info("Corporate_InProcess_Server is started");
		} else {
			log.error("Corporate_InProcess_Server is failed to start");
		}
	}

	//-----------Check LIC_INFile_Server Status----------//
	public void checkLIC_INFile_Server() throws InterruptedException {
		String statusLIC_INFile_Server = LIC_INFile_Serverstatus.getText();
		if (statusLIC_INFile_Server.equals("Inactive")) {
			LIC_INFile_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkLIC_INFile_Server1();
		} else {
			log.info("LIC_INFile_Server is already running");
		}
	}

	public void checkLIC_INFile_Server1() {
		String statusLIC_INFile_Server = LIC_INFile_Serverstatus.getText();
		if (statusLIC_INFile_Server.equals("Active")) {
			log.info("LIC_INFile_Server is started");
		} else {
			log.error("LIC_INFile_Server is failed to start");
		}
	}

	//------------Check SCHM_Segrigate_Server Status---------//
	public void checkSCHM_Segrigate_Server() throws InterruptedException {
		String statusSCHM_Segrigate_Server = SCHM_Segrigate_Serverstatus.getText();
		if (statusSCHM_Segrigate_Server.equals("Inactive")) {
			SCHM_Segrigate_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkSCHM_Segrigate_Server1();
		} else {
			log.info("SCHM_Segrigate_Server is already running");
		}
	}

	public void checkSCHM_Segrigate_Server1() {
		String statusSCHM_Segrigate_Server = SCHM_Segrigate_Serverstatus.getText();
		if (statusSCHM_Segrigate_Server.equals("Active")) {
			log.info("SCHM_Segrigate_Server is started");
		} else {
			log.error("SCHM_Segrigate_Server is failed to start");
		}
	}

	//-------------Check AutoMisServer Status--------------//
	public void checkAutoMisServer() throws InterruptedException {
		String statusAutoMisServer = AutoMisServerstatus.getText();
		if (statusAutoMisServer.equals("Inactive")) {
			AutoMisServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkAutoMisServer1();
		} else {
			log.info("AutoMisServer is already running");
		}
	}

	public void checkAutoMisServer1() {
		String statusAutoMisServer = AutoMisServerstatus.getText();
		if (statusAutoMisServer.equals("Active")) {
			log.info("AutoMisServer is started");
		} else {
			log.error("AutoMisServer is failed to start");
		}
	}

	//---------Check H2HMMSServer Status----------//
	public void checkH2HMMSServer() throws InterruptedException {
		String statusH2HMMSServer = H2HMMSServerstatus.getText();
		if (statusH2HMMSServer.equals("Inactive")) {
			H2HMMSServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkH2HMMSServer1();
		} else {
			log.info("H2HMMSServer is already running");
		}
	}

	public void checkH2HMMSServer1() {
		String statusH2HMMSServer = H2HMMSServerstatus.getText();
		if (statusH2HMMSServer.equals("Active")) {
			log.info("H2HMMSServer is started");
		} else {
			log.error("H2HMMSServer is failed to start");
		}
	}

	//----------Check H2HFileServerRouter Status-----------//
	public void checkH2HFileServerRouter() throws InterruptedException {
		String statusH2HFileServerRouter = H2HFileServerRouterstatus.getText();
		if (statusH2HFileServerRouter.equals("Inactive")) {
			H2HFileServerRoutercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkH2HFileServerRouter1();
		} else {
			log.info("H2HFileServerRouter is already running");
		}
	}

	public void checkH2HFileServerRouter1() {
		String statusH2HFileServerRouter = H2HFileServerRouterstatus.getText();
		if (statusH2HFileServerRouter.equals("Active")) {
			log.info("H2HFileServerRouter is started");
		} else {
			log.error("H2HFileServerRouter is failed to start");
		}
	}

	//---------Check MandateRepresentServer Status----------//
	public void checkMandateRepresentServer() throws InterruptedException {
		String statusMandateRepresentServer = MandateRepresentServerstatus.getText();
		if (statusMandateRepresentServer.equals("Inactive")) {
			MandateRepresentServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMandateRepresentServer1();
		} else {
			log.info("MandateRepresentServer is already running");
		}
	}

	public void checkMandateRepresentServer1() {
		String statusMandateRepresentServer = MandateRepresentServerstatus.getText();
		if (statusMandateRepresentServer.equals("Active")) {
			log.info("MandateRepresentServer is started");
		} else {
			log.error("MandateRepresentServer is failed to start");
		}
	}

	//-----------Check TransactionRepresentServer Status----------//
	public void checkTransactionRepresentServer() throws InterruptedException {
		String statusTransactionRepresentServer = TransactionRepresentServerstatus.getText();
		if (statusTransactionRepresentServer.equals("Inactive")) {
			TransactionRepresentServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkTransactionRepresentServer1();
		} else {
			log.info("TransactionRepresentServer is already running");
		}
	}

	public void checkTransactionRepresentServer1() {
		String statusTransactionRepresentServer = TransactionRepresentServerstatus.getText();
		if (statusTransactionRepresentServer.equals("Active")) {
			log.info("TransactionRepresentServer is started");
		} else {
			log.error("TransactionRepresentServer is failed to start");
		}
	}

	//---------Check GpsFileProgressServer Status----------//
	public void checkGpsFileProgressServer() throws InterruptedException {
		String statusGpsFileProgressServer = GpsFileProgressServerstatus.getText();
		if (statusGpsFileProgressServer.equals("Inactive")) {
			GpsFileProgressServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkGpsFileProgressServer1();
		} else {
			log.info("GpsFileProgressServer is already running");
		}
	}

	public void checkGpsFileProgressServer1() {
		String statusGpsFileProgressServer = GpsFileProgressServerstatus.getText();
		if (statusGpsFileProgressServer.equals("Active")) {
			log.info("GpsFileProgressServer is started");
		} else {
			log.error("GpsFileProgressServer is failed to start");
		}
	}

	//-----------Check GpsPaymentProgressServer Status----------//
	public void checkGpsPaymentProgressServer() throws InterruptedException {
		String statusGpsPaymentProgressServer = GpsPaymentProgressServerstatus.getText();
		if (statusGpsPaymentProgressServer.equals("Inactive")) {
			GpsPaymentProgressServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkGpsPaymentProgressServer1();
		} else {
			log.info("GpsPaymentProgressServer is already running");
		}
	}

	public void checkGpsPaymentProgressServer1() {
		String statusGpsPaymentProgressServer = GpsPaymentProgressServerstatus.getText();
		if (statusGpsPaymentProgressServer.equals("Active")) {
			log.info("GpsPaymentProgressServer is started");
		} else {
			log.error("GpsPaymentProgressServer is failed to start");
		}
	}

	//----------Check ChargePostingServer Status----------//
	public void checkChargePostingServer() throws InterruptedException {
		String statusChargePostingServer = ChargePostingServerstatus.getText();
		if (statusChargePostingServer.equals("Inactive")) {
			ChargePostingServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkChargePostingServer1();
		} else {
			log.info("ChargePostingServer is already running");
		}
	}

	public void checkChargePostingServer1() {
		String statusChargePostingServer = ChargePostingServerstatus.getText();
		if (statusChargePostingServer.equals("Active")) {
			log.info("ChargePostingServer is started");
		} else {
			log.error("ChargePostingServer is failed to start");
		}
	}

	//----------Check CorporateFundingServer Status---------//
	public void checkCorporateFundingServer() throws InterruptedException {
		String statusCorporateFundingServer = CorporateFundingServerstatus.getText();
		if (statusCorporateFundingServer.equals("Inactive")) {
			CorporateFundingServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkCorporateFundingServer1();
		} else {
			log.info("CorporateFundingServer is already running");
		}
	}

	public void checkCorporateFundingServer1() {
		String statusCorporateFundingServer = CorporateFundingServerstatus.getText();
		if (statusCorporateFundingServer.equals("Active")) {
			log.info("CorporateFundingServer is started");
		} else {
			log.error("CorporateFundingServer is failed to start");
		}
	}

	//----------Check FileMarkCompleteServer Status----------//
	public void checkFileMarkCompleteServer() throws InterruptedException {
		String statusFileMarkCompleteServer = FileMarkCompleteServerstatus.getText();
		if (statusFileMarkCompleteServer.equals("Inactive")) {
			FileMarkCompleteServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkFileMarkCompleteServer1();
		} else {
			log.info("FileMarkCompleteServer is already running");
		}
	}

	public void checkFileMarkCompleteServer1() {
		String statusFileMarkCompleteServer = FileMarkCompleteServerstatus.getText();
		if (statusFileMarkCompleteServer.equals("Active")) {
			log.info("FileMarkCompleteServer is started");
		} else {
			log.error("FileMarkCompleteServer is failed to start");
		}
	}

	//-----------Check FilePostingMarkCompleteServer Status-----------//
	public void checkFilePostingMarkCompleteServer() throws InterruptedException {
		String statusFilePostingMarkCompleteServer = FilePostingMarkCompleteServerstatus.getText();
		if (statusFilePostingMarkCompleteServer.equals("Inactive")) {
			FilePostingMarkCompleteServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkFilePostingMarkCompleteServer1();
		} else {
			log.info("FilePostingMarkCompleteServer is already running");
		}
	}

	public void checkFilePostingMarkCompleteServer1() {
		String statusFilePostingMarkCompleteServer = FilePostingMarkCompleteServerstatus.getText();
		if (statusFilePostingMarkCompleteServer.equals("Active")) {
			log.info("FilePostingMarkCompleteServer is started");
		} else {
			log.error("FilePostingMarkCompleteServer is failed to start");
		}
	}

	//-----------Check Finacle_Posting_Server Status-------------//
	public void checkFinacle_Posting_Server() throws InterruptedException {
		String statusFinacle_Posting_Server = Finacle_Posting_Serverstatus.getText();
		if (statusFinacle_Posting_Server.equals("Inactive")) {
			Finacle_Posting_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkFinacle_Posting_Server1();
		} else {
			log.info("Finacle_Posting_Server is already running");
		}
	}

	public void checkFinacle_Posting_Server1() {
		String statusFinacle_Posting_Server = Finacle_Posting_Serverstatus.getText();
		if (statusFinacle_Posting_Server.equals("Active")) {
			log.info("Finacle_Posting_Server is started");
		} else {
			log.error("Finacle_Posting_Server is failed to start");
		}
	}

	//----------Check GpsReQueueingServer Status------------//
	public void checkGpsReQueueingServer() throws InterruptedException {
		String statusGpsReQueueingServer = GpsReQueueingServerstatus.getText();
		if (statusGpsReQueueingServer.equals("Inactive")) {
			GpsReQueueingServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkGpsReQueueingServer1();
		} else {
			log.info("GpsReQueueingServer is already running");
		}
	}

	public void checkGpsReQueueingServer1() {
		String statusGpsReQueueingServer = GpsReQueueingServerstatus.getText();
		if (statusGpsReQueueingServer.equals("Active")) {
			log.info("GpsReQueueingServer is started");
		} else {
			log.error("GpsReQueueingServer is failed to start");
		}
	}

	//-----------Check IpaymentReQueueingServer Status-----------//
	public void checkIpaymentReQueueingServer() throws InterruptedException {
		String statusIpaymentReQueueingServer = IpaymentReQueueingServerstatus.getText();
		if (statusIpaymentReQueueingServer.equals("Inactive")) {
			IpaymentReQueueingServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkIpaymentReQueueingServer1();
		} else {
			log.info("IpaymentReQueueingServer is already running");
		}
	}

	public void checkIpaymentReQueueingServer1() {
		String statusIpaymentReQueueingServer = IpaymentReQueueingServerstatus.getText();
		if (statusIpaymentReQueueingServer.equals("Active")) {
			log.info("IpaymentReQueueingServer is started");
		} else {
			log.error("IpaymentReQueueingServer is failed to start");
		}
	}

	//------------Check Inward_Debit_Posting_Server Status-----------//
	public void checkInward_Debit_Posting_Server() throws InterruptedException {
		String statusInward_Debit_Posting_Server = Inward_Debit_Posting_Serverstatus.getText();
		if (statusInward_Debit_Posting_Server.equals("Inactive")) {
			Inward_Debit_Posting_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Debit_Posting_Server1();
		} else {
			log.info("Inward_Debit_Posting_Server is already running");
		}
	}

	public void checkInward_Debit_Posting_Server1() {
		String statusInward_Debit_Posting_Server = Inward_Debit_Posting_Serverstatus.getText();
		if (statusInward_Debit_Posting_Server.equals("Active")) {
			log.info("Inward_Debit_Posting_Server is started");
		} else {
			log.error("Inward_Debit_Posting_Server is failed to start");
		}
	}

	//----------Check Inward_Credit_Posting_Server Status----------//
	public void checkInward_Credit_Posting_Server() throws InterruptedException {
		String statusInward_Credit_Posting_Server = Inward_Credit_Posting_Serverstatus.getText();
		if (statusInward_Credit_Posting_Server.equals("Inactive")) {
			Inward_Credit_Posting_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Credit_Posting_Server1();
		} else {
			log.info("Inward_Credit_Posting_Server is already running");
		}
	}

	public void checkInward_Credit_Posting_Server1() {
		String statusInward_Credit_Posting_Server = Inward_Credit_Posting_Serverstatus.getText();
		if (statusInward_Credit_Posting_Server.equals("Active")) {
			log.info("Inward_Credit_Posting_Server is started");
		} else {
			log.error("Inward_Credit_Posting_Server is failed to start");
		}
	}

	//------------Check Inward_Debit_RePosting_Server Status------------//
	public void checkInward_Debit_RePosting_Server() throws InterruptedException {
		String statusInward_Debit_RePosting_Server = Inward_Debit_RePosting_Serverstatus.getText();
		if (statusInward_Debit_RePosting_Server.equals("Inactive")) {
			Inward_Debit_RePosting_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Debit_RePosting_Server1();
		} else {
			log.info("Inward_Debit_RePosting_Server is already running");
		}
	}

	public void checkInward_Debit_RePosting_Server1() {
		String statusInward_Debit_RePosting_Server = Inward_Debit_RePosting_Serverstatus.getText();
		if (statusInward_Debit_RePosting_Server.equals("Active")) {
			log.info("Inward_Debit_RePosting_Server is started");
		} else {
			log.error("Inward_Debit_RePosting_Server is failed to start");
		}
	}

	//----------Check Inward_Credit_RePosting_Server Status-----------//
	public void checkInward_Credit_RePosting_Server() throws InterruptedException {
		String statusInward_Credit_RePosting_Server = Inward_Credit_RePosting_Serverstatus.getText();
		if (statusInward_Credit_RePosting_Server.equals("Inactive")) {
			Inward_Credit_RePosting_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Credit_RePosting_Server1();
		} else {
			log.info("Inward_Credit_RePosting_Server is already running");
		}
	}

	public void checkInward_Credit_RePosting_Server1() {
		String statusInward_Credit_RePosting_Server = Inward_Credit_RePosting_Serverstatus.getText();
		if (statusInward_Credit_RePosting_Server.equals("Active")) {
			log.info("Inward_Credit_RePosting_Server is started");
		} else {
			log.error("Inward_Credit_RePosting_Server is failed to start");
		}
	}

	//-----------Check Inward_Debit_ReffralPost_Server Status-----------//
	public void checkInward_Debit_ReffralPost_Server() throws InterruptedException {
		String statusInward_Debit_ReffralPost_Server = Inward_Debit_ReffralPost_Serverstatus.getText();
		if (statusInward_Debit_ReffralPost_Server.equals("Inactive")) {
			Inward_Debit_ReffralPost_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Debit_ReffralPost_Server1();
		} else {
			log.info("Inward_Debit_ReffralPost_Server is already running");
		}
	}

	public void checkInward_Debit_ReffralPost_Server1() {
		String statusInward_Debit_ReffralPost_Server = Inward_Debit_ReffralPost_Serverstatus.getText();
		if (statusInward_Debit_ReffralPost_Server.equals("Active")) {
			log.info("Inward_Debit_ReffralPost_Server is started");
		} else {
			log.error("Inward_Debit_ReffralPost_Server is failed to start");
		}
	}

	//-----------Check Inward_Credit_ReffralPost_Server Status----------//
	public void checkInward_Credit_ReffralPost_Server() throws InterruptedException {
		String statusInward_Credit_ReffralPost_Server = Inward_Credit_ReffralPost_Serverstatus.getText();
		if (statusInward_Credit_ReffralPost_Server.equals("Inactive")) {
			Inward_Credit_ReffralPost_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkInward_Credit_ReffralPost_Server1();
		} else {
			log.info("Inward_Credit_ReffralPost_Server is already running");
		}
	}

	public void checkInward_Credit_ReffralPost_Server1() {
		String statusInward_Credit_ReffralPost_Server = Inward_Credit_ReffralPost_Serverstatus.getText();
		if (statusInward_Credit_ReffralPost_Server.equals("Active")) {
			log.info("Inward_Credit_ReffralPost_Server is started");
		} else {
			log.error("Inward_Credit_ReffralPost_Server is failed to start");
		}
	}

	//-------------Check Mandate_SMS_Alerts_Server Status-----------//
	public void checkMandate_SMS_Alerts_Server() throws InterruptedException {
		String statusMandate_SMS_Alerts_Server = Mandate_SMS_Alerts_Serverstatus.getText();
		if (statusMandate_SMS_Alerts_Server.equals("Inactive")) {
			Mandate_SMS_Alerts_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMandate_SMS_Alerts_Server1();
		} else {
			log.info("Mandate_SMS_Alerts_Server is already running");
		}
	}

	public void checkMandate_SMS_Alerts_Server1() {
		String statusMandate_SMS_Alerts_Server = Mandate_SMS_Alerts_Serverstatus.getText();
		if (statusMandate_SMS_Alerts_Server.equals("Active")) {
			log.info("Mandate_SMS_Alerts_Server is started");
		} else {
			log.error("Mandate_SMS_Alerts_Server is failed to start");
		}
	}

	//-----------Check Mandate_EMAIL_Alerts_Server Status-------------//
	public void checkMandate_EMAIL_Alerts_Server() throws InterruptedException {
		String statusMandate_EMAIL_Alerts_Server = Mandate_EMAIL_Alerts_Serverstatus.getText();
		if (statusMandate_EMAIL_Alerts_Server.equals("Inactive")) {
			Mandate_EMAIL_Alerts_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkMandate_EMAIL_Alerts_Server1();
		} else {
			log.info("Mandate_EMAIL_Alerts_Server is already running");
		}
	}

	public void checkMandate_EMAIL_Alerts_Server1() {
		String statusMandate_EMAIL_Alerts_Server = Mandate_EMAIL_Alerts_Serverstatus.getText();
		if (statusMandate_EMAIL_Alerts_Server.equals("Active")) {
			log.info("Mandate_EMAIL_Alerts_Server is started");
		} else {
			log.error("Mandate_EMAIL_Alerts_Server is failed to start");
		}
	}

	//------------Check Payment_SMS_Alerts_Server Status-------------//
	public void checkPayment_SMS_Alerts_Server() throws InterruptedException {
		String statusPayment_SMS_Alerts_Server = Payment_SMS_Alerts_Serverstatus.getText();
		if (statusPayment_SMS_Alerts_Server.equals("Inactive")) {
			Payment_SMS_Alerts_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkPayment_SMS_Alerts_Server1();
		} else {
			log.info("Payment_SMS_Alerts_Server is already running");
		}
	}

	public void checkPayment_SMS_Alerts_Server1() {
		String statusPayment_SMS_Alerts_Server = Payment_SMS_Alerts_Serverstatus.getText();
		if (statusPayment_SMS_Alerts_Server.equals("Active")) {
			log.info("Payment_SMS_Alerts_Server is started");
		} else {
			log.error("Payment_SMS_Alerts_Server is failed to start");
		}
	}

	//------------Check Payment_EMAIL_Alerts_Server Status-----------//
	public void checkPayment_EMAIL_Alerts_Server() throws InterruptedException {
		String statusPayment_EMAIL_Alerts_Server = Payment_EMAIL_Alerts_Serverstatus.getText();
		if (statusPayment_EMAIL_Alerts_Server.equals("Inactive")) {
			Payment_EMAIL_Alerts_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkPayment_EMAIL_Alerts_Server1();
		} else {
			log.info("Payment_EMAIL_Alerts_Server is already running");
		}
	}

	public void checkPayment_EMAIL_Alerts_Server1() {
		String statusPayment_EMAIL_Alerts_Server = Payment_EMAIL_Alerts_Serverstatus.getText();
		if (statusPayment_EMAIL_Alerts_Server.equals("Active")) {
			log.info("Payment_EMAIL_Alerts_Server is started");
		} else {
			log.error("Payment_EMAIL_Alerts_Server is failed to start");
		}
	}

	//-------------Check PaymentPosting_Alert_Server Status------------//
	public void checkPaymentPosting_Alert_Server() throws InterruptedException {
		String statusPaymentPosting_Alert_Server = PaymentPosting_Alert_Serverstatus.getText();
		if (statusPaymentPosting_Alert_Server.equals("Inactive")) {
			PaymentPosting_Alert_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkPaymentPosting_Alert_Server1();
		} else {
			log.info("PaymentPosting_Alert_Server is already running");
		}
	}

	public void checkPaymentPosting_Alert_Server1() {
		String statusPaymentPosting_Alert_Server = PaymentPosting_Alert_Serverstatus.getText();
		if (statusPaymentPosting_Alert_Server.equals("Active")) {
			log.info("PaymentPosting_Alert_Server is started");
		} else {
			log.error("PaymentPosting_Alert_Server is failed to start");
		}
	}

	//------------Check ESIGNMMSInFileServer Status-----------//
	public void checkESIGNMMSInFileServer() throws InterruptedException {
		String statusESIGNMMSInFileServer = ESIGNMMSInFileServerstatus.getText();
		if (statusESIGNMMSInFileServer.equals("Inactive")) {
			ESIGNMMSInFileServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkESIGNMMSInFileServer1();
		} else {
			log.info("ESIGNMMSInFileServer is already running");
		}
	}

	public void checkESIGNMMSInFileServer1() {
		String statusESIGNMMSInFileServer = ESIGNMMSInFileServerstatus.getText();
		if (statusESIGNMMSInFileServer.equals("Active")) {
			log.info("ESIGNMMSInFileServer is started");
		} else {
			log.error("ESIGNMMSInFileServer is failed to start");
		}
	}

	//-----------Check ESIGNMMSVerificationServer Status-----------//
	public void checkESIGNMMSVerificationServer() throws InterruptedException {
		String statusESIGNMMSVerificationServer = ESIGNMMSVerificationServerstatus.getText();
		if (statusESIGNMMSVerificationServer.equals("Inactive")) {
			ESIGNMMSVerificationServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkESIGNMMSVerificationServer1();
		} else {
			log.info("ESIGNMMSVerificationServer is already running");
		}
	}

	public void checkESIGNMMSVerificationServer1() {
		String statusESIGNMMSVerificationServer = ESIGNMMSVerificationServerstatus.getText();
		if (statusESIGNMMSVerificationServer.equals("Active")) {
			log.info("ESIGNMMSVerificationServer is started");
		} else {
			log.error("ESIGNMMSVerificationServer is failed to start");
		}
	}

	//-----------Check APIMandateValidateServer Status------------//
	public void checkAPIMandateValidateServer() throws InterruptedException {
		String statusAPIMandateValidateServer = APIMandateValidateServerstatus.getText();
		if (statusAPIMandateValidateServer.equals("Inactive")) {
			APIMandateValidateServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkAPIMandateValidateServer1();
		} else {
			log.info("APIMandateValidateServer is already running");
		}
	}

	public void checkAPIMandateValidateServer1() {
		String statusAPIMandateValidateServer = APIMandateValidateServerstatus.getText();
		if (statusAPIMandateValidateServer.equals("Active")) {
			log.info("APIMandateValidateServer is started");
		} else {
			log.error("APIMandateValidateServer is failed to start");
		}
	}

	//--------------Check JARVISFileProcessServer Status-------------//
	public void checkJARVISFileProcessServer() throws InterruptedException {
		String statusJARVISFileProcessServer = JARVISFileProcessServerstatus.getText();
		if (statusJARVISFileProcessServer.equals("Inactive")) {
			JARVISFileProcessServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkJARVISFileProcessServer1();
		} else {
			log.info("JARVISFileProcessServer is already running");
		}
	}

	public void checkJARVISFileProcessServer1() {
		String statusJARVISFileProcessServer = JARVISFileProcessServerstatus.getText();
		if (statusJARVISFileProcessServer.equals("Active")) {
			log.info("JARVISFileProcessServer is started");
		} else {
			log.error("JARVISFileProcessServer is failed to start");
		}
	}

	//-----------Check JARVISFileCreatorServer Status------------//
	public void checkJARVISFileCreatorServer() throws InterruptedException {
		String statusJARVISFileCreatorServer = JARVISFileCreatorServerstatus.getText();
		if (statusJARVISFileCreatorServer.equals("Inactive")) {
			JARVISFileCreatorServercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkJARVISFileCreatorServer1();
		} else {
			log.info("JARVISFileCreatorServer is already running");
		}
	}

	public void checkJARVISFileCreatorServer1() {
		String statusJARVISFileCreatorServer = JARVISFileCreatorServerstatus.getText();
		if (statusJARVISFileCreatorServer.equals("Active")) {
			log.info("JARVISFileCreatorServer is started");
		} else {
			log.error("JARVISFileCreatorServer is failed to start");
		}
	}

	//---------------Check NACH_FileEncryption_Server Status--------------//
	public void checkNACH_FileEncryption_Server() throws InterruptedException {
		String statusNACH_FileEncryption_Server = NACH_FileEncryption_Serverstatus.getText();
		if (statusNACH_FileEncryption_Server.equals("Inactive")) {
			NACH_FileEncryption_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_FileEncryption_Server1();
		} else {
			log.info("NACH_FileEncryption_Server is already running");
		}
	}

	public void checkNACH_FileEncryption_Server1() {
		String statusNACH_FileEncryption_Server = NACH_FileEncryption_Serverstatus.getText();
		if (statusNACH_FileEncryption_Server.equals("Active")) {
			log.info("NACH_FileEncryption_Server is started");
		} else {
			log.error("NACH_FileEncryption_Server is failed to start");
		}
	}

	//---------------Check NACH_FileDecryption_Server Status-------------//
	public void checkNACH_FileDecryption_Server() throws InterruptedException {
		String statusNACH_FileDecryption_Server = NACH_FileDecryption_Serverstatus.getText();
		if (statusNACH_FileDecryption_Server.equals("Inactive")) {
			NACH_FileEncryption_Servercheckbox.click();
			switchResourceButton.click();
			returnBtnStatus();
			checkNACH_FileEncryption_Server1();
		} else {
			log.info("NACH_FileDecryption_Server is already running");
		}
	}

	public void checkNACH_FileDecryption_Server1() {
		String statusNACH_FileDecryption_Server = NACH_FileDecryption_Serverstatus.getText();
		if (statusNACH_FileDecryption_Server.equals("Active")) {
			log.info("NACH_FileDecryption_Server is started");
		} else {
			log.error("NACH_FileDecryption_Server is failed to start");
		}
	}

	//---------Check Logout function----------//
	public void LogOut() {
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
	}
}
