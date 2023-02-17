package canceltickets;

public class CancelTicketsController implements CancelTicketsControllerToView, CancelTicketsControllerToModel {

    private final CancelTicketsModelToController cancelTicketsModel;

    private final CancelTicketsViewToController cancelTicketsView;

    public  CancelTicketsController(CancelTicketsView cancelTicketsView){
        this.cancelTicketsView=cancelTicketsView;
        cancelTicketsModel=new CancelTicketsModel(this);
    }

    @Override
    public void verifyDetails(String bookID) {
        cancelTicketsModel.verifyDetails(bookID);

    }
    public void cancelationSuccessfull(){
         cancelTicketsView.cancelationSuccessfull();
    }
    public void cancelationUnSuccessfull(){
        cancelTicketsView.cancelationUnSuccessfull();

    }
}
