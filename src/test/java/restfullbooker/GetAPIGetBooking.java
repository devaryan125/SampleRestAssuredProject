package restfullbooker;

import static io.restassured.RestAssured.*;

public class GetAPIGetBooking {

	public static void main(String[] args) {
		given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking/{id}").
		pathParam("id", 1).when().get().then().statusCode(200).log().all();
	}

}
