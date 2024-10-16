package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import testBase.BaseClass;

public class RegistrationTests extends BaseClass {


    @Test(groups ={"Regression", "Master"})
    public void verify_account_registration() {


        logger.info("*** Starting verify account registration test ***");
//        test.log(Status.INFO, "Registration function test started");
        try {

            HomePage homePage = new HomePage(driver);
            homePage.click_myAccount();
            logger.info("Clicked on My account dropdown ");
//            test.log(Status.PASS,"Clicked on My Accounts link");

            homePage.click_registerLink();
            logger.info("Clicked on Register link ");
//            test.log(Status.PASS,"Clicked on Register link");

            RegistrationPage registrationPage = new RegistrationPage(driver);

            logger.info("New user entering details... ");
            registrationPage.setFirstNameInput(randomString().toUpperCase());
            registrationPage.setLastNameInput(randomString().toUpperCase());
            registrationPage.setEmailInput(randomString() + "@gmail.com");
            registrationPage.setTelephoneInput(randomNum());

            String password = randomAlphaNum();
            registrationPage.setPasswordInput(password);
            registrationPage.setConfirmPasswordInput(password);
//            test.log(Status.PASS,"New user has entered details...");


            registrationPage.click_privacyPolicy();
//            test.log(Status.PASS,"Clicked on privacy policy checkbox");
            registrationPage.click_continueBtn();
//            test.log(Status.PASS,"Clicked on continue button");

            logger.info("Validating expected message...");
            String confmMsg = registrationPage.getConfirmationMsg();
//            Assert.assertEquals(confmMsg, "Your Account Has Been Created!");


            if(confmMsg.equals("Your Account Has Beens Created!")){
                Assert.assertTrue(true);
            } else {
                logger.error("Test failed");
                logger.debug("Debug logs");
                Assert.assertTrue(false, "'Your Account Has Been Created!' message did not get displayed");
            }
        }
        catch (Exception e){
            Assert.fail();
//            test.log(Status.FAIL,"Test has failed");
        }
//        test.log(Status.INFO,"Test Passed");
        logger.info("*** Finished verify account registration test ***");
    }

}
