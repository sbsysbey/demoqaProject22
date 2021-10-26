package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import pages.US06_LinksPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class US06_LinksStepDefinitions {
   US06_LinksPage linksPage = new US06_LinksPage();
    Actions actions = new Actions(Driver.getDriver());


    @And("Links butonuna basiniz")
    public void linksButonunaBasiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.lineMenuLink.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);

    }

    @And("Home butonuna tiklayin")
    public void homeButonunaTiklayin() {
linksPage.linkHome.click();
    }

    @Then("Yeni bir sekme de anasayfa acildigini dogrulayiniz")
    public void yeniBirSekmeDeAnasayfaAcildiginiDogrulayiniz() {
     ArrayList tabs = new ArrayList (Driver.getDriver().getWindowHandles());


        System.out.println(Driver.getDriver().getCurrentUrl());

                     Driver.getDriver().switchTo().window((String) tabs.get(1));
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://demoqa.com/"));
        Driver.getDriver().switchTo().window((String) tabs.get(1)).close();
        Driver.getDriver().switchTo().window((String) tabs.get(0));
}
    @And("HomeEur butonuna tiklayin")
    public void homeeurButonunaTiklayin() {
        linksPage.linkHomeDynamic.click();

    }




    @And("Created butonuna tiklayin")
    public void createdButonunaTiklayin() {

      linksPage.created.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("No Content butonuna tiklayin")
    public void noContentButonunaTiklayin() {
        linksPage.nocontent.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("Moved butonuna tiklayin")
    public void movedButonunaTiklayin() {
linksPage.moved.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("Bad Request butonuna tiklayin")
    public void badRequestButonunaTiklayin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.badrequest.click();
    }

    @And("Unauthorized butonuna tiklayin")
    public void unauthorizedButonunaTiklayin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.unauthorized.click();
    }

    @And("Forbidden butonuna tiklayin")
    public void forbiddenButonunaTiklayin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.forbidden.click();
    }

    @And("Not Found butonuna tiklayin")
    public void notFoundButonunaTiklayin() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.notFound.click();
    }


    @Then("yazinin {string} ve {string} icerdigini dogrulayiniz")
    public void yazininVeIcerdiginiDogrulayiniz(String arg0, String arg1) {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println(linksPage.yazi.getText());
        Assert.assertTrue(linksPage.yazi.getText().contains(arg0));
        Assert.assertTrue(linksPage.yazi.getText().contains(arg1));
        ReusableMethods.waitFor(1);


    }


}