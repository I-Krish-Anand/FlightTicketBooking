package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;

public interface AdminModelToController {
    void addFlightDetailsToDB(FlightDetails flightDetails);

     void deleteFlight(String flightNo);

    ArrayList<FlightDetails> getFlightDetailsFromDOB();
}
