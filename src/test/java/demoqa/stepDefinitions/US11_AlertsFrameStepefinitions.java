package demoqa.stepDefinitions;


import demoqa.pages.US11_AlertsFramePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import demoqa.utilities.ConfigReader;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;


import java.util.ArrayList;

import java.util.List;


public class US11_AlertsFrameStepefinitions {
    US11_AlertsFramePage alertsFrame = new US11_AlertsFramePage();
    Actions actions = new Actions(Driver.getDriver());




    @And("Kulanici Alerts, Frame & Windows accordionunu tiklar")
    public void kulaniciAlertsFrameWindowsAccordionunuTiklar() {
             alertsFrame.alertSection.click();

    }

    @And("Kulanici acilan sekmede Browser windows basligini tiklar")
    public void kulaniciAcilanSekmedeBrowserWindowsBasliginiTiklar() {
             alertsFrame.browserWindowsSekmesi.click();
    }


    @Then("Kullanici new Tab butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciNewTabButonununTiklanabilirOldugunuDogrular() {
        Assert.assertTrue(alertsFrame.tabButton.isEnabled());

    }

    @Then("Kullanici new Window Message butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciNewWindowMessageButonununTiklanabilirOldugunuDogrular() {
        Assert.assertTrue(alertsFrame.windowButton.isEnabled());
           }

    @Then("Kullanici new Window butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciNewWindowButonununTiklanabilirOldugunuDogrular() {
        Assert.assertTrue(alertsFrame.messageWindowButton.isEnabled());
    }

    @And("kullanici new Tab butonunu tiklar")
    public void kullaniciNewTabButonunuTiklar() {
        alertsFrame.tabButton.click();
    }


    @Then("Kullanici yeni bir tab acidligini dogrular")
    public void kullaniciYeniBirTabAcidliginiDogrular() {
        ArrayList tabs = new ArrayList (Driver.getDriver().getWindowHandles());

        System.out.println(Driver.getDriver().getCurrentUrl());
        Driver.getDriver().switchTo().window((String) tabs.get(1));

        System.out.println(Driver.getDriver().getCurrentUrl());
        System.out.println(ConfigReader.getProperty("newTabText"));
        System.out.println(alertsFrame.newTabText.getText());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://demoqa.com/sample"));
        Assert.assertTrue(alertsFrame.newTabText.getText().equals(ConfigReader.getProperty("newTabText")));


        Driver.getDriver().switchTo().window((String) tabs.get(1)).close();
        Driver.getDriver().switchTo().window((String) tabs.get(0));

    }

    @And("kullanici new Window butonunu tiklar")
    public void kullaniciNewWindowButonunuTiklar() {
        alertsFrame.windowButton.click();
    }

    @Then("Kullanici yeni bir Pencere acidligini dogrular")
    public void kullaniciYeniBirPencereAcidliginiDogrular() {
        /*String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                ReusableMethods.switchToWindow(windowHandle);
                System.out.println(Driver.getDriver().getCurrentUrl());
                System.out.println(ConfigReader.getProperty("newTabText"));
                System.out.println(alertsFrame.newTabText.getText());
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://demoqa.com/sample"));
                Assert.assertTrue(alertsFrame.newTabText.getText().equals(ConfigReader.getProperty("newTabText")));

                Driver.getDriver().close(); //closing child window
              Driver.getDriver().switchTo().window(parentWindow); //cntrl to parent window
            }
        }*/
        ArrayList tabs = new ArrayList (Driver.getDriver().getWindowHandles());

        System.out.println(Driver.getDriver().getCurrentUrl());
        Driver.getDriver().switchTo().window((String) tabs.get(1));

        System.out.println(Driver.getDriver().getCurrentUrl());
        System.out.println(ConfigReader.getProperty("newTabText"));
        System.out.println(alertsFrame.newTabText.getText());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://demoqa.com/sample"));
        Assert.assertTrue(alertsFrame.newTabText.getText().equals(ConfigReader.getProperty("newTabText")));
    }

    @And("kullanici new Window Message butonunu tiklar")
    public void kullaniciNewWindowMessageButonunuTiklar() {
        alertsFrame.messageWindowButton.click();
    }

    @Then("Kullanici yeni bir Pencere de mesaji dogrular")
    public void kullaniciYeniBirPencereDeMesajiDogrular() {

        List tabs = new ArrayList (Driver.getDriver().getWindowHandles());
        System.out.println(tabs.get(0));

        Driver.getDriver().switchTo().window((String) tabs.get(0));

        System.out.println(alertsFrame.messagText.getText());
        //  ReusableMethods.switchToWindow((String) tabs.get(1));
    }



