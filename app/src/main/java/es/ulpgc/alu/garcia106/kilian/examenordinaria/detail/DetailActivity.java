package es.ulpgc.alu.garcia106.kilian.examenordinaria.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;
  private TextView idNumberText, positionNumberText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    getSupportActionBar().setTitle("Detail");

    idNumberText = findViewById(R.id.id_number_text);
    positionNumberText = findViewById(R.id.position_number_text);


    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
   // ((TextView) findViewById(R.id.data)).setText(viewModel.data);

    int id = viewModel.currentItem.itemId;
    idNumberText.setText(Integer.toString(id));
    positionNumberText.setText(Integer.toString(viewModel.position));

  }

  @Override
  public void onBackPressed() {
    this.finish();
  }
}
