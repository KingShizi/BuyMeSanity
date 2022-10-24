package Utils;

import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() throws Exception {
        if (driver==null){
            try {
                if (Constants.BROWSER.equalsIgnoreCase("chrome"))
                    System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }catch (Exception e){
                e.printStackTrace();
                ReportsSingleton.logFail("Driver connection failed! " + e.getMessage());
                throw new Exception("Driver failed");
            }
        }
        return driver;
    }

}
