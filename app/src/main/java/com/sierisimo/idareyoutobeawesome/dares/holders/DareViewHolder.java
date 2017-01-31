package com.sierisimo.idareyoutobeawesome.dares.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.R;

/**
 * Created by sierisimo on 1/31/17.
 */

public class DareViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView textView;

    public DareViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        textView = (TextView) itemView.findViewById(R.id.tvChallenge);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        cardView.setOnClickListener(listener);
    }
}