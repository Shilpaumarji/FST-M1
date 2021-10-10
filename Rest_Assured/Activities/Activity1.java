package Actitities;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
  
	 final static String base_URI = "https://petstore.swagger.io/v2/pet";
	   
	   @Test(priority = 1)
	   public void postrequest() {
		   String reqBody = "{"
		            + "\"id\": 71232,"
		            + "\"name\": \"Joohi\","
		            + " \"status\": \"alive\""
		        + "}";
		   Response response = given().contentType(ContentType.JSON)
				   .body(reqBody).when().post(base_URI);
		   String body = response.getBody().asPrettyString();
		   System.out.println(body);
		   
		   response.then().body("id", equalTo(71232));
		   response.then().body("name", equalTo("Joohi"));
		   response.then().body("status", equalTo("alive"));
	  }
	  
	   @Test(priority = 2)
	   public void getrequest() {
		   Response response = 
				   given().contentType(ContentType.JSON)
				   .when().pathParam("petID", "71232")
				   .get(base_URI+"{petID}");
		   
		   response.then().body("id", equalTo(71232));
		   response.then().body("name", equalTo("Joohi"));
		   response.then().body("status", equalTo("alive"));
		   
	   }
	   
	   @Test(priority = 3)
	   public void deleterequest() {
		   Response response = 
				   given().contentType(ContentType.JSON)
				   .when().pathParam("petID", "71232")
				   .delete(base_URI+"{petID}");
		   
		   response.then().body("code", equalTo(200));
		   response.then().body("message", equalTo("71232"));
		   
		   
	   }
	   
	   
	   
}




