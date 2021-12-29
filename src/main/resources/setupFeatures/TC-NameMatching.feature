#Author: Suvarna Prabhumatkari

@Version1.0 
@Regression_Pack_NameMatching_Menu
Feature: To test the functionality of Name Matching Menu

	@TC_05_01_AddNameMatching
  Scenario Outline: To check functionality of Add Name Matching
    Given User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Add
    Then User add Name Matching record using "<SheetName>"
#	done
#Amount and percentage are blank
#All three fields should blank
    Examples: 
    |SheetName        |
    |NameMatching_Add |
    
  @TC_05_02_ListNameMatching
  Scenario Outline: To check functionality of List Name Matching
    Given User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option List
    Then User list Name Matching record using "<SheetName>"
#	done
    Examples: 
    |SheetName         |
    |NameMatching_List |
    
    @TC_05_03_ModifyNameMatching
  Scenario Outline: To check functionality of Modify Name Matching
    Given User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Modify
    Then User modify Name Matching record using "<SheetName>"

    Examples: 
    |SheetName           |
    |NameMatching_Modify |
    
    @TC_05_04_DeleteNameMatching
  Scenario Outline: To check functionality of Delete Name Matching
    Given User navigates to Application and clicks on Maintenance menu and then selects Name Matching menu and clicks on sub option Delete
    Then User deletes Name Matching record using "<SheetName>"

    Examples: 
    |SheetName           |
    |NameMatching_Delete |
    
    