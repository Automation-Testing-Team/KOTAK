#Author: 

@Version1.0
@Regression_Pack_RelationshipManager_Menu
Feature: To test Functionality of Corporate CMS for Relationship Manager Menus

@TC08_01_RelationshipManager_Add_ValidData
Scenario Outline: Testing of Add functionality With Valid Data for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Add
And User provides the record details using Sheet "<SheetName>"

Examples:
|SheetName       |
|RMAdd_ValidData |

@TC08_02_RelationshipManager_Approve_List
Scenario Outline: Testing of Approve,List functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves it and views the record
 
Examples:
|SheetName      |
|RM_Approve_List|

@TC08_03_RelationshipManager_Add_InvalidData
Scenario Outline: Testing of Add functionality With Invalid Data for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Add
And User provides the invalid record details using "<SheetName>"

Examples:
|SheetName         |
|RMAdd_InValidData |

@TC08_04_RelationshipManager_Modify
Scenario Outline: Testing of Modify functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Modify
And User provides the record details for modification using "<SheetName>"

Examples:
|SheetName          |
|RMModify_ValidData |

@TC08_05_RelationshipManager_Approve_List
Scenario Outline: Testing of Approve,List functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Approve
Then User provides the records details using "<SheetName>" and approves it and views the record

Examples:
|SheetName      |
|RM_Approve_List|

@TC08_06_RelationshipManager_Modify_InvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Modify
And User provides the invalid record details for modification using "<SheetName>"

Examples:
|SheetName            |
|RMModify_InValidData |


@TC08_07_RelationshipManager_Delete
Scenario Outline: Testing of Delete functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Delete
Then User provides the record details in Delete filter screen using Sheet "<SheetName>" for record deletion

Examples:
|SheetName |
|RM_Delete |

@TC08_08_RelationshipManager_ConfirmDelete_List
Scenario Outline: Testing of Confirm Delete,List functionality for Relationship Manager Menu
Given User navigates to Relationship Manager Confirm Delete Screen    
And User provides the record details in confirm Delete filter screen using Sheet "<SheetName>" for confirming record deletion

Examples:
|SheetName |
|RM_Delete |

@TC08_09_RelationshipManager_CancelModifyActionForAddedRecord
Scenario Outline: Testing of Cancel Modify Action functionality for Added Record Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Add
And User provides the record details using Sheet "<SheetName>"
Then User navigates to Relationship Manager Approve screen to perform Cancel Modify Action using "<SheetName>"

Examples:
|SheetName                       |
|RM_CancelModAction_AddedRecord  |

@TC08_10_RelationshipManager_CancelModifyActionForModifiedRecord
Scenario Outline: Testing of Modify functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Modify
And User provides the record details for modification using "<SheetName>"
Then User navigates to Relationship Manager Approve screen to perform Cancel Modify Action using "<SheetName>"

Examples:
|SheetName                        |
|RM_CancelModAction_ModifyRecord  |

@TC08_11_RelationshipManager_CancelDeleteAction
Scenario Outline: Testing of Cancel Delete Action functionality for Relationship Manager Menu
Given User navigates to Application and Maintenance clicks on Corporate CMS menu selects Relationship Manager and clicks on sub option Delete
And User provides the record details in Delete filter screen using Sheet "<SheetName>" for record deletion
Then User navigates to Relationship Manager Confirm Delete Screen to perform Cancel Delete Action 
And User navigates to Relationship Manager List screen after performing Cancel Delete Action to view the record using "<SheetName>"

Examples:
|SheetName              |
|RM_CancelDeleteAction  |




 




