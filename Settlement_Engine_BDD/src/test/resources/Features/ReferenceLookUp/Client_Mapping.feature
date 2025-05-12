Feature: Validation of the Client Mapping Reference LookUp UI Screen
 
   Background:  the user navigate to the Settlement Engine page
    Given Settlement_Engine<URL>
      When the user clicks Settlement Engine URL for the Client Mapping
      And the User clicks on Reference LookUp UI screen for the Client Mapping
      Then the User is able to navigate to the Settlement Engine Homepage for the Client Mapping & user is able to see the reference table dropdown
      
   
     
Scenario: Verify reference data form submission with valid data for Client Mapping
When the user select client_map_lkp from the common reference table
And the user clicks the Add button from the Client Mapping page
And the user enters the data in required fields for the Client Mapping
And the user should see click on the Submit Button for the Client Mapping
Then the user should see "test_data" in the file list for the Client Mapping
 Then user can search and see the addded same record for the Client Mapping
 
 Scenario: Verify validation errors when mandatory fields are missing for the Client Mapping
When the user select client_map_lkp from the common reference table
And the user clicks the Add button from the Client Mapping page
Then the user click on any field for the Client Mapping and the user should see validation errors for required fields for the Client Mapping

Scenario: Verify that clicking "Reset" fields clears the fields for the Client Mapping
 When the user select client_map_lkp from the common reference table
And the user clicks the Add button from the Client Mapping page
And the user enters the data in required fields for the Client Mapping
And the user click on Reset button for the Client Mapping
Then all the fields should be cleared for the Client Mapping
 
Scenario: Verify that clicking "Cancel" does not save data for the Client Mapping
  When the user select client_map_lkp from the common reference table
And the user clicks the Add button from the Client Mapping page
And the user click on Cancel button for the Client Mapping
  Then Add Pop up should be closed for the Client Mapping
  
Scenario: Verify the edit icon functionality for the Client Mapping
When the user select client_map_lkp from the common reference table
  And The User click the edit icon for the any Client Mapping
Then The User should see the edit modal open Client Mapping
And the user update the any field for the Client Mapping
And the user should see click on the Update Button for the Client Mapping
And the user should see the updated "test_file" in the file list for the Client Mapping

Scenario: Verify delete confirmation pop-up appears for the Client Mapping
  When the user select client_map_lkp from the common reference table
 And The User click the delete icon for the any Client Mapping
Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Client Mapping

Scenario: Confirm deletion of a Client Mapping
  When the user select client_map_lkp from the common reference table
And The User click the delete icon for the any Client Mapping
  And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client Mapping
  And The User confirm the deletion for the Client Mapping
Then the file should be removed from the table for the Client Mapping
 
#Scenario: User downloads all record a file successfully
 # When the user select client_map_lkp from the common reference table
#And user clicks the download all records button for the Client Mapping page 
#Then a file should be downloaded all the records to the default download folder for the Client Mapping page

#Scenario: User downloads a file successfully for approve record
#  When the user select client_map_lkp from the common reference table
#And user clicks the only approved records button for the Client Mapping page
#Then a file should be downloaded approved record to the default download folder for the Client Mapping page


#Scenario: Verify file Upload functionality 
#  When the user select client_map_lkp from the common reference table
#And the User Navigates to upload Button from the Client Mapping page
 # And user selects a valid file to upload for the Client Mapping
 # And the file should be successfully uploaded for the Client Mapping
  
#Scenario: Verify Send for Approval button triggers approval process
 #When the user select client_map_lkp from the common reference table
 # When user click the Send for Approval button for the Client Mapping
#Then the file should be submitted for approval for the Client Mapping
#And a confirmation message should be displayed with Confirm and Cancel buttons for the Client Mapping
  #And by clicking on Confirm button the file should be sent for approval for the Client Mapping   
