package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.US_14_dataPicker_maplePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class US_14_dataPicker_mapleStepDefinitions {
    US_14_dataPicker_maplePage datePicker = new US_14_dataPicker_maplePage();
    Actions actions = new Actions(Driver.getDriver());
    String expectedYear, expectedDay, expectedMonth;

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

        Select dropdownYil = new Select(datePicker.selectYil);
        dropdownYil.selectByVisibleText(yil);

        int ayindexi = Integer.parseInt(ay) - 1;
        Select dropdownAy = new Select(datePicker.selectAy);
        dropdownAy.selectByIndex(ayindexi);
        ReusableMethods.waitFor(3);

        for (int i = 1; i < 8; i++) {
            ReusableMethods.waitFor(1);

            WebElement takvimgunu = Driver.getDriver().findElement(By.xpath(" (//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (i) + "]"));
            if (takvimgunu.getText().equals("1")) {
                int belligun = Integer.parseInt(gun);
                actions.click(Driver.getDriver().findElement(By.xpath(" (//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (i + belligun - 1) + "]"))).perform();
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


}