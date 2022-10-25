package common_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class CommonActions {
    protected static WebDriver driver;
    protected static org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommonActions.class);

    @BeforeAll
    public static void load() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        logger.info("Драйвер поднят");

    }

    @AfterEach
    public void end(){
        if (driver!=null)
            driver.quit();
     }

    protected boolean waitForCondition(ExpectedCondition condition) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            webDriverWait.until(condition);
            return true;
        } catch(TimeoutException ignoring) {
            return false;
        }
    }


}
