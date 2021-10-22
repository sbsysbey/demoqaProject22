@us3
Feature: US03_RadioButton
Background:
  Given demoqa anasayfaya gidin
  Then elements butonuna basiniz
  And radiobox butonuna tiklayiniz
  Scenario: TC01

    And yes Buttonunu tiklayiniz
    Then Yes secildigini dogrulayiniz



    Scenario: TC02
      And Impresive butonuna tiklayiniz
      Then İmpersive yazisini dogrulayiniz
      Then Yes butonunun secili olmadigini dogrulayin


  Scenario: TC03
      Then No butonunun secildigini  dogrulayiniz

