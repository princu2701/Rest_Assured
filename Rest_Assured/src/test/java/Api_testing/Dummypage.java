package Api_testing;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Dummypage {

	@Test

	public void getemployee() {

		given().contentType(ContentType.JSON).get("https://dummy.restapiexample.com/api/v1/employees").then()
				.statusCode(200).log().all();
	}

	@Test

	public void getemployeeid() {

		given().contentType(ContentType.JSON).get("https://dummy.restapiexample.com/api/v1/employee/1").then()
				.statusCode(200).log().all();

	}

	@Test

	public void createid() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "test");

		jsonObject.put("salary", "123");

		jsonObject.put("age", "23");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.post("https://dummy.restapiexample.com/api/v1/create").then().statusCode(200).log().all();
	}

	@Test

	public void updateid() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "prince");

//		jsonObject.put("salary", "123");
//
//		jsonObject.put("age", "23");

		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
				.put("https://dummy.restapiexample.com/api/v1/update/21/").then().statusCode(301).log().all();

	}

	@Test

	public void delete() {

		given().contentType(ContentType.JSON).delete("https://dummy.restapiexample.com/api/v1/delete/2/").then()
				.statusCode(301).log().all();
	}

}
