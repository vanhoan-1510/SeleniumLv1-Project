package TestCases;

import Common.FakeData;
import Common.Log;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(dataProvider = "getData", description = "'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page")
    public void BookTicket(Object[] data) {

        String username = FakeData.createRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = FakeData.RandomNumber();
        String expectedHSPrice = data[2].toString();
        String expectedSSPrice = data[3].toString();
        String expectedSSCPrice = data[4].toString();
        String expectedHBPrice = data[5].toString();
        String expectedSBPrice = data[6].toString();
        String expectedSBCPrice = data[7].toString();

        Log.info("Navigate to Register page.");
        homePage.moveToRegisterPage();
        Log.info("Register new account.");
        registerPage.register(username, password, password, pid);

        Log.info("Navigate to Login page.");
        registerPage.moveToLoginPage();
        Log.info("Login to Safe Railway.");
        loginPage.login(username, password);

        Log.info("Navigate to Timetable page.");
        homePage.moveToTimeTablePage();
        Log.info("Check price.");
        timetablePage.setLnkCheckPrice();

        Log.info("Check that the web page displays correctly with the description.");
        String expectedMessage = "Ticket price from Đà Nẵng to Sài Gòn";
        String actualMessage = ticketPricePage.getTicketPriceMessage().getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        String actualHSPrice = ticketPricePage.getHSPrice().getText();
        Assert.assertEquals(expectedHSPrice, actualHSPrice);

        String actualSSPrice = ticketPricePage.getSSPrice().getText();
        Assert.assertEquals(expectedSSPrice, actualSSPrice);

        String actualSSCPrice = ticketPricePage.getSSCPrice().getText();
        Assert.assertEquals(expectedSSCPrice, actualSSCPrice);

        String actualHBPrice = ticketPricePage.getHBPrice().getText();
        Assert.assertEquals(expectedHBPrice, actualHBPrice);

        String actualSBPrice = ticketPricePage.getSBPrice().getText();
        Assert.assertEquals(expectedSBPrice, actualSBPrice);

        String actualSBCPrice = ticketPricePage.getSBCPrice().getText();
        Assert.assertEquals(expectedSBCPrice, actualSBCPrice);
    }
}
