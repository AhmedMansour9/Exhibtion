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
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderData;
import com.example.alshimaa.exhibtion.view.OnClickNavItemServiceProvView;
import com.example.alshimaa.exhibtion.view.OnclickIconHomeUnderConstructView;

import java.util.List;

public class NavItemServiceProvAdapter extends RecyclerView.Adapter<NavItemServiceProvAdapter.ViewHolder> {
    Context context;
    List<NavItemServiceProviderData> navItemServiceProviderDataList;
    OnClickNavItemServiceProvView onClickNavItemServiceProvView;


    public NavItemServiceProvAdapter(Context context, List<NavItemServiceProviderData> navItemServiceProviderDataList) {
        this.context = context;
        this.navItemServiceProviderDataList = navItemServiceProviderDataList;
    }

    public  void onClick(OnClickNavItemServiceProvView onClickNavItemServiceProvView)
        {
            this.onClickNavItemServiceProvView=onClickNavItemServiceProvView;
        }
    @Override
    public NavItemServiceProvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_nav_item_service_provider,parent,false);
        return new NavItemServiceProvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavItemServiceProvAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +navItemServiceProviderDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(navItemServiceProviderDataList.get( position ).getTitle());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNavItemServiceProvView.showOnClickNavItemServiceProvData(navItemServiceProviderDataList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return navItemServiceProviderDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
       // ImageView iconRegister;

        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_nav_item_service_prov_img);
            title=itemView.findViewById(R.id.row_nav_item_service_prov_title);
           // iconRegister=itemView.findViewById(R.id.row_home_exhib_icon_register);

        }
    }
}
