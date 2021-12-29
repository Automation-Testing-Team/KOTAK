#Author: Pranjal Mudhalwadkar

@Version1.0
@Regression_Pack_BusinessGroup_Menu
Feature: To test Functionality of Corporate CMS for Business Group Menus

@TC11_01_Business_Group_Add
Scenario Outline: Testing of Add functionality With Valid Data for Business Group Menu
Given User goes to Application and Maintenance clicks on Business group and clicks on Add menu
And User add Business Group record using "<SheetName>" and clicks on Ok button and Add confirm button
Then User goes to Business Group Approve menu approves the record using "<SheetName>" and views the record using List Menu

Examples:
 |SheetName     | 
 |BG_AddApprove |

@TC11_02_Business_Group_Validation
 Scenario Outline: Validation of Business Group Menu
 Given User goes to Application and Maintenance clicks on Business group and clicks on Add menu
 And User add invalid data using "<SheetName>" and clicks on Ok button and validate
 
 Examples:
 |SheetName                   |  
 |BG_ValidationforInvalidData |
 
@TC11_03_Business_Group_Modify_ValidData
Scenario Outline: Testing of Modify functionality with Valid Data for Business Group Menu
Given User goes to Application and Maintenance clicks on Business group and clicks on Modify menu
And User modifies the record using "<SheetName>" and clicks on Ok button and Modify Confirm button
Then User goes to Business Group Approve menu approves the record using "<SheetName>" and views the record using List Menu
 
 Examples:
 |SheetName    |
 |BG_Modify    |
 
@TC11_04_Business_Group_Modify_InvalidData
Scenario Outline: Testing of Modify functionality with Invalid Data for Business Group Menu
Given User goes to Application and Maintenance clicks on Business group and clicks on Modify menu
And User provides invalid data for modify operation using "<SheetName>" and clicks on Ok button and validate
 
 Examples:
 |SheetName             | 
 |BG_Modify_InvalidData |

@TC11_05_Business_Group_Delete
 Scenario Outline: Testing of Delete functionality for Business Group Menu
 Given user goes to Application and Maintenance clicks on Business group and clicks on Delete menu
 And User deletes the record from the list using "<SheetName>"
 Then User goes to Confirm Delete Menu confirms the deletion of record using "<SheetName>" and views the record using List Menu

Examples:
|SheetName|
|BG_Delete|  

@TC11_06_Business_Group_CancelModifyActionForAddedRecord
Scenario Outline: Testing of Cancel Modify Action Functionality For Business Group Menu
Given User goes to Application and Maintenance clicks on Business group and clicks on Add menu
And User add Business Group record using "<SheetName>" and clicks on Ok button and Add confirm button
Then User goes to Business Group Approve menu using "<SheetName>" and clicks on Cancel Modify Action button and views the record

Examples:
 |SheetName                     |
 |BG_CancelModAction_ForAddRec  |

@TC11_07_Business_Group_CancelModifyActionForModifiedRecord
Scenario Outline: Testing of Cancel Modify Action Functionality For Business Group Menu
Given User goes to Application and Maintenance clicks on Business group and clicks on Modify menu
And User modifies the record using "<SheetName>" and clicks on Ok button and Modify Confirm button
Then User goes to Business Group Approve menu using "<SheetName>" and clicks on Cancel Modify Action button and views the record

Examples:
 |SheetName                     |
 |BG_CancelModAction_ModifyRec  |

@TC11_08_Business_Group_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action Functionality For Business Group Menu
Given user goes to Application and Maintenance clicks on Business group and clicks on Delete menu
And User deletes the record from the list using "<SheetName>"
Then User goes to Confirm Delete Menu using "<SheetName>" and clicks on Cancel Delete Action button and views the record using List Menu

Examples:
 |SheetName             |
 |BG_CancelDeleteAction |
 
 
 
 