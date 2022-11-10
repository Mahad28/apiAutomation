package createBookingService;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    String firstName;
    String lastName;
    int totalPrice;
    Boolean depositPaid;
    String checkIn;
    String checkOut;
    String additionalNeeds;

    public BookingService(String firstName,String lastName,int totalPrice,Boolean depositPaid,String checkIn,String checkOut,String additionalNeeds){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.additionalNeeds =additionalNeeds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }



    public Map<String, Object> getPayload(){
        Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
        jsonBodyUsingMap.put("firstname", firstName);
        jsonBodyUsingMap.put("lastname", lastName);
        jsonBodyUsingMap.put("totalprice", totalPrice);
        jsonBodyUsingMap.put("depositpaid", depositPaid);

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", checkIn);
        bookingDatesMap.put("checkout", checkOut);

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", additionalNeeds);

        return jsonBodyUsingMap;
    }

}
