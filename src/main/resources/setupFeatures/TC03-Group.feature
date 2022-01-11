#Author: Suvarna Prabhumatkari
@RegressionGroupMenu
Feature: To Test Group Functionality

  @TC_10_01_AddGroupScenario
  Scenario Outline: Create Group
    Given user goes to administration and clicks on Group menu and add menu
    Then user enters data using "<SheetName>" and clicks on Ok button
	#done
		Examples:
		| SheetName |
		| Group_Add |
		
		@TC_10_02_ApproveGroupScenario
  Scenario Outline: Approve Group
    Given user goes to administration and clicks on Group menu and Approve menu
    Then user approves the record using "<SheetName>"
	#done
		Examples:
		| SheetName     |
		| Group_Approve |

  @TC_10_02_GroupModifyScenario
  Scenario Outline: Modify Group
    Given user goes to administration and clicks on Group menu and modify menu
    Then user modifies record using "<SheetName>"
#done
	Examples:
		| SheetName    |
		| Group_Modify |
   
  @TC_10_03_GroupRemoveScenario
  Scenario Outline: Remove Group
    Given user goes to administration and clicks on Group menu and remove menu
    And user removes the group profile using "<SheetName>"
   #done
    	Examples:
		| SheetName    |
		| Group_Remove |
      
      @TC_10_04_GroupListScenario
  Scenario Outline: List Group
    Given user goes to administration and clicks on Group menu and List menu
    Then user list the group profile using "<SheetName>"
	#done
   Examples:
		| SheetName  |
		| Group_List |
      
      @TC_10_05_GroupBlockScenario
  Scenario Outline: Block Group
    Given user goes to administration and clicks on Group menu and Block menu
    Then user blocks group profile using "<SheetName>"
	#done
    Examples:
		| SheetName   |
		| Group_Block |
      
      @TC_10_06_GroupUnblockScenario
  Scenario: Unblock Group
    Given user goes to administration and clicks on Group menu and Unblock menu
    Then user unblocks group profile
      #done
      
      
