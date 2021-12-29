#Author: Pranjal Mudhalwadkar

@Version1.0
@Regression_Pack_Miscellaneous_Menu
Feature: To test Functionality of Corporate CMS for Miscellaneous Menus

@TC09_01_Miscellaneous_Add_ValidData
Scenario Outline: Testing of Add functionality With Valid Data for Miscellaneous Menu
Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Add menu
And User adds Template Code and selects priority fields from sheetname "<SheetName>" and clicks on Ok button and confirm 

Examples:
|SheetName                  |
|Miscellaneous_AddValidData |


@TC09_02_Miscellaneous_Approve_List
Scenario Outline: Testing of Approve,List functionality for Miscellaneous Menu
Given User goes to Miscellaneous Approve screen and approve the record using SheetName "<SheetName>" and views the record using List

Examples:
|SheetName                 |
|Miscellaneous_ApproveList |


@TC09_03_Miscellaneous_Add_InValidData
Scenario Outline: Testing of Add functionality With Invalid Data for Miscellaneous Menu
Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Add menu
And User provides invalid data using Sheet "<SheetName>" to check Invalid Data Scenario

Examples:
|SheetName                    |
|Miscellaneous_AddInValidData |


@TC09_04_Miscellaneous_Modify_ValidData
Scenario Outline: Testing Modify functionality With Valid Data for Miscellaneous Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Modify menu
And User provides Party Name value from sheetname "<SheetName>" and clicks on Ok button and Modify Confirm button

Examples:
|SheetName                    |
|Miscellaneous_ModifyValidData|

@TC09_05_Miscellaneous_Approve_List
Scenario Outline: Testing of Approve,List functionality for Miscellaneous Menu
Given User goes to Miscellaneous Approve screen and approve the record using SheetName "<SheetName>" and views the record using List

Examples:
|SheetName                 |
|Miscellaneous_ApproveList |

@TC09_06_Miscellaneous_Modify_InvalidData
Scenario Outline: Testing Modify functionality With Invalid Data for Miscellaneous Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Modify menu
And User provides invalid record details using SheetName "<SheetName>" to check Invalid Data scenario

Examples:
|SheetName                      |
|Miscellaneous_ModifyInValidData|


@TC09_07_Miscellaneous_Delete
Scenario Outline: Testing Delete functionality for Miscellaneous Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Delete menu
And User provides Party Name value from sheetname "<SheetName>" and clicks on Ok button and Delete button
Then User navigates to Miscellaneous Confirm Delete Screen 
Then User provides Party Name value from sheetname "<SheetName>" and clicks on Ok button and Delete Confirm button

Examples:
|SheetName           |
|Miscellaneous_Delete|

@TC09_08_Miscellaneous_CancelModifyActionForAddedRecord
Scenario Outline: Testing Cancel Modify Action functionality(Added Record) for Miscellaneous->Approve Menu
Given User goes to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Add menu
And User adds Template Code and selects priority fields from sheetname "<SheetName>" and clicks on Ok button and confirm 
Then User navigates to Approve screen to perform Cancel Modify Action using SheetName "<SheetName>"

Examples:
|SheetName                 |
|Misc_CancelModActionAddRec|


@TC09_09_Miscellaneous_CancelModifyActionforModifiedRecord
Scenario Outline: Testing Cancel Modify Action functionality(Modified Record) for Miscellaneous->Approve Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Modify menu
And User provides Party Name value from sheetname "<SheetName>" and clicks on Ok button and Modify Confirm button
Then User navigates to Approve screen to perform Cancel Modify Action using SheetName "<SheetName>"

Examples:
|SheetName                     |
|Misc_CancelModActionModifyRec |


@TC09_10_Miscellaneous_CancelDeleteAction
Scenario Outline: Testing Cancel Delete Action functionality for Miscellaneous Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then Miscellaneous and clicks on Delete menu
And User provides Party Name value from sheetname "<SheetName>" and clicks on Ok button and Delete button
Then User navigates to Miscellaneous Confirm Delete Screen 
Then User provides Party Name value from sheetname "<SheetName>" and clicks on Cancel Delete Action button to cancel the deletion

Examples:
|SheetName                      |
|MiscellaneousCancelDeleteAction|



