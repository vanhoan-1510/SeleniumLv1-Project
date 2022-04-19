package TestCases;

import Common.Log;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactPage contactPage = new ContactPage();

    @Test(dataProvider = "getData", description = "User is redirected to Home page after logging out")
    public void Logout(Object[] data) {
        String username = data[0].toString();
        String password = data[1].toString();

        Log.info("Navigate to Login Page.");
        homePage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);
        Log.info("Navigate to Contact Page.");
        homePage.moveToContactPage();
        Log.info("Log out.");
        contactPage.loggingOut();

        Log.info("Check that the web page displays correctly with the description.");
        String expectedHeader = "Welcome to Safe Railway";
        String actualHeader = homePage.getTxtHomePageHeader().getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }
}
