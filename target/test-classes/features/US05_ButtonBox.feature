Feature: US05_ButtonBox

  Background:
Given demoqa anasayfaya gidin
Then elements butonuna basiniz
And Buttons butonuna basiniz


  Scenario: TC_01_DOUBLE_CLICK_ME
    And double click me butonuna basiniz
    And basildigini dogrulayiniz

  Scenario: TC_02_RIGHT_CLICK_ME
    And right click me butonuna basiniz
    And right basildigini dogrulayiniz

  Scenario: TC_03_DYNAMIC_CLICK_ME
    And click me butonuna basiniz
    And clickme butonuna basildigini dogrulayiniz

    Scenario:TC_04_BUTTONSDISPLAY
      And Buttons yazisinin gorunurlugunu basildigini Dogrulayiniz