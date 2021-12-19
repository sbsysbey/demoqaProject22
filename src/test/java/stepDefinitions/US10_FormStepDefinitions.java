package stepDefinitions;

import com.github.javafaker.Faker;

import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import pages.US10_FormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static utilities.ReusableMethods.getElementsText;


public class US10_FormStepDefinitions {
    US10_FormPage formsPage = new US10_FormPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker fake = new Faker();

    @Given("forms bolumunu acin")
    public void formsBolumunuAcin() {
        formsPage.formSection.click();
    }


    @And("Practise Forms bolumunu tiklayin")
    public void practiseFormsBolumunuTiklayin() {

        formsPage.practiseForm.click();
    }

    @And("FirstName yaziniz  {string}")
    public void firstnameYaziniz(String fakeisim) {
        if (fakeisim == "") {
            System.out.println("isim bos bırakılamaz");
            formsPage.firstName.sendKeys(fakeisim);
        } else {
            fakeisim = fake.name().firstName();
            formsPage.firstName.sendKeys(fakeisim);
        }
    }

    @And("LastName yaziniz  {string}")
    public void lastnameYaziniz(String fakeSoyisim) {
        if (fakeSoyisim == "") {
            System.out.println("soyisim bos bırakılamaz");
            formsPage.lastName.sendKeys(fakeSoyisim);
        } else {
            fakeSoyisim = fake.name().firstName();
            formsPage.lastName.sendKeys(fakeSoyisim);
        }
    }


    @And("Email giriniz {string}")
    public void emailGiriniz(String mail) {
        if (mail.equals("@eksik")) {
            mail = fake.name().firstName() + fake.name().lastName().toLowerCase(Locale.ROOT) + ".com";
        } else if (mail.equals(".eksik")) {
            mail = fake.name().firstName() + fake.name().lastName() + "@com";
        } else {
            mail = fake.internet().emailAddress();
        }
        formsPage.userEmail.sendKeys(mail);
    }

    @And("cinsiyet seciniz {string}")
    public void cinsiyetSeciniz(String cins) {
        String gender;
        if (cins.equals("female")) {
            gender = "female";
        } else if (cins.equals("male")) {
            gender = "male";
        } else if (cins.equals("other")) {
            gender = "other";
        } else {
            gender = fake.dog().gender();
        }

        System.out.println(gender);
        if (gender.equals("male")) {
            formsPage.genderRadio1.click();
        } else if (gender.equals("female")) {
            formsPage.genderRadio2.click();
        } else {
            formsPage.genderRadio3.click();
        }
    }


    @And("valid telefon giriniz {string}")
    public void validTelefonGiriniz(String telefon) {
        String tel = "";
        if (telefon.equals("valid")) {
            tel = fake.number().digits(10);
        } else if (telefon.equals("eksik")) {
            tel = fake.number().digits(9);

        } else if (telefon.equals("harfli")) {
            tel = fake.number().digits(9) + "s";

        }
        formsPage.userNumber.sendKeys(tel);
    }


