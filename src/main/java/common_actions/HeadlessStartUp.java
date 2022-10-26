package common_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class HeadlessStartUp {

    protected static WebDriver driver;
    protected static org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommonActions.class);


    @BeforeAll
    public static void load() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void headlessStartUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        logger.info("Драйвер поднят");

    }

    @AfterEach
    public void end(){
        if (driver!=null)
            driver.quit();
    }
}






