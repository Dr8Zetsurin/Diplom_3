package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка перехода к разделу 'Булки' в конструкторе")
    public void switchToBunsTest() {
        constructorPage.open();
        WebElement bunsSection = driver.findElement(By.xpath("//span[text()='Булки']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bunsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunsSection);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.attributeContains(
            By.xpath("//span[text()='Булки']/parent::div"), "class", "current")));
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' в конструкторе")
    public void switchToSaucesTest() {
        constructorPage.open();
        constructorPage.clickSaucesSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.attributeContains(
            By.xpath("//span[text()='Соусы']/parent::div"), "class", "current")));
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' в конструкторе")
    public void switchToFillingsTest() {
        constructorPage.open();
        constructorPage.clickFillingsSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.attributeContains(
            By.xpath("//span[text()='Начинки']/parent::div"), "class", "current")));
    }
} 