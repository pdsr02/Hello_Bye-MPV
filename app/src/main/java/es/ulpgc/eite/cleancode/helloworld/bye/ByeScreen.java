package es.ulpgc.eite.cleancode.helloworld.bye;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class ByeScreen {

    public static void configure(ByeContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        ByeContract.Presenter presenter = new ByePresenter(mediator);
        ByeContract.Model model = new ByeModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
