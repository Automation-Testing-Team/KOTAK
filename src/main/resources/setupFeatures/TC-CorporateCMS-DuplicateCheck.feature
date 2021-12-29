#Author: Suvarna Prabhumatkari

@Version1.0 
@Regression_Pack_DuplicateCheck_Menu
Feature: To test the functionality of Duplicate Check Menu

	@TC_05_01_AddDuplicateCheck
  Scenario Outline: To check functionality of Add Duplicate Check
    Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Add
    Then User add Duplicate Check record using "<SheetName>"
	#done
    Examples: 
    |SheetName          |
    |DuplicateCheck_Add |
    
  @TC_05_02_ApproveDuplicateCheck
  Scenario Outline: To check functionality of Approve Duplicate Check
    Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Approve
    Then User approves Duplicate Check record using "<SheetName>"
		#done
    Examples: 
    |SheetName              |
    |DuplicateCheck_Approve |

  @TC_05_03_ListDuplicateCheck
  Scenario Outline: To check functionality of List Duplicate Check
    Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option List
    Then User view Duplicate Check record using "<SheetName>"
		#done
    Examples: 
    |SheetName           |
    |DuplicateCheck_List |
    
    @TC_05_04_DeleteDuplicateCheck
	Scenario Outline: To check functionality of Delete Duplicate Check
		Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Delete
		Then User delete Duplicate Check record using "<SheetName>"
		#done
		Examples:
		|SheetName             |
		|DuplicateCheck_Delete |
		
		 @TC_05_05_ConfirmDeleteDuplicateCheck
	Scenario Outline: To check functionality of Confirm Delete Duplicate Check
		Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Confirm Delete
		Then User approves delete operation on Duplicate Check record using "<SheetName>"
		#done
		Examples:
		|SheetName                    |
		|DuplicateCheck_ConfirmDelete |
		
		 @TC_05_06_ModifyDuplicateCheckwithInvalidData
	Scenario Outline: To check functionality of Modify Duplicate Check with Invalid data
		Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Modify
		Then User try to modify Duplicate Check record with Invalid data using "<SheetName>"
		#done
		Examples:
		|SheetName                     |
		|DuplicateCheck_Modify_Invalid |
		
		@TC_05_07_ModifyDuplicateCheckwithValidData
	Scenario Outline: To check functionality of Modify Duplicate Check with Valid data
		Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Duplicate Check and clicks on sub option Modify
		Then User try to modify Duplicate Check record with Valid data using "<SheetName>"
		#done		
		Examples:
		|SheetName                   |
		|DuplicateCheck_Modify_Valid |
		
		
    
    
    