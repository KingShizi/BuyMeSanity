package Website_Pages;

import Utils.ReportsSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public void register(){
            clickToRegister();
            insertAndAssertAllInfo("שיזי", "s@elbaz.com", "Sh123456");
    }


    //click the כניסה/הרשמה button and then clicks on sign up
    private void clickToRegister(){
        clickElement(By.className("notSigned"));
        clickElement(By.cssSelector("span[class=\"text-link theme\"]"));
    }

    //inserts info to sign up form , asserting and submitting
    private void insertAndAssertAllInfo(String name, String mail, String password){
        sendKeysToElement(By.cssSelector("input[placeholder=\"שם פרטי\"]"), name);
        sendKeysToElement(By.cssSelector("input[type=\"email\"]"), mail);
        sendKeysToElement(By.cssSelector("input[type=\"password\"]"), password);
        sendKeysToElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"), password);

        try {
            Assert.assertEquals(getElementTextValue(By.cssSelector("input[placeholder=\"שם פרטי\"]")), name);
            Assert.assertEquals(getElementTextValue(By.cssSelector("input[type=\"email\"]")), mail);
            Assert.assertEquals(getElementTextValue(By.cssSelector("input[type=\"password\"]")), password);
        }catch (AssertionError e) {
            ReportsSingleton.logFail("Name, Email or Password aren't as expected" + "\n" + e.getMessage());
            throw new AssertionError();
        }

        clickElement(By.cssSelector("circle[class=\"fill\"]"));
        clickElement(By.cssSelector("button[type=\"submit\"]"));

    }
}
