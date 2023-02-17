package booktickets;

import dto.UserDetails;

public interface BookTicketsControllerToView {
    void bookTickets(UserDetails userDetails);
    void checkTicketAvailablity(UserDetails userDetails, String flightNo);

}
