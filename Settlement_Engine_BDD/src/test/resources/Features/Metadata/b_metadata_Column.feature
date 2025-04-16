Feature: Validation of the Metadata Column

   Background:  the user navigate to the "Settlement Engine" page
       Given Settlement Engine<URL>
      When the user hit the Settlement Engine URL
      And the User clicks on Metadata UI screen
    And click on the Expand button for the left panel
      Then the User is able to navigate to the Settlement Engine homepage
      And the User should see the left panel expanded
    And the Menu items should be visible
     
  Scenario: Verify Meta Data form submission with valid data for Metadata Column
   When the user click on Metadata Column
   And the user clicks the Add New button from the Metadata Column page
    And the user enters the data in required fields for the Metadata Column
     And the user should see click on the Submit Button for the Metadata Column
    Then the user should see "test_file" in the file list for the Metadata Column

  Scenario: Verify validation errors when mandatory fields are missing for the Metadata Column
  When the user click on Metadata Column
   And the user clicks the Add New button from the Metadata Column page
   And the user click on any field for the Metadata Column
  Then the user should see validation errors for required fields for the Metadata Column
   
  Scenario: Verify that clicking "Reset" fields clears the fields for the Metadata Column
   When the user click on Metadata Column
   And the user clicks the Add New button from the Metadata Column page
     And the user enters the data in required fields for the Metadata Column
    And the user click on Reset button for the Metadata Column
   Then all the fields should be cleared for the Metadata Column

 Scenario: Verify that clicking "Cancel" does not save data for the Metadata Column
   When the user click on Metadata Column
    And the user clicks the Add New button from the Metadata Column page
      And the user click on Cancel button for the Metadata Column
     Then Add New Pop up should be closed for the Metadata Column
    
  Scenario: Verify the edit icon functionality for the Metadata Column
  When the user click on Metadata Column
    And The User click the edit icon for the any Metadata Column
    Then The User should see the edit modal open Metadata Column
    And the user update the any field for the Metadata Column
   And the user should see click on the Update Button for the Metadata Column
   And the user should see the updated "test_file" in the file list for the Metadata Column
    
  Scenario: Verify delete confirmation pop-up appears for the Metadata Column
  When the user click on Metadata Column
    And The User click the delete icon for the any Metadata Column
   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Metadata Column
    And The User should see "Are you sure you want to delete" message for the Metadata Column
   
  Scenario: Confirm deletion of a Metadata Column
   When the user click on Metadata Column
    And The User click the delete icon for the any Metadata Column
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Metadata Column
     And The User confirm the deletion for the Metadata Column
     Then the file should be removed from the table for the Metadata Column
