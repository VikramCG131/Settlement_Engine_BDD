Feature: Validation of the Mov Mapping LookUP Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine <URL> for Mov Mapping LookUP
      When the user clicks settlement engine URL
      And the User clicks on reference lookUp UI Screen
      Then the User is able to navigate to the Settlement Engine Homepage for the Mov Mapping LookUP & user is able to see the reference table dropdown
      
     
Scenario: Verify reference data form submission with valid data for Mov Mapping LookUP
 When the user select move_mapping_lkp from the common reference table
 And the user clicks the Add button from the Mov Mapping LookUP page
 And the user enters the data in required fields for the Mov Mapping LookUP
  And the user should see click on the Submit Button for the Mov Mapping LookUP
  Then the user should see "test_data" in the file list for the Mov Mapping LookUP
	Then user can search and see the addded same record for Mov Mapping LookUP
	
Scenario: Verify validation errors when mandatory fields are missing for the Mov Mapping LookUP
 When the user select move_mapping_lkp from the common reference table
 	And the user clicks the Add button from the Mov Mapping LookUP page
 Then the user click on any field for the Mov Mapping LookUP and the user should see validation errors for required fields for the Mov Mapping LookUP
   
Scenario: Verify that clicking "Reset" fields clears the fields for the Mov Mapping LookUP
 When the user select move_mapping_lkp from the common reference table
 And the user clicks the Add button from the Mov Mapping LookUP page
 And the user enters the data in required fields for the Mov Mapping LookUP
 And the user click on Reset button for the Mov Mapping LookUP
 Then all the fields should be cleared for the Mov Mapping LookUP

Scenario: Verify that clicking "Cancel" does not save data for the Mov Mapping LookUP
  When the user select move_mapping_lkp from the common reference table
  And the user clicks the Add button from the Mov Mapping LookUP page
 And the user click on Cancel button for the Mov Mapping LookUP
 Then Add Pop up should be closed for the Mov Mapping LookUP
    
Scenario: Verify the edit icon functionality for the Mov Mapping LookUP
  When the user select move_mapping_lkp from the common reference table
  And The User click the edit icon for the any Mov Mapping LookUP
 Then The User should see the edit modal open Mov Mapping LookUP
 And the user update the any field for the Mov Mapping LookUP
 And the user should see click on the Update Button for the Mov Mapping LookUP
  And the user should see the updated "test_file" in the file list for the Mov Mapping LookUP
    
Scenario: Verify delete confirmation pop-up appears for the Mov Mapping LookUP
  When the user select move_mapping_lkp from the common reference table
 And The User click the delete icon for the any Mov Mapping LookUP
 Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Mov Mapping LookUP
   
Scenario: Confirm deletion of a Mov Mapping LookUP
  When the user select move_mapping_lkp from the common reference table
 And The User click the delete icon for the any Mov Mapping LookUP
 And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Mov Mapping LookUP
  And The User confirm the deletion for the Mov Mapping LookUP
  Then the file should be removed from the table for the Mov Mapping LookUP

Scenario: User downloads all record a file successfully
 When the user select move_mapping_lkp from the common reference table
  And user clicks the download all records button for the Mov Mapping LookUP page
  Then a file should be downloaded all the records to the default download folder for the Mov Mapping LookUP Page
 
 Scenario: User downloads a file successfully for approve record
 When the user select move_mapping_lkp from the common reference table
And user clicks the only approved records button for the Mov Mapping LookUP page
Then a file should be downloaded approved record to the default download folder for the Mov Mapping LookUP page
 
     
Scenario: Verify file Upload functionality 
  When the user select move_mapping_lkp from the common reference table
  And the User Navigates to upload Button from the Mov Mapping LookUP page
  And user selects a valid file to upload from the Mov Mapping LookUP page
 And the file should be successfully Uploaded from the Mov Mapping LookUP page
    
Scenario: Verify Send for Approval button triggers approval process
When the user select move_mapping_lkp from the common reference table
  When user click the Send for Approval button from the Mov Mapping LookUP page
  Then the file should be sumitted for Approval from the Mov Mapping LookUP page
 And a confirmation message should be displayed with Confirm and Cancel buttons for the Mov Mapping LookUP
  And by clicking on Confirm button the file should be sent for approval from Mov Mapping LookUP page