package es.ulpgc.eite.cleancode.helloworld.bye;

public class ByeModel implements ByeContract.Model {

    public static String TAG = ByeModel.class.getSimpleName();

    private String message;

    public ByeModel(String message) {
        this.message =message;
    }

    @Override
    public String getByeMessage() {
        // Log.e(TAG, "getStoredData()");
        return message;
    }

    @Override
    public void onRestartScreen(String message) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String message) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromHelloScreen(String message) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
