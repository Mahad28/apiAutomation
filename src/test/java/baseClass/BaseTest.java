package baseClass;

import io.restassured.RestAssured;
import utility.apiConstants;

public class BaseTest {

    public void baseUrl(){
        RestAssured.baseURI = apiConstants.BASE_CONFIG.BASE_URL;
    }

}
