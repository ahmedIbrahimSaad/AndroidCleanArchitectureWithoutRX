package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.domain;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCase;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.LoginDataSource;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.LoginRepo;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.model.Response;

public class LoginUsecase extends UseCase<LoginUsecase.RequestValues,LoginUsecase.ResponseValue> {
    private final LoginRepo loginRepo;

    public LoginUsecase(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
     loginRepo.doLogin(requestValues.username, requestValues.password, new LoginDataSource.LoginCallback() {
         @Override
         public void onLoginSuccess(Response response) {
          getmUseCaseCallback().onSuccess(new ResponseValue(response));
         }

         @Override
         public void onLoginError(String message) {
          getmUseCaseCallback().onError(message);
         }
     });
    }

    public static class RequestValues implements UseCase.RequestValues{
     String username;
     String password;

        public RequestValues(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    public class ResponseValue implements UseCase.ResponseValue{
     Response response;

        public ResponseValue(Response response) {
            this.response = response;
        }

        public Response getResponse() {
            return response;
        }
    }
}
