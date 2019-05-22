package es.ulpgc.alu.garcia106.kilian.examenordinaria.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE = null;
  private Context context;

  private List<Item> itemList;

  private Repository(Context context) {
    this.context = context;
    this.itemList = new ArrayList<>();
  }

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  @Override
  public void getItemList(LoadItemListCallback callback) {
    if (callback != null) {
      callback.setItemList(itemList);
    }
  }

  @Override
  public void addNewItem(OnAddNewItemCallback callback) {
    if (callback != null) {
      int id = itemList.size();
      itemList.add(new Item(id));
      callback.setItemList(itemList);
    }
  }

  @Override
  public void getPosition(LoadPositionCallback callback) {
    if (callback != null) {
      int position = searchPosition();
      callback.setItem(position);
    }

  }

  @Override
  public void addOnePosition(int itemId, OnAddOneItemCallback callback) {
    if (callback != null) {
      callback.setItem(itemList.get(itemId), searchPosition());
    }
  }


  private int searchPosition() {
    int position = 0;
    for (int k =0; k<itemList.size();k++) {
        position = itemList.get(k).position;
      }
      return position;
    }
  }
