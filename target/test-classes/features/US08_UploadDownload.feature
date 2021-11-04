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

    Scenario: TC_10_TITLE
    Then "Upload and Download" yazisinin gorunurlugunu  Dogrulayiniz

