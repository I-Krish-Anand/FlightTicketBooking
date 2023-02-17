package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView implements AdminViewToController {

    private final Scanner input=new Scanner(System.in);
    AdminControllerToView adminController;
    FlightDetails flightDetails;
    public void create() {
        getOperations();
    }
    public AdminView(){
        adminController=new AdminController(this);
    }
    private void getOperations() {

        boolean flag=true;
        while (flag) {
            System.out.println("1) Press 1 to view your Flight Schedule");
            System.out.println("2) Press 2 to add new flights");
            System.out.println("3) Press 3 to delete a route");

            int choice = input.nextInt();
            switch (choice){
                case 1->getFlightDetails();

                case 2->setFlightDetails();

                case 3->deleteFlight();
            }
            System.out.println("Do you want to continue? True/ False");
            flag=input.nextBoolean();
        }

    }

    private void deleteFlight(){
        System.out.println("Enter Flight No");
        String flightNo=input.next();
        adminController.deleteFlight(flightNo);
    }
    public void deletionSuccess(String flightNo){
        System.out.println("Deccan Air:"+flightNo+" "+"route is temporarily closed");
    }

    public void deletetionFailed(){
        System.out.println("No such Input");
    }

    private void getFlightDetails() {
        System.out.println("Get Flight Details");
        ArrayList<FlightDetails> flightRoutes=adminController.getFlightDetails();
        for(FlightDetails object:flightRoutes){
            System.out.println(object);
        }
    }

    private void setFlightDetails(){
        System.out.println("DECCAN AIR: --- CHENNAI BASE");
        System.out.println("Enter Estimated Departure Time:");
        String takeOffTime=(input.next());
        System.out.println("Estimated Arrival Time");
        String landingTime=(input.next());
        System.out.println("Enter Destination City");
        String toCity=(input.next());
        System.out.println("Enter Base Terminal");
        int terminal=(input.nextInt());
        flightDetails=new FlightDetails(takeOffTime,landingTime,toCity,terminal);
        adminController.setFlightDetails(flightDetails);

    }
    public void updationSuccess() {
        System.out.println("\tSuccessfully Updated:");
        getFlightDetails();
    }


}
