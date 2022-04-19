package TestCases;

import Common.Constant;
import Common.FakeData;
import Common.Log;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(dataProvider = "getData", description = "User can book many tickets at a time")
    public void BookTicket(Object[] data) throws InterruptedException {

        String username = FakeData.createRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = FakeData.RandomNumber();
        String departDate = data[2].toString();
        String departFrom = data[3].toString();
        String arrivePlace = data[4].toString();
        String seatType = data[5].toString();
        String amount = data[6].toString();

        Log.info("Navigate to Register page.");
        homePage.moveToRegisterPage();
        Log.info("Register new account.");
        registerPage.register(username, password, password, pid);

        Log.info("Navigate to Login page.");
        registerPage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Navigate to Book Ticket page.");
        homePage.moveToBookTicketPage();
        Log.info("Book a new ticket.");
        bookTicketPage.bookTicket(departDate, departFrom, arrivePlace, seatType, amount);

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "Ticket booked Successfully!";
        String actualMessage = bookTicketPage.getBookTicketMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
