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
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionUnderConstructView;
import com.example.alshimaa.exhibtion.view.OnclickIconHomeUnderConstructView;

import java.util.List;

public class HomeUnderConstructAdapter extends RecyclerView.Adapter<HomeUnderConstructAdapter.ViewHolder> {
    Context context;
    List<HomeUnderConstructData> homeUnderConstructDataList;
     OnclickIconHomeUnderConstructView onclickIconHomeUnderConstructView;
     DetailsExhibtionUnderConstructView detailsExhibtionUnderConstructView;
    public HomeUnderConstructAdapter(Context context, List<HomeUnderConstructData> homeUnderConstructDataList) {
        this.context = context;
        this.homeUnderConstructDataList = homeUnderConstructDataList;
    }
public  void onClick(OnclickIconHomeUnderConstructView onclickIconHomeUnderConstructView)
{
    this.onclickIconHomeUnderConstructView=onclickIconHomeUnderConstructView;
}
    public  void onClickItem(DetailsExhibtionUnderConstructView detailsExhibtionUnderConstructView)
    {
        this.detailsExhibtionUnderConstructView=detailsExhibtionUnderConstructView;
    }
    @Override
    public HomeUnderConstructAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_exhibitions_under_construct,parent,false);
        return new HomeUnderConstructAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeUnderConstructAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +homeUnderConstructDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(homeUnderConstructDataList.get( position ).getTitle());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );

        holder.iconRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeUnderConstructData homeUnderConstructData=new HomeUnderConstructData();
                homeUnderConstructData.setId(homeUnderConstructDataList.get(position).getId());
                onclickIconHomeUnderConstructView.showOnclickIconHomeUnderConstructDetails(homeUnderConstructData);

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeUnderConstructData homeUnderConstructData=new HomeUnderConstructData();
                homeUnderConstructData.setYoutube(homeUnderConstructDataList.get(position).getYoutube());
                homeUnderConstructData.setTitle(homeUnderConstructDataList.get(position).getTitle());
                homeUnderConstructData.setDescription(homeUnderConstructDataList.get(position).getDescription());
                homeUnderConstructData.setAddress(homeUnderConstructDataList.get(position).getAddress());
                homeUnderConstructData.setId(homeUnderConstructDataList.get(position).getId());
                homeUnderConstructData.setIdUser(homeUnderConstructDataList.get(position).getIdUser());
               // homeUnderConstructData.setLogo(homeUnderConstructDataList.get(position).getLogo());
                detailsExhibtionUnderConstructView.showDetailsExhibtionUnderConstruct(homeUnderConstructData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeUnderConstructDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        ImageView iconRegister;

        private ImageView videoYoutube;
        private TextView address;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_home_exhib_under_construct_img);
            title=itemView.findViewById(R.id.row_home_exhib_under_construct_title);
            iconRegister=itemView.findViewById(R.id.row_home_exhib_icon_register);

            /*videoYoutube=itemView.findViewById(R.id.row_cur_exhibtion_img_video);
            address=itemView.findViewById(R.id.row_cur_exhibtion_address);*/

        }
    }
}
