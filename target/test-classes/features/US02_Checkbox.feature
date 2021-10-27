@ft2

Feature:US02_CheckBox

  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And checktbox butonuna tiklayiniz


  Scenario:TC01_ARTIBUTONU
    And + butonuna basiniz
    And ExcelFile seciniz
    Then Excelin secili oldugunu dogrulayiniz
    Then butun mnenunun acildigini dogrulayin


  Scenario:TC02_EKSIBUTONU
    And eksibutonuna basiniz
  Then menunun kapalı oldugunu dogrulayiniz