    @And("valid dogum tarihi giriniz {string}")
    public void validDogumTarihiGiriniz(String dogum) {
        formsPage.dateOfBirthInput.click();
        formsPage.dateOfBirthInput.clear();


        Select dropdownAy = new Select(formsPage.selectAy);

        String aylar[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int ay = fake.number().numberBetween(1, 12);
        dropdownAy.selectByIndex(ay);


        int yil = fake.number().numberBetween(1950, 2020);

        Select dropdownYil = new Select(formsPage.selectYil);
        dropdownYil.selectByValue(String.valueOf(yil));
        // dropdown.selectByVisibleText("Programmer ");
        // int gun=fake.number().numberBetween(1,30);

        Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker')])[" + fake.number().numberBetween(28, 76) + "]")).click();


        // formsPage.dateOfBirthInput.sendKeys(Keys.ENTER);

    }

    @And("subject Giriniz")
    public void subjectGiriniz() {
        formsPage.subjectsContainer.click();
        ReusableMethods.waitFor(1);

        formsPage.subjectsContainer.sendKeys("m");
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        formsPage.subjectsContainer.sendKeys("s");
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        formsPage.subjectsContainer.sendKeys("e");
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
    }

    @And("Hobby seciniz {int}")
    public void hobbySeciniz(int arg0) {

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        formsPage.sportCheckbox1.click();
        formsPage.readingCheckbox2.click();
    }

    @And("Resim seciniz")
    public void resimSeciniz() {

        formsPage.uploadPicture.sendKeys("C:/Users/MRN/Pictures/mesaj.png");
    }

    @And("Current Adres giriniz")
    public void currentAdresGiriniz() {

        formsPage.currentAddress.sendKeys(fake.address().fullAddress());
    }

    @And("State seciniz")
    public void stateSeciniz() {

        formsPage.state.sendKeys("NCR" + Keys.ENTER);

    }

    @And("City seciniz")
    public void citySeciniz() {

        formsPage.city.sendKeys("Delhi" + Keys.ENTER);

    }

    @Then("Submiti Tiklayin")
    public void submitiTiklayin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        formsPage.submit.click();
    }

    @Then("Onaylandigini dogrulayin")
    public void onaylandiginiDogrulayin() {

        Assert.assertTrue(formsPage.sonucBaslik.getText().equals("Thanks for submitting the form"));

    }

    @Then("First Name bos Birakilamayacagini dogrulayin")
    public void firstNameBosBirakilamayacaginiDogrulayin() {

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String colorfirstName = formsPage.firstName.getCssValue("border-color");
        System.out.println(colorfirstName);

        String colorHex = Color.fromString(colorfirstName).asHex();
        System.out.println("firstName: " + colorHex);
        Assert.assertEquals(colorHex, "#dc3545");
    }

    @Then("Kullanici acilan sayfada Student Registration Form oldugunu dogrular.")
    public void kullaniciAcilanSayfadaStudentRegistrationFormOldugunuDogrular() {
        System.out.println(formsPage.baslikdogrulama.getText());
        Assert.assertTrue(formsPage.baslikdogrulama.getText().equals("Student Registration Form"));
    }

    @Then("LastName bos Birakilamayacagini dogrulayin")
    public void lastnameBosBirakilamayacaginiDogrulayin() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String colorLastName = formsPage.lastName.getCssValue("border-color");
        System.out.println(colorLastName);

