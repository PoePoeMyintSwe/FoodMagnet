package com.poepoemyintswe.foodmagnet.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.bumptech.glide.Glide;
import com.poepoemyintswe.foodmagnet.R;
import com.poepoemyintswe.foodmagnet.model.Result;
import java.util.List;

/**
 * Created by poepoe on 2/4/15.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

  private List<Result> results;

  public LocationAdapter(List<Result> results) {
    setHasStableIds(true);
    this.results = results;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_location, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, final int position) {
    Result result = results.get(position);
    holder.name.setText(result.name);
    holder.vicinity.setText(result.vicinity);
    Glide.with(holder.itemView.getContext()).load(result.icon).into(holder.icon);
  }

  public void addAll(List<Result> data) {
    int startIndex = results.size();
    results.addAll(startIndex, data);
    notifyItemRangeInserted(startIndex, data.size());
    notifyDataSetChanged();
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemCount() {
    return results.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.icon) ImageView icon;
    @InjectView(R.id.name) TextView name;
    @InjectView(R.id.vicinity) TextView vicinity;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.inject(this, view);
    }
  }
}