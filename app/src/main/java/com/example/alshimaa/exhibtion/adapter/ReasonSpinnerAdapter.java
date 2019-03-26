package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class ReasonSpinnerAdapter extends ArrayAdapter<String> {

    public ReasonSpinnerAdapter(@NonNull Context context, int resource) {
        super( context, resource );
    }

    @Override
    public int getCount() {
        int count = super.getCount();

        return count>0 ? count-1 : count ;

    }
}
