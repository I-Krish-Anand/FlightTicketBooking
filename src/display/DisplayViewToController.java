package display;

import dto.FlightDetails;

import java.util.ArrayList;

public interface DisplayViewToController {

    void querySuccess(ArrayList<FlightDetails> flightDetailsArrayList);

    void  queryFailed();

    void printSuccess(String tickets);
}
