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
        By signInButton = By.xpath("//*[@class='header2__auth js-open-modal']");
        By loginField = By.xpath("//*[contains(@class,'email-input')][contains(@type,'text')]");
        By pswdField = By.xpath("//*[contains(@class,'psw-input')][contains(@type,'password')]");
        By enterButton = By.xpath("//div[2]/form/div[4]/button");

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
