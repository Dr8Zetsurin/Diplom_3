package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        createTestUser();
        loginPage.open();        
        loginPage.login(email, PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода в личный кабинет по клику на 'Личный кабинет'")
    public void navigateToProfileTest() {
        loginPage.clickPersonalAccountButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/account/profile"));
        assertTrue(driver.getCurrentUrl().contains("/account/profile"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода в конструктор по клику на 'Конструктор'")
    public void navigateToConstructorFromProfileTest() {
        loginPage.clickPersonalAccountButton();
        profilePage.clickConstructorLink();
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Переход по клику на логотип")
    @Description("Проверка перехода на главную по клику на логотип Stellar Burgers")
    public void navigateByLogoClickTest() {
        loginPage.clickPersonalAccountButton();
        profilePage.clickLogoLink();
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта по кнопке 'Выйти'")
    public void logoutTest() {
        loginPage.clickPersonalAccountButton();
        profilePage.clickLogoutButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
