Feature: Validation of the Brand Mapping Reference LookUp UI Screen

   Background:  the user navigate to the Settlement Engine page
      Given Settlement_Engine <URL>
      When the user clicks Settlement Engine_URL
      And the User clicks on Reference LookUp UI Screen
      Then the User is able to navigate to the Settlement Engine Homepage for the Brand Mapping & user is able to see the reference table dropdown
      
     
#Scenario: Verify reference data form submission with valid data for Brand Mapping
 #When the user select brand_map_lkp from the common reference table
 #And the user clicks the Add button from the Brand Mapping page
 #And the user enters the data in required fields for the Brand Mapping
  #And the user should see click on the Submit Button for the Brand Mapping
  #Then the user should see "test_data" in the file list for the Brand Mapping
	#Then user can search and see the addded same record
	
#Scenario: Verify validation errors when mandatory fields are missing for the Brand Mapping
 #When the user select brand_map_lkp from the common reference table
 	#And the user clicks the Add button from the Brand Mapping page
 #Then the user click on any field for the Brand Mapping and the user should see validation errors for required fields for the Brand Mapping
   
#Scenario: Verify that clicking "Reset" fields clears the fields for the Brand Mapping
 #When the user select brand_map_lkp from the common reference table
 #And the user clicks the Add button from the Brand Mapping page
 #And the user enters the data in required fields for the Brand Mapping
 #And the user click on Reset button for the Brand Mapping
 #Then all the fields should be cleared for the Brand Mapping

#Scenario: Verify that clicking "Cancel" does not save data for the Brand Mapping
 # When the user select brand_map_lkp from the common reference table
 # And the user clicks the Add button from the Brand Mapping page
 #And the user click on Cancel button for the Brand Mapping
 #Then Add Pop up should be closed for the Brand Mapping
    
#Scenario: Verify the edit icon functionality for the Brand Mapping
 # When the user select brand_map_lkp from the common reference table
  #And The User click the edit icon for the any Brand Mapping
 #Then The User should see the edit modal open Brand Mapping
 #And the user update the any field for the Brand Mapping
 #And the user should see click on the Update Button for the Brand Mapping
  #And the user should see the updated "test_file" in the file list for the Brand Mapping
    
#Scenario: Verify delete confirmation pop-up appears for the Brand Mapping
 # When the user select brand_map_lkp from the common reference table
 #And The User click the delete icon for the any Brand Mapping
 #Then The User should see a confirmation pop-up with title "Confirmation deletion" for the Brand Mapping
   
#Scenario: Confirm deletion of a Brand Mapping
 # When the user select brand_map_lkp from the common reference table
 #And The User click the delete icon for the any Brand Mapping
 #And The User should see a confirmation pop-up with Cancel and Confirm buttons for the Brand Mapping
  #And The User confirm the deletion for the Brand Mapping
  #Then the file should be removed from the table for the Brand Mapping

Scenario: User downloads all record a file successfully
 When the user select brand_map_lkp from the common reference table
  And user clicks the download all records button for the Brand Mapping page
  Then a file should be downloaded all the records to the default download folder for the Brand Mapping Page
 
 Scenario: User downloads a file successfully for approve record
 When the user select brand_map_lkp from the common reference table
And user clicks the only approved records button for the Brand Mapping page
Then a file should be downloaded approved record to the default download folder for the Brand Mapping page
 
     
Scenario: Verify file Upload functionality 
  When the user select brand_map_lkp from the common reference table
  And the User Navigates to upload Button from the Brand Mapping page
  And user selects a valid file to upload from the Brand Mapping page
 And the file should be successfully Uploaded from the Brand Mapping page
    
Scenario: Verify Send for Approval button triggers approval process
When the user select brand_map_lkp from the common reference table
  When user click the Send for Approval button from the Brand Mapping page
  Then the file should be submitted for Approval from the Brand Mapping page
 And a confirmation message should be displayed with Confirm and Cancel buttons for the Brand Mapping
  And by clicking on Confirm button the file should be sent for approval from brand mapping page