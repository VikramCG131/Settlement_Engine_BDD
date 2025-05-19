Feature: Validation of the Shop Level Remittance Lookup Reference LookUp UI Screen
 
   Background:  the user navigate to the Settlement Engine page
    Given Settlement_Engine<URL> for common reference
      When the user clicks Settlement Engine URL for the Shop Level Remittance Lookup
      And the User clicks on Reference LookUp UI screen for the Shop Level Remittance Lookup
      Then the User is able to navigate to the Settlement Engine Homepage for the Shop Level Remittance Lookup & user is able to see the reference table dropdown
   
Scenario: Verify reference data form submission with valid data for Shop Level Remittance Lookup
When the user select shop_level_rem_lkp from the common reference table
And the user clicks the Add button from the Shop Level Remittance Lookup page
And the user enters the data in required fields for the Shop Level Remittance Lookup
And the user should see click on the Submit Button for the Shop Level Remittance Lookup
Then the user should see "test_data" in the file list for the Shop Level Remittance Lookup
 Then user can search and see the addded same record for the Shop Level Remittance Lookup
 
 Scenario: Verify validation errors when mandatory fields are missing for the Shop Level Remittance Lookup
When the user select shop_level_rem_lkp from the common reference table
And the user clicks the Add button from the Shop Level Remittance Lookup page
Then the user click on any field for the Shop Level Remittance Lookup and the user should see validation errors for required fields for the Shop Level Remittance Lookup

Scenario: Verify that clicking "Reset" fields clears the fields for the Shop Level Remittance Lookup
 When the user select shop_level_rem_lkp from the common reference table
And the user clicks the Add button from the Shop Level Remittance Lookup page
And the user enters the data in required fields for the Shop Level Remittance Lookup
And the user click on Reset button for the Shop Level Remittance Lookup
Then all the fields should be cleared for the Shop Level Remittance Lookup
 
Scenario: Verify that clicking "Cancel" does not save data for the Shop Level Remittance Lookup
  Whenthe the user select shop_level_rem_lkp from the common reference table
And the user clicks the Add button from the Shop Level Remittance Lookup page
And the user click on Cancel button for the Shop Level Remittance Lookup
 Then Add Pop up should be closed for the Shop Level Remittance Lookup
  
Scenario: Verify the edit icon functionality for the Shop Level Remittance Lookup
When the user select shop_level_rem_lkp from the common reference table
  And The User click the edit icon for the any Shop Level Remittance Lookup
Then The User should see the edit modal open Shop Level Remittance Lookup
And the user update the any field for the Shop Level Remittance Lookup
And the user should see click on the Update Button for the Shop Level Remittance Lookup
And the user should see the updated "test_file" in the file list for the Shop Level Remittance Lookup

Scenario: Verify delete confirmation pop-up appears for the Shop Level Remittance Lookup
  When the user select shop_level_rem_lkp from the common reference table
 And The User click the delete icon for the any Shop Level Remittance Lookup
Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Shop Level Remittance Lookup

Scenario: Confirm deletion of a Shop Level Remittance Lookup
  When the user select shop_level_rem_lkp from the common reference table
And The User click the delete icon for the any Shop Level Remittance Lookup
  And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Shop Level Remittance Lookup
  And The User confirm the deletion for the Shop Level Remittance Lookup
Then the file should be removed from the table for the Shop Level Remittance Lookup
 
Scenario: User downloads all record a file successfully
  When the user select shop_level_rem_lkp from the common reference table
And user clicks the download all records button for the Shop Level Remittance Lookup page 
Then a file should be downloaded all the records to the default download folder for the Brand Mapping Page

Scenario: User downloads a file successfully for approve record
 When the user select shop_level_rem_lkp from the common reference table
And user clicks the only approved records button for the Shop Level Remittance Lookup page
Then a file should be downloaded approved record to the default download folder for the Shop Level Remittance Lookup page


#Scenario: Verify file Upload functionality 
 # When the user select shop_level_rem_lkp from the common reference table
#And the User Navigates to upload Button from the Shop Level Remittance Lookup page
 # And user selects a valid file to upload for the Shop Level Remittance Lookup
  #And the file should be successfully uploaded for the Shop Level Remittance Lookup
  
Scenario: Verify Send for Approval button triggers approval process
 When the user select shop_level_rem_lkp from the common reference table
  When user click the Send for Approval button for the Shop Level Remittance Lookup
Then the file should be submitted for approval for the Shop Level Remittance Lookup
And a confirmation message should be displayed with Confirm and Cancel buttons for the Shop Level Remittance Lookup
  And by clicking on Confirm button the file should be sent for approval for the Shop Level Remittance Lookup   
