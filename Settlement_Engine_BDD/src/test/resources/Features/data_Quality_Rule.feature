Feature: Data Quality Rule Management

Background:  the user navigate to the "Settlement Engine" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     Then the user is able to navigate to the Settlement Engine homepage
     And the user click on Data Quality Rules 
 
  Scenario: Add a new Data Quality Rule
    When the user clicks the "Add New" button
    And enters "string" in the "Rule Expression" field
    And enters "string" in the "Rule Description" field
    And clicks the "Submit" button
    Then the new rule with Rule Id "DQ0000002" should be displayed in the table
    
    Scenario: Reset the form
    When the user clicks the "Add New" button
    And enters "Test" in the "Rule Expression" field
    And enters "Test Desc" in the "Rule Description" field
    And clicks the "Reset" button
    Then the "Rule Expression" field should be empty
    And the "Rule Description" field should be empty
    
    Scenario: Cancel the operation
    When the user clicks the "Add New" button
    And enters "Test" in the "Rule Expression" field
    And enters "Test Desc" in the "Rule Description" field
    And clicks the "Cancel" button
    Then the user should return to the "Data Quality Rule" page without saving changes
 
  Scenario: Edit an existing Data Quality Rule
    When the user clicks the "Edit" icon for the rule with Rule Id "DQ0000002"
    And updates "Ram" in the "Rule Expression" field
    And updates "Test1222" in the "Rule Description" field
    And clicks the "Submit" button
    Then the rule with Rule Id "DQ0000002" should be updated with "Ram" and "Test1222"
 
  Scenario: Delete a Data Quality Rules
    When the user clicks the "Delete" icon for the rule with Rule Id "DQ0000002"
    And confirms the deletion
    Then the rule with Rule Id "DQ0000002" should be removed from the table
 
  
 
  