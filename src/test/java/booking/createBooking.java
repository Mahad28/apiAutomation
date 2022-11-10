package booking;

import baseClass.BaseTest;
import createBookingService.BookingService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createBooking extends BaseTest {
    @Test
    public void TC_001_createBooking(){
        //Positive case
        baseUrl();
        BookingService bs = new BookingService("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response resp = given().log().all().when().headers("Content-Type", "application/json")
                .body(bs.getPayload()).when()
                .post("/booking");
        ResponseBody body = resp.getBody();
        System.out.println(body.asPrettyString());
        Assert.assertEquals(resp.getStatusCode(),200);
    }

    @Test void TC_002_createBooking(){
        //Date Format Change
        baseUrl();
        BookingService bs = new BookingService("Jim","Brown",111,true,"2018-0101","2019-01-01","Breakfast");
        Response resp = given().log().all().when().headers("Content-Type", "application/json")
                .body(bs.getPayload()).when()
                .post("/booking");
        ResponseBody body = resp.getBody();
        String bodyAsString = body.asString();
        System.out.println(body.asPrettyString());
        Assert.assertEquals(resp.getStatusCode(),200);
        Assert.assertEquals(bodyAsString.contains("Jim"),true,"Body Does not contain firstName");
    }
    @Test void TC_003_createBooking(){
        //Wrong Status Code expected
        baseUrl();
        BookingService bs = new BookingService("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response resp = given().log().all().when().headers("Content-Type", "application/json")
                .body(bs.getPayload()).when()
                .post("/booking");
        ResponseBody body = resp.getBody();
        System.out.println(body.asPrettyString());
        Assert.assertEquals(resp.getStatusCode(),201); //Status code expected as 200
    }
    @Test void TC_004_createBooking(){
        //If String is present or not in the body
        baseUrl();
        BookingService bs = new BookingService("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response resp = given().log().all().when().headers("Content-Type", "application/json")
                .body(bs.getPayload()).when()
                .post("/booking");
        ResponseBody body = resp.getBody();
        String bodyAsString = body.asString();
        System.out.println(body.asPrettyString());
        Assert.assertEquals(resp.getStatusCode(),200);
        Assert.assertEquals(bodyAsString.contains("Jim"),true,"Body Does contain firstName as String");
    }
}
