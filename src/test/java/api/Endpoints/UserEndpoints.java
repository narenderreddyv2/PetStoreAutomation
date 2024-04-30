package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	
	public static Response createUser(User payload)
	{
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	
		.when()
		.post(Routes.Post_url);
		
		return response;
	}
	public static Response getUser(String userName)
	{
		
		Response response=given()
				.pathParam("username",userName)
				
		.when()
		.get(Routes.Get_url);
		
		return response;
	}
	public static Response putUser(String userName, User payload)
	{
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",userName)
				
		.when()
		.put(Routes.Put_url);
		
		return response;
	}
	public static Response deleteUser(String userName)
	{
		
		Response response=given()
				.pathParam("username",userName)
				
		.when()
		.delete(Routes.Delete_url);
		
		return response;
	}
}
