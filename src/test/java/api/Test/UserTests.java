package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserTests {

	Faker faker;
	User userpayload;
	@BeforeClass
	public void setUp() {

		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUserName(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setPassword(faker.internet().password(6, 10));
		
		

	}
	

	@Test(priority=1)
	public void testPostUser()
	{
		
		Response response=UserEndpoints.createUser(userpayload);
		response.then().log().all();
		 
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2)
	public void upadateUser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response =UserEndpoints.putUser(this.userpayload.getUserName(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		
	}
	//@Test
	public void deleteUser() {
		Response response =UserEndpoints.deleteUser(this.userpayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),204);
		
	}
	 
	        
}
