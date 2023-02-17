package display;

import repository.FlightRepository;

public class DisplayModel implements DisplayModelToController {

    DisplayControllerToModel displayController;

    public DisplayModel(DisplayController displayController){
        this.displayController=displayController;
    }

    @Override
    public void displayUserQuery(String toCity) {
        boolean flag=FlightRepository.getInstance().displayUserQuery(toCity);
        if(flag)
            querySuccess();
        else
            queryFailed();
    }

    public void printTicketAvailablity(String flightNo){
        String availablity=FlightRepository.getInstance().printTicketsAvail(flightNo);

        if(availablity.equals(""))
            queryFailed();
        else
            printSuccess(availablity);
    }
    private void printSuccess(String tickets){
        displayController.printSuccess(tickets);
    }
    private void querySuccess(){
        displayController.querySuccess(FlightRepository.getInstance().getUserQueryFromDB());
    }
    private void  queryFailed(){
        displayController.queryFailed();
    }

}
