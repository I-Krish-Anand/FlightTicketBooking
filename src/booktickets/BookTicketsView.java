package booktickets;

import dto.FlightDetails;
import dto.UserDetails;

import java.util.ArrayList;

import java.util.Scanner;

public class BookTicketsView implements BookTicketsViewToController {

    BookTicketsControllerToView bookTicketsController;

    private final Scanner input=new Scanner(System.in);
    UserDetails userDetails;
    public void create(){
       getUserDetails();
    }

    public BookTicketsView(){
        bookTicketsController=new BookTicketsController(this);
    }

    private void getUserDetails(){
        System.out.println("DECCAN AIR: --- CHENNAI BASE");
        System.out.println("Enter no of tickets to book:");
        int noOfTickets=input.nextInt();
        while (noOfTickets-->0){
            System.out.println("Enter First Name");
            String firstName=input.next();
            System.out.println("Enter Last Name");
            String lastName=input.next();
            System.out.println("Enter your age");
            int age=input.nextInt();
            System.out.println("Enter your Phone Number");
            String phNo=input.next();
            System.out.println("Enter your Destination");
            String destinationLocation=input.next();
            System.out.println("Business-B 50$/ Economy Class-E  25$?:");
            String pricing=input.next();
            userDetails=new UserDetails(firstName,lastName,age,destinationLocation,pricing,phNo);
            bookTicketsController.bookTickets(userDetails);
        }
    }
    public void queryFailed(){
        System.out.println("We are sorry, but no such routes exist as of now");
    }
    public void querySuccess(ArrayList<FlightDetails> userQuery){
        System.out.println("-------AVAILABLE FLIGHTS ARE--------");
        for(FlightDetails flightDetails:userQuery)
                 System.out.println(flightDetails);
        System.out.println("\nEnter respective Flight Number");
        String flightNo=input.next();
        userDetails.setFlightNo(flightNo);
        bookTicketsController.checkTicketAvailablity(userDetails,flightNo);

    }
    public void noTickets(){
        System.out.println(" Tickets are full!");
    }
    public void inValidFlightNo(){
        System.out.println(" Invalid Flight No");
    }
    public void bookingConfirmed(UserDetails userDetails, String flightNo, int seatNo){
        System.out.println("----------TICKET CONFIRMED-----------");
        System.out.println(userDetails+" "+flightNo+" "+userDetails.getPricing()+seatNo+" "+"$"+userDetails.getFare());
    }

}
