package canceltickets;

import java.util.Scanner;

public class CancelTicketsView implements CancelTicketsViewToController{

    private final CancelTicketsControllerToView cancelTicketsController;
    private final Scanner input=new Scanner(System.in);

    public void create(){
        getCancelationDetails();
    }

    public CancelTicketsView(){
        cancelTicketsController=new CancelTicketsController(this);
    }

    private void getCancelationDetails(){
        System.out.println("Enter Booking ID");
        String bookID=input.next();
        cancelTicketsController.verifyDetails(bookID);
    }
    public void cancelationSuccessfull(){
        System.out.println("Cancellation Successful");
    }
    public void cancelationUnSuccessfull(){
        System.out.println("Cancelation Unsuccessfull");
    }
}
