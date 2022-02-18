package demoqa.stepDefinitions;

import com.github.javafaker.Faker;
import demoqa.pages.us20_BookstoreApplication_SigninPage;
import demoqa.utilities.ConfigReader;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class us20_BookstoreApplication_SigninStep {


    us20_BookstoreApplication_SigninPage bookStore = new us20_BookstoreApplication_SigninPage();
    Actions actions=new Actions(Driver.getDriver());
    @Given("kullanici Book Store Application' a tiklar")
    public void kullanici_book_store_application_a_tiklar() {
        ReusableMethods.jsClick(bookStore.bookStoreApplication);
    }

    @When("kullanici New User butonuna tiklar")
    public void kullanici_new_user_butonuna_tiklar() {
        ReusableMethods.jsClick(bookStore.newUserButton);
    }

    @When("kullanici {string} {string} {string} {string} alanlarini doldurur")
    public void kullanici_alanlarini_doldurur(String firstName, String lastName, String userName, String password) {
        Faker faker=new Faker();
        bookStore.firstName.sendKeys(faker.name().firstName());
        bookStore.lastName.sendKeys(faker.name().lastName());
        bookStore.userName.sendKeys(ConfigReader.getProperty("bookStoreUserName"));
        bookStore.password.sendKeys(ConfigReader.getProperty("bookStorePassword"));
    }

    @When("kullanici ben bir robot degilim checkBox'ini tiklar")
    public void kullanici_ben_bir_robot_degilim_check_box_ini_tiklar() throws InterruptedException {
       ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(bookStore.captchaIframe);
        Thread.sleep(5000);
        bookStore.notRobotCheckBox.click();
        ReusableMethods.waitFor(1);
    }

    @Then("kullanici register butonuna tiklar")
    public void kullanici_register_butonuna_tiklar() {
        Driver.getDriver().switchTo().defaultContent();
ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(bookStore.registerButton);

    }

    @Then("kullanici back to login butonuna tiklar")
    public void kullanici_back_to_login_butonuna_tiklar() {
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.jsClick(bookStore.backToLoginButton);
    }
    @Given("kullanici login butonuna tiklar")
    public void kullanici_login_butonuna_tiklar() {


        ReusableMethods.jsClick(bookStore.loginButton);
    }
    @When("kullanici valid UserName ve Password bilgilerini girer")
    public void kullanici_valid_user_name_ve_password_bilgilerini_girer() {
        bookStore.userName.sendKeys(ConfigReader.getProperty("bookStoreUserName"));
        bookStore.password.sendKeys(ConfigReader.getProperty("bookStorePassword"));
    }
    @When("Kullanici login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        ReusableMethods.waitFor(1);
        bookStore.loginButton.click();
    }
    @When("Kullanici gotoBookStore butonuna tiklar")
    public void kullaniciGotoBookStoreButonunaTiklar() {

        bookStore.goToBookStore.click();
    }
    @When("Kullanici search butonunda kitap {string} aratir")
    public void kullaniciSearchButonundaKitapAratir(String arg0) {
        ReusableMethods.waitFor(1);
        bookStore.searchBox.sendKeys(arg0);
    }
    @Then("Kullanici {string} kitabin bulundugunu dogrular")
    public void kullaniciKitabinBulundugunuDogrular(String arg0) {
        ReusableMethods.waitFor(1);
        SoftAssert softAssert=new SoftAssert();

        List<String> filtreliListe = ReusableMethods.getElementsText(bookStore.filtrelihepsi);
        List<String> bosListesi = ReusableMethods.getElementsText(bookStore.bosSatirlar);

        if (bosListesi.size() < 40) {
            List<String> ilkKitap = filtreliListe.subList(0,3);
            System.out.println("Birinci Kitap: " + ilkKitap);
            softAssert.assertTrue(ilkKitap.contains(arg0));
        }

        if (bosListesi.size() < 36) {
            List<String> ikinciKitap = filtreliListe.subList(3,6);
            System.out.println("İkinci Kitap: " + ikinciKitap);
            softAssert.assertTrue(ikinciKitap.contains(arg0));
        }

        if (bosListesi.size() < 32) {
            List<String> ucuncuiKitap = filtreliListe.subList(6,9);
            System.out.println("Üçüncü Kitap: " + ucuncuiKitap);
            softAssert.assertTrue(ucuncuiKitap.contains(arg0));
        }

        if (bosListesi.size() < 28) {
            List<String> dorduncuKitap = filtreliListe.subList(9,12);
            System.out.println("Dördüncü Kitap: " + dorduncuKitap);
            softAssert.assertTrue(dorduncuKitap.contains(arg0));
        }

        if (bosListesi.size() < 24) {
            List<String> besinciKitap = filtreliListe.subList(12,15);
            System.out.println("Besinci Kitap: " + besinciKitap);
            softAssert.assertTrue(besinciKitap.contains(arg0));
        }
        if (bosListesi.size() < 20) {
            List<String> altinciKitap = filtreliListe.subList(15,18);
            System.out.println("Altinci Kitap: " + altinciKitap);
            softAssert.assertTrue(altinciKitap.contains(arg0));
        }
        if (bosListesi.size() < 16) {
            List<String> yedincKitap = filtreliListe.subList(18,21);
            System.out.println("Yedinci Kitap: " + yedincKitap);
            softAssert.assertTrue(yedincKitap.contains(arg0));
        }
        if (bosListesi.size() < 12) {
            List<String> sekizinciKitap = filtreliListe.subList(21,24);
            System.out.println("Sekizinci Kitap: " + sekizinciKitap);
            softAssert.assertTrue(sekizinciKitap.contains(arg0));
        }
        if (bosListesi.size() < 8) {
            List<String> dokuzuncuKitap = filtreliListe.subList(24,27);
            System.out.println("Dokuzuncu Kitap: " + dokuzuncuKitap);
            softAssert.assertTrue(dokuzuncuKitap.contains(arg0));
        }

        if (bosListesi.size() < 4) {
            List<String> onuncuKitap = filtreliListe.subList(27,30);
            System.out.println("onuncu Kitap: " + onuncuKitap);
            softAssert.assertTrue(onuncuKitap.contains(arg0));
        }
    }

    @When("Kullanici kitabin bilgilerine tiklar {string}")
    public void kullaniciKitabinBilgilerineTiklar(String arg0) {
        ReusableMethods.waitFor(1);
        bookStore.getKitap(arg0).click();
    }

    @When("Kullanici kitabin bilgilerine tiklar")
    public void kullaniciKitabinBilgilerineTiklar() {
        bookStore.bookNameSearchResult.click();

    }


    @When("Kullanici bilgilere tikladiktan sonra addtoyourcollectiona tiklar")
    public void kullaniciBilgilereTikladiktanSonraAddtoyourcollectionaTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        bookStore.addtoYourCollection.click();
        //actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Kullanici profile bilgilerinde {string} kitabin eklendigini dogrular")
    public void kullaniciProfileBilgilerindeKitabinEklendiginiDogrular(String arg0) {
        bookStore.Profile.click();
        Assert.assertTrue(bookStore.getKitap(arg0).isDisplayed());
    }


    @When("Kullanici bookstore tablosundaki row sayisini {string} olarak secer")
    public void kullaniciBookstoreTablosundakiRowSayisiniOlarakSecer(String arg0) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select options = new Select(bookStore.rowSelectMenu);
        ReusableMethods.waitFor(1);
        options.selectByValue(arg0);
    }


    @Then("Kullanici bookstore sayfasindaki row sayisini dogrular {string}")
    public void kullaniciBookstoreSayfasindakiRowSayisiniDogrular(String arg0) {
        String rowCount=String.valueOf(bookStore.allRowsList.size());

        System.out.println(rowCount);
        Assert.assertEquals(rowCount,arg0);


    }


 /*   @When("Kullanici profile butonuna tiklar")
    public void kullaniciProfileButonunaTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bookStore.Profile.click();
    }*/

    @Then("Kullanici kitap adiyla {string} yazar adini {string} eslestigini dogrular")
    public void kullaniciKitapAdiylaYazarAdiniEslestiginiDogrular(String arg0, String arg1) {
        SoftAssert softAssert=new SoftAssert();
        actions.sendKeys(Keys.PAGE_UP).perform();
        softAssert.assertTrue(bookStore.ilkKitapIsmi.getText().equals(arg0));
        softAssert.assertTrue(bookStore.ilkYazarIsmi.getText().equals(arg1));


        softAssert.assertAll();
    }







    @And("Kullanici logout yapar")
    public void kullaniciLogoutYapar() {
        bookStore.logout.click();


    }

    @Then("kitabin bilgilerinidogrular")
    public void kitabinBilgilerinidogrular(List<Map<String,String>> dataTable){
        List<String> kitapBilgiList=ReusableMethods.getElementsText(bookStore.kitapOzalikleri);

        Map<String,String> kitapBilgiler=new HashMap<>();

        for (int i = 0; i <12; i++) {

            kitapBilgiler.put(kitapBilgiList.get(i).substring(0,kitapBilgiList.get(i).length()-2),kitapBilgiList.get(i+1));
            i++;
        }

      for(Map<String, String>map:dataTable){
          System.out.println("map        : "+map);
          System.out.println("kitap bilgi: "+kitapBilgiler);

          Assert.assertTrue(map.equals(kitapBilgiler));




       }
        }}




