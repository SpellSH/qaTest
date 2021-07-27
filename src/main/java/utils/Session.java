package utils;

import org.openqa.selenium.WebDriver;
import pages.LogInPage;


import java.io.IOException;

public class Session {

    private WebDriver driver;
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

    public Session(WebDriver driver) {
        this.driver = driver;
    }
    public LogInPage getLoginPage(){
       return new LogInPage(this.driver);
   }





}
