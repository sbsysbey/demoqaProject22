
Feature: US_15_Widgets_DataPicker

  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar
    And kullanici dataPicker sekmesini acar


  Scenario: TC_01
    And Kullanici takvimi tiklar
    And Kullanici Yil girer "1905"
    And Kullanici Ayi girer 04
    And Kullanici Gun secer "01"
    Then dogru tarih oldugunu test eder


  Scenario Outline: TC_03
    And Kullanici takvimi tiklar
    And Kullanici Yil girer "<2021>"
    And Kullanici Ay girer  "<December>"
    And Kullanici Gun secer "<09>"
    Then dogru tarih oldugunu test eder
    Examples:
      | 2021 | December  | 09 |
      | 2000 | September | 15 |
      | 1905 | April     | 01 |
      | 2091 | January   | 31 |

  Scenario Outline: TC_04
    And Kullanici takvimi tiklar
    And Kullanici Yil girer "<2021>"
    And Kullanici Ay girer  "<December>"
    And Kullanici Gun secer "<09>"
    Then Kullanici İleri tarihi kabul etmedigini dogrular
    Examples:
      | 2021 | December  | 09 |
      | 2000 | September | 15 |
      | 1905 | April     | 01 |
      | 2091 | January   | 31 |

  Scenario: TC_05
    And Kullanici zamanbox i tiklar tiklar
   And Kullanici zaman bolumune Yil girer "2013"
    And Kullanici zaman bolumune Ayi girer 5
    And Kullanici zaman bolumune Gunu secer 20
   And Kullanici saati secer "18:30"
   ## Then Kullanici dogru zaman oldugunu test eder

  Scenario: TC_06
    And Kullanici zamanbox i tiklar tiklar
    And Kullanici zaman bolumunu temizler
    Then Kullanici zaman gonderir "12/12/2100 00:45"
    Then Kontrol eder

  Scenario Outline: TC_07 saatli bolum
    And Kullanici zamanbox i tiklar tiklar
    And Kullanici zaman bolumune Yil girer "<2021>"
    And Kullanici zaman bolumune Ayi girer <12>
    And Kullanici zaman bolumune Gunu secer <19>
    And Kullanici saati secer "<10:45>"
    Then Kullanici dogru zaman oldugunu test eder "<2021>",<12>,<19>,"<10:45>"
    Examples:
      | 2021 | 12 | 19 | 10:45
      | 2020 | 11 | 11 | 10:45