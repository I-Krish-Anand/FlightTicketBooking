package login;

import admincontrols.AdminView;
import booktickets.BookTicketsView;
import canceltickets.CancelTicketsView;
import display.DisplayView;

import java.util.Scanner;

public class LoginView implements LoginViewToController {
    private final Scanner input=new Scanner(System.in);
    LoginControllerToView loginController;

    public static void main(String[] args) {
        LoginView loginView=new LoginView();
        loginView.create();
    }
    LoginView() {
        loginController=new LoginController(this);
    }
    private void create() {
        getCredentials();
    }

    private void getCredentials()
    {
        System.out.println("-------WELCOME TO DECCAN AIR (CHENNAI TAMBARAM)-------\n");
        System.out.println("Enter Username:");
        String username=input.nextLine();
        System.out.println("Enter Password");
        String password=input.nextLine();
        loginController.checkCredentials(username,password);
    }
    public void loginToAdminSuccess(String userName){
        System.out.println("\tWelcome Back Captain:"+userName);
        AdminView adminView=new AdminView();
        adminView.create();

    }
    public void loginToUserSuccess(String userName){

        System.out.println("\tWelcome To Deccan Air, I'm Maara and I'll be assisting you today:"+userName+"\n");
        boolean flag=true;
        while (flag) {
            System.out.println("Press 1 to Book a Ticket");
            System.out.println("Press 2 to Cancel a ticket");
            System.out.println("Press 3 to View Avaliablity");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    BookTicketsView bookTicketsView = new BookTicketsView();
                    bookTicketsView.create();
                }
                case 2 -> {
                    CancelTicketsView cancelTicketsView = new CancelTicketsView();
                    cancelTicketsView.create();
                }
                case 3 -> {
                    DisplayView displayView=new DisplayView();
                    displayView.create();
                }
            }
            System.out.println("Do you want to Continue: True/False");
            flag = input.nextBoolean();
        }
    }
    public void loginFailed(){
        System.out.println("Invalid Credentials");
    }

}
