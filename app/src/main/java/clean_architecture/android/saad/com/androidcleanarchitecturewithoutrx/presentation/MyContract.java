package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.presentation;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.presentation.BasePresenter;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.presentation.BaseView;

public interface MyContract {
    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter {

    }
}
