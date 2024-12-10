package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Before
    public void createUser() {
        createTestUser();
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной")
    @Description("Проверка входа через кнопку на главной странице")
    public void loginFromMainPageButtonTest() {
        driver.get(constructorPage.getBaseUrl());
        loginPage.clickMainPageLoginButton();
        loginPage.login(email, PASSWORD);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage.getBaseUrl()));
        
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Проверка входа через кнопку личного кабинета")
    public void loginFromPersonalAccountTest() {
        driver.get(constructorPage.getBaseUrl());
        loginPage.clickPersonalAccountButton();
        loginPage.login(email, PASSWORD);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage.getBaseUrl()));
        
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Проверка входа через переход с формы регистрации")
    public void loginFromRegisterPageTest() {
        registerPage.open();
        registerPage.clickLoginLink();
        loginPage.login(email, PASSWORD);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage.getBaseUrl()));
        
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    @Description("Проверка входа через форму восстановления пароля")
    public void loginFromForgotPasswordTest() {
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginLink();
        loginPage.login(email, PASSWORD);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage.getBaseUrl()));
        
        assertTrue(driver.getCurrentUrl().equals(constructorPage.getBaseUrl()));
    }
}
