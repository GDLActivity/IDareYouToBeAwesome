package com.sierisimo.idareyoutobeawesome.dares;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.dares.holders.DareViewHolder;
import com.sierisimo.idareyoutobeawesome.data.Dare;

import java.util.List;

/**
 * Created by Baltazar Rodriguez on 23/01/2017.
 */
public class RecyclerDareAdapter extends RecyclerView.Adapter<DareViewHolder> {
    private List<Dare> items;

    public RecyclerDareAdapter(List<Dare> list) {
        this.items = list;
    }

    @Override
    public DareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new DareViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DareViewHolder holder, int position) {
        Dare currentDare = items.get(position);
        holder.setText(currentDare.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
