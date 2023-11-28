package com.cmccarthy.ui.page;

import com.cmccarthy.ui.annotations.PageObject;
import com.cmccarthy.ui.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@PageObject
public class Way2automationCommonPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "/html/body/table/thead/tr[2]/td/button")
    private WebElement centralLogo;

    public Way2automationCommonPage(DriverManager driverManager) {
        super(driverManager);
    }

    public WebElement getCentralLogo() {
        return centralLogo;
    }
}

