Feature: Login

  Scenario: Correct transfer of coupons between all shares to the basket
    Given User launch application
    And User click popup root button
    When User click login button
    And Username with "kemins"
    And Password with "K123456"
    And User click membership login button
    And User see "12843795" message
    And User click kupondas button
    And User click all shares button
    And User click play now button
    Then Get coupon detail team name
    And User click detail play now button
    And Check basket page