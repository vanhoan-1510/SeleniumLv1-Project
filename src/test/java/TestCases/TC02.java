package TestCases;

import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "Login to Railway with blank Email and valid Password")
    public void Login(Object[] data) {
        String password = data[1].toString();

        Log.info("Navigate to Login Page.");
        homePage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login("", password);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";
        String actualMessage = loginPage.getErrorMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
