package repository;

import dto.FlightDetails;
import dto.UserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class FlightRepository {

    private static FlightRepository flightRepository;
    ArrayList<FlightDetails> flightRoutes=new ArrayList<>();
    ArrayList<FlightDetails> userQuery=new ArrayList<>();
    ArrayList<UserDetails> userDetailsArrayList=new ArrayList<>();

    private  FlightRepository() {

    }
    public static FlightRepository getInstance()
    {
        if(flightRepository==null) {
            flightRepository = new FlightRepository();
            flightRepository.defualtRoutes();
            flightRepository.adminSetup();
            flightRepository.initialSetup();
        }
        return flightRepository;
    }
    HashMap<String,String> userDetails=new HashMap<>();
    HashMap<String,String>adminDetails=new HashMap<>();
    private void defualtRoutes(){
        flightRoutes.add(new FlightDetails("7:00","9:00","Kochin",1));
        flightRoutes.add(new FlightDetails("8:00","10:00","Kochin",2));
        flightRoutes.add(new FlightDetails("10:00","12:00","Goa",3));
        flightRoutes.add(new FlightDetails("11:00","13:00","Goa",4));
        flightRoutes.add(new FlightDetails("16:00","18:00","Bangalore",4));

    }
    public  void addToDB(FlightDetails flightDetails)
    {
        flightRoutes.add(flightDetails);
    }
    public  ArrayList<FlightDetails> getFromDB()
    {
        return flightRoutes;
    }
    public boolean checkAvaliablity(UserDetails userDetails){
        userQuery.clear();
       for(FlightDetails flightDetails:flightRoutes) {
           if (userDetails.getDestinationLocation().equals(flightDetails.getToCity())) {
               userQuery.add(flightDetails);
           }
       }
       return !userQuery.isEmpty();
    }
    public int checkTicketAvailablity(UserDetails userDetails,String flightNo){
        for(FlightDetails flightDetails:flightRoutes){
            if(flightDetails.getFlightNo().equals(flightNo))
            {
                if(Objects.equals(userDetails.getPricing(), "B")) {
                    if (flightDetails.getBusinessClass() > 0 ) {

                         int[]array=flightDetails.getbClassArr();
                         for (int i=0;i<array.length;i++){
                             if(array[i]==0){
                                 array[i]=1;
                                 flightDetails.setBusinessClass(flightDetails.getBusinessClass()-1);
                                 userDetails.setAllotedSeat(i);
                                 userDetails.setFare(50);
                                 userDetailsArrayList.add(userDetails);
                                 return i;
                             }
                         }
                    }
                    else return -1;
                }
                else if(Objects.equals(userDetails.getPricing(), "E")){
                   if(flightDetails.getEconomy()>0) {

                       int[]array=flightDetails.geteClassArr();
                       for (int i=0;i<array.length;i++){
                           if(array[i]==0){
                               array[i]=1;
                               flightDetails.setEconomy(flightDetails.getEconomy()-1);
                               userDetails.setAllotedSeat(i);
                               userDetails.setFare(25);
                               userDetailsArrayList.add(userDetails);
                               return i;
                           }
                       }
                   }
                   else return -1;
                }
            }
        }
        return -2;
    }
    private void initialSetup() {
        userDetails.put("Deepak","user");
        userDetails.put("Kamalesh","user");
        userDetails.put("Krish","user");
        userDetails.put("Gokul","user");
        userDetails.put("Abhisek","user");

    }
    private void adminSetup() {
        adminDetails.put("admin","DeccanAir");
    }
    public int checkValidUser(String username,String password) {
        if(adminDetails.containsKey(username)) {
            if(password.equals(adminDetails.get(username)))
             return 1;
        }
        else if(userDetails.containsKey(username)) {
            if(password.equals(userDetails.get(username)))
                return 2;
        }
        return 3;

    }
    public  ArrayList<FlightDetails> getUserQueryFromDB(){
        return userQuery;
    }
    public boolean verifyDetailsForCancelation(String bookID){
        for (UserDetails userDetails:userDetailsArrayList){
            if(userDetails.getBookingId().equals(bookID)) {
                System.out.println(userDetails.getFirstName());
                for(FlightDetails flightDetails:flightRoutes) {
                    if(userDetails.getFlightNo().equals(flightDetails.getFlightNo())) {
                        if(userDetails.getPricing().equals("B")) {
                            int[]array=flightDetails.getbClassArr();
                            array[userDetails.getAllotedSeat()]=0;
                            flightDetails.setBusinessClass(flightDetails.getBusinessClass() + 1);
                        }
                        else {
                            int[]array=flightDetails.geteClassArr();
                            array[userDetails.getAllotedSeat()]=0;
                            flightDetails.setEconomy(flightDetails.getEconomy() + 1);
                        }
                    }
                }
                userDetailsArrayList.remove(userDetails);
                return true;
            }
        }
        return false;
    }
    public  boolean deleteFlights(String flightNo){
        for (FlightDetails flightDetails:flightRoutes){
            if(flightDetails.getFlightNo().equals(flightNo)) {
                flightRoutes.remove(flightDetails);
                return true;
            }
        }
        return  false;
    }
    public boolean displayUserQuery(String toCity){
        userQuery.clear();
        for(FlightDetails flightDetails:flightRoutes) {
            if (toCity.equals(flightDetails.getToCity())) {
                userQuery.add(flightDetails);
            }
        }
        return !userQuery.isEmpty();
    }
    public String printTicketsAvail(String flightNo){
        for(FlightDetails flightDetails:flightRoutes){
            if(flightNo.equals(flightDetails.getFlightNo())){
                return "No of Economy Tickets:"+flightDetails.getEconomy()+"  No of Business Class Tickets: "+flightDetails.getBusinessClass();
            }
        }
        return "";
    }

}
