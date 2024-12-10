package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@id='root']/div/main/div/nav/ul/li[3]/button")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[text()='Конструктор']")
    private WebElement constructorLink;

    @FindBy(xpath = "//*[@id='root']/div/header/nav/div")
    private WebElement logoLink;

    private final WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Нажатие кнопки выхода")
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    @Step("Переход на страницу конструктора")
    public void clickConstructorLink() {
        wait.until(ExpectedConditions.elementToBeClickable(constructorLink));
        constructorLink.click();
    }

    @Step("Переход на главную страницу через логотип")
    public void clickLogoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(logoLink));
        logoLink.click();
    }
} 