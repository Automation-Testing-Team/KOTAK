#Author: Suvarna Prabhumatkari
@Version1.0 
@Regression_Pack_User_Menu
Feature: To Test The Functionality Of User Menu

  @TC01_01_AddUser
  Scenario Outline: To Create User
    Given User goes to Administration and then User Add menu
    Then User enters details using "<SheetName>" and clicks on Ok button
#done
    Examples: 
      | SheetName |
      | User_Add  |

  @TC01_02_Approve_User
  Scenario Outline: To Approve the User
    Given User goes to Administration and then User Approve menu
    Then User goes to Approve screen and approves the record using "<SheetName>"
#done
    Examples: 
      | SheetName    |
      | User_Approve |

  @TC01_03_View_User
  Scenario Outline: To View the User
    Given User goes to Administration and then User List menu
    Then User goes to List screen and views the record using "<SheetName>"
#	done
    Examples: 
      | SheetName |
      | User_View |

  @TC01_04_User_Modify/Repair
  Scenario Outline: To perform Modify/Repair action for user
    Given User goes to Administration and then User selects Modify/Repair menu
    Then User provides valid record details for Modify/Repair operation using "<SheetName>"
#done
    Examples: 
      | SheetName   |
      | User_Modify |
      
      @TC01_02_Approve_User
  Scenario Outline: To Approve the User
    Given User goes to Administration and then User Approve menu
    Then User goes to Approve screen and approves the record using "<SheetName>"
#done
    Examples: 
      | SheetName    |
      | User_Approve |

  @TC01_07_RemoveUser
  Scenario Outline: To Remove User
    Given User goes to Administration and then User selects Remove menu
    Then User goes to Remove screen and remove the record using "<SheetName>"
#done
    Examples: 
      | SheetName   |
      | User_Remove |
      
      @TC01_02_Approve_User
  Scenario Outline: To Approve the User
    Given User goes to Administration and then User Approve menu
    Then User goes to Approve screen and approves the record using "<SheetName>"
#done
    Examples: 
      | SheetName    |
      | User_Approve |

  @TC01_10_BlockUnBlockUser 
  Scenario Outline: To Block or UnBlock User
    Given User goes to Administration and then User selcts Block or UnBlock menu
    Then User goes to BlockUnblock screen and Block or UnBlock the record using "<SheetName>"
#	done
    Examples: 
      | SheetName         |
      | User_BlockUnblock |
      
      @TC01_02_Approve_User
  Scenario Outline: To Approve the User
    Given User goes to Administration and then User Approve menu
    Then User goes to Approve screen and approves the record using "<SheetName>"
#done
    Examples: 
      | SheetName    |
      | User_Approve |