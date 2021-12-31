package demoqa.stepDefinitions;

import demoqa.pages.US05_ButtonBoxPage;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

public class US05_ButtonBoxStepDefinition {
    US05_ButtonBoxPage uS05_ButtonBoxPage = new US05_ButtonBoxPage();
    Actions actions = new Actions(Driver.getDriver());


    @And("Buttons butonuna basiniz")
    public void buttonsButonunaBasiniz() {
uS05_ButtonBoxPage.button.click();


    }

    @And("double click me butonuna basiniz")
    public void doubleClickMeButonunaBasiniz() {
        ReusableMethods.waitFor(1);
       // actions.doubleClick(uS05_ButtonBoxPage.doubleClickMe);
       actions.doubleClick(uS05_ButtonBoxPage.doubleClickMe).perform();

        System.out.println(uS05_ButtonBoxPage.doubleClickMessage.getText());
    }

    @And("basildigini dogrulayiniz")
    public void basildiginiDogrulayiniz() {
        Assert.assertTrue(uS05_ButtonBoxPage.doubleClickMessage.getText().equals("You have done a double click"));

    }


    @And("right click me butonuna basiniz")
    public void rightClickMeButonunaBasiniz() {
        actions.contextClick(uS05_ButtonBoxPage.rightClickMe).perform();
        System.out.println(uS05_ButtonBoxPage.rightClickMessage.getText());
    }

    @And("right basildigini dogrulayiniz")
    public void rightBasildiginiDogrulayiniz() {
        Assert.assertTrue(uS05_ButtonBoxPage.rightClickMessage.getText().equals("You have done a right click"));

    }

    @And("click me butonuna basiniz")
    public void clickMeButonunaBasiniz() {
        actions.doubleClick(uS05_ButtonBoxPage.ClickMe).perform();
        System.out.println(uS05_ButtonBoxPage.dynamicClickMessage.getText());
    }

    @And("clickme butonuna basildigini dogrulayiniz")
    public void clickmeButonunaBasildiginiDogrulayiniz() {
        Assert.assertTrue(uS05_ButtonBoxPage.dynamicClickMessage.getText().equals("You have done a dynamic click"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(uS05_ButtonBoxPage.dynamicClickMessage.getText().equals("You have done a dynamic click"),"gorunuyor");
    }

    @And("Buttons yazisinin gorunurlugunu basildigini Dogrulayiniz")
    public void buttonsYazisininGorunurlugunuBasildiginiDogrulayiniz() {
        System.out.println(uS05_ButtonBoxPage.yaziButton.getText());
        Assert.assertFalse(uS05_ButtonBoxPage.yaziButton.getText().equals("BUTTONS"));
    }

    @And("{string} yazisinin gorunurlugunu  Dogrulayiniz")
    public void yazisininGorunurlugunuDogrulayiniz(String arg0) {
        actions.sendKeys(Keys.PAGE_UP);
        System.out.println(uS05_ButtonBoxPage.yaziButton.getText());
        Assert.assertTrue(uS05_ButtonBoxPage.yaziButton.getText().equals(arg0));
    }
}
