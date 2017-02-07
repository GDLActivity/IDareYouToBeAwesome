package com.sierisimo.idareyoutobeawesome.dares;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.dares.holders.DareBasicViewHolder;
import com.sierisimo.idareyoutobeawesome.data.Dare;
import com.sierisimo.idareyoutobeawesome.listeners.DareListener;

import java.util.List;

/**
 * Created by Baltazar Rodriguez on 23/01/2017.
 *
 */
public class RecyclerDareAdapter extends RecyclerView.Adapter<DareBasicViewHolder> implements DareBasicViewHolder.OnDareHolderClick {
    private List<Dare> items;
    private DareListener listener;

    public RecyclerDareAdapter(List<Dare> list, DareListener listener) {
        this.listener = listener;
        this.items = list;
    }

    @Override
    public DareBasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new DareBasicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DareBasicViewHolder holder, int position) {
        holder.setDare(items.get(position));
        holder.setOnDareHolderClickListener(this);
    }

    @Override
    public void onViewRecycled(DareBasicViewHolder holder) {
        holder.setDare(null);
        holder.setOnDareHolderClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // FIXME: 2/6/17 we should kill listeners everywhere
    @Override
    public void onDareViewClick(Dare dare) {
        listener.onDarePressed(dare);
    }
}
