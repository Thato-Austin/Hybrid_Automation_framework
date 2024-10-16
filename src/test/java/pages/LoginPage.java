package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement email_input;
    @FindBy(id = "input-password")
    WebElement password_input;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement login_btn;

    public void setEmail_input(String email){
        email_input.click();
        email_input.sendKeys(email);
    }

    public void setPassword_input(String password){
        password_input.click();
        password_input.sendKeys(password);
    }

    public void click_loginBtn(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", login_btn);
    }
}
