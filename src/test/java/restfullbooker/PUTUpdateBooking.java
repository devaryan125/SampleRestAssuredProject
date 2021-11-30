package restfullbooker;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class PUTUpdateBooking {

	public static void main(String[] args) {
		given().baseUri("https://restful-booker.herokuapp.com/").
		basePath("/booking/{id}").
		pathParam("id", 1).
		contentType(ContentType.JSON).
		header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
		body("{\r\n"
				+ "    \"firstname\" : \"Dan\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 211,\r\n"
				+ "    \"depositpaid\" : false,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").
		when().put().then().statusCode(200).log().all();
	}

}
