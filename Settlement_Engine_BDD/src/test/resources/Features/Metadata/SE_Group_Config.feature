Feature: Settlement Grouping Configuration

Background: the user navigate to the "Settlement Engine" page
    Given The Settlement Engine<URL> for SE Group Config UI	
    When user hit the Settlement Engine URL for SE Group Config UI
    And the user clicks on MetaData UI screen for SE Group Config
    Then the user is able to Navigate to the Settlement Engine SE Group Config page UI
    And User clicks on Hamburger Button for SE Group Config UI
    
 
#Scenario: Move rule from Applied to Configured using arrows
#When the user click on SE Group Config
   #And the user clicks the Add button for the SE Group Config
	#And selects Rules from the list of Configured Rules and clicks the any arrow icon
 #Then Rules should appear under Applied Rules and arrows working as expected
 
 
  #Scenario: Submit form with valid group name and at least one applied rule
  #When the user click on SE Group Config
   #And the user clicks the Add button for the SE Group Config
   #When User enter the required group name in the Group Name field
   #And User move any Rule from Configured Rules to Applied Rules
    #And the user should see click on the Submit Button for the file for the SE Group Config
    #Then the form should be submitted successfully
 
 #Scenario: Verify validation errors when mandatory fields are missing for the SE Group Config
  # When the user click on SE Group Config
   #And the user clicks the Add button for the SE Group Config
  	#And the user click on group name for the SE Group Config and the user should see validation errors for required fields for the SE Group Config
 
 #Scenario: Verify that clicking "Cancel" does not save data for the SE Group Config
   # When the user click on SE Group Config
   # And the user clicks the Add button for the SE Group Config
  #  And the user click on Cancel button for the SE Group Config
  # Then Add Pop up should be closed for the SE Group Config
   
 # Scenario: Verify that clicking "Reset" fields clears the fields for SE Group Config
  #When the user click on SE Group Config
   #And the user clicks the Add button for the SE Group Config
   #When User enter the required group name in the Group Name field
   #And User move any Rule from Configured Rules to Applied Rules
    #And the user click on Reset button for the SE Group Config
 	#Then all the fields should be cleared for the SE Group Config
 	
 	#Scenario: Verify the edit icon functionality for the SE Group Config
   #When the user click on SE Group Config
   #And The User click the edit icon for the any record for the SE Group Config
  #Then The User should see the edit modal open file for the SE Group Config
  #And the user update the any field for the SE Group Config
 #And the user should see click on the Update Button for the SE Group Config
  #And the user should see the updated "test_file" in the file list for the SE Group Config

 	Scenario: Verify delete confirmation pop-up appears
   When the user click on SE Group Config
   And The User click the delete icon for the any file for the SE Group Config
   Then The User should see a confirmation pop-up with title "Confirmation deletion" for the SE Group Config

Scenario: Confirm deletion of a file
    When the user click on SE Group Config
    And The User click the delete icon for the any file for the SE Group Config
    And The User should see a confirmation pop-up with Cancel and Confirm buttons for the SE Group Config
    And The User confirm the deletion for the SE Group Config
   Then the file should be removed from the table for the SE Group Config

   
   