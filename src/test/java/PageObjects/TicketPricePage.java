package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {

    private By lblTicketPriceMessage = By.xpath("//div[@id='content']/div/div/table/tbody/tr[@class='TableSmallHeader']/th");
    private By hsPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='HS']/preceding-sibling::td)+1]");
    private By ssPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='SS']/preceding-sibling::td)+1]");
    private By sscPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='SSC']/preceding-sibling::td)+1]");
    private By hbPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='HB']/preceding-sibling::td)+1]");
    private By sbPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='SB']/preceding-sibling::td)+1]");
    private By sbcPrice = By.xpath("//th[@class='RowHeader']/../following-sibling::tr/th[@class='RowHeader']/following-sibling::td[count(//td[text()='SBC']/preceding-sibling::td)+1]");

    public WebElement getTicketPriceMessage() {return Constant.DRIVER.findElement(lblTicketPriceMessage);}
    public WebElement getHSPrice() {return Constant.DRIVER.findElement(hsPrice);}
    public WebElement getSSPrice() {return Constant.DRIVER.findElement(ssPrice);}
    public WebElement getSSCPrice() {return Constant.DRIVER.findElement(sscPrice);}
    public WebElement getHBPrice() {return Constant.DRIVER.findElement(hbPrice);}
    public WebElement getSBPrice() {return Constant.DRIVER.findElement(sbPrice);}
    public WebElement getSBCPrice() {return Constant.DRIVER.findElement(sbcPrice);}
}
