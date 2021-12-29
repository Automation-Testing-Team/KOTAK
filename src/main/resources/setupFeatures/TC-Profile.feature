#Author: Suvarna Prabhumatkari
@Version1.0 @Regression_Pack_Profile_Menu
Feature: To Test The Functionality Of Profile Menu

  @TC01_01_AddProfile
  Scenario Outline: To Create Profile
    Given User goes to Administration and then Profile Add menu
    Then User enters valid record details using "<SheetName>" and clicks on Ok button

    Examples: 
      | SheetName              |
      | Profile_AddApproveList |

  @TC01_02_Approve_Profile
  Scenario Outline: To Approve the Profile
    Given User goes to Administration and then Profile Approve menu
    Then User goes to Profile Approve screen and approves the record using "<SheetName>"

    Examples: 
      | SheetName              |
      | Profile_AddApproveList |

  @TC01_03_View_Profile
  Scenario Outline: To View the Profile
    Given User goes to Administration and then Profile List menu
    Then User goes to Profile List screen and views the record using "<SheetName>"

    Examples: 
      | SheetName              |
      | Profile_AddApproveList |

  @TC01_04_Profile_Modify/Repair
  Scenario Outline: To perform Modify/Repair action for Profile
    Given User goes to Administration and then User selects Profile Modify/Repair menu
    Then User provides valid profile record details for Modify/Repair operation using "<SheetName>"

    Examples: 
      | SheetName                       |
      | Profile_ModifyRepairApproveList |

  @TC01_05_Approve_Profile
  Scenario Outline: To Approve the Profile
     Given User goes to Administration and then Profile Approve menu
    Then User goes to Profile Approve screen and approves the record using "<SheetName>"

   Examples: 
      | SheetName                       |
      | Profile_ModifyRepairApproveList |

  @TC01_06_View_Profile
  Scenario Outline: To View the Profile
    Given User goes to Administration and then Profile List menu
    Then User goes to Profile List screen and views the record using "<SheetName>"

 Examples: 
      | SheetName                       |
      | Profile_ModifyRepairApproveList |

  @TC01_07_Remove_Profile
  Scenario Outline: To Remove Profile
    Given User goes to Administration and then User selects Profile Remove menu
    Then User goes to Profile Remove screen and remove the record using "<SheetName>"

    Examples: 
      | SheetName                 |
      | Profile_RemoveApproveList |

  @TC01_0_Approve_Profile
  Scenario Outline: To Approve the Profile
     Given User goes to Administration and then Profile Approve menu
    Then User goes to Profile Approve screen and approves the record using "<SheetName>"

   Examples: 
      | SheetName                 |
      | Profile_RemoveApproveList |

  @TC01_06_View_Profile
  Scenario Outline: To View the Profile
    Given User goes to Administration and then Profile List menu
    Then User goes to Profile List screen and views the record using "<SheetName>"

  Examples: 
      | SheetName                 |
      | Profile_RemoveApproveList |

 