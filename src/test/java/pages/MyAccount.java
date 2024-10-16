package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
    public MyAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccount_heading;
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement logoutBtn;

    public boolean doesMyAccountPageExist(){
        try{
            return (myAccount_heading.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }

    public void click_logOut(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", logoutBtn);
    }
}
