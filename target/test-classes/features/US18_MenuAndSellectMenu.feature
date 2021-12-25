Feature: US18_MenuAndSellectMenu



  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar


  Scenario: TC_01 Menu
    Given Kullanici Menu sekmesini tiklar
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

