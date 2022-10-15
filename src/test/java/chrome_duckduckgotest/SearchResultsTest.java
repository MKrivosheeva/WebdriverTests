package chrome_duckduckgotest;

import common_actions.HeadlessStartUp;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchResultsTest extends HeadlessStartUp {

    private final String URL = "https://duckduckgo.com/";
    private final String RESULTURL = "https://otus.ru";

    @Test
    public void searchResultsTest() {
        By element = By.id("search_form_input_homepage");
        By button = By.id("search_button_homepage");
        By searchResult = By.cssSelector("#r1-0 > div:nth-child(1) a > span");
        String keys = "ОТУС";
        driver.get(URL);
        driver.findElement(element).sendKeys(keys);
        driver.findElement(button).click();
        WebElement searchresult = driver.findElement(searchResult);
        logger.info("Первый результат поиска: " + searchresult.getText());
        Assertions.assertEquals(RESULTURL, searchresult.getText());
      }
}

