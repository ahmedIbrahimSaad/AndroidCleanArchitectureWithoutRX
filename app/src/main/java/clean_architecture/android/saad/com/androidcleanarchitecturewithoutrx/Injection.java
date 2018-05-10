package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCaseHandler;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.LoginRemoteDataSource;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.LoginRepo;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.domain.LoginUsecase;

public class Injection {
    public static LoginUsecase provideLoginUseCase() {
        return new LoginUsecase(provideLoginRepo());
    }

    private static LoginRepo provideLoginRepo() {
        return new LoginRepo(new LoginRemoteDataSource());
    }
    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

}
