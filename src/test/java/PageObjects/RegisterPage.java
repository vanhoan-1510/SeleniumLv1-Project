package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private By usernameBox = By.xpath("//input[@id='email']");
    private By passwordBox = By.xpath("//input[@id='password']");
    private By confirmPasswordBox = By.xpath("//input[@id='confirmPassword']");
    private By passportBox = By.xpath("//input[@id='pid']");
    private By btnRegister = By.xpath("//form[@id='RegisterForm']/fieldset/p/input");
    private By lblMessage = By.xpath("//div[@id='content']/p");
    private By lblErrorMessage = By.xpath("//div[@id='content']/p/following-sibling::p");
    private By lblPswErrorMessage = By.xpath("//form[@id='RegisterForm']/fieldset/ol/li[2]/label[2]");
    private By lblPidErrorMessage = By.xpath("//form[@id='RegisterForm']/fieldset/ol/li[4]/label[2]");


    public WebElement getUserNameBox() {
        return Constant.DRIVER.findElement(usernameBox);
    }
    public WebElement getPasswordBox() {
        return Constant.DRIVER.findElement(passwordBox);
    }
    public WebElement getConfirmPasswordBox() {
        return Constant.DRIVER.findElement(confirmPasswordBox);
    }
    public WebElement getPassportBox() {
        return Constant.DRIVER.findElement(passportBox);
    }
    public WebElement getBtnRegister() {
        return Constant.DRIVER.findElement(btnRegister);
    }
    public WebElement getMessage() {return Constant.DRIVER.findElement(lblMessage);}
    public WebElement getErrorMessage() {return Constant.DRIVER.findElement(lblErrorMessage);}
    public WebElement getPswErrorMessage() {return Constant.DRIVER.findElement(lblPswErrorMessage);}
    public WebElement getPidErrorMessage() {return Constant.DRIVER.findElement(lblPidErrorMessage);}

    public RegisterPage register(String username, String password, String confirm, String passport) {
        this.getUserNameBox().sendKeys(username);
        this.getPasswordBox().sendKeys(password);
        this.getConfirmPasswordBox().sendKeys(confirm);
        this.getPassportBox().sendKeys(passport);

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", getBtnRegister());
        getBtnRegister().click();

        return new RegisterPage();
    }
}