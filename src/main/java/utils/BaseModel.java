package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseModel {

    public static final Integer PAGE_LOAD_SEC_TIMEOUT = 10;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseModel(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, PAGE_LOAD_SEC_TIMEOUT);

        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected String getTitle(){
        return this.driver.getTitle();
    }

}
