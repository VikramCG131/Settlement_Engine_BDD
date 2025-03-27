Feature: Data Quality Assignment Management

Background: The User navigate to the "Settlement Engine" page
    Given Settlement engine
    When User click the Settlement Engine URL
    Then The User is able to navigate to the settlement Engine homepage

Scenario: Verify Meta Data form submission with valid data for the DQ Assignment
    When the user click on Data Quality Assignment
    And the user clicks the Add New button for the DQ Assignment
    And the user enters the data in required fields for the DQ Assignment
    And the user should see click on the Submit Button for the DQ Assignment
    Then the user should see "test_file" in the file list for the DQ Assignment

Scenario: Verify validation errors when mandatory fields are missing for the DQ Assignment
    When the user click on Data Quality Assignment
    And the user clicks the Add New button for the DQ Assignment
    And the user click on any field for the DQ Assignment and validate the mandatory required field message

Scenario: Verify that clicking "Reset" fields clears the fields for the DQ Assignment
    When the user click on Data Quality Assignment
    And the user clicks the Add New button for the DQ Assignment
    And the user enters the data in required fields for the DQ Assignment
    And the user click on Reset button for the DQ Assignment
    Then all the fields should be cleared for the DQ Assignment

Scenario: Verify that clicking "Cancel" does not save data for the DQ Assignment
    When the user click on Data Quality Assignment
    And the user clicks the Add New button for the DQ Assignment
    And the user click on Cancel button for the DQ Assignment
    Then Add New Pop up should be closed for the DQ Assignment

Scenario: Verify the edit icon functionality for the Data Quality Rule
    When the user click on Data Quality Assignment
    And The User click the edit icon for the any file for the DQ Assignment
    Then The User should see the edit modal open file for the DQ Assignment
    And the user update the any field for the DQ Assignment
    And the user should see click on the Update Button for the DQ Assignment
    And the user should see the updated "test_file" in the file list for the DQ Assignment

Scenario: Verify delete confirmation pop-up appears
    When the user click on Data Quality Assignment
    And The User click the delete icon for the any file for the DQ Assignment
    Then The User should see a confirmation pop-up with message "Are you sure you want to delete" for the DQ Assignment

Scenario: Confirm deletion of a file
    When the user click on Data Quality Assignment
    And The User click the delete icon for the any file for the DQ Assignment
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Assignment
    And The User confirm the deletion for the DQ Assignment
#    Then the file should be removed from the table for the DQ Assignment
