package Api_testing;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReqresApi {
//For Get
	@Test
	public void tc1() {
// .log(),.All() is used to show the data inside the response

		given().contentType("application/json").get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}

	@Test
	public void tc2() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}

	@Test

	public void tc3() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/users/23").then().statusCode(404).log().all();

	}

	@Test

	public void tc4() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	}

	@Test

	public void tc5() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
	}

	@Test

	public void tc6() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/unknown/23").then().statusCode(200).log()
				.all();

	}

	@Test

	public void tc7() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "morpheus");

		jsonObject.put("job", "leader");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when().post("https://reqres.in/api/users")
				.then().statusCode(201).log().all();
	}

	@Test

	public void tc8() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "morpheus");
		jsonObject.put("job", "zion resident");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.put("https://reqres.in/api/users/2").then().statusCode(200).log().all();

	}

	@Test

	public void tc9() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "morpheus");

		jsonObject.put("job", "zion resident");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.patch("https://reqres.in/api/users/2").then().log().all();

	}

	@Test

	public void tc10() {

		given().contentType(ContentType.JSON).delete("https://reqres.in/api/users/2").then().statusCode(204).log()
				.all();
	}

	@Test

	public void tc11() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("email", "eve.holt@reqres.in");

		jsonObject.put("password", "pistol");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.post("https://reqres.in/api/register").then().statusCode(200).log().all();

	}

	@Test

	public void tc12() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("email", "sydney@fife");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.post("https://reqres.in/api/register").then().statusCode(400).log().all();
	}

	@Test

	public void tc13() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("email", "eve.holt@reqres.in");
		jsonObject.put("password", "cityslicka");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when().post("https://reqres.in/api/login")
				.then().statusCode(200).log().all();
	}

	@Test

	public void tc14() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("email", "peter@klaven");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when().post("https://reqres.in/api/login")
				.then().statusCode(400).log().all();

	}

	@Test

	public void tc15() {

		given().contentType(ContentType.JSON).get("https://reqres.in/api/users?delay=3").then().statusCode(200).log()
				.all();
	}

}
