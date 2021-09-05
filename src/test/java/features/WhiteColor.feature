@WhiteColor
Feature: Validate White Functions

Background: 
	Given  "White" button exists                
	
Scenario: 1 User should be able to change background color to white

	When User should be able to click on the white button
	Then the background color will change to "white"