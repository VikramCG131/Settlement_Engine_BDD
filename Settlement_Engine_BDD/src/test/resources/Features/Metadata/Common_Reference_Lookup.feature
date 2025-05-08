Feature: Validation of the Common_Reference_Lookup Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine <URL> for commonreference
      When the user clicks Settlement Engine_URL for commonreference
      And the User clicks on Reference LookUp UI Screen for commonreference
      Then the User is able to navigate to the Settlement_Engine Homepage for commonreference
      And User Clicks On Hamburger Button Icon Brand for commonreference
     
#Scenario: Verify reference data form submission with valid data for Common_Reference_Lookup
# When the user click on the Common_Reference_Lookup
 #And the user clicks the Add button from the Common_Reference_Lookup page
# And the user enters the data in required fields for the Common_Reference_Lookup
 # And the user should see click on the Submit Button for the Common_Reference_Lookup
 # Then the user should see "test_data" in the file list for the Common_Reference_Lookup
	#Then user can search and see the addded same record for Common Reference
	
#Scenario: Verify validation errors when mandatory fields are missing for the Common_Reference_Lookup
 #When the user click on the Common_Reference_Lookup
 #	And the user clicks the Add button from the Common_Reference_Lookup page
 #Then the user click on any field for the Common_Reference_Lookup and the user should see validation errors for required fields for the Common_Reference_Lookup
   
#Scenario: Verify that clicking "Reset" fields clears the fields for the Common_Reference_Lookup
 #When the user click on the Common_Reference_Lookup
 #And the user clicks the Add button from the Common_Reference_Lookup page
# And the user enters the data in required fields for the Common_Reference_Lookup
 #And the user click on Reset button for the Common_Reference_Lookup
 #Then all the fields should be cleared for the Common_Reference_Lookup

#Scenario: Verify that clicking "Cancel" does not save data for the Common_Reference_Lookup
 # When the user click on the Common_Reference_Lookup
 # And the user clicks the Add button from the Common_Reference_Lookup page
 #And the user click on Cancel button for the Common_Reference_Lookup
 #Then Add Pop up should be closed for the Common_Reference_Lookup
    
#Scenario: Verify the edit icon functionality for the Common_Reference_Lookup
  #When the user click on the Common_Reference_Lookup
 # And The User click the edit icon for the any Common_Reference_Lookup
 #Then The User should see the edit modal open Common_Reference_Lookup
 #And the user update the any field for the Common_Reference_Lookup
 #And the user should see click on the Update Button for the Common_Reference_Lookup
 # And the user should see the updated "test_file" in the file list for the Common_Reference_Lookup
    
#Scenario: Verify delete confirmation pop-up appears for the Common_Reference_Lookup
 # When the user click on the Common_Reference_Lookup
 #And The User click the delete icon for the any Common_Reference_Lookup
  #Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Common_Reference_Lookup
   
#Scenario: Confirm deletion of a Common_Reference_Lookup
  #When the user click on the Common_Reference_Lookup
 #And The User click the delete icon for the any Common_Reference_Lookup
 #And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Common_Reference_Lookup
  #And The User confirm the deletion for the Common_Reference_Lookup
  #Then the file should be removed from the table for the Common_Reference_Lookup

#Scenario: User downloads a file successfully
 #When the user click on the Common_Reference_Lookup
  #And user clicks the download button from the Common_Reference_Lookup page
 # Then a file should be downloaded to the default download folder from the Common_Reference_Lookup page
     
#Scenario: Verify file Upload functionality 
  #When the user click on the Common_Reference_Lookup 
  #And the User Navigates to upload Button from the Common_Reference_Lookup page
  #And user selects a valid file to upload from the Common_Reference_Lookup page
 #And the file should be successfully Uploaded from the Common_Reference_Lookup page
    
#Scenario: Verify Send for Approval button triggers approval process
  #When user click the Send for Approval button from the Common_Reference_Lookup page
  #Then the file should be submitted for Approval from the Common_Reference_Lookup page
 #And a confirmation message should be displayed with Confirm and Cancel buttons for the Common_Reference_Lookup
 # And by clicking on Confirm button the file should be sent for approval from Common_Reference_Lookup page