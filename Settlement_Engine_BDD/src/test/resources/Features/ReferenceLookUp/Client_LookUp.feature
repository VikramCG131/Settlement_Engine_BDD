Feature: Validation of the Client LookUp Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine<URL> for Client LookUp page
      When the user clicks Settlement Engine URL for Client LookUp page
      Then The User is able to navigate to the settlement Engine Homepage
      And the User clicks on Reference LookUp UI screen
      And User Clicks on Hamburger Button Icon
     
 Scenario: Verify reference data form submission with valid data for Client LookUp
  When the user click on the Client LookUp
  And the user clicks the Add button from the Client LookUp page
  And the user enters the data in required fields for the Client LookUp
  And the user should see click on the Submit Button for the Client LookUp
  Then the user should see "test_data" in the file list for the Client LookUp

Scenario: Verify validation errors when mandatory fields are missing for the Client LookUp
  When the user click on the Client LookUp
 And the user clicks the Add button from the Client LookUp page
  And the user click on any field for the Client LookUp and the user should see validation errors for required fields for the Client LookUp
   
Scenario: Verify that clicking "Reset" fields clears the fields for the Client LookUp
  When the user click on the Client LookUp
 And the user clicks the Add button from the Client LookUp page
  And the user enters the data in required fields for the Client LookUp
  And the user click on Reset button for the Client LookUp
  Then all the fields should be cleared for the Client LookUp

Scenario: Verify that clicking "Cancel" does not save data for the Client LookUp
  When the user click on the Client LookUp
  And the user clicks the Add button from the Client LookUp page
  And the user click on Cancel button for the Client LookUp
 Then Add Pop up should be closed for the Client LookUp
    
Scenario: Verify the edit icon functionality for the Client LookUp
  When the user click on the Client LookUp
  And The User click the edit icon for the any Client LookUp
  Then The User should see the edit modal open Client LookUp
  And the user update the any field for the Client LookUp
 And the user should see click on the Update Button for the Client LookUp
  And the user should see the updated "test_file" in the file list for the Client LookUp
    
Scenario: Verify delete confirmation pop-up appears for the Client LookUp
  When the user click on the Client LookUp
  And The User click the delete icon for the any Client LookUp
 Then The User should see a confirmation pop-up with message "Are you sure you want to delete" for the Client LookUp
   
Scenario: Confirm deletion of a Client LookUp
  When the user click on the Client LookUp
  And The User click the delete icon for the any Client LookUp
 And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client LookUp
  And The User confirm the deletion for the Client LookUp
 Then the file should be removed from the table for the Client LookUp

Scenario: User downloads a file successfully
  When the user click on the Client LookUp
 And user clicks the download button
 Then a file should be downloaded to the default download folder
     
Scenario: Verify file Upload functionality 
  When the user click on the Client LookUp
  And the User Navigates to upload Button
 And user selects a valid file to upload
 And the file should be successfully uploaded
    
Scenario: Verify Send for Approval button triggers approval process
 When user click the Send for Approval button
 Then the file should be submitted for approval
  And a confirmation message should be displayed with Confirm and Cancel buttons
 And by clicking on Confirm button the file should be sent for approval   
  
  