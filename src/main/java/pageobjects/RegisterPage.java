package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = "[name='name']")
    private WebElement nameInput;

    // @FindBy(css = "[name='email']")
    // private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(css = "[name='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[contains(text(),'Некорректный пароль')]")
    private WebElement passwordError;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public RegisterPage open() {
        driver.get(BASE_URL + "register");
        return this;
    }

    @Step("Ввод имени {name}")
    public RegisterPage setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Ввод email {email}")
    public RegisterPage setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Ввод пароля {password}")
    public RegisterPage setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки регистрации")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Клик по ссылке входа")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Получение текста ошибки пароля")
    public String getPasswordErrorText() {
        return passwordError.getText();
    }

    @Step("Регистрация нового пользователя")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }
} 