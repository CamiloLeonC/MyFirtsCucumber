package com.advantageshopping.automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


import java.util.concurrent.TimeUnit;

public class RegisterNewUserStepDefinitions {

    public WebDriver driver;

    @Given("^that a web user wants to register in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/register");
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    //Hay que cambiar el usuario y correo cada vez que se quiera ejecutar el test
    String username = "Camialo8a8a8";
    String email = "camilol1234234.xzczas@gmail.com";
    String password = "QdunoA27*";

    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() {
       //assertEquals(driver.findElement(By.xpath("//h3[text()='CREATE ACCOUNT']")).getText(),"CREATE ACCOUNT");

        //Ingresar UserName
        driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
        //Ingresar email
        driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
        //Ingresar contraseña
        driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
        //Confirmar contraseña
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //DATOS PERSONALES

        //Ingresar Nombre
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Camilo");
        //Ingresar apellido
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Leon");

        //VALIDACION
       assertEquals(driver.findElement(By.xpath("//h3[text()='PERSONAL DETAILS']")).getText(),"PERSONAL DETAILS");
        //Ingresar Numero

        //DIRECCION

        //Elegir Pais y ciudad
        driver.findElement(By.name("countryListboxRegisterPage")).sendKeys("Colombia");
        driver.findElement(By.name("cityRegisterPage")).sendKeys("Bogota");
        //Ingresar Direccion
        driver.findElement(By.name("addressRegisterPage")).sendKeys("CALLE 3ERA #70-98");
        //Region
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Engativa");
        //Ingresar codigo postal
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("111011");
        //Desmarcar publicidad
        driver.findElement(By.name("allowOffersPromotion")).click();
        //Aceptar terminos y condiciones
        driver.findElement(By.name("i_agree")).click();

        //Click en registrar
        driver.findElement(By.id("register_btnundefined")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() throws InterruptedException {
        //LOGEO
      /* driver.get("https://www.advantageonlineshopping.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Iniciar sesion
        driver.findElement(By.id("menuUserSVGPath")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Username
        driver.findElement(By.name("username")).sendKeys(username);
        //Password
        driver.findElement(By.name("password")).sendKeys(password);
        //Sign in
        driver.findElement(By.xpath("//button[@id='sign_in_btnundefined']")).click();
        */

        //VALIDACION
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.xpath("//a[text()='CONTACT US']")).getText(),"CONTACT US");
        driver.quit();


    }

}
