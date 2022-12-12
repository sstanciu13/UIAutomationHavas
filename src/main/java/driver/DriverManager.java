package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (null != driver.get()) {
            try {
                driver.get().quit();
                driver.remove();
            } catch (Exception e) {
                System.out.println("Unable to gracefully quit WebDriver." + e);
            }
        }
    }

    public WebDriver getDriver() {
        if (null == driver.get()) {
            driver.set(this.createDriver());
        }
        return driver.get();
    }
}
