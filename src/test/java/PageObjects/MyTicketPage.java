package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage{

    private By btnCancel = By.xpath("//div[@class='DivCenter']//input");

    public WebElement getCancelButton(){return Constant.DRIVER.findElement(btnCancel);}

    public void cancelTicket(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", getCancelButton());

        getCancelButton().click();
        Constant.DRIVER.switchTo().alert().accept();
    }
}