package es.ulpgc.alu.garcia106.kilian.examenordinaria.detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.app.AppMediator;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.Repository;

public class DetailScreen {

  public static void configure(DetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    DetailState state = mediator.getDetailState();

    Repository repository = Repository.getInstance(context.get());

    DetailContract.Router router = new DetailRouter(mediator);
    DetailContract.Presenter presenter = new DetailPresenter(state);
    DetailContract.Model model = new DetailModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
