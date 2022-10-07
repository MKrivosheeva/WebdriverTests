package chrome_otustest;

import common_actions.CommonActions;
import common_actions.IGetCredentials;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FindAllCookies extends CommonActions {
    private final String URL = "https://otus.ru";
    private IGetCredentials loginPassword = ConfigFactory.create(IGetCredentials.class);


    @Test
    public void findAllCookiesTest() {
        By signInButton = By.cssSelector("button[data-modal-id=new-log-reg]");
        By loginField = By.cssSelector("input[placeholder='Электронная почта'][type='text']");
        By pswdField = By.cssSelector("input[type=password]");
        By enterButton = By.cssSelector("button[class$='new-button_md'][type='submit']");

        driver.get(URL);
        driver.manage().window().fullscreen();
        driver.findElement(signInButton).click();
        driver.findElement(loginField).sendKeys(loginPassword.login());
        driver.findElement(pswdField).sendKeys(loginPassword.password());
        driver.findElement(enterButton).click();
        logger.info("Куки с сайта" + driver.manage().getCookies());
        driver.manage().deleteAllCookies();
    }
}
