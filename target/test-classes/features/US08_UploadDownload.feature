Feature: US08_UploadDownload


  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And UploandandDownland butonuna tiklayiniz

  Scenario: TC_01_Upload
    Given choosefile btonunu seciniz
    Given sectigimiz dosyanin gorunurlugunu dogrulayiniz
    Given bir dosya indiriniz
    Given dosyaninin indriildigini dogrulayiniz

  Scenario: Tc_02_Dowland
    Given Dowland butonuna tiklayiniz
    Given indirilen dosyayi gorunurlugunu dogrulayiniz


    Scenario: TC_10_TITLE
    Then "Upload and Download" yazisinin gorunurlugunu  Dogrulayiniz

