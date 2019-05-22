package es.ulpgc.alu.garcia106.kilian.examenordinaria.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();

    void getPosition(RepositoryContract.LoadPositionCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    DetailState getDataFromMasterScreen();
  }
}
