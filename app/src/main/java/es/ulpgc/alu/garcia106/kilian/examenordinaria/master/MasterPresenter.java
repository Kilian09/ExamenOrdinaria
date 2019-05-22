package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.Item;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    /*
    // set passed state
    MasterState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }
*/
    if (viewModel.itemList == null) {
      model.loadItemList(new RepositoryContract.LoadItemListCallback() {
        @Override
        public void setItemList(List<Item> itemList) {
          viewModel.itemList = itemList;
        }
      });
    }
    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void onAddButtonClicked(){
    model.addNewitem(new RepositoryContract.OnAddNewItemCallback() {
      @Override
      public void setItemList(List<Item> itemList) {
        viewModel.itemList = itemList;
        view.get().displayData(viewModel);
      }
    });
  }

}
