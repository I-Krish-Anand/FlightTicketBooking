package booktickets;

import dto.FlightDetails;
import dto.UserDetails;
import repository.FlightRepository;

import java.util.ArrayList;

public class BookTicketsModel implements BookTicketsModelToController {

        boolean flag;
        int seatNo;
       BookTicketsControllerToModel bookTicketsController;

       BookTicketsModel(BookTicketsController bookTicketsController){
           this.bookTicketsController=bookTicketsController;
       }

        public void checkAvaliablity(UserDetails userDetails){
            flag=FlightRepository.getInstance().checkAvaliablity(userDetails);
            if(flag==true)
                getUserQueryFromDB();
            else
                queryFailed();
        }
    public void checkTicketAvailablity(UserDetails pricing, String flightNo){
            seatNo=FlightRepository.getInstance().checkTicketAvailablity(pricing,flightNo);
            if(seatNo==-1)
             noTickets();
            if(seatNo>=0)
                bookingConfirmed(pricing, flightNo, seatNo);

            else
                inValidFlightNo();
    }
    private void noTickets(){
           bookTicketsController.noTickets();
    }
    private void inValidFlightNo(){
         bookTicketsController.inValidFlightNo();
    }
    private void bookingConfirmed(UserDetails userDetails, String flightNo, int seatNo){
        bookTicketsController.bookingConfirmed(userDetails,flightNo,seatNo);
    }
    public void getUserQueryFromDB() {
            ArrayList<FlightDetails> userQuery= FlightRepository.getInstance().getUserQueryFromDB();
            bookTicketsController.querySuccess(userQuery);

       }
        public void queryFailed(){
            bookTicketsController.queryFailed();
        }

}
