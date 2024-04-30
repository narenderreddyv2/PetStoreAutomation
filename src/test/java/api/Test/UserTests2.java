package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Endpoints.UserEndpoints2;
import api.Payload.User;
import io.restassured.response.Response;

public class UserTests2 {

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
		
		Response response=UserEndpoints2.createUser(userpayload);
		response.then().log().all();
		 
		Assert.assertEquals(response.getStatusCode(),200);
	}
	//@Test(priority=2)
	public void upadateUser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response =UserEndpoints2.putUser(this.userpayload.getUserName(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		
	}
	//@Test
	public void deleteUser() {
		Response response =UserEndpoints2.deleteUser(this.userpayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),204);
		
	}
}
