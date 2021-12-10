Feature: US_15_Widgets_DataPicker

  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar
    And kullanici dataPicker sekmesini acar


  Scenario: TC_01
    And Kullanici takvimi tiklar
    And Kullanici Yil girer "1905"
    And Kullanici Ayi girer 04
    And Kullanici Gunu secer "01"
    Then dogru tarih oldugunu test ediniz

  Scenario Outline: TC_03
    And Kullanici takvimi tiklar
    And Kullanici Yil girer "<2021>"
    And Kullanici Ay girer  "<December>"
    And Kullanici Gun secer "<09>"
    Then dogru tarih oldugunu test ediniz
    Examples:
      | 2021 | December  | 09 |
      | 2000 | September | 15 |
      | 1905 | April     | 01 |
      | 2091 | January   | 31 |


  Scenario: TC_04 ileri tarih girme
    And Kullanici zamanbox i tiklar tiklar
    And Kullanicizaman olumune Ayi girer 10
    And Kullanici zaman olumune Yil girer "2011"
    And Kullanici zaman olumune Gunu secer 25

