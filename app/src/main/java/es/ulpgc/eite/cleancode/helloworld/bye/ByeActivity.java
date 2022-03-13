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

    Button sayHelloButton, sayByeButton;
    TextView byeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);
        getSupportActionBar().setTitle(R.string.bye_screen_title);

        sayHelloButton = findViewById(R.id.sayHelloButton);
        sayByeButton = findViewById(R.id.goByeButton);

        byeMessage = findViewById(R.id.byeMessage);

       /* sayByeButton.setOnClickListener(v -> presenter.sayByeButtonClicked());
        sayByeButton.setText(getByeButtonLabel());*/


        // do the setup
        ByeScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    private String getByeButtonLabel() {
        return getResources().getString(R.string.say_bye_button_label);
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
        byeMessage.setText(viewModel.byeMessage);
    }

    @Override
    public void injectPresenter(ByeContract.Presenter presenter) {
        this.presenter = presenter;
    }



}