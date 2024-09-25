package MileStones;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SampleBooksApi {

	String id;

	@Test

	public void tc1() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		given().contentType(ContentType.JSON).get("/status").then().statusCode(200).log().all();
	}

	@Test

	public void tc2() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		given().contentType(ContentType.JSON).get("/books").then().statusCode(200).log().all();

	}

	@Test

	public void tc3() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		given().contentType(ContentType.JSON).get("/books/4").then().statusCode(200).log().all();

	}

	@Test
	public void tc4() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("clientName", "Prince");

		jsonObject.put("clientEmail", "prince201@gmail.com");
		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when().post("/api-clients/").then()
				.statusCode(201).log().all();
	}

	@Test

	public void submitandorder() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("bookId", "1");

		jsonObject.put("customerName", "John");

		given().header("Authorization", "Bearer " + "31e8bcdcfce7812300dbbbc1517a51f41eb1e13fa2fc90b73a90b766ab0637a1")
				.contentType(ContentType.JSON).body(jsonObject.toJSONString()).when().post("/orders").then()
				.statusCode(201).log().all();

	}

	@Test

	public void getallorders() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		given().header("Authorization", "Bearer " + "31e8bcdcfce7812300dbbbc1517a51f41eb1e13fa2fc90b73a90b766ab0637a1")
				.contentType(ContentType.JSON).get("/orders").then().statusCode(200).log().all();

	}

	@Test

	public void getanorder() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		given().header("Authorization", "Bearer " + "31e8bcdcfce7812300dbbbc1517a51f41eb1e13fa2fc90b73a90b766ab0637a1")
				.contentType(ContentType.JSON).get("/orders/WP6SRabwGeNRE1bfEnCoy").then().statusCode(200).log().all();

	}

	@Test

	public void updateorder() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("clientName", "Hirak");

		given().header("Authorization", "Bearer " + "31e8bcdcfce7812300dbbbc1517a51f41eb1e13fa2fc90b73a90b766ab0637a1")
				.contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.patch("/orders/WP6SRabwGeNRE1bfEnCoy").then().statusCode(204).log().all();

	}

	@Test

	public void deleteorder() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		given().header("Authorization", "Bearer " + "31e8bcdcfce7812300dbbbc1517a51f41eb1e13fa2fc90b73a90b766ab0637a1")
				.contentType(ContentType.JSON).delete("/orders/WP6SRabwGeNRE1bfEnCoy").then().statusCode(200).log()
				.all();
	}

}
