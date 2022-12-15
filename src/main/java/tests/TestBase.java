package tests;

import driver.ChromeDriverManager;
import driver.DriverManager;
import driver.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CampaignEditPage;
import pages.CampaignsPage;
import pages.DashboardPage;
import utils.LoginUtils;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    private DriverManager driverManager;
    protected Logger logger;
    protected WebDriver webDriver;
    private static int DEFAULT_PAGE_LOAD_TIMEOUT_SECONDS = 10;

    protected String urlHomePage;
    protected DashboardPage dashboardPage;
    protected CampaignsPage campaignsPage;
    protected CampaignEditPage campaignEditPage;

    @BeforeSuite
    public void beforeSuite() {
        readAppProperties();
    }

    @Parameters({ "browser" })
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) {
        setupDriver(browserName);
        setupLogger();
        instantiatePages();
        loginCristianMoga();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driverManager.quitDriver();
    }

    private void setupDriver(String browser) {
        driverManager = getDriverManager(browser);
        webDriver = driverManager.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DEFAULT_PAGE_LOAD_TIMEOUT_SECONDS));
    }

    private void setupLogger() {
        logger = LogManager.getLogger();
    }

    private void instantiatePages() {
        dashboardPage = new DashboardPage(webDriver, logger);
        campaignsPage = new CampaignsPage(webDriver,logger);
        campaignEditPage = new CampaignEditPage(webDriver, logger);
    }

    private void loginCristianMoga() {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        webDriver.get(urlHomePage);
        LoginUtils.loginCristianMoga(robot);
    }

    private void readAppProperties() {
        String fileSeparator = System.getProperty("file.separator");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") +
                    "_src_main_resources_app.properties"
                            .replace("_", fileSeparator)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        urlHomePage = properties.getProperty("urlHomePage");
    }

    private DriverManager getDriverManager(String browser) {
        DriverManager driverManager;
        switch (browser.toLowerCase()) {
            case ("chrome"):
                driverManager = new ChromeDriverManager();
                break;
            case ("firefox"):
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }

    protected void waitTime(int milies) {
        try {
            Thread.sleep(milies);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
