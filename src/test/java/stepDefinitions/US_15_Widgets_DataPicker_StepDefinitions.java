package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US_15_Widgets_DataPickerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class US_15_Widgets_DataPicker_StepDefinitions {

    US_15_Widgets_DataPickerPage dataPickers = new US_15_Widgets_DataPickerPage();
    Actions actions = new Actions(Driver.getDriver());
   String girilenYil="";
   String   girilenGun = "0";
    String ay;
int gun=0;

    @And("kullanici dataPicker sekmesini acar")
    public void kullaniciWidgetsSekmesiniAcar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        dataPickers.dataPickerSekmesi.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);

    }




    @And("Kullanici Yil girer {string}")
    public void kullaniciYilGirer(String arg0) {
        girilenYil=arg0;
        Select dropdownYil = new Select(dataPickers.selectYil);
        dropdownYil.selectByValue(arg0);
    }

    @And("Kullanici Ayi girer {int}")
    public void kullaniciAyiGirer(int arg0) {
        ay=String.valueOf(arg0);
        System.out.println(ay);
        Select dropdownAy = new Select(dataPickers.selectAy);
        arg0 = arg0 - 1;
        dropdownAy.selectByIndex(arg0);
    }

    @And("Kullanici Gunu secer {string}")
    public void kullaniciGunuSecer(String arg0) {

        String ilkGunText = dataPickers.dateilkGun.getText();
        String s_ay = dataPickers.selectAy.getAttribute("value");

        if (s_ay.equals("4") || s_ay.equals("6") || s_ay.equals("9") || s_ay.equals("11")) {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 6;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 5;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 3;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) + 2;
            } else if (ilkGunText.equals("30")) {
                gun = Integer.parseInt(arg0) + 1;
            } else {
                gun = Integer.parseInt(arg0);
            }
        } else if (s_ay.equals("3")) {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 3;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 2;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 1;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) + 1;
            } else if (ilkGunText.equals("1")) {
                gun = Integer.parseInt(arg0);
            }

        } else {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 7;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 6;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 5;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) +3;
            } else if (ilkGunText.equals("30")) {
                gun = Integer.parseInt(arg0) +2;
            } else if (ilkGunText.equals("31")) {
                gun = Integer.parseInt(arg0) + 1;
            }else {
                gun = Integer.parseInt(arg0);
            }
        }

        Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + gun + "]")).click();
    }

    @Then("dogru tarih oldugunu test ediniz")
    public void dogruTarihOldugunuTestEdiniz() {
        System.out.println("gelen tarih: " + dataPickers.tarihsonuc.getAttribute("value"));

    }


    @Then("Kullanici İleri tarihi kabul etmedigini dogrular")
    public void kullaniciİleriTarihiKabulEtmediginiDogrular() throws ParseException {
        Date d1, d2;
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        System.out.println("gelen tarih: " + dataPickers.tarihsonuc.getAttribute("value"));
        LocalDate tarih = LocalDate.now();
        //   System.out.println("Bugnün tarihi: "+DateTimeFormatter.ofPattern("MM/dd/yyyy").format(tarih));

        d1 = simpleDateFormat.parse(dataPickers.tarihsonuc.getAttribute("value"));
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

    @And("Kullanici zamanbox i tiklar tiklar")
    public void kullaniciZamanboxITiklarTiklar() {
        dataPickers.zamansecme2.click();


    }


    @And("Kullanici zaman olumune Yil girer {string}")
    public void kullaniciZamanOlumuneYilGirer(String arg0) {

        Select dropdownzamanYil = new Select(dataPickers.selectZamanYil);
        dropdownzamanYil.selectByValue(arg0);


    }

    @And("Kullanicizaman olumune Ayi girer {int}")
    public void kullanicizamanOlumuneAyiGirer(int arg0) {
        dataPickers.selectZamanAy.click();
        actions.sendKeys(Keys.DOWN).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.DOWN).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).click().perform();
        ReusableMethods.waitFor(2);
    }


    @And("Kullanici Ay girer  {string}")
    public void kullaniciAyGirer(String arg0) {
        ay=String.valueOf(arg0);
        Select dropdownAy = new Select(dataPickers.selectAy);
        dropdownAy.selectByVisibleText(arg0);
    }

    @And("Kullanici Gun secer {string}")
    public void kullaniciGunSecer(String arg0) {
girilenGun=arg0;
        String ilkGunText = dataPickers.dateilkGun.getText();
        String s_ay = dataPickers.selectAy.getAttribute("value");
        System.out.println(s_ay);
        if (s_ay.equals("4") || s_ay.equals("6") || s_ay.equals("9") || s_ay.equals("11")) {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 6;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 5;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 3;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) + 2;
            } else if (ilkGunText.equals("30")) {
                gun = Integer.parseInt(arg0) + 1;
            } else {
                gun = Integer.parseInt(arg0);
            }
        }  else if (s_ay.equals("2")) {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 3;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 2;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 1;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) + 1;
            } else if (ilkGunText.equals("1")) {
                gun = Integer.parseInt(arg0);
            }

        } else {
            if (ilkGunText.equals("25")) {
                gun = Integer.parseInt(arg0) + 7;
            } else if (ilkGunText.equals("26")) {
                gun = Integer.parseInt(arg0) + 6;
            } else if (ilkGunText.equals("27")) {
                gun = Integer.parseInt(arg0) + 5;
            } else if (ilkGunText.equals("28")) {
                gun = Integer.parseInt(arg0) + 4;
            } else if (ilkGunText.equals("29")) {
                gun = Integer.parseInt(arg0) +3;
            } else if (ilkGunText.equals("30")) {
                gun = Integer.parseInt(arg0) + 2;
            }else if (ilkGunText.equals("31")) {
                    gun = Integer.parseInt(arg0) + 1;
                }else {
                    gun = Integer.parseInt(arg0);
                }
        }
        System.out.println("girilen Tarih: "+ay+"/"+girilenGun+"/"+girilenYil);
        System.out.println(girilenYil);
        System.out.println(ay);
        Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + gun + "]")).click();
    }

}

