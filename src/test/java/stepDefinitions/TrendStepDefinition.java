package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.TrendPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TrendStepDefinition {
    TrendPage trendPage = new TrendPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("trend yol anasayfaya git")
    public void trend_yol_anasayfaya_git() {
        Driver.getDriver().get(ConfigReader.getProperty("trend_url"));
    }


    @Then("{string} arattiriniz")
    public void arattiriniz(String shoe) {

        trendPage.searcbar.sendKeys(shoe);
        trendPage.searcbar.sendKeys(Keys.ENTER);

    }

    @And("ilk urunu tiklayin")
    public void ilkUrunuTiklayin() {
        trendPage.searcbar.sendKeys(Keys.ESCAPE);
        trendPage.ilkurun.click();
    }

    @And("sepete ekleyin")
    public void sepeteEkleyin() {

        trendPage.ilkurunnumara.click();
        trendPage.sepet.click();

    }

    @And("sepete gidin")
    public void sepeteGidin() {
trendPage.Warenkorb.click();

    }

    @Then("sepette urunun oldugunu dogrulayin")
    public void sepetteUrununOldugunuDogrulayin() {





    }
}
