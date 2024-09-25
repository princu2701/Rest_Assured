package MileStones;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Trellopractice {

	@Test

	public void createaboard() {

		RestAssured.baseURI = "https://api.trello.com";
		given().queryParam("name", "restassuredpractice").queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.contentType(ContentType.JSON).when().post("/1/boards/").then().statusCode(200).log().all();
	}

	@Test

	public void getaboard() {

		RestAssured.baseURI = "https://api.trello.com";

		given().queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.contentType(ContentType.JSON).get("/1/boards/66dc9b5d14e21291ea57a4f5").then().statusCode(200).log()
				.all();
	}

	@Test

	public void deleteaboard() {

		RestAssured.baseURI = "https://api.trello.com";

		given().queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.contentType(ContentType.JSON).delete("/1/boards/66dc9b5d14e21291ea57a4f5").then().statusCode(200).log()
				.all();
	}
}
