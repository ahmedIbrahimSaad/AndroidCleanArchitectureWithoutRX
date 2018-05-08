package dagger2simple.android.vogella.com.androidcleanarchitecturewithoutrx.base.presentation;

/**
 * Created by akhalaf on 7/11/2017.
 */

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

    boolean isActive();
}
