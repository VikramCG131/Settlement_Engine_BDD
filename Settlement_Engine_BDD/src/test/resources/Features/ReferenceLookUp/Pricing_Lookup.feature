Feature: Validation of the Pricing LookUp Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine <URL> Page
      When The User Clicks Settlement engine URL
      And the User clicks on Reference lookUp UI screen
      Then the User is able to navigate to the Settlement Engine Homepage for the Pricing LookUp & user is able to see the reference table dropdown
      
     
Scenario: Verify reference data form submission with valid data for Pricing LookUp
 When the user select pricing_lkp from the common reference table
 And the user clicks the Add button from the Pricing LookUp page
 And the user enters the data in required fields for the Pricing LookUp
 And the user should see click on the Submit Button for the Pricing LookUp
  Then the user should see "test_data" in the file list for the Pricing LookUp
	Then user can search and see the addded same record for the Pricing LookUp
	
Scenario: Verify validation errors when mandatory fields are missing for the Pricing LookUp
 When the user select pricing_lkp from the common reference table
 	And the user clicks the Add button from the Pricing LookUp page
 Then the user click on any field for the Pricing LookUp and the user should see validation errors for required fields for the Pricing LookUp
   
Scenario: Verify that clicking "Reset" fields clears the fields for the Pricing LookUp
 When the user select pricing_lkp from the common reference table
 And the user clicks the Add button from the Pricing LookUp page
 And the user enters the data in required fields for the Pricing LookUp
 And the user click on Reset button for the Pricing LookUp
 Then all the fields should be cleared for the Pricing LookUp

Scenario: Verify that clicking "Cancel" does not save data for the Pricing LookUp
 When the user select pricing_lkp from the common reference table
  And the user clicks the Add button from the Pricing LookUp page
 And the user click on Cancel button for the Pricing LookUp
 Then Add Pop up should be closed for the Pricing LookUp
    
Scenario: Verify the edit icon functionality for the Pricing LookUp
 When the user select pricing_lkp from the common reference table
  And The User click the edit icon for the any Pricing LookUp
 Then The User should see the edit modal open Pricing LookUp
 And the user update the any field for the Pricing LookUp
 And the user should see click on the Update Button for the Pricing LookUp
  And the user should see the updated "test_file" in the file list for the Pricing LookUp
    
Scenario: Verify delete confirmation pop-up appears for the Pricing LookUp
  When the user select pricing_lkp from the common reference table
 And The User click the delete icon for the any Pricing LookUp
 Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Pricing LookUp
   
Scenario: Confirm deletion of a Pricing LookUp
 When the user select pricing_lkp from the common reference table
 And The User click the delete icon for the any Pricing LookUp
 And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Pricing LookUp
  And The User confirm the deletion for the Pricing LookUp
  Then the file should be removed from the table for the Pricing LookUp

Scenario: User downloads all record a file successfully
 When the user select pricing_lkp from the common reference table
  And user clicks the download all records button for the Pricing LookUp page
  Then a file should be downloaded all the records to the default download folder for the Pricing LookUp Page
 
 Scenario: User downloads a file successfully for approve record
 When the user select pricing_lkp from the common reference table
And user clicks the only approved records button for the Pricing LookUp page
Then a file should be downloaded approved record to the default download folder for the Pricing LookUp page
 
     
Scenario: Verify file Upload functionality 
  When the user select pricing_lkp from the common reference table
  And the User Navigates to upload Button from the Pricing LookUp page
  And user selects a valid file to upload from the Pricing LookUp page
 And the file should be successfully Uploaded from the Pricing LookUp page
    
Scenario: Verify Send for Approval button triggers approval process
When the user select pricing_lkp from the common reference table
  When user click the Send for Approval button from the Pricing LookUp page
  Then the file should be submitted for Approval from the Pricing LookUp page
 And a confirmation message should be displayed with Confirm and Cancel buttons for the Pricing LookUp
  And by clicking on Confirm button the file should be sent for approval from Pricing LookUp page