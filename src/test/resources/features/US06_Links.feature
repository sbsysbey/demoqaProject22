Feature: US06_Links

  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And Links butonuna basiniz


  Scenario: TC_01_Home
    And Home butonuna tiklayin
   Then Yeni bir sekme de anasayfa acildigini dogrulayiniz
    And HomeEur butonuna tiklayin
    Then Yeni bir sekme de anasayfa acildigini dogrulayiniz

  Scenario: TC_03_CREATED
    And Created butonuna tiklayin
    Then yazinin "Created" ve "201" icerdigini dogrulayiniz


 # Scenario: TC_04_No_Content
    And No Content butonuna tiklayin
    Then yazinin "No Content" ve "204" icerdigini dogrulayiniz

  #Scenario: TC_05_Moved
    And Moved butonuna tiklayin
    Then yazinin "Moved Permanently" ve "301" icerdigini dogrulayiniz

  #Scenario: TC_06_Bad_Request
    And Bad Request butonuna tiklayin
    Then yazinin "Bad Request" ve "400" icerdigini dogrulayiniz

 # Scenario: TC_07_Unauthorized
    And Unauthorized butonuna tiklayin
    Then yazinin "Unauthorized" ve "401" icerdigini dogrulayiniz

  #Scenario: TC_08_Forbidden
    And Forbidden butonuna tiklayin
    Then yazinin "Forbidden" ve "403" icerdigini dogrulayiniz




  #Scenario: TC_09_Not Found
    And Not Found butonuna tiklayin
    Then yazinin "Not Found" ve "404" icerdigini dogrulayiniz


  #Scenario: TC_10_TITLE

    Then "link" yazisinin gorunurlugunu  Dogrulayiniz