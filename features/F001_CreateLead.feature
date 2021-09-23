Feature: Create Lead functionality of Leaftaps application

Scenario Outline: TC001_Create lead testcase positive flow

#Given Launch the Chrome browser   --Commented out first 2 lines as it is implemented in HooksImplementation
#Given Load the Leaftaps application url 'http://leaftaps.com/opentaps'

Given Input the username as 'demosalesmanager'
Given Input the password as 'crmsfa'
When Hit the Login button
When Click the CRMSFA link
When Click the Leads link
When Click the CreateLead link
Then Create lead page will be displayed
Given Input the Companyname as <companyname>
Given Input the Forename as <firstname>
Given Input the Surname as <lastname>
When Click the Createlead button
Then ViewLead should be displayed

Examples:
|companyname|firstname|lastname|
|'TCS'|'Divi'|'Parthi'|
|'Optus'|'Kannan'|'Selvam'|