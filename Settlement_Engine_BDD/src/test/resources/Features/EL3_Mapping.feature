Feature: Validation of the EL3 Mapping Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine<URL> EL3_Mapping
      When The user Clicks Settlement Engine URL
      And the User Clicks on Reference LookUp UI screen
    And Clicks on the Expand button for the left panel
      Then The User is able to navigate to the Settlement Engine Homepage
      And The User should see the Left panel expanded
    And The Menu Items should be visible
     
 Scenario: Verify reference data form submission with valid data for EL3 Mapping
  When the user click on the EL3 Mapping
 And the user clicks the Add button from the EL3 Mapping page
And the user enters the data in required fields for the EL3 Mapping
 	And the user should see click on the Submit Button for the EL3 Mapping
 	Then the user should see "test_data" in the file list for the EL3 Mapping

Scenario: Verify validation errors when mandatory fields are missing for the EL3 Mapping
  When the user click on the EL3 Mapping
  And the user clicks the Add button from the EL3 Mapping page
  And the user click on any field for the EL3 Mapping
  Then the user should see validation errors for required fields for the EL3 Mapping
   
Scenario: Verify that clicking "Reset" fields clears the fields for the EL3 Mapping
  When the user click on the EL3 Mapping
  And the user clicks the Add button from the EL3 Mapping page
  And the user enters the data in required fields for the EL3 Mapping
  And the user click on Reset button for the EL3 Mapping
  Then all the fields should be cleared for the EL3 Mapping

Scenario: Verify that clicking "Cancel" does not save data for the EL3 Mapping
  When the user click on the EL3 Mapping
  And the user clicks the Add button from the EL3 Mapping page
 And the user click on Cancel button for the EL3 Mapping
 Then Add Pop up should be closed for the EL3 Mapping
    
Scenario: Verify the edit icon functionality for the EL3 Mapping
  When the user click on the EL3 Mapping
 And The User click the edit icon for the any EL3 Mapping
 Then The User should see the edit modal open EL3 Mapping
  And the user update the any field for the EL3 Mapping
 And the user should see click on the Update Button for the EL3 Mapping
 And the user should see the updated "test_file" in the file list for the EL3 Mapping
    
Scenario: Verify delete confirmation pop-up appears for the EL3 Mapping
  When the user click on the EL3 Mapping
  And The User click the delete icon for the any EL3 Mapping
  Then The User should see a confirmation pop-up with title "Confirmation deletion" for the EL3 Mapping
  And The User should see "Are you sure you want to delete" message for the EL3 Mapping
   
Scenario: Confirm deletion of a EL3 Mapping
  When the user click on the EL3 Mapping
 And The User click the delete icon for the any EL3 Mapping
  And The User should see a confirmation pop-up with Cancel and Confirm buttons for the EL3 Mapping
 And The User confirm the deletion for the EL3 Mapping
 Then the file should be removed from the table for the EL3 Mapping

Scenario: User downloads a file successfully
  When the user click on the EL3 Mapping
  And user clicks the download button EL3 Mapping
 Then a file should be downloaded to the default download folder for the EL3 Mapping
 
 Scenario: Verify file Upload functionality 
  When the user click on the EL3 Mapping
  And the User Navigates to upload Button from the EL3 Mapping page
  And user selects a valid file to upload for the EL3 Mapping
  And the file should be successfully uploaded for EL3 Client Mapping
     
    
Scenario: Verify Send for Approval button triggers approval process
  When user click the Send for Approval button EL3 Mapping
  Then the file should be submitted for approval EL3 Mapping
  And a confirmation message should be displayed with Confirm and Cancel Buttons
 And by clicking on Confirm button the file should be sent for Approval
  
  