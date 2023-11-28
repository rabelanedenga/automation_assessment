package com.cmccarthy.api.model.response;


import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Test {

    public class DogApiTest {

        public static void main(String[] args) {
            // Set the base URI
            RestAssured.baseURI = "https://dog.ceo";

            // Send GET request and store the response
            Response response = RestAssured.given().get("/api/breeds/list/all");

            // Extract the JSON response body as a string
            String responseBody = response.getBody().asString();
            System.out.println("Response Body: " + responseBody);

//            // Perform assertions
//            Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200 OK");
//
//            // Example assertion: Check if "status" is "success"
//            Assert.assertEquals(response.jsonPath().getString("status"), "success", "Status is not success");
//
//            // Example assertion: Check if the "affenpinscher" breed is present
//            Assert.assertTrue(response.jsonPath().getString("message.affenpinscher").isEmpty(), "affenpinscher breed is not present");
//
//            // Add more assertions based on your requirements
        }
    }

}
