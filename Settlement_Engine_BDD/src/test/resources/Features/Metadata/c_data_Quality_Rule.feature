 @skip
 Feature: Data Quality Rule Management

#Background:  the user navigate to the "Settlement Engine" page
   #    Given Settlement Engine<URL> for data Quality
   #   When the user hit the Settlement Engine URL for data Quality
    #  And the User clicks on Metadata UI screen for data Quality
   # And click on the Expand button for the left panel for data Quality
    #  Then the User is able to navigate to the for data Quality home page
     # And the User should see the left panel expanded for data Quality
   # And the Menu items should be visible for data Quality

  #Scenario: Verify Meta Data form submission with valid data for the DQ Rule
   #  When the user click on Data Quality Rules
    # And the user clicks the Add New button for the DQ Rule
    # And the user enters the data in required fields for the DQ Rule
    # And the user should see click on the Submit Button for the DQ Rule
    # Then the user should see "test_file" in the file list for the DQ Rule

#  Scenario: Verify validation errors when mandatory fields are missing for the DQ Rule
#      When the user click on Data Quality Rules
#      And the user clicks the Add New button for the DQ Rule
#      And the user click on any field for the DQ Rule
#      Then the user should see validation errors for required fields for the DQ Rule

#  Scenario: Verify that clicking "Reset" fields clears the fields for the DQ Rule
#      When the user click on Data Quality Rules
#      And the user clicks the Add New button for the DQ Rule
#      And the user enters the data in required fields for the DQ Rule
#      And the user click on Reset button for the DQ Rule
#      Then all the fields should be cleared for the DQ Rule

#  Scenario: Verify that clicking "Cancel" does not save data for the DQ Rule
#      When the user click on Data Quality Rules
#      And the user clicks the Add New button for the DQ Rule
#      And the user click on Cancel button for the DQ Rule
#      Then Add New Pop up should be closed for the DQ Rule

#  Scenario: Verify the edit icon functionality for the Data Quality Rule
#      When the user click on Data Quality Rules
#      And The User click the edit icon for the any file for the DQ Rule
#      Then The User should see the edit modal open file for the DQ Rule
#      And the user update the any field for the DQ Rule
#      And the user should see click on the Update Button for the DQ Rule
#      And the user should see the updated "test_file" in the file list for the DQ Rule

#  Scenario: Verify delete confirmation pop-up appears
#      When the user click on Data Quality Rules
#      And The User click the delete icon for the any file for the DQ Rule
#      Then The User should see a confirmation pop-up with title "Confirmation deletion" for the DQ Rule
#      And The User should see "Are you sure you want to delete" message for the DQ Rule

#  Scenario: Confirm deletion of a file
#      When the user click on Data Quality Rules
#      And The User click the delete icon for the any file for the DQ Rule
#      And The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Rule
#      And The User confirm the deletion for the DQ Rule
#      Then the file should be removed from the table for the DQ Rule
