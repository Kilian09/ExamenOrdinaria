package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.R;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;
  private FloatingActionButton addButton;

  private MasterAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    addButton = findViewById(R.id.addButton);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onAddButtonClicked();
      }
    });

    listAdapter = new MasterAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    RecyclerView recyclerView = findViewById(R.id.master_recycler);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    MasterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final MasterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    //((TextView) findViewById(R.id.data)).setText(viewModel.data);

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.itemList);
      }
    });
  }
}
