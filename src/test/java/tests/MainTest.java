package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Config;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class MainTest {

    public static String Email = "spelltest71@gmail.com";
    public static String Password = "123456";
    public static String PasswordFail = "123123";
    public static String PasswordEmpty = "";
    public static String Login = "SpellTest";
    public static String WrongPassOrEmail = "Invalid email or password";
    public static String EmptyPassNote = "Should not be empty";


    private static WebDriver WEBDRIVER;
    private static String DRIVER_PATH = System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe";
    private static String SITE_URL;

    static {
        try {
            SITE_URL = getUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUrl() throws IOException {
        Config config = new Config();
        return config.getFromEnv("URL");
    }

    public static WebDriver getWebDriver(){
        return WEBDRIVER;
    }

    @BeforeClass
    public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
            WEBDRIVER = new ChromeDriver();
            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            getWebDriver().manage().window().maximize();
            getWebDriver().navigate().to(SITE_URL);
    }

    @AfterClass
    public void tearDown() {
        getWebDriver().quit();
    }

}
