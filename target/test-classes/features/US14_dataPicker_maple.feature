Feature: US_14_dataPicker_maple

  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar
    And kullanici dataPicker sekmesini acar


  Scenario: TC_01_Map yontemi ile datePicker
    And Kullanici takvimi tiklar
    And Kullanici YIL,AY,GUN secer
      | Year | Month | Day |
      | 2000 | May   | 01  |
    Then Kullanici date and time secilebildigini dogrular

  @dene
  Scenario Outline: TC_02 Outline ile datePicker
    And Kullanici takvimi tiklar
    And Kullanici "<yil>","<ay>","<gun>" girer
    And Kullanici "<yil>","<ay>","<gun>" girdiginin sonucunu dogrular

    Examples:
      | yil  | ay | gun |
      | 1971 | 03 | 12  |
      | 2000 | 12 | 31  |
      | 1999 | 01 | 01  |
      | 2100 | 12 | 12  |
      | 1999 | 02 | 28   |


  Scenario: TC_03 saatli bolum
    And Kullanici zamanbox i tiklar tiklar
    And Kullanici zaman bolumune Yil girer "2021"
    And Kullanici zaman bolumune Ayi girer 12
    And Kullanici zaman bolumune Gunu secer 19
    And Kullanici saati secer "11:45"
    Then Kullanici dogru zaman oldugunu test eder "2021","12","19","10:45"



