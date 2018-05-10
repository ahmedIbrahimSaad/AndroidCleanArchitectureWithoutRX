package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.presentation;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.presentation.BasePresenter;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.presentation.BaseView;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.model.Response;

public interface MyContract {
    interface View extends BaseView<Presenter>{
        void doLoginByUsernameSuccess(Response model);

        void doLoginByUsernameFailed(String message);
    }
    interface Presenter extends BasePresenter {
        void doLoginByUsername(String username,String password);
    }
}
