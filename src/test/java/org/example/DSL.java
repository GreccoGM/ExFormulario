package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
    private static WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(String namoCampo, String valor){
        driver.findElement(By.name(namoCampo)).sendKeys(valor);
    }

    public void clicarCombo(String id, String valorLista){
        WebElement element = driver.findElement(By.name(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valorLista);
    }
}
