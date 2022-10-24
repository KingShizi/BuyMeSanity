package Website_Pages;

import Utils.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public void findAGift() throws Exception {
            pickPriceRegionAndCategory();
    }

    //picking price, region and category and clicking search.
    private void pickPriceRegionAndCategory() throws Exception {
            List<WebElement> optionDropBoxes = DriverSingleton.getDriver().findElements(By.className("selected-text"));

            //thought that value can be the uniquest, after multiple tries.
            clickElement(optionDropBoxes.get(0));
            scrollToElement(By.cssSelector("li[value=\"2\"]"));
            clickElement(By.cssSelector("li[value=\"2\"]"));

            clickElement(optionDropBoxes.get(1));
            scrollToElement(By.cssSelector("li[value=\"13\"]"));
            clickElement(By.cssSelector("li[value=\"13\"]"));

            clickElement(optionDropBoxes.get(2));
            scrollToElement(By.cssSelector("li[value=\"359\"]"));
            clickElement(By.cssSelector("li[value=\"359\"]"));

            scrollToElement(By.cssSelector("a[rel=\"nofollow\"]"));
            clickElement(By.cssSelector("a[rel=\"nofollow\"]"));

    }
}
