package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.UserGenerator;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Проверка успешной регистрации с валидными данными")
    public void successfulRegistrationTest() {
        registerPage.open()
                   .register(NAME, email, PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    @Description("Проверка появления ошибки при вводе пароля менее 6 символов")
    public void invalidPasswordRegistrationTest() {
        String shortPassword = "12345";

        registerPage.open()
                   .register(NAME, email, shortPassword);

        String errorText = registerPage.getPasswordErrorText();
        assertTrue(errorText.contains("Некорректный пароль"));
    }
} 