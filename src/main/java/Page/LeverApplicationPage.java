package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeverApplicationPage extends BasePage{

    public static By submitYourApplication=By.xpath("//h4[contains(text(),'Submit your application')]");

    public LeverApplicationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnLeverApplicationPage(){
        return isDisplayed(submitYourApplication);
    }
}
