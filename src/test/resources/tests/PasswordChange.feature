Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.
 

Scenario: Successful Password Change
Given I am logged into my account with username and current password
When I navigate to the "Change Password" section
And I enter a new password that meets the password policy guidelines
And I confirm the new password
Then My password should be successfully updated
And I should receive a confirmation message

Scenario: Password Does Not Meet Policy Requirements
Given I am logged into my account with username and current password
When I navigate to the "Change Password" section
And I enter a new password that does not meet the password policy guidelines
And I confirm the new password
Then I should see an error message indicating the password requirements


Scenario: Incorrect Current Password
Given I am logged into my account with username and current password
When I navigate to the "Change Password" section
And I enter my current password incorrectly
And I enter a new password that meets the password policy guidelines
And I confirm the new password
Then I should see an error message indicating the current password is incorrect


Scenario: Password and Confirmation Do Not Match
Given I am logged into my account with username and current password
When I navigate to the "Change Password" section
And I enter a new password that meets the password policy guidelines
And I confirm a different password
Then I should see an error message indicating that the password and confirmation do not match


Scenario: Multiple Failed Attempts Lockout
Given I am logged into my account with username and current password
When I attempt to change my password multiple times incorrectly, exceeding the lockout threshold
Then I should be locked out from further password change attempts for a specified period
And I should see a message informing me of the lockout duration