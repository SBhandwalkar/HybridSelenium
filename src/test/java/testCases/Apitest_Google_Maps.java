package testCases;

import org.testng.annotations.Test;

import functionLib.RSAMapsPayloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.ProxyAuthenticator;

import static io.restassured.RestAssured.*;

import java.net.Authenticator;

public class Apitest_Google_Maps {


	@Test
	public static void getAddress()
	{
		Authenticator.setDefault(new ProxyAuthenticator("XY58778", "July@2020"));
		System.setProperty("http.proxyHost", "fwdproxy.za.omlac.net");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "fwdproxy.za.omlac.net");
		System.setProperty("https.proxyPort", "8080");

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String res=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(RSAMapsPayloads.addLocation()).when().post("/maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js= new JsonPath(res);
		String placeID=js.getString("id");
		System.out.println(placeID);
	}

}
