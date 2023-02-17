package booktickets;

import dto.UserDetails;

public interface BookTicketsModelToController {
    void checkAvaliablity(UserDetails userDetails);
    void checkTicketAvailablity(UserDetails userDetails, String flightNo);
}
