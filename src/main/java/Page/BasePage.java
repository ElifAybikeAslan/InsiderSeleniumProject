package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class BasePage {

    WebDriver webDriver;
    Actions actions;

    protected BasePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    protected WebElement find(By locator){
        return webDriver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return webDriver.findElements(locator);
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected void type(By locator,String text){
        find(locator).sendKeys(text);
    }

    protected Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    protected void scrollToElement(By locator) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", find(locator));
    }

    protected void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    protected void moveToElement (By locator) {
        actions = new Actions(webDriver);
        actions.moveToElement(find(locator)).build().perform();
    }

    protected void switchToWindow() {
        String mainWindow = webDriver.getWindowHandle();
        for (String lastWindow : webDriver.getWindowHandles()) {
            if (!mainWindow.contentEquals(lastWindow)) {
                webDriver.switchTo().window(lastWindow);
                break;
            }
        }
    }
}
