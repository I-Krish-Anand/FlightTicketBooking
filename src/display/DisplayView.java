package display;

import dto.FlightDetails;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayView implements DisplayViewToController{

    private final Scanner input=new Scanner(System.in);
    DisplayControllerToView  displayController;

    public DisplayView(){
        displayController=new DisplayController(this);
    }

    public void create(){
        getUserQuery();
    }
    void getUserQuery(){
        System.out.println("Enter Destination City");
        String toCity=input.next();
        displayController.displayUserQuery(toCity);
    }
    public void querySuccess(ArrayList<FlightDetails> flightDetailsArrayList){
        System.out.println("-------AVAILABLE FLIGHTS ARE--------");
        for(FlightDetails flightDetails:flightDetailsArrayList)
            System.out.println(flightDetails);
        System.out.println("\nEnter respective Flight Number");
        String flightNo=input.next();
        displayController.printTicketAvailablity(flightNo);
    }
    public void printSuccess(String tickets){
        System.out.println(tickets);
    }

    public void  queryFailed(){
        System.out.println("Invalid Input");
    }
}
