Feature: Meta Data Form Submission


     Background:  I navigate to the "Meta Data" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     Then the user is able to navigate to the MetadataPage

  Scenario: Verify Meta Data form submission with valid data
    When I click on Metadata Button
    And I click on "Add New"
    And I enter "test_file" in the "File Name" field
    And I enter "CSV" in the "File Type" field
    And I enter "/raw/path/test_file.csv" in the "File path raw" field
    And I enter "/cleansed/path/test_file.csv" in the "File Path Cleansed" field
    And I enter "test_pattern" in the "File Pattern" field
    And I enter "10" in the "File Max Sized(MB)" field
    And I enter "comma" in the "File Delimeter" field
    And I enter "header1" in the "Header Identifier" field
    And I click on "Submit"
    Then I should see "test_file" in the file list

  Scenario: Verify validation errors when mandatory fields are missing
    When I click on "Add New"
    And I click on "Submit"
    Then I should see validation errors for required fields

  Scenario: Verify that clicking "Cancel" does not save data
    When I click on "Add New"
    And I enter "test_cancel" in the "File Name" field
    And I click on "Cancel"
    Then "test_cancel" should not be in the file list
