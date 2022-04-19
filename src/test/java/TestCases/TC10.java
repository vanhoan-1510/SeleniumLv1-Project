package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can't create account with an already in-use email")
    public void Register(Object[] data) throws InterruptedException {
        String username = FakeData.createRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = FakeData.RandomNumber();

        for (int i = 0; i < 2; i++) {
            Log.info("Navigate to Register page.");
            homePage.moveToRegisterPage();
            Log.info("Register new account.");
            registerPage.register(username, password, password, pid);
        }

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "This email address is already in use.";
        String actualMessage = registerPage.getErrorMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
