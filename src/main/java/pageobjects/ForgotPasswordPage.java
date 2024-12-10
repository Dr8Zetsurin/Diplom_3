package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы восстановления пароля")
    public ForgotPasswordPage open() {
        driver.get(BASE_URL + "forgot-password");
        return this;
    }

    @Step("Клик по ссылке входа")
    public void clickLoginLink() {
        loginLink.click();
    }
}
