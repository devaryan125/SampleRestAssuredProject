package restfullbooker;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class PostAPICreateBooking {

	public static void main(String[] args) {
		given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").contentType(ContentType.JSON).
		body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").
			when().
			post().
			then().
			statusCode(200).
			log().all();

	}

}
