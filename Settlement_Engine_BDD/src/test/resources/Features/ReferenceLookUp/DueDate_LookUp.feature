Feature: Validation of the Due Date LookUP Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine <URL> for Due Date Lookup
      When the user clicks Settlement Engine_URL for Due Date Lookup
      And the User clicks on Reference LookUp UI Screen for Due Date LookUP
      Then the User is able to navigate to the Settlement Engine Homepage for the Due Date LookUP & user is able to see the reference table dropdown
      
     
#Scenario: Verify reference data form submission with valid data for Due Date LookUP
 #When the user select due_date_lkp from the common reference table
 #And the user clicks the Add button from the Due Date LookUP page
 #And the user enters the data in required fields for the Due Date LookUP
  #And the user should see click on the Submit Button for the Due Date LookUP
  #Then the user should see "test_data" in the file list for the Due Date LookUP
	#Then user can search and see the addded same record for the Due Date LookUP
	
#Scenario: Verify validation errors when mandatory fields are missing for the Due Date LookUP
 #When the user select due_date_lkp from the common reference table
 	#And the user clicks the Add button from the Due Date LookUP page
 #Then the user click on any field for the Due Date LookUP and the user should see validation errors for required fields for the Due Date LookUP
   
#Scenario: Verify that clicking "Reset" fields clears the fields for the Due Date LookUP
 #When the user select due_date_lkp from the common reference table
 #And the user clicks the Add button from the Due Date LookUP page
 #And the user enters the data in required fields for the Due Date LookUP
 #And the user click on Reset button for the Due Date LookUP
 #Then all the fields should be cleared for the Due Date LookUP

#Scenario: Verify that clicking "Cancel" does not save data for the Due Date LookUP
 # When the user select due_date_lkp from the common reference table
  #And the user clicks the Add button from the Due Date LookUP page
 #And the user click on Cancel button for the Due Date LookUP
 #Then Add Pop up should be closed for the Due Date LookUP
    
#Scenario: Verify the edit icon functionality for the Due Date LookUP
 # When the user select due_date_lkp from the common reference table
  #And The User click the edit icon for the any Due Date LookUP
 #Then The User should see the edit modal open Due Date LookUP
 #And the user update the any field for the Due Date LookUP
 #And the user should see click on the Update Button for the Due Date LookUP
  #And the user should see the updated "test_file" in the file list for the Due Date LookUP
    
Scenario: Verify delete confirmation pop-up appears for the Due Date LookUP
  When the user select due_date_lkp from the common reference table
 And The User click the delete icon for the any Due Date LookUP
 Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Due Date LookUP
   
Scenario: Confirm deletion of a Due Date LookUP
 When the user select due_date_lkp from the common reference table
 And The User click the delete icon for the any Due Date LookUP
 And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Due Date LookUP
  And The User confirm the deletion for the Due Date LookUP
  Then the file should be removed from the table for the Due Date LookUP

Scenario: User downloads all record a file successfully
 When the user select due_date_lkp from the common reference table
  And user clicks the download all records button for the Due Date LookUP page
  Then a file should be downloaded all the records to the default download folder for the Due Date LookUP Page
 
 Scenario: User downloads a file successfully for approve record
 When the user select due_date_lkp from the common reference table
And user clicks the only approved records button for the Due Date LookUP page
Then a file should be downloaded approved record to the default download folder for the Due Date LookUP page
 
     
Scenario: Verify file Upload functionality 
  When the user select due_date_lkp from the common reference table
  And the User Navigates to upload Button from the Due Date LookUP page
  And user selects a valid file to upload from the Due Date LookUP page
 And the file should be successfully Uploaded from the Due Date LookUP page
    
Scenario: Verify Send for Approval button triggers approval process
When the user select due_date_lkp from the common reference table
  When user click the Send for Approval button from the Due Date LookUP page
  Then the file should be submitted for Approval from the Due Date LookUP page
 And a confirmation message should be displayed with Confirm and Cancel buttons for the Due Date LookUP
  And by clicking on Confirm button the file should be sent for approval from Due Date LookUP page