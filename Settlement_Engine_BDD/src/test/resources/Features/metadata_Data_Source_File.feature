Feature: Meta Data Form Submission


     Background:  the user navigate to the "Settlement Engine" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     Then the user is able to navigate to the Settlement Engine homepage
     And the user click on Data Source File 
     

 Scenario: Verify Meta Data form submission with valid data
    When the user clicks the Add New button
    And the user enters the data in required fields
    And the user should see click on the Submit Button
    Then the user should see "test_file" in the file list

#  Scenario: Verify validation errors when mandatory fields are missing
#    When the user clicks the Add New button
#    And the user click on "Submit"
#    Then the user should see validation errors for required fields

#  Scenario: Verify that clicking "Cancel" does not save data
#    When the user clicks the "Add New" buttons
#    And the user click on "Cancel"
#   Then "test_cancel" should not be in the file list
    
  
  
    
