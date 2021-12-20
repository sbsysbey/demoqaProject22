package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;



import org.openqa.selenium.interactions.Actions;
import pages.US16_SlidersPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US16_SlidersStepDefinitions {
    US16_SlidersPage slidersPage=new US16_SlidersPage();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Kullanici silders butonunu tiklar")
    public void kullanici_silders_butonunu_tiklar() {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        slidersPage.sliderLink.click();
    }
    @Then("Kulanici sliderin saga kaydirabilecegini dogrular")
    public void kulanici_sliderin_saga_kaydirabilecegini_dogrular() {



        ReusableMethods.setSliderBall(slidersPage.sliderBall,0,50);
        ReusableMethods.waitFor(6);
        Assert.assertTrue(slidersPage.sliderBall.getAttribute("value").equals("50"));
    }

    @Then("Kulanici sliderin sola kaydirabilecegini dogrular")
    public void kulanici_sliderin_sola_kaydirabilecegini_dogrular() {


        ReusableMethods.setSliderBall(slidersPage.sliderBall,50,0);
        ReusableMethods.waitFor(6);
        Assert.assertTrue(slidersPage.sliderBall.getAttribute("value").equals("0"));

    }

    @Then("Kulanici sliderin en saga kaydirabilecegini dogrular")
    public void kulanici_sliderin_en_saga_kaydirabilecegini_dogrular() {
        actions.dragAndDropBy(slidersPage.sliderBall, 70, 0).perform();
        ReusableMethods.setSliderBall(slidersPage.sliderBall,20,30);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(slidersPage.sliderBall.getAttribute("value").equals("30"));

    }
    @Then("Kulanici sliderin  en sola kaydirabilecegini dogrular")
    public void kulanici_sliderin_en_sola_kaydirabilecegini_dogrular() {
        ReusableMethods.waitFor(5);
        ReusableMethods.setSliderBall(slidersPage.sliderBall,30,0);
        ReusableMethods.waitFor(5);
        Assert.assertTrue(slidersPage.sliderBall.getAttribute("value").equals("0"));
    }



    @Then("Kulanici sliderin once sola sonra saga kaydirabilecegini dogrular")
    public void kulanici_sliderin_once_sola_sonra_saga_kaydirabilecegini_dogrular() {
        ReusableMethods.setSliderBall(slidersPage.sliderBall,0,30);

        ReusableMethods.waitFor(5);


        Assert.assertTrue(slidersPage.sliderBall.getAttribute("value").equals("30"));

    }



}



