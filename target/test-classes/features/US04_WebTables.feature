Feature: US04_WebTables
Background:
  Given demoqa anasayfaya gidin
  Then elements butonuna basiniz
    And webTables butonuna basiniz
  Scenario Outline: TC_01
    And Add butonuna basiniz
    And cikan formda firstName yaziniz  "<firstname>"
    And cikan formda lastName yaziniz  "<lastName>"
    And cikan formda email giriniz  "<email>"
    And cikan formda age yaziniz "<age>"
    And cikan formda salary yaziniz "<salary>"
    And cikan formda department yaziniz "<department>"
    And submit butonuna tiklayiniz
    And search butonuna firstName giriniz "<firstname>"
    Then  kaydin ekledigini dogrulayiniz "<firstname>"

    Examples:
      | firstname | lastName | email             | age | salary | department |
      | abdullah  | mucahit  | mucahit@gmail.com | 34  | 30000  | IT         |
      | zehra     | bektas   | zhra@gmail.com    | 25  | 50000  | TESTER     |
      | aslan     | kaplan   | aslan@gmail.com   | 12  | 70000  | TESTER     |

    Scenario: TC02
      And duzenle butonuna basiniz
      And cikan formda firstName yaziniz  "aslan"
      And cikan formda lastName yaziniz  "kaplan"
      And cikan formda email giriniz  "sa@gmail.com"
      And cikan formda salary yaziniz "5000"
      And cikan formda department yaziniz "muhendis"
      And submit butonuna tiklayiniz
      And search butonuna firstName giriniz "aslan"
      Then  kaydin ekledigini dogrulayiniz "aslan"


  Scenario: TC03 silme
    And sil butonuna basiniz
    Then  kaydin silindigini dogrulayiniz


  Scenario: TC04 liste
    And liste olustur


