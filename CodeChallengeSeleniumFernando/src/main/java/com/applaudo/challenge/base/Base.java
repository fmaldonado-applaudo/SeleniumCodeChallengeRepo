package com.applaudo.challenge.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
    public WebDriver myDriver;


    public WebDriver initializeDriver() throws IOException {

        Properties pProperties = new Properties();
        FileInputStream fisFileInput = new FileInputStream("Drivers/data.properties");
        pProperties.load(fisFileInput);
        String sBroweser = pProperties.getProperty("browser");

        if (sBroweser.equals("chrome")) {
            // To run test on chrome
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            myDriver = new ChromeDriver();
        } else if (sBroweser.equals("firefox")) {
            // To run test on firefox
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            myDriver = new FirefoxDriver();

        } else if (sBroweser.equals("IE")) {
            // To run test on internet explorer
            System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
            myDriver = new InternetExplorerDriver();
        }

        // To wait before each test
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return myDriver;
    }
}
