Feature: Book Store Application Sign-in Feature

  Background:
    Given demoqa anasayfaya gidin
    And kullanici Book Store Application' a tiklar
    And kullanici login butonuna tiklar

  Scenario:Tc01 Login
    When kullanici New User butonuna tiklar
    And kullanici "firstName" "lastName" "userName" "password" alanlarini doldurur
    And kullanici ben bir robot degilim checkBox'ini tiklar
    Then kullanici register butonuna tiklar
    Then kullanici back to login butonuna tiklar

  Scenario:TC_02 Book store
    When kullanici valid UserName ve Password bilgilerini girer
    When Kullanici login butonuna tiklar
   # When Kullanici gotoBookStore butonuna tiklar
    When Kullanici search butonunda kitap "Media" aratir
    Then Kullanici "Media" kitabin bulundugunu dogrular


  Scenario Outline:TC_03 Book store outline
    When kullanici valid UserName ve Password bilgilerini girer
    When Kullanici login butonuna tiklar
    When Kullanici search butonunda kitap "<kelime>" aratir
    Then Kullanici "<kelime>" kitabin bulundugunu dogrular
    And Kullanici logout yapar
    Examples:
      | kelime           |
      | Git Pocket Guide |
      | Addy Osmani      |
      | Press            |
      | Media            |



  Scenario:Tc04
      When kullanici valid UserName ve Password bilgilerini girer
      When Kullanici login butonuna tiklar
     # When Kullanici gotoBookStore butonuna tiklar
      When Kullanici kitabin bilgilerine tiklar "Git Pocket Guide"
    Then kitabin bilgilerinidogrular
      | Sub Title              | Total Pages | ISBN          | Title            | Author               | Publisher      |
      | A Working Introduction | 234         | 9781449325862 | Git Pocket Guide | Richard E. Silverman | O'Reilly Media |


  Scenario:TC_05
    When kullanici valid UserName ve Password bilgilerini girer
    When Kullanici login butonuna tiklar
    When Kullanici search butonunda kitap "Git Pocket Guide" aratir
    Then Kullanici "Git Pocket Guide" kitabin bulundugunu dogrular
    When Kullanici kitabin bilgilerine tiklar
    When Kullanici bilgilere tikladiktan sonra addtoyourcollectiona tiklar
    Then Kullanici profile bilgilerinde "Git Pocket Guide" kitabin eklendigini dogrular
    When Kullanici bookstore tablosundaki row sayisini "10" olarak secer
    Then Kullanici bookstore sayfasindaki row sayisini dogrular "10"
       # When Kullanici profile butonuna tiklar
    Then Kullanici kitap adiyla "Git Pocket Guide" yazar adini "Richard E. Silverman" eslestigini dogrular