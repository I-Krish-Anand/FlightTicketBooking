package booktickets;

import dto.FlightDetails;
import dto.UserDetails;

import java.util.ArrayList;

public interface BookTicketsViewToController {
     void queryFailed();
     void querySuccess(ArrayList<FlightDetails> userQuery);
     void noTickets();
     void inValidFlightNo();
     void bookingConfirmed(UserDetails pricing, String flightNo, int seatNo);
}
