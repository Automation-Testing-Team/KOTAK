#Author: Suvarna Prabhumatkari
@Version1.0 
@Regression_Pack_Calendar_Menu
Feature: To test the functionality of Calendar Menu

  @TC_05_01_CreateCalendarwithInvaliddata
  Scenario Outline: To Create Calendar with Invalid data
    Then User goes to Maintenance and open Calendar Add menu to add Calendar
    Then User add Calendar with invalid data using "<SheetName>"
	
    Examples: 
    |SheetName            |
    |Calendar_Add_Invalid |

  @TC_05_02_CreateCalendarwithValiddata
  Scenario Outline: To Create Calendar with Valid data
    Then User goes to Maintenance and open Calendar Add menu to add Calendar
    Then User add Calendar with valid data using "<SheetName>"
	
    Examples: 
    |SheetName          |
    |Calendar_Add_Valid |

  @TC_05_03_ApproveCalendar
  Scenario Outline: To Approve/Reject/SendToRepair Calendar
    Then User goes to Maintenance and open Calendar Approve menu to approve Calendar
    Then User Approves Calendar using "<SheetName>" and view the record
	
    Examples: 
    |SheetName             |
    |Calendar_Approve_View |

   @TC_05_04_ViewCalendar
  Scenario Outline: To View Calendar
    Then User goes to Maintenance and open Calendar View menu
    Then User view Calendar using "<SheetName>"
  
    Examples: 
    |SheetName     |
    |Calendar_View |

   @TC_05_05_Modify/RepairCalendar
  Scenario Outline: To Modify Calendar
    Then User goes to Maintenance and open Calendar Modify menu
    Then User modify Calendar using "<SheetName>" and view the record

    Examples: 
    |SheetName       |
    |Calendar_Modify |

    @TC_05_06_ApproveCalendar
  Scenario Outline: To Approve Calendar
    Then User goes to Maintenance and open Calendar Approve menu to approve Calendar
    Then User Approves Calendar using "<SheetName>" and view the record

   Examples: 
    |SheetName             |
    |Calendar_Approve_View |
