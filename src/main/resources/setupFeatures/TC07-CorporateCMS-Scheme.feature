#Author: 

@Version1.0
@Regression_Pack_Scheme_Menu

Feature: To test Functionality of Corporate CMS for Scheme Menus

@TC07_01_Scheme_Add_ValidData
Scenario Outline: Testing of Add functionality With Valid Data for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Add
And User provides the valid record details using Sheet "<SheetName>" to add the record

Examples:
|SheetName            |
|Scheme_Add_ValidData |

@TC07_02_Scheme_Approve_List
Scenario Outline: Testing of Approve,List functionality for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves the record and views it record using List menu
 
Examples:
|SheetName          |
|Scheme_Approve_List|

@TC07_03_Scheme_Add_InvalidData
Scenario Outline: Testing of Add functionality for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Add
And User provides invalid record details using Sheet "<SheetName>" to check Invalid Data Scenario

Examples:
|SheetName              |
|Scheme_Add_InValidData |

@TC07_04_Scheme_Modify_ValidData
Scenario Outline: Testing of Modify functionality With Valid Data for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Modify
And User provides the valid record details using Sheet "<SheetName>" to Modify the record

Examples:
|SheetName               |
|Scheme_Modify_ValidData |

@TC07_05_Scheme_Approve_List
Scenario Outline: Testing of Approve,List functionality for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves the record and views it record using List menu
 
Examples:
|SheetName          |
|Scheme_Approve_List|

@TC07_06_Scheme_Modify_InvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Modify
And User provides the invalid record details using Sheet "<SheetName>"

Examples:
|SheetName                 |
|Scheme_Modify_InValidData |


@TC07_07_Scheme_Delete
Scenario Outline: Testing of Delete functionality for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Delete
Then User provides the record details in Delete filter screen using Sheet "<SheetName>" for deletion of record

Examples:
|SheetName     |
|Scheme_Delete |


@TC07_08_Scheme_ConfirmDelete_List
Scenario Outline: Testing of Confirm Delete,List functionality for Scheme Menu
Given User navigates to Scheme Confirm Delete Screen    
Then User provides the record details in confirm Delete filter screen using Sheet "<SheetName>" for confirming the record deletion

Examples:
|SheetName     |
|Scheme_Delete |

@TC07_09_Scheme_CancelModifyActionForAddedRecord
Scenario Outline: Testing of Cancel Modify Action functionality For Added Record for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Add
And User provides the valid record details using Sheet "<SheetName>" to add the record
Then User navigates to Scheme Approve Screen using Sheet "<SheetName>" to perform Cancel Modify Action and check record visibility 

Examples:
|SheetName                          |
|Scheme_CancelModifyActionAddRec    |

@TC07_10_Scheme_CancelModifyActionForModifiedRecord
Scenario Outline: Testing of Cancel Modify Action functionality For Modified Record for Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Modify
And User provides the valid record details using Sheet "<SheetName>" to Modify the record
Then User navigates to Scheme Approve Screen using Sheet "<SheetName>" to perform Cancel Modify Action and check record visibility 

Examples:
|SheetName                          |
|Scheme_CancelModifyActionModRec    |

@TC07_11_Scheme_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action functionality For Scheme Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Scheme and clicks on sub option Delete
And User provides the record details in Delete filter screen using Sheet "<SheetName>" for deletion of record
Then User navigates to Scheme Confirm Delete Screen provides the record details using "<SheetName>" for Cancel Delete Action and check record visibility

Examples:
|SheetName                  |
|SchemeCancelDeleteAction   |






