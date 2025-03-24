Feature: Meta Data Form Submission


     Background:  the user navigate to the "Settlement Engine" page
     Given The Settlement Engine<URL>
     When user hit the Settlement Engine URL
     Then the user is able to navigate to the Settlement Engine homepage
     And the user click on Data Source File 
     

 #Scenario: Verify Meta Data form submission with valid data
  # When the user clicks the Add New button
   # And the user enters the data in required fields
    #And the user should see click on the Submit Button
    #Then the user should see "test_file" in the file list

 #Scenario: Verify validation errors when mandatory fields are missing
   #When the user clicks the Add New button
   #And the user click on any field
  # Then the user should see validation errors for required fields
   
  #Scenario: Verify that clicking "Reset" fields clears the fields
    #When the user clicks the Add New button
    #And the user enters the data in required fields
   # And the user click on Reset button
   # Then all the fields should be cleared

 #Scenario: Verify that clicking "Cancel" does not save data
   #  When the user clicks the Add New button
    # And the user click on Cancel button
   #  Then Add New Pop up should be closed
    
   #Scenario: Verify the edit icon functionality
   #When The User click the edit icon for the any file 
   # Then The User should see the edit modal open file
   # And the user update the any field
   # And the user should see click on the Update Button
   # And the user should see the updated "test_file" in the file list
    
    
 #Scenario: Verify delete confirmation pop-up appears
  # When The User click the delete icon for the any file
  # Then The User should see a confirmation pop-up with title "Confirmation deletion"
   # And The User should see "Are you sure you want to delete" message
    
  Scenario: Confirm deletion of a file
    When The User click the delete icon for the any file
   And The User should see a confirmation pop-up with Cancel and Confirm buttons
    And The User confirm the deletion
    Then the file should be removed from the table
  
  
    

    