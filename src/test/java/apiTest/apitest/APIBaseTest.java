package apiTest.apitest;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Utils.TestUtils;








/**
 * Unit test for simple App.
 */
public class APIBaseTest 

{

    public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtils testUtils = new TestUtils();

    @BeforeClass
    void setup (){
        //Test Setup - api.tmsandbox.co.nz/v1/Categories/
        APIUtils.setBaseURI(); //Setup Base URI
        APIUtils.setBasePath("v1/Categories/"); //Setup Base Path
        String path = "6327/Details.json?catalogue=false"; //Path of the search query
        APIUtils.setContentType(ContentType.JSON); //Setup Content Type          
        res = APIUtils.getResponsebyPath(path); //Get response
        System.out.println("response path ----" +res);
        jp = APIUtils.getJsonPath(res); //Set JsonPath
        testUtils.checkStatusIs200(res); //Check Reponse 200
        
        
    }
    
    
    @Test
    public void T01_SearchTermTest() {
        //Verify Name is Carbon credits
    	testUtils.assertEquals("Carbon credits", jp.get("Name"), "Category Name value does not match with Carbon Credits");
      
    }
    
    @Test
    public void T02_SearchTermTest() {
        //Verify canRelist is true 
    	testUtils.assertEquals(true,jp.get("CanRelist"),"CanRelist is False");
      
    }    
    
    @Test
    public void T03_GalleryWith2xImage1() {
        //Verify canRelist is true 
    	testUtils.getLabel(jp, "Gallery", "2x larger image");

    }  
      

    @AfterClass
    public void afterTest (){
        //Reset Values
    	APIUtils.resetBaseURI();
    	APIUtils.resetBasePath();
    }

}
