package TestCases;

import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "Login to Railway with valid Email and invalid password")
    public void LoginFail(Object[] data) {
        String username = data[0].toString();
        String password = data[1].toString();

        Log.info("Navigate to Login Page.");
        homePage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "Invalid username or password. Please try again.";
        String actualMessage = loginPage.getErrorMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
