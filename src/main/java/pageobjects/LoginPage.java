package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement mainPageLoginButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(css = "[name='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открытие страницы входа")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        return this;
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной")
    public void clickMainPageLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPageLoginButton)).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    @Step("Ввод email {email}")
    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
    }

    @Step("Ввод пароля {password}")
    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    @Step("Клик по кнопке входа")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Авторизация с данными: {email}, {password}")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
} 