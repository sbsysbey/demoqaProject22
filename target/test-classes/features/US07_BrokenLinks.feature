Feature: US07_BrokenLinksPage

  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And Broken links butonuna tiklayiniz
  Scenario: Tc01_validimage
    Then valid image gorunurlugunu dogrulayiniz
  Scenario: TC02_validLink
    Then Click Here for Valid Link tiklayiniz
    Then tikladiktan sonra anasayfaya gittigini dogrulayiniz
  Scenario: TC03_Click Here for Broken Link
    Then Click Here for Broken Link tiklayiniz
    Then tikladiktan sonra sayfanin hata kodu verdigini dogrulayiniz
