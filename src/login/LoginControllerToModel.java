package login;

public interface LoginControllerToModel {

     void userLoginSuccess(String username);
     void adminLoginSuccess(String username);
     void loginFailed();
}
