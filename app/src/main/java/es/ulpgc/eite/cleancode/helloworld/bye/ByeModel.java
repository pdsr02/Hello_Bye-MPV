package es.ulpgc.eite.cleancode.helloworld.bye;

public class ByeModel implements ByeContract.Model {

    public static String TAG = ByeModel.class.getSimpleName();

    private String message;

    public ByeModel(String message) {
        this.message =message;
    }

    @Override
    public String getStoredData() {
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
    public void onDataFromPreviousScreen(String message) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
