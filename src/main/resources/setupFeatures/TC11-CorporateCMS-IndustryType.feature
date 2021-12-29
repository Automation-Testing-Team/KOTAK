#Author: Pranjal Mudhalwadkar

@Version1.0
@Regression_Pack_IndustryType_Menu
Feature: To test Functionality of Corporate CMS for Industry Type Menus

@TC11_01_Industry_Type_Add
Scenario Outline: Testing of Add menu With Valid Data for Industry Type 
Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Industry Type and clicks on Add menu
And User adds record using "<SheetName>" and clicks on Ok button and Add Confirm button
Then User goes to Industry Type Approve menu using "<SheetName>" and approves the record and views it using List Menu

Examples: 
|SheetName          |
| IndustryType_Add  | 

@TC11_02_Industry_Type_Validation
 Scenario Outline: Validation of Industry Type Menu
 Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Industry Type and clicks on Add menu
 And User provides invalid record details using "<SheetName>" and clicks on Ok button and validate the fields
 
 Examples: 
|SheetName                  |
| IndustryType_Validations  | 

 
 @TC11_03_Industry_Type_Modify
 Scenario Outline: Modification of Industry Type
 Given User goes to Application and Maintenance clicks on Corporate CMS menu then Industry Type and clicks on Modify menu
 And User modifies the record by changing fields using "<SheetName>"
 Then User goes to Industry Type Approve menu using "<SheetName>" and approves the record and views it using List Menu

 Examples: 
|SheetName             |
| IndustryType_Modify  | 

@TC11_04_Industry_Type_Modify_InvalidData
 Scenario Outline: Modification of Industry Type With Invalid Data
 Given User goes to Application and Maintenance clicks on Corporate CMS menu then Industry Type and clicks on Modify menu
 And User provides invalid record details for modify operation using "<SheetName>"
 
 Examples: 
|SheetName                         |
| IndustryType_Modify_InvalidData  | 

 @TC11_05_Industry_Type_Delete
 Scenario Outline: Testing of Delete functionality for Industry Type Menu
 Given user goes to Application and Maintenance clicks Corporate CMS menu then Industry Type and clicks on Delete menu
 And User performs delete operation on the record from the list using "<SheetName>"
 Then User goes to Industry Type Confirm Delete Menu confirms the deletion of record using "<SheetName>" and views the record using List Menu

Examples:
|SheetName           |
|IndustryType_Delete |  

@TC11_06_Industry_Type_CancelModifyActionForAddedRecord
Scenario Outline: Testing of Cancel Modify Action(Added Record) Functionality For Industry Type Menu
Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Industry Type and clicks on Add menu
And User adds record using "<SheetName>" and clicks on Ok button and Add Confirm button
Then User goes to Industry Type Approve menu using "<SheetName>" and clicks on Cancel Modify Action button and views the record

Examples:
 |SheetName                  |
 |IT_CancelModAction_ForAdd  |

@TC11_07_Industry_Type_CancelModifyActionForModifiedRecord
Scenario Outline: Testing of Cancel Modify Action(Modified Record) Functionality For Industry Type Menu
Given User goes to Application and Maintenance clicks on Corporate CMS menu then Industry Type and clicks on Modify menu
And User modifies the record by changing fields using "<SheetName>"
Then User goes to Industry Type Approve menu using "<SheetName>" and clicks on Cancel Modify Action button and views the record

Examples:
 |SheetName                     |
 |IT_CancelModAction_ModifyRec  |

@TC11_08_Industry_Type_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action Functionality For Industry Type Menu
Given user goes to Application and Maintenance clicks Corporate CMS menu then Industry Type and clicks on Delete menu
And User performs delete operation on the record from the list using "<SheetName>"
Then User goes Industry Type to Confirm Delete Menu using "<SheetName>" and clicks on Cancel Delete Action button and views the record using List Menu

Examples:
 |SheetName             |
 |IT_CancelDeleteAction |

