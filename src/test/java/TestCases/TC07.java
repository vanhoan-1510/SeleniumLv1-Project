package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User register a new account.")
    public void Register(Object[] data) {
        String username = FakeData.createRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = FakeData.RandomNumber();

        Log.info("Navigate to Register page.");
        homePage.moveToRegisterPage();
        Log.info("Register new account.");
        registerPage.register(username, password, password, pid);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "Registration Confirmed! You can now log in to the site.";
        String actualMessage = registerPage.getMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
