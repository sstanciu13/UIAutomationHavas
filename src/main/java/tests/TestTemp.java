package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTemp extends TestBase {

    @Test
    public void testtemp() {
        logger.info("Starting test ...");
        dashboardPage.selectBuyingOrganizationHavasMedia();
        dashboardPage.accessCampaignsTab();

        campaignsPage.fillInSearchByText("Action");
        campaignsPage.perfomSearch();

        campaignsPage.editCampaign("Action Aid September");

        campaignEditPage.accessPlanningTab();
        Assert.assertTrue(campaignEditPage.verifyPlanningTabIsActive());

        campaignEditPage.accessCampaignTab();
        Assert.assertTrue(campaignEditPage.verifyCampaignTabIsActive());

        waitTime(5000);
    }
}
