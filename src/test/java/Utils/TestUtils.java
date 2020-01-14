package Utils;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import static com.jayway.restassured.path.json.JsonPath.from;

/**
 * Common Test methods
 */
public class TestUtils {

	// Verify the http response status returned. Check Status Code is 200?
	public void checkStatusIs200(Response res) {
		System.out.println("Response Code-----------" + res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
	}

	public void assertEquals(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);

	}

	public void getLabel(JsonPath jp, String name, String description) {
		String expression = "Promotions.findAll { it.Name== '" + name + "'}.findAll{it.Description.contains('" + description + "')}";
		System.out.println("expr----------" + expression);
		List<String> labels = jp.getList(expression);
		System.out.println("***********" +labels.size());
		if (labels.size() > 0) {
			System.out.println("testsetset");
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(true, false);
		}
		/*
		 * List<HashMap<String, Object>> promotionValue = jp.getList("Promotions");
		 * System.out.println("getLabel------------" +promotionValue.toString());
		 * 
			for (HashMap<String, Object>
		 * promotionKey : promotionValue) { System.out.println("promotionKey-------"
		 * +promotionKey); String id = (String)promotionKey.get("Name"); String  =
		 * (String)promotionKey.get("Description"); if(id.equals("Gallery") &&
		 * desc.contains(check)) { System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
		 * Assert.assertEquals(true, true); break; }
		 * 
		 * }
		 */
	}

}
