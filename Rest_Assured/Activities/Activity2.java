package Actitities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


	public class Activity2 {
	    
	    final static String base_URI = "https://petstore.swagger.io/v2/user";

	    @Test(priority=1)
	    public void addNewUserFromFile() throws IOException {
	        FileInputStream inputJSON = new FileInputStream("src/test/userfile.json");
	        final byte[] reqbody = Files.readAllBytes(Paths.get("src/test/userfile.json"));
	        

	        Response response = 
	            given().contentType(ContentType.JSON) 
	            .body(reqbody) 
	            .when().post(base_URI); 

	        inputJSON.close();

	        // Assertion
	        response.then().body("code", equalTo(200));
	        response.then().body("message", equalTo("9921"));
	    }
	    
	    @Test(priority=2)
	    public void getUserInfo() {
	        
	        File outputJSON = new File("src/test/userGETResponse.json");

	        Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .pathParam("username", "justina") // Pass request body from file
	            .when().get(base_URI + "/{username}"); // Send POST request
	        
	
	        String resBody = response.getBody().asPrettyString();

	        try {
	           
	            outputJSON.createNewFile();
	            FileWriter writer = new FileWriter(outputJSON.getPath());
	            writer.write(resBody);
	            writer.close();
	        } catch (IOException excp) {
	            excp.printStackTrace();
	        }
	        
	        // Assertion
	        response.then().body("id", equalTo(9921));
	        response.then().body("username", equalTo("justina"));
	        response.then().body("firstName", equalTo("Justin"));
	        response.then().body("lastName", equalTo("Case"));
	        response.then().body("email", equalTo("justincase@mail.com"));
	        response.then().body("password", equalTo("password123"));
	        response.then().body("phone", equalTo("9812763450"));
	    }
	    
	    @Test(priority=3)
	    public void deleteUser() throws IOException {
	        Response response = 
	            given().contentType(ContentType.JSON)
	            .pathParam("username", "justina") 
	            .when().delete(base_URI + "/{username}");

	        
	        response.then().body("code", equalTo(200));
	        response.then().body("message", equalTo("justina"));
	    }
	}
	   





