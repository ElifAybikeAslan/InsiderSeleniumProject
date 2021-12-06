package Feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver webDriver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.get("https://useinsider.com/");
        webDriver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        webDriver.quit();
    }
}
