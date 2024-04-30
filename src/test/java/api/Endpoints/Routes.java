package api.Endpoints;

public class Routes {
	
	//https://petstore.swagger.io/v2/user/createWithArray
	//https://petstore.swagger.io/v2/user/{userName}
	//https:petstore.swagger.io/v2/user/{userName}
	//https://petstore.swagger.io/v2/user/{userName}
	
	 
	public static String base_url ="https://petstore.swagger.io/v2";
	
	public static String Post_url = base_url+"/user";
	public static String Get_url = base_url+"/user/{username}";
	public static String Put_url = base_url+"/user/{username}";
	public static String Delete_url = base_url+"/user/{username}";
}
