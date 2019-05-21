package es.ulpgc.alu.garcia106.kilian.examenordinaria.data;

import android.content.Context;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE = null;
  private Context context;

  private Repository(Context context) {
  }

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

}
