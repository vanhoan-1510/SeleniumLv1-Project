package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can't create account while password and PID fields are empty")
    public void Register(Object[] data) {
        String username = FakeData.createRandomEmail(data[0].toString());

        Log.info("Navigate to Register page.");
        homePage.moveToRegisterPage();
        Log.info("Register new account.");
        registerPage.register(username, "", "", "");

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessageForm = "There're errors in the form. Please correct the errors and try again.";
        String actualMessageForm = registerPage.getErrorMessage().getText();
        Assert.assertEquals(expectedMessageForm, actualMessageForm);

        String expectedMessagePsw = "Invalid password length";
        String actualMessagePsw = registerPage.getPswErrorMessage().getText();
        Assert.assertEquals(expectedMessagePsw, actualMessagePsw);

        String expectedMessagePid = "Invalid ID length";
        String actualMessagePid = registerPage.getPidErrorMessage().getText();
        Assert.assertEquals(expectedMessagePid, actualMessagePid);

    }
}
