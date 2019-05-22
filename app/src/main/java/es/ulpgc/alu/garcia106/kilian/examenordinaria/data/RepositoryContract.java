package es.ulpgc.alu.garcia106.kilian.examenordinaria.data;

import java.util.List;

public interface RepositoryContract {

  interface LoadItemListCallback {
    void setItemList(List<Item> itemList);
  }

  interface OnAddNewItemCallback {
    void setItemList(List<Item> itemList);
  }

  interface LoadPositionCallback {
    void setItem(int position);
  }

  interface OnAddOneItemCallback {
    void setItem(Item item, int position);
  }

  void getItemList(LoadItemListCallback callback);

  void addNewItem(OnAddNewItemCallback callback);

  void getPosition(LoadPositionCallback callback);

  void addOnePosition(int itemId, OnAddOneItemCallback callback);
}
