Feature: US10_Form

  Background:
    Given demoqa anasayfaya gidin
    Given forms bolumunu acin
    And Practise Forms bolumunu tiklayin


  Scenario: TC_01

    Then Kullanici acilan sayfada Student Registration Form oldugunu dogrular.

  Scenario: TC02_Valid degerlerle dogrulama yapin


    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And Email giriniz "valid"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And valid dogum tarihi giriniz "valid"
    And subject Giriniz
    And Hobby seciniz 2
    And Resim seciniz

    And Current Adres giriniz
    And State seciniz
    And City seciniz
    Then Submiti Tiklayin
    Then Onaylandigini dogrulayin


  Scenario: TC03_ First Name bos Birakilamayacagini dogrulayin

    And FirstName yaziniz  ""
    And LastName yaziniz  ""
    And Email giriniz "valid"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And valid dogum tarihi giriniz "valid"
    And subject Giriniz
    And Hobby seciniz 2
    And Resim seciniz

    And Current Adres giriniz
    And State seciniz
    And City seciniz

    Then Submiti Tiklayin

    Then First Name bos Birakilamayacagini dogrulayin


  Scenario: TC04_ LastName bos Birakilamayacagini dogrulayin
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  ""
    And Email giriniz "valid"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And valid dogum tarihi giriniz "valid"
    And subject Giriniz
        And Hobby seciniz 2
    And Resim seciniz
    And Current Adres giriniz
    And State seciniz
    And City seciniz
    And Submiti Tiklayin
    Then LastName bos Birakilamayacagini dogrulayin


  Scenario: TC05_cinsiyet secimlerinin birden fazla yapilamamasi
    And cinsiyet seciniz "male"
    Then cinsiyette birden fazla secim yapilamadigini dogrulayin
    And cinsiyet seciniz "female"
    Then cinsiyette birden fazla secim yapilamadigini dogrulayin
    And cinsiyet seciniz "other"
    Then cinsiyette birden fazla secim yapilamadigini dogrulayin

  Scenario: TC06_mail at ve nokta  icermelidir

    And Email giriniz "@eksik"
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And valid dogum tarihi giriniz "valid"
    And subject Giriniz
    And Hobby seciniz 2
    And Resim seciniz
    And Current Adres giriniz
    And State seciniz
    And City seciniz
    And Submiti Tiklayin
    Then email at olmadan kabul edilmedigini dogrulayin
    And emaili temizleyin
    And Email giriniz ".eksik"
    And Submiti Tiklayin
    Then email nokta olmadan kabul edilmedigini dogrulayin

  Scenario: TC07_Telefon on haneli olmali
    And Email giriniz "Rastgele"
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "eksik"
    And valid dogum tarihi giriniz "valid"
    And subject Giriniz
    And Hobby seciniz 2
    And Resim seciniz
    And Current Adres giriniz
    And State seciniz
    And City seciniz
    And Submiti Tiklayin
    Then Tel on hane  olmadan kabul edilmedigini dogrulayin
    And tel bolumunu temizleyin
    And valid telefon giriniz "harfli"
    And Submiti Tiklayin
    Then Tel on hane  olmadan kabul edilmedigini dogrulayin

  Scenario: TC08_tarih gunumuzden ileride secilememelidir

    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And Email giriniz "Rastgele"
    And valid telefon giriniz "valid"
    And gelecek Yili dogum tarihi giriniz
    And subject Giriniz
    And Hobby seciniz 2
    And Resim seciniz
    And Current Adres giriniz
    And State seciniz
    And City seciniz
    And Submiti Tiklayin
    Then yeniden Dene
    Then tarih gunumuzden ileride secilemedigini dogrulayin


  Scenario: TC_09_Ayni anda birden fazla subject girilebilmeli
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    #And subject autocomplet
    And subject Giriniz
    And Submiti Tiklayin
    And birden fazla giris yapilabildigini dogrulayin


  Scenario: TC_10_Ayni anda birden fazla subject kabul edilmeli
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And subject Giriniz
    And Submiti Tiklayin
    Then Ayni anda birden fazla subject girilebildigini dogrulayin


  Scenario: TC_11_ Subjet bolumunde otomatik tamamlamayi

    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And subject Giriniz
    And Submiti Tiklayin
    Then Subjet bolumunde otomatik tamamlamayi dogrulayin

    Scenario: TC_12_Hobbies bolumunde secme serbestiyeti

      And FirstName yaziniz  "firstname"
      And LastName yaziniz  "lastName"
      And cinsiyet seciniz "rastgele"
      And valid telefon giriniz "valid"
      And tum hobbyleri secin
       And Submiti Tiklayin
      Then Hobbies bolumunde secme serbestiyeti

  Scenario: TC_13_Hobbies bolumunde secme serbestiyeti

    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And Resim seciniz
    And Submiti Tiklayin
    Then resmin secildigini dogrulayiniz

    Scenario:TC_14_Current Adresin sadece rakam kabul ettigini dogrulayin
      And FirstName yaziniz  "firstname"
      And LastName yaziniz  "lastName"
      And cinsiyet seciniz "rastgele"
      And valid telefon giriniz "valid"
      And Current Adres sadece rakam giriniz
      And Submiti Tiklayin
      Then Onaylandigini dogrulayin

  Scenario:TC_15_Current Adresin sadece harf kabul ettigini dogrulayin
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And Current Adres sadece harf giriniz
    And Submiti Tiklayin
    Then Onaylandigini dogrulayin


  Scenario:TC_16_Current Adresin ozel karakter kabul ettigini dogrulayin
    And FirstName yaziniz  "firstname"
    And LastName yaziniz  "lastName"
    And cinsiyet seciniz "rastgele"
    And valid telefon giriniz "valid"
    And Current Adrese ozel karakterler giriniz
    And Submiti Tiklayin
    Then Onaylandigini dogrulayin


  Scenario:TC_17_state isimleri tiklama ile gorulmeli
    And state Tiklayiniz
    And subject autocomplet
    Then state isimlerinin gorundugunu dogrulayiniz

  Scenario:TC_18_City isimleri tiklma ile gorulmeli

    And city Tiklayiniz
    Then city isimlerinin gorundugunu dogrulayiniz