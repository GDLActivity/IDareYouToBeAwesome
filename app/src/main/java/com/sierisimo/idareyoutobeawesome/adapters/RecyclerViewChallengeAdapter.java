package com.sierisimo.idareyoutobeawesome.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.R;

/**
 * Created by Baltazar Rodriguez on 23/01/2017.
 */

public class RecyclerViewChallengeAdapter extends RecyclerView.Adapter<RecyclerViewChallengeAdapter.ViewHolder> {

    private String[] list;

    public RecyclerViewChallengeAdapter (String[] list){
        this.list = list;
    }

    @Override
    public RecyclerViewChallengeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewChallengeAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tvChallenge);
        }
    }
}
