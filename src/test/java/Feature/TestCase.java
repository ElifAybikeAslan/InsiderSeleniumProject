package Feature;

import Page.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCase extends BaseTest {

    HomePage homePage;
    CareersPage careersPage;
    CareerOpportunitiesPage careerOpportunitiesPage;
    PositionDetailPage positionDetailPage;
    LeverApplicationPage leverApplicationPage;

    @Test
    public void isOnHomePage(){
        homePage = new HomePage(webDriver);
        careersPage = new CareersPage(webDriver);
        careerOpportunitiesPage = new CareerOpportunitiesPage(webDriver);
        positionDetailPage = new PositionDetailPage(webDriver);
        leverApplicationPage = new LeverApplicationPage(webDriver);

        homePage.acceptCookies();
        Assertions.assertTrue(homePage.isOnHomePage(),
                "Not on Home Page!");
        homePage.clickMoreMenu();
        homePage.isOnMoreDropDownMenu();
        homePage.clickCareersMenuItem();

        careersPage.checkCareersPageFields();
        careersPage.clickFindYourJob();

        careerOpportunitiesPage.selectLocation();
        careerOpportunitiesPage.selectDepartment();
        Assertions.assertTrue(careerOpportunitiesPage.isOnElementListItem().size()>0,
                "Quality Assurance position not listed!");
        careerOpportunitiesPage.checkElementListed();
        careerOpportunitiesPage.clickApplyNow();

        positionDetailPage.isOnPositionsDetailPage();
        positionDetailPage.clickApplyForThisJob();

        Assertions.assertTrue(leverApplicationPage.isOnLeverApplicationPage(),
                "Not on Lever Application Page!");

    }
}
