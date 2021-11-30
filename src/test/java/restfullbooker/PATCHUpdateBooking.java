package restfullbooker;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class PATCHUpdateBooking {

	public static void main(String[] args) {
		given().log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking/1").contentType(ContentType.JSON).header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").body("{\r\n"
				+ "    \"firstname\" : \"Jameson\",\r\n"
				+ "    \"lastname\" : \"Irish\"\r\n"
				+ "}").when().patch().then().assertThat().statusCode(200).log().all();
		
	}

}
