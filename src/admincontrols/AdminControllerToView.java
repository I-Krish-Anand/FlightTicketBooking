package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;

public interface AdminControllerToView {
    void setFlightDetails(FlightDetails flightDetails);

    void deleteFlight(String flightNo);
    ArrayList<FlightDetails> getFlightDetails();
}
