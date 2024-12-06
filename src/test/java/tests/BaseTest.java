package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utils.UserGenerator;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected ProfilePage profilePage;
    protected ConstructorPage constructorPage;
    protected ForgotPasswordPage forgotPasswordPage;
    
    protected String email;
    protected final String PASSWORD = "password123";
    protected final String NAME = "TestUser";
    protected String accessToken;

    @Before
    public void setUp() {
        driver = WebDriverCreator.createWebDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
        constructorPage = new ConstructorPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        
        // Генерация уникального email для каждого теста
        email = "test" + System.currentTimeMillis() + "@test.com";
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserGenerator.deleteUser(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }
    
    protected void createTestUser() {
        accessToken = UserGenerator.createUser(email, PASSWORD, NAME);
    }
} 