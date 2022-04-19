package TestCases;

import Common.Log;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(dataProvider = "getData", description = "Go to Book ticket page")
    public void GoToBookTicket(Object[] data) {
        String username = data[0].toString();
        String password = data[1].toString();

        Log.info("Navigate to Login Page.");
        homePage.moveToBookTicketPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedHeader = "Book ticket";
        String actualHeader = bookTicketPage.getBookTicketHeaderText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }
}
