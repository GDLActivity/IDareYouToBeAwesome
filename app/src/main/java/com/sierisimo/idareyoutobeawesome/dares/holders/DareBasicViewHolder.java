package com.sierisimo.idareyoutobeawesome.dares.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.data.Dare;
import com.sierisimo.idareyoutobeawesome.listeners.DareListener;

/**
 * Created by sierisimo on 1/31/17.
 */
public class DareBasicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView textView;
    private OnDareHolderClick listener; // FIXME: 2/6/17 KILL ME

    private Dare dare;

    public DareBasicViewHolder(View itemView) {
        super(itemView);

        itemView.findViewById(R.id.card_view).setOnClickListener(this);

        textView = (TextView) itemView.findViewById(R.id.tvChallenge);
    }

    public void setDare(Dare dare){
        this.dare = dare;
        setText(dare.getTitle());
    }

    public void setOnDareHolderClickListener(OnDareHolderClick listener) {
        this.listener = listener;
    }

    public void setText(String text) {
        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.card_view && listener != null) {
            listener.onDareViewClick(dare);
        }
    }

    // FIXME: 2/6/17 LISTENER MUST DIE!
    public interface OnDareHolderClick {
        void onDareViewClick(Dare dare);
    }
}