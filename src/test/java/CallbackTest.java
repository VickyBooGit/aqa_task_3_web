import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.junit.jupiter.api.Assertions.assertEquals;


public class CallbackTest {
    private WebDriver driver;


//    @BeforeClass
//    public static void setupClass() {
//
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @Before
//    public void setupTest() {
//        driver = new ChromeDriver();
//    }
//
//    @After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "./driver/linux/chromedriver");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSendRequest() {
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://localhost:9999");
        WebElement form = driver.findElement(By.cssSelector("[class] form"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванов Иван Иванович");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79523586842");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[type=button]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());


    }

}
