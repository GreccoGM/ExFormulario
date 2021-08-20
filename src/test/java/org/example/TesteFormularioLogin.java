package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TesteFormularioLogin{

    private static WebDriver driver;
    private static DSL dsl;

    @Before
    public void inicializarDriver(){
         /*System.setProperty("webdriver.gecko.driver","C:\\Program Files\\DriverSelenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://way2automation.com/way2auto_jquery/index.php");*/

        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
        dsl = new DSL(driver);
    }

//    @After
//    public void finalizarDriver(){
//        driver.quit();
//    }

    @Test
    public void cadastrarComSucesso(){
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement modal = driver.findElement(By.id("load_box"));
        /*modal.findElement(By.name("name")).sendKeys("Glória");*/

        dsl.escreve("name","Glória");
        dsl.escreve("phone","(51)9919872856");
        dsl.escreve("email","gloriamargrecco@gmail.com");
        dsl.clicarCombo("country","Bahamas");
        dsl.escreve("city","Teste");
        //dsl.escreve("username","Marques Grecco");
        //dsl.escreve("password","12345678910");
        modal.findElement(By.name("username")).sendKeys("Marques Grecco");
        modal.findElement(By.name("password")).sendKeys("123456");

        modal.findElement(By.className("button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //String texto = modal.findElement(By.id("alert")).getText();
        WebElement elemento = driver.findElement(By.xpath("//p[text()='This is just a dummy form, you just clicked SUBMIT BUTTON']"));
        String texto = elemento.getText();

        //System.out.println("Elemento " + elemento);
        //System.out.println("texto: " + texto);

        Assert.assertEquals("This is just a dummy form, you just clicked SUBMIT BUTTON", texto);
    }

    @Test
    public void testeAcessaPagina(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*WebElement elemento = (driver.findElement(By.id("load_form")).findElement(By.tagName("h3")));
        String texto = elemento.getText();
        System.out.println("texto"  + texto);*/

        String alert = driver.findElement(By.xpath("//h3[text()='Dummy Registration Form']")).getText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(("DUMMY REGISTRATION FORM"), alert);
    }

    @Test
    public void validarCampoNomeObrigatorio(){
        WebElement modal = driver.findElement(By.id("load_box"));

        WebElement botaoEnviar = modal.findElement(By.className("button"));
        botaoEnviar.click();
    }
}
