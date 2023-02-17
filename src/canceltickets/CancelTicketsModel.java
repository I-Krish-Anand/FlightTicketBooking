package canceltickets;

import repository.FlightRepository;

public class CancelTicketsModel implements CancelTicketsModelToController{

    boolean flag;

    private final CancelTicketsControllerToModel cancelTicketsController;

    public CancelTicketsModel(CancelTicketsController cancelTicketsController){
        this.cancelTicketsController=cancelTicketsController;
    }
    @Override
    public void verifyDetails(String bookID) {
        flag = FlightRepository.getInstance().verifyDetailsForCancelation(bookID);

        if (flag)
            cancelationSuccessfull();
        else
            cancelationUnSuccessfull();
    }
    private void cancelationSuccessfull(){
        cancelTicketsController.cancelationSuccessfull();
    }
    private void cancelationUnSuccessfull(){
         cancelTicketsController.cancelationUnSuccessfull();
    }

}
