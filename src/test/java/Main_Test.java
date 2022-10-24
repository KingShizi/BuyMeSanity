import Utils.Constants;
import Utils.DriverSingleton;
import Utils.ReportsSingleton;
import Website_Pages.HomePage;
import Website_Pages.PickBusinessPage;
import Website_Pages.RegistrationPage;
import Website_Pages.SenderAndReceiverInfoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main_Test {

    private WebDriver driver;

    @BeforeClass
    public void beforeAll() throws Exception {
        this.driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        ReportsSingleton.logInfo("before test method");
        ReportsSingleton.report();
        driver.manage().window().fullscreen();

    }

    @Test
    public void test01_registration(){
        RegistrationPage register = new RegistrationPage();
        register.register();
        ReportsSingleton.logPass("Registration passed successfully");
    }

    @Test
    public void test02_searchAGift() throws Exception {
        HomePage home = new HomePage();
        home.findAGift();
        ReportsSingleton.logPass("Searching a gift passed successfully");
    }

    @Test
    public void test03_pickBusiness() {
        PickBusinessPage pickBusiness = new PickBusinessPage();
        pickBusiness.pickBusiness();
        ReportsSingleton.logPass("Picking a business passed successfully");
    }

    @Test
    public void test04_senderAndReceiver() throws Exception {
        SenderAndReceiverInfoPage senderAndReceiver = new SenderAndReceiverInfoPage();
        senderAndReceiver.insertSenderAndReceiverInfo();
        ReportsSingleton.logPass("Sender and Receiver Info test passed successfully");
        ReportsSingleton.logInfo("BuyMe Sanity Test Passed Successfully!!!");
    }

    @AfterClass
    public void afterAll() throws Exception {
        ReportsSingleton.finishReport();
        DriverSingleton.getDriver().quit();
    }
}
