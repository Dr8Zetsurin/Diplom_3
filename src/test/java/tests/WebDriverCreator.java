package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;

public class WebDriverCreator {
    private static final List<String> browsers = new ArrayList<String>() {{
        add("chrome");
        add("yandex");
    }};
    
    private static int currentBrowserIndex = 0;

    public static WebDriver createWebDriver() {
        String browserType = browsers.get(currentBrowserIndex);
        currentBrowserIndex = (currentBrowserIndex + 1) % browsers.size();
        
        switch (browserType.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "yandex":
                return createYandexDriver();
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER_PATH"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("YANDEX_DRIVER_PATH"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        return new ChromeDriver(options);
    }
}