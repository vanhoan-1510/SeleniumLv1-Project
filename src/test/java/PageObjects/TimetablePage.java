package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    private By lnkCheckPrice = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..//a[contains(@href, 'TicketPrice')]");

    public WebElement getLnkCheckPrice() {return Constant.DRIVER.findElement(lnkCheckPrice);}

    public void setLnkCheckPrice() {
        Constant.DRIVER.navigate().refresh();

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", getLnkCheckPrice());

        getLnkCheckPrice().click();
    }
}
