package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.JopsData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;

import java.util.List;

public class JopsAdapter extends RecyclerView.Adapter<JopsAdapter.ViewHolder> {
    Context context;
    List<JopsData> jopsDataList;

    public JopsAdapter(Context context, List<JopsData> jopsDataList) {
        this.context = context;
        this.jopsDataList = jopsDataList;
    }

    @Override
    public JopsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_jops,parent,false);
        return new JopsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JopsAdapter.ViewHolder holder, int position) {

        holder.title.setText(jopsDataList.get( position ).getTitle());
        holder.date.setText(jopsDataList.get( position ).getDate());
        holder.email.setText(jopsDataList.get( position ).getEmail());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.date.setTypeface( customFontRegular );
        holder.email.setTypeface(customFontRegular);
    }

    @Override
    public int getItemCount() {
        return jopsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView date;
        private TextView email;
        public ViewHolder(View itemView) {
            super( itemView );
            title=itemView.findViewById(R.id.row_jops_text_title);
            date=itemView.findViewById(R.id.row_jops_text_date);
            email=itemView.findViewById(R.id.row_jops_text_email);
        }
    }
}
