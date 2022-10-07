package chrome_duckduckgotest;

import common_actions.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;
import java.time.Duration;

public class SearchResultsTest extends CommonActions {
    private final String URL = "https://duckduckgo.com/";
    private final String RESULTURL = "https://otus.ru";

    @Override
    @BeforeEach
    public void StartUp() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            logger.info("Драйвер поднят");
    }

    @Test
    public void searchResultsTest() {
        By element = By.id("search_form_input_homepage");
        By button = By.id("search_button_homepage");
        By searchResult = By.cssSelector("#r1-0 > div:nth-child(1) > div > a > span");
        String keys = "ОТУС";
        driver.get(URL);
        driver.findElement(element).sendKeys(keys);
        driver.findElement(button).click();
        WebElement searchresult = driver.findElement(searchResult);
        logger.info("Первый результат поиска: " + searchresult.getText());
        Assertions.assertEquals(RESULTURL, searchresult.getText());
      }
}

