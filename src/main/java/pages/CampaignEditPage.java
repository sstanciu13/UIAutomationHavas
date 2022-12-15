package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class CampaignEditPage extends BasePage{
    static final String LIGHT_BLUE_CHROME = "rgba(0, 174, 208, 1)";
    static final String LIGHT_BLUE_FIREFOX = "rgb(0, 174, 208)";

    public CampaignEditPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    
    /**
     * *************************************** PRIVATE LOCATORS SECTION ***************************************
     * Keep the order of the locators from top of the page to bottom of the page
     */

    private By tab(Tab tab) {
        return By.xpath("//div[@role='tab'][contains(text(), '" + tab.label + "')]");
    }

    private By loadingSpinnerChangeTab() {
        return By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
    }


    /**
     * *************************************** PUBLIC TEST METHODS ***************************************
     */

    public void accessPlanningTab() {
        clickElement(tab(Tab.Planning));
        waitForSpinner(loadingSpinnerChangeTab());
    }

    public boolean verifyPlanningTabIsActive() {
        return (getCSSValue(tab(Tab.Planning), "color").equals(LIGHT_BLUE_CHROME) ||
                getCSSValue(tab(Tab.Planning), "color").equals(LIGHT_BLUE_FIREFOX));
    }

    public void accessCampaignTab() {
        clickElement(tab(Tab.Campaign));
        waitForSpinner(loadingSpinnerChangeTab());
    }

    public boolean verifyCampaignTabIsActive() {
        return (getCSSValue(tab(Tab.Campaign), "color").equals(LIGHT_BLUE_CHROME) ||
                getCSSValue(tab(Tab.Campaign), "color").equals(LIGHT_BLUE_FIREFOX));
    }


    /**
     * *************************************** PRIVATE METHODS SECTION ***************************************
     */

    private void waitForSpinner(By spinnerLocator){
        try {
            waitForElementToBeVisible(spinnerLocator, 2);
        } catch (TimeoutException timeoutException) {
            logger.debug("Spinner was not detected.");
        }
        waitForElementToBeInvisible(spinnerLocator);
    }


    /**
     * *************************************** PRIVATE ENUMS SECTION ***************************************
     */

    private enum Tab {
        Campaign("Campaign"),
        Planning("Planning");

        public final String label;
        private Tab(String label) {
            this.label = label;
        }
    }
}
