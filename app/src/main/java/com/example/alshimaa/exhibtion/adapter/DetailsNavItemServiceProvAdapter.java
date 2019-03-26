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
import com.example.alshimaa.exhibtion.model.DetailsNavItemServiceProvData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.view.DetailsPreviousExhibtion;

import java.util.List;

public class DetailsNavItemServiceProvAdapter extends RecyclerView.Adapter<DetailsNavItemServiceProvAdapter.ViewHolder> {
    Context context;
    List<DetailsNavItemServiceProvData> detailsNavItemServiceProvDataList;

    //DetailsPreviousExhibtion detailsPreviousExhibtion;

    public DetailsNavItemServiceProvAdapter(Context context, List<DetailsNavItemServiceProvData> detailsNavItemServiceProvDataList) {
        this.context = context;
        this.detailsNavItemServiceProvDataList = detailsNavItemServiceProvDataList;
    }

    /* public void onClick(DetailsPreviousExhibtion detailsPreviousExhibtion)
        {
            this.detailsPreviousExhibtion=detailsPreviousExhibtion;
        }*/
    @Override
    public DetailsNavItemServiceProvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_details_nav_item_service_provider,parent,false);
        return new DetailsNavItemServiceProvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsNavItemServiceProvAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +detailsNavItemServiceProvDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(detailsNavItemServiceProvDataList.get( position ).getTitle());
        holder.describtion.setText(detailsNavItemServiceProvDataList.get( position ).getDescription());
      /*  holder.endDate.setText(previousExhibtionDataList.get( position ).getEndDate());

        holder.address.setText(previousExhibtionDataList.get( position ).getAddress());*/
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.describtion.setTypeface( customFontRegular );
        /*holder.endDate.setTypeface(customFontRegular);*/

      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreviousExhibtionData previousExhibtionData=new PreviousExhibtionData();
                previousExhibtionData.setYoutube(previousExhibtionDataList.get(position).getYoutube());
                previousExhibtionData.setTitle(previousExhibtionDataList.get(position).getTitle());
                previousExhibtionData.setDescription(previousExhibtionDataList.get(position).getDescription());
                previousExhibtionData.setAddress(previousExhibtionDataList.get(position).getAddress());
                previousExhibtionData.setId(previousExhibtionDataList.get(position).getId());
                previousExhibtionData.setIdUser(previousExhibtionDataList.get(position).getIdUser());
                previousExhibtionData.setLogo(previousExhibtionDataList.get(position).getLogo());
                detailsPreviousExhibtion.showExhibtionDetails(previousExhibtionData);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return detailsNavItemServiceProvDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView describtion;
       /* private TextView endDate;

        private ImageView videoYoutube;
        private TextView address;*/
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.details_nav_item_service_prov_img);
            title=itemView.findViewById(R.id.details_nav_item_service_prov_title);
            describtion=itemView.findViewById(R.id.details_nav_item_service_prov_desc);
           /* endDate=itemView.findViewById(R.id.row_prev_exhibtion_end_date);
            videoYoutube=itemView.findViewById(R.id.row_prev_exhibtion_img_video);
            address=itemView.findViewById(R.id.row_prev_exhibtion_address);*/
        }
    }
}
