package com.cmccarthy.ui.step;

import com.cmccarthy.common.utils.ApplicationProperties;
import com.cmccarthy.ui.page.WikipediaHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;

import static org.springframework.test.util.AssertionErrors.assertTrue;


public class WikipediaPageSteps extends AbstractStep {

    private final Logger logger = LoggerFactory.getLogger(WikipediaPageSteps.class);

   private String searchText;
    private final ApplicationProperties applicationProperties;
    private final WikipediaHomePage wikipediaHomePage;

    public WikipediaPageSteps(ApplicationProperties applicationProperties,
                              WikipediaHomePage wikipediaHomePage) {
        this.applicationProperties = applicationProperties;
        this.wikipediaHomePage = wikipediaHomePage;
    }

    @Given("The user opened the Way2automation Homepage")
    public void userIsOpenMainPage() throws NoSuchFieldException {
        System.out.println("applicationProperties = " + applicationProperties.getWikipediaUrl());
        wikipediaHomePage.open(applicationProperties.getWikipediaUrl());
        logger.info("The user navigated to the Way2automation Homepage : " + applicationProperties
                .getWikipediaUrl());
        assertTrue("Way2automation Homepage should be opened",
                isElementDisplayed(wikipediaHomePage.getCommonPage()));
    }

    @And("The user clicked on the Add user")
    public void theUserClickedOnTheCommonLink() throws NoSuchFieldException {
        click(wikipediaHomePage.getCommonPage());
        logger.info("The user clicked the Add user on the Homepage");
    }
    @And("The user click save button")
    public void theUserClickedOnSaveButton() throws NoSuchFieldException {
        click(wikipediaHomePage.setSave());
        logger.info("The user clicked the Add user on the Homepage");
    }
    @And("The user enter first name {string}")
    public void theUserEnterFirstname(String firstName) throws NoSuchFieldException {
        sendKeys(wikipediaHomePage.setFirstName(),firstName);
        logger.info("first name "+firstName);
    }
    @And("The user enter last name {string}")
    public void theUserEnterLastname(String LastName) throws NoSuchFieldException {
        sendKeys(wikipediaHomePage.setLastName(),LastName);
        logger.info("last name "+LastName);
    }
    @And("The user enter User name {string}")
    public void theUserEnterUsername(String UserName) throws NoSuchFieldException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        searchText = UserName+formattedTime;
        sendKeys(wikipediaHomePage.setUserName(),searchText);
        logger.info("User name "+searchText);
    }
    @And("The user enter password {string}")
    public void theUserEnterPassword(String password) throws NoSuchFieldException {
        sendKeys(wikipediaHomePage.setPassword(),password);
        logger.info("password "+password);
    }
    @And("The user enter email {string}")
    public void theUserEnterEmail(String email) throws NoSuchFieldException {
        sendKeys(wikipediaHomePage.setEmail(),email);
        logger.info("email "+email);
    }
    @And("The user enter mobile phone {string}")
    public void theUserEnterMobilephone(String mobilephone) throws NoSuchFieldException {
        sendKeys(wikipediaHomePage.setInput_mobilephone(),mobilephone);
        logger.info("mobile phone "+mobilephone);
    } @And("The user select roleId {string}")
    public void theUserSelectRoleId (String roleId) throws NoSuchFieldException {
        select(wikipediaHomePage.setRoleId(),roleId);
        logger.info("roleId "+roleId);
    }

    @And("The user select Company {string}")
    public void theUserSelectCompany(String company) throws NoSuchFieldException {
        if(company.equalsIgnoreCase("AAA"))
        {
           click(wikipediaHomePage.setCompanyAAA());
        } else if (company.equalsIgnoreCase("BBB")) {
            click(wikipediaHomePage.setCompanyBBB());
        }

    }
    @Then("check if user name exist")
    public void checkIfUserNameExist() throws NoSuchFieldException {
        isElementDisplayed(wikipediaHomePage.setSystemUserName());
        logger.info("roleId ");
    }
}
