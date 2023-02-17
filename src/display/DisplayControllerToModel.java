package display;

import dto.FlightDetails;

import java.util.ArrayList;

public interface DisplayControllerToModel {

    void querySuccess(ArrayList<FlightDetails> flightDetailsArrayList);

    void  queryFailed();

    void printSuccess(String tickets);
}
