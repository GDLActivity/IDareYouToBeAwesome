package com.sierisimo.idareyoutobeawesome.dares;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.dares.holders.DareBasicoViewHolder;
import com.sierisimo.idareyoutobeawesome.listeners.DareListener;

/**
 * Created by Baltazar Rodriguez on 23/01/2017.
 */

public class RecyclerDareAdapter extends RecyclerView.Adapter<DareBasicoViewHolder> {
    private String[] list;
    private DareListener listener;

    public RecyclerDareAdapter(String[] list) {
        this.list = list;
    }

    public void setListener(DareListener listener) {
        this.listener = listener;
    }

    @Override
    public DareBasicoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new DareBasicoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DareBasicoViewHolder holder, int position) {
        holder.setText(list[position]);
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDarePressed();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }
}
