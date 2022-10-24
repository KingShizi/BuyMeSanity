package Utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;

public class Constants {

    public static final String CHROMEDRIVER_PATH = "/Users/shirazelbaz/Downloads/chromedriver";
    public static final String BROWSER;
    public static final String URL;

    static {
        try {
            URL = getData("URL");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            BROWSER = getData("browserType");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static String getData (String keyName) throws Exception{
        File fXmlFile = new File("/Users/shirazelbaz/Documents/Automation Class Java Projects/BuyMeWebsite-Shiraz/src/main/resources/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
