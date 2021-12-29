#Author: Suvarna Prabhumatkari
@Version1.0
@Regression_Pack_IFSCCODE_Menu
Feature: To Test IFSCCODE Functionality

  @TC_12_01_AddIFSCCODEwithInvaliddata
  Scenario Outline: To add IFSC Code with Invalid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Add menu
    Then user enters invalid data using "<SheetName>" and <Row>

    Examples: 
      | SheetName |
      | IFSC_Add  |

	@TC_12_02_AddIFSCCODEwithBlankdata
  Scenario Outline: To add IFSC Code with Blank data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Add menu
    Then user keep data blank using "<SheetName>" and <Row>

    Examples: 
      | SheetName | Row |
      | IFSC_Add  |   0 |
      #| IFSC_Add  |   1 |
#			| IFSC_Add  | 	2 |
#			| IFSC_Add  | 	3 |

	@TC_12_03_AddIFSCCODEwithValiddata
  Scenario Outline: To add IFSC Code with Valid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Add menu
    Then user enters valid data using "<SheetName>" and <Row>

    Examples: 
      | SheetName | Row |
      | IFSC_Add  |   0 |
      
  @TC_12_04_DeleteIFSCCODEwithInvaliddata
  Scenario Outline: To delete IFSC Code	with Invalid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Delete menu
    Then user try to filter IFSC Code using invalid data using "<SheetName>" and <Row>

    Examples: 
      | SheetName   | Row |
      | IFSC_Delete |   0 |
      
      @TC_12_05_DeleteIFSCCODEwithValiddata 
  Scenario Outline: To delete IFSC Code	with Valid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Delete menu
    Then user try to filter IFSC Code using valid data using "<SheetName>" and <Row>
#functionality is not working 
    Examples: 
      | SheetName   | Row |
      | IFSC_Delete |   1 |
      
      @TC_12_06_ListIFSCCODEwithValiddata
  Scenario Outline: To List IFSC Code with Valid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE List menu
    Then user view IFSC Code using valid data using "<SheetName>"

    Examples: 
      | SheetName   |
      | IFSC_List   |
      
      

  