    @Then("Kullanici yeni bir Pencere de mesaji goruntuler")
    public void kullaniciYeniBirPencereDeMesajiGoruntuler() {
        ArrayList tabs = new ArrayList (Driver.getDriver().getWindowHandles());

        System.out.println(Driver.getDriver().getCurrentUrl());
        Driver.getDriver().switchTo().window((String) tabs.get(1));

        System.out.println(Driver.getDriver().getCurrentUrl());
        System.out.println(ConfigReader.getProperty("newTabText"));
        System.out.println(alertsFrame.newTabText.getText());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://demoqa.com/sample"));
        Assert.assertTrue(alertsFrame.newTabText.getText().equals(ConfigReader.getProperty("newTabText")));


        Driver.getDriver().switchTo().window((String) tabs.get(1)).close();
        Driver.getDriver().switchTo().window((String) tabs.get(0));
    }

    @And("Kulanici acilan sekmede Alerts basligini tiklar")
    public void kulaniciAcilanSekmedeAlertsBasliginiTiklar() {

         alertsFrame.Alertssekmesi.click();
    }

      @And("Kullanici ilk alertme butonuna tiklar")
    public void kullaniciIlkAlertmeButonunaTiklar() {
     alertsFrame.alertbirinciclikcme.click();
    }

    @Then("Kullanici alert uzerinde mesaji dogrular")
    public void kullaniciAlertUzerindeMesajiDogrular() {
       // Alert a = Driver.getDriver().switchTo().alert();
        String s= Driver.getDriver().switchTo().alert().getText();
        System.out.println(s);

        Assert.assertTrue(s.equals("You clicked a button"));

    }

    @Then("Kullanici alert uzerinde tamam butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciAlertUzerindeTamamButonununTiklanabilirOldugunuDogrular() {
        ReusableMethods.waitFor(3);
Driver.getDriver().switchTo().alert().accept();

    }

    @And("Kullanici ikinci alertme butonuna tiklar")
    public void kullaniciIkinciAlertmeButonunaTiklar() {
        alertsFrame.alertikinciclickme.click();
    }


    @Then("Kullanici alertte {int}sn sonra mesajin gorundugunu dogrular")
    public void kullaniciAlertteSnSonraMesajinGorundugunuDogrular(int arg0) {
        ReusableMethods.waitFor(6);
        Alert b= Driver.getDriver().switchTo().alert();
        String gecikenMesaj= Driver.getDriver().switchTo().alert().getText();
        System.out.println(gecikenMesaj);
        b.accept();
        Assert.assertTrue(gecikenMesaj.equals("This alert appeared after 5 seconds"));

    }

    @And("Kullanici ucuncu alertme butonuna tiklar")
    public void kullaniciUcuncuAlertmeButonunaTiklar() {
        alertsFrame.alertucuncuclikcme.click();

    }

    @Then("Kullanici alertte onay ve iptal butonlarinin gorundugunu dogrular")
    public void kullaniciAlertteOnayVeIptalButonlarininGorundugunuDogrular() {
        ReusableMethods.waitFor(1);
        Alert c= Driver.getDriver().switchTo().alert();
        String onayMesaj= Driver.getDriver().switchTo().alert().getText();
        System.out.println(onayMesaj);
        Assert.assertTrue(onayMesaj.equals("Do you confirm action?"));


    }

    @Then("tamam butonunu tiklar")
    public void tamamButonunuTiklar() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().accept();
    }
    @Then("tamam secildiginde selected ok yazisini dogrular")
    public void tamamSecildigindeSelectedOkYazisiniDogrular() {
         System.out.println(alertsFrame.sonucYazisi.getText());
        Assert.assertTrue(alertsFrame.sonucYazisi.getText().equals("You selected Ok"));

    }

    @Then("iptal butonunu tiklar")
    public void iptalButonunuTiklar() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().dismiss();

    }

