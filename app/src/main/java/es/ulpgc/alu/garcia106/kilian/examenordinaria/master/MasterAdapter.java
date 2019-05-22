package es.ulpgc.alu.garcia106.kilian.examenordinaria.master;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.R;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.data.Item;

public class MasterAdapter
    extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<Item> itemList;
  private final View.OnClickListener clickListener;

  public MasterAdapter(View.OnClickListener clickListener) {
    this.itemList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(Item item) {
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<Item> items) {
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<Item> items) {
    itemList = items;
    notifyDataSetChanged();
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.master_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    int id = itemList.get(position).itemId;
    holder.idText.setText(Integer.toString(id));
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView idText;

    ViewHolder(View view) {
      super(view);
      idText = view.findViewById(R.id.id_text_view);

    }
  }
}
