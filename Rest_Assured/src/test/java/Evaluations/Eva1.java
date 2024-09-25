package Evaluations;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Eva1 {

	@Test

	public void scheduleahook() {
//Created the base url using restassured.baseuri
		RestAssured.baseURI = "https://posthook-api.mock.beeceptor.com";
//Since this post don't have the body so no body and used all the required method and asserted the status code
		given().contentType(ContentType.JSON).when().post("/v1/hooks").then().statusCode(200).log().all();
	}

	@Test

	public void gethooks() {
		// Created the base url using restassured.baseuri

		RestAssured.baseURI = "https://posthook-api.mock.beeceptor.com";
//We want to get the list of all hooks so we will get it using get request and will assert the status code and will also see the body using log all.
		given().contentType(ContentType.JSON).get("/v1/hooks").then().statusCode(200).log().all();
	}

	@Test

	public void getahook() {
		// Created the base url using restassured.baseuri

		RestAssured.baseURI = "https://posthook-api.mock.beeceptor.com";
//We want to get a single hook so we will use id of the hook generated from all the hooks and will do the further process with assertion at last
		given().contentType(ContentType.JSON).get("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then()
				.statusCode(200).log().all();
	}

	@Test

	public void deleteahook() {
//Stored base url in RestAssured.baseuri
		RestAssured.baseURI = "https://posthook-api.mock.beeceptor.com";
//Delting the hook by using id and asserting the status code 
		given().contentType(ContentType.JSON).delete("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then()
				.statusCode(200).log().all();
	}

	@Test

	public void addahook() {
		// Created the base url using restassured.baseuri

		RestAssured.baseURI = "https://posthook-api.mock.beeceptor.com";
//We have to insert a body here,so we will use the JSONOnject here and store all the data which we want to insert
		JSONObject js = new JSONObject();

		js.put("name", "updated-project");

		js.put("domain", "api.example.com");

		js.put("headerAuthorization", "");

		js.put("minRetries", 1);

		js.put("retryDelaySecs", 5);
//We will use toJSONString to fill the data using put method and will assert the code at last 
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().put("/v1/projects/").then().statusCode(200)
				.log().all();

	}

}
