Feature: Validation of the Client Mapping Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine<URL>
      When the user clicks Settlement Engine URL
      And the User clicks on Reference LookUp UI screen
    And clicks on the Expand button for the left panel
      Then the User is able to navigate to the Settlement Engine Homepage
      And the User should see the Left panel expanded
    And the Menu Items should be visible
     
 # Scenario: Verify reference data form submission with valid data for Client Mapping
  # When the user click on the Client Mapping
  # And the user clicks the Add button from the Client Mapping page
   # And the user enters the data in required fields for the Client Mapping
   #  And the user should see click on the Submit Button for the Client Mapping
   # Then the user should see "test_data" in the file list for the Client Mapping

 # Scenario: Verify validation errors when mandatory fields are missing for the Client Mapping
 #  When the user click on the Client Mapping
  # And the user clicks the Add button from the Client Mapping page
 #  And the user click on any field for the Client Mapping
 # Then the user should see validation errors for required fields for the Client Mapping
   
 # Scenario: Verify that clicking "Reset" fields clears the fields for the Client Mapping
 #   When the user click on the Client Mapping
  # And the user clicks the Add button from the Client Mapping page
   # And the user enters the data in required fields for the Client Mapping
  #  And the user click on Reset button for the Client Mapping
  # Then all the fields should be cleared for the Client Mapping

 # Scenario: Verify that clicking "Cancel" does not save data for the Client Mapping
  #  When the user click on the Client Mapping
  #  And the user clicks the Add button from the Client Mapping page
  #    And the user click on Cancel button for the Client Mapping
  #  Then Add New Pop up should be closed for the Client Mapping
    
#  Scenario: Verify the edit icon functionality for the Client Mapping
 #   When the user click on the Client Mapping
  #  And The User click the edit icon for the any Client Mapping
 #   Then The User should see the edit modal open Client Mapping
  #  And the user update the any field for the Client Mapping
  #  And the user should see click on the Update Button for the Client Mapping
  #  And the user should see the updated "test_file" in the file list for the Client Mapping
    
#  Scenario: Verify delete confirmation pop-up appears for the Client Mapping
#   When the user click on the Client Mapping
#    And The User click the delete icon for the any Client Mapping
#   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Client Mapping
#    And The User should see "Are you sure you want to delete" message for the Client Mapping
   
#  Scenario: Confirm deletion of a Client Mapping
#    When the user click on the Client Mapping
#    And The User click the delete icon for the any Client Mapping
#    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client Mapping
#     And The User confirm the deletion for the Client Mapping
#     Then the file should be removed from the table for the Client Mapping
     
  #  Scenario: Verify file Upload functionality 
  #  When the user click on the Client Mapping
  #  And user clicks the Upload button
   # Then file selection dialog should appear
   # And user selects a valid file to upload
  #  And the file should be successfully uploaded
    
     Scenario: Verify Send for Approval button triggers approval process
    When user click the Send for Approval button
    Then the file should be submitted for approval
   And a confirmation message should be displayed with Confirm and Cancel buttons
    And by clicking on Confirm button the file should be sent for approval
    
     
#  Scenario Outline: Validate filter options in the Client Mapping Grid
#    Given I navigate to the Client Mapping Grid
#    When I select "<Filter Type>" from the filter dropdown
#    And I enter "<Filter Value>" in the filter input (if applicable)
#    And I apply the filter
#    Then the displayed rows should match the "<Expected Outcome>"

#    Examples:
#      | Filter Type        | Filter Value | Expected Outcome                                      |
#      | Contains          | S            | Rows where Shop Code contains "S"                    |
#      | Does not contain | S            | Rows where Shop Code does not contain "S"            |
#      | Equals           | YY           | Only rows where Shop Code is "YY"                    |
#      | Does not equal   | YY           | Rows where Shop Code is not "YY"                     |
#      | Begins with      | S            | Rows where Shop Code starts with "S"                 |
#      | Ends with        | Y            | Rows where Shop Code ends with "Y"                   |
#      | Blank            |              | Only rows where Shop Code is blank                   |
#      | Not blank        |              | Only rows where Shop Code is not blank               |
