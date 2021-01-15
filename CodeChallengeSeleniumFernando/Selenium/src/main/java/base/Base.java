package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.Utilities;

public class Base {

    protected Properties pProperties = null;
    protected Utilities oUtilities = null;
    protected DriverBuilder oDriver = null;
    protected WebDriver myDriver;
    private String sBrowser;


    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeClass
    public void beforeEveryClass() throws IOException {
        pProperties = new Properties();
        oDriver = new DriverBuilder();
        FileInputStream fisFileInput = new FileInputStream("Properties/data.properties");
        pProperties.load(fisFileInput);
        sBrowser = pProperties.getProperty("browser");
        String sPageUrl = pProperties.getProperty("baseurl");
        myDriver = oDriver.driverBuilder(sBrowser);
        myDriver.get(sPageUrl);
        myDriver.manage().window().maximize();
        oUtilities = new Utilities();
    }

    @AfterClass
    public void afterEveryClass(){
        myDriver.quit();
    }

    @AfterSuite
    public void afterSuite(){

    }

}
