package es.ulpgc.eite.cleancode.helloworld.bye;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;

public class ByePresenter implements ByeContract.Presenter {

    public static String TAG = ByePresenter.class.getSimpleName();

    private WeakReference<ByeContract.View> view;
    private ByeState state;
    private ByeContract.Model model;
    private AppMediator mediator;

    public ByePresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getByeState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new ByeState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        HelloToByeState savedState = mediator.getHelloToByeState();
       /* if (savedState != null) {

           // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
         Log.e(TAG, "onResume()");

        // use passed state if is necessary
        /*NextToByeState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }



    /*private NextToByeState getStateFromNextScreen() {
        return mediator.getNextByeScreenState();
    }

    private void passStateToNextScreen(ByeToNextState state) {
        mediator.setNextByeScreenState(state);
    }*/

    private void passStateToHelloScreen(HelloToByeState state) {
        mediator.setHelloToByeState(state);
    }

    private HelloToByeState getStateFromPreviousScreen() {
        return mediator.getHelloToByeState();
    }

    @Override
    public void injectView(WeakReference<ByeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ByeContract.Model model) {
        this.model = model;
    }



}
