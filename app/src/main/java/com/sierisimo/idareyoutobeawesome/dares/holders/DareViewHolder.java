package com.sierisimo.idareyoutobeawesome.dares.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.R;

/**
 * Created by sierisimo on 1/31/17.
 */
public class DareViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public DareViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.tvChallenge);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}