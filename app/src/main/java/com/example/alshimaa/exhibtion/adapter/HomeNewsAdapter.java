package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;
import com.example.alshimaa.exhibtion.model.NewsData;

import java.util.List;

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.ViewHolder> {
    Context context;
    List<NewsData> newsDataList;

    public HomeNewsAdapter(Context context, List<NewsData> newsDataList) {
        this.context = context;
        this.newsDataList = newsDataList;
    }

    @Override
    public HomeNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_news,parent,false);
        return new HomeNewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewsAdapter.ViewHolder holder, int position) {
       /* Glide.with( context ).load( "http://eelectronicexpo.com"
                +newsDataList.get( position ).getImg() ).into(holder.imageView);*/
        holder.title.setText(newsDataList.get( position ).getTitle());
        holder.describtion.setText(newsDataList.get( position ).getDescription());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.describtion.setTypeface( customFontRegular );



    }

    @Override
    public int getItemCount() {
        return newsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       // private ImageView imageView;
        private TextView title;
        private TextView describtion;
        public ViewHolder(View itemView) {
            super( itemView );
           // imageView=itemView.findViewById( R.id.row_home_service_provider_img);
            title=itemView.findViewById(R.id.row_home_service_provider_title);
            describtion=itemView.findViewById(R.id.row_home_service_provider_desc);
            describtion.setSelected(true);

        }
    }
}

