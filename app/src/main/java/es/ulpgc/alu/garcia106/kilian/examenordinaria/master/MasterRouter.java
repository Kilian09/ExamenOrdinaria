package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.app.AppMediator;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.detail.DetailActivity;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.detail.DetailState;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToDetailScreen(DetailState state) {
    mediator.setDetailState(state);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }
}
