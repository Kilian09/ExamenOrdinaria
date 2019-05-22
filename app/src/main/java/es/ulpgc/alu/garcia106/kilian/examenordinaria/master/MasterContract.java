package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import java.lang.ref.WeakReference;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.Item;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.detail.DetailState;

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

    void onListItemClicked(Item item);
  }

  interface Model {
    String fetchData();

    void addNewitem(RepositoryContract.OnAddNewItemCallback callback);

    void loadItemList(RepositoryContract.LoadItemListCallback callback);
  }

  interface Router {
    void navigateToDetailScreen();

    void passDataToDetailScreen(DetailState state);

    MasterState getDataFromPreviousScreen();
  }
}
