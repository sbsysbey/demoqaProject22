package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.US14_dataPicker_maplePage;
import pages.US15_Widgets_DataPickerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.ParseException;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class US14_dataPicker_mapleStepDefinitions {
    US14_dataPicker_maplePage datePicker = new US14_dataPicker_maplePage();

    @And("kullanici dataPicker sekmesini acar")
    public void kullaniciWidgetsSekmesiniAcar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        datePicker.dataPickerSekmesi.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);

    }

    Actions actions = new Actions(Driver.getDriver());
    String expectedYear, expectedDay, expectedMonth;
    US15_Widgets_DataPickerPage dataPickers = new US15_Widgets_DataPickerPage();
    JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();
    // Scenario: TC_01
    @Given("Kullanici YIL,AY,GUN secer")
    public void kullanici_yil_ay_gun_secer(List<Map<String, String>> dateTable) {
        for (Map<String, String> map : dateTable) {
            Select selectYear = new Select(datePicker.selectYil);
            selectYear.selectByValue(map.get("Year"));
            Select selectMonth = new Select(datePicker.selectAy);
            selectMonth.selectByVisibleText(map.get("Month"));
            String month = map.get("Month");
            expectedYear = map.get("Year");
            List<WebElement> days = null;
            switch (month.toLowerCase()) {
                case "january":
                    days = datePicker.january;
                    expectedMonth = "01";
                    break;
                case "february":
                    days = datePicker.february;
                    expectedMonth = "02";
                    break;
                case "march":
                    days = datePicker.march;
                    expectedMonth = "03";
                    break;
                case "april":
                    days = datePicker.april;
                    expectedMonth = "04";
                    break;
                case "may":
                    days = datePicker.may;
                    expectedMonth = "05";
                    break;
                case "june":
                    days = datePicker.june;
                    expectedMonth = "06";
                    break;
                case "july":
                    days = datePicker.july;
                    expectedMonth = "07";
                    break;
                case "august":
                    days = datePicker.august;
                    expectedMonth = "08";
                    break;
                case "september":
                    days = datePicker.september;
                    expectedMonth = "09";
                    break;
                case "october":
                    days = datePicker.october;
                    expectedMonth = "10";
                    break;
                case "november":
                    days = datePicker.november;
                    expectedMonth = "11";
                    break;
                case "december":
                    days = datePicker.december;
                    expectedMonth = "12";
                    break;
            }
            for (WebElement day : days) {
                ReusableMethods.waitFor(2);
                if ((day.getText()).equals(map.get("Day"))) {
                    expectedDay = day.getText();
                    ReusableMethods.waitFor(2);
                    actions.click(day).perform();
                    break;
                }
            }
        }
    }

    @Then("Kullanici date and time secilebildigini dogrular")
    public void kullaniciDateAndTimeSecilebildiginiDogrular() {
        System.out.println(expectedMonth + "/" + expectedDay + "/" + expectedYear);
        System.out.println(datePicker.dataPickerSekmesi.getAttribute("value"));
        Assert.assertEquals(expectedMonth + "/" + expectedDay + "/" + expectedYear, datePicker.dataPickerSekmesi.getAttribute("value"));
    }


    @And("Kullanici takvimi tiklar")
    public void kullaniciTakvimiTiklar() {

        datePicker.tarihsecme1.click();
    }

    @And("Kullanici {string},{string},{string} girer")
    public void kullaniciGirer(String yil, String ay, String gun) {
        // Yıl seçme
        Select dropdownYil = new Select(datePicker.selectYil);
        dropdownYil.selectByVisibleText(yil);
        // ay seçme
        int ayindexi = Integer.parseInt(ay) - 1;
        Select dropdownAy = new Select(datePicker.selectAy);
        dropdownAy.selectByIndex(ayindexi);
        ReusableMethods.waitFor(1);
        // Gun seçme
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


    @And("Kullanici {string},{string},{string} girdiginin sonucunu dogrular")
    public void kullaniciGirdigininSonucunuDogrular(String yil, String ay, String gun) {
        String verilengun = ay + "/" + gun + "/" + yil;
        System.out.println("verilengun:  " + ay + "/" + gun + "/" + yil);

        System.out.println("gelen tarih: " + datePicker.tarihsonuc.getAttribute("value"));
        System.out.println("-----------------------------------------------------------");
        Assert.assertTrue(datePicker.tarihsonuc.getAttribute("value").equals(verilengun));
    }


    //TC_03 Saatli Bölüm

    @And("Kullanici zamanbox i tiklar tiklar")
    public void kullaniciZamanboxITiklarTiklar() {
        datePicker.zamansecme2.click();
    }


    @And("Kullanici zaman bolumune Yil girer {string}")
    public void kullaniciZamanBolumuneYilGirer(String arg0) {
        datePicker.selectZamanYil.click();

          Calendar calendar = Calendar.getInstance();
          int fark = calendar.get(calendar.YEAR) - Integer.parseInt(arg0);
         if (fark < 5 && fark > -5) {
            actions.click(datePicker.getYear(arg0)).perform();
        } else if (fark > 5) {

            jsx.executeScript("window.scrollBy(0,200)", "");
            for (int k = 1; k <= fark - 5; k++) {
                ReusableMethods.waitFor(1);
                actions.click(datePicker.yilGeriAlma).perform();
            }
            actions.click(datePicker.getYear(arg0)).perform();
        }

    }


    @And("Kullanici zaman bolumune Ayi girer {int}")
    public void kullaniciZamanBolumuneAyiGirer(int arg0) {
        jsx.executeScript("window.scrollBy(0,100)", "");
        datePicker.selectZamanAy.click();
        datePicker.getMonth(arg0).click();
    }

    @And("Kullanici zaman bolumune Gunu secer {int}")
    public void kullaniciZamanBolumuneGunuSecer(int gun) {
        ReusableMethods.waitFor(1);
        for (int m = 1; m < 8; m++) {
            ReusableMethods.waitFor(1);
            WebElement takvimgunu = datePicker.getGun(m);
            if (takvimgunu.getText().equals("1")) {
                int belligun = gun;
                datePicker.getGun((m + belligun - 1)).click();
                ReusableMethods.waitFor(1);
                break;
            } else {
                continue;
            }
        }
    }

    @And("Kullanici saati secer {string}")
    public void kullaniciSaatiSecer(String arg0) {
ReusableMethods.jsClick( datePicker.getSaat(arg0));

    }


    @Then("Kullanici dogru zaman oldugunu test eder {string},{string},{string},{string}")
    public void kullaniciDogruZamanOldugunuTestEder(String arg0, String arg1, String arg2, String arg3) throws ParseException {

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

        Calendar girilenDate = Calendar.getInstance();
        String[] bol = arg3.split(":");

        girilenDate.set(Calendar.YEAR, Integer.parseInt(arg0));
        girilenDate.set(Calendar.MONTH, Integer.parseInt(arg1)-1);
        girilenDate.set(Calendar.DATE, Integer.parseInt(arg2));
        girilenDate.set(Calendar.HOUR,Integer.parseInt(bol[0])+1);
        girilenDate.set(Calendar.MINUTE,Integer.parseInt(bol[1]));
        java.util.Date girilenTarih = girilenDate.getTime();

        System.out.println("girilen tarih = "+girilenTarih);

        System.out.println("Date  aynı mı? " + gelentarih.equals(girilenTarih));
        Assert.assertTrue(girilenTarih.compareTo(gelentarih)==0);
    }
}