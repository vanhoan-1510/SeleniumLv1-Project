package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private By usernameBox = By.xpath("//input[@id='username']");
    private By passwordBox = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//div[@id='content']/form/fieldset/p/input");
    private By lblErrorMessage = By.xpath("//div[@id='content']/p");

    public WebElement getUsernameBox() {return Constant.DRIVER.findElement(usernameBox);}
    public WebElement getPasswordBox() {return Constant.DRIVER.findElement(passwordBox);}
    public WebElement getLoginButton() {return Constant.DRIVER.findElement(btnLogin);}
    public WebElement getErrorMessage() {return Constant.DRIVER.findElement(lblErrorMessage);}

    public HomePage login(String username, String password) {
        this.getUsernameBox().sendKeys(username);
        this.getPasswordBox().sendKeys(password);

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", getLoginButton());

        getLoginButton().click();

        return new HomePage();
    }
}