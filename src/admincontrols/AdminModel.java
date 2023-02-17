package admincontrols;

import dto.FlightDetails;
import repository.FlightRepository;

import java.util.ArrayList;

public class AdminModel implements AdminModelToController{

    boolean flag;

    private final AdminControllerToModel adminController;

    public AdminModel(AdminController adminController){
        this.adminController=adminController;
    }

    public void deleteFlight(String flightNo){
         flag=FlightRepository.getInstance().deleteFlights(flightNo);
    }

    private void deletionSuccess(String flightNo){
      adminController.deletionSuccess(flightNo);
    }

    private void deletetionFailed(){
       adminController.deletetionFailed();
    }

    public void addFlightDetailsToDB(FlightDetails flightDetails) {
        FlightRepository.getInstance().addToDB(flightDetails);
        adminController.updationSuccess();

    }
    public ArrayList<FlightDetails> getFlightDetailsFromDOB(){
        return FlightRepository.getInstance().getFromDB();
    }
}
