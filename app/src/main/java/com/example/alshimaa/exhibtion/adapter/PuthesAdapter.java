package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.Checkbox_Id;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.model.PuthesData;
import com.example.alshimaa.exhibtion.view.DetailsPreviousExhibtion;
import com.example.alshimaa.exhibtion.view.OnClickMultipleChoiceCheckBox;
import com.example.alshimaa.exhibtion.view.PuthesView;

import java.util.ArrayList;
import java.util.List;

public class PuthesAdapter extends RecyclerView.Adapter<PuthesAdapter.ViewHolder> {
    Context context;
    List<PuthesData> puthesDataList;
    public static List<Checkbox_Id> IdList=new ArrayList<>();
   OnClickMultipleChoiceCheckBox onClickMultipleChoiceCheckBox;

    public PuthesAdapter(Context context, List<PuthesData> puthesDataList) {
        this.context = context;
        this.puthesDataList = puthesDataList;
    }

   public void onClick(OnClickMultipleChoiceCheckBox onClickMultipleChoiceCheckBox)
    {
        this.onClickMultipleChoiceCheckBox=onClickMultipleChoiceCheckBox;
    }
    @Override
    public PuthesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_pollutant,parent,false);
        return new PuthesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PuthesAdapter.ViewHolder holder, final int position) {

        holder.number.setText(" بوثة "+puthesDataList.get( position ).getNumber());
        holder.area.setText(puthesDataList.get( position ).getWidth()+" * "+puthesDataList.get(position).getHeight());
        holder.price.setText(" ريال "+puthesDataList.get( position ).getPrice());


        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.number.setTypeface( customFontRegular );
        holder.area.setTypeface( customFontRegular );
        holder.price.setTypeface(customFontRegular);

     holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
          if(isChecked){
              PuthesData puthesData=new PuthesData();
              puthesData.setIdPartion(puthesDataList.get(position).getIdPartion());
              if(IdList.isEmpty()) {
                  Checkbox_Id checkbox_id=new Checkbox_Id();
                  checkbox_id.setId(puthesDataList.get(position).getIdPartion());
                  IdList.add(checkbox_id);
              }else {
                  int poistion=puthesDataList.get(position).getIdPartion();
                  for (int i=0;i<IdList.size();i++){
                      if (IdList.get(i).getId()==poistion){
                          IdList.remove(i).getId();
                      }
                  }
                  Checkbox_Id checkbox_id=new Checkbox_Id();
                  checkbox_id.setId(puthesDataList.get(position).getIdPartion());
                  IdList.add(checkbox_id);


              }
          }else {
              int poistion=puthesDataList.get(position).getIdPartion();
              for (int i=0;i<IdList.size();i++){
                  if (IdList.get(i).getId()==poistion){
                      IdList.remove(i).getId();
                  }
              }
          }



//             onClickMultipleChoiceCheckBox.showOnClickMultipleChoiceCheckBoxResult(String.valueOf(puthesData));

         }
     });
    }

    @Override
    public int getItemCount() {
        return puthesDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CheckBox checkBox;
        private TextView number;
        private TextView area;
        private TextView price;

        public ViewHolder(View itemView) {
            super( itemView );
            checkBox=itemView.findViewById(R.id.row_pollutant_checkbox);
            number=itemView.findViewById(R.id.row_pollutant_text_number);
            area=itemView.findViewById(R.id.row_pollutant_text_area);
            price=itemView.findViewById(R.id.row_pollutant_text_price);

        }
    }
}
