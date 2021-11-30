package restfullbooker;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecMultipleBooking {
	RequestSpecification reqspec = RestAssured.given();
	
	@BeforeClass
	public void setupRequestSpec() {
		
		reqspec.log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		contentType(ContentType.JSON);
	}
	@Test
	public void createBooking1() {
		given().spec(reqspec).body("{\r\n"
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
