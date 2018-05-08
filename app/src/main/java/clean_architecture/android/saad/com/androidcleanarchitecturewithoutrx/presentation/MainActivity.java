package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.R;

public class MainActivity extends AppCompatActivity implements MyContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setPresenter(MyContract.Presenter presenter) {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
