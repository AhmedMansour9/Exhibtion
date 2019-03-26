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
import com.example.alshimaa.exhibtion.model.HomeSliderData;

import java.util.List;

public class HomeSliderAdapter extends  RecyclerView.Adapter<HomeSliderAdapter.ViewHolder> {
    Context context;
    List<HomeSliderData> homeSliderDataList;

    public HomeSliderAdapter(Context context, List<HomeSliderData> homeBannerDataList) {
        this.context = context;
        this.homeSliderDataList = homeBannerDataList;
    }

    @Override
    public HomeSliderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_banner,parent,false);
        return new HomeSliderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeSliderAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +homeSliderDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(homeSliderDataList.get( position ).getTitle());
       // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );


        holder.date.setText(homeSliderDataList.get( position ).getDate());
        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.date.setTypeface( customFontRegular );
    }

    @Override
    public int getItemCount() {
        return homeSliderDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView date;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_home_banner_img);
            title=itemView.findViewById(R.id.row_home_banner_title);
            date=itemView.findViewById(R.id.row_home_banner_text_date);
        }
    }
}