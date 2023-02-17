package login;

public interface LoginViewToController {
     void loginToAdminSuccess(String userName);
     void loginToUserSuccess(String userName);
     void loginFailed();
}
