package login;

import repository.FlightRepository;


public class LoginModel implements LoginModelToController {

    private LoginControllerToModel loginController;

    LoginModel(LoginController loginController) {
        this.loginController=loginController;
    }
    public void checkCredentialsFromDB(String userName,String password)
    {
        int flag= FlightRepository.getInstance().checkValidUser(userName,password);
        if(flag==1)
            loginController.adminLoginSuccess(userName);
        else if(flag==2)
            loginController.userLoginSuccess(userName);
        else
            loginController.loginFailed();

    }

}
