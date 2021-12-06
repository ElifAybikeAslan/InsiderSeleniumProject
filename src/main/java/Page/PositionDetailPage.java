package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PositionDetailPage extends BasePage{

    public static By positionTitle = By.className("posting-headline");
    public static By applyForThisJob = By.xpath("//div[@class='postings-btn-wrapper']/a[text()='Apply for this job']");
    public static By positionDescription = By.cssSelector("div:nth-child(2) > div> h3");

    public PositionDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isOnPositionsDetailPage(){
        switchToWindow();
        Assert.assertTrue(isDisplayed(positionTitle),"You are not on the position detail page!");
        Assert.assertTrue(isDisplayed(applyForThisJob),"You are not on the position detail page!");
        Assert.assertTrue(isDisplayed(positionDescription),"You are not on the position detail page!");
    }

    public void clickApplyForThisJob(){
        click(applyForThisJob);
    }
}
