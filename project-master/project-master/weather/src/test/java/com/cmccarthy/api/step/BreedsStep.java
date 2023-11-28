package com.cmccarthy.api.step;

import com.cmccarthy.api.service.BreedsService;
import com.cmccarthy.common.service.StepDefinitionDataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Arrays;

public class BreedsStep {

    private final Logger logger = LoggerFactory.getLogger(BreedsStep.class);
    @Autowired
    private BreedsService breedsService;
    @Autowired
    private StepDefinitionDataManager stepDefinitionDataManager;
    private  String responseBody ="";
    private   Response response;
    @Then("Verify retriever breed is within the list")
    public void theWeatherForDublinShouldBeReturned() {
        Assert.assertTrue(response.jsonPath().getList("message.retriever").containsAll(Arrays.asList("chesapeake", "curly", "flatcoated", "golden")),
                "Retriever breed is not present in the list");

    }
    @Then("Verify sub-breeds for retriever breed is within the list")
    public void verifySubBreed() {
        Assert.assertTrue(response.jsonPath().getList("message").containsAll(Arrays.asList("chesapeake", "curly", "flatcoated", "golden")),
                "Retriever breed is not present in the list");

    }

    @Given("The user has requested the list of all dog breeds")
    public void theUserHasRequestedTheWeatherForDublin() {
        RestAssured.baseURI = "https://dog.ceo";

        // Send GET request and store the response
        response = RestAssured.given().get("/api/breeds/list/all");

        // Extract the JSON response body as a string
        responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @Given("The user has requested the list of sub-breeds for retriever")
    public void subBreedsForRetriever() {
        RestAssured.baseURI = "https://dog.ceo";

        // Send GET request and store the response
        response = RestAssured.given().get("/api/breed/retriever/list");

        // Extract the JSON response body as a string
        responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
}