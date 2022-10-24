package Website_Pages;

import Utils.ReportsSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PickBusinessPage extends BasePage {

    public void pickBusiness(){
            assertURL();
            pickBusinessAndSelect();
    }

    //this will be used to assert the current URL.
    private void assertURL(){
        try {
            Assert.assertEquals(getCurrentURL(), "https://buyme.co.il/search?budget=2&category=359&region=13");
        }catch (AssertionError e) {
            ReportsSingleton.logFail("Search a Gift URL isn't as expected" + "\n" + e.getMessage());
            throw new AssertionError();
        }
    }

    //picking derech hayayn business and selecting an option from store.
    private void pickBusinessAndSelect(){
        clickElement(By.cssSelector("img[title=\"דרך היין\"]"));

        clickElement(By.cssSelector("img[src=\"https://buyme.co.il/files/packages/private/packageImage11618608.jpg?v=1663844442?\"]"));

        //just in case..
        //clickElement(By.id("ember2297"));
    }
}
