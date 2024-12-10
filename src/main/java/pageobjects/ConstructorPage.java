package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage extends BasePage {

    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement bunsSection;

    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement saucesSection;

    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement fillingsSection;

    @FindBy(xpath = "//span[text()='Булки']/parent::div")
    private WebElement bunsSectionParent;

    @FindBy(xpath = "//span[text()='Соусы']/parent::div")
    private WebElement saucesSectionParent;

    @FindBy(xpath = "//span[text()='Начинки']/parent::div")
    private WebElement fillingsSectionParent;

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы конструктора")
    public ConstructorPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Переход в раздел 'Булки'")
    public void clickBunsSection() {
        bunsSection.click();
    }

    @Step("Переход в раздел 'Соусы'")
    public void clickSaucesSection() {
        saucesSection.click();
    }

    @Step("Переход в раздел 'Начинки'")
    public void clickFillingsSection() {
        fillingsSection.click();
    }

    public boolean isBunsSectionActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(bunsSectionParent, "class", "current"));
    }

    public boolean isSaucesSectionActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(saucesSectionParent, "class", "current"));
    }

    public boolean isFillingsSectionActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(fillingsSectionParent, "class", "current"));
    }
} 