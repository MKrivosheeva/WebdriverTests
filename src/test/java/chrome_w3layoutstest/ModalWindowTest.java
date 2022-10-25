package chrome_w3layoutstest;

import common_actions.CommonActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ModalWindowTest extends CommonActions {
    private final String URL = "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";
    private WebElement picture;

    @Test
    public void modalWindowTest() {
        By image = By.cssSelector("li:nth-child(1) span:nth-child(1) a:nth-child(1) div:nth-child(1)");
        By modalWindowImage = By.cssSelector("div.pp_pic_holder.light_rounded");
        driver.get(URL);
        driver.manage().window().maximize();
        picture = driver.findElement(image);
        Assertions.assertTrue(waitForCondition(ExpectedConditions.invisibilityOfElementLocated(modalWindowImage)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", picture);
        Assertions.assertTrue(waitForCondition(ExpectedConditions.presenceOfElementLocated(modalWindowImage)));
        logger.info("Открыто модальное окно");
    }

}
