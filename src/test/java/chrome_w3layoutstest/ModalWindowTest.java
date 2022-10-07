package chrome_w3layoutstest;

import common_actions.CommonActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class ModalWindowTest extends CommonActions {
    private final String URL = "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";
    JavascriptExecutor js;
    @Test
    public void modalWindowTest() {
        By image = By.cssSelector("li[class^='portfolio-item2']"); //поиск любой картинки, так как не указано, какую именно картинку надо найти
        By modalWindowImage = By.cssSelector("div.pp_pic_holder.light_rounded");
        driver.get(URL);
        driver.manage().window().maximize();
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(image));
        new Actions(driver).click(driver.findElement(image));
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(1));
        Boolean modalWindowAppearance = wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalWindowImage))).isDisplayed();
        Assertions.assertTrue(modalWindowAppearance, "Картинка открыта в новом модальном окне");
    }

}
