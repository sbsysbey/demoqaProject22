Feature: US11_AlertsFrame

  Background:
    Given demoqa anasayfaya gidin

    And Kulanici Alerts, Frame & Windows accordionunu tiklar


  Scenario: TC_01_Alerts bolumune gecis

    Then "Alerts, Frame & Windows" yazisinin gorunurlugunu  Dogrulayiniz

  Scenario: TC02_Sayfada  3 Buton gorunur olmalı




  Scenario: TC03_Sayfada new Tab butonu tiklanabilir olmalı
    And Kulanici acilan sekmede Browser windows basligini tiklar
    Then Kullanici new Tab butonunun tiklanabilir oldugunu dogrular
    Then Kullanici new Window Message butonunun tiklanabilir oldugunu dogrular
    Then Kullanici new Window butonunun tiklanabilir oldugunu dogrular


  Scenario: TC06_New Tab Butonu ile yeni Tab acilmali
    And Kulanici acilan sekmede Browser windows basligini tiklar
    And kullanici new Tab butonunu tiklar
    Then Kullanici yeni bir tab acidligini dogrular


  Scenario: TC07_New Window butonu yeni bir pencere acmali
    And Kulanici acilan sekmede Browser windows basligini tiklar
    And kullanici new Window butonunu tiklar
    Then Kullanici yeni bir Pencere acidligini dogrular


  Scenario: TC08_New Window Message butonu yeni bir pencere acmali
    And Kulanici acilan sekmede Browser windows basligini tiklar
    And kullanici new Window Message butonunu tiklar
    Then Kullanici yeni bir Pencere de mesaji dogrular

    Scenario: TC_10ilk "click me" butonuna tiklandiginda alert hemen açilmali
    And Kulanici acilan sekmede Alerts basligini tiklar
    And Kullanici ilk alertme butonuna tiklar
    Then Kullanici alert uzerinde mesaji dogrular
    Then Kullanici alert uzerinde tamam butonunun tiklanabilir oldugunu dogrular



  Scenario: TC_11_ikinci "click me" butonuna tiklandiginda alert 5sn sonra acilmali
    And Kulanici acilan sekmede Alerts basligini tiklar
    And Kullanici ikinci alertme butonuna tiklar
    Then Kullanici alertte 5sn sonra mesajin gorundugunu dogrular




  Scenario: TC_12_ucuncu click me butonunda tamam islemi

    And Kulanici acilan sekmede Alerts basligini tiklar
    And Kullanici ucuncu alertme butonuna tiklar
    Then tamam butonunu tiklar
    Then tamam secildiginde selected ok yazisini dogrular


  Scenario: TC_13_ucuncu click me butonunda iptal islemi
    And Kulanici acilan sekmede Alerts basligini tiklar
    And Kullanici ucuncu alertme butonuna tiklar
    Then iptal butonunu tiklar
    Then iptal secildiginde selected cancelyazisini dogrular

  Scenario: TC_14_dorduncu click me

    And Kulanici acilan sekmede Alerts basligini tiklar
    And Kullanici dorduncu alertme butonuna tiklar
    When Kullanici textboxa mesaj yazar
    And Kullanici alertte tamam butonunu tiklar
    Then Kullanici mesajin goruntulendigini dogrular


  Scenario:TC_15_Frames bolumunde gecisler yapilabilir olmali
    And Kulanici acilan sekmede Frames basligini tiklar
    Then Kullanici Frame ler arası gecis olabidigini dogrular


  Scenario:TC_15_Frames bolumunde arası parent-child  olmali
    And Kulanici acilan sekmede Nested Frames basligini tiklar

    Then Kullanici Frame ler arası parent-child iliskisini dogrular



  Scenario:TC_17_Sayfada small ve Large  modal butonlari tiklanabilir olmalı

    And Kulanici acilan sekmede Modal Dialogs basligini tiklar
    Then Kullanici small butonunun tiklanabilir oldugunu dogrular
    Then Kullanici Large modal butonunun tiklanabilir oldugunu dogrular


  Scenario:TC_18_Small modal Butonu ile Small modal Diyalog penceresi acilmali
    And Kulanici acilan sekmede Modal Dialogs basligini tiklar
    And kullanici Small modal butonunu tiklar
    Then Kullanici yeni bir small modal acildigini dogrular
    Then kullanici small close butonunun enable oldugunu dogrular


  Scenario:TC_19
    And Kulanici acilan sekmede Modal Dialogs basligini tiklar
    And kullanici Large modal butonunu tiklar
    Then kullanici Yeni Bir Genis Model Diyalog Acildigini Dogrular
    Then kullanici large close butonunun enable oldugunu dogrular

  Scenario: TC_20
    And Kulanici acilan sekmede Modal Dialogs basligini tiklar
    And kullanici Large modal butonunu tiklar
    And kullanici "message" ı goruntuler:
      """
    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
      """


  Scenario: TC_21
    And Kulanici acilan sekmede Modal Dialogs basligini tiklar
    And kullanici Large modal butonunu tiklar
    And kullanici goruntuler
    """
    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
      """
