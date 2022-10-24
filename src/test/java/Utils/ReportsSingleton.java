package Utils;

import Utils.DriverSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

public class ReportsSingleton {
    // create the report object, path and name
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMe - Sanity Test", "Will preform an automated sanity test for the BuyMe website.");

    //function to call from before test - will insert details in the beginning of the run.
    public static void report() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("/Users/shirazelbaz/Documents/Automation Class Java Projects/BuyMeWebsite-Shiraz");
        extent.attachReporter(htmlReporter);

        // screenshot
        try {
            test.info(" ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriver(), String.valueOf(Time.valueOf(LocalTime.now())))).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //like a setter for the using the log fail function from outside
    public static void logPass(String info){
        test.pass(info);
    }

    //like a setter for the using the log fail function from outside
    public static void logFail(String info){
        try {
            test.fail(info, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriver(), "scrnshot")).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //like a setter for the using the log info function from outside
    public static void logInfo(String info){
        test.info(info);
    }

    //like a getter for the using the flush function from outside
    public static void finishReport(){
        extent.flush();
    }

    //function to use for taking screenshots
    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }

}
