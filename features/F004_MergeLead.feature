Feature: Merge Lead functionality of Leaftaps application

Scenario Outline: TC004_Merge lead testcase positive flow

#Given Launch the Chrome browser   --Commented out first 2 lines as it is implemented in HooksImplementation
#Given Load the Leaftaps application url 'http://leaftaps.com/opentaps'

Given Input the username as 'demosalesmanager'
Given Input the password as 'crmsfa'
When Hit the Login button
When Click the CRMSFA link
When Click the Leads link
When Click the MergeLeads link
When Click the FromLead lookup <firstname>
When Click the ToLead lookup <lastname>
When Click the Merge button
When Handle the alert
When Click the FindLeads link
When Search the LeadID
When Click the FindLeads button
Then Verify the leads are merged

Examples:
|firstname|lastname|
|'divi'|'selvam'|
|'divi'|'parthi'|