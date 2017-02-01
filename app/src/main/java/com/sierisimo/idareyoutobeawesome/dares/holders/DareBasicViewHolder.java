package com.sierisimo.idareyoutobeawesome.dares.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.listeners.DareListener;

/**
 * Created by sierisimo on 1/31/17.
 */

public class DareBasicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView textView;
    private DareListener listener;

    public DareBasicViewHolder(View itemView) {
        super(itemView);

        CardView cardView = (CardView) itemView.findViewById(R.id.card_view);
        cardView.setOnClickListener(this);

        textView = (TextView) itemView.findViewById(R.id.tvChallenge);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void setDareListener(DareListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.card_view) {
            if (listener != null) listener.onDarePressed();
        }
    }
}