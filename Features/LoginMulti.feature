Feature: Login with multi credentials

  Scenario Outline: Login with multi credentials
    Given User launch the application in browser 
    When User opens the url as "https://demo.guru99.com/V1/index.php"
    And User entered the username as <user>
    And User entered the password as <password>
    And User clicked on Login button
    Then Page title should be "GTPL Bank Manager HomePage"
    And close the browser


    Examples: 
      | user  | password | status  |
      | name1 |     abcd | fail 	 |
      | name2 |     efgh | fail    |
      | mngr481521 | vurUzEn| pass |
      
            
