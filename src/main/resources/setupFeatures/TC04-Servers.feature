#Author: Suvarna Prabhumatkari
@Version1.0 
@Regression_Pack_Environment_Menu
Feature: To test the functionality of Servers in Environment Menu

@TC_04_01_BusinessDate_SOD
  Scenario: To Set Business Date
   Given User goes to Environment and Open Run menu
   Then User set business date

@TC_04_02_Servers
  Scenario: To Enable all available servers
    Then User goes to Environment and Open Run menu
    Then Check envEventServer
    Then Check remoteResourceServer
    Then Check remoteLogConsoleServer	
    Then Check schedulerTracker
    Then Check updaterServer
    Then Check emailServer
    
    #"SFTP Servers"
    Then Check NPCI_Upload_Server
    Then Check NPCI_Download_Server
    Then Check File_Router_Server
    
    #"Mandate Servers"
    Then Check MMS_InFile_Server
    Then Check MMS_InProcess_Server
    Then Check MMS_OutFileCreate_Server
    
    #"DBTL Servers"
    Then Check DBTL_InFile_Server
    Then Check DBTL_InProcess_Server
    Then Check DBTL_Verification_Server
    Then Check DBTL_OutFileCreate_Server
    
    #"CBDT Servers"
    Then Check CBDT_InFile_Server
    Then Check CBDT_InProcess_Server
    Then Check CBDT_AccountVerification_Server
    Then Check CBDT_OutFileCreate_Server
    
    #"ACH Servers"
    Then Check NACH_InFile_Server
    Then Check NACH_InProcess_Server
    Then Check NACH_OutProcess_Server
    Then Check NACH_OutFileCreate_Server
    
    #Corporate Servers
    Then Check Corporate_InFile_Server	
    Then Check Corporate_InProcess_Server
    Then Check LIC_INFile_Server
    Then Check SCHM_Segrigate_Server
    
    #ReportServer Servers
    Then Check AutoMisServer	
    Then Check H2HMMSServer
    Then Check H2HFileServerRouter
    Then Check MandateRepresentServer
    Then Check TransactionRepresentServer
    
    #ROUTER Servers
    Then Check GpsFileProgressServer
    Then Check GpsPaymentProgressServer
    Then Check ChargePostingServer
    Then Check CorporateFundingServer
    Then Check FileMarkCompleteServer
    Then Check FilePostingMarkCompleteServer
    
    #Posting Servers
    Then Check Finacle_Posting_Server
    Then Check GpsReQueueingServer
    Then Check IpaymentReQueueingServer
    Then Check Inward_Debit_Posting_Server
    Then Check Inward_Credit_Posting_Server
    Then Check Inward_Debit_RePosting_Server
    Then Check Inward_Credit_RePosting_Server
    Then Check Inward_Debit_ReffralPost_Server
    Then Check Inward_Credit_ReffralPost_Server
    
    #Alert Servers
    Then Check Mandate_SMS_Alerts_Server
    Then Check Mandate_EMAIL_Alerts_Server
    Then Check Payment_SMS_Alerts_Server
    Then Check Payment_EMAIL_Alerts_Server
    Then Check PaymentPosting_Alert_Server
    
    #ESIGN Servers
    Then Check ESIGNMMSInFileServer
    Then Check ESIGNMMSVerificationServer
    
    #MMS API Servers
    Then Check APIMandateValidateServer
    
    #JARVIS Servers
    Then Check JARVISFileProcessServer
    Then Check JARVISFileCreatorServer
    
    #PGP Servers
    Then Check NACH_FileEncryption_Server
    Then Check NACH_FileDecryption_Server
    
    
    
    
    
    
    