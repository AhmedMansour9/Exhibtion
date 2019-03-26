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
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.view.DetailsPreviousExhibtion;

import java.util.List;

public class PreviousExhibtionAdapter extends RecyclerView.Adapter<PreviousExhibtionAdapter.ViewHolder> {
    Context context;
    List<PreviousExhibtionData> previousExhibtionDataList;

    DetailsPreviousExhibtion detailsPreviousExhibtion;
    public PreviousExhibtionAdapter(Context context, List<PreviousExhibtionData> previousExhibtionDataList) {
        this.context = context;
        this.previousExhibtionDataList = previousExhibtionDataList;
    }
  public void onClick(DetailsPreviousExhibtion detailsPreviousExhibtion)
  {
      this.detailsPreviousExhibtion=detailsPreviousExhibtion;
  }
    @Override
    public PreviousExhibtionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_previous_exhibtion,parent,false);
        return new PreviousExhibtionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousExhibtionAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +previousExhibtionDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(previousExhibtionDataList.get( position ).getTitle());
        holder.describtion.setText(previousExhibtionDataList.get( position ).getDescription());
        holder.endDate.setText(previousExhibtionDataList.get( position ).getEndDate());

        holder.address.setText(previousExhibtionDataList.get( position ).getAddress());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.describtion.setTypeface( customFontRegular );
        holder.endDate.setTypeface(customFontRegular);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
        });
    }

    @Override
    public int getItemCount() {
        return previousExhibtionDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView describtion;
        private TextView endDate;

        private ImageView videoYoutube;
        private TextView address;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_prev_exhibtion_img);
            title=itemView.findViewById(R.id.row_prev_exhibtion_title);
            describtion=itemView.findViewById(R.id.row_prev_exhibtion_desc);
            endDate=itemView.findViewById(R.id.row_prev_exhibtion_end_date);
            videoYoutube=itemView.findViewById(R.id.row_prev_exhibtion_img_video);
            address=itemView.findViewById(R.id.row_prev_exhibtion_address);
        }
    }
}
