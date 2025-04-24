Feature: Validation of the MetaData Email Alert

    Background: the user navigate to the "Settlement Engine" page
    Given The Settlement Engine<URL> for email alert
    When user hit the Settlement Engine URL for email alert
    And the user clicks on MetaData UI screen
    Then the user is able to Navigate to the Settlement Engine Email Alert page
    And User clicks on Hamburger Button for Email Alert

Scenario: Verify Meta Data form submission with valid data for the file
  When the user click on Email Alert
  And the user clicks the Add New button for the Email Alert
  And the user enters the data in required fields for the Email Alert
  And the user should see click on the Submit Button for the file for the Email Alert
  Then the user should see "test_file" in the file list for the file email

Scenario: Verify validation errors when mandatory fields are missing for the Email Alert
   When the user click on Email Alert
   And the user clicks the Add New button for the Email Alert
  	And the user click on any field for the Email Alert and the user should see validation errors for required fields for the Email Alert

Scenario: Verify that clicking "Reset" fields clears the fields for the Email Alert
   When the user click on Email Alert
    And the user clicks the Add New button for the Email Alert
   And the user enters the data in required fields for the Email Alert
    And the user click on Reset button for the Email Alert
 	Then all the fields should be cleared for the Email Alert

Scenario: Verify that clicking "Cancel" does not save data for the Email Alert
    When the user click on Email Alert
    And the user clicks the Add New button for the Email Alert
    And the user click on Cancel button for the Email Alert
   Then Add New Pop up should be closed for the Email Alert

Scenario: Verify the edit icon functionality for the Data Quality Rule
   When the user click on Email Alert
   And The User click the edit icon for the any file for the Email Alert
   Then The User should see the edit modal open file for the Email Alert
   And the user update the any field for the Email Alert
  And the user should see click on the Update Button for the Email Alert
  And the user should see the updated "test_file" in the file list for the Email Alert

Scenario: Verify delete confirmation pop-up appears
    When the user click on Email Alert
   And The User click the delete icon for the any file for the Email Alert
   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Email Alert

Scenario: Confirm deletion of a file
    When the user click on Email Alert
    And The User click the delete icon for the any file for the Email Alert
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Email Alert
    And The User confirm the deletion for the Email Alert
    Then the file should be removed from the table for the Email Alert
