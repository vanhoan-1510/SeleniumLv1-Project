package TestCases;

import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "Login to Railway with invalid information several times")
    public void Login(Object[] data) {
        String username = data[0].toString();
        String password = data[1].toString();

        Log.info("Navigate to Login Page.");
        homePage.moveToLoginPage();
        for (int i = 1; i < 5; i++) {
            Log.info("Login to Safe Railway.");
            loginPage.login(username, password);
        }

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes.";
        String actualMessage = loginPage.getErrorMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
