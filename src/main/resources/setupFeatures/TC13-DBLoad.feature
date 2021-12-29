#Author: Suvarna Prabhumatkari
@Version1.0
@Regression_Pack_DBLoads_Menu
Feature: To test DBloads functionality

  @TC_03_01_IFSCCodeDBLoadfunctionality
  Scenario Outline: To upload IFSC Codes through DBLoad
    Then User goes to Maintenance DB and open Static data menu and then DB Loads menu to upload IFSC Codes
    Then User uploads IFSC list using "<SheetName>" and view added IFSC Code
#We have to select NPCI-ACH to upload IFSC Codes(after resolve we need to change msg in code)
     Examples: 
      | SheetName               |
      | DBLoad_Upload_IFSCCodes |

      #@TC_03_02_DBLoadfunctionalityForNPCI-ACH
  #Scenario Outline: To upload NPCI-ACH through DBLoad
    #Then User goes to Maintenance DB and open Static data menu and then DB Loads menu to upload IFSC Codes
    #Then User uploads IFSC list using "<Loadtype>","<ForceUpdate>" and "<FileName>"
    #Then User views NPCI Code list
    #
    #Examples: 
    #
    #| Loadtype | ForceUpdate| FileName                                                     |
    #|NPCI-ACH  | Y          |																										           |
      