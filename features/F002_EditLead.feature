Feature: Edit Lead functionality of Leaftaps application

Scenario Outline: TC002_Edit lead testcase positive flow

#Given Launch the Chrome browser   --Commented out first 2 lines as it is implemented in HooksImplementation
#Given Load the Leaftaps application url 'http://leaftaps.com/opentaps'

Given Input the username as 'demosalesmanager'
Given Input the password as 'crmsfa'
When Hit the Login button
When Click the CRMSFA link
When Click the Leads link
When Click the FindLeads link
When Click the Phone tab
When Input the Phonenumber as <phoneno>
When Click the FindLeads button
When Click the first resulting lead
When Click the Edit button
Given Edit the companyname as <companyname>
When Hit the Update button
Then Companyname of Lead should be updated

Examples:
|phoneno|companyname|
|'99'|'Test'|
|'98'|'TCS'|
|'99'|'Optus'|
