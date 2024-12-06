package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstructorPage extends BasePage {

    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement bunsSection;

    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement saucesSection;

    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement fillingsSection;

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
} 