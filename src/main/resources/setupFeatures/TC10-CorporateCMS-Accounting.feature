#Author: 

@Version1.0
@Regression_Pack_Accounting_Menu
Feature: To test Functionality of Corporate CMS for Accounting Menus

@TC10_01_Accounting_Add_ValidData
Scenario Outline: Testing of Add functionality With Valid Data for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Add
And User provides the valid record details using Sheet "<SheetName>" and clicks on Ok button and Add Confirm button

Examples:
|SheetName               |
|Accounting_AddValidData |

@TC10_02_Accounting_Approve_List
Scenario Outline: Testing of Approve,List functionality for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves it and views the record using Accounting List
 
Examples:
|SheetName                    |
|Accounting_ApproveAddRec_List|

@TC10_03_Accounting_Add_InvalidData
Scenario Outline: Testing of Add functionality With Invalid Data for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Add
And User provides the invalid record details for Add operation using "<SheetName>" and clicks on ok button and validates

Examples:
|SheetName                 |
|Accounting_AddInValidData |

@TC10_04_Accounting_Modify_ValidData
Scenario Outline: Testing of Modify functionality With Valid Data for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Modify
And User provides the valid record details for modification using "<SheetName>"

Examples:
|SheetName                  |
|Accounting_ModifyValidData |

@TC10_05_Accounting_Approve_List
Scenario Outline: Testing of Approve,List functionality for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves it and views the record using Accounting List
 
Examples:
|SheetName                      |
|Accounting_ApproveModifRec_List|


@TC10_06_Accounting_Modify_InvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Modify
And User provides the invalid record details for modify operation using "<SheetName>"

Examples:
|SheetName                    |
|Accounting_ModifyInValidData |

@TC10_07_Accounting_Delete
Scenario Outline: Testing of Delete functionality for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Delete
Then User provides the record details for Delete operation using Sheet "<SheetName>"

Examples:
|SheetName                       |
|Accounting_Delete_ConfirmDelete |

@TC10_08_Accounting_ConfirmDelete_List
Scenario Outline: Testing of Confirm Delete,List functionality for Accounting Menu
Given User navigates to Accounting Confirm Delete Screen    
And User provides the record details using Sheet "<SheetName>" and confirms the deletion of record and views it using Accounting List

Examples:
|SheetName                       |
|Accounting_Delete_ConfirmDelete |

@TC10_09_Accounting_CancelModifyActionForAddedRecord
Scenario Outline: Testing of Cancel Modify Action functionality for Added Record For Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Add
And User provides the valid record details using Sheet "<SheetName>" and clicks on Ok button and Add Confirm button
Then User navigates to Accounting Approve screen to perform Cancel Modify Action using "<SheetName>"

Examples:
|SheetName                       |
|Accounting_CancelModAction_Add  |


@TC10_10_Accounting_CancelModifyActionForModifiedRecord
Scenario Outline: Testing of Cancel Modify Action functionality for Modified Record For Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Modify
And User provides the valid record details for modification using "<SheetName>"
Then User navigates to Accounting Approve screen to perform Cancel Modify Action using "<SheetName>"

Examples:
|SheetName                       |
|Accounting_CancelModAction_Mod  |

@TC10_11_Accounting_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action functionality for Accounting Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Accounting and clicks on sub option Delete
And User provides the record details for Delete operation using Sheet "<SheetName>"
Then User cancels the deletion of record using "<SheetName>" and views it using Accounting List 

Examples:
|SheetName                      |
|Accounting_CancelDeleteAction  |



 




