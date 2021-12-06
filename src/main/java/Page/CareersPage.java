package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareersPage extends BasePage{

    public static By careerPageHead = By.id("page-head");
    public static By findYourDreamJob=By.xpath("(//a[contains(text(),'Find your dream job')])[1]");
    public static By ourStory = By.xpath("//h2[contains(text(),'Our story')]");
    public static By seeAllTeams = By.xpath("//a[contains(text(),'See all teams')]");
    public static By ourLocations = By.xpath("//h3[contains(text(),'Our Locations')]");
    public static By lifeAtInsider = By.xpath("//h2[contains(text(),'Life at Insider')]");
    public static By createYourLifesWork = By.xpath("//h3[contains(text(),'Create your life’s work ')]");

    public CareersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkCareersPageFields(){
        scrollToElement(ourStory);
        sleep(3000);
        Assert.assertTrue(isDisplayed(ourStory),"Our Story is not on screen!");

        scrollToElement(seeAllTeams);
        sleep(3000);
        Assert.assertTrue(isDisplayed(seeAllTeams),"See All Teams is not on screen!");

        scrollToElement(ourLocations);
        sleep(3000);
        Assert.assertTrue(isDisplayed(ourLocations),"Our Locations is not on screen!");

        scrollToElement(findYourDreamJob);
        sleep(3000);
        Assert.assertTrue(isDisplayed(findYourDreamJob),"Find Your Dream Job is not on screen!");

        scrollToElement(lifeAtInsider);
        sleep(3000);
        Assert.assertTrue(isDisplayed(lifeAtInsider),"Life At Insider is not on screen!");

        scrollToElement(createYourLifesWork);
        sleep(3000);
        Assert.assertTrue(isDisplayed(createYourLifesWork),"Create Your Lifes Work is not on screen!");

        scrollToElement(careerPageHead);
        sleep(3000);
        Assert.assertTrue(isDisplayed(careerPageHead),"Career Page Head is not on screen!");
    }

    public void clickFindYourJob(){
        click(findYourDreamJob);
    }
}
