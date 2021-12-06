package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static By homePageNavigationBar=By.id("navigation");
    public static By homePageAcceptCookies=By.id("wt-cli-accept-btn");
    public static By homePageMoreButton = By.xpath("//span[contains(text(),'More')]");
    public static By homePageMoreCareersMenu = By.xpath("//h5[contains(text(),'Careers')]");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnHomePage(){
        return isDisplayed(homePageNavigationBar);
    }


    public void acceptCookies(){
        if(isDisplayed(homePageAcceptCookies)){
            click(homePageAcceptCookies);
        }
    }

    public void clickMoreMenu(){
        click(homePageMoreButton);
    }

    public boolean isOnMoreDropDownMenu(){
        return isDisplayed(homePageMoreCareersMenu);
    }

    public void clickCareersMenuItem(){
        click(homePageMoreCareersMenu);
    }
}
