@SkyBlue
Feature: Validate Sky Blue Functions

Background: 
	Given  "Sky Blue" b utton exists         
	
Scenario: 1 User should be able to change background color to sky blue

	When User should be able to click on the skyblue button
	Then the background color will change to "skyblue"

