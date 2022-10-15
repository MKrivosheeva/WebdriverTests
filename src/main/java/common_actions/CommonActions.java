package common_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public abstract class CommonActions {
    protected static WebDriver driver;
    protected static org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommonActions.class);

    @BeforeAll
    public static void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        logger.info("Драйвер поднят");

    }

    @AfterAll
    public static void end(){
        if (driver!=null)
            driver.quit();
     }
}
