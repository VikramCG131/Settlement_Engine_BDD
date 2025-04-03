Feature: Validation of the Client Mapping Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
       Given Settlement_Engine<URL>
      When the user clicks Settlement Engine URL
      And the User clicks on Reference LookUp UI screen
    And clicks on the Expand button for the left panel
      Then the User is able to navigate to the Settlement Engine Homepage
      And the User should see the Left panel expanded
    And the Menu Items should be visible
     
  Scenario: Verify reference data form submission with valid data for Client Mapping
   When the user click on Client Mapping
   And the user clicks the Add New button from the Client Mapping page
    And the user enters the data in required fields for the Client Mapping
     And the user should see click on the Submit Button for the Client Mapping
    Then the user should see "test_data" in the file list for the Client Mapping

  Scenario: Verify validation errors when mandatory fields are missing for the Client Mapping
  When the user click on Client Mapping
   And the user clicks the Add New button from the Client Mapping page
   And the user click on any field for the Client Mapping
  Then the user should see validation errors for required fields for the Client Mapping
   
  Scenario: Verify that clicking "Reset" fields clears the fields for the Client Mapping
   When the user click on Client Mapping
   And the user clicks the Add New button from the Client Mapping page
     And the user enters the data in required fields for the Client Mapping
    And the user click on Reset button for the Client Mapping
   Then all the fields should be cleared for the Client Mapping

  Scenario: Verify that clicking "Cancel" does not save data for the Client Mapping
   When the user click on Client Mapping
    And the user clicks the Add New button from the Client Mapping page
      And the user click on Cancel button for the Client Mapping
     Then Add New Pop up should be closed for the Client Mapping
    
  Scenario: Verify the edit icon functionality for the Client Mapping
   When the user click on Client Mapping
    And The User click the edit icon for the any Client Mapping
    Then The User should see the edit modal open Client Mapping
    And the user update the any field for the Client Mapping
    And the user should see click on the Update Button for the Client Mapping
    And the user should see the updated "test_file" in the file list for the Client Mapping
    
  Scenario: Verify delete confirmation pop-up appears for the Client Mapping
  When the user click on Client Mapping
    And The User click the delete icon for the any Client Mapping
   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Client Mapping
    And The User should see "Are you sure you want to delete" message for the Client Mapping
   
  Scenario: Confirm deletion of a Client Mapping
   When the user click on Client Mapping
    And The User click the delete icon for the any Client Mapping
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client Mapping
     And The User confirm the deletion for the Client Mapping
     Then the file should be removed from the table for the Client Mapping
