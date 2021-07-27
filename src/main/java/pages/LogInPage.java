package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver){
        super(driver);
    }

    public WebElement getEmailField(){
        return super.driver.findElement(new By.ByName("email"));
    }

    public WebElement getPasswordField(){
        return super.driver.findElement(new By.ByName("password"));
    }

    public WebElement getSignInButton(){
        return super.driver.findElement(new By.ById("signin"));
    }

    public WebElement getSignInText(){
        return super.driver.findElement(new By.ByXPath("//a[@href='/a/wa/account']//div[1]"));
    }

    public WebElement getInvalidNotification(){
        return super.driver.findElement(new By.ByXPath("(//span[@role='alert'])[1]"));
    }

    public WebElement getPasswordNotification(){
        return super.driver.findElement(new By.ByXPath("//div[text()='Password']/following-sibling::span"));
    }

    public void setCredentials(String Login, String Password ){
        getEmailField().sendKeys(Login);
        getPasswordField().sendKeys(Password);
        getSignInButton().click();
    }

    public void validateSignIn(String Login) {
        waitForElementToBeVisible(getSignInText());
        waitForElementToBeClickable(getSignInText());
        Assert.assertTrue(getSignInText().getText().contains(Login));
    }

    public void validateInvalidNotification(String Notification) {
        waitForElementToBeVisible(getInvalidNotification());
        waitForElementToBeClickable(getInvalidNotification());
        Assert.assertTrue(getInvalidNotification().getText().contains(Notification));
    }

    public void validatePasswordNotification(String EmptyPassNote) {
        waitForElementToBeVisible(getPasswordNotification());
        waitForElementToBeClickable(getPasswordNotification());
        Assert.assertTrue(getPasswordNotification().getText().contains(EmptyPassNote));
    }

}
