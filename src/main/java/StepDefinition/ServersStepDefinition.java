package StepDefinition;

import org.openqa.selenium.WebDriver;
import COM.KOTAK.QA.FACTORY.DriverFactory;
import COM.KOTAK.QA.PAGES.EnvironmentPage;
import COM.KOTAK.QA.PAGES.HomePage;
import COM.KOTAK.QA.PAGES.LoginPage;
import COM.KOTAK.QA.UTIL.ElementUtil;
import io.cucumber.java.en.Then;

/**
* @Author -- Suvarna Prabhumatkari
**/

public class ServersStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver=DriverFactory.getDriver();
	EnvironmentPage environmentPage;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil=new ElementUtil(driver);

	@Then("User goes to Environment and Open Run menu")
	public void user_goes_to_Environment_and_Open_Run_menu() throws InterruptedException {
	   elementUtil.GoToFrame("toc");
	   environmentPage=homePage.clickonEnvironmentRunLink();
	   environmentPage.clickonEnvironmentokbutton();
	}
	
	@Then("User set business date")
	public void user_set_business_date() throws InterruptedException {
		environmentPage.businessDate();
	}

	@Then("Check envEventServer")
	public void check_env_event_server() throws InterruptedException {
		environmentPage.checkenvEventServer();
	}
	
	@Then("Check remoteResourceServer")
	public void check_remote_resource_server() throws InterruptedException {
		environmentPage.checkremoteResourceServer();
	}
	
	@Then("Check remoteLogConsoleServer")
	public void check_remote_log_console_server() throws InterruptedException {
		environmentPage.checkremoteLogConsoleServer();
	}
	
	@Then("Check schedulerTracker")
	public void check_scheduler_tracker() throws InterruptedException {
		environmentPage.checkschedulerTracker();
	}
	
	@Then("Check updaterServer")
	public void check_updater_server() throws InterruptedException {
		environmentPage.checkupdaterServer();
	}
	
	@Then("Check emailServer")
	public void check_email_server() throws InterruptedException {
		environmentPage.checkemailServer();
	}
	
	@Then("Check NPCI_Upload_Server")
	public void check_npci_upload_server() throws InterruptedException {
		environmentPage.checkNPCI_Upload_Server();
	}
	
	@Then("Check NPCI_Download_Server")
	public void check_npci_download_server() throws InterruptedException {
		environmentPage.checkNPCI_Download_Server();
	}
	
	@Then("Check File_Router_Server")
	public void check_file_router_server() throws InterruptedException {
		environmentPage.checkFile_Router_Server();
	}
	
	@Then("Check MMS_InFile_Server")
	public void check_mms_in_file_server() throws InterruptedException {
		environmentPage.checkMMS_InFile_Server();
	}
	
	@Then("Check MMS_InProcess_Server")
	public void check_mms_in_process_server() throws InterruptedException {
		environmentPage.checkMMS_InProcess_Server();
	}
	
	@Then("Check MMS_OutFileCreate_Server")
	public void check_mms_out_file_create_server() throws InterruptedException {
		environmentPage.checkMMS_OutFileCreate_Server();
	}
	
	@Then("Check DBTL_InFile_Server")
	public void check_dbtl_in_file_server() throws InterruptedException {
		environmentPage.checkDBTL_InFile_Server();
	}
	
	@Then("Check DBTL_InProcess_Server")
	public void check_dbtl_in_process_server() throws InterruptedException {
		environmentPage.checkDBTL_InProcess_Server();
	}
	
	@Then("Check DBTL_Verification_Server")
	public void check_dbtl_verification_server() throws InterruptedException {
		environmentPage.checkDBTL_Verification_Server();
	}
	
	@Then("Check DBTL_OutFileCreate_Server")
	public void check_dbtl_out_file_create_server() throws InterruptedException {
		environmentPage.checkDBTL_OutFileCreate_Server();
	}
	
	@Then("Check CBDT_InFile_Server")
	public void check_cbdt_in_file_server() throws InterruptedException {
		environmentPage.checkCBDT_InFile_Server();
	}
	
	@Then("Check CBDT_InProcess_Server")
	public void check_cbdt_in_process_server() throws InterruptedException {
		environmentPage.checkCBDT_InProcess_Server();
	}
	
	@Then("Check CBDT_AccountVerification_Server")
	public void check_cbdt_account_verification_server() throws InterruptedException {
		environmentPage.checkCBDT_AccountVerification_Server();
	}
	
	@Then("Check CBDT_OutFileCreate_Server")
	public void check_cbdt_out_file_create_server() throws InterruptedException {
		environmentPage.checkCBDT_OutFileCreate_Server();
	}
	
	@Then("Check NACH_InFile_Server")
	public void check_nach_in_file_server() throws InterruptedException {
		environmentPage.checkNACH_InFile_Server();
	}
	
	@Then("Check NACH_InProcess_Server")
	public void check_nach_in_process_server() throws InterruptedException {
		environmentPage.checkNACH_InProcess_Server();
	}
	
	@Then("Check NACH_OutProcess_Server")
	public void check_nach_out_process_server() throws InterruptedException {
		environmentPage.checkNACH_OutProcess_Server();
	}
	
	@Then("Check NACH_OutFileCreate_Server")
	public void check_nach_out_file_create_server() throws InterruptedException {
		environmentPage.checkNACH_OutFileCreate_Server();
	}
	
	@Then("Check Corporate_InFile_Server")
	public void check_corporate_in_file_server() throws InterruptedException {
		environmentPage.checkCorporate_InFile_Server();
	}
	
	@Then("Check Corporate_InProcess_Server")
	public void check_corporate_in_process_server() throws InterruptedException {
		environmentPage.checkCorporate_InProcess_Server();
	}
	
	@Then("Check LIC_INFile_Server")
	public void check_lic_in_file_server() throws InterruptedException {
		environmentPage.checkLIC_INFile_Server();
	}
	
	@Then("Check SCHM_Segrigate_Server")
	public void check_schm_segrigate_server() throws InterruptedException {
		environmentPage.checkSCHM_Segrigate_Server();
	}
	
	@Then("Check AutoMisServer")
	public void check_auto_mis_server() throws InterruptedException {
		environmentPage.checkAutoMisServer();
	}
	
	@Then("Check H2HMMSServer")
	public void check_h2hmms_server() throws InterruptedException {
		environmentPage.checkH2HMMSServer();
	}
	
	@Then("Check H2HFileServerRouter")
	public void check_h2h_file_server_router() throws InterruptedException {
		environmentPage.checkH2HFileServerRouter();
	}
	
	@Then("Check MandateRepresentServer")
	public void check_mandate_represent_server() throws InterruptedException {
		environmentPage.checkMandateRepresentServer();  
	}
	
	@Then("Check TransactionRepresentServer")
	public void check_transaction_represent_server() throws InterruptedException {
		environmentPage.checkTransactionRepresentServer();
	}
	
	@Then("Check GpsFileProgressServer")
	public void check_gps_file_progress_server() throws InterruptedException {
		environmentPage.checkGpsFileProgressServer();
	}
	
	@Then("Check GpsPaymentProgressServer")
	public void check_gps_payment_progress_server() throws InterruptedException {
		environmentPage.checkGpsPaymentProgressServer();
	}
	
	@Then("Check ChargePostingServer")
	public void check_charge_posting_server() throws InterruptedException {
		environmentPage.checkChargePostingServer();
	}
	
	@Then("Check CorporateFundingServer")
	public void check_corporate_funding_server() throws InterruptedException {
		environmentPage.checkCorporateFundingServer();
	}
	
	@Then("Check FileMarkCompleteServer")
	public void check_file_mark_complete_server() throws InterruptedException {
		environmentPage.checkFileMarkCompleteServer();
	}
	
	@Then("Check FilePostingMarkCompleteServer")
	public void check_file_posting_mark_complete_server() throws InterruptedException {
		environmentPage.checkFilePostingMarkCompleteServer();
	}
	
	@Then("Check Finacle_Posting_Server")
	public void check_finacle_posting_server() throws InterruptedException {
		environmentPage.checkFinacle_Posting_Server();
	}
	
	@Then("Check GpsReQueueingServer")
	public void check_gps_re_queueing_server() throws InterruptedException {
		environmentPage.checkGpsReQueueingServer();
	}
	
	@Then("Check IpaymentReQueueingServer")
	public void check_ipayment_re_queueing_server() throws InterruptedException {
		environmentPage.checkIpaymentReQueueingServer();
	}
	
	@Then("Check Inward_Debit_Posting_Server")
	public void check_inward_debit_posting_server() throws InterruptedException {
		environmentPage.checkInward_Debit_Posting_Server();
	}
	
	@Then("Check Inward_Credit_Posting_Server")
	public void check_inward_credit_posting_server() throws InterruptedException {
		environmentPage.checkInward_Credit_Posting_Server();
	}
	
	@Then("Check Inward_Debit_RePosting_Server")
	public void check_inward_debit_re_posting_server() throws InterruptedException {
		environmentPage.checkInward_Debit_RePosting_Server();
	}
	
	@Then("Check Inward_Credit_RePosting_Server")
	public void check_inward_credit_re_posting_server() throws InterruptedException {
		environmentPage.checkInward_Credit_RePosting_Server();
	}
	
	@Then("Check Inward_Debit_ReffralPost_Server")
	public void check_inward_debit_reffral_post_server() throws InterruptedException {
		environmentPage.checkInward_Debit_ReffralPost_Server();
	}
	
	@Then("Check Inward_Credit_ReffralPost_Server")
	public void check_inward_credit_reffral_post_server() throws InterruptedException {
		environmentPage.checkInward_Credit_ReffralPost_Server();
	}
	
	@Then("Check Mandate_SMS_Alerts_Server")
	public void check_mandate_sms_alerts_server() throws InterruptedException {
		environmentPage.checkMandate_SMS_Alerts_Server();
	}
	
	@Then("Check Mandate_EMAIL_Alerts_Server")
	public void check_mandate_email_alerts_server() throws InterruptedException {
		environmentPage.checkMandate_EMAIL_Alerts_Server();
	}
	
	@Then("Check Payment_SMS_Alerts_Server")
	public void check_payment_sms_alerts_server() throws InterruptedException {
		environmentPage.checkPayment_SMS_Alerts_Server();
	}
	
	@Then("Check Payment_EMAIL_Alerts_Server")
	public void check_payment_email_alerts_server() throws InterruptedException {
		environmentPage.checkPayment_EMAIL_Alerts_Server();
	}
	
	@Then("Check PaymentPosting_Alert_Server")
	public void check_payment_posting_alert_server() throws InterruptedException {
		environmentPage.checkPaymentPosting_Alert_Server();
	}
	
	@Then("Check ESIGNMMSInFileServer")
	public void check_esignmms_in_file_server() throws InterruptedException {
		environmentPage.checkESIGNMMSInFileServer();
	}
	
	@Then("Check ESIGNMMSVerificationServer")
	public void check_esignmms_verification_server() throws InterruptedException {
		environmentPage.checkESIGNMMSVerificationServer();
	}
	
	@Then("Check APIMandateValidateServer")
	public void check_api_mandate_validate_server() throws InterruptedException {
		environmentPage.checkAPIMandateValidateServer();
	}
	
	@Then("Check JARVISFileProcessServer")
	public void check_jarvis_file_process_server() throws InterruptedException {
		environmentPage.checkJARVISFileProcessServer();
	}
	
	@Then("Check JARVISFileCreatorServer")
	public void check_jarvis_file_creator_server() throws InterruptedException {
		environmentPage.checkJARVISFileCreatorServer();
	}
	
	@Then("Check NACH_FileEncryption_Server")
	public void check_nach_file_encryption_server() throws InterruptedException {
		environmentPage.checkNACH_FileEncryption_Server();
	}
	
	@Then("Check NACH_FileDecryption_Server")
	public void check_nach_file_decryption_server() throws InterruptedException {
		environmentPage.checkNACH_FileDecryption_Server();
		environmentPage.LogOut();
	}
	
}
