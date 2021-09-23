Feature: Delete Lead functionality of Leaftaps application

Scenario Outline: TC005_Delete lead testcase positive flow

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
When Click the first resulting lead to be deleted
When Click the Delete button
When Click the FindLeads link
When Input the LeadID
When Click the FindLeads button
Then No search results should be displayed

Examples:
|phoneno|
|'99'|
|'98'|
