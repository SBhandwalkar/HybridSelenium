Feature: Login to Application

Scenario Outline: Login with valid credentials
Given User is on login page
When User enters <username> and <password>
Then User gets logged into application



Examples:
|username	|password|
|"XY58278"	|"Password@123" |

