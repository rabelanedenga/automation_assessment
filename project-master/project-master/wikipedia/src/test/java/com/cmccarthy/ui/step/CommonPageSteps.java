package com.cmccarthy.ui.step;

import com.cmccarthy.ui.page.Way2automationCommonPage;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class CommonPageSteps extends AbstractStep {

    private final Logger logger = LoggerFactory.getLogger(CommonPageSteps.class);
    @Autowired
    private Way2automationCommonPage way2automationCommonPage;

    @Then("The user should be on the Common page")
    public void theUserShouldBeOnTheCommonPage() {
        logger.info("The Way2automation Common page should be opened");
        assertTrue("Way2automation Common page should be opened",
                isElementDisplayed(way2automationCommonPage.getCentralLogo()));
    }
}
