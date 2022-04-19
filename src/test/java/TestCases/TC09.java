package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.ChangePassword;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePassword changePassword = new ChangePassword();

    @Test(dataProvider = "getData", description = "User can't change password when New Password and Confirm Password are different.")
    public void Register(Object[] data) {
        String username = FakeData.createRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = FakeData.RandomNumber();

        Log.info("Navigate to Register page.");
        homePage.moveToRegisterPage();
        Log.info("Register new account.");
        registerPage.register(username, password, password, pid);

        Log.info("Navigate to Login page.");
        registerPage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Navigate to Change Password page.");
        homePage.moveToChangePasswordPage();
        Log.info("Change password.");
        changePassword.changePassword(password, password, password + "!!$%");
    }
}