@Then("iptal secildiginde selected cancelyazisini dogrular")
    public void iptalSecildigindeSelectedCancelyazisiniDogrular() {
        System.out.println(alertsFrame.sonucYazisi.getText());
        Assert.assertTrue(alertsFrame.sonucYazisi.getText().equals("You selected Cancel"));
    }

    @And("Kullanici dorduncu alertme butonuna tiklar")
    public void kullaniciDorduncuAlertmeButonunaTiklar() {
        alertsFrame.alertdorduncuclickme.click();
    }

    @When("Kullanici textboxa mesaj yazar")
    public void kullaniciTextboxaMesajYazar() {

        Driver.getDriver().switchTo().alert().sendKeys(ConfigReader.getProperty("promptIsmi"));
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici alertte tamam butonunu tiklar")
    public void kullaniciAlertteTamamButonunuTiklar() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Kullanici mesajin goruntulendigini dogrular")
    public void kullaniciMesajinGoruntulendiginiDogrular() {
        System.out.println("You entered "+ConfigReader.getProperty("promptIsmi"));
        System.out.println(alertsFrame.promptResult.getText());
        Assert.assertTrue(alertsFrame.promptResult.getText().equals("You entered "+ConfigReader.getProperty("promptIsmi")));
    }

    @And("Kulanici acilan sekmede Frames basligini tiklar")
    public void kulaniciAcilanSekmedeFramesBasliginiTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        alertsFrame.framesSekmesi.click();
    }
    @Given("Kulanici acilan sekmede Nested Frames basligini tiklar")
    public void kulanici_acilan_sekmede_nested_frames_basligini_tiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        alertsFrame.nestedFramesSekmesi.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Then("Kullanici Frame ler arası gecis olabidigini dogrular")
    public void kullaniciFrameLerArasıGecisOlabidiginiDogrular() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
       Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("frame2")));

      String message1=alertsFrame.newTabText.getText();
        System.out.println("frame2:"+alertsFrame.newTabText.getText());
        Driver.getDriver().switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_UP).perform();

       Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("frame1")));
        ReusableMethods.waitFor(1);
        String message2=alertsFrame.newTabText.getText();
        System.out.println("frame1:"+alertsFrame.newTabText.getText());
        Assert.assertTrue(message1.equals(message2));
    }

    @Then("Kullanici Frame ler arası parent-child iliskisini dogrular")
    public void kullaniciFrameLerArasıParentChildIliskisiniDogrular() {

        ReusableMethods.waitFor(1);
       // Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("frame1")));
        Driver.getDriver().switchTo().frame("frame1");
        String message1=alertsFrame.messagText.getText();
        System.out.println("frame1:"+message1);
     //   Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.tagName("iframe")));

      //  Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("frame2")));
        ReusableMethods.waitFor(1);
        String message2=alertsFrame.messagText.getText();
        System.out.println("frame2:"+message2);
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(message1.equals("Parent frame"));
        softAssert.assertTrue(message2.equals("Child Iframe"));

        Driver.getDriver().switchTo().parentFrame();

        String messagedeneme=alertsFrame.messagText.getText();
        System.out.println("frame1:"+message1);
         softAssert.assertAll();
    }

    @And("Kulanici acilan sekmede Modal Dialogs basligini tiklar")
    public void kulaniciAcilanSekmedeModalDialogsBasliginiTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        alertsFrame.ModalDialogSekmesi.click();
    }


    @Then("Kullanici small butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciSmallButonununTiklanabilirOldugunuDogrular() {

     Assert.assertTrue(alertsFrame.showSmallModal.isEnabled());

    }


    @Then("Kullanici Large modal butonunun tiklanabilir oldugunu dogrular")
    public void kullaniciLargeModalButonununTiklanabilirOldugunuDogrular() {
        Assert.assertTrue(alertsFrame.showSmallModal.isEnabled());
    }

    @And("kullanici Small modal butonunu tiklar")
    public void kullaniciSmallModalButonunuTiklar() {
          alertsFrame.showSmallModal.click();
    }

    @And("kullanici Large modal butonunu tiklar")
    public void kullaniciLargeModalButonunuTiklar() {
        alertsFrame.showLargeModal.click();
    }

    @Then("kullanici large close butonunun enable oldugunu dogrular")
    public void kullaniciLargeCloseButonununEnableoLdugunuDogrular() {

        Assert.assertTrue(alertsFrame.closeLargeModal.isEnabled());
    }

    @Then("kullanici small close butonunun enable oldugunu dogrular")
    public void kullaniciSmallCloseButonununEnableoLdugunuDogrular() {
        Assert.assertTrue(alertsFrame.closeSmallModal.isEnabled());
    }
    @Then("Kullanici yeni bir small modal acildigini dogrular")
    public void kullaniciYeniBirSmallModalAcildiginiDogrular() {
        System.out.println(alertsFrame.small_LargeModaltext.getText());
        Assert.assertTrue(alertsFrame.small_LargeModaltext.getText().equals("This is a small modal. It has very less content"));
    }

    @Then("kullanici Yeni Bir Genis Model Diyalog Acildigini Dogrular")
    public void kullaniciYeniBirGenisModelDiyalogAcildiginiDogrular() {
        System.out.println(alertsFrame.small_LargeModaltext.getText());
        Assert.assertTrue(alertsFrame.small_LargeModaltext.getText()
                .equals("Lorem Ipsum is simply dummy text of the printing and" +
                        " typesetting industry. Lorem Ipsum has been the industry's " +
                        "standard dummy text ever since the 1500s, when an unknown printer " +
                        "took a galley of type and scrambled it to make a type specimen book." +
                        " It has survived not only five centuries, but also the leap into electronic " +
                        "typesetting, remaining essentially unchanged. It was popularised in the " +
                        "1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                        " and more recently with desktop publishing software like Aldus PageMaker " +
                        "including versions of Lorem Ipsum."));
    }


    @And("kullanici {string} ı goruntuler:")
    public void kullaniciIGoruntuler(String arg0,String uzunmesaj) {

        System.out.println(arg0);
        System.out.println(uzunmesaj);
        System.out.println(alertsFrame.small_LargeModaltext.getText());
Assert.assertTrue(alertsFrame.small_LargeModaltext.getText().equals(uzunmesaj));

    }


    @And("kullanici goruntuler")
    public void kullaniciGoruntuler(String a) {


        System.out.println(a);
        System.out.println(alertsFrame.small_LargeModaltext.getText());
        Assert.assertTrue(alertsFrame.small_LargeModaltext.getText().equals(a));
    }
}




