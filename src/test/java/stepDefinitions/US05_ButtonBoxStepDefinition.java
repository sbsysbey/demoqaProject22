package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.interactions.Actions;
import pages.US04_WebTablesPage;
import pages.US05_ButtonBoxPage;
import utilities.Driver;

public class US05_ButtonBoxStepDefinition {
    US05_ButtonBoxPage uS05_ButtonBoxPage = new US05_ButtonBoxPage();
    Actions actions = new Actions(Driver.getDriver());


    @And("Buttons butonuna basiniz")
    public void buttonsButonunaBasiniz() {
uS05_ButtonBoxPage.button.click();


    }

    @And("double click me butonuna basiniz")
    public void doubleClickMeButonunaBasiniz() {
    }

    @And("basildigini dogrulayiniz")
    public void basildiginiDogrulayiniz() {
    }


    }

