Feature: Validation of the MetaData Data Source File

     Background:  the user navigate to the "Settlement Engine" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     And the user clicks on Metadata UI Screen
     Then the user is able to Navigate to the Settlement Engine homepage
     And User clicks on Hamburger Button
   
Scenario: Verify Meta Data form submission with valid data for the file
 When the user click on Data Source File
And the user clicks the Add New button from the Data Source File page
And the user enters the data in required fields for the Data Source File
  And the user should see click on the Submit Button for the file
Then the user should see "test_file" in the file list for the file
Then user can search and see the addded same record for data Source

 Scenario: Verify validation errors when mandatory fields are missing for the file
 When the user click on Data Source File
   And the user clicks the Add New button from the Data Source File page
  And the user click on any field for the Data source file and validate the mandatory required field message
   
 Scenario: Verify that clicking "Reset" fields clears the fields for the file
  When the user click on Data Source File
  And the user clicks the Add New button from the Data Source File page
    And the user enters the data in required fields for the Data Source File
   And the user click on Reset button for the file
  Then all the fields should be cleared for the file

 Scenario: Verify that clicking "Cancel" does not save data for the file
When the user click on Data Source File
  And the user clicks the Add New button from the Data Source File page
  And the user click on Cancel button for the file
  Then Add New Pop up should be closed for the file
    
  Scenario: Verify the edit icon functionality for the Data Source file
When the user click on Data Source File
 	And The User click the edit icon for the any Data Source file
   Then The User should see the edit modal open Data Source file
   And the user update the any field for the file
   And the user should see click on the Update Button for the file
  And the user should see the updated "test_file" in the file list for the Data Source file
    
    
 Scenario: Verify delete confirmation pop-up appears for the file
 When the user click on Data Source File
  And The User click the delete icon for the any Data Source file
  Then The User should see a confirmation pop-up with title "Confirmation deletion" for the file
And The User should see "Are you sure you want to delete" message for the file
    
 Scenario: Confirm deletion of a file
    When the user click on Data Source File
  And The User click the delete icon for the any Data Source file
  And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Data Source file
   And The User confirm the deletion for the Data Source file
    Then the file should be removed from the table for the Data Source file
  
  
    

    