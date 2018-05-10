package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.model.Response;

public class LoginRemoteDataSource implements LoginDataSource {
    Response response;
    @Override
    public void doLogin(String username, String password, LoginCallback loginCallback) {
        response=new Response("ahmed","android dev","28");
        if (username.equals(response.getName())){
            loginCallback.onLoginSuccess(response);
        }
        else
            loginCallback.onLoginError("enter valid username");

    }
}
