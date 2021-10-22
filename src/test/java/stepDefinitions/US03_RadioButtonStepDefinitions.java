package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US03_RadioButtonPage;
import utilities.Driver;

public class US03_RadioButtonStepDefinitions {

    US03_RadioButtonPage radioButtonPage = new US03_RadioButtonPage();
    Actions actions = new Actions(Driver.getDriver());





    @Then("radiobox butonuna tiklayiniz")
    public void radiobox_butonuna_tiklayiniz() {
      radioButtonPage.radioButtonMenuLink.click();
    }




    @Then("yes Buttonunu tiklayiniz")
    public void yes_buttonunu_tiklayiniz() {
      radioButtonPage.yes.click();
    }
    @Then("Yes secildigini dogrulayiniz")
    public void yes_secildigini_dogrulayiniz() {
        Assert.assertTrue(radioButtonPage.yesYaziyiDogrulama.getText().contains("Yes"));
        System.out.println(radioButtonPage.yesYaziyiDogrulama.getText());
    }


    @Given("Impresive butonuna tiklayiniz")
    public void impresive_butonuna_tiklayiniz() {
radioButtonPage.impressive.click();
    }

    @Then("İmpersive yazisini dogrulayiniz")
    public void i̇mpersive_yazisini_dogrulayiniz() {
        Assert.assertTrue(radioButtonPage.yesYaziyiDogrulama.getText().contains("Impressive"));
        System.out.println(radioButtonPage.yesYaziyiDogrulama.getText());
    }
    @Then("Yes butonunun secili olmadigini dogrulayin")
    public void yes_butonunun_secili_olmadigini_dogrulayin() {
Assert.assertFalse(radioButtonPage.yes.isSelected());
    }
    @Then("No butonunu seciniz")
    public void no_butonunu_seciniz() {
radioButtonPage.noButton.click();
    }
    @Then("No butonunun secildigini  dogrulayiniz")
    public void no_butonunun_secildigini_dogrulayiniz() {
       if (radioButtonPage.noButton.isEnabled()){
           System.out.println("işlem tamam");
       }else {
           System.out.println("burada bug car No butonu kullanılamıyor");
       }
    }
}
