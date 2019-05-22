package es.ulpgc.alu.garcia106.kilian.examenordinaria.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
/*
    // set passed state
    DetailState state = router.getDataFromPreviousScreen();
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

    if (viewModel.currentItem == null) {
      DetailState state = router.getDataFromMasterScreen();
      if (state != null) {
        viewModel.currentItem = state.currentItem;
      }
    }
    model.getPosition(new RepositoryContract.LoadPositionCallback() {
      @Override
      public void setItem(int position) {
        viewModel.position = position;
      }
    });
    // update the view
    view.get().displayData(viewModel);

  }
}
