package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.*;
import org.testng.annotations.Test;

public class TC16 extends  TestBase{

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

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
        bookTicketPage.bookTicket(departDate,departFrom, arrivePlace, seatType, amount);

        Log.info("Navigate to My Ticket page.");
        bookTicketPage.moveToMyTicketPage();
        Log.info("Cancel ticket.");
        myTicketPage.cancelTicket();
    }
}
