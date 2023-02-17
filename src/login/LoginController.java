package login;

public class LoginController implements LoginControllerToView, LoginControllerToModel{

    private LoginViewToController loginView;
    private LoginModelToController loginModel;

    LoginController(LoginView loginView)
    {
        this.loginView=loginView;
        loginModel=new LoginModel(this);
    }
    public void checkCredentials(String username,String password)
    {
       loginModel.checkCredentialsFromDB(username,password);
    }
    public void userLoginSuccess(String username) {
        loginView.loginToUserSuccess(username);
    }
    public void adminLoginSuccess(String username){
        loginView.loginToAdminSuccess(username);
    }
    public void loginFailed() {
        loginView.loginFailed();
    }
}
