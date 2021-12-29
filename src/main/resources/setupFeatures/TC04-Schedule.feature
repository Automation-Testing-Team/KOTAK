#Author: Suvarna
Feature: Schedule feature

  @TC_04_01_ControlSchedule
  Scenario: To check Schedule control
    Then User goes Maintenance and open Schedule Control menu
    Then User Activate the Scheduler Service
    #done

  @TC_04_02_ListSchedule
  Scenario Outline: To List Scheduler
    Then User goes Maintenance and open Schedule List menu
    Then User list the Scheduler using "<SheetName>"
    #done
    Examples:
     | SheetName     |
     | Schedule_List |

  @TC_04_03_AddNewSchedulewithInvaliddata
  Scenario Outline: To Add Scheduler with Invalid data
    Then User goes Maintenance and open Schedule New menu
    Then User add Invalid data for Scheduler using "<SheetName>"
    #done
    #Scheduler invalid data is getting added
     Examples: 
      | SheetName                |
      | Schedule_Add_InvalidData |

  @TC_04_05_AddNewSchedulerwithValiddata
  Scenario Outline: To Add Scheduler with valid data
    Then User goes Maintenance and open Schedule New menu
    Then User add Valid data for Scheduler using "<SheetName>"
    #done
    Examples: 
      | SheetName              |
      | Schedule_Add_ValidData |

  @TC_04_09_ModifySchedulers
  Scenario Outline: To Modify Scheduler
    Then User goes Maintenance and open Schedule Modify menu
    Then User modify Scheduler using "<SheetName>"
    #done
    Examples: 
      | SheetName       |
      | Schedule_Modify |