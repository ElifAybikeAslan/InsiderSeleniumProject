package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CareerOpportunitiesPage extends BasePage{

    public static By selectLocator=By.id("filter-by-location");
    public static By selectDepartment=By.id("filter-by-department");
    public static By elementListItem = By.className("position-list-item");
    public static By positionTitle = By.xpath("//p[@class='position-title font-weight-bold']");
    public static By departmentTitle = By.xpath("//span[@class='position-department text-large font-weight-600 text-primary']");
    public static By locationTitle = By.xpath("//div[@class='position-location text-large']");
    public static By positionItem = By.xpath("//*[@id='jobs-list']/div[1]");
    public static By applyNowButton = By.xpath("(//*[contains(text(),'Apply Now')])[1]");

    Select locator;
    WebElement webElement;

    List<WebElement> listPosition;
    List<WebElement> listDepartment;
    List<WebElement> listLocation;

    public enum JobData {
        POSITION("Software"),
        DEPARTMENT("Quality Assurance"),
        LOCATION("Istanbul, Turkey");

        String data;
        JobData(String data){
            this.data = data;
        }
    }


    public CareerOpportunitiesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectLocation(){
        webElement= find(selectLocator);
        locator=new Select(webElement);
        locator.selectByVisibleText(JobData.LOCATION.data);
        sleep(3000);
    }

    public void selectDepartment(){
        webElement=find(selectDepartment);
        locator=new Select(webElement);
        locator.selectByVisibleText(JobData.DEPARTMENT.data);
        sleep(3000);
    }

    public List<WebElement> isOnElementListItem(){
        return findAll(elementListItem);
    }

    public void checkElementListed(){
        listPosition = findAll(positionTitle);
        listDepartment = findAll(departmentTitle);
        listLocation = findAll(locationTitle);

        for (int i=0; i<listPosition.size(); i++) {
            Assert.assertTrue(listPosition.get(i).getText().contains(JobData.POSITION.data),"The position is not as chosen!");
            Assert.assertTrue(listDepartment.get(i).getText().contains(JobData.DEPARTMENT.data),"The department is not as selected!");
            Assert.assertTrue(listLocation.get(i).getText().contains(JobData.LOCATION.data),"The location is not as chosen!");
        }
    }

    public void clickApplyNow(){
        scrollToElement(positionItem);
        moveToElement(positionItem);
        sleep(3000);
        click(applyNowButton);
    }

}
