package es.ulpgc.alu.garcia106.kilian.examenordinaria.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.Repository;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.RepositoryContract;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private Repository repository;

  public DetailModel(Repository repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void getPosition(RepositoryContract.LoadPositionCallback callback){
    repository.getPosition(callback);
  }

}
