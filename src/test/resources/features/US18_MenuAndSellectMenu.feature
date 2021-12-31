Feature: US18_MenuAndSellectMenu

  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar


  Scenario: TC_01 Menu

    Given Kullanici Menu sekmesini tiklar
    Then Kullanici SubItemlerin gorunmedigini dogrular
    And Kullanici mouse Mainıtem1 uzerine getirir
    Then Kullanici SubItemlerin gorunmedigini dogrular
    Then Kullanici SubSubItemlerin gorunmedigini dogrular
    And Kullanici mouse Mainıtem3 uzerine getirir
    Then Kullanici SubItemlerin gorunmedigini dogrular
    Then Kullanici SubSubItemlerin gorunmedigini dogrular
    And Kullanici mouse Mainıtem2 uzerine getirir
    Then Kullanici SubItemlerin gorundugunu dogrular
    And Kullanici mouse subItem1 uzerine getirir
    Then Kullanici SubSubItemlerin gorunmedigini dogrular
    And Kullanici mouse subItem2 uzerine getirir
    Then Kullanici SubSubItemlerin gorunmedigini dogrular
    And Kullanici mouse subublist uzerine getirir
    Then Kullanici SubSubItemlerin gorundugunu dogrular



  Scenario: TC_02_Menu
    Given Kullanici Menu sekmesini tiklar
    Then Kullanici uc tane main-item oldugunu dogrular
    And Kullanici mouse Mainıtem2 uzerine getirir
    Then Kullanici iki tane sub-item ve birtane sub-sub list oldugunu dogrular

  Scenario: TC_03
    Given Kullanici Menu sekmesini tiklar
    And Kullanici mouse Mainıtem2 uzerine getirir
    And Kullanici mouse subublist uzerine getirir
    Then Kullanici sekiz tane linkin oldugunu ve isimlerini dogrular
      | arg0           |
      | Main Item   1  |
      | Main Item  3   |
      | Main Item   2  |
      | Sub Item       |
      | Sub Item       |
      | SUB SUB LIST » |
      | Sub Sub Item 1 |
      | Sub Sub Item 2 |








  Scenario Outline: TC_02 SELECT MENU Select Value

    And Kullanici Select Menu sekmesini tiklar
    And Kullanici select Option dropdownunu tiklar
    Then Kullanici "select value" inputunun border color mavi oldugunu dogrular
    And Kullanici "<deger>" degerini secer
    Then Kuulanici secimde "<deger>" oldugunu dogrular

    Examples:
      | deger               |
      | Group 1, option 1   |
      | Group 1, option 2   |
      | Group 2, option 1   |
      | Group 1, option 2   |
      | A root option       |
      | Another root option |

  Scenario Outline: TC_03 SELECT MENU Select Value

    And Kullanici Select Menu sekmesini tiklar
    And Kullanici select Option dropdownunu tiklar
    And Kullanici "<deger>" degerini secer
    Then Kuulanici secimde "<deger>" olmadini dogrular

    Examples:
      | deger |
      | aslan |



  Scenario Outline: TC_05 SELECT TITLE

    And Kullanici Select Menu sekmesini tiklar
    And Kullanici select Title dropdownunu tiklar
    And Kullanici title "<deger>" degerini secer
    Then Kuulanici title "<deger>" oldugunu dogrular

    Examples:
      | deger |
      | Dr.   |
      | Mr.   |
      | Ms.   |
      | Mrs.  |