package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }


    /**
     * *************************************** PRIVATE LOCATORS SECTION ***************************************
     * Keep the order of the locators from top of the page to bottom of the page
     */

    private By selectBuyingOrganizationDropdown() {
        return By.xpath("//header//span[text()='Select Buying Organisation']/parent::div");
    }

    private By selectBuyingOrganizationOption(BuyingOrganization buyingOrganization) {
        return By.xpath("//div[@class='ant-select-item-option-content'][text()='" + buyingOrganization.label + "']");
    }

    private By dashboardTab(DashboardTab dashboardTab) {
        return By.xpath("//a[@href='" + dashboardTab.label + "']");
    }

    private By loadingSpinnerCampaigns() {
        return By.xpath("//div[@class='ant-spin-text']");
    }


    /**
     * *************************************** PUBLIC TEST METHODS ***************************************
     */

    public void selectBuyingOrganizationHavasMedia() {
        clickElement(selectBuyingOrganizationDropdown());
        clickElement(selectBuyingOrganizationOption(BuyingOrganization.HavasMedia));
    }

    public void accessCampaignsTab() {
        clickElement(dashboardTab(DashboardTab.Campaigns));
        waitForSpinnerCampaigns();
    }


    /**
     * *************************************** PRIVATE METHODS SECTION ***************************************
     */

    private void waitForSpinnerCampaigns(){
        waitForElementToBeVisible(loadingSpinnerCampaigns());
        waitForElementToBeInvisible(loadingSpinnerCampaigns());
    }


    /**
     * *************************************** PRIVATE ENUMS SECTION ***************************************
     */

    private enum DashboardTab {
        Campaigns("/campaigns"),
        DraftInvoices("/draft-invoices"),
        Invoices("/invoices"),
        CampaignApproval("/campaigns/campaign-approval"),
        BookingQuery("/booking-query");

        public final String label;
        private DashboardTab(String label) {
            this.label = label;
        }
    }

    private enum BuyingOrganization {
        SelectAll("Select All"),
        HMI("HMI"),
        HavasEntertainment("Havas Entertainment"),
        HavasMedia("Havas Media");

        public final String label;
        private BuyingOrganization(String label) {
            this.label = label;
        }
    }
}
