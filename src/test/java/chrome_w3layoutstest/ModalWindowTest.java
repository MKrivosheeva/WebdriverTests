package chrome_w3layoutstest;

import common_actions.CommonActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class ModalWindowTest extends CommonActions {
    private final String URL = "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";

    @Test
    public void modalWindowTest() {
        By image = By.xpath("//div/ul[2]/li[1]/span/a/div[1]");
        By modalWindowImage = By.xpath("//section[2]/div/ul[2]/li[1]/span/a/img");

        driver.get(URL);
        driver.manage().window().maximize();
        WebElement mainPageImage = driver.findElement(image);
        new Actions(driver).click(mainPageImage);
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
        WebElement modalWindowAppearance = wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalWindowImage)));
        Assertions.assertNotNull(modalWindowAppearance, "Картинка открыта в новом модальном окне");
    }

}
