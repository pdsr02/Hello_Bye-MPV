package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;

public interface ByeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(ByeViewModel viewModel);

        void finishView();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();

        void sayByeButtonClicked();

        void goHelloButtonClicked();
    }

    interface Model {
        String getByeMessage();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromHelloScreen(String data);
    }

}