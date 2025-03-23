Feature: Meta Data Form Submission


     Background:  the user navigate to the "Settlement Engine" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     Then the user is able to navigate to the Settlement Engine homepage
     And the user click on Data Source File 
     And the user click on "Add New"

  Scenario: Verify Meta Data form submission with valid data
    And the user enter "test_file" in the "File Name" field
    And the user enter "CSV" in the "File Type" field
    And the user enter "/raw/path/test_file.csv" in the "File path raw" field
    And the user enter "/cleansed/path/test_file.csv" in the "File Path Cleansed" field
    And the user enter "test_pattern" in the "File Pattern" field
    And the user enter "10" in the "File Max Sized(MB)" field
    And the user enter "comma" in the "File Delimeter" field
    And the user enter "header1" in the "Header Identifier" field
    And the user click on "Submit"
    Then the user should see "test_file" in the file list
    
@ignore
  Scenario: Verify validation errors when mandatory fields are missing
    And the user click on "Submit"
    Then the user should see validation errors for required fields
@ignore
  Scenario: Verify that clicking "Cancel" does not save data
    And the user enter "test_cancel" in the "File Name" field
    And the user click on "Cancel"
    Then "test_cancel" should not be in the file list
    
  
  
    
