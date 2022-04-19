package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By txtHomePageHeader = By.xpath("//div[@id='content']/h1");

    public WebElement getTxtHomePageHeader() {
        return Constant.DRIVER.findElement(txtHomePageHeader);
    }
}