        String colorHex = Color.fromString(colorLastName).asHex();
        System.out.println("LastName: " + colorHex);
        Assert.assertEquals(colorHex, "#dc3545");
    }

    @Then("cinsiyette birden fazla secim yapilamadigini dogrulayin")
    public void cinsiyetteBirdenFazlaSecimYapilamadiginiDogrulayin() {
        if (formsPage.genderRadio1.isSelected()) {
            Assert.assertFalse(formsPage.genderRadio2.isSelected());
            Assert.assertFalse(formsPage.genderRadio3.isSelected());
        } else if (formsPage.genderRadio2.isSelected()) {
            Assert.assertFalse(formsPage.genderRadio1.isSelected());
            Assert.assertFalse(formsPage.genderRadio3.isSelected());
        } else if (formsPage.genderRadio3.isSelected()) {
            Assert.assertFalse(formsPage.genderRadio1.isSelected());
            Assert.assertFalse(formsPage.genderRadio2.isSelected());
        }

    }


    @Then("email at olmadan kabul edilmedigini dogrulayin")
    public void emailAtOlmadanKabulEdilmediginiDogrulayin() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String colormail = formsPage.userEmail.getCssValue("border-color");
        String colorHex = Color.fromString(colormail).asHex();
        System.out.println("ateksilmail : " + colorHex);
        Assert.assertEquals(colorHex, "#dc3545");


    }

    @Then("email nokta olmadan kabul edilmedigini dogrulayin")
    public void emailNoktaOlmadanKabulEdilmediginiDogrulayin() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String colormail = formsPage.userEmail.getCssValue("border-color");
        String colorHex = Color.fromString(colormail).asHex();
        System.out.println("mail: " + colorHex);
        Assert.assertEquals(colorHex, "#dc3545");

    }

    @And("emaili temizleyin")
    public void emailiTemizleyin() {
        ReusableMethods.waitFor(3);
        formsPage.userEmail.clear();
    }

    @Then("Tel on hane  olmadan kabul edilmedigini dogrulayin")
    public void telOnHaneOlmadanKabulEdilmediginiDogrulayin() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String colortel = formsPage.userNumber.getCssValue("border-color");
        String colorHex = Color.fromString(colortel).asHex();
        System.out.println("tel: " + colorHex);
        Assert.assertEquals(colorHex, "#dc3545");


    }

    @And("tel bolumunu temizleyin")
    public void telBolumunuTemizleyin() {
        ReusableMethods.waitFor(1);
        formsPage.userNumber.clear();
        ReusableMethods.waitFor(1);
    }

    @And("gelecek Yili dogum tarihi giriniz")
    public void gelecekYiliDogumTarihiGiriniz() {

        DateFormat sdf = new SimpleDateFormat("dd MMM YYYY");
        int tarih = new java.util.Date().getYear();
        System.out.println(sdf.format(tarih));

        formsPage.dateOfBirthInput.click();
        formsPage.dateOfBirthInput.clear();

        Select dropdownAy = new Select(formsPage.selectAy);
        dropdownAy.selectByValue("4");


        int yil = fake.number().numberBetween(2022, 2030);

        Select dropdownYil = new Select(formsPage.selectYil);
        dropdownYil.selectByValue(String.valueOf(yil));

        Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker')])[" + fake.number().numberBetween(28, 76) + "]")).click();


        // formsPage.dateOfBirthInput.sendKeys(Keys.ENTER);

    }

    @Then("tarih gunumuzden ileride secilemedigini dogrulayin")
    public void tarihGunumuzdenIlerideSecilemediginiDogrulayin() {
        DateFormat sdf = new SimpleDateFormat("dd MMM YYYY");
        Date tarih = new java.util.Date();
        System.out.println(sdf.format(tarih));
        String bugunkutarihStr = sdf.format(tarih).toString();
        String bugunkutarih = bugunkutarihStr.substring(bugunkutarihStr.length() - 4);
        String gelenDogumTarihi = formsPage.birtDaySonuc.getText();

        String girilenTarih = gelenDogumTarihi.substring(gelenDogumTarihi.length() - 4);

        System.out.println(bugunkutarih + "  :   " + girilenTarih);
        int bugunkuYilInt = Integer.parseInt(bugunkutarih);
        int gelenyilInt = Integer.parseInt(girilenTarih);
        if (bugunkuYilInt == gelenyilInt) {
            System.out.println("tarih bugünle aynı");
        } else if (bugunkuYilInt < gelenyilInt) {
            System.out.println("dogum günü gelecekte olamaz");
        } else {
            System.out.println("hersey normal");
        }

    }


    @Then("yeniden Dene")
    public void yenidenDene() throws ParseException {


        Date tarih = new java.util.Date();

        DateFormat dateFormat = new SimpleDateFormat("dd MMM,yyyy");
        Date bugunkuTarihdate = new Date();


        System.out.println(dateFormat.format(bugunkuTarihdate));


        String gelenDogumTarihi = formsPage.birtDaySonuc.getText();
        System.out.println(gelenDogumTarihi);
        DateFormat df = new SimpleDateFormat("dd MMM,yyyy");

        Date gelenTarihDate = df.parse(gelenDogumTarihi);

        System.out.println("oldu?:    " + gelenTarihDate);
        System.out.println(dateFormat.format(gelenTarihDate));

        int eng = gelenTarihDate.compareTo(bugunkuTarihdate);
        System.out.println(eng);

        if (eng == 0) {
            System.out.println("tarih bugünle aynı");
        } else if (eng == 1) {
            System.out.println("dogum günü gelecekte olamaz");
        } else {
            System.out.println("hersey normal");
        }
    }


    @Then("Ayni anda birden fazla subject girilebildigini dogrulayin")
    public void ayniAndaBirdenFazlaSubjectGirilebildiginiDogrulayin() {


        List<String> list = new ArrayList<String>();
        String str = formsPage.subjectSonuc.getText();
        String[] arrStr = str.split(",");
        for (String el : arrStr)
            list.add(el);

        System.out.println(list);
        System.out.println(list.size());
        Assert.assertTrue(list.size() > 2);
    }


    @Then("Subjet bolumunde otomatik tamamlamayi dogrulayin")
    public void subjetBolumundeOtomatikTamamlamayiDogrulayin() {
        System.out.println(formsPage.subjectSonuc.getText());
        Assert.assertTrue(formsPage.subjectSonuc.getText().contains("Physics"));

    }

    @And("tum hobbyleri secin")
    public void tumHobbyleriSecin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        formsPage.sportCheckbox1.click();
        formsPage.readingCheckbox2.click();
        formsPage.musicCheckbox.click();


    }


    @Then("Hobbies bolumunde secme serbestiyeti")
    public void hobbiesBolumundeSecmeSerbestiyeti() {
        System.out.println(formsPage.hobbiesSonuc.getText());
        Assert.assertTrue(formsPage.hobbiesSonuc.getText().contains("Sports"));
        Assert.assertTrue(formsPage.hobbiesSonuc.getText().contains("Reading"));
        Assert.assertTrue(formsPage.hobbiesSonuc.getText().contains("Music"));
    }

    @And("birden fazla giris yapilabildigini dogrulayin")
    public void birdenFazlaGirisYapilabildiginiDogrulayin() {
        List<String> bolumler = getElementsText(By.xpath("//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']"));
        System.out.println("bolumler=:" + bolumler);

        System.out.println(bolumler.size());
        Assert.assertTrue(bolumler.size() > 2);

    }


    @Then("resmin secildigini dogrulayiniz")
    public void resminSecildiginiDogrulayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println(formsPage.dosyaSecSonuc.getText());
        Assert.assertTrue(formsPage.dosyaSecSonuc.getText().equals("mesaj.png"));

    }

    @And("Current Adres sadece rakam giriniz")
    public void currentAdresSadeceRakamGiriniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        formsPage.currentAddress.sendKeys("123456789");
    }


    @And("Current Adres sadece harf giriniz")
    public void currentAdresSadeceHarfGiriniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        formsPage.currentAddress.sendKeys("sssssssssssssssssssssssss");
    }

    @And("Current Adrese ozel karakterler giriniz")
    public void currentAdreseOzelKarakterlerGiriniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        formsPage.currentAddress.sendKeys("^+%&/@{[]}()=?_?=)(:ÇÖ>");
    }

    @And("state Tiklayiniz")
    public void stateTiklayiniz() {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        formsPage.state.sendKeys("C");
    }

    @Then("state isimlerinin gorundugunu dogrulayiniz")
    public void stateIsimlerininGorundugunuDogrulayiniz() {
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        System.out.println(formsPage.stateTik.getText());
        Assert.assertTrue(formsPage.stateTik.getText().equals("NCR"));

        ReusableMethods.waitFor(2);
        formsPage.state.sendKeys("J");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        System.out.println(formsPage.stateTik.getText());
        Assert.assertTrue(formsPage.stateTik.getText().equals("Rajasthan"));
    }


    @And("city Tiklayiniz")
    public void cityTiklayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        formsPage.state.sendKeys("h");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        System.out.println(formsPage.stateTik.getText());


        ReusableMethods.waitFor(1);
    }

    @Then("city isimlerinin gorundugunu dogrulayiniz")
    public void cityIsimlerininGorundugunuDogrulayiniz() {
        formsPage.city.sendKeys("K");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
        System.out.println(formsPage.cityTik.getText());
        Assert.assertTrue(formsPage.cityTik.getText().equals("Karnal"));
    }
}