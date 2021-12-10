Feature:Widgets

  Background:
    Given demoqa anasayfaya gidin
    And kullanici widgets sekmesini acar


    Scenario: TC_01_Accordion
      And Kullanici Accordian sekmesini tiklar
      And Kullanici ilk acordian tiklar
      Then Kullanici digerlerinin kapalı oldugunu dogrular
      And Kullanici ikinci acordian tiklar
      Then Kullanici digerlerinin kapalı oldugunu dogrular
      And Kullanici ucuncu acordian tiklar
      Then Kullanici digerlerinin kapalı oldugunu dogrular

  Scenario: TC_02_AutoComplete multiple area  dropdownu calisyor mu
    And Kullanici AutoComplete sekmesini tiklar
    And Kullanici Multiple text alaninna tiklar
    And Kullanici bir veri secer "a"
    And Kullanici bir veri secer "a"
    And Kullanici bir veri secer "a"
    #Given Kullanici multiple AutoComlete iki veri daha gonderir
    Then Kullanici Multiple text alaninna girdigi verilerin "a" icerdigini oldugunu dogrular

  Scenario: TC_03_AutoComplete  multiple area  dropdownu birden fazla veri kabul etmesi
    And Kullanici AutoComplete sekmesini tiklar
    And Kullanici Multiple text alaninna tiklar
    And Kullanici bir veri secer "a"
    And Kullanici bir veri secer "a"
    And Kullanici bir veri secer "a"
    Then Kullanici ayni text alaninda uc veri oldugunu dogrular



  Scenario: TC_04_AutoComplete single area dalanini calistirma
    And Kullanici AutoComplete sekmesini tiklar
    And  Kullanici single text alanina tiklar
    And Kullanici bir veri secer "a"
    And Kullanici bir veri secer "e"
    Then Kullanici birinci verinin olmadigini dogrular
    Then Kullanici ikinci verinin oldugunu dogrular


