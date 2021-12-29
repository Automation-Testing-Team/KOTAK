#Author: Suvarna Prabhumatkari
@Version1.0 
@Regression_Pack_Profile_Menu
Feature: To test Profile functionality

  @TC_11_01_AddProfileScenario
  Scenario Outline: To Create Maker Profile
    Given user is on Administration menu and clicks on Profile menu and Add menu
    Then user enters the profile name using "<SheetName>" and clicks on checkboxes and ok button 
    
    Examples:
    |SheetName   |
    |Profile_Add |
    
     @TC_11_02_ApproveProfileScenario
  Scenario Outline: To Approve Maker Profile
    Given user goes to Administration and then Profile Approve menu
    Then user approve the record using "<SheetName>"
	#done
    Examples:
    |SheetName       |
    |Profile_Approve | 
    
    
  @TC_11_03_CheckerProfileScenario
  Scenario Outline: To Create Checker Profile
    Given user is on Administration menu and clicks on Profile menu and Add menu
    Then user enters the profile name "<Profilename>" and clicks on all checkboxes and ok button 
    Then user approves the record

    Examples: 
      | Profilename  | 
      | Checker1		 |
     	| Checker2		 | 
     
     
     @TC_11_03_ProfileModifyScenario
     Scenario Outline: To Modify the profile 
     Given user is on Administration menu and clicks on Profile menu and Modify menu and enters "<profilename>"
     Then user modifies "<ProfileName>" the record and clicks on ok button
     Then user approves the record
     
     Examples:
    |profilename |ProfileName	|
    |		Maker1		 |  Maker2		|
    
    @TC_11_04_ProfileRemoveScenario
    Scenario Outline: To Remove the profile
    Given user is on Administration menu and clicks on Profile menu and Remove menu
    Then user removes the profile using "<SheetName>"
    #done
    Examples:
    |SheetName      |
    |Profile_Remove |
    
    @TC_11_05_ProfileListScenario
    Scenario Outline: To List the profile
    Given user is on Administration menu and clicks on Profile menu and List menu
    Then user list the profile using "<SheetName>"
    #done
     Examples:
    |SheetName    |
    |Profile_List |
    
    
    