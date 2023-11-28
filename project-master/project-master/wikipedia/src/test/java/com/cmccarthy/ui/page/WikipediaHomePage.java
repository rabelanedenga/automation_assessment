package com.cmccarthy.ui.page;

import com.cmccarthy.ui.annotations.PageObject;
import com.cmccarthy.ui.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@PageObject
public class WikipediaHomePage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add User')]")
    private WebElement COMMONS_LOGO;
    @FindBy(how = How.XPATH, using = "//*[text()='searchText']")
    private WebElement searchText;
    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement input_firstName;
    @FindBy(how = How.NAME, using = "LastName")
    private WebElement input_lastName;
    @FindBy(how = How.NAME, using = "UserName")
    private WebElement input_userName;
    @FindBy(how = How.NAME, using = "Password")
    private WebElement input_password;
    @FindBy(how = How.CSS, using = "button[ng-click='save(user)']")
    private WebElement btn_save;
    @FindBy(how = How.CSS, using = "input[type='radio'][value='15']")
    private WebElement companyAAA;
    @FindBy(how = How.XPATH, using = "input[type='radio'][value='16']")
    private WebElement companyBBB;
    @FindBy(how = How.NAME, using = "Email")
    private WebElement input_email;
    @FindBy(how = How.NAME, using = "Mobilephone")
    private WebElement input_mobilephone;
    @FindBy(how = How.NAME, using = "RoleId")
    private WebElement select_roleId;

    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr[1]/td[3]")
    private WebElement systemUserName;

    public WikipediaHomePage(DriverManager driverManager) {
        super(driverManager);
    }

    public void open(String url) {
        openAt(url);
    }

    public WebElement getCommonPage() {
        return COMMONS_LOGO;
    }
    public WebElement setFirstName() {
        return input_firstName;
    }
    public WebElement setLastName() {
        return input_lastName;
    }
    public WebElement setUserName() {
        return input_userName;
    }
    public WebElement setPassword() {
        return input_password;
    }
    public WebElement setCompanyAAA() {
        return companyAAA;
    }
    public WebElement setCompanyBBB() {
        return companyBBB;
    }
    public WebElement setEmail() {
        return input_email;
    }
    public WebElement setSystemUserName() {
        return systemUserName;
    }
    public WebElement setInput_mobilephone() {
        return input_mobilephone;
    }
    public WebElement setRoleId() {
        return select_roleId;
    }public WebElement setSave() {
        return btn_save;
    }public WebElement setSearchText() {
        return searchText;
    }


}

