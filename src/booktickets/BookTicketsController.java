package booktickets;

import dto.FlightDetails;
import dto.UserDetails;

import java.util.ArrayList;

public class BookTicketsController implements BookTicketsControllerToView,BookTicketsControllerToModel {

    BookTicketsModelToController bookTicketsModel;
    BookTicketsViewToController bookTicketsView;

    BookTicketsController(BookTicketsView bookTicketsView){
        this.bookTicketsView=bookTicketsView;
        bookTicketsModel=new BookTicketsModel(this);
    }
    public void bookTickets(UserDetails userDetails){
        bookTicketsModel.checkAvaliablity(userDetails);
    }
    public void checkTicketAvailablity(UserDetails pricing, String flightNo){
        bookTicketsModel.checkTicketAvailablity(pricing,flightNo);
    }

    public void querySuccess(ArrayList<FlightDetails> userQuery){
        bookTicketsView.querySuccess(userQuery);
    }
    public void queryFailed(){
        bookTicketsView.queryFailed();
    }
    public void noTickets(){
        bookTicketsView.noTickets();
    }
    public void inValidFlightNo(){
        bookTicketsView.inValidFlightNo();
    }
    public void bookingConfirmed(UserDetails userDetails, String flightNo, int seatNo){
       bookTicketsView.bookingConfirmed( userDetails, flightNo,seatNo);
    }
}
