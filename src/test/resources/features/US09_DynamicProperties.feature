Feature: US09_DynamicProperties


  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And DynamicProperties butonuna tiklayiniz
  Scenario: TC_01
    Then Wil enable besseconds isimli buton sayfa acildiginda Disabled oldugunu  dogrulayin
    Then bes sn sonra Enabled oldugunu dogrulayin



    Then This text has random Id isimli Text Box sayfa her yenilendiginde farkli bir ID value'sune sahip oldugunu dogrulayin
  Scenario: TC02_ColorChange
    Then Color Change isimli butonun yazi renginin sayfa yuklendiginde "#fff" ve bes sn sonra "#dc3545" oldugunu dogrulayin


  Scenario: TC03_Visible 
    Then Visible After bes Seconds isimli butonun sayfa yuklendiginde goruntulenemez oldugunu
    Then ve bes sn sonra goruntulenebilir oldugunu dogrulayin
