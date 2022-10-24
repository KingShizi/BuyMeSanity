package Website_Pages;

import Utils.ReportsSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SenderAndReceiverInfoPage extends BasePage {

    public void insertSenderAndReceiverInfo() throws Exception {
        senderAndGreetingInfo();
        receiverInfo();
    }

    //Insert sender and greeting info
    private void senderAndGreetingInfo() throws Exception {
        clickElement(By.cssSelector("input[type=\"text\"]"));
        sendKeysToElement(By.cssSelector("input[type=\"text\"]"), "קייסי");
        clickElement(By.cssSelector("div[class=\"selected-name\"]"));
        clickElement(By.cssSelector("li[value=\"10\"]"));

        By greetingTextBox = By.cssSelector("textarea[data-parsley-group=\"voucher-greeting\"]");
        clickElement(greetingTextBox);
        clearText(greetingTextBox);
        sendKeysToElement((greetingTextBox), "mazal tov!");

        sendKeysToElement(By.cssSelector("input[type=\"file\"]"), "/Users/shirazelbaz/Documents/Automation Class Java Projects/BuyMeWebsite-Shiraz/Group1.png");
        scrollToElement(By.cssSelector("button[type=\"submit\"]"));
        clickElement(By.cssSelector("button[type=\"submit\"]"));
    }

    //insert receiver info and asserting both sender and receiver names from the pre-receipt.
    private void receiverInfo() throws Exception {
        clickElement(By.cssSelector("svg[gtm=\"method-email\"]"));
        clickElement(By.id("email"));
        sendKeysToElement(By.id("email"), "s@s.com");
        scrollToElement(By.cssSelector("button[type=\"submit\"]"));
        clickElement(By.cssSelector("button[type=\"submit\"]"));

        clickElement(By.cssSelector("svg[id=\"eye\"]"));
        scrollToElement(By.className("recipient-sender"));
        String receiverAndSenderName = getText(By.className("recipient-sender"));
        System.out.println(receiverAndSenderName);
        try {
            Assert.assertEquals(receiverAndSenderName, "קייסי, זה היום שלך! קיבלת הרגע מתנה משיזי");
        }catch (AssertionError e){
            ReportsSingleton.logFail("Sender and Receiver names aren't as expected" + "\n" + e.getMessage());
            throw new AssertionError();
        }

    }

}
