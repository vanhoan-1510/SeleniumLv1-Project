package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    private By lnkTimetablePage = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private By lnkTicketPricePage = By.xpath("//a[@href = '/Page/TrainPriceListPage.cshtml']");
    private By lnkLoginPage = By.xpath("//a[@href='/Account/Login.cshtml']");
    private By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private By lnkBookTicketPage = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By lnkContactPage = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private By lnkRegisterPage = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By lnkMyTicketPage = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private By lnkChangePasswordPage = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private By lnkLogoutTab = By.xpath("//a[@href='/Account/Logout']");

    public WebElement getLnkTimeTablePage() {
        return Constant.DRIVER.findElement(lnkTimetablePage);
    }
    public WebElement getLnkTicketPricePage() {
        return Constant.DRIVER.findElement(lnkTicketPricePage);
    }
    public WebElement getLnkLoginPage() {return Constant.DRIVER.findElement(lnkLoginPage);}
    public WebElement getWelcomeMessage() {
        return Constant.DRIVER.findElement(lblWelcomeMessage);
    }
    public WebElement getLnkBookTicketPage() {return Constant.DRIVER.findElement(lnkBookTicketPage);}
    public WebElement getLnkContactPage() {
        return Constant.DRIVER.findElement(lnkContactPage);
    }
    public WebElement getLnkRegisterPage() {return Constant.DRIVER.findElement(lnkRegisterPage);}
    public WebElement getlnkMyTicketPage(){return Constant.DRIVER.findElement(lnkMyTicketPage);}
    public WebElement getLnkChangePasswordPage() {return Constant.DRIVER.findElement(lnkChangePasswordPage);}
    public WebElement getLnkLogoutTab() {return Constant.DRIVER.findElement(lnkLogoutTab);}

    public void moveToTimeTablePage() {
        getLnkTimeTablePage().click();
    }
    public void moveToLoginPage() {
        getLnkLoginPage().click();
    }
    public void moveToBookTicketPage() {
        getLnkBookTicketPage().click();
    }
    public void moveToContactPage() {
        getLnkContactPage().click();
    }
    public void moveToRegisterPage() {
        getLnkRegisterPage().click();
    }
    public void moveToMyTicketPage() {getlnkMyTicketPage().click();}
    public void moveToChangePasswordPage() {getLnkChangePasswordPage().click();}
    public void loggingOut() {getLnkLogoutTab().click();}
}