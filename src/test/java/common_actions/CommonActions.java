package common_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class CommonActions {
    protected WebDriver driver;
    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommonActions.class);

    @BeforeEach
    public void StartUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        logger.info("Драйвер поднят");

    }

    @AfterEach
    public void End(){
        if (driver!=null)
            driver.quit();
     }
}
