Feature: User Signup

  Scenario: Successful signup
    Given I am on the signup page
    When I enter a valid email and password
    And I confirm the password correctly
    Then I should see a success message

  Scenario: Signup with an existing email
    Given I am on the signup page
    When I enter an email that is already registered
    And I enter a password
    Then I should see an error message "Email already exists"
    
  Scenario: Signup with invalid email format
    Given I am on the signup page
    When I enter an invalid email format
    And I enter a password
    Then I should see an error message "Invalid email format"

  Scenario: Password and Confirm Password mismatch
    Given I am on the signup page
    When I enter a valid email
    And I enter a password and confirm password that do not match
    Then I should see an error message "Passwords do not match"
