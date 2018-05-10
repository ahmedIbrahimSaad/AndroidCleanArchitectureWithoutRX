package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.model.Response;

public interface LoginDataSource {
    void doLogin(String username,String password,LoginCallback loginCallback);
    interface  LoginCallback{
        void onLoginSuccess(Response response);
        void onLoginError(String message);
    }
}
