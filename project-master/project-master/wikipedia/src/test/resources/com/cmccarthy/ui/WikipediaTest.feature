@Wikipedia-UI
Feature: As a user, I want to add new user on Way2automation list

  Scenario Outline: I want to add user Way2automation list
    Given The user opened the Way2automation Homepage
    And The user clicked on the Add user
    And The user enter first name "<firstName>"
    And The user enter last name "<lastName>"
    And The user enter User name "<Username>"
    And The user enter password "<password>"
    And The user select Company "<Company>"
    And The user select roleId "<roleId>"
    And The user enter email "<email>"
    And The user enter mobile phone "<mobilePhone>"
    And The user click save button
    Then check if user name exist
    Examples:
      | firstName  | lastName  |Username|password|Company |email|mobilePhone|roleId|
    |    FName1        |  LName1 |  User1 |Pass1|   AAA    |admin@mail.com|082555  |Admin|
    |    FName2        |  LName2 |  User2 |Pass2|   BBB    |customer@mail.com|083444  |Customer|