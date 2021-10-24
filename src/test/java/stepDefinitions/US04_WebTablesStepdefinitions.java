package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.US04_WebTablesPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US04_WebTablesStepdefinitions {

    US04_WebTablesPage uS04_WebTablesPage = new US04_WebTablesPage();
    Actions actions = new Actions(Driver.getDriver());

   static String isim="";


    @And("webTables butonuna basiniz")
    public void web_tables_butonuna_basiniz() {

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        uS04_WebTablesPage.webTables.click();
        ReusableMethods.waitFor(1);
    }


    @Given("Add butonuna basiniz")
    public void addButonunaBasiniz() {
        uS04_WebTablesPage.add.click();
    }

    @And("submit butonuna tiklayiniz")
    public void submitButonunaTiklayiniz() {
        uS04_WebTablesPage.submit.click();
    }

    @And("cikan formda firstName yaziniz  {string}")
    public void cikanFormdaFirstNameYaziniz(String arg0) {
        uS04_WebTablesPage.firstName.clear();
        uS04_WebTablesPage.firstName.sendKeys(arg0);
    }

    @And("cikan formda lastName yaziniz  {string}")
    public void cikanFormdaLastNameYaziniz(String arg0) {
        uS04_WebTablesPage.lastName.clear();
        uS04_WebTablesPage.lastName.sendKeys(arg0);

    }

    @And("cikan formda email giriniz  {string}")
    public void cikanFormdaEmailGiriniz(String arg0) {
        uS04_WebTablesPage.email.clear();
        uS04_WebTablesPage.email.sendKeys(arg0);
    }

    @And("cikan formda age yaziniz {string}")
    public void cikanFormdaAgeYaziniz(String arg0) {
        uS04_WebTablesPage.age.clear();
        uS04_WebTablesPage.age.sendKeys(arg0);
    }

    @And("cikan formda salary yaziniz {string}")
    public void cikanFormdaSalaryYaziniz(String arg0) {
        uS04_WebTablesPage.salary.clear();
        uS04_WebTablesPage.salary.sendKeys(arg0);
    }

    @And("cikan formda department yaziniz {string}")
    public void cikanFormdaDepartmentYaziniz(String arg0) {
        uS04_WebTablesPage.department.sendKeys(arg0);
    }

    @And("search butonuna firstName giriniz {string}")
    public void searchButonunaFirstNameGiriniz(String arg0) {
      uS04_WebTablesPage.seaarch.sendKeys(arg0);
      ReusableMethods.waitFor(2);
    }

    @Then("kaydin ekledigini dogrulayiniz {string}")
    public void kaydinEklediginiDogrulayiniz(String firstName) {
        System.out.println(uS04_WebTablesPage.firstRow.getText());
        Assert.assertTrue(uS04_WebTablesPage.firstRow.getText().contains(firstName));
    }

    @And("duzenle butonuna basiniz")
    public void duzenleButonunaBasiniz() {
        uS04_WebTablesPage.edit.click();
    }
    @And("sil butonuna basiniz")
    public void silButonunaBasiniz() {


        isim=uS04_WebTablesPage.firstRow.getText();

        uS04_WebTablesPage.sil.click();


    }

    @Then("kaydin silindigini dogrulayiniz")
    public void kaydinSilindiginiDogrulayiniz() {

        System.out.println();
        System.out.print("son isim:   "+isim);
        System.out.println();
        System.out.print("son firstrow:   "+uS04_WebTablesPage.firstRow.getText());
        Assert.assertFalse(uS04_WebTablesPage.firstRow.getText().equals(isim));
    }


    @And("liste olustur")
    public void listeOlustur() {

        List <WebElement> elems=Driver.getDriver().findElements(By.xpath("//div[@class='rt-tr -odd']"));
       List list=new ArrayList();

       list=ReusableMethods.getElementsText(elems);
        System.out.println(list);


        
        
    }



}
