package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.JopsAdapter;
import com.example.alshimaa.exhibtion.adapter.PreviousExhibtionAdapter;
import com.example.alshimaa.exhibtion.model.JopsData;
import com.example.alshimaa.exhibtion.presenter.JopsPresenter;
import com.example.alshimaa.exhibtion.presenter.PreviousExhibtionPresenter;
import com.example.alshimaa.exhibtion.view.JopsView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JopsFragment extends Fragment implements JopsView {
    NetworkConnection networkConnection;



    RecyclerView recyclerViewJops;
    JopsAdapter jopsAdapter;
    JopsPresenter jopsPresenter;

    public JopsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_jops, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        Jops();
       // Toast.makeText(getContext(), "id_user" +DetailsExhibtorsFragment.ID+"  fair"+DetailsExhibtionFragment.ID, Toast.LENGTH_SHORT).show();
        return view;
    }

    private void Jops() {
        jopsPresenter=new JopsPresenter(getContext(),this);
        if(networkConnection.isNetworkAvailable(getContext()))
        {
            if (Language.isRTL())
            {
                jopsPresenter.getJopsResult( "ar",DetailsExhibtionFragment.ID,DetailsExhibtorsFragment.ID ); // user id ,fair id
            }else
            {
                jopsPresenter.getJopsResult("en",DetailsExhibtionFragment.ID,DetailsExhibtorsFragment.ID);
            }
        }else
        {
            Toast.makeText(getContext(), "Check Network Connection!", Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {
        recyclerViewJops=view.findViewById(R.id.jops_recycler);
    }

    @Override
    public void showJopsList(List<JopsData> jopsDataList) {
        jopsAdapter=new JopsAdapter( getContext(),jopsDataList );
        //homeProductAdapter.onClick(this);
        recyclerViewJops.setLayoutManager( new LinearLayoutManager(getContext()));
        recyclerViewJops.setAdapter( jopsAdapter );
    }

    @Override
    public void showError() {

    }
}
