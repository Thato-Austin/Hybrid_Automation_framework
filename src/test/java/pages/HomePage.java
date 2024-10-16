package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    public void click_myAccount(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
//        JavascriptExecutor js= (JavascriptExecutor)driver;
//        js.executeAsyncScript("arguments[0].click()", myAccount);
//        myAccount.click();
    }

    public void click_registerLink() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();
    }

    public void click_loginLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }
}
