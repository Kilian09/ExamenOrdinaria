package es.ulpgc.alu.garcia106.kilian.examenordinaria.data;

import java.util.List;

public interface RepositoryContract {

  interface LoadItemListCallback{
    void setItemList(List<Item> itemList);
  }

  interface  OnAddNewItemCallback{
    void setItemList(List<Item> itemList);
  }

  void getItemList(LoadItemListCallback callback);

  void addNewItem(OnAddNewItemCallback callback);
}
