package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US14_dataPicker_maplePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class US15_Widgets_DataPicker_StepDefinitions {
    US14_dataPicker_maplePage datePicker = new US14_dataPicker_maplePage();

    Actions actions = new Actions(Driver.getDriver());
    String girilenYil = "";
    String girilenGun = "0";
    String ay;
    int gun = 0;




    @And("Kullanici Yil girer {string}")
    public void kullaniciYilGirer(String arg0) {
        girilenYil = arg0;
        Select dropdownYil = new Select(datePicker.selectYil);
        dropdownYil.selectByValue(arg0);
    }

    @And("Kullanici Ayi girer {int}")
    public void kullaniciAyiGirer(int arg0) {
        ay = String.valueOf(arg0);
        System.out.println(ay);
        Select dropdownAy = new Select(datePicker.selectAy);
        arg0 = arg0 - 1;
        dropdownAy.selectByIndex(arg0);
    }

    @And("Kullanici Ay girer  {string}")
    public void kullaniciAyGirer(String arg0) {
        ay = String.valueOf(arg0);
        Select dropdownAy = new Select(datePicker.selectAy);
        dropdownAy.selectByVisibleText(arg0);
    }


    @Then("dogru tarih oldugunu test eder")
    public void dogruTarihOldugunuTestEder() {
        System.out.println("gelen tarih: " + datePicker.tarihsonuc.getAttribute("value"));
        Assert.assertTrue(datePicker.tarihsonuc.getAttribute("value").equals(ay + "/" + girilenGun + "/" + girilenYil));
    }


    @Then("Kullanici İleri tarihi kabul etmedigini dogrular")
    public void kullaniciİleriTarihiKabulEtmediginiDogrular() throws ParseException {
        Date d1, d2;
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        System.out.println("gelen tarih: " + datePicker.tarihsonuc.getAttribute("value"));
        LocalDate tarih = LocalDate.now();


        d1 = simpleDateFormat.parse(datePicker.tarihsonuc.getAttribute("value"));
        d2 = simpleDateFormat.parse(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(tarih));
        System.out.println("gelen: " + d1);
        System.out.println("bugun: " + d2);

        //-------------------------------------------------------------------


        if (d1.compareTo(d2) > 0) {

            // d1 > d2 ise çalıştır
            System.out.println("gelen tarih bugünden ilerdedir");
        } else if (d1.compareTo(d2) < 0) {

            // d1 < d2 ise çalışır.
            System.out.println(" Gelen Tarih bugünden geridedir");
        } else if (d1.compareTo(d2) == 0) {

            // iki tarih eşitse çalışır.
            System.out.println("Gelen Tarih bugündür");
        }

        //-------------------------------------------------------------------------------
        Assert.assertTrue("tarih ilerde olmaz", d1.compareTo(d2) < 0);


    }


    // Zamanlı Bolum


    @And("Kullanici gun secer {int}")
    public void kullaniciGunSecer(int arg0) {
        ReusableMethods.waitFor(1);
        datePicker.getGun(arg0).click();
        //System.out.println();
        for (int i = 1; i < 8; i++) {
            ReusableMethods.waitFor(1);

            //  WebElement takvimgunu = Driver.getDriver().findElement(By.xpath(" (//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (i) + "]"));
            WebElement takvimgunu =datePicker.getGun(i);

            if (takvimgunu.getText().equals("1")) {
                int belligun = arg0;
                //  actions.click(Driver.getDriver().findElement(By.xpath(" (//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (i + belligun - 1) + "]"))).perform();
                datePicker.getGun((i + belligun - 1)).click();

                ReusableMethods.waitFor(1);
                break;
            } else {
                continue;
            }
        }

    }
    @And("Kullanici Gun secer {string}")
    public void kullaniciGunSecer(String gun) {
        for (int i = 1; i < 8; i++) {
            ReusableMethods.waitFor(1);
            WebElement takvimgunu = datePicker.getGun(i);
            if (takvimgunu.getText().equals("1")) {
                int belligun = Integer.parseInt(gun);
                datePicker.getGun((i + belligun - 1)).click();
                ReusableMethods.waitFor(1);
                break;
            } else {
                continue;
            }
        }


    }

    @And("Kullanici zaman bolumunu temizler")
    public void kullaniciZamanBolumunuTemizler() {
        ReusableMethods.waitFor(2);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.BACK_SPACE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);
        datePicker.zamansecme2.sendKeys(Keys.DELETE);


        ReusableMethods.waitFor(3);
    }


    @Then("Kontrol eder")
    public void kontrolEder() {
        ReusableMethods.setSliderBall(Driver.getDriver().findElement(By.xpath("//div[@class='react-datepicker__time']")), 5, 12);
    }

    @Then("Kullanici zaman gonderir {string}")
    public void kullaniciZamanGonderir(String tarih) {

        datePicker.zamansecme2.sendKeys(tarih);

        ReusableMethods.waitFor(3);
        datePicker.zamansecme2.click();
        datePicker.bosclick.click();


    }



    @Then("Kullanici dogru zaman oldugunu test eder {string},<{int}>,<{int}>,{string}")
    public void kullaniciDogruZamanOldugunuTestEder(String arg0, int arg1, int arg2, String arg3) {



        String a=datePicker.zamanSonuc.getAttribute("value");
        String[] gelenbol = a.split(" ");
        Calendar gelenDate = Calendar.getInstance();
        gelenDate.set(Calendar.YEAR, Integer.parseInt(gelenbol[2]));
        gelenDate.set(Calendar.MONTH, Month.valueOf(gelenbol[0].toUpperCase()).getValue()-1);
        gelenDate.set(Calendar.DATE, Integer.parseInt(gelenbol[1].substring(0,2)));
        gelenDate.set(Calendar.HOUR,Integer.parseInt(gelenbol[3].split(":")[0]));
        gelenDate.set(Calendar.MINUTE,Integer.parseInt(gelenbol[3].split(":")[1]));
        java.util.Date gelentarih = gelenDate.getTime();
        System.out.println("gelentarih = "+gelentarih);


        String[] bol = arg3.split(":");
        Calendar girilenDate = Calendar.getInstance();
        girilenDate.set(Calendar.YEAR, Integer.parseInt(arg0));
        girilenDate.set(Calendar.MONTH, arg1-1);
        girilenDate.set(Calendar.DATE, arg2);

        girilenDate.set(Calendar.HOUR,Integer.parseInt(bol[0]));
        girilenDate.set(Calendar.MINUTE,Integer.parseInt(bol[1]));
        java.util.Date girilenTarih = girilenDate.getTime();
        System.out.println("girilen tarih = "+girilenTarih);
        System.out.println("Date  aynı mı? " + gelentarih.equals(girilenTarih));
        Assert.assertTrue(girilenTarih.compareTo(gelentarih)==0);



    }


}

