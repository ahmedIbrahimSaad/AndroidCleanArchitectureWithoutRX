package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.Injection;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.R;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCaseHandler;
import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.data_layer.login.model.Response;

public class MainActivity extends AppCompatActivity implements MyContract.View {
    MyPresenter presenter;
    @BindView(R.id.usernameTXT) EditText usernameTXT;
    @BindView(R.id.passwordTXT)EditText passwordTXT;
    @BindView(R.id.btn_Login)Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new MyPresenter(this, Injection.provideLoginUseCase(),Injection.provideUseCaseHandler());
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_Login)void submit(){
        if(!(usernameTXT.getText().toString().equals("")||passwordTXT.getText().toString().equals(""))){
            hideKeyBoard();
            presenter.doLoginByUsername(usernameTXT.getText().toString(),passwordTXT.getText().toString());
        }

    }


    @Override
    public void setPresenter(MyContract.Presenter presenter) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doLoginByUsernameSuccess(Response model) {
        Toast.makeText(this, model.getJob(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doLoginByUsernameFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    void hideKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
