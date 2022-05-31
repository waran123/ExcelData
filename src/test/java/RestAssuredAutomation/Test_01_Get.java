package RestAssuredAutomation;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class Test_01_Get {

	@Test(priority = 1)
	public void getRequest() {

		RestAssured.baseURI = "https://reqres.in/api/" ;
		String response = given().get("users?page=2").then().log().all().extract().response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath (response) ;
		int id = js.get("data.id[0]") ;
		System.out.println(id);
	}

	@Test(priority = 2 )
	public void getRequest1 () {

		Response response1 = given().get("https://reqres.in/api/users?page=1").then().log().all().extract().response();
		System.out.println(response1);
		System.out.println(response1.getHeaders()) ;
		System.out.println(response1.getStatusLine()) ;
		System.out.println(response1.getStatusCode()) ;
		System.out.println(response1.contentType()) ;

	}
	
	@Test(priority = 3 )
	public void postRequest() {
		
		HashMap<String , Object > map = new HashMap() ;
		
		map.put("name", "PonVeena") ;
		map.put("job", "Fashion_Designer") ; 
		
		JSONObject js1 = new JSONObject(map);
		System.out.println(js1.toJSONString()) ;
		
		String response2 = given().log().all().body(js1.toJSONString()).header("Content-type","application/json").when().post("https://reqres.in/api/users")
		.then().extract().response().asString();
		
		System.out.println(response2);
		 JsonPath res2 = new JsonPath(response2);
		 
		 System.out.println(res2.get("id"));
		
	}

}
