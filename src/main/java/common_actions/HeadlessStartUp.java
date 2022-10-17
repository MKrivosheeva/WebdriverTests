package common_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class HeadlessStartUp {

    protected static WebDriver driver;
    protected static org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommonActions.class);

    @BeforeAll
    public static void headlessStartUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        logger.info("Драйвер поднят");

    }

    @AfterAll
    public static void end(){
        if (driver!=null)
            driver.quit();
    }
}






