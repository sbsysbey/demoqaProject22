@gor

Feature:TextBox

  Background:
    Given demoqa anasayfaya gidin
    Then elements butonuna basiniz
    And textbox butonuna tiklayiniz
  Scenario:tc01

    And Fullname giriniz
    And email giriniz
    And adres1 giriniz
    And adres2 giriniz
    And submit butonuna tiklayin
    And giris isleminin tamamlandigini dogrulayin

   Scenario Outline:
      And Name  giriniz "<isim>"
      And email giriniz "<email>"
      And currentadres giriniz "<adresa>"
     And PermanentAdres giriniz "<adresb>"
     And submit butonuna tiklayin
     Then isim onaylandigini dogrulayiniz "<isim>"
     Then mail onaylandigini dogrulayiniz "<email>"
     Then currentadres onaylandigini dogrulayiniz "<adresa>"
     Then  permanentadres onaylandigini dogrulayiniz "<adresb>"
     Examples:
       | isim   | email           | adresa  | adresb     |
       | ahmet  | sa@gmail.com    | adresim | yeni adres |
       | rahmi  | rahmi@gmail.com | adres2  | aslan      |
       | nermin | mes@gmail.com   | adres3  | kaplan     |
       | melik  | as@gmail.com    | 12345   | kedi       |
       | said   | der@gmail.com   | adres5  | 2345       |

  Scenario Outline:tc04
       And Name  giriniz "<isim>"
       And email giriniz "<email>"
       And currentadres giriniz "<adresa>"
       And PermanentAdres giriniz "<adresb>"
       And submit butonuna tiklayin
           Then mail onaylanmadigini dogrulayiniz "<email>"

       Examples:
         | isim   | email      | adresa  | adresb     |
         | 12345  | sa@gmail   | adresim | yeni adres |
         | rahmi  | rahmi      | adres2  | aslan      |
         | nermin | mes@gmail  | adres3  | kaplan     |
         | melik  | gmail.com  | 12345   | kedi       |
         | said   | @gmail.com | adres5  | 2345       |