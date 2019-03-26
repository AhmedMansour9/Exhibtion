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
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtorsView;

import java.util.List;

public class ExhibtorsAdapter extends RecyclerView.Adapter<ExhibtorsAdapter.ViewHolder> {
    Context context;
    List<ExhibtorsData> exhibtorsDataList;

    DetailsExhibtorsView detailsExhibtorsView;


    public ExhibtorsAdapter(Context context, List<ExhibtorsData> exhibtorsDataList) {
        this.context = context;
        this.exhibtorsDataList = exhibtorsDataList;
    }

     public  void onClick(DetailsExhibtorsView detailsExhibtorsView)
    {
        this.detailsExhibtorsView=detailsExhibtorsView;
    }
    @Override
    public ExhibtorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_exhibtors,parent,false);
        return new ExhibtorsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibtorsAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +exhibtorsDataList.get( position ).getImg2() ).into(holder.imageView);
        holder.title.setText(exhibtorsDataList.get( position ).getName());
       // holder.describtion.setText(currentExhibtionDataList.get( position ).getDescription());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.address.setText(exhibtorsDataList.get( position ).getAddress());

        holder.phone.setText(exhibtorsDataList.get( position ).getPhone());
        holder.email.setText(exhibtorsDataList.get( position ).getEmail());
        holder.websiteLink.setText(exhibtorsDataList.get( position ).getWebsiteLink());

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
       // holder.describtion.setTypeface( customFontRegular );

        holder.address.setTypeface( customFontRegular );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExhibtorsData exhibtorsData=new ExhibtorsData();
                exhibtorsData.setYoutubeLink(exhibtorsDataList.get(position).getYoutubeLink());
                exhibtorsData.setName(exhibtorsDataList.get(position).getName());
                exhibtorsData.setAddress(exhibtorsDataList.get(position).getAddress());
                exhibtorsData.setIdExhibitor(exhibtorsDataList.get(position).getIdExhibitor());
                exhibtorsData.setPhone(exhibtorsDataList.get(position).getPhone());
                exhibtorsData.setEmail(exhibtorsDataList.get(position).getEmail());
                exhibtorsData.setWebsiteLink(exhibtorsDataList.get(position).getWebsiteLink());
                detailsExhibtorsView.showDetailsExhibtorsData(exhibtorsData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exhibtorsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        //private TextView describtion;
        private ImageView videoYoutube;
        private TextView address;
        private TextView phone;
        private TextView email;
        private TextView websiteLink;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_exhibtor_img);
            title=itemView.findViewById(R.id.row_exhibtor_title);
            //describtion=itemView.findViewById(R.id.row_cur_exhibtion_desc);

            videoYoutube=itemView.findViewById(R.id.row_exhibtor_img_video);
            address=itemView.findViewById(R.id.row_exhibtor_address);

            phone=itemView.findViewById(R.id.row_exhibtor_phone);
            email=itemView.findViewById(R.id.row_exhibtor_email);
            websiteLink=itemView.findViewById(R.id.row_exhibtor_website_link);
        }
    }
}
