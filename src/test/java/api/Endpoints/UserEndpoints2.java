package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle resources = ResourceBundle.getBundle("routes");
		return resources;
	}
	
	public static Response createUser(User payload)
	{
		String Post_url=getURL().getString("Post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	
		.when()
		.post(Post_url);
		
		return response;
	}
	public static Response getUser(String userName)
	{
		String Get_url=getURL().getString("Get_url");
		Response response=given()
				.pathParam("username",userName)
				
		.when()
		.get(Get_url);
		
		return response;
	}
	public static Response putUser(String userName, User payload)
	{
		String Put_url=getURL().getString("Put_url");
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",userName)
				
		.when()
		.put(Put_url);
		
		return response;
	}
	public static Response deleteUser(String userName)
	{
		String Delete_url=getURL().getString("Delete_url");
		Response response=given()
				.pathParam("username",userName)
				
		.when()
		.delete(Delete_url);
		
		return response;
	}
}
