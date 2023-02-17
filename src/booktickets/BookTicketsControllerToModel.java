package booktickets;

import dto.FlightDetails;
import dto.UserDetails;

import java.util.ArrayList;

public interface BookTicketsControllerToModel {
    void queryFailed();
    void querySuccess(ArrayList<FlightDetails> userQuery);
    void noTickets();
    void inValidFlightNo();
    void bookingConfirmed(UserDetails userDetails, String flightNo, int seatNo);
}
