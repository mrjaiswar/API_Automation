package apiTest.apitest;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

/**
 * Hello world!
 *
 */
public class APIUtils 
{//Global Setup Variables
    public static String path;
    public static String jsonPathTerm;

    //Sets Base URI
    public static void setBaseURI (){
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/";
    }

    //Sets base path
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }


    //Returns response by given path
    public static Response getResponsebyPath(String path) {
        return get(path);
    }

    //Returns response
    public static Response getResponse() {
        return get();
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }}
