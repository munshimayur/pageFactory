#Author: Mayur Munshi
Feature: WCC Test Cases

  Background: Given all open windows are closed

  @q1
  Scenario Outline: 01 Verify given text is present on WCC URL
    Given user launch "<browser>"
    When user navigate to WCC URL "<url>"
    And clicks on Term of use link
    And clicks on hamburger icon at the top left
    And enter "<searchValue>" in search field
    And clicks on search icon
    And navigates to last page
    Then verify the "<givenText>" is present
    And user close the browser

    Examples: 
      | browser | url                                 | searchValue | givenText                             |
      | chrome  | http://wccqa.on24.com/webcast/login | elite       | ON24 Makes Business Webcasting Easier |

  @q2
  Scenario Outline: 02 Verify different social media links are present on WCC Page
    Given user launch "<browser>"
    When user navigate to WCC URL "<url>"
    And clicks on Term of use link
    And clicks on hamburger icon at the top left
    And verify link for "<socialMediaLink>"is present
    And user close the browser

    Examples: 
      | browser | url                                 | socialMediaLink |
      | chrome  | http://wccqa.on24.com/webcast/login | Twitter         |
      | chrome  | http://wccqa.on24.com/webcast/login | Facebook        |
      | chrome  | http://wccqa.on24.com/webcast/login | Linkedin        |
      | chrome  | http://wccqa.on24.com/webcast/login | Youtube         |
      | chrome  | http://wccqa.on24.com/webcast/login | Instagram       |

  @q3
  Scenario Outline: 03 Verify vshow url username and password
    Given user launch "<browser>"
    When user navigate to WCC URL "<url>"
    And enters "<invalidUsername>" and "<invalidPassword>"
    And user clicks on Login button
    Then verify invalid username / password combination error shold be displayed and user should not be able to login
    When user enters blank username and blank password
    And user clicks on Login button
    Then verify blank username error should be displayed and user should not be able to login
    When user enters  "<invalidUsername>" and blank password
    Then verify blank password should error should  be displayed and user should not be able to login
    When user enters blank username and "<invalidPassword>"
    Then verify blank username error should be displayed and user should not be able to login
    And user close the browser

    Examples: 
      | browser | url                                         | invalidUsername | invalidPassword |
      | chrome  | https://vshowqa.on24.com/vshow/ve/10081595/ | admin1          | pass2           |

  @q5
  Scenario Outline: 05 Verify Webcam Window is enabled on PMXD page
    Given user launch "<browser>"
    When user navigate to WCC URL "<url>"
    And enters first name "<firstname>"
    And enters last name "<lastname>"
    And enters email "<email>"
    And clicks on Producer button
    Then verify Webcam window is enabled

    Examples: 
      | browser | url                                                                                   | firstname | lastname | email            |
      | chrome  | https://wccqa.on24.com/webcast/present?e=1258209&k=087C3A15346E406B43658A770D65C63A61 | mayur     | munshi   | qa2001@inbfw.com |
