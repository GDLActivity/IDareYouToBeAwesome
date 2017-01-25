package com.sierisimo.idareyoutobeawesome.listeners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sierisimo.idareyoutobeawesome.MainActivity;

/**
 * Created by Baltazar Rodriguez on 22/01/2017.
 */

public class DrawerItemClickListener implements ListView.OnItemClickListener{

    Context context;

    public DrawerItemClickListener(Context context){
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItemPosition(i);
    }

    private void selectedItemPosition(int i) {
        switch (i){
            case 0:
                Toast.makeText(context, "Title one", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(context, "Title two", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(context, "Title three", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
