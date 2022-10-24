package Website_Pages;

import Utils.DriverSingleton;
import Utils.ReportsSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage {

    //this will be used to click on any element by locator.
    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
        }catch (Exception e){
            ReportsSingleton.logFail("Element isn't clickable! " +"\n" + e.getMessage());
            ReportsSingleton.report();
            throw new RuntimeException();
        }
    }

    //this will be used to click on any element.
    public void clickElement(WebElement element){
        element.click();
    }

    //this will be used to clear text from a text box element.
    public void clearText(By locator){
        getWebElement(locator).clear();
    }

    //this will be used to send keys to any element using a locator.
    public void sendKeysToElement(By locator, String text){
        getWebElement(locator).sendKeys(text);
    }

    //this will be used to get element text value.
    public String getElementTextValue(By locator){
        return getWebElement(locator).getAttribute("value");
    }

    //this will be used to get element text.
    public String getText(By locator){
        return getWebElement(locator).getText();
    }
    //this will be used to get the current URL.
    public String getCurrentURL(){
        try {
            return DriverSingleton.getDriver().getCurrentUrl();
        } catch (Exception e) {
            ReportsSingleton.logFail("Couldn't find current URL! " +"\n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //this will be used to scroll to any element.
    public void scrollToElement(By locator) throws Exception {
        WebElement element = getWebElement(locator);
            ((JavascriptExecutor) DriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    //this will be used to find an element and will return the element,
    //and inserting a scrn shot if it doesn't work
    private WebElement getWebElement(By locator){
        try {
            return DriverSingleton.getDriver().findElement(locator);
        } catch (Exception e) {
            e.printStackTrace();
            ReportsSingleton.logFail("Element wasn't found! " +"\n" + e.getMessage());
            ReportsSingleton.report();
            throw new RuntimeException(e);
        }


    }
}
