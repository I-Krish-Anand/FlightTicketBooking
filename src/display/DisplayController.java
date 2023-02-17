package display;

import dto.FlightDetails;

import java.util.ArrayList;

public class DisplayController implements DisplayControllerToView,  DisplayControllerToModel {

    DisplayModelToController displayModel;

    DisplayViewToController displayView;

    public DisplayController(DisplayView displayView){
        this.displayView=displayView;
        displayModel=new DisplayModel(this);
    }

    public void displayUserQuery(String toCity){
        displayModel.displayUserQuery(toCity);
    }
    public void querySuccess(ArrayList<FlightDetails> flightDetailsArrayList){
        displayView.querySuccess(flightDetailsArrayList);
    }
    public void printSuccess(String tickets){
       displayView.printSuccess(tickets);
    }
    public void printTicketAvailablity(String flightNo){
        displayModel.printTicketAvailablity(flightNo);
    }

    public void  queryFailed(){
        displayView.queryFailed();
    }
}
