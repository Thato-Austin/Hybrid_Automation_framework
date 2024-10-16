package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    WebElement lastNameInput;

    @FindBy(id = "input-email")
    WebElement emailInput;

    @FindBy(id = "input-telephone")
    WebElement telephoneInput;

    @FindBy(id = "input-password")
    WebElement passwordInput;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//div[@class='pull-right']//input[1]")
    WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confirmation_msg;

    public void setFirstNameInput(String fName){
        firstNameInput.click();
        firstNameInput.sendKeys(fName);
    }

    public void setLastNameInput(String lName) {
        lastNameInput.click();
        lastNameInput.sendKeys(lName);
    }

    public void setEmailInput(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void setTelephoneInput(String tel) {
        telephoneInput.click();
        telephoneInput.sendKeys(tel);
    }

    public void setPasswordInput(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(String confirmPassword) {
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void click_privacyPolicy() {
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy)).click();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", privacyPolicy);
    }

    public void click_continueBtn(){
//        JavascriptExecutor js= (JavascriptExecutor)driver;
//        js.executeAsyncScript("arguments[0].click()", continueBtn);
        continueBtn.click();
    }

    public String getConfirmationMsg(){
        try {
            return (confirmation_msg.getText());
        } catch (Exception e){
            return (e.getMessage());
        }
    }
}
