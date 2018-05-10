package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.presentation;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCase;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCaseHandler;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.domain.LoginUsecase;

public class MyPresenter implements MyContract.Presenter {
    MyContract.View mView;
    private final LoginUsecase loginUsecase;
    private final UseCaseHandler mUsecaseHandler;

    public MyPresenter(MyContract.View mView,LoginUsecase loginUsecase, UseCaseHandler mUsecaseHandler) {
        this.mView=mView;
        this.loginUsecase = loginUsecase;
        this.mUsecaseHandler = mUsecaseHandler;
    }

    @Override

    public void doLoginByUsername(String username, String password) {
        LoginUsecase.RequestValues requestValues=new LoginUsecase.RequestValues(username,password);
        mUsecaseHandler.execute(loginUsecase, requestValues, new UseCase.UseCaseCallback<LoginUsecase.ResponseValue>() {
            @Override
            public void onSuccess(LoginUsecase.ResponseValue response) {
                mView.doLoginByUsernameSuccess(response.getResponse());
            }

            @Override
            public void onError(String message) {
               mView.doLoginByUsernameFailed(message);
            }
        });

    }
}
