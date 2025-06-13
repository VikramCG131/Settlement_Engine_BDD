Feature: Settlement Engine Calculation
 
 Background: the user navigate to the "Settlement Engine" page
    Given The Settlement Engine<URL> for SE Calculation UI	
    When user hit the Settlement Engine URL for SE Calculation UI
    And the user clicks on MetaData UI screen for SE Calculation
    Then the user is able to Navigate to the Settlement Engine SE Calculation page UI
    And User clicks on Hamburger Button for SE Calculation UI
    
  Scenario: User configures a new settlement rule
   When the user click on SE Calculation
    And the user enters values in required fields of Settlement Rules Config Metadata Category
    And the user enters Valid formula in required field of Settlement Rules Config Metadata Explorer
    And the user clicks on VALIDATE button and see the success message 
    And the user clicks the Save button
   Then the rule should be saved successfully
    
    Scenario: Verify validation errors when mandatory fields are missing for the SE Calculation
   When the user click on SE Calculation
  	And the user click on VALIDATE Button for the SE Calculation and the user should see error for required fields for the SE Calculation
  	
  	Scenario: Verify that clicking "Reset" fields clears the fields for SE Calculation
  When the user click on SE Calculation
   And the user enters values in requried fields of Settlement Rules Config Metadata Category
   And the user enters required formula in requried field of Settlement Rules Config Metadata Explorer
    And the user click on Reset button for the SE Calculation
 	Then all the fields should be cleared for the SE Calculation
 	
 	Scenario: Verify the edit icon functionality for the SE Calculation
   When the user click on SE Calculation
   And The User click the edit icon for the any record for the SE Calculation
  Then The User should see the edit modal open file for the SE Calculation
  And the user update the any field for the SE Calculation
 And the user should see click on the Update Button for the SE Calculation
  And the user should see the updated "test_file" in the file list for the SE Calculation

 	Scenario: Verify delete confirmation pop-up appears
   When the user click on SE Calculation
   And The User click the delete icon for the any file for the SE Calculation
   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the SE Calculation

Scenario: Confirm deletion of a file
    When the user click on SE Calculation
    And The User click the delete icon for the any file for the SE Calculation
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the SE Calculation
    And The User confirm the deletion for the SE Calculation
   Then the file should be removed from the table for the SE Calculation
   
Scenario: Validate the operators and logical conditions functionality
When the user click on SE Calculation
And the user clicks on Enter Formula for the SE Calculation
And the user uses appropriate operators and logical conditions such for entering valid formula 
And the formula should be displayed in the formula input box and the user clicks on VALIDATE button
Then the system should validate formula with success message

