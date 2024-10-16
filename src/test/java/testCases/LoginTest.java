package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginTest extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;

    @Test(groups = {"Sanity", "Master"})
    public void loginTest(){
        logger.info("*** Starting login test ***");
        try {
            homePage = new HomePage(driver);
            homePage.click_myAccount();
            homePage.click_loginLink();

            loginPage = new LoginPage(driver);
            loginPage.setEmail_input(p.getProperty("email"));
            loginPage.setPassword_input(p.getProperty("password"));
            loginPage.click_loginBtn();
        } catch (Exception e){
            Assert.fail();
        }
        logger.info("*** Finished login test ***");
    }

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")//getting data provider from a different/separate class
    public void verify_loginDDT(String email, String passwrd, String expResults){
        homePage = new HomePage(driver);
        homePage.click_myAccount();
        homePage.click_loginLink();

        loginPage = new LoginPage(driver);
        loginPage.setEmail_input(email);
        loginPage.setPassword_input(passwrd);
        loginPage.click_loginBtn();

        MyAccount myAccount= new MyAccount(driver);
        boolean targetPage= myAccount.doesMyAccountPageExist();
        if(expResults.equalsIgnoreCase("Valid"))
        {
            if(targetPage==true)
            {
                Assert.assertTrue(targetPage);
                myAccount.click_logOut();
            }
            else
            {
                Assert.fail();
            }
        }
        if(expResults.equalsIgnoreCase("Invalid")){
            if(targetPage==true)
            {
                Assert.fail();
                myAccount.click_logOut();
            }
            else
            {
                Assert.assertTrue(true);
            }
        }

    }
}
