package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;

public class AdminController  implements AdminControllerToView, AdminControllerToModel{


    private final AdminModelToController adminModel;
    private final AdminViewToController adminView;
    public AdminController(AdminView adminView){
        adminModel=new AdminModel(this);
        this.adminView=adminView;
    }

    public void deleteFlight(String flightNo){
        adminModel.deleteFlight(flightNo);
    }
    public void deletionSuccess(String flightNo){
         adminView.deletionSuccess(flightNo);
    }

    public void deletetionFailed(){
          adminView.deletetionFailed();
    }
    public void setFlightDetails(FlightDetails flightDetails) {
        adminModel.addFlightDetailsToDB(flightDetails);
    }
    public ArrayList<FlightDetails> getFlightDetails(){
        return adminModel.getFlightDetailsFromDOB();
    }
    public void updationSuccess(){
        adminView.updationSuccess();
    }

}
