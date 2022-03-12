package es.ulpgc.eite.cleancode.helloworld.bye;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.helloworld.R;

public class ByeActivity
        extends AppCompatActivity implements ByeContract.View {

    public static String TAG = ByeActivity.class.getSimpleName();

    private ByeContract.Presenter presenter;

    Button sayHelloButton, goByeButton;
    TextView byeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);
        getSupportActionBar().setTitle(R.string.bye_screen_title);

       sayHelloButton = findViewById(R.id.sayHelloButton);
        goByeButton = findViewById(R.id.goByeButton);

        byeMessage = findViewById(R.id.byeMessage);

        /*sayHelloButton.setOnClickListener(v -> presenter.sayHelloButtonClicked());

        goByeButton.setOnClickListener(v -> presenter.goByeButtonClicked());

        sayHelloButton.setText(getSayHelloButtonLabel());
        goByeButton.setText(getGoByeButtonLabel());*/



        // do the setup
        ByeScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(ByeViewModel viewModel) {
        Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.byeMessage)).setText(viewModel.data);
    }

    private String getGoByeButtonLabel() {
        return getResources().getString(R.string.go_bye_button_label);
    }

    private String getSayHelloButtonLabel() {
        return getResources().getString(R.string.say_hello_button_label);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ByeActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(ByeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}