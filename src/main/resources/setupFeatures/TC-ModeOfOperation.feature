#Author: Suvarna Prabhumatkari

@Version1.0 
@Regression_Pack_ModeOfOperation_Menu
Feature: To test the functionality of Mode Of Operation Menu

@TC_05_01_ListModeOfOperation
Scenario Outline: To check the functionality of Mode Of Operation List
 Given User navigates to Application and Maintenance clicks on Corporate CMS menu and then selects Mode Of Operation and clicks on sub option List
 Then User lists Mode of Operation record using "<SheetName>"

 Examples:
 |SheetName            |
 |ModeOfOperation_List |