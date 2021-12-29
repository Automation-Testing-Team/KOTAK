#Author: 

@Version1.0
@Regression_Pack_Customer_Menu

Feature: To test Functionality of Corporate CMS for Customer Menus

@TC06_01_Customer_Add
Scenario Outline: Testing of Add functionality With Valid Data for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Add 
And User provides record details for Add operation using "<SheetName>" and clicks on Ok button and Add Confirm button

Examples: 
|SheetName               |
| Customer_Add_ValidData | 

@TC06_02_Customer_Approve_List
Scenario Outline: Testing of Approve,List functionality for Customer Menu
Then User goes to Customer Approve menu using "<SheetName>" and approves the record and views it using List Menu
#done
Examples: 
|SheetName             |
|Customer_ApproveList  |

@TC06_03_Customer_Add_InvalidData
Scenario Outline: Testing of Add functionality With Invalid Data for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Add 
And User provides invalid record details for Add operation using "<SheetName>" and validates

Examples: 
|SheetName                  |
| Customer_Add_InValidData  |

@TC06_04_Customer_Modify
Scenario Outline: Testing of Modify functionality With Valid Data for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Modify 
And User provides record details for Modify operation using "<SheetName>" and clicks on Ok button and Modify Confirm button

Examples: 
|SheetName         |
| Customer_Modify  | 

@TC06_05_Customer_Approve_List
Scenario Outline: Testing of Approve,List functionality for Customer Menu
Then User goes to Customer Approve menu using "<SheetName>" and approves the record and views it using List Menu
#done
Examples: 
|SheetName             |
|Customer_ApproveList  |

@TC06_06_Customer_Delete
Scenario Outline: Testing of Delete functionality With Valid Data for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Delete
And User provides record details for delete operation using "<SheetName>" and clicks on Ok button and Delete button
Then User navigates to Customer Confirm Delete Menu confirms the deletion of record using "<SheetName>" and views the record using List Menu
#done
Examples: 
|SheetName         |
| Customer_Delete  |  

@TC06_07_Customer_CancelModifyActionAddedRecord
Scenario Outline: Testing of Cancel Modify Action functionality(Added Record) for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Add 
And User provides record details for Add operation using "<SheetName>" and clicks on Ok button and Add Confirm button
Then User goes to Customer Approve menu using "<SheetName>" and Clicks on Cancel Modify Action button and views it using List Menu

Examples: 
|SheetName                         |
| Customer_CancelModAction_ForAdd  | 

@TC06_08_Customer_CancelModifyActionModifiedRecord
Scenario Outline: Testing of Cancel Modify Action functionality(Modified Record) for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Modify 
And User provides record details for Modify operation using "<SheetName>" and clicks on Ok button and Modify Confirm button
Then User goes to Customer Approve menu using "<SheetName>" and Clicks on Cancel Modify Action button and views it using List Menu

Examples: 
|SheetName                        |
| Customer_CancelModAction_ForMod | 

@TC06_09_Customer_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action functionality for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option Delete
And User provides record details for delete operation using "<SheetName>" and clicks on Ok button and Delete button
Then User navigates to Customer Confirm Delete Menu and cancels the deletion of record using "<SheetName>" and views the record using List Menu
#done
Examples: 
|SheetName                     |
| Customer_CancelDeleteAction  |  

@TC06_10_Customer_Scheme/FormatCode_Mapping
Scenario Outline: Testing of Scheme/FormatCode Mapping functionality for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option SchemeFormatCodeMapping
And User provides details for Scheme or Format Code Mapping operation using "<SheetName>"

Examples: 
|SheetName                     |
| Cust_SchemeFormatCodeMap     |
 
@TC06_11_Customer_Scheme/FormatCode_UnMapping
Scenario Outline: Testing of Scheme/FormatCode Unmapping functionality for Customer Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Customer and clicks on sub option SchemeFormatCodeMapping
And User provides details for Scheme or Format Code Unmapping operation using "<SheetName>"

Examples: 
|SheetName                      |
| Cust_SchemeFormatCodeUnmap    |









