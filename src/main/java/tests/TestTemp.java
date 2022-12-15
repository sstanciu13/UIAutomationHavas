package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTemp extends TestBase {

    @Test
    public void testtemp1() {
        logger.info("Starting test 1 ...");
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

    @Test
    public void testtemp2() {
        logger.info("Starting test 2 ...");
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
