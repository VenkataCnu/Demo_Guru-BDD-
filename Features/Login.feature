Feature: Login feature

  Scenario: Login test
    Given User launch the application in browser 
    When User opens the url as "https://demo.guru99.com/V1/index.php"
    And User entered the username as "mngr481521"
    And User entered the password as "vurUzEn"
    And User clicked on Login button
    Then Page title should be "GTPL Bank Manager HomePage"
    And close the browser

  Scenario Outline: Login with multi credentials
		
		Given User launch the application in browser 
    When User opens the url as "https://demo.guru99.com/V1/index.php"
    And User entered the username as <UserId>
    And User entered the password as <Password>
    And User clicked on Login button
    Then Page title should be "GTPL Bank Manager HomePage"
    And close the browser
    
    Examples: 
      | UserId  | Password | status  |
      | abcdef | abcdef | Fail|
      | xyzabc | xyzabc | Fail|
      | mngr481521 |vurUzEn| Success |
