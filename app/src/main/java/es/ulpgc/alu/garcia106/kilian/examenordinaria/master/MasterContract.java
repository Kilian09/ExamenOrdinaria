package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import java.lang.ref.WeakReference;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onAddButtonClicked();
  }

  interface Model {
    String fetchData();

    void addNewitem(RepositoryContract.OnAddNewItemCallback callback);

    void loadItemList(RepositoryContract.LoadItemListCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MasterState state);

    MasterState getDataFromPreviousScreen();
  }
}
