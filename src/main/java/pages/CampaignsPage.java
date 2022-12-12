package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignsPage extends BasePage{

    public CampaignsPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    
    /**
     * *************************************** PRIVATE LOCATORS SECTION ***************************************
     * Keep the order of the locators from top of the page to bottom of the page
     */

    private By searchByInput() {
        return By.xpath("//input[@id='SearchBy']");
    }

    private By searchButton() {
        return By.xpath("//button[@id='campSearchBtn']");
    }

    private By tableCampaignName(String campaignName) {
        return By.xpath("//div[@id='campaignName']//span[text()='" + campaignName + "']/parent::a");
    }

    private By loadingSpinnerCampaigns() {
        return By.xpath("//div[@class='ant-spin-text']");
    }

    private By loadingSpinnerEditCampaign() {
        return By.xpath("//div[@class='spinner']");
//        return By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
    }


    /**
     * *************************************** PUBLIC TEST METHODS ***************************************
     */

    public void fillInSearchByText(String text) {
        fillInInput(searchByInput(), text);
    }

    public void perfomSearch() {
        clickElement(searchButton());
        waitForSpinner(loadingSpinnerCampaigns());
    }

    public void editCampaign(String campaignName) {
        clickElement(tableCampaignName(campaignName));
        waitForSpinner(loadingSpinnerEditCampaign());
    }


    /**
     * *************************************** PRIVATE METHODS SECTION ***************************************
     */

    private void waitForSpinner(By spinnerLocator){
        waitForElementToBeVisible(spinnerLocator);
        waitForElementToBeInvisible(spinnerLocator);
    }


    /**
     * *************************************** PRIVATE ENUMS SECTION ***************************************
     */

}
