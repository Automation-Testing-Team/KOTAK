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
    Then Check ReportEventProducerServer
    Then Check ReportGeneratorServer
    
    #"SFTP Servers"
    Then Check SFTPDownloadServer	
    Then Check SFTPUploadServer
    
    #"File Processor Servers"
    Then Check FileReadServer
    Then Check FileValidateServer
    Then Check PfmsBatchQueueServer
    Then Check MainFilePayCreationServer
    Then Check FutureRolloverServer
    Then Check FileExpiryServer
    
    #"Enrollment Servers"
    Then Check FileEnrolmentMatcherServer
    Then Check DscEnrollementServer
    
    #"Producer Servers"
    Then Check GpsReQueueingServer
    Then Check InitAckProducerServer
    
    #"ACH Servers"
    Then Check NACH_InFile_Server
    Then Check NACH_InProcess_Server
    Then Check NACH_OutProcess_Server
    Then Check NACH_OutFileCreate_Server
    
    #MISC Servers
    Then Check FileStatusUpdateServer	
    Then Check DISCExpiryAlertServer
    
    #ACK NACK Servers
    Then Check ReceiptAckServer	
    Then Check InitAckConsumerServer
    Then Check SuccAckServer
    Then Check RejectAckServer
    
    #Posting Servers
    Then Check MainPostingServer
    Then Check DupRevPostingServer
    Then Check PoolToSettBatchPostingServer
    Then Check PoolToAgencyBatchPostingServer
    Then Check SettToPoolBatchPostingServer
    
    #ONUS Servers
    Then Check OnUsPaymentProcessServer
    Then Check OnusPostingServer
    
    #NEFT Servers
    Then Check NeftPaymentProcessServer
    
    #ACH Servers
    Then Check AchPaymentProcessServer
    Then Check AchOutputServer
    Then Check AchResponseReaderServer
    Then Check AchResponseProcessServer
    
    #APBS Servers
    Then Check ApbsPaymentProcessServer
    Then Check ApbsOutputServer
    Then Check ApbsResponseReaderServer
    Then Check ApbsResponseProcessServer
    Then Check AadhaarVaultGetReferenceServer
    Then Check AadhaarVaultForHistoryPaymentsServer
    
    #AV Servers
    Then Check CpsmsAVFileRequestServer
    Then Check CpsmsAVProcessingServer
    Then Check AVResponseGenerationServer
    Then Check AVAckReadServer
    
    #SFMS Servers
    Then Check NeftOutputServer
    
    #REPORT Servers
    Then Check ReportEventProducerServer
    Then Check ReportGeneratorServer
    
    
    
    
    
    