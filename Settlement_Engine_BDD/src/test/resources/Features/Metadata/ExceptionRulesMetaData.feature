Feature: Exception Rule Meta Data Management

Background: The User navigate to the "Settlement Engine" page
    Given Settlement engine<URL> Exception
    When User click the Settlement Engine URL on Exception
     And The User clicks on Metadata UI screen on Exception
    Then The User is able to navigate to the settlement Engine homepage on Exception
  And User Clicks on Hamburger Button Icon for the Exception Rule

Scenario: Verify Meta Data form submission with valid data for the Exception Rule Meta Data
  When the user click on Exception Rule Meta Data 
  And the user clicks the Add New button for the Exception Rule Meta Data
  And the user enters the data in required fields for the Exception Rule Meta Data
  And the user should see click on the Submit Button for the Exception Rule Meta Data
 Then the user should see "test_file" in the file list for the Exception Rule Meta Data

Scenario: Verify validation errors when mandatory fields are missing for the Exception Rule Meta Data
  When the user click on Exception Rule Meta Data
  And the user clicks the Add New button for the Exception Rule Meta Data
  And the user click on any field for the Exception Rule Meta Data and the user should see validation errors for required fields for the Exception Rule Meta Data

Scenario: Verify that clicking "Reset" fields clears the fields for the Exception Rule Meta Data
  When the user click on Exception Rule Meta Data
  And the user clicks the Add New button for the Exception Rule Meta Data
  And the user enters the data in required fields for the Exception Rule Meta Data
  And the user click on Reset button for the Exception Rule Meta Data
  Then all the fields should be cleared for the Exception Rule Meta Data

Scenario: Verify that clicking "Cancel" does not save data for the Exception Rule Meta Data
  When the user click on Exception Rule Meta Data
  And the user clicks the Add New button for the Exception Rule Meta Data
  And the user enters the data in required fields for the Exception Rule Meta Data
  And the user click on Cancel button for the Exception Rule Meta Data
  Then Add New Pop up should be closed for the Exception Rule Meta Data

Scenario: Verify the edit icon functionality for the Data Quality Rule
  When the user click on Exception Rule Meta Data
  And The User click the edit icon for the any file for the Exception Rule Meta Data
  Then The User should see the edit modal open file for the Exception Rule Meta Data
 	And the user update the any field for the Exception Rule Meta Data
  And the user should see click on the Update Button for the Exception Rule Meta Data
 And the user should see the updated "test_file" in the file list for the Exception Rule Meta Data

Scenario: Verify delete confirmation pop-up appears
  When the user click on Exception Rule Meta Data
  And The User click the delete icon for the any file for the Exception Rule Meta Data
  Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Exception Rule Meta Data

Scenario: Confirm deletion of a file
  When the user click on Exception Rule Meta Data
  And The User click the delete icon for the any file for the Exception Rule Meta Data
  And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Exception Rule Meta Data
  Then the file should be removed from the table for the Exception Rule Meta Data

Scenario: User downloads a file successfully
  When the user click on Exception Rule Meta Data
  And user clicks the download button Exception Rule Meta Data
  Then a file should be downloaded to the default download folder for the Exception Rule Meta Data
