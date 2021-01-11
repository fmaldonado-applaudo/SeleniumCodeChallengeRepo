package com.applaudo.challenge.tests.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.applaudo.challenge.tests.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {

    protected Properties pProperties = null;
    protected Utilities oUtilities = null;
    protected WebDriver myDriver;
    private String sBrowser;


    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeClass
    public void beforeEveryClass() throws IOException {
        pProperties = new Properties();
        FileInputStream fisFileInput = new FileInputStream("Properties/data.properties");
        pProperties.load(fisFileInput);
        sBrowser = pProperties.getProperty("browser");
        String sPageUrl = pProperties.getProperty("baseurl");
        driverBuilder();
        myDriver.get(sPageUrl);
        myDriver.manage().window().maximize();
        oUtilities = new Utilities();
    }

    @AfterSuite
    public void afterSuite(){

    }

    public WebDriver driverBuilder() {
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
        }
        // To wait for the elements in the page to fully load
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return myDriver;
    }
}
