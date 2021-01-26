package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class DriverBuilder {


    public WebDriver driverBuilder(String sBrowser) {
        WebDriver myDriver;
        switch (sBrowser) {
            case "chrome":
                // To run test on chrome
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                myDriver = new ChromeDriver();
                break;
            case "firefox":
                // To run test on firefox
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                myDriver = new FirefoxDriver();
                break;
            case "IE":
                // To run test on internet explorer
                System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
                myDriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sBrowser);
        }
        // To wait for the elements in the page to fully load
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return myDriver;
    }
}
