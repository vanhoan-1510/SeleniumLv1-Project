package TestCases;

import Common.Log;
import org.testng.Assert;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "Login to Railway with valid information")
    public void Login(Object[] data) {
        String username = data[0].toString();
        String password = data[1].toString();

        Log.info("Navigate to Login page.");
        homePage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "Welcome " + username;
        String actualMessage = homePage.getWelcomeMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}