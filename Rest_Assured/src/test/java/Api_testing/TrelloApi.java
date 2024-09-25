package Api_testing;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TrelloApi {
	String id;

	@Test(priority = 0)

	public void createboard() {

		RestAssured.baseURI = "https://api.trello.com";

		Response bases = given().contentType(ContentType.JSON).queryParam("name", "soni")
				.queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.when().post("/1/boards/").then().extract().response();

		String extracted = bases.asString();

		JsonPath jp = new JsonPath(extracted);

		id = jp.get("id");

		System.out.println(id);
	}

	@Test(priority = 1)

	public void getboard() {
		RestAssured.baseURI = "https://api.trello.com";
		given().contentType(ContentType.JSON).queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.get("/1/boards/" + id).then().log().all();
	}

	@Test(priority = 2)

	public void deleteaboard() {
		RestAssured.baseURI = "https://api.trello.com";
		given().contentType(ContentType.JSON).queryParam("key", "f82463b097cfb3977864e28555da3428")
				.queryParam("token", "ATTA9c4416f2092c9a5cb9a4553c9454c66aa0370f03194a8d3f7291fdd44730da05F21A20AB")
				.delete("/1/boards/" + id).then().statusCode(200).log().all();

	}

}
